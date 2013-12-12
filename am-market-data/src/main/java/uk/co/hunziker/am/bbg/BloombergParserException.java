package uk.co.hunziker.am.bbg;

public class BloombergParserException extends Exception {

	private static final long serialVersionUID = 2802795363842067478L;

	private static final String MESSAGE = "[%s] doesn't point to a valid quote or the selectors used are out of date";

	public BloombergParserException(String url) {
		this(url, null);
	}

	public BloombergParserException(String url, Exception cause) {
		super(String.format(MESSAGE, url), cause);
	}

}
