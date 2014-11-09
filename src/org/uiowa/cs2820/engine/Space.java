package org.uiowa.cs2820.engine;

public interface Space {
	public Object read(int id);
	public void write(int id, Object o);
}