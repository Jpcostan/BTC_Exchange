
package edu.olemiss.cs.csci387.acceptanceTests;

import java.util.ArrayList;

public abstract class AcceptanceTestCommand {

	// Are these a bad idea? They're an opportunity for error.
	static final String createMockExchange = "createMockExchange"; 
	static final String createMtGoxExchange = "createMtGoxExchange"; 
	static final String createBitStampExchange = "createBitStampExchange"; 
	static final String createAccount = "createAccount"; 
	static final String createCredentials = "createCredentials";
	static final String login = "login";
	static final String isLoggedIn = "isLoggedIn";
	static final String print = "print";

	ArrayList<String> arguments;  // many commands have arguments
	String objectName; // some commands execute methods of existing objects.
	
	AcceptanceTestCommand(){
		
		arguments = new ArrayList<String>();
	}
	
	public static AcceptanceTestCommand createCommand(String type){
		
		if (type.equals(createMockExchange)){
			
			return new CreateMockExchangeCommand();
		} else 	if (type.equals(createMtGoxExchange)){
			
			return new CreateMtGoxExchangeCommand();
		} else  if(type.equals(createAccount)){
			
			return new CreateSimpleAccountCommand();
		} else if(type.equals(createCredentials)){
			
			return new CreateCredentialsCommand();
		} else if(type.equals(login)){
			
			return new LoginCommand();
		} else if(type.equals(isLoggedIn)){
			
			return new IsLoggedInCommand();
		} else if(type.equals(print)){
			
			return new PrintCommand();

		} else 
			return new UnknownCommand(type);
		
	}
	
	
	public void addArgument(String arg){
		
		arguments.add(arg);
	}

	
	public void setObjectName(String name){
		
		objectName = name;
	}

	public abstract Object execute(Environment e);
	
	
	

	

}
