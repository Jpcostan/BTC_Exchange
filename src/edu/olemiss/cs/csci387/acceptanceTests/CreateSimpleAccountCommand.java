package edu.olemiss.cs.csci387.acceptanceTests;

import edu.olemiss.cs.csci387.CSCI387Exchange;
import edu.olemiss.cs.csci387.Credentials;
import edu.olemiss.cs.csci387.SimpleAccount;



public class CreateSimpleAccountCommand extends AcceptanceTestCommand {

	@Override
	public Object execute(Environment e) {
		
		return new SimpleAccount(
				(CSCI387Exchange) (e.lookup(arguments.get(0))),
				(Credentials) (e.lookup(arguments.get(1)))			
			);
	}

}
