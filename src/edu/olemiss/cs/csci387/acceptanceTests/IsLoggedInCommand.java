package edu.olemiss.cs.csci387.acceptanceTests;

import edu.olemiss.cs.csci387.CSCI387Account;


public class IsLoggedInCommand extends AcceptanceTestCommand {

	@Override
	public Object execute(Environment e) {

		CSCI387Account account = (CSCI387Account) (e.lookup(objectName));

		return new Boolean(account.isLoggedIn());
	}

}
