package edu.olemiss.cs.csci387.acceptanceTests;


import edu.olemiss.cs.csci387.CSCI387MtGoxExchange;

public class CreateMtGoxExchangeCommand extends AcceptanceTestCommand {

	@Override
	public Object execute(Environment e) {
		
		
		return new CSCI387MtGoxExchange();
	}

}
