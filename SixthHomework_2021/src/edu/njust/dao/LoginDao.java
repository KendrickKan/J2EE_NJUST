package edu.njust.dao;

import java.util.*;

import edu.njust.entity.*;
import edu.njust.utils.*;

import java.sql.*;
import javax.sql.*;


public class LoginDao {
	public LoginDao(){
	
	}
	
	public int findByName(Login login){
		int result = 2; //用户不存在
		Connection conn =null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		String sql = "select name,pwd from users where name =?";
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     ps = conn.prepareStatement(sql);
		     ps.setString(1, login.getName());
		     rs = ps.executeQuery();
		     while(rs.next()){
		    	 result = 1; //用户存在
		    	 if(rs.getString(2).equals(login.getPwd())){
		    		 result = 0; //用户存在,密码正确
		    	 }		    	 
		     }		     
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, ps, rs);		
		return result;		
	}
	
	// do unit test here
	public static void main(String[] args) {
		LoginDao dao = new LoginDao();
		Login login = new Login("njust","j2ee");
		int result = dao.findByName(login);
		System.out.println("用户信息验证结果："+result);
	}    
}
