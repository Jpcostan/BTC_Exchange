package edu.olemiss.cs.csci387;

import java.io.IOException;

public interface CSCI387Account{
	
	void login();
	
	void logout();
	
	boolean isLoggedIn();
	
	Credentials getCredentials();
	
	double getUSDBalance() throws IOException;
	
	double getBTCBalance() throws IOException;
	
	void depositBTC(double btc) throws IOException;
	
	void depositUSD(double usd) throws IOException;
	
	void buyBTC(double btc) throws IOException;
	
	void sellBTC(double btc) throws IOException;	
	
	//void transferBTC(double btc) throws IOException;
	
	//void transferUSD(double usd) throws IOException;


}
