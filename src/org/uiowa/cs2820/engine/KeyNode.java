package org.uiowa.cs2820.engine;

public class KeyNode {
	protected Field key;
	public int prev;
	public int next;
	public int value;
	
	KeyNode(Field f){
		this(f,-1,-1,-1);
	}
	KeyNode(Field f, int p, int n, int v){
		key = f;
		prev = p;
		next = n;
		value = v;
	}
	
	public boolean match(Field f){
		return key.getFieldName().equals(f.getFieldName()) && key.getFieldValue().equals(f.getFieldValue());
	}
	
	public Field getKey(){
		return key;
	}
}