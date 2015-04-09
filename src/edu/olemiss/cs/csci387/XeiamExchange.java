package edu.olemiss.cs.csci387;

import java.io.IOException;

import org.joda.money.BigMoney;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.currency.Currencies;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.service.polling.PollingMarketDataService;



public abstract class XeiamExchange extends AuthenticatingExchange implements CSCI387Exchange {
    
    protected Exchange exchange;
    protected PollingMarketDataService marketDataService;
    

    
    

    protected XeiamExchange(String exchangeName){
    	
    	// Use the factory to get an exchange API using default settings
    	exchange =  ExchangeFactory.INSTANCE.createExchange(exchangeName);
    	
    	 // Interested in the public polling market data feed (no authentication)
    	this.marketDataService = exchange.getPollingMarketDataService();
     }
    
	@Override
	public String getCurrentMarketData() throws IOException{
		
	    // Get the latest ticker data showing BTC to USD
	    Ticker ticker = marketDataService.getTicker(Currencies.BTC, Currencies.USD);

		
		return "{ \"Currency\": "+ "\""+ Currencies.USD + "\""+ ", \"Last\": " + "\""+ ticker.getLast().toString() + "\""+ ", \"Volume\": " + "\""+ ticker.getVolume().toString()
				+ "\""+ ", \"High\": " + "\""+ ticker.getHigh().toString() + "\""+ ", \"Low\": " + "\""+ ticker.getLow().toString()+"\""+ "}";
	}
	
	@Override
	public double getMarketBTCPrice() throws IOException {

		BigMoney lastPrice = marketDataService.getTicker(Currencies.BTC, Currencies.USD).getLast();
				
		return lastPrice.getAmountMinorLong() / 100.0;
	}
	

	

	
	
	
	// trade?
	
	//limit order?
    
}
