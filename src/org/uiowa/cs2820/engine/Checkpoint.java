package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



//andrew hoch

public class Checkpoint {

    public static void save(Object obj) throws IOException{
    	byte[] buffer = Field.convert(obj);
    	Files.write(Paths.get("target-file"), buffer);
    	
    	
    }
    public static Object restore(String filename) throws IOException{
    	Path path = Paths.get(filename);
    	byte [] buffer = Files.readAllBytes(path);
    	Object theobject = Field.revert(buffer);
    	return theobject;
    }
}
