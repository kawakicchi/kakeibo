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

import org.kawakicchi.kakeibo.domain.model.account.AccountId;
import org.kawakicchi.kakeibo.domain.model.account.GroupId;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * 「tr_group_account」テーブル定義
 * 
 * @author kawakicchi
 */
@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
public final class TrGroupAccount {

	/** グループID */
	@Id
	private final GroupId groupId;
	/** アカウントID */
	@Id
	private final AccountId accountId;

	public TrGroupAccount(GroupId groupId, AccountId accountId) {
		super();
		this.groupId = groupId;
		this.accountId = accountId;
	}

	/**
	 * groupId を取得する。
	 * 
	 * @return groupId
	 */
	public GroupId getGroupId() {
		return groupId;
	}

	/**
	 * accountId を取得する。
	 * 
	 * @return accountId
	 */
	public AccountId getAccountId() {
		return accountId;
	}

}
