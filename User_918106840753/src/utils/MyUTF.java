package utils;

public class MyUTF {
	 
	//封装成工具类
	   public static String getNewString(String str) throws Exception
	    {
	       return new String(str.getBytes("ISO-8859-1"),"UTF-8");
	    }
}