package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



//andrew hoch

public class checkpoint {
    //public static byte[] save(Object obj)  {    	
        //return Field.convert(obj);
    //}

    //public static Object restore(byte[] bytes)  {
        //return Field.revert(bytes);
    //}
    public static void save(Object obj) throws IOException{
    	byte[] theArray = Field.convert(obj);
    	Files.write(Paths.get("target-file"), theArray);
    	
    	
    }
    public static Object restore(String filename) throws IOException{
    	Path path = Paths.get(filename);
    	byte [] theArray = Files.readAllBytes(path);
    	Object theobject = Field.revert(theArray);
    	return theobject;
    }

}
