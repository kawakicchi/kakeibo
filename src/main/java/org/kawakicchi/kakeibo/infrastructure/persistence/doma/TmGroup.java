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

import org.kawakicchi.kakeibo.domain.model.account.GroupId;
import org.kawakicchi.kakeibo.domain.model.account.GroupName;
import org.kawakicchi.kakeibo.domain.shared.DeleteFlag;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * 「tm_group」テーブル定義
 * 
 * @author kawakicchi
 */
@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE)
public final class TmGroup {

	/** グループID */
	@Id
	private final GroupId groupId;
	/** グループ名 */
	private final GroupName name;

	/** 削除フラグ */
	private final DeleteFlag deleteFlag;

	/**
	 * コンストラクタ
	 * 
	 * @param groupId
	 * @param name
	 * @param deleteFlag
	 */
	public TmGroup(GroupId groupId, GroupName name, DeleteFlag deleteFlag) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.deleteFlag = deleteFlag;
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
	 * name を取得する。
	 * 
	 * @return name
	 */
	public GroupName getName() {
		return name;
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
