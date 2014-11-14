package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class AllocateTest {

	@Test
	public void testAllocate() throws IOException {
		Allocate.allocate();
		Allocate.allocate();
		assertEquals(Allocate.allocate(), 2);
		assertEquals(Allocate.getValue(2),true);
	}

	@Test
	public void testAllocateInt() throws IOException {		
		
		Allocate.setBit(0, false);
		assertEquals(Allocate.getValue(0), false);
		
		Allocate.allocate(0);
		assertEquals(Allocate.getValue(0), true);
	}

	@Test
	public void testFree() throws IOException {		
		
		
		Allocate.setBit(0, true);
		assertEquals(Allocate.getValue(0), true);
		
		Allocate.free(0);
		assertEquals(Allocate.getValue(0), false);		
	}

}
