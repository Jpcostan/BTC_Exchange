/**
 * Copyright (C) 2012 - 2013 Xeiam LLC http://xeiam.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
//package com.xeiam.xchange.examples.bitstamp.marketdata;

import java.io.IOException;

import edu.olemiss.cs.csci387.*;

/**
 * Demonstrate requesting Ticker Data from various exchanges.
 * 
 * Hello World!!!
 * 
 */
public class TickerDemo {

  public static void main(String[] args) throws IOException {
	  
	CSCI387Exchange e1 = new CSCI387BitStampExchange();
	CSCI387Exchange e2 = new CSCI387MtGoxExchange();
	//CSCI387Exchange e3 = new CSCI387BTCeExchange();
	CSCI387Exchange e4 = new CSCI387KrakenExchange();
	
	
	for(;;){
		
		System.out.println("BitStamp  "+e1.getCurrentMarketData());
		System.out.println("MTG  "+e2.getCurrentMarketData());
		//System.out.println("BTCe  "+e3.getCurrentMarketData());
		System.out.println("Kraken  "+e4.getCurrentMarketData());
		System.out.println("");
		
	}
  }
 
}