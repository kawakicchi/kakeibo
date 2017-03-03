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
package org.kawakicchi.kakeibo.domain.model.account;

import java.io.Serializable;

import org.kawakicchi.kakeibo.application.util.KakeiboUtil;

/**
 * アカウント
 * 
 * @author kawakicchi
 */
public class Account implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 552889471167189808L;

	/** アカウントID */
	private final AccountId accountId;
	/** アカウント名 */
	private final AccountName name;
	/** メールアドレス */
	private final Email email;

	/**
	 * コンストラクタ
	 * 
	 * @param accountId アカウントID
	 * @param name アカウント名
	 * @param email メールアドレス
	 */
	public Account(final AccountId accountId, final AccountName name, final Email email) {
		super();
		this.accountId = accountId;
		this.name = name;
		this.email = email;
	}

	/**
	 * アカウントID を取得する。
	 * 
	 * @return アカウントID
	 */
	public AccountId getAccountId() {
		return accountId;
	}

	/**
	 * アカウント名 を取得する。
	 * 
	 * @return アカウント名
	 */
	public AccountName getName() {
		return name;
	}

	/**
	 * メールアドレス を取得する。
	 * 
	 * @return メールアドレス
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * アカウントビルダー
	 */
	public static class Builder {

		/** アカウントID */
		private AccountId accountId;
		/** アカウント名 */
		private AccountName name;
		/** メールアドレス */
		private Email email;

		private Builder() {

		}

		private Builder(final Account account) {
			accountId = account.accountId;
			name = account.name;
			email = account.email;
		}

		public static Builder newInstance() {
			return new Builder();
		}

		public static Builder newInstance(final Account account) {
			return new Builder(account);
		}

		public Account build() {
			return new Account(accountId, name, email);
		}

		public Builder withAccountId(final AccountId accountId) {
			this.accountId = accountId;
			return this;
		}

		public Builder withName(final AccountName name) {
			this.name = name;
			return this;
		}

		public Builder withEmail(final Email email) {
			this.email = email;
			return this;
		}
	}

	/**
	 * 新規アカウントを作成する。
	 * 
	 * @param name アカウント名
	 * @param email メールアドレス
	 * @param password パスワード
	 * @param rep リポジトリ
	 * @return アカウント
	 */
	public static Account create(final AccountName name, final Email email, final Password password, final AccountRepository rep) {
		final Email encEmail = encryptEmail(email);
		final Password encPassword = encryptPassword(email, password);

		final Account.Builder builder = Account.Builder.newInstance();
		builder.withAccountId(AccountId.of(KakeiboUtil.generateUUID()));
		builder.withName(name);

		final Account account = rep.store(builder.build(), encEmail, encPassword);

		return account;
	}

	/**
	 * メールアドレスとパスワードからアカウントを取得する。
	 * 
	 * @param email メールアドレス
	 * @param password パスワード
	 * @param rep リポジトリ
	 * @return アカウント
	 */
	public static Account get(final Email email, final Password password, final AccountRepository rep) {
		final Email encEmail = encryptEmail(email);
		final Password encPassword = encryptPassword(email, password);

		final Account account = rep.findAccountByEmailAndPassword(encEmail, encPassword);

		return account;
	}

	private static Email encryptEmail(final Email email) {
		return email;
	}

	private static Password encryptPassword(final Email email, final Password password) {
		return password;
	}
}
