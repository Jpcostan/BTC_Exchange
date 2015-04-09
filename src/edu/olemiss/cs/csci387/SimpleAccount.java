package edu.olemiss.cs.csci387;

import java.io.IOException;

public class SimpleAccount implements CSCI387Account {
	
	
	CSCI387Exchange exchange;
	Credentials credentials;
    protected double btcBalance;
    protected double usdBalance;
	protected boolean isLoggedIn=false;
	
	public SimpleAccount(CSCI387Exchange exc, Credentials c){
		
		exchange=exc;
		credentials=c;
		
		//exchange.connect(this);  //Assumes credentials have already been assigned.
	}

	
	@Override
	public void login() {
		
		this.isLoggedIn = exchange.connect(this);
	}

	@Override
	public void logout() {
		
		this.isLoggedIn = ! (exchange.disconnect(this));
	}
	public void addUSD(double amt){
		usdBalance = usdBalance + amt;
	}
	public void addBTC(double amt){
		btcBalance = btcBalance + amt;
	}
	public void subtractUSD(double amt){
		usdBalance = usdBalance - amt;
	}
	public void subtractBTC(double amt){
		btcBalance = btcBalance - amt;
	}
	@Override
	public double getUSDBalance() {
		
		return usdBalance;
	}

	@Override
	public double getBTCBalance() {
		
		return btcBalance;
	}

	@Override
	public void depositBTC(double btc) {
		
		if(btc < 0.0){
			
			throw new IllegalArgumentException("Negative amounts not allowed.");
		}
		
		double commission = exchange.getCommission();
		
		btcBalance+=btc*(1.0 - commission);
	}

	@Override
	public void depositUSD(double usd) {

		if(usd < 0.0){
			
			throw new IllegalArgumentException("Negative amounts not allowed.");
		}

		double commission = exchange.getCommission();
		
		usdBalance+=usd*(1.0 - commission);
	}

	@Override
	public void buyBTC(double btc) throws IOException {
		
		if(btc < 0.0){
			
			throw new IllegalArgumentException("Negative amounts not allowed.");
		}
				
		double commission = exchange.getCommission();
		
		double lastPrice = exchange.getMarketBTCPrice();
		
		double costInDollars = lastPrice * btc * (1.0 + commission);
			
		usdBalance -= costInDollars;
		btcBalance += btc;
	}

	@Override
	public void sellBTC(double btc) throws IOException {

		if(btc < 0.0){
			
			throw new IllegalArgumentException("Negative amounts not allowed.");
		}		
		
		double commission = exchange.getCommission();
		
		double lastPrice = exchange.getMarketBTCPrice();
		
		double yieldInDollars = lastPrice * btc * (1.0 - commission);
			
		usdBalance += yieldInDollars;
		btcBalance -= btc;
	}


	@Override
	public Credentials getCredentials() {
	
		return this.credentials;
	}


	@Override
	public boolean isLoggedIn() {
		
		return isLoggedIn;
	}
	
	
	

}
