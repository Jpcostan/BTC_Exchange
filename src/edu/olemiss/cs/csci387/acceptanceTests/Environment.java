package edu.olemiss.cs.csci387.acceptanceTests;

import java.util.Hashtable;

public class Environment {
	
	
	Hashtable<String, Object> e;
	
	Environment(){
		
		e = new Hashtable<String, Object>();
	}

	public Object lookup(String name){
		
		return e.get(name);
	}
	
	
	public void set(String name, Object o){
		
		e.put(name, o);
	}
	
}
