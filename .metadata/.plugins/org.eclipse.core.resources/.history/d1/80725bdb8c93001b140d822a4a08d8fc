import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SharedServlet extends HttpServlet {
	
	//String id;
	//String name;
	String ServletContextObject;

	/**
		 * Constructor of the object.
		 */
	public SharedServlet() {
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
		String context_id = this.getServletContext().getInitParameter("id");
		String context_name = this.getServletContext().getInitParameter("name");
		out.println("<h1>&emsp;"+"id:"+"&emsp;&emsp;"+context_id+"</h1>");
		out.println("<br>");
		out.println("<h1>name:"+"&emsp;"+context_name+"</h1>");
		
		
		this.getServletContext().setAttribute("ServletContextObject", "130");
		out.println("<br>");
		out.println("<h1>ServletContextObject:"+"&emsp;"+(String)this.getServletContext().getAttribute("ServletContextObject")+"</h1>");
		this.getServletContext().removeAttribute("ServletContextObject");
		//out.println("<h1>ServletContextObject:"+"&emsp;"+(String)this.getServletContext().getAttribute("ServletContextObject")+"</h1>");
		
		HttpSession session = request.getSession();
		session.setAttribute("HttpSessionObject", "131");
		out.println("<br>");
		out.println("<h1>HttpSessionObject:"+"&emsp;"+(String)session.getAttribute("HttpSessionObject")+"</h1>");
		session.removeAttribute("HttpSessionObject");
		//out.println("<h1>HttpSessionObject:"+"&emsp;"+(String)session.getAttribute("HttpSessionObject")+"</h1>");
		
		request.setAttribute("HttpServletRequestObject", "132");
		out.println("<br>");
		out.println("<h1>HttpServletRequestObject:"+"&emsp;"+(String)request.getAttribute("HttpServletRequestObject")+"</h1>");
		request.removeAttribute("HttpServletRequestObject");
		//out.println("<h1>HttpServletRequestObject:"+"&emsp;"+(String)request.getAttribute("HttpServletRequestObject")+"</h1>");
		
		
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
