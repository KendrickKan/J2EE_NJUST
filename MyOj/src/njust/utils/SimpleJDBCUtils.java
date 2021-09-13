package njust.utils;

import java.io.*;
import java.sql.*;

import javax.sql.*;

import java.util.*;

public class SimpleJDBCUtils {
	private static String  driver = null;
    private static String  url = null;
    private static String  username = null;
    private static String password = null;

    static {
        try {
            //��ȡ�����ļ��Ķ�����
            InputStream is = SimpleJDBCUtils.class.getClassLoader().getResourceAsStream("/db.properties");
            // ��1�� "/db.properties" ����src��Ŀ¼��
            // ��2��  "db.properties" ������SimpleJDBCUtilsͬһĿ¼��
            // ��3�� "/WEB-INF/db.properties" ����web-inf�£�
            /*
             * ServletContext context=request.getServletContext();
             * InputStream is=context.getResourceAsStream("/WEB-INF/db.properties");
             */
            Properties properties = new Properties();
            
            if(is!=null){
               properties.load(is);
               System.out.println("here");
               //��ȡ�����ļ�����Ϣ
               driver = properties.getProperty("driver");            
               url = properties.getProperty("url");
               username = properties.getProperty("username");
               password = properties.getProperty("password");
            }else {
            	driver = "org.postgresql.Driver";            
                url = "jdbc:postgresql://124.70.8.112:26000/myoj";
                username = "lkl";
                password = "9191062301LKL#";
            }  

            //����������
            Class.forName(driver);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    
    public static void release(Connection connection,
    		               Statement statement, ResultSet resultSet) {
        
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }	

	public SimpleJDBCUtils() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleJDBCUtils jdbc = new SimpleJDBCUtils();
		Connection conn = null;
		try{
		  conn = jdbc.getConnection();
		  System.out.println(conn);
		}catch(Exception e){
			e.printStackTrace();
		}
		jdbc.release(conn,null,null);	

	}

}