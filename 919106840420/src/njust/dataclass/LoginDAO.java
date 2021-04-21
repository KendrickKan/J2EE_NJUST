package njust.dataclass;

import java.sql.*;

import javax.sql.*;

import org.eclipse.jdt.internal.compiler.batch.Main;

import java.util.*;


public class LoginDAO {

	public Login getLogin(String id) {
		   Connection conn =null;
		   Statement stmt = null;
		   ResultSet rs = null;
		   Login login = null;
		   
		   String sql = "select * from user where userid="+id;
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(sql);
			     while(rs.next()){
			    	 login = new Login();
			    	 login.setUserid(rs.getString(1));
			    	 login.setName(rs.getString(2));
			    	 login.setPassword(rs.getString(3));
//			    	 System.out.println(rs.getString(1));
//			    	 System.out.println(rs.getString(2));
//			    	 System.out.println(rs.getString(3));
			     }
			   }catch(SQLException e){
				   e.printStackTrace();
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   return login;
	}
	public boolean addLogin(Login log) {
		   Connection conn =null;
		   Statement stmt = null;
		   int rows = -1;
		   String sql = "insert into user values('"+log.getUserid() + "','"+log.getName()
				                        +"','"+log.getPassword() +"');";
		   System.out.println(sql);
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     stmt = conn.createStatement();
		     Login tmp = this.getLogin(log.getUserid());
		     if(tmp == null){
		       rows = stmt.executeUpdate(sql);
		     }
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, stmt, null);
		   if(rows > 0){
			   return true;
		   }else {
			   return false;
		   }	
	}
//	public static void main(String[] args) {
//		LoginDAO testDao = new LoginDAO();
//		testDao.getLogin("919106840420");
//		Login testLogin = new Login();
//		testLogin.setName("����");
//		testLogin.setUserid("919106840425");
//		testLogin.setPassword("123456");
//		System.out.println(testDao.addLogin(testLogin));
//	}
}