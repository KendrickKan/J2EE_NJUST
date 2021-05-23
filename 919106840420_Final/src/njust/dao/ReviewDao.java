package njust.dao;

import njust.utils.*;
import njust.entity.Review;

import java.sql.*;

import javax.sql.*;
import java.util.*;

import org.eclipse.jdt.internal.compiler.batch.Main;

public class ReviewDao {

	public Review getReview(String id){
		   Connection conn =null;
		   Statement stmt = null;
		   ResultSet rs = null;
		   Review review = null;
		   
		   String sql = "select * from review_log where reviewId="+id;
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(sql);
			     while(rs.next()){
			    	 review = new Review(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getBoolean(6));
			
//			    	 System.out.println(rs.getString(1));
//			    	 System.out.println(rs.getString(2));
//			    	 System.out.println(rs.getString(3));
			     }
			   }catch(SQLException e){
				   e.printStackTrace();
				   return null;
			   }catch(Exception e){
				   e.printStackTrace();
			   };
		   return review;
	}
	
	public List<Review> getAllReview(){
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Review> reviews = new ArrayList<>();
		Review tempReview = null;
		String sql = "select * from review_log";
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(sql);
			     while(rs.next()){
			    	 tempReview = new Review(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getBoolean(6));
			    	 reviews.add(tempReview);		    	 
			     }
			     
			   }catch(SQLException e){
				   e.printStackTrace();
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   SimpleJDBCUtils.release(conn, stmt, rs);
		return reviews;
	}
	
	public int getCount(){
		   Connection conn =null;
		   Statement stmt = null;
		   ResultSet rs = null;
		   int rows = -1;
		   String sql = "select count(*) from review_log where isPayed = 0";
		   int count = -1;
		   try{
			     conn = SimpleJDBCUtils.getConnection();
			     stmt = conn.createStatement();
			     rs = stmt.executeQuery(sql);
			     while(rs.next()){
			    	 count = rs.getInt(1);
			     }
			     
			   }catch(SQLException e){
				   e.printStackTrace();
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   SimpleJDBCUtils.release(conn, stmt, rs);
		return count;
	}
	
	//分页功能 currentPage 当前页 ，pageSize 页面显示数量
		public List<Review> getCourseByPage(int currentPage,int pageSize){
			String sql = "select * from review_log order by reviewId";

			Object[] bindArgs = {(currentPage-1)*pageSize,pageSize};
			try{
			
				List<Map<String, Object>> rs = DBUtil.executeQuery(sql,null);
				//List<Map<String, Object>> rs = DBUtil.executeQuery(sql, bindArgs);
				List<Review> cour = new ArrayList<Review>();
				if(!rs.isEmpty())
				{
					int size = rs.size();
					int index = 0;
					int nowin = 0;
					int x=(currentPage-1)*pageSize;
					int y=currentPage*pageSize;
					while(index < size)
					{
						Review temp=new Review();
						temp.setReviewid((int)rs.get(index).get("reviewId"));
						temp.setOrganization((String)rs.get(index).get("organization"));
						temp.setPapertitle((String)rs.get(index).get("paperTitle"));
						temp.setFee((int)rs.get(index).get("fee"));
						temp.setDate(rs.get(index).get("date").toString());
						temp.setIspayed((boolean)rs.get(index).get("isPayed"));
						if(temp.isIspayed()==false)
						{
							if(nowin>=x&&nowin<y)
							cour.add(temp);
							nowin++;
						}
						
							//cour.add(temp);
						index++;
					}
					return cour;
				
				}
				}catch(SQLException e){
				   e.printStackTrace();
				}catch(Exception e){
				   e.printStackTrace();
				}
			return null;
		}
	
	
	public static void main(String[] args) {
//		ReviewDao testDao = new ReviewDao();
//		List<Review> curList = testDao.getCourseByPage(2, 2);
//		Review cou = null;
//		if(!curList.isEmpty()){
//    		int size = curList.size();
//    		int index =0; //starting from 0
//    		 while (index < size){	      	    
//			    cou =(Review) curList.get(index);
//		     	if(cou != null){
//		     		System.out.println(cou.getPapertitle());
//			    }
//			    index = index +1;
//		     }
//		}
	}
}
