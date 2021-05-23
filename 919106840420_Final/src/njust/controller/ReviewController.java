package njust.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import njust.entity.Review;
import njust.entity.ReviewPage;
import njust.service.ReviewService;

public class ReviewController extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ReviewController() {
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

		  //response.setContentType("text/html");
		  response.setContentType("text/html;charset=gb2312");
		  ReviewService conReviewService = new ReviewService();
		  
		  ReviewPage temPage = new ReviewPage();//将分页所需的字段组装完成
		  
		  String cPage = request.getParameter("currentPage");
			if(cPage == null)
			{
				cPage = "1";
			}
			int currentPage = Integer.parseInt(cPage);
			
			temPage.setCurrentPage(currentPage);
			
			//System.out.println((String)request.getAttribute("mainuserid"));
			temPage.setTotalCount(conReviewService.getTotalCount());
			//System.out.println(temPage.getTotalCount());
			
			int pageSize = 5;
			temPage.setPageSize(pageSize);
			
			List<Review> lReviews = conReviewService.getReviewByPage(currentPage, pageSize);
			temPage.setCourses(lReviews);
			request.setAttribute("kPage", temPage);
			request.getRequestDispatcher("manageReviewByPage.jsp").forward(request, response);
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		//request.getRequestDispatcher("manageReviewByPage.jsp").forward(request, response);
		
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
