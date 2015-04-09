package edu.olemiss.cs.csci387;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CSCI387KrakenExchangeTest {

	@Test
	public void constructor() {
		
		@SuppressWarnings("unused")
		CSCI387KrakenExchange exc = new CSCI387KrakenExchange();	
	}
	
	@Test
	public void marketData0() throws IOException {
		
		CSCI387KrakenExchange exc = new CSCI387KrakenExchange();	
		
		String marketData = exc.getCurrentMarketData();
		
		assertNotNull(marketData);
	}

	
	@Test
	public void marketData1() throws IOException {
		
		CSCI387KrakenExchange exc = new CSCI387KrakenExchange();	
		
		String marketData = exc.getCurrentMarketData();
		
		assertTrue(marketData.contains("Currency"));
		assertTrue(marketData.contains("Last"));
		assertTrue(marketData.contains("Volume"));
		assertTrue(marketData.contains("High"));
		assertTrue(marketData.contains("Low"));
	}
	
	@Test
	public void marketBTCPrice() throws IOException {

		CSCI387BitStampExchange exc = new CSCI387BitStampExchange();
		
		double price = exc.getMarketBTCPrice();
		
		assertNotEquals(0.0, price);
		
	}

}
