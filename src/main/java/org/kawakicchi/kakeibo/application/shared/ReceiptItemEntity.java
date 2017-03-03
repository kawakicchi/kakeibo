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

import org.kawakicchi.kakeibo.domain.model.item.ItemId;
import org.kawakicchi.kakeibo.domain.model.item.ItemName;
import org.kawakicchi.kakeibo.domain.model.item.ItemPrice;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Quantity;
import org.kawakicchi.kakeibo.domain.model.kakeibo.ReceiptItem;
import org.kawakicchi.kakeibo.domain.model.kakeibo.ReceiptItemNo;
import org.kawakicchi.kakeibo.domain.shared.Memo;

/**
 * 商品情報
 * 
 * @author kawakicchi
 */
public class ReceiptItemEntity {

	/** レシート商品番号 */
	private Integer no;
	/** 商品名 */
	private String name;
	/** 商品価格 */
	private Double price;
	/** 数量 */
	private Integer quantity;
	/** 商品ID */
	private String itemId;
	/** メモ */
	private String memo;

	public ReceiptItemEntity() {
	}

	public static ReceiptItemEntity valueOf(ReceiptItem item) {
		ReceiptItemEntity entity = null;
		if (null != item) {
			entity = new ReceiptItemEntity();
			entity.no = ReceiptItemNo.getValue(item.getNo());
			entity.name = ItemName.getValue(item.getName());
			entity.price = ItemPrice.getValue(item.getPrice());
			entity.quantity = Quantity.getValue(item.getQuantity());
			entity.itemId = ItemId.getValue(item.getItemId());
			entity.memo = Memo.getValue(item.getMemo());
		}
		return entity;
	}

	/**
	 * レシート商品番号 を取得する。
	 * 
	 * @return レシート商品番号
	 */
	public Integer getNo() {
		return no;
	}

	/**
	 * レシート商品番号 を設定する。
	 * 
	 * @param no レシート商品番号
	 */
	public void setNo(Integer no) {
		this.no = no;
	}

	/**
	 * 商品名 を取得する。
	 * 
	 * @return 商品名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 商品名 を設定する。
	 * 
	 * @param name 商品名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 商品価格 を取得する。
	 * 
	 * @return 商品価格
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * 商品価格 を設定する。
	 * 
	 * @param price 商品価格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 数量 を取得する。
	 * 
	 * @return 数量
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 数量 を設定する。
	 * 
	 * @param quantity 数量
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 商品ID を取得する。
	 * 
	 * @return 商品ID
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * 商品ID を設定する。
	 * 
	 * @param itemId 商品ID
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * メモ を取得する。
	 * 
	 * @return メモ
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * メモ を設定する。
	 * 
	 * @param memo メモ
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

}
