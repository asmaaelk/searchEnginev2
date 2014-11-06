package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class KeyStorage {
	protected int size;
	
	public KeyStorage(){}
	
	public KeyNode add(Field f){}
	public KeyNode find(Field f){}
	public KeyNode key(Field f){}
	public KeyNode delete(Field f){}
	public ArrayList<Field> getKeys(){}
	
	public int size(){
		return size;
	}
}
