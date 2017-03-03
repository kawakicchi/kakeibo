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
package org.kawakicchi.kakeibo.interfaces.kakeibo.rest;

import java.util.List;

import org.kawakicchi.kakeibo.application.KakeiboService;
import org.kawakicchi.kakeibo.application.shared.AccountEntity;
import org.kawakicchi.kakeibo.application.shared.KakeiboEntity;
import org.kawakicchi.kakeibo.application.shared.ReceiptEntity;
import org.kawakicchi.kakeibo.interfaces.kakeibo.dto.CreateKakeiboRequest;
import org.kawakicchi.kakeibo.interfaces.kakeibo.dto.KakeiboResponse;
import org.kawakicchi.kakeibo.interfaces.kakeibo.dto.ReceiptResponse;
import org.kawakicchi.kakeibo.interfaces.kakeibo.dto.ReceiptsResponse;
import org.kawakicchi.kakeibo.interfaces.kakeibo.dto.RegistReceiptRequest;
import org.kawakicchi.kakeibo.interfaces.kakeibo.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * このクラスは、家計簿機能を提供するRESTコントローラです。
 * 
 * @author kawakicchi
 */
@RestController
@RequestMapping("/api/kakeibo")
public class KakeiboRestController {

	@Autowired
	private KakeiboService kakeiboService;

	@RequestMapping(path = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "Hello kakeibo ping";
	}

	/**
	 * 家計簿を作成する。
	 * 
	 * @param req リクエスト情報
	 * @return レスポンス情報
	 */
	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public Response create(@RequestBody final CreateKakeiboRequest req) {
		final AccountEntity account = null; // TODO: 

		final KakeiboEntity kakeibo = kakeiboService.create(req.getKakeibo(), account);

		return new KakeiboResponse(kakeibo);
	}

	/**
	 * 家計簿を取得する。
	 * 
	 * @param kakeiboId 家計簿ID
	 * @return レスポンス情報
	 */
	@RequestMapping(value = { "/{kakeiboId:^[0-9a-z]{32}$}" }, method = RequestMethod.GET)
	public Response get(@PathVariable final String kakeiboId) {
		final AccountEntity account = null; // TODO: 

		final KakeiboEntity kakeibo = kakeiboService.get(kakeiboId, account);

		return new KakeiboResponse(kakeibo);
	}

	/**
	 * 家計簿にレシートを登録する。
	 * 
	 * @param kakeiboId 家計簿ID
	 * @param req リクエスト情報
	 * @return レスポンス情報
	 */
	@RequestMapping(value = { "/{kakeiboId:^[0-9a-z]{32}$}/receipt/regist" }, method = RequestMethod.POST)
	public Response registReceipt(@PathVariable final String kakeiboId, @RequestBody final RegistReceiptRequest req) {
		final AccountEntity account = null; // TODO: 

		final ReceiptEntity receipt = kakeiboService.registReceipt(kakeiboId, req.getReceipt(), account);

		return new ReceiptResponse(receipt);
	}

	/**
	 * 対象年月のレシートを取得する。
	 * 
	 * @param kakeiboId 家計簿ID
	 * @param year 年
	 * @param month 月
	 * @return レスポンス情報
	 */
	@RequestMapping(value = { "/{kakeiboId:^[0-9a-z]{32}$}/{year:^[0-9]{4}$}/{month:^[0-9]{1,2}$}/receipts" }, method = RequestMethod.GET)
	public Response receipts(@PathVariable final String kakeiboId, @PathVariable final Integer year, @PathVariable final Integer month) {
		final AccountEntity account = null; // TODO: 

		final List<ReceiptEntity> receipts = kakeiboService.getReceipts(kakeiboId, year, month, account);

		return new ReceiptsResponse(receipts);
	}

}
