package uk.co.hunziker.am.dataaccess.bbg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.co.hunziker.am.bbg.BloombergParser;
import uk.co.hunziker.am.model.marketable.MarketData;
import uk.co.hunziker.am.model.marketable.UpdateStatus;
import uk.co.hunziker.am.util.PropertyUtils;

public class BloombergParserTest {

	private static final String BLOOMBERG_PROPERTIES = "bloomberg.properties";

	private BloombergParser bbgParser;

	@Before
	public void setUp() throws Exception {
		Map<String, String> props = PropertyUtils.loadProperties(BLOOMBERG_PROPERTIES);
		bbgParser = new BloombergParser(props);
	}

	@After
	public void tearDown() throws Exception {
		bbgParser = null;
	}

	@Test
	public void testFetchMarketData_Success() throws Exception {
		MarketData marketData = bbgParser.fetchMarketData("UBSN:VX");
		assertNotNull(marketData.getPrice());
		assertNotNull(marketData.getPriceDate());
		assertEquals(UpdateStatus.SUCCESS, marketData.getUpdateStatus());
	}

	@Test
	public void testFetchMarketData_InvalidURL() throws Exception {
		MarketData marketData = bbgParser.fetchMarketData(" UBSN:VX");
		assertNull(marketData.getPrice());
		assertNull(marketData.getPriceDate());
		assertEquals(UpdateStatus.ERROR, marketData.getUpdateStatus());
	}

	@Test
	public void testFetchMarketData_InvalidSymbol() throws Exception {
		MarketData marketData = bbgParser.fetchMarketData("HELLO");
		assertNull(marketData.getPrice());
		assertNull(marketData.getPriceDate());
		assertEquals(UpdateStatus.ERROR, marketData.getUpdateStatus());
	}

}
