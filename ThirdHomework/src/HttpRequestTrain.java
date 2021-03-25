// 导入必需的 java 库
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class HttpRequestTrain extends HttpServlet {



	  public void init() throws ServletException
	  {

	  }

	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
	      //response.setContentType("text/html");
		  response.setContentType("text/html;charset=gb2312"); 

	      PrintWriter out = response.getWriter();
	      out.println("getContextPath():&emsp;" + request.getContextPath());
	      out.println("<br>");
	      out.println("getHeaderNames():&emsp;" + "<br>");
	      Enumeration headerNames = request.getHeaderNames();
			while(headerNames.hasMoreElements()){
				String paramName = (String)headerNames.nextElement();
				out.print(paramName);
				String paramValue = request.getHeader(paramName);
				out.print(paramValue+"<br>");
			}
	      out.println("getPathInfo():&emsp;" + request.getPathInfo());
	      out.println("<br>");
	      out.println("getServletPath():&emsp;" + request.getServletPath());
	      out.println("<br>");
	      out.println("getRequestURI():&emsp;" + request.getRequestURI());
	      out.println("<br>");
	      out.println("getParameter():&emsp;" + request.getParameter("KanDong"));
	      
	  }
	  
	  public void destroy()
	  {
	      
	  }
	}
