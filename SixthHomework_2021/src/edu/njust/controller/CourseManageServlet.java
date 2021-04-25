package edu.njust.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.njust.dao.CourseDao;
import edu.njust.entity.Course;
import edu.njust.service.CourseService;

public class CourseManageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CourseManageServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		HttpSession session = request.getSession(false);
		//session.invalidate();
		//System.out.println(session);
		if(session == null){
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		
		String operation = request.getParameter("operation");
		String curName = request.getParameter("cName");		
		Course course = null;
		CourseService cs = new CourseService();
		
		int result = 0 ;
		if(operation.equals("add")){//增加course操作
			String curCreator = request.getParameter("cCreator");
			String curDate = request.getParameter("cDate");
			Date date = null;
			if(curDate!=null){
				//2020-04-07 12:43
				int year = Integer.parseInt(curDate.substring(0, 4));
				int month = Integer.parseInt(curDate.substring(5, 7));
				int day = Integer.parseInt(curDate.substring(8, 10));
				int hours = Integer.parseInt(curDate.substring(11, 13));
				int minutes = Integer.parseInt(curDate.substring(14, 16));
				
				Calendar rightNow = Calendar.getInstance();
				rightNow.set(year, month-1, day, hours, minutes);
				date = rightNow.getTime();
			    course = new Course(curName,curCreator,date);
			}else {
			  course = new Course(curName,curCreator);
			}
			if(course!=null && cs.addNewCourse(course)){
				result = 1; // 状态代码“1” 表示增加成功
			}else {
				result = -1; // 状态代码“-1” 表示增加失败，原因同名的课程已存在
			}
		}else if(operation.equals("del")){//删除course操作
			course = new Course(curName,null,null);
			if(cs.delCourse(course)){
				result = 2; // 状态代码“1” 表示删除成功
			}else{
				result = -2; // 状态代码“-2” 表示删除失败，原因课程不存在
			}	
		}else if(operation.equals("mod")){//修改course操作
			String curCreator = request.getParameter("cCreator");
			String curDate = request.getParameter("cDate");
			if(curDate!=null){
				//2020-04-07 12:43
				
				int year = Integer.parseInt(curDate.substring(0, 4));
				int month = Integer.parseInt(curDate.substring(5, 7));
				int day = Integer.parseInt(curDate.substring(8, 10));
				int hours=0;
				int minutes=0;
				if(curDate.length()>10){
				   hours = Integer.parseInt(curDate.substring(11, 13));
				   minutes = Integer.parseInt(curDate.substring(14, 16));
				}
				
				//System.out.println("year:=  "+year);
				Calendar rightNow = Calendar.getInstance();
				rightNow.set(year, month-1, day, hours, minutes);
				Date date = rightNow.getTime();
				
			    course = new Course(curName,curCreator,date);
			}
			if(cs.modifyCourse(course)){
				result = 5; // 状态代码“5” 表示修改成功
			}else {
				result = -5; // 状态代码“-5” 表示修改失败，原因课程不存在
			}
			
		}else if(operation.equals("modReq")){//请求修改course操作			
			course = cs.findCourseByName(curName);
			if(course != null){
				//request.setAttribute("curCourse", course);
				result = 3;				
			}				
		}else if(operation.equals("query")){//查询所有course
			
			result = 4;
		}
		
		switch(result){
			case 1:			
			case 4:
			case 2:
			case 5:
				Vector<Course> curVec = cs.findAllCourses();
				request.setAttribute("allCourse", curVec);
				request.getRequestDispatcher("manageCourse.jsp").forward(request,response);
				break;
			case 3:
				request.setAttribute("curCourse", course);
				request.getRequestDispatcher("modifyCourse.jsp").forward(request,response);
				break;
			case -1:
			case -2:
			case -5:
				request.setAttribute("error_code", result);
				request.getRequestDispatcher("failure.jsp").forward(request,response);
				break;
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
