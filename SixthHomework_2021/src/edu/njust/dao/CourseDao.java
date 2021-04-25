package edu.njust.dao;

import java.util.Date;
import java.util.Vector;

import edu.njust.entity.*;
import edu.njust.utils.*;

import java.sql.*;
import javax.sql.*;

public class CourseDao {
	
	public CourseDao(){
		
	}	
	
	public CourseDao(Course course) {
		// TODO Auto-generated constructor stub
	}	

	public boolean addCourse(Course course){ 
		boolean isSuc = false;
		Connection conn =null;
		PreparedStatement ps= null;
		int rows = 0;
		String sql = "insert into courses (name,creator,cdate) values (?,?,?)";
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     ps = conn.prepareStatement(sql);
		     ps.setString(1, course.getName());
		     ps.setString(2, course.getCreator());
		     ps.setTimestamp(3, new Timestamp(course.getCreateDate().getTime()));
		     rows = ps.executeUpdate();
		     if(rows > 0){
		    	 isSuc = true; 
		     }		     		     
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, ps, null);	
		return isSuc;
	}
	
	public boolean findByCourseName(Course course){
		boolean isSuc = false;
		Connection conn =null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		String sql = "select count(*) from courses where name = ?";
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     ps = conn.prepareStatement(sql);
		     ps.setString(1, course.getName());
		     rs = ps.executeQuery();
		     while(rs.next()){
		    	 if(rs.getInt(1)>0){
		    		 isSuc = true;  
		    	 }
		     }	     		     
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, ps, rs);	
		return isSuc;
	}
	
	public Course findByCourseName(String name){
		Course course = null;
		Connection conn =null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		String sql = "select name,creator,cdate from courses where name = ?";
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     ps = conn.prepareStatement(sql);
		     ps.setString(1, name);
		     rs = ps.executeQuery();
		     while(rs.next()){
		    	 course = new Course(rs.getString(1),rs.getString(2),rs.getTimestamp(3));
		     }	     		     
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, ps, rs);	
		return course;
	}
	
	public Vector<Course> findAllCourses(){
		Connection conn =null;
		Statement stmt= null;
		ResultSet rs = null;
		Vector<Course> vecCur = new Vector<Course>();
		Course course = null;
		String sql = "select name,creator,cdate from courses";
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     stmt = conn.createStatement();
		     rs = stmt.executeQuery(sql);
		     while(rs.next()){
		    	course = new Course(rs.getString(1),rs.getString(2),rs.getTimestamp(3));
		    	vecCur.add(course);
		     }	     		     
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, stmt, rs);	
		return vecCur;
	}	
	
	public boolean delCourse(Course course){
		boolean isSuc = false;
		Connection conn =null;
		PreparedStatement ps= null;
		int rows = 0;
		String sql = "delete from courses where name = ?";
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     ps = conn.prepareStatement(sql);
		     ps.setString(1, course.getName());
		     rows = ps.executeUpdate();
		     if(rows > 0){
		    	 isSuc = true; 
		     }		     		     
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, ps, null);	
		return isSuc;
	}
	
	public boolean modifyCourse(Course course){
		boolean isSuc = false;
		Connection conn =null;
		PreparedStatement ps= null;
		int rows = 0;
		String sql = "update courses set creator = ?,cdate= ? where name = ?";
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     ps = conn.prepareStatement(sql);
		     ps.setString(1, course.getCreator());
		     ps.setTimestamp(2,new Timestamp(course.getCreateDate().getTime()) );
		     ps.setString(3, course.getName());		     
		     rows = ps.executeUpdate();
		     if(rows > 0){
		    	 isSuc = true; 
		     }		     		     
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, ps, null);	
		return isSuc;
	}
	


	public static void main(String[] args) { // 将所有方法做一个简单的单元测试
		// TODO Auto-generated method stub
		CourseDao dao = new CourseDao();
		boolean flag = false;
		//1.测试添加课程
		Course course = new Course("软件课程设计II","njust-SE",new Date());	
		if(!dao.findByCourseName(course)){
			flag = dao.addCourse(course);
			if(flag){
				System.out.println("课程添加成功");
			}else {
			    System.out.println("课程添加失败");
			}
		}else {
			System.out.println("该课程已经存在");
		}
		
		
		//2.查询所有课程
		Vector<Course> vecCur = dao.findAllCourses();
		if(vecCur != null){
			int size = vecCur.size();
			while (size> 0){
				course =(Course) vecCur.get(size-1);
				if(course != null){
					System.out.println(course.getName()+"   "+course.getCreator()+"   "+course.getCreateDate());				  
				}
				size = size -1;
			}
		}
		
		// 3.删除指定的课程
		course = new Course("软件课程设计III",null,null);
		if(dao.delCourse(course)){
			System.out.println("课程删除成功: "+ course.getName());
		}else {
			System.out.println("课程删除失败: "+ course.getName());
		}
		
		// 4.修改指定的课程 by name
		course = new Course("软件课程设计II","njust-cs-seer",new Date());
		if(dao.modifyCourse(course)){
			System.out.println("课程修改成功: "+ course.getName()+" "+course.getCreator());
		}else {
			System.out.println("课程修改失败: "+ course.getName()+" "+course.getCreator());
		}
	
		// 验证操作后的结果是否正确
		int size = vecCur.size();
		while (size> 0){
			course =(Course) vecCur.get(size-1);
			if(course != null){
				System.out.println(course.getName()+"   "+course.getCreator()+"   "+course.getCreateDate());
			}
			size = size -1;
		}	

	}

}
