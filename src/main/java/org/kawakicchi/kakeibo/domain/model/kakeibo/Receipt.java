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
import java.util.Date;
import java.util.List;

import org.kawakicchi.kakeibo.domain.model.account.Account;
import org.kawakicchi.kakeibo.domain.model.shop.ShopAddress;
import org.kawakicchi.kakeibo.domain.model.shop.ShopId;
import org.kawakicchi.kakeibo.domain.model.shop.ShopName;
import org.kawakicchi.kakeibo.domain.model.shop.ShopNameSub;
import org.kawakicchi.kakeibo.domain.model.shop.ShopTel;
import org.kawakicchi.kakeibo.domain.shared.Memo;

/**
 * レシート
 * 
 * @author kawakicchi
 */
public class Receipt implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -2704524967339808831L;

	/** レシートID */
	private final ReceiptId receiptId;
	/** 日付 */
	private final Date date;
	/** 店名 */
	private final ShopName shopName;
	/** 店名サブ */
	private final ShopNameSub shopNameSub;
	/** TEL */
	private final ShopTel shopTel;
	/** 住所 */
	private final ShopAddress shopAddress;
	/** お店ID */
	private final ShopId shopId;
	/** メモ */
	private final Memo memo;

	/**
	 * コンストラクタ
	 * 
	 * @param receiptId レシートID
	 * @param date 日付
	 * @param shopName 店名
	 * @param shopNameSub 店名サブ
	 * @param shopTel TEL
	 * @param shopAddress 住所
	 * @param shopId お店ID
	 * @param memo メモ
	 */
	public Receipt(ReceiptId receiptId, Date date, ShopName shopName, ShopNameSub shopNameSub, ShopTel shopTel, ShopAddress shopAddress, ShopId shopId,
			Memo memo) {
		super();
		this.receiptId = receiptId;
		this.date = date;
		this.shopName = shopName;
		this.shopNameSub = shopNameSub;
		this.shopTel = shopTel;
		this.shopAddress = shopAddress;
		this.shopId = shopId;
		this.memo = memo;
	}

	/**
	 * レシートID を取得する。
	 * 
	 * @return レシートID
	 */
	public ReceiptId getReceiptId() {
		return receiptId;
	}

	/**
	 * 日付 を取得する。
	 * 
	 * @return 日付
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 店名 を取得する。
	 * 
	 * @return 店名
	 */
	public ShopName getShopName() {
		return shopName;
	}

	/**
	 * 店名サブ を取得する。
	 * 
	 * @return 店名サブ
	 */
	public ShopNameSub getShopNameSub() {
		return shopNameSub;
	}

	/**
	 * TEL を取得する。
	 * 
	 * @return TEL
	 */
	public ShopTel getShopTel() {
		return shopTel;
	}

	/**
	 * 住所 を取得する。
	 * 
	 * @return 住所
	 */
	public ShopAddress getShopAddress() {
		return shopAddress;
	}

	/**
	 * お店ID を取得する。
	 * 
	 * @return お店ID
	 */
	public ShopId getShopId() {
		return shopId;
	}

	/**
	 * メモ を取得する。
	 * 
	 * @return メモ
	 */
	public Memo getMemo() {
		return memo;
	}

	public static class Builder {
		/** レシートID */
		private ReceiptId receiptId;
		/** 日付 */
		private Date date;
		/** 店名 */
		private ShopName shopName;
		/** 店名サブ */
		private ShopNameSub shopNameSub;
		/** TEL */
		private ShopTel shopTel;
		/** 住所 */
		private ShopAddress shopAddress;
		/** お店ID */
		private ShopId shopId;
		/** メモ */
		private Memo memo;

		private Builder() {

		}

		private Builder(Receipt receipt) {
			receiptId = receipt.receiptId;
			date = receipt.date;
			shopName = receipt.shopName;
			shopNameSub = receipt.shopNameSub;
			shopTel = receipt.shopTel;
			shopAddress = receipt.shopAddress;
			shopId = receipt.shopId;
			memo = receipt.memo;
		}

		public static Builder newInstance() {
			return new Builder();
		}

		public static Builder newInstance(Receipt receipt) {
			return new Builder(receipt);
		}

		public Receipt build() {
			return new Receipt(receiptId, date, shopName, shopNameSub, shopTel, shopAddress, shopId, memo);
		}

		public Builder withReceiptId(final ReceiptId receiptId) {
			this.receiptId = receiptId;
			return this;
		}

		public Builder withDate(final Date date) {
			this.date = date;
			return this;
		}

		public Builder withShopName(final ShopName shopName, final ShopNameSub shopNameSub) {
			this.shopName = shopName;
			this.shopNameSub = shopNameSub;
			return this;
		}

		public Builder withShopTel(final ShopTel shopTel) {
			this.shopTel = shopTel;
			return this;
		}

		public Builder withShopAddress(final ShopAddress shopAddress) {
			this.shopAddress = shopAddress;
			return this;
		}

		public Builder withShopId(final ShopId shopId) {
			this.shopId = shopId;
			return this;
		}

		public Builder withMemo(final Memo memo) {
			this.memo = memo;
			return this;
		}
	}

	/**
	 * 商品を登録する。
	 * 
	 * @param item 商品
	 * @param rep リポジトリ
	 * @return 商品
	 */
	public ReceiptItem addReceiptItem(final ReceiptItem item, final Account account, final KakeiboRepository rep) {

		final ReceiptItem result = rep.store(item, this, account);

		return result;
	}

	/**
	 * 商品の一覧を取得する。
	 * 
	 * @param rep リポジトリ
	 * @return 商品一覧
	 */
	public List<ReceiptItem> getReceiptItemList(final KakeiboRepository rep) {
		final List<ReceiptItem> result = rep.findReceiptItemListByReceipt(this);

		return result;
	}
}
