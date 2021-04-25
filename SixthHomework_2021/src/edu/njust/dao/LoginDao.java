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
		int result = 2; //�û�������
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
		    	 result = 1; //�û�����
		    	 if(rs.getString(2).equals(login.getPwd())){
		    		 result = 0; //�û�����,������ȷ
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
		System.out.println("�û���Ϣ��֤�����"+result);
	}    
}
