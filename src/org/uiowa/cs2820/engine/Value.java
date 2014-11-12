package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

public interface Value {
	public void add(String identifier) throws IOException;
	public ArrayList<String> load(long id) throws IOException;
}
