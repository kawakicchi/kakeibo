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

import java.util.Date;

import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboId;
import org.kawakicchi.kakeibo.domain.model.kakeibo.ReceiptId;
import org.kawakicchi.kakeibo.domain.model.shop.ShopAddress;
import org.kawakicchi.kakeibo.domain.model.shop.ShopId;
import org.kawakicchi.kakeibo.domain.model.shop.ShopName;
import org.kawakicchi.kakeibo.domain.model.shop.ShopNameSub;
import org.kawakicchi.kakeibo.domain.model.shop.ShopTel;
import org.kawakicchi.kakeibo.domain.shared.DeleteFlag;
import org.kawakicchi.kakeibo.domain.shared.Memo;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * 「td_receipt」テーブル定義
 * 
 * @author kawakicchi
 */
@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
public final class TdReceipt {

	/** レシートID */
	@Id
	private final ReceiptId receiptId;
	/** 家計簿ID */
	private final KakeiboId kakeiboId;
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

	/** 削除フラグ */
	private final DeleteFlag deleteFlag;

	public TdReceipt(ReceiptId receiptId, KakeiboId kakeiboId, Date date, ShopName shopName, ShopNameSub shopNameSub, ShopTel shopTel, ShopAddress shopAddress,
			ShopId shopId, Memo memo, DeleteFlag deleteFlag) {
		super();
		this.receiptId = receiptId;
		this.kakeiboId = kakeiboId;
		this.date = date;
		this.shopName = shopName;
		this.shopNameSub = shopNameSub;
		this.shopTel = shopTel;
		this.shopAddress = shopAddress;
		this.shopId = shopId;
		this.memo = memo;
		this.deleteFlag = deleteFlag;
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
	 * 家計簿ID を取得する。
	 * 
	 * @return 家計簿ID
	 */
	public KakeiboId getKakeiboId() {
		return kakeiboId;
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

	/**
	 * 削除フラグ を取得する。
	 * 
	 * @return 削除フラグ
	 */
	public DeleteFlag getDeleteFlag() {
		return deleteFlag;
	}

}
