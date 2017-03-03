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
package org.kawakicchi.kakeibo.domain.shared;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.Validate;
import org.seasar.doma.Column;
import org.seasar.doma.Domain;

/**
 * 削除フラグ
 * 
 * @author kawakicchi
 */
@Domain(valueType = boolean.class, factoryMethod = "of")
public enum DeleteFlag {
	/** */
	True(true),
	/** */
	False(false);

	@Column(name = "deleteFlag")
	@NotNull
	private final boolean value;

	private DeleteFlag(boolean value) {
		this.value = value;
	}

	public static DeleteFlag of(boolean value) {
		Validate.notNull(value);

		for (DeleteFlag type : DeleteFlag.values()) {
			if (type.value == value) {
				return type;
			}
		}
		throw new IllegalArgumentException(value + "");
	}

	public boolean getValue() {
		return value;
	}
}