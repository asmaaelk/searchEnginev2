package org.uiowa.cs2820.engine;
//andrew hoch

public class checkpoint {
    public static byte[] save(Object obj)  {    	
        return Field.convert(obj);
    }

    public static Object restore(byte[] bytes)  {
        return Field.revert(bytes);
    }
}
