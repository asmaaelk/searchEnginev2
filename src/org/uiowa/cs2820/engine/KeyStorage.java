package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.ArrayList;

public class KeyStorage {
	
	public KeyStorage() throws IOException{
		KeyNode zero = read(0);
		if(zero == null){
			Allocate.allocate(0);
			DiskSpace.write(new KeyNode(null), 0);
		}
	}
	
	protected KeyNode read(int area) throws IOException{
		if(area == -1)
			// Returns a dummy node that eases programming later
			return new KeyNode(null);
		
		return (KeyNode)DiskSpace.read(area);
	}
	
	protected void write(KeyNode node, int area) throws IOException{
		if(area == -1)
			// Writing a dummy node, do nothing
			return;
		
		node.addr = area;
		DiskSpace.write(node,area);
	}
	protected void write(ValueNode node, int area) throws IOException{
		if(area == -1)
			// Writing a dummy node, do nothing
			return;
		
		node.addr = area;
		DiskSpace.write(node,area);
	}
	
	public KeyNode add(Field f) throws IOException{return add(f,null);} // For backward compatibility	
	public KeyNode add(Field f, String id) throws IOException{
		if(f == null) throw new IllegalArgumentException("KeyNode.add(): field cannot be null");
		
		KeyNode zero = read(0);
		KeyNode one = read(zero.next);
		
		KeyNode node = new KeyNode(f,0,zero.next);
		int addr = Allocate.allocate();
		ValueNode vnode = new ValueNode(id);
		int addr2 = Allocate.allocate();
		node.value = addr2;
		write(vnode, addr2);
		write(node, addr);
		
		one.prev = addr;
		write(one, one.addr);
		zero.next = addr;
		write(zero, 0);
		
		return node;
	}
	
	public KeyNode find(Field f) throws IOException{
		if(f == null) throw new IllegalArgumentException("KeyNode.find(): field cannot be null");
		
		KeyNode temp = read(0);
		
		while(temp.next != -1){
			temp = read(temp.next);
			if(temp.match(f)) return temp;
		}
		
		return null;
	}
	
	public KeyNode key(Field f) throws IOException{return key(f,null);} // For backward compatibility
	public KeyNode key(Field f, String id) throws IOException{
		if(f == null) throw new IllegalArgumentException("KeyNode.key(): field cannot be null");
		
		KeyNode node = find(f);
		if(node == null) return add(f,id);
		else return node;
	}
	
	public void delete(Field f) throws IOException{
		if(f == null) throw new IllegalArgumentException("KeyNode.delete(): field cannot be null");
		
		KeyNode node = find(f);
		if(node == null) return;
		
		KeyNode prev = read(node.prev);
		KeyNode next = read(node.next);
		
		prev.next = node.next;
		next.prev = node.prev;
		write(prev, node.prev);
		write(next, node.next);
		
		Allocate.free(node.addr);
	}
	
	public ArrayList<Field> getKeys() throws IOException{
		KeyNode temp = read(0);
		ArrayList<Field> keys = new ArrayList<Field>();
		
		while(temp.next != -1){
			temp = read(temp.next);
			keys.add(temp.key);
		}
		
		return keys;
	}
}
