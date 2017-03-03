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

import org.kawakicchi.kakeibo.domain.model.account.Account;
import org.kawakicchi.kakeibo.domain.model.account.AccountRepository;
import org.kawakicchi.kakeibo.domain.model.account.Email;
import org.kawakicchi.kakeibo.domain.model.account.Group;
import org.kawakicchi.kakeibo.domain.model.account.Password;
import org.kawakicchi.kakeibo.domain.shared.DeleteFlag;
import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kawakicchi
 */
@Component
public class DomaAccountRepository implements AccountRepository {

	@Autowired
	private AccountDao accountDao;

	@Override
	public Account store(final Account account, final Email email, final Password password) {

		final TmAccount record = new TmAccount(account.getAccountId(), account.getName(), email, password, DeleteFlag.False);

		final Result<TmAccount> result = accountDao.insert(record);

		return toAccount(result.getEntity());
	}

	@Override
	public Group store(final Group group, final Account account) {

		final TmGroup record1 = new TmGroup(group.getGroupId(), group.getName(), DeleteFlag.False);

		final Result<TmGroup> result1 = accountDao.insert(record1);

		final TrGroupAccount record2 = new TrGroupAccount(group.getGroupId(), account.getAccountId());

		final Result<TrGroupAccount> result2 = accountDao.insert(record2);

		return toGroup(result1.getEntity());
	}

	@Override
	public Account findAccountByEmailAndPassword(final Email email, final Password password) {

		final TmAccount record = accountDao.findByEmailAndPassword(email, password);

		final Account account = toAccount(record);

		return account;
	}

	private Group toGroup(TmGroup record) {
		if (null == record) {
			return null;
		}

		final Group.Builder builder = Group.Builder.newInstance();
		builder.withGroupId(record.getGroupId());
		builder.withName(record.getName());
		return builder.build();
	}

	private Account toAccount(TmAccount record) {
		if (null == record) {
			return null;
		}

		final Account.Builder builder = Account.Builder.newInstance();
		builder.withAccountId(record.getAccountId());
		builder.withName(record.getName());
		builder.withEmail(record.getEmail());
		return builder.build();
	}
}
