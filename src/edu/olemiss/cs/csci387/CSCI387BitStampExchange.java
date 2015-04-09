package edu.olemiss.cs.csci387;

import com.xeiam.xchange.bitstamp.BitstampExchange;

public class CSCI387BitStampExchange extends XeiamExchange {
	

	public CSCI387BitStampExchange(){
		
		super(BitstampExchange.class.getName());
		
		register(new Credentials("Wilma","0000"));
		register(new Credentials("Betty","01234"));		
	}

	
}
