package edu.olemiss.cs.csci387.acceptanceTests;


import edu.olemiss.cs.csci387.CSCI387MockExchange;

public class CreateMockExchangeCommand extends AcceptanceTestCommand {

	@Override
	public Object execute(Environment e) {
		
		
		return new CSCI387MockExchange();
	}

}
