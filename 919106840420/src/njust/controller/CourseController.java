package njust.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import njust.dataclass.courseDAO;
import njust.dataclass.CourseService;
import njust.dataclass.course;

public class CourseController extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public CourseController() {
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
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");	
		
		if((int)request.getSession().getAttribute("errno")==200)
		{
			course concourse = new course();
			concourse = (course)request.getSession().getAttribute("testcourse");
			concourse.setTitle(request.getParameter("title"));
			concourse.setNewdate(request.getParameter("adddate"));
			concourse.setNewtime(request.getParameter("addtime"));
			CourseService conCourseService = new CourseService();
			int backnum = conCourseService.addCourseService(concourse);
			if(backnum == 200)
			{
				request.getRequestDispatcher("manageCourse.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("failure.jsp").forward(request, response);
			}
		}
		else
		{

			String[] ids = request.getParameterValues("xuhao");
			if(ids != null){
				CourseService conCourseService = new CourseService();
				for(int i=0;i<ids.length;i++){
					//System.out.println("Choose:"+ids[i]);
					//courseDAO conCourseDAO = new courseDAO();
					//course conCourse = conCourseDAO.getCourse(Integer.valueOf(ids[i]).intValue());
				}
			}
			else{
				//并没有选则 提示并提供超链接
			}
			//String id = request.getParameter("checbox");
			//System.out.println(id);
		}
		
		
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
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
