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
import org.kawakicchi.kakeibo.domain.shared.Memo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 商品登録情報
 * 
 * @author kawakicchi
 */
public class RegistReceiptItemEntity {

	@JsonProperty("name")
	private String name;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("quantity")
	private Integer quantity;
	@JsonProperty("itemId")
	private String itemId;
	@JsonProperty("memo")
	private String memo;

	public static ReceiptItem toReceiptItem(final RegistReceiptItemEntity entity) {
		ReceiptItem item = null;
		if (null != entity) {
			item = entity.toReceiptItem();
		}
		return item;
	}

	public ReceiptItem toReceiptItem() {
		ReceiptItem.Builder builder = ReceiptItem.Builder.newInstance();
		builder.withItem(ItemName.of(name), ItemPrice.of(price), Quantity.of(quantity));
		builder.withItemId(ItemId.of(itemId));
		builder.withMemo(Memo.of(memo));

		return builder.build();
	}
}
