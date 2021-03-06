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
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboId;
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboMemo;
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboTitle;
import org.kawakicchi.kakeibo.domain.shared.DeleteFlag;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * 「td_kakeibo」テーブル定義
 * 
 * @author kawakicchi
 */
@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
public final class TdKakeibo {

	/** 家計簿ID */
	@Id
	private final KakeiboId kakeiboId;
	/** タイトル */
	private final KakeiboTitle title;
	/** メモ */
	private final KakeiboMemo memo;
	/** グループID */
	private final GroupId groupId;
	/** アカウントID */
	private final AccountId accountId;

	/** 削除フラグ */
	private final DeleteFlag deleteFlag;

	public TdKakeibo(final KakeiboId kakeiboId, final KakeiboTitle title, final KakeiboMemo memo, final GroupId groupId, final AccountId accountId,
			final DeleteFlag deleteFlag) {
		this.kakeiboId = kakeiboId;
		this.title = title;
		this.memo = memo;
		this.groupId = groupId;
		this.accountId = accountId;
		this.deleteFlag = deleteFlag;
	}

	/**
	 * 家計簿ID を取得する。
	 * 
	 * @return 家計簿ID
	 */
	public KakeiboId getKakeiboId() {
		return kakeiboId;
	}

	/**
	 * title を取得する。
	 * 
	 * @return title
	 */
	public KakeiboTitle getTitle() {
		return title;
	}

	/**
	 * memo を取得する。
	 * 
	 * @return memo
	 */
	public KakeiboMemo getMemo() {
		return memo;
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

	/**
	 * 削除フラグ を取得する。
	 * 
	 * @return 削除フラグ
	 */
	public DeleteFlag getDeleteFlag() {
		return deleteFlag;
	}

}
