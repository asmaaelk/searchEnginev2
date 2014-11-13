package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

public class DiskSpace {
	RandomAccessFile someFile;
	public DiskSpace(String filePath) throws FileNotFoundException{
		this.someFile = new RandomAccessFile(filename, "rw");
	}

	public byte[] read(long area) throws IOException{
	/*Basic read() from file; uses */		
		byte[] bytes = new byte[DiskSpace.getFileSize()];
		someFile.seek(area*1024); //What if this is to big?
		someFile.readFully(bytes);
		someFile.close();
		return bytes;
		
	}

	public static void write(Object O, long area) throws IOException{
		//someFile declared above
		someFile.seek(getFileSize());
		someFile.write(o);//the object is what we are writing to file
		someFile.close();

	}
	//End write
	
	public static int getFileSize() {
		int fileSize = (int) file.length();
		return fileSize;
	}
}//End DiskSpace()
