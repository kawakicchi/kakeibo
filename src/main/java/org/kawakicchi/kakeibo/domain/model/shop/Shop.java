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
package org.kawakicchi.kakeibo.domain.model.shop;

import java.util.List;

import org.kawakicchi.kakeibo.application.util.KakeiboUtil;
import org.kawakicchi.kakeibo.domain.model.item.Item;
import org.seasar.doma.Id;

/**
 * @author kawakicchi
 */
public class Shop {

	@Id
	private ShopId shopId;

	public static class Builder {

		private ShopId shopId;

		private Builder() {

		}

		private Builder(Shop shop) {

		}

		public static Builder newInstance() {
			return new Builder();
		}

		public static Builder newInstance(Shop shop) {
			return new Builder(shop);
		}

		public Shop build() {
			return new Shop();
		}

		public Builder withShopId(final ShopId shopId) {
			this.shopId = shopId;
			return this;
		}
	}

	/**
	 * 新規ショップを作成する。
	 * 
	 * @param shop ショップ情報
	 * @param rep リポジトリ
	 * @return ショップ
	 */
	public static Shop create(final Shop shop, final ShopRepository rep) {
		final ShopId shopId = ShopId.of(KakeiboUtil.generateUUID());

		final Builder builder = Builder.newInstance(shop);
		builder.withShopId(shopId);

		final Shop result = rep.store(builder.build());

		return result;
	}

	public static Shop get(final ShopId shopId, final ShopRepository rep) {
		// TODO: 
		return null;
	}

	public static List<Shop> search(final ShopRepository rep) {
		// TODO
		return null;
	}

	public List<Item> getItemList(final ShopRepository rep) {
		return null;
	}
}
