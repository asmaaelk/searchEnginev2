package org.uiowa.cs2820.engine;

import java.io.Serializable;

public class KeyNode implements Serializable{
	protected Field key;
	public int addr;
	public int prev;
	public int next;
	public int value;
	
	KeyNode(Field f){
		this(f,-1,-1,-1);
	}
	KeyNode(Field f, int p, int n){
		this(f,p,n,-1);
	}
	KeyNode(Field f, int p, int n, int v){
		addr = -1;
		key = f;
		prev = p;
		next = n;
		value = v;
	}
	
	public boolean match(Field f){
		return key.equals(f);
	}
	
	public Field getKey(){
		return key;
	}
	
	public ValueStorage getValueStorage(){
		return new ValueStorage(value);
	}
}