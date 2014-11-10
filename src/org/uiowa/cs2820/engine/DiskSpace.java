/*SOURCE:
    http://examples.javacodegeeks.com/core-java/io/randomaccessfile/java-randomaccessfile-example/
*/
package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

/*
This is a working IMPLEMENTATION from link provided at top. 
To implement, change the filepath as needed.

static final String FILEPATH = "C:/Users/USER_NAME/just_a_path/input.txt";
	public static void main(String[] args) {
		try {

			System.out.println(new String(readFromFile(FILEPATH, 150, 23)));

			writeToFile(FILEPATH, "Object-Oriented  Rocks!", 22);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}*/

public class RandomAccessFileEx {
	private static File file;
	private static String filePath;

	/*private static byte[] readFromFile(String filePath, int position, int size) throws IOException {
	private static byte[] read(long area) throws IOException{
		
		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
		file.seek(position);
		byte[] bytes = new byte[size];
		file.read(bytes);
		file.close();
		return bytes;

	}//End read*/
	private static byte[] read(long area) throws IOException{
		
		RandomAccessFile randFile = new RandomAccessFile(filePath, "rw");
		byte[] bytes = new byte[DiskSpace.getFileSize()];
		randFile.seek(area);
		randFile.readFully(bytes);
		randFile.close();
		return bytes;
		
	}

	private static void writeToFile(String filePath, String data, int position)
			throws IOException {

		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
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
