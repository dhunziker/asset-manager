package uk.co.hunziker.am.util;

import static uk.co.hunziker.am.util.FormatConstants.DEFAULT_DATE_TIME_TMZ_PATTERN;
import static uk.co.hunziker.am.util.FormatConstants.DEFAULT_DECIMAL_PATTERN;
import static uk.co.hunziker.am.util.FormatConstants.DEFAULT_LOCALE;
import static uk.co.hunziker.am.util.FormatConstants.DEFAULT_TIMEZONE;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JodaTimeFormat {

	public static DateTimeFormatter getDefaultDateTimeTmzFormatter() {
		DateTimeFormatter fmt = getDateTimeFormatter(DEFAULT_TIMEZONE, DEFAULT_DATE_TIME_TMZ_PATTERN);
		fmt.withLocale(DEFAULT_LOCALE);
		return fmt;
	}

	public static DateTimeFormatter getDateTimeFormatter(String tmzId, String pattern) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
		return fmt.withZone(DateTimeZone.forID(tmzId));
	}

	public static String print(DateTime dateTime) {
		if (dateTime != null) {
			return getDefaultDateTimeTmzFormatter().print(dateTime);
		}
		return "null";
	}

	public static String print(BigDecimal number) {
		if (number != null) {
			DecimalFormat df = new DecimalFormat(DEFAULT_DECIMAL_PATTERN);
			return df.format(number);
		}
		return "";
	}

}
