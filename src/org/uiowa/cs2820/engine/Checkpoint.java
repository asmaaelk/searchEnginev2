package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;





//andrew hoch

public class Checkpoint {	
	static File file = new File("checkpoint_file");
    public static void save(Object obj) throws IOException{
    	byte[] buffer = Field.convert(obj);    	
    	FileOutputStream f = new FileOutputStream(file);
    	f.write(buffer);
    	f.close();
    	
    	
    }
    public static Object restore() throws IOException{    	
    	FileInputStream f = new FileInputStream(file);
    	byte[] buffer = new byte[(int) file.length()];
    	f.read(buffer);
    	f.close();
    	Object theobject = Field.revert(buffer);
    	return theobject;
    }
}
