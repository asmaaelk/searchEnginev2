package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.ArrayList;

public class KeyStorage {	
	public KeyStorage(){}
	
	protected KeyNode read(int area){
		try{return (KeyNode)DiscSpace.read(area);}
		catch(IOException e){return null;}
	}
	protected KeyNode head(){return read(0);}
	
	public KeyNode add(Field f) throws IOException{
		KeyNode head = head();
		if(head == null){
			KeyNode node = new KeyNode(f);
			DiscSpace.write(0,node);
			return node;
		}else{
			KeyNode node = new KeyNode(f,0,head.next);
			int addr = DiscSpace.write(node);
			
			if(head.next != -1){
				KeyNode sec = read(head.next);
				if(sec == null) throw new IOException();
				sec.prev = addr;
				DiscSpace.write(head.next, sec);
			}
			
			head.next = addr;
			DiscSpace.write(0,head);
			
			return node;
		}
	}
	public KeyNode find(Field f){return null;}
	public KeyNode key(Field f){return null;}
	public KeyNode delete(Field f){return null;}
	
	public ArrayList<Field> getKeys() throws IOException{
		KeyNode temp = head();
		ArrayList<Field> keys = new ArrayList<Field>();
		
		if(temp == null) return keys;
		while(true){
			keys.add(temp.getKey());
			if(temp.next == -1) return keys;
			temp = read(temp.next);
			if(temp == null) throw new IOException();
		}
	}
}
