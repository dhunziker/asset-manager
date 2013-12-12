package uk.co.hunziker.am.util;

import java.util.Locale;

public class FormatConstants {

	public static final String DEFAULT_DECIMAL_PATTERN = "#,##0.00";

	public static final String DEFAULT_DATE_PATTERN = "dd-MMM-YYYY";

	public static final String DEFAULT_DATE_TIME_PATTERN = DEFAULT_DATE_PATTERN + " HH:mm:ss";

	public static final String DEFAULT_DATE_TIME_TMZ_PATTERN = DEFAULT_DATE_TIME_PATTERN + " z";

	public static final String DEFAULT_TIMEZONE = "Europe/London";

	public static final Locale DEFAULT_LOCALE = Locale.UK;

	private FormatConstants() {
	}

}
