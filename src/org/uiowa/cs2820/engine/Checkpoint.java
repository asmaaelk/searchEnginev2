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
    	if (file.exists() == false){file = new File("checkpoint_file");}
    	byte[] buffer = Field.convert(obj);    	
    	FileOutputStream f = new FileOutputStream(file);
    	f.write(buffer);
		f.close();    	
    }
    
    public static Object restore() throws IOException, FileNotFoundException{    	
    	if (file.exists() == false) {file = new File("checkpoint_file");}    	
    	FileInputStream f = new FileInputStream(file);
    	byte[] buffer = new byte[(int) file.length()];
    	f.read(buffer);
    	f.close();
    	Object theobject = Field.revert(buffer);
    	return theobject;
    }

}
