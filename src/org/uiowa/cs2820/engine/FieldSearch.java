package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.ArrayList;

public class FieldSearch {
	
  private Database D;
  
  FieldSearch(Database d) {
	this.D = d;  
    }
	
  public String[] findEquals(Field f) throws IOException {
	ArrayList<String> p = D.fetch(f);
	String[] R = new String[p.size()];
	R = p.toArray(R);
	return R;
    }
  }