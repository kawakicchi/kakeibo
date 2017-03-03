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
package org.kawakicchi.kakeibo.domain.model.kakeibo;

import java.io.Serializable;
import java.util.List;

import org.kawakicchi.kakeibo.application.util.KakeiboUtil;
import org.kawakicchi.kakeibo.domain.model.account.Account;
import org.kawakicchi.kakeibo.domain.model.account.AccountRepository;
import org.kawakicchi.kakeibo.domain.model.account.Group;
import org.kawakicchi.kakeibo.domain.model.account.GroupId;
import org.kawakicchi.kakeibo.domain.model.account.GroupName;

/**
 * 家計簿
 * 
 * @author kawakicchi
 */
public class Kakeibo implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -6706443973488437234L;

	/** 家計簿ID */
	private final KakeiboId kakeiboId;
	/** タイトル */
	private final KakeiboTitle title;
	/** メモ */
	private final KakeiboMemo memo;

	/**
	 * コンストラクタ
	 * 
	 * @param kakeiboId 家計簿ID
	 */
	public Kakeibo(final KakeiboId kakeiboId, final KakeiboTitle title, final KakeiboMemo memo) {
		super();
		this.kakeiboId = kakeiboId;
		this.title = title;
		this.memo = memo;
	}

	/**
	 * 家計簿ID を取得する。
	 * 
	 * @return 家計簿ID
	 */
	public KakeiboId getKakeiboId() {
		return kakeiboId;
	}

	/**
	 * tile を取得する。
	 * 
	 * @return tile
	 */
	public KakeiboTitle getTitle() {
		return title;
	}

	/**
	 * memo を取得する。
	 * 
	 * @return memo
	 */
	public KakeiboMemo getMemo() {
		return memo;
	}

	public static class Builder {

		/** 家計簿ID */
		private KakeiboId kakeiboId;
		/** タイトル */
		private KakeiboTitle title;
		/** メモ */
		private KakeiboMemo memo;

		private Builder() {

		}

		private Builder(final Kakeibo kakeibo) {
			kakeiboId = kakeibo.kakeiboId;
			title = kakeibo.title;
			memo = kakeibo.memo;
		}

		public static Builder newInstance() {
			return new Builder();
		}

		public static Builder newInstance(final Kakeibo kakeibo) {
			return new Builder(kakeibo);
		}

		public Kakeibo build() {
			return new Kakeibo(kakeiboId, title, memo);
		}

		public Builder withKakeiboId(final KakeiboId kakeiboId) {
			this.kakeiboId = kakeiboId;
			return this;
		}

		public Builder withTitleAndMemo(final KakeiboTitle title, final KakeiboMemo memo) {
			this.title = title;
			this.memo = memo;
			return this;
		}
	}

	/**
	 * 家計簿を作成する。
	 * 
	 * @param kakeibo 家計簿
	 * @param account アカウント
	 * @param rep リポジトリ
	 * @return 家計簿
	 */
	public static Kakeibo create(final Kakeibo kakeibo, final Account account, final KakeiboRepository kakeiboRepository,
			final AccountRepository accountRepository) {
		final Group.Builder groupBuilder = Group.Builder.newInstance();
		groupBuilder.withGroupId(GroupId.of(KakeiboUtil.generateUUID()));
		groupBuilder.withName(GroupName.of(KakeiboTitle.getValue(kakeibo.getTitle())));

		final Group group = accountRepository.store(groupBuilder.build(), account);

		final Kakeibo.Builder builder = Kakeibo.Builder.newInstance(kakeibo);
		builder.withKakeiboId(KakeiboId.of(KakeiboUtil.generateUUID()));

		final Kakeibo result = kakeiboRepository.store(kakeibo, group, account);
		return result;
	}

	/**
	 * 家計簿を取得する。
	 * 
	 * @param kakeiboId 家計簿ID
	 * @param account アカウント
	 * @param rep リポジトリ
	 * @return 家計簿
	 */
	public static Kakeibo get(final KakeiboId kakeiboId, final Account account, final KakeiboRepository rep) {
		final Kakeibo kakeibo = rep.findKakeiboByKakeiboId(kakeiboId, account);

		return kakeibo;
	}

	/**
	 * レシートを登録する。
	 * 
	 * @param receipt レシート
	 * @param rep リポジトリ
	 * @return レシート
	 */
	public Receipt addReceipt(final Receipt receipt, final Account account, final KakeiboRepository rep) {
		final Receipt.Builder builder = Receipt.Builder.newInstance(receipt);
		builder.withReceiptId(ReceiptId.of(KakeiboUtil.generateUUID()));

		final Receipt result = rep.store(builder.build(), this, account);

		return result;
	}

	/**
	 * レシートの一覧を取得する。
	 * 
	 * @param rep リポジトリ
	 * @return レシート一覧
	 */
	public List<Receipt> getReceiptList(final KakeiboRepository rep) {
		final List<Receipt> result = rep.findReceiptListByKakeibo(this);

		return result;
	}

	/**
	 * 月刊レシートの一覧を取得する。
	 * 
	 * @param year 年
	 * @param month 月
	 * @param rep リポジトリ
	 * @return レシート一覧
	 */
	public List<Receipt> getReceiptListByMonthly(final Year year, final Month month, final KakeiboRepository rep) {
		final List<Receipt> result = rep.findReceiptListByKakeiboAndYearMonth(this, year, month);

		return result;
	}
}
