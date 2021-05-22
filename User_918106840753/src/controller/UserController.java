package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.*;
import utils.MyUTF;
import entity.*;

public class UserController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserController() {
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
		doPost(request,response);
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=gb2312");
		HttpSession session = request.getSession();
		String req=(String)session.getAttribute("req");
		UserService US=new UserService();
		String req1=request.getParameter("req");
		if(req1!=null && req1.equals("delete")){
			String uname=null;
			try {
				uname = MyUTF.getNewString(request.getParameter("uname"));
			} catch (Exception e) {
				e.printStackTrace();
			}
	        String upsd = request.getParameter("upsd");
	        UserBean user=new UserBean(uname,upsd);
			int result=US.deleteUser(user);
			if(result==1){
				req="show";
			}
			else {
				request.setAttribute("error_code", 18);
				request.getRequestDispatcher("failure.jsp").forward(request,response);
			}
		}
		else {
			if(req.equals("modify")){
				UserBean user1=(UserBean)session.getAttribute("user");
				String uname=null;
				try {
					uname = MyUTF.getNewString(request.getParameter("uname"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				uname=user1.getName();
		        String upsd = request.getParameter("newpsd1");
		        UserBean user=new UserBean(uname,upsd);
				int result=US.modifyUser(user);
				if(result==0){
					req="show";
				}
				else {
					request.setAttribute("error_code", 20);
					request.getRequestDispatcher("failure.jsp").forward(request,response);
				}
			}
			else if(req.equals("check")){
				String uname = request.getParameter("uname");
		        String upsd = request.getParameter("upsd");
		        request.setAttribute("uname",uname);		//
		        request.setAttribute("upsd",upsd);			//
		        UserBean user=new UserBean(uname,upsd);
				int result=US.validateLoginInfo(user);
				request.setAttribute("error_code",result);
				if(result==1){
					req="show";
				}
				else {
					request.getRequestDispatcher("failure.jsp").forward(request, response);  
				}
			}
			
			
			if(req.equals("add")){
				String uname = request.getParameter("uname");
		        String upsd = request.getParameter("upsd");
		        UserBean user=new UserBean(uname,upsd);
				int result=US.validateLoginInfo(user);
		        if(result!=-1){
					request.setAttribute("error_code",2);
		        	request.getRequestDispatcher("failure.jsp").forward(request, response);  
				}
		        else {
					result=US.addUser(user);
					if(result==0){
						req="show";
					}
					else {
						request.setAttribute("error_code", 15);
						request.getRequestDispatcher("failure.jsp").forward(request,response);
					}
		        }
			}
		}

		

		if(req.equals("show")){
			List<UserBean> allusers=US.getAllusers();
			int count=US.getCountOfUsers();
			request.setAttribute("allusers", allusers);
			request.setAttribute("cnt", count);
			request.getRequestDispatcher("userManagement.jsp").forward(request,response);	
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
