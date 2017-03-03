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
package org.kawakicchi.kakeibo.domain.model.item;

import java.io.Serializable;

/**
 * 商品
 * 
 * @author kawakicchi
 */
public class Item implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 8372850618670938085L;

	/** 商品ID */
	private final ItemId itemId;
	/** 商品名 */
	private final ItemName name;
	/** 商品価格 */
	private final ItemPrice price;

	public Item(ItemId itemId, ItemName name, ItemPrice price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
	}

	/**
	 * itemId を取得する。
	 * 
	 * @return itemId
	 */
	public ItemId getItemId() {
		return itemId;
	}

	/**
	 * name を取得する。
	 * 
	 * @return name
	 */
	public ItemName getName() {
		return name;
	}

	/**
	 * price を取得する。
	 * 
	 * @return price
	 */
	public ItemPrice getPrice() {
		return price;
	}

}
