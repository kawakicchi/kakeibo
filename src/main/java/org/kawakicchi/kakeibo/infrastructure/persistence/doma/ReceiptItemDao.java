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
package org.kawakicchi.kakeibo.infrastructure.persistence.doma;

import java.util.function.Function;
import java.util.stream.Stream;

import org.kawakicchi.kakeibo.domain.model.kakeibo.ReceiptId;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.seasar.doma.jdbc.SelectOptions;

@Dao
@ConfigAutowireable
public interface ReceiptItemDao {

	@Insert
	Result<TdReceiptItem> insert(TdReceiptItem item);

	@Select(strategy = SelectType.STREAM)
	Integer findByReceiptId(ReceiptId receiptId, SelectOptions options, Function<Stream<TdReceiptItem>, Integer> mapper);

	@Select
	Integer maxNoByReceiptId(ReceiptId receiptId);
}
