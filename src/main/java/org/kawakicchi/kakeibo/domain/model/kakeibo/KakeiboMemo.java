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

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.Validate;
import org.seasar.doma.Column;
import org.seasar.doma.Domain;

/**
 * めも
 * 
 * @author kawakicchi
 */
@Domain(valueType = String.class, factoryMethod = "of")
public class KakeiboMemo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "memo")
	@NotNull
	private final String value;

	private KakeiboMemo(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static KakeiboMemo of(String value) {
		Validate.notNull(value);

		return new KakeiboMemo(value);
	}

	public static String getValue(KakeiboMemo value) {
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
		KakeiboMemo other = (KakeiboMemo) o;
		return sameValueAs(other);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	boolean sameValueAs(KakeiboMemo other) {
		return other != null && this.value.equals(other.value);
	}
}