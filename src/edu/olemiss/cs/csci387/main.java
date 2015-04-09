package edu.olemiss.cs.csci387;

import java.io.IOException;
import java.util.Scanner;

public class main {
	static String username, pw;
	static SimpleAccount a1;
	static SimpleAccount a2;
	static CSCI387BitStampExchange BSExchange = new CSCI387BitStampExchange();
	static CSCI387KrakenExchange KExchange = new CSCI387KrakenExchange();
	static CSCI387BTCeExchange BTCExchange = new CSCI387BTCeExchange();
	static CSCI387Exchange ex;
	static Scanner scan = new Scanner(System.in);
	static PairAccounts paired;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		login();
		a1.depositBTC(5);
		a1.depositUSD(5000);
		System.out.println("Would you like to pair it with another account?");
		System.out.println("Enter 1 for yes");
		System.out.println("Enter 2 for no");
		int x = scan.nextInt();
		if (x == 1) {
			login2();
			a2.depositUSD(1000);
			paired = new PairAccounts(a1, a2);
			new Gui(a1, a2);
			Agent agent = new Agent(a1, a2, paired);

		} else {
			new Gui(a1);

			Agent agent = new Agent(a1);
		}
		// System.out.println(a1.getCredentials());
		// SimpleAccount a2 = new SimpleAccount(exc1, new
		// Credentials("Joey","1111"));
		// a2.login();
		// a1.depositUSD(98986);
		// a2.depositUSD(500);
		// a2.depositBTC(300);
		// a1.depositBTC(5);
		// PairAccounts paired = new PairAccounts(a1,a2);
		// System.out.println(a1.getUSDBalance());
		// System.out.println(a2.getUSDBalance());
		// paired.transfer1to2USD(1100);
		// System.out.println(a1.getUSDBalance());
		// System.out.println(a2.getUSDBalance());
		// Condition c = new Condition();
		// System.out.println(c.findPriceAvg());
		// testing Agent
		// Agent a = new Agent();
		// a.execute();
		// Gui g = new Gui(a1,a2,exc1,exc2);

	}

	public static void login() {
		System.out.println("What exchange would you like to use?");
		System.out.println("Enter 1 for BitStamp");
		System.out.println("Enter 2 for Kraken");
		System.out.println("Enter 3 for BTC");
		int exchange = scan.nextInt();
		do {
			System.out
					.println("Please Login with the Username and Password associated with the exchange");
			System.out.println("Username:  ");
			username = scan.next();
			System.out.println("Password:  ");
			pw = scan.next();
			Credentials creds = new Credentials(username, pw);
			if (exchange == 1) {
				ex = BSExchange;
			} else if (exchange == 2) {
				ex = KExchange;
			} else if (exchange == 3) {
				ex = BTCExchange;
			} else {
				System.out.println("That is not a valid exchange");
			}
			a1 = new SimpleAccount(ex, creds);

			a1.login();
			if (!a1.isLoggedIn()) {
				System.out.println("Wrong Credentials");
			}
		} while (!a1.isLoggedIn());
	}

	public static void login2() {
		System.out.println("What other exchange would you like to use?");
		System.out.println("Enter 1 for BitStamp");
		System.out.println("Enter 2 for Kraken");
		System.out.println("Enter 3 for BTC");
		int exchange = scan.nextInt();
		do {
			System.out
					.println("Please Login with the Username and Password associated with the exchange");
			System.out.println("Username:  ");
			username = scan.next();
			System.out.println("Password:  ");
			pw = scan.next();
			Credentials creds = new Credentials(username, pw);
			if (exchange == 1) {
				ex = BSExchange;
			} else if (exchange == 2) {
				ex = KExchange;
			} else if (exchange == 3) {
				ex = BTCExchange;
			} else {
				System.out.println("That is not a valid exchange");
			}
			a2 = new SimpleAccount(ex, creds);

			a2.login();
			if (!a2.isLoggedIn()) {
				System.out.println("Wrong Credentials");
			}
		} while (!a2.isLoggedIn());
	}
}