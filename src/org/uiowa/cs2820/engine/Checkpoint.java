package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;





//andrew hoch

public class Checkpoint {	
	static File file;
    public static void save(Object obj) throws IOException, FileNotFoundException{
    	byte[] buffer = Field.convert(obj);
    	file = new File("checkpoint_file");    		
    	FileOutputStream fos = null;
    	try {    			
    		fos = new FileOutputStream(file);    			
    		fos.write(buffer);
    	}
    	catch (FileNotFoundException e) {
    		System.out.println("File not found" + e);
    	}
    	catch (IOException ioe) {
    		System.out.println("Exception while writing file " + ioe);
    	}
    	finally {
    		try {
    			if (fos != null) {
    				fos.close();
    			}
    		}
    		catch (IOException ioe) {
    			System.out.println("Error while closing stream: " + ioe);
    		}
    	}    	   	
    }
    
    public static Object restore() throws IOException, FileNotFoundException{    	
    	FileInputStream fis = null;
    	try{
	    	fis = new FileInputStream(file);
	    	byte[] buffer = new byte[(int) file.length()];
	    	fis.read(buffer);	    	
	    	Object theobject = Field.revert(buffer);
	    	return theobject;
    	}
    	catch (FileNotFoundException e) {
    		System.out.println("File not found" + e);
    	}
    	catch (IOException ioe) {
    		System.out.println("Exception while writing file " + ioe);
    	}
    	finally {
    		try {
    			if (fis != null) {
    				fis.close();
    			}
    		}
    		catch (IOException ioe) {
    			System.out.println("Error while closing stream: " + ioe);
    		}
    	}return 0;    	   	
    }    
}    
    
    		

    		
    	

    


