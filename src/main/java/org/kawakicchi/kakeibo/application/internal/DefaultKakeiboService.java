/**
 * Copyright 2017 Azuki Framework.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kawakicchi.kakeibo.application.internal;

import java.util.ArrayList;
import java.util.List;

import org.kawakicchi.kakeibo.application.KakeiboService;
import org.kawakicchi.kakeibo.application.shared.AccountEntity;
import org.kawakicchi.kakeibo.application.shared.CreateKakeiboEntity;
import org.kawakicchi.kakeibo.application.shared.KakeiboEntity;
import org.kawakicchi.kakeibo.application.shared.ReceiptEntity;
import org.kawakicchi.kakeibo.application.shared.ReceiptItemEntity;
import org.kawakicchi.kakeibo.application.shared.RegistReceiptEntity;
import org.kawakicchi.kakeibo.application.shared.RegistReceiptItemEntity;
import org.kawakicchi.kakeibo.domain.model.account.Account;
import org.kawakicchi.kakeibo.domain.model.account.AccountRepository;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Kakeibo;
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboId;
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboMemo;
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboRepository;
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboTitle;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Month;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Receipt;
import org.kawakicchi.kakeibo.domain.model.kakeibo.ReceiptItem;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Year;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * このインターフェースは、家計簿関連の機能を実装するサービスインターフェースです。
 * 
 * @author kawakicchi
 */
@Service
public class DefaultKakeiboService implements KakeiboService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private KakeiboRepository kakeiboRepository;

	@Override
	@Transactional
	public KakeiboEntity create(final CreateKakeiboEntity kakeiboEntity, final AccountEntity accountEntity) {
		final Account account = AccountEntity.toAccount(accountEntity);

		final Kakeibo.Builder builder = Kakeibo.Builder.newInstance();
		builder.withTitleAndMemo(KakeiboTitle.of(kakeiboEntity.getTitle()), KakeiboMemo.of(kakeiboEntity.getMemo()));

		final Kakeibo kakeibo = Kakeibo.create(builder.build(), account, kakeiboRepository, accountRepository);

		return KakeiboEntity.valueOf(kakeibo);
	}

	@Override
	public KakeiboEntity get(final String kakeiboId, final AccountEntity accountEntity) {
		final Account account = AccountEntity.toAccount(accountEntity);
		final Kakeibo kakeibo = Kakeibo.get(KakeiboId.of(kakeiboId), account, kakeiboRepository);

		final KakeiboEntity result = KakeiboEntity.valueOf(kakeibo);

		final List<Receipt> receiptList = kakeibo.getReceiptList(kakeiboRepository);
		receiptList.forEach(receipt -> {

			final ReceiptEntity r = ReceiptEntity.valueOf(receipt);
			result.addReceipt(r);

			final List<ReceiptItem> itemList = receipt.getReceiptItemList(kakeiboRepository);
			itemList.forEach(item -> {

				final ReceiptItemEntity i = ReceiptItemEntity.valueOf(item);
				r.addItem(i);
			});
		});

		return result;
	}

	@Override
	@Transactional
	public ReceiptEntity registReceipt(final String kakeiboId, final RegistReceiptEntity receipt, final AccountEntity accountEntity) {
		final Account account = AccountEntity.toAccount(accountEntity);

		final Kakeibo kakeibo = Kakeibo.get(KakeiboId.of(kakeiboId), account, kakeiboRepository);

		final Receipt r = kakeibo.addReceipt(receipt.toReceipt(), account, kakeiboRepository);

		final ReceiptEntity result = ReceiptEntity.valueOf(r);

		final List<RegistReceiptItemEntity> itemList = receipt.getItems();
		itemList.forEach(item -> {

			final ReceiptItem i = r.addReceiptItem(item.toReceiptItem(), account, kakeiboRepository);
			result.addItem(ReceiptItemEntity.valueOf(i));
		});

		return result;
	}

	@Override
	public List<ReceiptEntity> getReceipts(final String kakeiboId, final Integer year, final Integer month, final AccountEntity accountEntity) {
		final Account account = AccountEntity.toAccount(accountEntity);
		final Kakeibo kakeibo = Kakeibo.get(KakeiboId.of(kakeiboId), account, kakeiboRepository);

		final List<ReceiptEntity> result = new ArrayList<ReceiptEntity>();

		final List<Receipt> receiptList = kakeibo.getReceiptListByMonthly(Year.of(year), Month.of(month), kakeiboRepository);
		receiptList.forEach(receipt -> {

			final ReceiptEntity r = ReceiptEntity.valueOf(receipt);
			result.add(r);

			final List<ReceiptItem> itemList = receipt.getReceiptItemList(kakeiboRepository);
			itemList.forEach(item -> {

				final ReceiptItemEntity i = ReceiptItemEntity.valueOf(item);
				r.addItem(i);
			});
		});

		return result;
	}
}
