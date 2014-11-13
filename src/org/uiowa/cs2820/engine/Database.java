package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.ArrayList;

public interface Database {
  public abstract ArrayList<String> fetch(Field key) throws IOException;  // fetch a Node by key
  public abstract void delete(Field key, String id) throws IOException;  // delete an id
  public abstract void store(Field key, String id) throws IOException; // store an id
  }
