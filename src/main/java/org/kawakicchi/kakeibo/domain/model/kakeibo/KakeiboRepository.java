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

import java.util.List;

import org.kawakicchi.kakeibo.domain.model.account.Account;
import org.kawakicchi.kakeibo.domain.model.account.Group;

public interface KakeiboRepository {

	Kakeibo store(Kakeibo kakeibo, Group group, Account account);

	Receipt store(Receipt receipt, Kakeibo kakeibo, Account account);

	ReceiptItem store(ReceiptItem item, Receipt receipt, Account account);

	Kakeibo findKakeiboByKakeiboId(KakeiboId kakeiboId, Account account);

	List<Receipt> findReceiptListByKakeibo(Kakeibo kakeibo);

	List<Receipt> findReceiptListByKakeiboAndYearMonth(Kakeibo kakeibo, Year year, Month month);

	List<ReceiptItem> findReceiptItemListByReceipt(Receipt receipt);
}
