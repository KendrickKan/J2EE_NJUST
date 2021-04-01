package cn.edu.njust;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpResponseTrain extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HttpResponseTrain() {
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
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Redirect = request.getParameter("Redirect");
		String ContentType = request.getParameter("ContentType");
		String CharacterEncoding = request.getParameter("CharacterEncoding");
		String Header1 = request.getParameter("Header1");
		String Header2 = request.getParameter("Header2");
		System.out.println(Redirect);
		if (ContentType != "") {
			response.setContentType(ContentType);
			System.out.println(response.getContentType());
			
		}
		if (CharacterEncoding != "" && CharacterEncoding =="iso-8859-1" ||CharacterEncoding =="gbk" ) {
			response.setCharacterEncoding(CharacterEncoding);
			System.out.println(response.getCharacterEncoding());
			
		}
		if (Redirect != "") {
			System.out.println("transfer to baidu.com");
			//response.setHeader("refresh", "5;URL=http://www.baidu.com");
		    response.sendRedirect(Redirect);
		}
		if (Header1 != "" && Header2 != "") {
			response.addHeader(Header1, Header2);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String url = request.getParameter("url");	
		String waiting =  request.getParameter("waiting");	
		if (url != "") {
			System.out.println("transfer to baidu.com after"+waiting+"  seconds");
			response.setHeader("refresh", waiting+";url=http://"+url);
		//			"3;URL=http://www.baidu.com");
		}
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
