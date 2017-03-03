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

import org.kawakicchi.kakeibo.application.shared.AccountEntity;
import org.kawakicchi.kakeibo.application.shared.CreateAccountEntity;

/**
 * このインターフェースは、アカウント関連の機能を定義するサービスインターフェースです。
 * 
 * @author kawakicchi
 */
public interface AccountService {

	/**
	 * アカウントを作成する。
	 * 
	 * @param account アカウント情報
	 * @return アカウント情報
	 */
	AccountEntity create(CreateAccountEntity account);

	/**
	 * ログインする。
	 * 
	 * @param email メールアドレス
	 * @param password パスワード
	 * @return アカウント情報
	 */
	AccountEntity login(String email, String password);
}
