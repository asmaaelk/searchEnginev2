/*Credit:
    http://examples.javacodegeeks.com/core-java/io/randomaccessfile/java-randomaccessfile-example/
 
 RandomAccessFile.readFully() method docs:
   http://www.tutorialspoint.com/java/io/randomaccessfile_readfully_byte.htm
*/
package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

/*
This is a working IMPLEMENTATION from link provided at top. 
To implement, change the filepath as needed.

Food for thought.
*/

	/*
Previous implementation of read:

	private static byte[] readFromFile(String filePath, int position, int size) throws IOException {
	private static byte[] read(long area) throws IOException{
		
		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
		file.seek(position);
		byte[] bytes = new byte[size];
		file.read(bytes);
		file.close();
		return bytes;

	}//End read
	*/
	
public class RandomAccessFileEx {
	private static File file;
	private static String filePath;

	private static byte[] read(long area) throws IOException{
		
		RandomAccessFile randFile = new RandomAccessFile(filePath, "r"); //Constructor: What to read
		byte[] bytes = new byte[DiskSpace.getFileSize()];                //How much to read
		randFile.seek(area);                                             //Searching
		randFile.readFully(bytes);                                       //Reads up to 'bytes'
		randFile.close();                                                //Close file
		return bytes;                                                    //So we know where to write!
		
	}

	private static void writeToFile(String filePath, String data, int position)
			throws IOException {

		RandomAccessFile file = new RandomAccessFile(filePath, "rw"); //Same as above, but with write option
		file.seek(position);
		file.write(data.getBytes());
		file.close();

	}
	//End write
	
	public static int getFileSize() {
		int fileSize = (int) file.length();
		return fileSize;
	}
}//End DiskSpace()
