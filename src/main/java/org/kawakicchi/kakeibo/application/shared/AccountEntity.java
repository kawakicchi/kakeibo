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

import org.kawakicchi.kakeibo.domain.model.account.Account;
import org.kawakicchi.kakeibo.domain.model.account.AccountId;
import org.kawakicchi.kakeibo.domain.model.account.AccountName;
import org.kawakicchi.kakeibo.domain.model.account.Email;

/**
 * アカウント情報
 * 
 * @author kawakicchi
 */
public class AccountEntity {

	/** アカウントID */
	private String accountId;
	/** アカウント名 */
	private String name;
	/** メールアドレス */
	private String email;

	public static AccountEntity valueOf(final Account account) {
		AccountEntity entity = null;
		if (null != account) {
			entity = new AccountEntity();
			entity.accountId = AccountId.getValue(account.getAccountId());
			entity.name = AccountName.getValue(account.getName());
			entity.email = Email.getValue(account.getEmail());
		}
		return entity;
	}

	public static Account toAccount(final AccountEntity entity) {
		if (null != entity) {
			return entity.toAccount();
		}
		return null;
	}

	public Account toAccount() {
		Account.Builder builder = Account.Builder.newInstance();
		builder.withAccountId(AccountId.of(accountId));
		builder.withName(AccountName.of(name));
		builder.withEmail(Email.of(email));
		return builder.build();
	}

	/**
	 * accountId を取得する。
	 * 
	 * @return accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * accountId を設定する。
	 * 
	 * @param accountId accountId
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * name を取得する。
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * name を設定する。
	 * 
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * email を取得する。
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * email を設定する。
	 * 
	 * @param email email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
