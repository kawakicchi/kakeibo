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

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.seasar.doma.Column;
import org.seasar.doma.Domain;

@Domain(valueType = String.class, factoryMethod = "of")
public class ShopId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "shopId")
	@NotNull
	private final String value;

	private ShopId(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ShopId of(String value) {
		if (null != value) {
			return new ShopId(value);
		}
		return null;
	}

	public static String getValue(ShopId value) {
		if (null != value) {
			return value.getValue();
		}
		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShopId other = (ShopId) o;
		return sameValueAs(other);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	boolean sameValueAs(ShopId other) {
		return other != null && this.value.equals(other.value);
	}
}