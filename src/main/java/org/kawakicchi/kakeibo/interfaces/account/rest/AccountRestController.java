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
package org.kawakicchi.kakeibo.interfaces.account.rest;

import org.kawakicchi.kakeibo.application.AccountService;
import org.kawakicchi.kakeibo.application.shared.AccountEntity;
import org.kawakicchi.kakeibo.application.util.KakeiboUtil;
import org.kawakicchi.kakeibo.interfaces.account.dto.CreateAccountRequest;
import org.kawakicchi.kakeibo.interfaces.kakeibo.dto.AccountResponse;
import org.kawakicchi.kakeibo.interfaces.kakeibo.dto.LoginRequest;
import org.kawakicchi.kakeibo.interfaces.kakeibo.dto.LoginResponse;
import org.kawakicchi.kakeibo.interfaces.kakeibo.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * このクラスは、アカウント機能を提供するRESTコントローラです。
 * 
 * @author kawakicchi
 */
@RestController
@RequestMapping("/api/account")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(path = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "Hello account ping";
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public Response create(@RequestBody final CreateAccountRequest req) {

		final AccountEntity account = accountService.create(req.getAccount());

		return new AccountResponse(account);
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public Response login(@RequestBody final LoginRequest req) {

		final AccountEntity account = accountService.login(req.getEmail(), req.getPassword());

		final String authToken = KakeiboUtil.generateUUID();

		return new LoginResponse(authToken);
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public void logout() {

	}

}
