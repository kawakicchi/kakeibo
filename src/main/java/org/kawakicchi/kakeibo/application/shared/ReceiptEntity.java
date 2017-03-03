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
package org.kawakicchi.kakeibo.application.shared;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.kawakicchi.kakeibo.domain.model.kakeibo.Receipt;
import org.kawakicchi.kakeibo.domain.model.kakeibo.ReceiptId;
import org.kawakicchi.kakeibo.domain.model.shop.ShopAddress;
import org.kawakicchi.kakeibo.domain.model.shop.ShopId;
import org.kawakicchi.kakeibo.domain.model.shop.ShopName;
import org.kawakicchi.kakeibo.domain.model.shop.ShopNameSub;
import org.kawakicchi.kakeibo.domain.model.shop.ShopTel;
import org.kawakicchi.kakeibo.domain.shared.Memo;

/**
 * レシート情報
 * 
 * @author kawakicchi
 */
public class ReceiptEntity {

	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	/** レシートID */
	private String receiptId;
	private String date;
	private String shopName;
	private String shopNameSub;
	private String shopTel;
	private String shopAddress;
	private String shopId;
	private String memo;

	/** 商品情報一覧 */
	private List<ReceiptItemEntity> items;

	public ReceiptEntity() {
		items = new ArrayList<ReceiptItemEntity>();
	}

	public static ReceiptEntity valueOf(Receipt receipt) {
		ReceiptEntity entity = null;
		if (null != receipt) {
			entity = new ReceiptEntity();
			entity.receiptId = ReceiptId.getValue(receipt.getReceiptId());

			if (null != receipt.getDate()) {
				entity.date = FORMAT.format(receipt.getDate());
			}

			entity.shopName = ShopName.getValue(receipt.getShopName());
			entity.shopNameSub = ShopNameSub.getValue(receipt.getShopNameSub());
			entity.shopTel = ShopTel.getValue(receipt.getShopTel());
			entity.shopAddress = ShopAddress.getValue(receipt.getShopAddress());
			entity.shopId = ShopId.getValue(receipt.getShopId());
			entity.memo = Memo.getValue(receipt.getMemo());
		}
		return entity;
	}

	/**
	 * レシートID を取得する。
	 * 
	 * @return レシートID
	 */
	public String getReceiptId() {
		return receiptId;
	}

	/**
	 * レシートID を設定する。
	 * 
	 * @param receiptId レシートID
	 */
	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	/**
	 * date を取得する。
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * date を設定する。
	 * 
	 * @param date date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * shopName を取得する。
	 * 
	 * @return shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * shopName を設定する。
	 * 
	 * @param shopName shopName
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * shopNameSub を取得する。
	 * 
	 * @return shopNameSub
	 */
	public String getShopNameSub() {
		return shopNameSub;
	}

	/**
	 * shopNameSub を設定する。
	 * 
	 * @param shopNameSub shopNameSub
	 */
	public void setShopNameSub(String shopNameSub) {
		this.shopNameSub = shopNameSub;
	}

	/**
	 * shopTel を取得する。
	 * 
	 * @return shopTel
	 */
	public String getShopTel() {
		return shopTel;
	}

	/**
	 * shopTel を設定する。
	 * 
	 * @param shopTel shopTel
	 */
	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}

	/**
	 * shopAddress を取得する。
	 * 
	 * @return shopAddress
	 */
	public String getShopAddress() {
		return shopAddress;
	}

	/**
	 * shopAddress を設定する。
	 * 
	 * @param shopAddress shopAddress
	 */
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	/**
	 * shopId を取得する。
	 * 
	 * @return shopId
	 */
	public String getShopId() {
		return shopId;
	}

	/**
	 * shopId を設定する。
	 * 
	 * @param shopId shopId
	 */
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	/**
	 * memo を取得する。
	 * 
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * memo を設定する。
	 * 
	 * @param memo memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * 商品情報一覧 を取得する。
	 * 
	 * @return 商品情報一覧
	 */
	public List<ReceiptItemEntity> getItems() {
		return items;
	}

	/**
	 * 商品情報 を追加する。
	 * 
	 * @param item 商品情報
	 */
	public void addItem(ReceiptItemEntity item) {
		items.add(item);
	}
}
