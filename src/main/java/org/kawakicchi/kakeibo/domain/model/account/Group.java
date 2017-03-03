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

/**
 * グループ
 * 
 * @author kawakicchi
 */
public class Group implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -5977602299506613524L;

	/** グループID */
	private final GroupId groupId;
	/** グループ名 */
	private final GroupName name;

	/**
	 * コンストラクタ
	 * 
	 * @param groupId グループID
	 * @param name グループ名
	 */
	public Group(GroupId groupId, GroupName name) {
		super();
		this.groupId = groupId;
		this.name = name;
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

	public static class Builder {

		/** グループID */
		private GroupId groupId;
		/** グループ名 */
		private GroupName name;

		private Builder() {

		}

		private Builder(final Group group) {
			groupId = group.groupId;
			name = group.name;
		}

		public static Builder newInstance() {
			return new Builder();
		}

		public static Builder newInstance(final Group group) {
			return new Builder(group);
		}

		public Group build() {
			return new Group(groupId, name);
		}

		public Builder withGroupId(final GroupId groupId) {
			this.groupId = groupId;
			return this;
		}

		public Builder withName(final GroupName name) {
			this.name = name;
			return this;
		}
	}
}
