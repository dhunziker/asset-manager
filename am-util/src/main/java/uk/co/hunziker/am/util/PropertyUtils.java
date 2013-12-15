package uk.co.hunziker.am.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.FormattedMessage;

public class PropertyUtils {

	private static final Logger log = LogManager.getLogger();

	private static final String PROPERTY_PATTERN = "=";

	public static Map<String, String> loadProperties(String file) {
		Map<String, String> props = new HashMap<>();
		try (InputStream is = PropertyUtils.class.getResourceAsStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(PROPERTY_PATTERN, 2);
				switch (tokens.length) {
				case 2:
					props.put(tokens[0], tokens[1]);
					break;
				default:
					log.info(new FormattedMessage("%s is not a valid property", line));
				}
			}
		} catch (IOException e) {
			log.warn(new FormattedMessage("Failed to close properties file: %s", e.getMessage()));
		}
		return props;
	}

}
