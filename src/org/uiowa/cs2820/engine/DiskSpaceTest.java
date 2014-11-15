package org.uiowa.cs2820.engine;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DiskSpaceTest {
 
	
	;
	
	@Test
	public void TestDiskSpace () throws IOException {
		String testee = "Object Oriented rox";
		DiskSpace disk = new DiskSpace("DiskSpace.txt");
		byte[] object = Utility.convert(testee);
		disk.writeByte(object,0);
		byte[] read = disk.readArea(0);
		String data =  (String) Utility.revert(read);
		assertEquals(A, data);
		
		
	}
}
