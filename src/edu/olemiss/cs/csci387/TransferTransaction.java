package edu.olemiss.cs.csci387;

import java.util.UUID;

public class TransferTransaction extends Transaction {

	public TransferTransaction(String dr, String tr, String dc, String tc, boolean man, /*String sid, */
			CSCI387Account fromAcct, CSCI387Account toAcct, AuthenticatingExchange fromExch, AuthenticatingExchange toExch, String cur){
		transactionNumber = UUID.randomUUID();
		dateRequested = dr;
		timeRequested = tr;
		dateCompleted = dc;
		timeCompleted = tc;
		isManual = man;
		//strategyID = sid;
		username = fromAcct.getCredentials().getUsername();
		fromAccount = fromAcct;
		fromExchange = fromExch;
		toAccount = toAcct;
		toExchange = toExch;
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
		result += "\nTransaction type:  transfer";
		result += "\nAmount:  " + amount;
		result += "From account:  " + fromAccount.getCredentials();
		result += "On this exchange:  " + fromExchange.getName();
		result += "To account:  " + toAccount.getCredentials();
		result += "On this exchange:  " + toExchange.getName();
		result += "In this currency:  " + fromCurrency;
		return result;
	}
	
}
