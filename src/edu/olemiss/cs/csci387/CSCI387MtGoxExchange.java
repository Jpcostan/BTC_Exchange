package edu.olemiss.cs.csci387;

import com.xeiam.xchange.mtgox.v2.MtGoxExchange;


public class CSCI387MtGoxExchange extends XeiamExchange {
	
	public CSCI387MtGoxExchange(){
		
		super(MtGoxExchange.class.getName());

		register(new Credentials("Fred","0000"));
		register(new Credentials("Barney","01234"));
	}

}
