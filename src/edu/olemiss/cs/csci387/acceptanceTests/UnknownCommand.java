package edu.olemiss.cs.csci387.acceptanceTests;


public class UnknownCommand extends AcceptanceTestCommand {
	
	String type; // the bogus type string.

	public UnknownCommand(String type){
		
		this.type=type;
	}
	
	
	@Override
	public Object execute(Environment e) {
		
		System.err.println("Invalid Command Found in Acceptance Test: "+type);
		
		return null;
	}

}
