package edu.olemiss.cs.csci387;

import java.io.IOException;



public class CSCI387MockExchange extends AuthenticatingExchange {

	public CSCI387MockExchange(){

		register(new Credentials("Fred","0000"));
		register(new Credentials("Barney","01234"));		
	}

	
	@Override
	public String getCurrentMarketData() throws IOException {
		
		return new String("{ \"Currency\": \"USD\", \"Last\": \"USD 690.40\", \"Volume\": \"76544.08813723\", \"High\": \"USD 712.90\", \"Low\": \"USD 538.01\" }");
	}

	@Override
	public double getMarketBTCPrice() throws IOException {
		
		return 100.00;
	}

}
