// 导入必需的 java 库
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// 扩展 HttpServlet 类
public class HelloWorldServlet extends HttpServlet {
 
  private String name;
  private String student_no;

  public void init() throws ServletException
  {
	  name = "阚东";
	  student_no = "919106840420";
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      //response.setContentType("text/html");
	  response.setContentType("text/html;charset=gb2312");

      PrintWriter out = response.getWriter();
      out.println("<h1>" + "学号为" + student_no + "的" + name + "同学，你好！" + "</h1>");
  }
  
  public void destroy()
  {
     
  }
}