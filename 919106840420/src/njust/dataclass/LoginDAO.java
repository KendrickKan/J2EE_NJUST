package njust.dataclass;

import java.sql.*;

import javax.sql.*;

import org.eclipse.jdt.internal.compiler.batch.Main;

import njust.utils.DBUtil;

import java.util.*;


public class LoginDAO {

	public Login getLogin(String id) {
		List<Map<String, Object>> lsitMaps = null ;
		
		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put("userid",id);
        try {
        	lsitMaps = DBUtil.query("user", whereMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        Login login = null;
        if(!lsitMaps.isEmpty())
        {
        	login = new Login();
        	login.setPassword((String)lsitMaps.get(0).get("password"));
        	login.setName((String)lsitMaps.get(0).get("name"));
        	login.setDepartment((String)lsitMaps.get(0).get("department"));
        	login.setUserid((String)lsitMaps.get(0).get("userid"));
        	login.setAcademy((String)lsitMaps.get(0).get("academy"));
        }
		return login;
//		   Connection conn =null;
//		   Statement stmt = null;
//		   ResultSet rs = null;
//		   Login login = null;
//		   
//		   String sql = "select * from user where userid="+id;
//		   try{
//			     conn = SimpleJDBCUtils.getConnection();
//			     stmt = conn.createStatement();
//			     rs = stmt.executeQuery(sql);
//			     while(rs.next()){
//			    	 login = new Login();
//			    	 login.setUserid(rs.getString(1));
//			    	 login.setName(rs.getString(2));
//			    	 login.setPassword(rs.getString(3));
//			    	 login.setAcademy(rs.getString(4));
//			    	 login.setDepartment(rs.getString(5));
////			    	 System.out.println(rs.getString(1));
////			    	 System.out.println(rs.getString(2));
////			    	 System.out.println(rs.getString(3));
//			     }
//			   }catch(SQLException e){
//				   e.printStackTrace();
//				   return null;
//			   }catch(Exception e){
//				   e.printStackTrace();
//			   }
//		   return login;
	}
	public boolean addLogin(Login log) {
		
		int rows = -1;
		Map<String, Object> map = new HashMap<>();    
		map.put("userid",log.getUserid());
		map.put("password",log.getPassword());
		map.put("name",log.getName());
		map.put("department",log.getDepartment());
		map.put("academy",log.getAcademy());
		try {
			rows = DBUtil.insert("user", map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		if(rows > 0){
		    return true;
	    }else {
		    return false;
	    }	
//		   Connection conn =null;
//		   Statement stmt = null;
//		   int rows = -1;
//		   String sql = "insert into user values('"+log.getUserid() + "','" + log.getName() +"','"+log.getPassword() + "','" + log.getAcademy() + "','" + log.getDepartment() + "');";
//		   //System.out.println(sql);
//		   try{
//		     conn = SimpleJDBCUtils.getConnection();
//		     stmt = conn.createStatement();
//		     Login tmp = this.getLogin(log.getUserid());
//		     if(tmp == null){
//		       rows = stmt.executeUpdate(sql);
//		     }
//		   }catch(SQLException e){
//			   e.printStackTrace();
//		   }catch(Exception e){
//			   e.printStackTrace();
//		   }
//		   SimpleJDBCUtils.release(conn, stmt, null);
//		   if(rows > 0){
//			   return true;
//		   }else {
//			   return false;
//		   }	
	}
//	public static void main(String[] args) {
//		LoginDAO testDao = new LoginDAO();
//		Login testlogin = null;
//		testlogin = testDao.getLogin("919106840420");
//		System.out.println(testlogin.getUserid());
//		System.out.println(testDao.getLogin("919106840421"));
//		LoginDAO testDao = new LoginDAO();
//		Login testLogin = new Login();
//		testLogin.setName("????2");
//		testLogin.setUserid("918106840420");
//		testLogin.setPassword("123456");
//		testLogin.setAcademy("????????????????????");
//		testLogin.setDepartment("??????????????");
//		System.out.println(testDao.addLogin(testLogin));
////		System.out.println(testDao.addLogin(testLogin));
//	}
}
