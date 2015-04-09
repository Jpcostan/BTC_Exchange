package edu.olemiss.cs.csci387;

import java.util.Hashtable;


public abstract class AuthenticatingExchange implements CSCI387Exchange {
	
	String name = "CSCI387Exchange";
	
	//TODO: I think this needs to move.
    protected double commission=0.006;

	class Authentication{
		
		boolean valid=false;

		Authentication(){
			valid=false;
		}

		Authentication(boolean v){
			valid=v;
		}
	}
	
	private Hashtable<Credentials,Authentication> accounts;
	
	

	AuthenticatingExchange(){
	    	
		accounts = new Hashtable<Credentials, Authentication>();
	}

	/**
	 * Register the given credentials with this exchange. This will allow 
	 * an account with the same credentials to connect to the exchange in future.
	 * @param c the given credentials.
	 */
	protected void register(Credentials c){
		
		accounts.put(c, new Authentication());
	}
	
	@Override
	public boolean connect(CSCI387Account acc){
		
		Authentication auth = accounts.get(acc.getCredentials());
		
		if(auth != null) {
			
			auth.valid=true;
			return true;
		} else {
			
			//throw new CSCI387AuthenticationException("Invalid Credentials");
			return false;
		}
	}
	
	
	
	@Override
	public boolean disconnect(CSCI387Account acc){
		
		Authentication auth = accounts.get(acc.getCredentials());
		
		if(auth != null && auth.valid) {
			
			auth.valid=false;
			return true;
		} else {
			
			System.err.println("disconnect(): called with nonexistent or non-authenticated account.");
			return false;
		}
	}
	
	
	@Override
	public double getCommission(){
		
		return this.commission;
	}

	public String getName() {
		return name;
	}
	

	


}
