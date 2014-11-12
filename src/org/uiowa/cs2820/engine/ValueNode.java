package org.uiowa.cs2820.engine;

public class ValueNode {
	
	public String identifier;
	public int next;
	public int addr;
	
	public ValueNode(String id) {identifier = id; next = -1;}
	

}
