package edu.olemiss.cs.csci387;

import java.util.UUID;

public class WithdrawTransaction extends Transaction {

	public WithdrawTransaction(String dr, String tr, String dc, String tc, boolean man, /*String sid, */
			CSCI387Account acct, AuthenticatingExchange exch, String cur){
		transactionNumber = UUID.randomUUID();
		dateRequested = dr;
		timeRequested = tr;
		dateCompleted = dc;
		timeCompleted = tc;
		isManual = man;
		//strategyID = sid;
		username = acct.getCredentials().getUsername();
		fromExchange = exch;
		fromCurrency = cur;
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
		//else
		//	result += "strategy " + strategyID;
		result += "\nTransaction type:  withdrawal";
		result += "\nAmount:  " + amount;
		result += "\nCurrency:  " + fromCurrency;
		result += "From account:  " + fromAccount.getCredentials();
		result += "On this exchange:  " + fromExchange.getName();
		return result;
	}
	
}
