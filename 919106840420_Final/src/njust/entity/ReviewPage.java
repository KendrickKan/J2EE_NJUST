package njust.entity;

import java.util.List;

public class ReviewPage {
	
	private int currentPage;
	
	private int pageSize;
	
	private int totalCount;
	
	private int totalPage;
	
	private List<Review> reviews;
	
	public ReviewPage(){
		
	}

	public ReviewPage(int currentPage, int pageSize,int totalCount,int totalPage,List<Review> reviews){
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.reviews = reviews;
		
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		
		this.pageSize = pageSize;
		this.totalPage = this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}

	public List<Review> getCourses() {
		return reviews;
	}

	public void setCourses(List<Review> courses) {
		this.reviews = courses;
	}
}
