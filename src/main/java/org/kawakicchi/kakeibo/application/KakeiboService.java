/**
 * Copyright 2017 Azuki Framework.
 *
 *import org.kawakicchi.kakeibo.domain.model.kakeibo.Kakeibo;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Month;
import org.kawakicchi.kakeibo.domain.model.kakeibo.Year;

 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kawakicchi.kakeibo.application;

import java.util.List;

import org.kawakicchi.kakeibo.application.shared.AccountEntity;
import org.kawakicchi.kakeibo.application.shared.CreateKakeiboEntity;
import org.kawakicchi.kakeibo.application.shared.KakeiboEntity;
import org.kawakicchi.kakeibo.application.shared.ReceiptEntity;
import org.kawakicchi.kakeibo.application.shared.RegistReceiptEntity;

/**
 * このインターフェースは、家計簿関連の機能を定義するサービスインターフェースです。
 * 
 * @author kawakicchi
 */
public interface KakeiboService {

	/**
	 * 家計簿を作成する。
	 * 
	 * @param kakeibo 家計簿情報
	 * @param account アカウント情報
	 * @return 家計簿情報
	 */
	KakeiboEntity create(CreateKakeiboEntity kakeibo, AccountEntity account);

	/**
	 * 家計簿を取得する。
	 * 
	 * @param kakeiboId 家計簿ID
	 * @param account アカウント情報
	 * @return 家計簿情報
	 */
	KakeiboEntity get(String kakeiboId, AccountEntity account);

	/**
	 * レシートを登録する。
	 * 
	 * @param kakeiboId 家計簿ID
	 * @param receipt レシート情報
	 * @param account アカウント情報
	 * @return レシート情報
	 */
	ReceiptEntity registReceipt(String kakeiboId, RegistReceiptEntity receipt, AccountEntity account);

	/**
	 * 対象年月のレシート一覧を取得する。
	 * 
	 * @param kakeiboId 家計簿ID
	 * @param year 年
	 * @param month 月
	 * @param account アカウント情報
	 * @return レシート情報一覧
	 */
	List<ReceiptEntity> getReceipts(String kakeiboId, Integer year, Integer month, AccountEntity account);

}
