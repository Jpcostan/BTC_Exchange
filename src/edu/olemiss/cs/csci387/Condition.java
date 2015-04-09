package edu.olemiss.cs.csci387;
import java.io.IOException;


import edu.olemiss.cs.csci387.CSCI387Exchange;
public class Condition {

		boolean satisfied = false;
		boolean satisfied2 = false;
		double BTCpriceAvg;
		double percent;
		
		CSCI387Exchange BSE = new CSCI387BitStampExchange();
		CSCI387Exchange BTCE = new CSCI387BTCeExchange();
		CSCI387Exchange KR = new CSCI387KrakenExchange();
		
		//Condition con = new Condition();
	
	public Condition()
	{
		 percent = 0.05;		 
		
	}
	//this could possibly be a void method that simply sets BTCpriceAvg to the average of these 3
	public double findPriceAvg() throws IOException{
		
		double BTCpriceAvg =((BSE.getMarketBTCPrice() + BTCE.getMarketBTCPrice() 
				+ KR.getMarketBTCPrice()) / 3);
		return BTCpriceAvg;
	}	
	//The next two methods still need to be specified as to whether they are high or low risk
	public boolean isSatisfiedRaising(){
		//if the price avg of the exchanges has increased by 5%
		//need to find a way to make use of System.currentTimeMillis(); in here
		//possible to be better to use a switch statement here
		//long startTime = System.currentTimeMillis();
		//long endTime (would be after the case?)
		if(BTCpriceAvg == ((BTCpriceAvg * percent) + BTCpriceAvg)){
			return satisfied = true;
		}
			else return satisfied = false;
	}
	public boolean isSatisfiedDropping(){
		//same goes for this func as the one above
		//if the price avg of the exchanged has decreased by 5%
		if(BTCpriceAvg == ((BTCpriceAvg * percent) - BTCpriceAvg)){
			return satisfied = true;
		}
		else return satisfied = false;
	}
}
