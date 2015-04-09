package edu.olemiss.cs.csci387;

public class Credentials {
	String username;
	int hashCode;
	
	public Credentials(String name, String password){
		username = name;
		hashCode = (name.hashCode() + password.hashCode());
	}
	
	public String getUsername(){
		return username;
	}
	
	@Override
	public int hashCode(){
		
		return hashCode;
	}
	
	@Override
	public boolean equals(Object c){
		
		return c.hashCode() == this.hashCode;
	}
	
}
