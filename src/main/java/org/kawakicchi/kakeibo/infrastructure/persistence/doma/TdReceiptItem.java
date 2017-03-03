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

import org.kawakicchi.kakeibo.domain.model.item.ItemId;
import org.kawakicchi.kakeibo.domain.model.item.ItemName;
import org.kawakicchi.kakeibo.domain.model.item.ItemPrice;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Quantity;
import org.kawakicchi.kakeibo.domain.model.kakeibo.ReceiptId;
import org.kawakicchi.kakeibo.domain.model.kakeibo.ReceiptItemNo;
import org.kawakicchi.kakeibo.domain.shared.DeleteFlag;
import org.kawakicchi.kakeibo.domain.shared.Memo;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * 「td_receipt_item」テーブル定義
 * 
 * @author kawakicchi
 */
@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
public final class TdReceiptItem {

	/** レシートID */
	@Id
	private final ReceiptId receiptId;
	/** レシート商品番号 */
	@Id
	private final ReceiptItemNo no;
	/** 商品名 */
	private final ItemName name;
	/** 商品価格 */
	private final ItemPrice price;
	/** 数量 */
	private final Quantity quantity;
	/** 商品ID */
	private final ItemId itemId;
	/** メモ */
	private final Memo memo;
	/** 削除フラグ */
	private final DeleteFlag deleteFlag;

	/**
	 * コンストラクタ
	 * 
	 * @param receiptId レシートID
	 * @param no レシート商品番号
	 * @param name 商品名
	 * @param price 商品価格
	 * @param quantity 数量
	 * @param itemId 商品ID
	 * @param memo メモ
	 * @param deleteFlag 削除フラグ
	 */
	public TdReceiptItem(ReceiptId receiptId, ReceiptItemNo no, ItemName name, ItemPrice price, Quantity quantity, ItemId itemId, Memo memo,
			DeleteFlag deleteFlag) {
		super();
		this.receiptId = receiptId;
		this.no = no;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.itemId = itemId;
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
	 * レシート商品番号 を取得する。
	 * 
	 * @return レシート商品番号
	 */
	public ReceiptItemNo getNo() {
		return no;
	}

	/**
	 * 商品名 を取得する。
	 * 
	 * @return 商品名
	 */
	public ItemName getName() {
		return name;
	}

	/**
	 * 商品価格 を取得する。
	 * 
	 * @return 商品価格
	 */
	public ItemPrice getPrice() {
		return price;
	}

	/**
	 * 数量 を取得する。
	 * 
	 * @return 数量
	 */
	public Quantity getQuantity() {
		return quantity;
	}

	/**
	 * 商品ID を取得する。
	 * 
	 * @return 商品ID
	 */
	public ItemId getItemId() {
		return itemId;
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
