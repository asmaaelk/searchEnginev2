package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class LinearFileDatabaseTest {
	LinearFileDatabase d;
	Field k1 = new Field("someField1", "someValue1");
	Field k2 = new Field("someField2", "someValue2");
	Field k3 = new Field("someField3", "someValue3");

	@Before
	public void before() throws IOException {
		d = new LinearFileDatabase();
	}

	@Test
	public void testStore() throws IOException {
		d.store(k1,"doc1");
		d.store(k1,"doc2");
		d.store(k1,"doc3");
		d.store(k2,"doc1");
		d.store(k2,"doc3");
		d.store(k3,"doc2");
		
		ArrayList<String> ids1 = d.fetch(k1);
		assertEquals(3,ids1.size());
		assertTrue(ids1.contains("doc1"));
		assertTrue(ids1.contains("doc2"));
		assertTrue(ids1.contains("doc3"));
		
		ArrayList<String> ids2 = d.fetch(k2);
		assertEquals(2,ids1.size());
		assertTrue(ids2.contains("doc1"));
		assertTrue(ids2.contains("doc3"));
		
		ArrayList<String> ids3 = d.fetch(k3);
		assertEquals(1,ids1.size());
		assertTrue(ids3.contains("doc2"));
	}
	
//	@Test
//	public void testDelete() throws IOException{}

}
