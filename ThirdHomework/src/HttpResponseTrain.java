// 导入必需的 java 库
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class HttpResponseTrain extends HttpServlet {


	  public void init() throws ServletException
	  {

	  }

	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  response.setContentType("text/html;charset=gb2312"); 
		  response.setCharacterEncoding("utf-8");

		  
	      PrintWriter out = response.getWriter();
	      out.println("<br>");
	      out.println("setContentType("+"text/html;charset=gb2312"+")");
	      out.println("<br>");
	      out.println("setCharacterEncoding("+"utf-8"+")");
	      out.println("<br>");
	      response.addHeader("KanDong", "10");
	      out.println(response.getHeaderNames()+"<br>");
	      out.println("<br>");
	      response.sendRedirect("https://github.com/KendrickKan");
	  }
	  
	  public void destroy()
	  {
	      
	  }
	}
