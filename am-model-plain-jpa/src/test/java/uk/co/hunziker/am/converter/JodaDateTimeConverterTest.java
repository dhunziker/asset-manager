package uk.co.hunziker.am.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JodaDateTimeConverterTest {

	private JodaDateTimeConverter converter;

	@Before
	public void setUp() throws Exception {
		converter = new JodaDateTimeConverter();
	}

	@After
	public void tearDown() throws Exception {
		converter = null;
	}

	@Test
	public void testConvertToDatabaseColumn() {
		DateTime now = DateTime.now();
		long nowMillis = now.getMillis();
		Timestamp result = converter.convertToDatabaseColumn(now);
		assertEquals(nowMillis, result.getTime());
	}
	
	@Test
	public void testConvertToDatabaseColumn_Null() {
		assertNull(converter.convertToDatabaseColumn(null));
	}

	@Test
	public void testConvertToEntityAttribute() {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		long nowMillis = now.getTime();
		DateTime result = converter.convertToEntityAttribute(now);
		assertEquals(nowMillis, result.getMillis());
	}
	
	@Test
	public void testConvertToEntityAttribute_Null() {
		assertNull(converter.convertToEntityAttribute(null));
	}

}
