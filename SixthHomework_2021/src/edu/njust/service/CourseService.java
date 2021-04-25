package edu.njust.service;

import java.util.Vector;

import edu.njust.dao.CourseDao;
import edu.njust.entity.Course;

public class CourseService {
	private CourseDao  cdao = null;

	public CourseService() {
		// TODO Auto-generated constructor stub
		cdao = new CourseDao();
	}
	
	public Vector<Course> findAllCourses(){
		Vector<Course> vecCur = cdao.findAllCourses();
		return vecCur;
	}
	
	public Course findCourseByName(String name){
		Course course;
		course = cdao.findByCourseName(name);
		return course;
	}
	
	public boolean addNewCourse(Course course){
		boolean flag = false;
//		cdao = new CourseDao();
		if(!cdao.findByCourseName(course)){
			cdao.addCourse(course);		
			flag = true;
		}
		return flag;		
	}
	
	public boolean delCourse(Course course){
		boolean flag = false;
//		cdao = new CourseDao();
		if(cdao.findByCourseName(course)){
			cdao.delCourse(course);		
			flag = true;
		}
		return flag;		
	}
	
	public boolean modifyCourse(Course course){
		boolean flag = false;
//		cdao = new CourseDao();
		if(cdao.findByCourseName(course)){
			cdao.modifyCourse(course);	
			flag = true;
		}
		return flag;		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
