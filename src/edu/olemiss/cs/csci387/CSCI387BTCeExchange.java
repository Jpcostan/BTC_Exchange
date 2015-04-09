package edu.olemiss.cs.csci387;

import com.xeiam.xchange.btce.BTCEExchange;

public class CSCI387BTCeExchange extends XeiamExchange {
	

	public CSCI387BTCeExchange(){
		
		super(BTCEExchange.class.getName());
		
		register(new Credentials("Rocky","0000"));
		register(new Credentials("Bullwinkle","abcde"));		
	}

	
}
