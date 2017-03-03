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

import org.kawakicchi.kakeibo.domain.model.item.ItemId;
import org.kawakicchi.kakeibo.domain.model.item.ItemName;
import org.kawakicchi.kakeibo.domain.model.item.ItemPrice;
import org.kawakicchi.kakeibo.domain.shared.Memo;

/**
 * 商品
 * 
 * @author kawakicchi
 */
public class ReceiptItem implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -5440213679686958833L;

	/** レシート商品番号 */
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

	public ReceiptItem(ReceiptItemNo no, ItemName name, ItemPrice price, Quantity quantity, ItemId itemId, Memo memo) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.itemId = itemId;
		this.memo = memo;
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

	public static class Builder {

		/** レシート商品番号 */
		private ReceiptItemNo no;
		/** 商品名 */
		private ItemName name;
		/** 商品価格 */
		private ItemPrice price;
		/** 数量 */
		private Quantity quantity;
		/** 商品ID */
		private ItemId itemId;
		/** メモ */
		private Memo memo;

		private Builder() {

		}

		private Builder(final ReceiptItem item) {
			no = item.no;
			name = item.name;
			price = item.price;
			quantity = item.quantity;
			itemId = item.itemId;
			memo = item.memo;
		}

		public static Builder newInstance() {
			return new Builder();
		}

		public static Builder newInstance(final ReceiptItem item) {
			return new Builder(item);
		}

		public ReceiptItem build() {
			return new ReceiptItem(no, name, price, quantity, itemId, memo);
		}

		public Builder withNo(final ReceiptItemNo no) {
			this.no = no;
			return this;
		}

		public Builder withItem(final ItemName name, final ItemPrice price, final Quantity quantity) {
			this.name = name;
			this.price = price;
			this.quantity = quantity;
			return this;
		}

		public Builder withItemId(final ItemId itemId) {
			this.itemId = itemId;
			return this;
		}

		public Builder withMemo(final Memo memo) {
			this.memo = memo;
			return this;
		}
	}
}
