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
package org.kawakicchi.kakeibo.application.internal;

import org.kawakicchi.kakeibo.application.AccountService;
import org.kawakicchi.kakeibo.application.shared.AccountEntity;
import org.kawakicchi.kakeibo.application.shared.CreateAccountEntity;
import org.kawakicchi.kakeibo.domain.model.account.Account;
import org.kawakicchi.kakeibo.domain.model.account.AccountName;
import org.kawakicchi.kakeibo.domain.model.account.AccountRepository;
import org.kawakicchi.kakeibo.domain.model.account.Email;
import org.kawakicchi.kakeibo.domain.model.account.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * このインターフェースは、アカウント関連の機能を実装するサービスインターフェースです。
 * 
 * @author kawakicchi
 */
@Service
public class DefaultAccountService implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	@Transactional
	public AccountEntity create(final CreateAccountEntity entity) {
		final AccountName name = AccountName.of(entity.getName());
		final Email email = Email.of(entity.getEmail());
		final Password password = Password.of(entity.getPassword());

		final Account account = Account.create(name, email, password, accountRepository);

		return AccountEntity.valueOf(account);
	}

	@Override
	@Transactional
	public AccountEntity login(final String email, final String password) {

		final Account account = Account.get(Email.of(email), Password.of(password), accountRepository);

		return AccountEntity.valueOf(account);
	}

}
