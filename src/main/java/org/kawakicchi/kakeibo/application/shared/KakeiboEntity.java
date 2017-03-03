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

import java.util.ArrayList;
import java.util.List;

import org.kawakicchi.kakeibo.domain.model.kakeibo.Kakeibo;
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboId;
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboMemo;
import org.kawakicchi.kakeibo.domain.model.kakeibo.KakeiboTitle;

/**
 * 家計簿情報
 * 
 * @author kawakicchi
 */
public class KakeiboEntity {

	/** 家計簿ID */
	private String kakeiboId;
	/** タイトル */
	private String title;
	/** メモ */
	private String memo;

	/** レシート情報一覧 */
	private List<ReceiptEntity> receipts;

	public KakeiboEntity() {
		receipts = new ArrayList<ReceiptEntity>();
	}

	public static KakeiboEntity valueOf(Kakeibo kakeibo) {
		KakeiboEntity entity = null;
		if (null != kakeibo) {
			entity = new KakeiboEntity();
			entity.kakeiboId = KakeiboId.getValue(kakeibo.getKakeiboId());
			entity.title = KakeiboTitle.getValue(kakeibo.getTitle());
			entity.memo = KakeiboMemo.getValue(kakeibo.getMemo());
		}
		return entity;
	}

	/**
	 * 家計簿ID を取得する。
	 * 
	 * @return 家計簿ID
	 */
	public String getKakeiboId() {
		return kakeiboId;
	}

	/**
	 * 家計簿ID を設定する。
	 * 
	 * @param kakeiboId 家計簿ID
	 */
	public void setKakeiboId(String kakeiboId) {
		this.kakeiboId = kakeiboId;
	}

	/**
	 * title を取得する。
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * title を設定する。
	 * 
	 * @param title title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * memo を取得する。
	 * 
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * memo を設定する。
	 * 
	 * @param memo memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * レシート情報一覧 を取得する。
	 * 
	 * @return レシート情報一覧
	 */
	public List<ReceiptEntity> getReceipts() {
		return receipts;
	}

	/**
	 * レシート情報 を追加する。
	 * 
	 * @param receipt レシート情報
	 */
	public void addReceipt(ReceiptEntity receipt) {
		receipts.add(receipt);
	}
}
