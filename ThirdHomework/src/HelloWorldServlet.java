// �������� java ��
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// ��չ HttpServlet ��
public class HelloWorldServlet extends HttpServlet {
 
  private String name;
  private String student_no;

  public void init() throws ServletException
  {
	  name = "�۶�";
	  student_no = "919106840420";
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      //response.setContentType("text/html");
	  response.setContentType("text/html;charset=gb2312");

      PrintWriter out = response.getWriter();
      out.println("<h1>" + "ѧ��Ϊ" + student_no + "��" + name + "ͬѧ����ã�" + "</h1>");
  }
  
  public void destroy()
  {
     
  }
}