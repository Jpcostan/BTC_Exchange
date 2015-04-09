package edu.olemiss.cs.csci387;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CSCI387MockExchangeTest {

	@Test
	public void testCSCI387MockExchange() {
		
		@SuppressWarnings("unused")
		CSCI387MockExchange exc = new CSCI387MockExchange();
	}

	
	@Test
	public void marketBTCPrice() throws IOException  {
	
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		double price = exc.getMarketBTCPrice();
		
		assertEquals(100.0, price, 0.0001);
	}
	
	@Test
	public void constructor() {
		
		@SuppressWarnings("unused")
		CSCI387MockExchange exc = new CSCI387MockExchange();	
	}
	
	@Test
	public void marketData0() throws IOException {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();	
		
		String marketData = exc.getCurrentMarketData();
		
		assertNotNull(marketData);
	}

	
	@Test
	public void marketData1() throws IOException {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();	
		
		String marketData = exc.getCurrentMarketData();
		
		assertTrue(marketData.contains("Currency"));
		assertTrue(marketData.contains("Last"));
		assertTrue(marketData.contains("Volume"));
		assertTrue(marketData.contains("High"));
		assertTrue(marketData.contains("Low"));
	}
	

	@Test
	public void validAccountConnect1() {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		@SuppressWarnings("unused")
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0000"));
		
	}

	@Test
	public void validAccountsConnect2() {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		@SuppressWarnings("unused")
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0000"));
		
		@SuppressWarnings("unused")
		SimpleAccount acc2 = new SimpleAccount(exc, new Credentials("Barney","01234"));
		
	}

	
	@Test
	public void inValidAccountConnect1() {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		

		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0001"));

		assertFalse(acc.isLoggedIn());
		
	}

	@Test
	public void inValidAccountConnect2() {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Freddy","0000"));
		
		assertFalse(acc.isLoggedIn());
	}
	

	@Test
	public void depositBTC() {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0000"));
		
		acc.depositBTC(10);
		
		assertEquals(9.94, acc.getBTCBalance(), 0.001);
		
	}

	@Test
	public void depositUSD() {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0000"));
		
		acc.depositUSD(10);
		
		assertEquals(9.94, acc.getUSDBalance(), 0.001);
		
	}
	
	@Test
	public void trade() throws IOException {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0000"));
		
		acc.depositUSD(1000);
		
		acc.buyBTC(0.001);
		
		assertTrue( acc.getBTCBalance() > 0);
		
	}


}
