package edu.olemiss.cs.csci387;

import java.util.UUID;

public class Transaction {
	protected UUID transactionNumber;
	protected String dateRequested; //date transaction was requested
	protected String dateCompleted; //date the transaction occurred (after processing)
	protected String timeRequested; //time transaction was requested
	protected String timeCompleted; //time the transaction occurred (after processing)
	protected double amount; //btc or usd
	protected boolean isManual;
	protected String username; //or from Account or something
	//protected String strategyID; //or also a UUID?
	protected CSCI387Account fromAccount;
	protected CSCI387Account toAccount;
	protected AuthenticatingExchange fromExchange;
	protected AuthenticatingExchange toExchange;
	protected String fromCurrency; //or use Currencies class, but where is it?
	protected String toCurrency;
	
	public Transaction(){ //shouldn't be called
		transactionNumber = UUID.randomUUID();
		dateRequested = "";
		dateCompleted = "";
		timeRequested = "";
		timeCompleted = "";
		amount = 0.0;
		isManual = false;
		//strategyID = "";
		username = "";
		fromAccount = null;
		toAccount = null;
		fromExchange = null;
		toExchange = null;
		fromCurrency = null;
		toCurrency = null;
	}
	
	public Transaction(String dr, String dc, String tr, String tc, double amt, boolean man, /*String sid, */
			CSCI387Account fromAcct, CSCI387Account toAcct, AuthenticatingExchange fromExch, AuthenticatingExchange toExch, String fromCur, String toCur){
		transactionNumber = UUID.randomUUID();
		dateRequested = dr;
		dateCompleted = dc;
		timeRequested = tr;
		timeCompleted = tc;
		amount = amt;
		isManual = man;
		//strategyID = sid;
		username = fromAcct.getCredentials().getUsername();
		fromAccount = fromAcct;
		toAccount = toAcct;
		fromExchange = fromExch;
		toExchange = toExch;
		fromCurrency = fromCur;
		toCurrency = toCur;
	}
	
	public String toString(){
		String result = "";
		result += "Transaction:  " + transactionNumber.toString();
		result += "\nDate requested:  " + dateRequested;
		result += "\nTime requested:  " + timeRequested;
		result += "\nDate completed:  " + dateCompleted;
		result += "\nTime completed:  " + timeCompleted;
		result += "\nRequested by:  ";
		if(isManual)
			result += "user" + username;
		/*else
			result += "strategy " + strategyID;*/
		result += "\nTransaction type:  general transaction";
		result += "\nAmount:  " + amount;
		result += "From account:  " + fromAccount.getCredentials();
		result += "On this exchange:  " /*+ fromExchange.name*/;
		result += "To account:  " + toAccount.getCredentials();
		result += "On this exchange:  " /*+ toExchange.name*/;
		result += "From this currency:  " + fromCurrency; //I don't like this for non-trades.
		result += "To this currency:  " + toCurrency; //maybe inheritance for the type makes sense
		return result;
	}
}
