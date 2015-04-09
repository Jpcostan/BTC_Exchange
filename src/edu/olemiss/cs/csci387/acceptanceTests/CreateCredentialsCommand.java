package edu.olemiss.cs.csci387.acceptanceTests;


import edu.olemiss.cs.csci387.Credentials;

public class CreateCredentialsCommand extends AcceptanceTestCommand {

	@Override
	public Object execute(Environment e) {
		
		return new Credentials(arguments.get(0), arguments.get(1));
	}

}
