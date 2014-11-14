package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

public class ValueStorage implements Value{
	
	public static int head;
	public static int size;
	public String identifier;
	
	public ValueStorage(int h){head = h;}
	
	//returns a list of identifiers as an ArrayList of strings
	//associated with a field
	public ArrayList<String> load() throws IOException{
		ArrayList<String> nL = new ArrayList<String>();
		//KeyNode docName = DiskSpace.read(id);
		ValueNode temp = DiskSpace.read(head);
		while(temp.next != -1) {
			String tmp = temp.identifier;
			nL.add(tmp);
			temp = DiskSpace.read(temp.next);
		}
		for(int i = 0; i < nL.size(); i++)
		{
			System.out.println(nL.get(i));
		}
		return nL;
	}
	
	//add takes as input an identifier
	//creates a new value node
	//and adds it as a value node associated with a key node
	//also points to next node
	public void add(String identifier) throws IOException {
		//finds free space
		ValueNode n = new ValueNode(identifier);
		 //Allocate.allocate();
		ValueNode temp = DiskSpace.read(head);
		boolean addNode = true;
		while(temp.next != -1) {
			temp = DiskSpace.read(temp.next);
			//make sure we are not duplicating nodes
			if (temp.identifier == identifier) {
				addNode = false;
				break;
			}
		}
		if(addNode) {
			temp.next = Allocate.allocate();
			n.addr = temp.next;
			DiskSpace.write(n, temp.next);
			DiskSpace.write(temp, temp.addr);
		}
	}
}
