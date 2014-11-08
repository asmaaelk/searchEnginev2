package org.uiowa.cs2820.engine;

public interface Storage {
	public Object read(int id);
	public void write(int id, Object o);
}