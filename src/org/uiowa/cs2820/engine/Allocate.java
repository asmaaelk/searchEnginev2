package org.uiowa.cs2820.engine;

import java.util.BitSet;
//andrew hoch
//0 free
//1 used

public class Allocate{
	private static BitSet theBitSet = new BitSet();
	
	public static int allocate(){
		int firstzero =  theBitSet.nextClearBit(0);
		return firstzero;
	}
	
	public static void allocate(int area){
		theBitSet.set(area);
		
	}
	public static void free(int area){
		theBitSet.clear(area);
		return;
	}
}
