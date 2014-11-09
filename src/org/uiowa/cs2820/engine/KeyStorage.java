package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.ArrayList;

public class KeyStorage {
	protected DiskSpace disk;
	
	public KeyStorage(){this("Database");}
	public KeyStorage(String filename){
		disk = new DiskSpace(filename);
	}
	
	protected KeyNode read(int area){
		try{return (KeyNode)disk.read(area);}
		catch(IOException e){return null;}
	}
	protected KeyNode head(){return read(0);}
	
	protected void write(int area, KeyNode node) throws IOException{
		if(node != null){
			node.addr = area;
			Allocate.allocate(area);
		}
		disk.write(area,node);
	}
	protected int write(KeyNode node) throws IOException{
		int addr = Allocate.allocate();
		write(addr,node);
		return addr;
	}
	
	public KeyNode add(Field f) throws IOException{
		KeyNode head = head();
		if(head == null){
			KeyNode node = new KeyNode(f);
			write(0,node);
			return node;
		}else{
			KeyNode node = new KeyNode(f,0,head.next);
			int addr = write(node);
			
			if(head.next != -1){
				KeyNode sec = read(head.next);
				if(sec == null) throw new IOException();
				sec.prev = addr;
				write(head.next, sec);
			}
			
			head.next = addr;
			write(0,head);
			
			return node;
		}
	}
	
	public KeyNode find(Field f) throws IOException{
		KeyNode temp = head();
		if(temp == null) return null;
		
		while(true){
			if(temp.match(f)) return temp;
			if(temp.next == -1) return null;
			temp = read(temp.next);
			if(temp == null) throw new IOException();
		}
	}
	
	public KeyNode key(Field f) throws IOException{
		KeyNode node = find(f);
		if(node == null) return add(f);
		else return node;
	}
	
	public void delete(Field f) throws IOException{
		KeyNode node = find(f);
		if(node == null) return;
		
		if(node.prev == -1){
			if(node.next == -1){
				write(0, null);
				return;
			}
			
			KeyNode sec = read(node.next);
			sec.prev = -1;
			write(0, sec);
			
			if(sec.next != -1){
				KeyNode thr = read(sec.next);
				thr.prev = 0;
				write(sec.next, thr);
			}
			return;
		}
		
		KeyNode prev = read(node.prev);
		if(prev == null) throw new IOException();
		prev.next = node.next;
		write(node.prev, prev);
		
		if(node.next != -1){
			KeyNode next = read(node.next);
			if(next == null) throw new IOException();
			next.prev = node.prev;
			write(node.next, next);
		}
		
		node.getValueStorage().delete();
		
		Allocate.free(node.addr);
	}
	
	public ArrayList<Field> getKeys() throws IOException{
		KeyNode temp = head();
		ArrayList<Field> keys = new ArrayList<Field>();
		
		if(temp == null) return keys;
		while(true){
			System.out.println(temp.addr);
			keys.add(temp.getKey());
			if(temp.next == -1) return keys;
			temp = read(temp.next);
			if(temp == null) throw new IOException();
		}
	}
}
