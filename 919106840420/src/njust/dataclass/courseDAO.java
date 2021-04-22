package njust.dataclass;

import java.sql.*;
import java.sql.Date;

import javax.sql.*;

import org.eclipse.jdt.internal.compiler.batch.Main;

import sun.util.resources.LocaleData;

import java.util.*;

public class courseDAO {
	
	//List<course> courses ;
	
	public course getCourse(int id) {
		   Connection conn =null;
		   Statement stmt = null;
		   ResultSet rs = null;
		   course cour = null;
		   
		   String sql = "select * from course where id="+id;
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(sql);
			     while(rs.next()){
			    	 cour = new course();
			    	 cour.setId(rs.getInt(1));
			    	 cour.setTitle(rs.getString(2));
			    	 cour.setUserid(rs.getString(3));
			    	 cour.setName(rs.getString(4));
			    	 cour.setNewdate(rs.getString(5));
			    	 cour.setNewtime(rs.getString(6));
			     }
			   }catch(SQLException e){
				   e.printStackTrace();
				   return null;
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   return cour;
	}
	
	public List<course> getAllCourse(String kid){
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		List<course> courses = new ArrayList<>();
		course tempCourse = null;
		String sql = "select * from course where userid="+kid;
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(sql);
			     while(rs.next()){
			    	 tempCourse = new course();
			    	 tempCourse.setId(rs.getInt(1));
			    	 //System.out.println(tempCourse.getId());
			    	 tempCourse.setTitle(rs.getString(2));
			    	 //System.out.println(tempCourse.getTitle());
			    	 tempCourse.setUserid(rs.getString(3));
			    	 //System.out.println(tempCourse.getUserid());
			    	 tempCourse.setName(rs.getString(4));
			    	 //System.out.println(tempCourse.getName());
			    	 tempCourse.setNewdate(rs.getString(5));
			    	 //System.out.println(tempCourse.getNewdate());
			    	 tempCourse.setNewtime(rs.getString(6));
			    	 //System.out.println(tempCourse.getNewtime());
			    	 courses.add(tempCourse);		    	 
			     }
			     
			   }catch(SQLException e){
				   e.printStackTrace();
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   SimpleJDBCUtils.release(conn, stmt, rs);
		return courses;
	}
	public boolean addCourse(course cour){
		   Connection conn =null;
		   Statement stmt = null;
		   int rows = -1;
		   String sql = "insert into course values('"+cour.getId() + "','" + cour.getTitle() +"','"+cour.getUserid() + "','" + cour.getName() + "','" + cour.getNewdate()+ "','" + cour.getNewtime() + "');";
		   //System.out.println(sql);
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     stmt = conn.createStatement();
		     course tmp = this.getCourse(cour.getId());
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
	public boolean deleteCourse(course cour){
		   Connection conn =null;
		   Statement stmt = null;
		   int rows = -1;
		   String sql = "delete from course where id="+cour.getId();
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rows = stmt.executeUpdate(sql);
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
	public boolean deleteCourse(int id){
		   Connection conn =null;
		   Statement stmt = null;
		   int rows = -1;
		   String sql = "delete from course where id="+id;
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rows = stmt.executeUpdate(sql);
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
	public int getMaxId(){
		   Connection conn =null;
		   Statement stmt = null;
		   ResultSet rs = null;
		   int rows = -1;
		   String sql = "select max(id) from course";
		   int tempmaxid=0;
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(sql);
			     while(rs.next()){
			    	 tempmaxid = rs.getInt(1);
			     }
			     
			   }catch(SQLException e){
				   e.printStackTrace();
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   SimpleJDBCUtils.release(conn, stmt, rs);
		return tempmaxid;
	}
//	public static void main(String args[]){
//		courseDAO testCourseDAO = new courseDAO();
//		System.out.println(testCourseDAO.getMaxId());
//		List<course> curList = testCourseDAO.getAllCourse("919106840420");
//		course cou = null;
//		if(!curList.isEmpty()){
//    		int size = curList.size();
//    		int index =0; //starting from 0
//    		 while (index < size){	      	    
//			    cou =(course) curList.get(index);
//		     	if(cou != null){
//		     		System.out.println(cou.getId());
//		     		System.out.println(cou.getTitle());
//		     		System.out.println(cou.getName());
//		     		System.out.println(cou.getNewdate());
//		     		System.out.println(cou.getNewtime());
//			    }
//			    index = index +1;
//		     }
//		}
//		testCourse.setId(3);
//		testCourse.setName("kkk");
//		testCourse.setNewdate("2021-12-21");
//		testCourse.setNewtime("15:13:01");
//		testCourse.setTitle("J2EE_Six");
//		testCourse.setUserid("919106840420");
//		testCourseDAO.addCourse(testCourse);
//		testCourseDAO.deleteCourse(testCourse);
//		testCourseDAO.deleteCourse(3);
//	}
}
