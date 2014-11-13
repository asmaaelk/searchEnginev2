package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.ArrayList;

public class LinearFileDatabase implements Database {
	protected KeyStorage ks;
	
	public LinearFileDatabase() throws IOException{
		ks = new KeyStorage();
	}

	public ArrayList<String> fetch(Field key) throws IOException {
		return ks.find(key).getValueStorage().load();
	}

	public void delete(Field key, String id) throws IOException {
		//ks.find(key).getValueStorage().delete(id);
	}

	public void store(Field key, String id) throws IOException {
		ks.key(key,id).getValueStorage().add(id);
	}

}
