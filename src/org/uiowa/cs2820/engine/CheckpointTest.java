package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;


import org.junit.Test;

public class CheckpointTest {

	@Test
	public void testBoth() throws FileNotFoundException, IOException {
		
		Object a = "hello";
		Checkpoint.save(a);
		assertEquals(a,Checkpoint.restore());		
	}

}
