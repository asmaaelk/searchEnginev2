package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

public interface Value {
	public void add(String identifier, Node n) throws IOException;
	public void delete(String identifier);
	public void delete();
	public ArrayList<String> load(long id) throws IOException;
}
