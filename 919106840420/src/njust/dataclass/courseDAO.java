package njust.dataclass;

import java.sql.*;
import java.sql.Date;

import javax.sql.*;

import org.eclipse.jdt.internal.compiler.batch.Main;

import njust.utils.DBUtil;
import sun.util.resources.LocaleData;

import java.util.*;

public class courseDAO {
	
	//List<course> courses ;
	
	public course getCourse(int cid) {
		
		List<Map<String, Object>> lsitMaps = null ;
		
		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put("id",cid);
        try {
        	lsitMaps = DBUtil.query("course", whereMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        course testcourse = null;
        if(!lsitMaps.isEmpty())
        {
        	testcourse=new course();
        	testcourse.setId(cid);
        	testcourse.setName((String)lsitMaps.get(0).get("name"));
        	testcourse.setNewdate(lsitMaps.get(0).get("newdate").toString());
        	testcourse.setNewtime(lsitMaps.get(0).get("newtime").toString());
        	testcourse.setTitle((String)lsitMaps.get(0).get("title"));
        	testcourse.setUserid((String)lsitMaps.get(0).get("userid"));
        }
		return testcourse;
		
//		   Connection conn =null;
//		   Statement stmt = null;
//		   ResultSet rs = null;
//		   course cour = null;
//		   
//		   String sql = "select * from course where id="+cid;
//		   try{
//			     conn = SimpleJDBCUtils.getConnection();
//			     stmt = conn.createStatement();
//			     rs = stmt.executeQuery(sql);
//			     while(rs.next()){
//			    	 cour = new course();
//			    	 cour.setId(rs.getInt(1));
//			    	 cour.setTitle(rs.getString(2));
//			    	 cour.setUserid(rs.getString(3));
//			    	 cour.setName(rs.getString(4));
//			    	 cour.setNewdate(rs.getString(5));
//			    	 cour.setNewtime(rs.getString(6));
//			     }
//			   }catch(SQLException e){
//				   e.printStackTrace();
//				   return null;
//			   }catch(Exception e){
//				   e.printStackTrace();
//			   }
//		   return cour;
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
	public int getCount(String id){
		   Connection conn =null;
		   Statement stmt = null;
		   ResultSet rs = null;
		   int rows = -1;
		   String sql = "select count(*) from course where userid = "+id;
		   int count = -1;
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(sql);
			     while(rs.next()){
			    	 count = rs.getInt(1);
			     }
			     
			   }catch(SQLException e){
				   e.printStackTrace();
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   SimpleJDBCUtils.release(conn, stmt, rs);
		return count;
	}
	
	public int getCount(){
		   Connection conn =null;
		   Statement stmt = null;
		   ResultSet rs = null;
		   int rows = -1;
		   String sql = "select count(*) from course ";
		   int count = -1;
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(sql);
			     while(rs.next()){
			    	 count = rs.getInt(1);
			     }
			     
			   }catch(SQLException e){
				   e.printStackTrace();
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   SimpleJDBCUtils.release(conn, stmt, rs);
		return count;
	}
	
	//???????? currentPage ?????? ??pageSize ????????????
	public List<course> getCourseByPage(int currentPage,int pageSize){
		String sql = "select * from course limit ?,?";

		Object[] bindArgs = {(currentPage-1)*pageSize,pageSize};
		try{
		
			List<Map<String, Object>> rs = DBUtil.executeQuery(sql, bindArgs);
			List<course> cour = new ArrayList<course>();
			if(!rs.isEmpty())
			{
				int size = rs.size();
				int index = 0;
				while(index < size)
				{
					course tempCourse=new course();
					tempCourse.setId((int)rs.get(index).get("id"));
					tempCourse.setName((String)rs.get(index).get("name"));
					tempCourse.setNewdate(rs.get(index).get("newdate").toString());
					tempCourse.setNewtime(rs.get(index).get("newtime").toString());
					tempCourse.setTitle((String)rs.get(index).get("title"));
					tempCourse.setUserid((String)rs.get(index).get("userid"));
					cour.add(tempCourse);
					index++;
				}
				return cour;
			
			}
			}catch(SQLException e){
			   e.printStackTrace();
			}catch(Exception e){
			   e.printStackTrace();
			}
		return null;
	}
	
//	public static void main(String args[]){
//		courseDAO testCourseDAO = new courseDAO();
//		List<course> cour = testCourseDAO.getCourseByPage(1, 5);
//		if(!cour.isEmpty())
//		{
//			int size = cour.size();
//			int index = 0;
//			while(index<size)
//			{
//				System.out.println(cour.get(index).getTitle());
//				index++;
//			}
//		}}
//		System.out.println(testCourseDAO.getCount());
//		courseDAO testCourseDAO = new courseDAO();
//		course testCourse = testCourseDAO.getCourse(1);
//		System.out.println(testCourse.getId());
//		System.out.println(testCourse.getName());
//		System.out.println(testCourse.getNewdate());
//		System.out.println(testCourse.getNewtime());
//		System.out.println(testCourse.getTitle());
//		System.out.println(testCourse.getUserid());
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
