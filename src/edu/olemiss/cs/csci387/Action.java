package edu.olemiss.cs.csci387;

import java.io.IOException;
import java.util.Scanner;

import edu.olemiss.cs.csci387.CSCI387Exchange;

public class Action extends Condition {

	SimpleAccount account;
	SimpleAccount account1, account2;
	PairAccounts pair;
	CSCI387Exchange exchange;
	Credentials credentials;
	protected double btcBalance;
	protected double usdBalance;
	boolean buy;
	Condition c = new Condition();
	Scanner scan = new Scanner(System.in);

	public Action(SimpleAccount a)// boolean bos)
	{
		// buy = bos;
		account = a;
	}

	public Action(SimpleAccount a, SimpleAccount b, PairAccounts p) {
		account1 = a;
		account2 = b;
		pair = p;

	}

	public void performHighRisk() throws IOException {
		// possibly split this up into 2 methods
		// if high risk if()
		buy = c.isSatisfiedRaising();
		if (account.getUSDBalance() < account.exchange.getMarketBTCPrice()) {
			System.out.println("Error, not enough USD ");
		} else {
			if (buy == true) {
				account.buyBTC(1.00);// code to buy
			} else
				account.sellBTC(1.00);

		}
	}

	public void performLowRisk() throws IOException {

		// if low risk if()
		buy = c.isSatisfiedDropping();
		if (account.getUSDBalance() < account.exchange.getMarketBTCPrice()) {
			System.out.println("Error, not enough USD. ");
		} else {
			if (buy == false) {
				account.sellBTC(1.00); // code to sell
			} else
				account.buyBTC(1.00);

		}
	}
	
	public void performArbitrage() throws IOException{
		if(account1.exchange.getMarketBTCPrice()<account2.exchange.getMarketBTCPrice()){
			//double amt = account1.getUSDBalance()/account1.exchange.getMarketBTCPrice();
			account1.buyBTC(1.00);
			pair.transfer1to2BTC(1);
			account2.sellBTC(1);
			pair.transfer2to1USD(account2.exchange.getMarketBTCPrice());
		}
		else{
			//double amt = account2.getUSDBalance()/account2.exchange.getMarketBTCPrice();
			account2.buyBTC(1);
			pair.transfer2to1BTC(1);
			account1.sellBTC(1);
			pair.transfer1to2USD(account1.exchange.getMarketBTCPrice());
		}
	}
	
	public void transferFunds(){
		System.out.println("Account 1 USD: " + account1.getUSDBalance());
		System.out.println("Account 2 USD: " + account2.getUSDBalance());
		
		System.out.println("--------------------");
		System.out.println("What account would you like to transfer from? 1 or 2?");
		int acc = scan.nextInt();
		if(acc == 1){
			System.out.println("You have "+ account1.getUSDBalance() +" available");
			System.out.println("How much would you like to transfer?");
			int amt  = scan.nextInt();
			pair.transfer1to2USD(amt);
			System.out.println("Your remaining balance for account 1 is " + account1.getUSDBalance());
			System.out.println("Your balance for account 2 is now " + account2.getUSDBalance());
		}
		else if(acc ==2){
			System.out.println("You have "+ account2.getUSDBalance() +" available");
			System.out.println("How much would you like to transfer?");
			int amt  = scan.nextInt();
			pair.transfer2to1USD(amt);
			System.out.println("Your remaining balance for account 2 is " + account2.getUSDBalance());
			System.out.println("Your balance for account 1 is now " + account1.getUSDBalance());
		}
		else{
			System.out.println("That is not a valid choice.");
			transferFunds();
		}
		
	}
	public void transferBTC(){
		System.out.println("Account 1 BTC: " + account1.getBTCBalance());
		System.out.println("Account 2 BTC: " + account2.getBTCBalance());
		
		System.out.println("--------------------");
		System.out.println("What account would you like to transfer from? 1 or 2?");
		int acc = scan.nextInt();
		if(acc == 1){
			System.out.println("You have "+ account1.getBTCBalance() +" available");
			System.out.println("How much would you like to transfer?");
			int amt  = scan.nextInt();
			pair.transfer1to2BTC(amt);
			System.out.println("Your remaining balance for account 1 is " + account1.getBTCBalance());
			System.out.println("Your balance for account 2 is now " + account2.getBTCBalance());
		}
		else if(acc ==2){
			System.out.println("You have "+ account2.getUSDBalance() +" available");
			System.out.println("How much would you like to transfer?");
			int amt  = scan.nextInt();
			pair.transfer2to1USD(amt);
			System.out.println("Your remaining balance for account 2 is " + account2.getUSDBalance());
			System.out.println("Your balance for account 1 is now " + account1.getUSDBalance());
		}
		else{
			System.out.println("That is not a valid choice.");
			transferBTC();
		}
	}
	
	public void accountInfo(){
		System.out.println("Account 1 USD: " + account1.getUSDBalance());
		System.out.println("Account 1 BTC: " + account1.getBTCBalance());
		System.out.println("Account 2 USD: " + account2.getUSDBalance());
		System.out.println("Account 2 BTC: " + account2.getBTCBalance());
		System.out.println("--------------------");
	}
}
