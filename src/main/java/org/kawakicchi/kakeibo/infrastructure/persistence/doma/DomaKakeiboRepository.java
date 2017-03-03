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
package org.kawakicchi.kakeibo.infrastructure.persistence.doma;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.kawakicchi.kakeibo.application.util.KakeiboUtil;
import org.kawakicchi.kakeibo.domain.model.account.Account;
import org.kawakicchi.kakeibo.domain.model.account.Group;
import org.kawakicchi.kakeibo.domain.model.account.GroupId;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Kakeibo;
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboId;
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboRepository;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Month;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Receipt;
import org.kawakicchi.kakeibo.domain.model.kakeibo.ReceiptId;
import org.kawakicchi.kakeibo.domain.model.kakeibo.ReceiptItem;
import org.kawakicchi.kakeibo.domain.model.kakeibo.ReceiptItemNo;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Year;
import org.kawakicchi.kakeibo.domain.shared.DeleteFlag;
import org.seasar.doma.jdbc.Result;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DomaKakeiboRepository implements KakeiboRepository {

	@Autowired
	private KakeiboDao kakeiboDao;
	@Autowired
	private ReceiptDao receiptDao;
	@Autowired
	private ReceiptItemDao receiptItemDao;

	@Override
	public Kakeibo store(final Kakeibo kakeibo, final Group group, final Account account) {
		final TdKakeibo record = toTdKakeibo(kakeibo, group, account);

		final Result<TdKakeibo> result = kakeiboDao.insert(record);

		return toKakeibo(result.getEntity());
	}

	@Override
	public Receipt store(final Receipt receipt, final Kakeibo kakeibo, final Account account) {
		final TdReceipt record = toTdReceipt(receipt, kakeibo, account);

		final Result<TdReceipt> result = receiptDao.insert(record);

		return toReceipt(result.getEntity());
	}

	@Override
	public ReceiptItem store(final ReceiptItem item, final Receipt receipt, final Account account) {
		final SelectOptions options = SelectOptions.get().forUpdate();

		final ReceiptId receiptId = receipt.getReceiptId();
		receiptItemDao.findByReceiptId(receiptId, options, mapper -> {
			return 0;
		});

		final Integer maxNo = receiptItemDao.maxNoByReceiptId(receiptId);
		Integer newNo = 1;
		if (null != maxNo) {
			newNo = maxNo + 1;
		}

		final TdReceiptItem record = toTdReceiptItem(ReceiptItemNo.of(newNo), item, receipt, account);
		final Result<TdReceiptItem> result = receiptItemDao.insert(record);

		return toReceiptItem(result.getEntity());
	}

	@Override
	public Kakeibo findKakeiboByKakeiboId(final KakeiboId kakeiboId, final Account account) {

		final TdKakeibo record = kakeiboDao.findByKakeiboIdAndAccountId(kakeiboId, account.getAccountId());

		return toKakeibo(record);
	}

	@Override
	public List<Receipt> findReceiptListByKakeibo(final Kakeibo kakeibo) {
		final List<Receipt> result = new ArrayList<Receipt>();

		receiptDao.findByKakeiboId(kakeibo.getKakeiboId(), null, null, stream -> {
			stream.forEach(record -> {
				result.add(toReceipt(record));
			});
			return result.size();
		});

		return result;
	}

	@Override
	public List<Receipt> findReceiptListByKakeiboAndYearMonth(final Kakeibo kakeibo, final Year year, final Month month) {
		final List<Receipt> result = new ArrayList<Receipt>();

		final Date fromDate = KakeiboUtil.getDate(year.getValue(), month.getValue());
		final Date toDate = KakeiboUtil.getNextMonth(fromDate);

		receiptDao.findByKakeiboId(kakeibo.getKakeiboId(), fromDate, toDate, stream -> {
			stream.forEach(record -> {
				result.add(toReceipt(record));
			});
			return result.size();
		});

		return result;
	}

	@Override
	public List<ReceiptItem> findReceiptItemListByReceipt(final Receipt receipt) {
		final List<ReceiptItem> result = new ArrayList<ReceiptItem>();

		final SelectOptions options = SelectOptions.get();

		receiptItemDao.findByReceiptId(receipt.getReceiptId(), options, stream -> {
			stream.forEach(record -> {
				result.add(toReceiptItem(record));
			});
			return result.size();
		});

		return result;
	}

	private TdKakeibo toTdKakeibo(final Kakeibo kakeibo, final Group group, final Account account) {
		final GroupId groupId = (null != group) ? group.getGroupId() : null;

		final TdKakeibo record = new TdKakeibo(kakeibo.getKakeiboId(), kakeibo.getTitle(), kakeibo.getMemo(), groupId, account.getAccountId(), DeleteFlag.False);

		return record;
	}

	private Kakeibo toKakeibo(final TdKakeibo record) {
		if (null == record) {
			return null;
		}

		final Kakeibo.Builder builder = Kakeibo.Builder.newInstance();
		builder.withKakeiboId(record.getKakeiboId());
		builder.withTitleAndMemo(record.getTitle(), record.getMemo());
		return builder.build();
	}

	private TdReceipt toTdReceipt(final Receipt receipt, final Kakeibo kakeibo, final Account account) {

		final TdReceipt record = new TdReceipt(receipt.getReceiptId(), kakeibo.getKakeiboId(), receipt.getDate(), receipt.getShopName(),
				receipt.getShopNameSub(), receipt.getShopTel(), receipt.getShopAddress(), receipt.getShopId(), receipt.getMemo(), DeleteFlag.False);

		return record;
	}

	private Receipt toReceipt(final TdReceipt record) {
		if (null == record) {
			return null;
		}

		final Receipt.Builder builder = Receipt.Builder.newInstance();
		builder.withReceiptId(record.getReceiptId());
		builder.withDate(record.getDate());
		builder.withShopName(record.getShopName(), record.getShopNameSub());
		builder.withShopTel(record.getShopTel());
		builder.withShopAddress(record.getShopAddress());
		builder.withShopId(record.getShopId());
		builder.withMemo(record.getMemo());
		return builder.build();
	}

	private TdReceiptItem toTdReceiptItem(final ReceiptItemNo no, final ReceiptItem item, final Receipt receipt, final Account account) {

		final TdReceiptItem record = new TdReceiptItem(receipt.getReceiptId(), no, item.getName(), item.getPrice(), item.getQuantity(), item.getItemId(),
				item.getMemo(), DeleteFlag.False);

		return record;
	}

	private ReceiptItem toReceiptItem(final TdReceiptItem record) {
		if (null == record) {
			return null;
		}

		final ReceiptItem.Builder builder = ReceiptItem.Builder.newInstance();
		builder.withNo(record.getNo());
		builder.withItem(record.getName(), record.getPrice(), record.getQuantity());
		builder.withItemId(record.getItemId());
		builder.withMemo(record.getMemo());

		return builder.build();
	}
}
