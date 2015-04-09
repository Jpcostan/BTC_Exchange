package edu.olemiss.cs.csci387;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CSCI387BitStampExchangeTest {

	@Test
	public void constructor() {
		
		@SuppressWarnings("unused")
		CSCI387BitStampExchange exc = new CSCI387BitStampExchange();	
	}
	
	@Test
	public void marketData0() throws IOException {
		
		CSCI387BitStampExchange exc = new CSCI387BitStampExchange();	
		
		String marketData = exc.getCurrentMarketData();
		
		assertNotNull(marketData);
	}

	
	@Test
	public void marketData1() throws IOException {
		
		CSCI387BitStampExchange exc = new CSCI387BitStampExchange();	
		
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

	@Test
	public void validAccountConnect() {
		
		CSCI387BitStampExchange exc = new CSCI387BitStampExchange();
		
		@SuppressWarnings("unused")
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Wilma","0000"));
		
	}

	



}
