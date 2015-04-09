import edu.olemiss.cs.csci387.acceptanceTests.AcceptanceTestParser;

//THIS IS A TEST TO SEE IF SVN UPDATES WORK--- TEST2
public class ParserDemo {
	
	
	public static void main(String[] args){
		
		System.out.println("Running AcceptanceTestParser.");
		
		AcceptanceTestParser  parser= new AcceptanceTestParser();
	
		parser.executeTest(args[0]);
	}
}
