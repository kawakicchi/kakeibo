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

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.Validate;
import org.seasar.doma.Column;
import org.seasar.doma.Domain;

/**
 * 月
 * 
 * @author kawakicchi
 */
@Domain(valueType = Integer.class, factoryMethod = "of")
public enum Month {
	/** */
	January(Integer.valueOf(1)),
	/** */
	February(Integer.valueOf(2)),
	/** */
	March(Integer.valueOf(3)),
	/** */
	April(Integer.valueOf(4)),
	/** */
	May(Integer.valueOf(5)),
	/** */
	June(Integer.valueOf(6)),
	/** */
	July(Integer.valueOf(7)),
	/** */
	August(Integer.valueOf(8)),
	/** */
	September(Integer.valueOf(9)),
	/** */
	October(Integer.valueOf(10)),
	/** */
	November(Integer.valueOf(11)),
	/** */
	December(Integer.valueOf(12));

	@Column(name = "month")
	@NotNull
	private final Integer value;

	private Month(Integer value) {
		this.value = value;
	}

	public static Month of(Integer value) {
		Validate.notNull(value);

		for (Month jobType : Month.values()) {
			if (jobType.value.equals(value)) {
				return jobType;
			}
		}
		throw new IllegalArgumentException(value + "");
	}

	public static Integer getValue(Month value) {
		if (null != value) {
			return value.getValue();
		}
		return null;
	}

	public Integer getValue() {
		return value;
	}
}