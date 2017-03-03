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
import org.kawakicchi.kakeibo.domain.model.account.AccountName;
import org.kawakicchi.kakeibo.domain.model.account.Email;
import org.kawakicchi.kakeibo.domain.model.account.Password;
import org.kawakicchi.kakeibo.domain.shared.DeleteFlag;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * 「tm_account」テーブル定義
 * 
 * @author kawakicchi
 */
@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
public final class TmAccount {

	/** アカウントID */
	@Id
	private final AccountId accountId;
	/** アカウント名 */
	private final AccountName name;
	/** メールアドレス */
	private final Email email;
	/** パスワード */
	private final Password password;

	/** 削除フラグ */
	private final DeleteFlag deleteFlag;

	/**
	 * コンストラクタ
	 * 
	 * @param accountId
	 * @param name
	 * @param email
	 * @param password
	 * @param deleteFlag
	 */
	public TmAccount(AccountId accountId, AccountName name, Email email, Password password, DeleteFlag deleteFlag) {
		super();
		this.accountId = accountId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.deleteFlag = deleteFlag;
	}

	/**
	 * accountId を取得する。
	 * 
	 * @return accountId
	 */
	public AccountId getAccountId() {
		return accountId;
	}

	/**
	 * name を取得する。
	 * 
	 * @return name
	 */
	public AccountName getName() {
		return name;
	}

	/**
	 * email を取得する。
	 * 
	 * @return email
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * password を取得する。
	 * 
	 * @return password
	 */
	public Password getPassword() {
		return password;
	}

	/**
	 * 削除フラグ を取得する。
	 * 
	 * @return 削除フラグ
	 */
	public DeleteFlag getDeleteFlag() {
		return deleteFlag;
	}

}
