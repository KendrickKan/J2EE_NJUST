package utils;

public class MyUTF {
	 
	//��װ�ɹ�����
	   public static String getNewString(String str) throws Exception
	    {
	       return new String(str.getBytes("ISO-8859-1"),"UTF-8");
	    }
}