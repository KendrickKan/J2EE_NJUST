package service;

import java.util.Vector;

import dao.*;
import entity.*;

public class UserService {
	UserDAO user1;
	public UserService() {
		user1=new UserDAO();
	}
	
	public int validateLoginInfo(UserBean user){
		return user1.find(user);
	}
	
	public Vector<UserBean> getAllusers(){
		return user1.getAllusers();
	}
	public int getCountOfUsers(){
		return user1.getCountofUsers();
	}

	public int addUser(UserBean user){
		return user1.addUser(user);
	}
	
	public int deleteUser(UserBean user){
		return user1.deleteUser(user);//ɾ���ɹ�1
	}
	public int modifyUser(UserBean user){
		return user1.modifyUser(user);//�޸ĳɹ�1
	}
}
