package edu.olemiss.cs.csci387;

import java.util.Scanner;
import java.io.IOException;

//This is a test from Josh
public class Agent {
	SimpleAccount account;
	SimpleAccount account2;
	// private Node [] NodeList;
	// int highorlow;
	Scanner scan = new Scanner(System.in);
	Action action1, action2;
	// Action action2;
	PairAccounts pair;

	public Agent(SimpleAccount a) throws IOException// int i, Node[] n)
	{
		account = a;
		action1 = new Action(account);
		// NodeList = n;
		// highorlow = i;
		execute();

	}

	public Agent(SimpleAccount a, SimpleAccount b, PairAccounts p) throws IOException {
		account = a;
		account2 = b;
		pair = p;
		action2 = new Action(account, account2, pair);
		executePairAccounts();

	}

	// execute high risk
	// create a scanner and ask user high or low risk
	// depending on users' choice, execute either the high or low risk methods
	// from the Action class
	// condition is high/low risk non-dependent
	// we only need condition to see if price is rising or lowering
	//
	public void execute() throws IOException {

		System.out
				.println("Choose between a High or Low risk investing method");
		System.out
				.println("Enter a 1) for | High Risk| or 2) for | Low Risk |");
		int userChoice = scan.nextInt();
		if (userChoice == 1) {

			executeHighRisk();
		}
		if (userChoice == 2) {

			executeLowRisk();
		}
	}
	
	public void executeHighRisk() throws IOException {
		System.out.println("You are now running: HIGH RISK");
			for (;;) {
			action1.performHighRisk();
		}

	}

	// execute low risk
	public void executeLowRisk() throws IOException {
		System.out.println("You are now running: LOW RISK");
		for (;;) {
			action1.performLowRisk();
		}
	}
	
	public void executePairAccounts() throws IOException{
		System.out.println("What would you like to do?");
		System.out.println("1. Arbitrage");
		System.out.println("2. Transfer Funds");
		System.out.println("3. Transfer BTC");
		System.out.println("4. Request Account Info");
		int userChoice = scan.nextInt();
		if(userChoice==1){
			for(int i = 0; i < 50; i++){
		action2.performArbitrage();}
		executePairAccounts();
		}
		else if(userChoice ==2){
			action2.transferFunds();
			executePairAccounts();
		}
		else if(userChoice == 3){
			action2.transferBTC();
			executePairAccounts();
		}
		else if(userChoice ==4){
			action2.accountInfo();
			executePairAccounts();
		}
		else{
			System.out.println("That is not a valid choice");
			executePairAccounts();
		}

	}

}
