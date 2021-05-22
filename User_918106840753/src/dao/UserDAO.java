package dao;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import entity.*;
import utils.*;
public class UserDAO {
	Vector<UserBean> users;
	
	public UserDAO() {
		users=new Vector<UserBean>();
	}
	
	public int find(UserBean user){
		int result=-1;
		Map<String, Object> map = null;
		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put("usrName", user.getName());
   	    try {
   	       List<Map<String, Object>> list = DBUtil.query("usr",whereMap);
   	       int size = list.size();
		   if(size == 1){
			   map = list.get(0);
			   result = -2; //用户存在
			   if(map.get("pw").equals(user.getPsd())){
		    		 result = 1; //用户存在,密码正确
		       }
		   	   return result;
		   }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } catch (Exception e){
	         e.printStackTrace();
	     }
   	    return result;
	}
	
	public int addUser(UserBean user){
		Map<String, Object> valueMap = new HashMap<>();
		valueMap.put("usrName", user.getName());
		valueMap.put("pw",user.getPsd());
   	    try {
   	    	int count = DBUtil.insert("usr", valueMap);
	    	if(count > 0){
	    		   return 0;
	    	 }
	    	else return 1;
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } catch (Exception e){
	         e.printStackTrace();
	     }
   	    return 1;
	}

	public int deleteUser(UserBean user){
		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put("usrName", user.getName());
		whereMap.put("pw", user.getPsd());
   	    try {
		   int count = DBUtil.delete("usr",whereMap);
		   if(count > 0){
			   return 1;
		   }
	    } catch (SQLException e) {
	       e.printStackTrace();
	    } catch (Exception e){
	       e.printStackTrace();
	    }
		return 0;	
	}
	
	public int modifyUser(UserBean user){
		Map<String, Object> valueMap = new HashMap<>();
		valueMap.put("pw",user.getPsd());
		Map<String, Object> whereMap = new HashMap<>();
		whereMap.put("usrName", user.getName());
   	    try {
   	    	int count = DBUtil.update("usr", valueMap,whereMap);
	    	if(count > 0){
	    		   return 0;
	    	 }
	    	else return 1;
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } catch (Exception e){
	         e.printStackTrace();
	     }
   	    return 1;
	}
	
	public Vector<UserBean> getAllusers(){
		Map<String, Object> map = null;
		UserBean user = null;
		String sql="select * from usr";
		//String sql ="select * from courses limit "+ (curPage-1)*pageSize+","+pageSize;
		try {
			List<Map<String, Object>> list = DBUtil.query(sql);
			int size = list.size();
			for(int i=0;i<size;i++){
			   map = list.get(i);
			   user = new UserBean((String)map.get("usrName"),(String)map.get("pw"));
			   users.add(user);
			}
        } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e){
            e.printStackTrace();
		}
		return users;
	}
	public int getCountofUsers() {
		String sql="select * from usr";
		try {
			List<Map<String, Object>> list = DBUtil.query(sql);
			return list.size();
        } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e){
            e.printStackTrace();
		}
		return 0;
	}
	 public static void main(String[] args) {
		 UserBean user=new UserBean("njust","456");
		 System.out.println(user.getName());
			Map<String, Object> whereMap = new HashMap<>();
		whereMap.put("usrName", user.getName());
	       List<Map<String, Object>> list;
		try {
			list = DBUtil.query("usr",whereMap);
	   	       int size = list.size();
	    		 System.out.println(size);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 }
}
