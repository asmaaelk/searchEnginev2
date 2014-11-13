package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

public class DiskSpace {
	RandomAccessFile someFile;
	public DiskSpace(String filePath) throws FileNotFoundException{
		if (!file.exists()) {
			file.createNewFile()//Lets be sure we even have a file :)
			System.out.println("file created");
		}
		this.someFile = new RandomAccessFile(filePath, "rw");
	}

	public byte[] read( long area ) throws IOException{
	/*Basic read() from file; uses */		
		byte[] bytes = new byte[DiskSpace.getFileSize()];
		someFile.seek( area*1024 ); //What if this is to big?
		someFile.readFully( bytes );
		someFile.close();
		return bytes;
		
	}

	public static void write(Object O, long area) throws IOException{
		//someFile declared above
		someFile.seek( getFileSize() );
		someFile.write( o.getBytes() ); //We have a getBytes() method somewhere, righ?!
/* 
  *The object is what we are writing to file. 
 * Is there a getBytes method that works here?
 */ 
		someFile.close();

	}
	//End write
	
	public static int getFileSize() {
		int fileSize = (int) file.length();
		return fileSize;
	}
}//End DiskSpace()
