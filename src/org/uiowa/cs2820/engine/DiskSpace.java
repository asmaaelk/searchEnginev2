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
		
	}//End read

	public static void write(Object o, long area) throws IOException{
		//someFile declared above
		someFile.seek( getFileSize() );
		someFile.write( convert(o) );
		revert(o);
		someFile.close();
	}//End write

	public static Object revert(byte[] seq) {
		Object O = null; // default value
		try {
			ByteArrayInputStream M = new ByteArrayInputStream(seq);
			ObjectInputStream N = new ObjectInputStream(M);
			O = N.readObject();
		}
		catch (Exception e) { return null };//Shouldn't happen
		return O;
	}//End revert
	
	public static byte[] convert(Object O) {
	// private method converts objects into byte array
		ByteArrayOutputStream M = new ByteArrayOutputStream();
		ObjectOutput N = null;
		try {
			N = new ObjectOutputStream(M);
			N.writeObject(O);
		}
		catch (IOException e) {return null;} // wrong, but should not happen
		return M.toByteArray();
	}//End convert
	
	public static int getFileSize() {
		int fileSize = (int) file.length();
		return fileSize;
	}
}//End DiskSpace()
