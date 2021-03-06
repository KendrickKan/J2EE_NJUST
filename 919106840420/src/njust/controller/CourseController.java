package njust.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import njust.dataclass.courseDAO;
import njust.dataclass.coursePage;
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
	
	  public void doGet(HttpServletRequest request,
              HttpServletResponse response)
      throws ServletException, IOException
	  {
		  //response.setContentType("text/html");
		  response.setContentType("text/html;charset=gb2312");
		  CourseService conCourseService = new CourseService();
		  
		  coursePage temPage = new coursePage();//将分页所需的字段组装完成
		  
		  String cPage = request.getParameter("currentPage");
			if(cPage == null)
			{
				cPage = "1";
			}
			int currentPage = Integer.parseInt(cPage);
			
			temPage.setCurrentPage(currentPage);
			
			//System.out.println((String)request.getAttribute("mainuserid"));
			temPage.setTotalCount(conCourseService.getTotalCount());
			//System.out.println(temPage.getTotalCount());
			
			int pageSize = 4;
			temPage.setPageSize(pageSize);
			
			List<course> lcourses = conCourseService.getCourseByPage(currentPage, pageSize);
			temPage.setCourses(lcourses);
			request.setAttribute("kPage", temPage);
			request.getRequestDispatcher("manageCourseByPage.jsp").forward(request, response);

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

		response.setContentType("text/html;charset=utf-8");
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
		else if ((int)request.getSession().getAttribute("errno")==201)
		{
			String[] ids = request.getParameterValues("xuhao");
			if(ids != null){
				CourseService conCourseService = new CourseService();
				boolean isDelete=false;
				for(int i=0;i<ids.length;i++){
					int checkdelete = conCourseService.delCourseService(Integer.valueOf(ids[i]).intValue());
					if(checkdelete==201)
					{
						isDelete = true;
						break;
					}
					//System.out.println("Choose:"+ids[i]);
					//courseDAO conCourseDAO = new courseDAO();
					//course conCourse = conCourseDAO.getCourse(Integer.valueOf(ids[i]).intValue());
				}
				if(!isDelete)
				{
					//删除成功
					PrintWriter out = response.getWriter();
					out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
					out.println("<HTML>");
					out.println("  <HEAD><TITLE>A Servlet</TITLE>");
					out.println("<meta http-equiv='refresh' content='5,URL=manageCourse.jsp'>");
					out.println("</HEAD>");
					out.println("  <BODY>");
					out.println("<h1>删除成功，将在五秒后返回ManageCourse页面</h1>");
					out.println("  </BODY>");
					out.println("</HTML>");
					out.flush();
					out.close();
					//request.getRequestDispatcher("manageCourse.jsp").forward(request, response);
				}
				else
				{
					//删除失败
					request.getRequestDispatcher("faliure.jsp").forward(request, response);
				}
			}
			else{
				//并没有选则 提示并提供超链接
				request.getRequestDispatcher("faliure.jsp").forward(request, response);
			}
			//String id = request.getParameter("checbox");
			//System.out.println(id);
		}
//		else{
//			String cPage = request.getParameter("currentPage");
//			if(cPage == null)
//			{
//				cPage = "1";
//			}
//			int currentPage = Integer.parseInt(cPage);
//			CourseService conCourseService = new CourseService();
//			List<course> lcourses = conCourseService.getCourseByPage(currentPage, 5);
//			request.setAttribute("courses", lcourses);
//			request.getRequestDispatcher("manageCourse.jsp").forward(request, response);
//		}
		
		
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
