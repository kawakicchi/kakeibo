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
package org.kawakicchi.kakeibo.application.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class KakeiboUtil {

	public static void main(final String[] args) {
		Date d = getDate(2016, 12);
		System.out.println(toYYYYMMDDHHMMSSWithSlash(d));
		System.out.println(toYYYYMMDDHHMMSSWithSlash(getNextMonth(d)));
	}

	public static Date getDate(final Integer year, final Integer month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date getNextMonth(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		return c.getTime();
	}

	private static final SimpleDateFormat DF_YYYYMMDDHHMMSS_SLASH = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public static String toYYYYMMDDHHMMSSWithSlash(final Date date) {
		String string = null;
		string = DF_YYYYMMDDHHMMSS_SLASH.format(date);
		return string;
	}

	public static String generateUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24, 36);
	}

	public static boolean isNull(final Object object) {
		return (null == object);
	}

	public static boolean isNotNull(final Object object) {
		return !(isNull(object));
	}
}
