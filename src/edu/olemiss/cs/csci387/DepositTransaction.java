package edu.olemiss.cs.csci387;

import java.util.UUID;

public class DepositTransaction extends Transaction {
	
	public DepositTransaction(String dr, String tr, String dc, String tc, boolean man, /*String sid, */
			CSCI387Account acct, AuthenticatingExchange exch, String cur){
		transactionNumber = UUID.randomUUID();
		dateRequested = dr;
		timeRequested = tr;
		dateCompleted = dc;
		timeCompleted = tc;
		isManual = man;
		//strategyID = sid;
		username = acct.getCredentials().getUsername();
		toExchange = exch;
		toCurrency = cur;
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
		result += "\nTransaction type:  deposit";
		result += "\nAmount:  " + amount;
		result += "\nCurrency:  " + toCurrency;
		result += "To account:  " + toAccount.getCredentials();
		result += "On this exchange:  "  + toExchange.getName();
		return result;
	}
}
