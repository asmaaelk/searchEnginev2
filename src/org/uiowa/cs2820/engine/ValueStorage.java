package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

public class ValueStorage implements Value{
	
	public static int head;
	public static int size;
	public String identifier;
	
	public ValueStorage(int h){head = h;}
	
	public ArrayList<String> load(long id) throws IOException{
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
	}

	public void add(String identifier) throws IOException {
		//finds free space
		ValueNode n = new ValueNode(identifier);
		 //Allocate.allocate();
		ValueNode temp = DiskSpace.read(head);
		while(temp.next != -1) {
			temp = DiskSpace.read(temp.next);
		}
		temp.next = Allocate.allocate();
		n.addr = temp.next;
		DiskSpace.write(n, temp.next);
		DiskSpace.write(temp, temp.addr);
	}
}
