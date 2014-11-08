package org.uiowa.cs2820.engine;

import java.util.BitSet;
//andrew hoch
//0 free
//1 used

public class Allocate{
	private BitSet theBitSet = new BitSet();
	
	public int allocate(){
		int firstzero =  theBitSet.nextClearBit(0);
		return firstzero;
	}
	
	public void allocate(int area){
		theBitSet.set(area);
		
	}
	public void free(int area){
		theBitSet.clear(area);
		return;
	}
}
