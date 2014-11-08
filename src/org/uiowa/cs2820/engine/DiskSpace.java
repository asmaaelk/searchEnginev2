/*SOURCE:
    http://examples.javacodegeeks.com/core-java/io/randomaccessfile/java-randomaccessfile-example/
*/
package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx {
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

	private static byte[] readFromFile(String filePath, int position, int size)
			throws IOException {

		RandomAccessFile file = new RandomAccessFile(filePath, "r");
		file.seek(position);
		byte[] bytes = new byte[size];
		file.read(bytes);
		file.close();
		return bytes;

	}//End read

	private static void writeToFile(String filePath, String data, int position)
			throws IOException {

		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
		file.seek(position);
		file.write(data.getBytes());
		file.close();

	}//End write
}//End DiskSpace()
