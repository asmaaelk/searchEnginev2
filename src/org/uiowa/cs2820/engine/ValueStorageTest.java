package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class ValueStorageTest {
	
	public ValueStorage vs;
	
	@Test
	public void testValStor() throws IOException {
		vs = new ValueStorage(1);
		vs.add("six");
		vs.add("five");
		vs.add("six");
		vs.load();
		ArrayList<String> valList = vs.load();
		assertTrue(valList.contains("six"));
		assertTrue(valList.contains("five"));
		assertFalse(valList.contains("seven"));
		assertEquals(2,valList.size());

		
		
	}
		
	
	
	
	
	
	
	
	
	
	

}
