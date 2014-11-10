package org.uiowa.cs2820.engine;

import java.util.*;

public class ValueStorage implements Value throws IOException {
	
	public static int head;
	public static int size;
	
	public String identifier;
	public static long tail;
	
	
	
	public ArrayList<String> load(int id) {
		ArrayList<String> nL = new ArrayList<String>();
		byte[] fileName = DiskSpace.readFromFile(id);
		return nL;
	}

	public void add(String identifier, Node n) throws {
		n.valHead = Allocate.allocate();
		this.identifier = identifier;
		DiskSpace.write(this, 25);
	}
	
	public void delete(String identifier) {
		
	}
	public void delete() {
		
	}

}
