package edu.olemiss.cs.csci387;

import java.io.IOException;

public interface CSCI387Exchange {
	
	String getCurrentMarketData() throws IOException;
	
	double getMarketBTCPrice() throws IOException;

	boolean connect(CSCI387Account acc);
	
	boolean disconnect(CSCI387Account acc);
	
	double getCommission();
}
