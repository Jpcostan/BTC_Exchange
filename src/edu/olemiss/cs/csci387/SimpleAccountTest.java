package edu.olemiss.cs.csci387;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class SimpleAccountTest {
	
	static final double EPSILON=0.00000001;

	@Test
	public void depositBTC() {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0000"));
		
		acc.depositBTC(10);
		
		assertEquals(9.94, acc.getBTCBalance(), EPSILON);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void depositBTC2() {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0000"));
		
		acc.depositBTC(-10);
	}

	
	
	@Test
	public void depositUSD() {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0000"));
		
		acc.depositUSD(10);
		
		assertEquals(9.94, acc.getUSDBalance(), EPSILON);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void depositUSD2() {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0000"));
		
		acc.depositUSD(-10);
	}

	
	@Test
	public void buyBTC() throws IOException {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0000"));
		
		acc.depositUSD(1000); // remember we get charged a commission for this!
		
		assertEquals(994, acc.getUSDBalance(), EPSILON);
		
		acc.buyBTC(1);
		
		assertEquals(1, acc.getBTCBalance(), EPSILON);
		assertEquals(994-100.60, acc.getUSDBalance(), EPSILON);
	}


	
	@Test
	public void sellBTC() throws IOException {
		
		CSCI387MockExchange exc = new CSCI387MockExchange();
		
		SimpleAccount acc = new SimpleAccount(exc, new Credentials("Fred","0000"));
		
		acc.depositBTC(2); // remember we get charged a commission for this!
		
		assertEquals(2 - 0.006*2, acc.getBTCBalance(), EPSILON);
		
		acc.sellBTC(1);
		
		assertEquals(2 - 0.006*2 - 1, acc.getBTCBalance(), EPSILON);
		assertEquals(100 - 100*0.006, acc.getUSDBalance(), EPSILON);
	}

}
