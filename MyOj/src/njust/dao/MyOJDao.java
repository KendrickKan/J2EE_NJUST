package njust.dao;

import njust.utils.*;

import java.sql.*;

import javax.sql.*;
import java.util.*;

import org.eclipse.jdt.internal.compiler.batch.Main;

public class MyOJDao {

	public String getPassword(String id){
		   Connection conn =null;
		   Statement stmt = null;
		   ResultSet rs = null;
		   String ans = "";
		   
		   String sql = "select * from learner where pid="+id;
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(sql);
			     while(rs.next()){
			    	 ans = rs.getString(2);
			
//			    	 System.out.println(rs.getString(1));
//			    	 System.out.println(rs.getString(2));
//			    	 System.out.println(rs.getString(3));
			     }
			   }catch(SQLException e){
				   e.printStackTrace();
				   return null;
			   }catch(Exception e){
				   e.printStackTrace();
			   };
		   return ans;
	}
	

	public static void main(String[] args) {
		MyOJDao testDao = new MyOJDao();
		System.out.println(testDao.getPassword("919106840420"));
	}
}
