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
package org.kawakicchi.kakeibo.domain.model.category;

import java.io.Serializable;

import org.kawakicchi.kakeibo.application.util.KakeiboUtil;
import org.kawakicchi.kakeibo.domain.model.account.Account;

/**
 * カテゴリ
 * 
 * @author kawakicchi
 */
public class Category implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -7312946292444701687L;

	/** カテゴリID */
	private final CategoryId categoryId;
	/** カテゴリ名 */
	private final CategoryName name;

	public Category(final CategoryId categoryId, final CategoryName name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	/**
	 * categoryId を取得する。
	 * 
	 * @return categoryId
	 */
	public CategoryId getCategoryId() {
		return categoryId;
	}

	/**
	 * name を取得する。
	 * 
	 * @return name
	 */
	public CategoryName getName() {
		return name;
	}

	public static class Builder {
		/** カテゴリID */
		private CategoryId categoryId;
		/** カテゴリ名 */
		private CategoryName name;

		private Builder() {

		}

		private Builder(final Category category) {
			categoryId = category.categoryId;
			name = category.name;
		}

		public static Builder newInstance() {
			return new Builder();
		}

		public static Builder newInstance(final Category category) {
			return new Builder(category);
		}

		public Category build() {
			return new Category(categoryId, name);
		}

		public Builder withCategoryId(final CategoryId categoryId) {
			this.categoryId = categoryId;
			return this;
		}

		public Builder withName(final CategoryName name) {
			this.name = name;
			return this;
		}
	}

	public static Category regist(final Category category, final Account account, final CategoryRepository repository) {
		final Category.Builder builder = Category.Builder.newInstance(category);
		builder.withCategoryId(CategoryId.of(KakeiboUtil.generateUUID()));

		final Category result = repository.store(category, account);

		return result;
	}

}
