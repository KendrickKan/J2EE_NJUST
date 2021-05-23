package njust.service;

import java.util.List;

import njust.dao.ReviewDao;
import njust.entity.Review;


public class ReviewService {

	public List<Review> getReviewByPage(int currentPage, int pageSize)
	{
		ReviewDao serReviewDao = new ReviewDao();
		return serReviewDao.getCourseByPage(currentPage, pageSize);
	}
	public static int getTotalCount()
	{
		ReviewDao serReviewDao = new ReviewDao();
		return serReviewDao.getCount();
	}
}
