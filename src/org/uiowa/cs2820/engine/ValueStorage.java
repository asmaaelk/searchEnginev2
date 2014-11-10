package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

public class ValueStorage implements Value{
	
	public static int head;
	public static int size;
	public String identifier;
	public static long tail;
	
	
	public ArrayList<String> load(long id) throws IOException{
		ArrayList<String> nL = new ArrayList<String>();
		byte[] fileName = DiskSpace.read(id);
		return nL;
	}

	public void add(String identifier, Node n) throws IOException {
		head = n.valHead;
		n.valHead = Allocate.allocate();
		this.identifier = identifier;
		DiskSpace.write(this, 25);
	}
	
	public void delete(String identifier) {
		
	}
	public void delete() {
		
	}

}
