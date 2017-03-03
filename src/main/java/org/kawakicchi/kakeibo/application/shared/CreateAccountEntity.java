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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * アカウント作成情報
 * 
 * @author kawakicchi
 */
public class CreateAccountEntity {

	@JsonProperty
	private String name;
	@JsonProperty
	private String email;
	@JsonProperty
	private String password;

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

	/**
	 * password を取得する。
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * password を設定する。
	 * 
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
