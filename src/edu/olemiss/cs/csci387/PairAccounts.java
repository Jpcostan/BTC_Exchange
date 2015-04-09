package edu.olemiss.cs.csci387;

public class PairAccounts {
	SimpleAccount account1;
	SimpleAccount account2;
	public PairAccounts(SimpleAccount acc1, SimpleAccount acc2){
		account1 = acc1;
		account2 = acc2;
		
	}
	public void transfer1to2USD(double amt){
		if(account1.getUSDBalance() < amt){
			System.out.println("Insufficient Funds to Transfer");
		}
		else{
		account1.subtractUSD(amt);
		account2.addUSD(amt);
		}
	}
	public void transfer2to1USD(double amt){
		if(account2.getUSDBalance() < amt){
			System.out.println("Insufficient Funds to Transfer");
		}
		else{
		account2.subtractUSD(amt);
		account1.addUSD(amt);
		}
	}
	public void transfer1to2BTC(double amt){
		if(account1.getBTCBalance() < amt){
			System.out.println("Insufficient Funds to Transfer");
		}
		else{
		account1.subtractBTC(amt);
		account2.addBTC(amt);
		}
	}
	public void transfer2to1BTC(double amt){
		if(account2.getBTCBalance() < amt){
			System.out.println("Insufficient Funds to Transfer");
		}
		else{
		account2.subtractBTC(amt);
		account1.addBTC(amt);
		}
	}
}
