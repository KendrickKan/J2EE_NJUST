package njust.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import njust.data.*;

public class BookController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BookController() {
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

		request.setCharacterEncoding("utf-8");	
		
		String operation = request.getParameter("operation");
		String bookId = request.getParameter("bookId");		
		Book book = null;
		BookDaoImpl bdi = new BookDaoImpl();
		
		int result = 0 ;
		if(operation.equals("add")){//����course����
			String curCreator = request.getParameter("cCreator");
			String curDate = request.getParameter("cDate");
			
			if(book!=null && bdi.addBook(book)){
				result = 1; // ״̬���롰1�� ��ʾ���ӳɹ�
			}else {
				result = -1; // ״̬���롰-1�� ��ʾ����ʧ�ܣ�ԭ��ͬ���Ŀγ��Ѵ���
			}
		}else if(operation.equals("del")){//ɾ��course����
			if(bookId!=null){
				book = new Book(Integer.parseInt(bookId));
				if(book!= null){
					if(bdi.deleteBook(book)){
						result = 2; // ״̬���롰2�� ��ʾɾ���ɹ�
					}else{
						//result = -2; // ״̬���롰-2�� ��ʾɾ��ʧ�ܣ�ԭ����鲻����
					}	
				}
			}
		}else if(operation.equals("mod")){//�޸�course����		
		
			if(bdi.updateBook(book)){
				result = 5; // ״̬���롰5�� ��ʾ�޸ĳɹ�
			}else {
				result = -5; // ״̬���롰-5�� ��ʾ�޸�ʧ�ܣ�ԭ��γ̲�����
			}
			
		}else if(operation.equals("modReq")){//�����޸�course����
			book = null;
			if(book != null){
				//request.setAttribute("curCourse", course);
				result = 3;				
			}				
		}else if(operation.equals("query")){//��ѯ����books			
			result = 4;
		}
		
		switch(result){
			case 1:			
			case 4:
			case 2:
			case 5:
				List<Book> books = bdi.getAllBooks();
				request.setAttribute("allBooks", books);
				request.getRequestDispatcher("showBooks.jsp").forward(request,response);
				break;
			case 3:
				request.setAttribute("curBook", book);
				request.getRequestDispatcher("modifyBook.jsp").forward(request,response);
				break;
			case -1:
			case -2:
			case -5:
				request.setAttribute("error_code", result);
				request.getRequestDispatcher("failure.jsp").forward(request,response);
				break;
		}
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
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
