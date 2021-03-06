import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateSharedServlet extends HttpServlet {
	
	
    static private boolean isFirst = true;
    static private boolean flag = true;

	/**
		 * Constructor of the object.
		 */
	public ValidateSharedServlet() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		
		ServletContext servletContext = this.getServletContext();
		HttpSession httpSession = request.getSession();

		boolean ifsc = servletContext.getAttribute("value")!=null;
        boolean ifhs = httpSession.getAttribute("value")!=null;
        boolean ifhsr = request.getParameter("value")!=null;


        if(ifhsr && !ifsc && isFirst)
        {
        	servletContext.setAttribute("value", request.getParameter("value"));
        	httpSession.setAttribute("value", request.getParameter("value"));
            isFirst = false;
        }
        else if(ifsc && ifhs)
        {
        	httpSession.setMaxInactiveInterval(3);
        }

        out.println("<html>");
        out.println("<body link=\"red\" alink=\"red\">");

        if( !ifsc && !ifhs && !ifhsr )
        {
            out.println("<form action=\"/919106840420/servlet/ValidateSharedServlet\" method=\"get\">");
            out.println("<h1>请输入文字作为三者绑定对象的值<br><input type=\"text\" name=\"value\" />"+"</h1>");
            out.println("<input type=\"submit\" value=\"提交\" />"+"</form>");
        }
        else
        {
            out.println("<h1>"+"ServletContext绑定对象的值："+servletContext.getAttribute("value")+"</h1>");
            out.println("<h1>"+"HttpSession绑定对象的值："+httpSession.getAttribute("value")+"</h1>");
            out.println("<h1>"+"HttpServletRequest绑定对象的值："+request.getParameter("value")+"</h1>");
            
            response.setHeader("REFRESH", "3;URL=/919106840420/servlet/ValidateSharedServlet");
            if(request.getParameter("value")!=null)
            {
                out.println("<h1>以上是ServletContext、HttpSession、HttpServletRequest绑定的对象的值。</h1>");
                out.println("<br>");
                out.println("此页面将在3秒后刷新。。。。。。");
            }
            else if(httpSession.getAttribute("value")!=null)
            {
                out.println("<h1>HttpServletRequest绑定对象的值仅在一次请求中有效，在新的一次请求中变为null。</h1>");
                out.println("<br>");
                out.println("此页面将在3秒后刷新。。。。。。");
            }
            else
            {
                out.println("<h1>HttpSession的生命周期结束了，其绑定对象的值变为null。</h1>");
                out.println("<br>");
                out.println("此页面将在3秒后刷新。。。。。。");

                if(!flag)
                {
                	response.setHeader("REFRESH", "18000;URL=/919106840420/servlet/ValidateSharedServlet");
                    out.println("<br>");
                    out.println("你可以点击下方链接查看三者区别。");
                    out.println("<br>");
                    out.println("<a href = \"/919106840420/MyHtml.html\">ServletContext、HttpSession和HttpServletRequest作为容器对象的区别</a>");
                }
                flag=false;

            }
        }

        out.println("</body>");
        out.println("</html>");
		
		out.flush();
		out.close();
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
