package org.uiowa.cs2820.engine;

import java.util.*;

public interface Value {
	public void add(String identifier);
	public void delete(String identifier);
	public void delete();
	public void store(List<String> identifiers);
	public ArrayList<String> load();
}
