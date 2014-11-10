/*SOURCE:
    http://examples.javacodegeeks.com/core-java/io/randomaccessfile/java-randomaccessfile-example/
*/
package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

/*
This is a working IMPLEMENTATION from link provided at top. 
To implement, change the filepath as needed.*/

public class DiskSpace {
	private static File file;
	private static String filePath;

	public static byte[] read(long area) throws IOException{
		
		RandomAccessFile randFile = new RandomAccessFile(filePath, "rw");
		byte[] bytes = new byte[DiskSpace.getFileSize()];
		randFile.seek(area*1024);
		randFile.readFully(bytes);
		randFile.close();
		return bytes;
		
	}

	public static void write(Object O, long area) throws IOException{
		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
		file.seek(area*1024);
		//file.write(data.getBytes());
		file.close();

	}
	//End write
	
	public static int getFileSize() {
		int fileSize = (int) file.length();
		return fileSize;
	}
}//End DiskSpace()
