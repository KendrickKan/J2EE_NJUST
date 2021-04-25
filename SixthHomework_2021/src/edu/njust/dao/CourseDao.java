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
	


	public static void main(String[] args) { // �����з�����һ���򵥵ĵ�Ԫ����
		// TODO Auto-generated method stub
		CourseDao dao = new CourseDao();
		boolean flag = false;
		//1.������ӿγ�
		Course course = new Course("����γ����II","njust-SE",new Date());	
		if(!dao.findByCourseName(course)){
			flag = dao.addCourse(course);
			if(flag){
				System.out.println("�γ���ӳɹ�");
			}else {
			    System.out.println("�γ����ʧ��");
			}
		}else {
			System.out.println("�ÿγ��Ѿ�����");
		}
		
		
		//2.��ѯ���пγ�
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
		
		// 3.ɾ��ָ���Ŀγ�
		course = new Course("����γ����III",null,null);
		if(dao.delCourse(course)){
			System.out.println("�γ�ɾ���ɹ�: "+ course.getName());
		}else {
			System.out.println("�γ�ɾ��ʧ��: "+ course.getName());
		}
		
		// 4.�޸�ָ���Ŀγ� by name
		course = new Course("����γ����II","njust-cs-seer",new Date());
		if(dao.modifyCourse(course)){
			System.out.println("�γ��޸ĳɹ�: "+ course.getName()+" "+course.getCreator());
		}else {
			System.out.println("�γ��޸�ʧ��: "+ course.getName()+" "+course.getCreator());
		}
	
		// ��֤������Ľ���Ƿ���ȷ
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
