package edu.olemiss.cs.csci387.acceptanceTests;

public class PrintCommand extends AcceptanceTestCommand {

	@Override
	public Object execute(Environment e) {
		
		Object a = e.lookup(arguments.get(0));
		
		if (a!=null) {
			System.out.println(arguments.get(0)+"="+a);
		} else {
			System.out.println("\""+arguments.get(0)+"\""+" was not found in the environment.");
		}
		
		return null;
	}

}
