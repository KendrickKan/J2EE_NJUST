package njust.entity;

public class Review {
	private int reviewid;
	private String organization;
	private String papertitle;
	private int fee;
	private String date;
	private boolean ispayed;
	
	public Review(){
		
	}
	
	public Review(int reviewid,String organization,String papertitle,int fee,String date,boolean ispayed){
		this.reviewid = reviewid;
		this.organization = organization;
		this.papertitle = papertitle;
		this.fee = fee;
		this.date = date;
		this.ispayed = ispayed;
	}
	
	public int getReviewid() {
		return reviewid;
	}
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getPapertitle() {
		return papertitle;
	}
	public void setPapertitle(String papertitle) {
		this.papertitle = papertitle;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isIspayed() {
		return ispayed;
	}
	public void setIspayed(boolean ispayed) {
		this.ispayed = ispayed;
	}
	
}
