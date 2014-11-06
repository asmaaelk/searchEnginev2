package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class KeyStorageTest {
	public KeyStorage ks;
	public Field f1 = new Field("someFieldName1","someFieldValue1");
	public Field f2 = new Field("someFieldName2","someFieldValue2");
	public Field f3 = new Field("someFieldName3","someFieldValue3");
	
	@Before
	public void before(){
		ks = new KeyStorage();
		assertEquals(0,ks.getKeys().size());
	}
	
	@After
	public void after(){
		ks.delete(f1);
		ks.delete(f2);
		ks.delete(f3);
	}
	
	@Test
	public void testAdd(){
		ks.add(f1);
		ks.add(f2);
		ks.add(f3);
		
		ArrayList<Field> keys = ks.getKeys();
		
		assertEquals(3,keys.size());
		assertTrue(keys.contains(f1));
		assertTrue(keys.contains(f2));
		assertTrue(keys.contains(f3));
	}
	
	@Test
	public void testFind(){
		ks.add(f1);
		assertNotNull(ks.find(f1));
		assertNull(ks.find(f2));
		assertEquals(1,ks.getKeys().size());
	}
	
	@Test
	public void testKey(){
		ks.add(f1);
		assertNotNull(ks.key(f1));
		assertNotNull(ks.key(f2));
		assertEquals(2,ks.getKeys().size());
	}
	
	@Test
	public void testDelete(){
		ks.add(f1);
		ks.add(f2);
		ks.add(f3);
		assertEquals(3,ks.getKeys().size());
		
		ks.delete(f1);
		assertEquals(2,ks.getKeys().size());
		assertNull   (ks.find(f1));
		assertNotNull(ks.find(f2));
		assertNotNull(ks.find(f3));
		
		ks.delete(f3);
		assertEquals(1,ks.getKeys().size());
		assertNull   (ks.find(f1));
		assertNotNull(ks.find(f2));
		assertNull   (ks.find(f3));
	}
	
	@Test
	public void testGetKeys(){
		ks.add(f1);
		ks.add(f3);
		
		ArrayList<Field> keys = ks.getKeys();
		assertEquals(3,keys.size());
		assertTrue (keys.contains(f1));
		assertFalse(keys.contains(f2));
		assertTrue (keys.contains(f3));
	}

}
