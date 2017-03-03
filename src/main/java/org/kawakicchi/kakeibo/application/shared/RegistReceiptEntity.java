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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.kawakicchi.kakeibo.domain.model.kakeibo.Receipt;
import org.kawakicchi.kakeibo.domain.model.shop.ShopAddress;
import org.kawakicchi.kakeibo.domain.model.shop.ShopId;
import org.kawakicchi.kakeibo.domain.model.shop.ShopName;
import org.kawakicchi.kakeibo.domain.model.shop.ShopNameSub;
import org.kawakicchi.kakeibo.domain.model.shop.ShopTel;
import org.kawakicchi.kakeibo.domain.shared.Memo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * レシート登録情報
 * 
 * @author kawakicchi
 */
public class RegistReceiptEntity {

	@JsonProperty("date")
	private String date;
	@JsonProperty("shopName")
	private String shopName;
	@JsonProperty("shopNameSub")
	private String shopNameSub;
	@JsonProperty("shopTel")
	private String shopTel;
	@JsonProperty("shopAddress")
	private String shopAddress;
	@JsonProperty("shopId")
	private String shopId;
	@JsonProperty("memo")
	private String memo;

	@JsonProperty("items")
	private List<RegistReceiptItemEntity> items;

	public static Receipt toReceipt(final RegistReceiptEntity entity) {
		Receipt receipt = null;
		if (null != entity) {
			receipt = entity.toReceipt();
		}
		return receipt;
	}

	public Receipt toReceipt() {
		Receipt.Builder builder = Receipt.Builder.newInstance();
		if (null != date) {
			try {
				builder.withDate(FORMAT.parse(date));
			} catch (ParseException ex) {

			}
		}
		builder.withShopName(ShopName.of(shopName), ShopNameSub.of(shopNameSub));
		builder.withShopTel(ShopTel.of(shopTel));
		builder.withShopAddress(ShopAddress.of(shopAddress));
		builder.withShopId(ShopId.of(shopId));
		builder.withMemo(Memo.of(memo));

		return builder.build();
	}

	private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public List<RegistReceiptItemEntity> getItems() {
		return items;
	}
}
