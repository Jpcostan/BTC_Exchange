package edu.olemiss.cs.csci387.acceptanceTests;

import edu.olemiss.cs.csci387.CSCI387Account;


public class LoginCommand extends AcceptanceTestCommand {

	@Override
	public Object execute(Environment e) {

		CSCI387Account account = (CSCI387Account) (e.lookup(objectName));

		account.login();
		return null;
	}
}
