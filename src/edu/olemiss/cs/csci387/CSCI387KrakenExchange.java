package edu.olemiss.cs.csci387;

import com.xeiam.xchange.kraken.KrakenExchange;

public class CSCI387KrakenExchange extends XeiamExchange {
	

	public CSCI387KrakenExchange(){
		
		super(KrakenExchange.class.getName());
		
		register(new Credentials("Scooby","0000"));
		register(new Credentials("Doo","01234"));		
	}

	
}
