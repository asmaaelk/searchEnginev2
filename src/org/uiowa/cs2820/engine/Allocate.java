package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.BitSet;
//andrew hoch
//0 free
//1 used

public class Allocate{
	private static BitSet theBitSet = new BitSet();
	
	
	public static int allocate() throws IOException{
		int firstzero =  theBitSet.nextClearBit(0);		
		return firstzero;
	}
	
	public static void allocate(int area) throws IOException{
		theBitSet.set(area);
		
		
		
	}
	public static void free(int area) throws IOException{
		theBitSet.clear(area);
		
	}
	
	//methods used in testing
	public static boolean getValue(int arg0){
		return theBitSet.get(arg0);
	}	
	public static void setBit(int arg0, boolean value){
		theBitSet.set(arg0, value);
	}
}
