package njust.dataclass;

import java.sql.*;

public class course {

	private int id;
	private String title;
	private String userid;
	private String name;
	private String newdate;
	private String newtime;
	public void setId(int kid){
		this.id = kid;
	}
	public int getId(){
		return this.id;
	}
	public void setTitle(String ktitle){
		this.title = ktitle;
	}
	public String getTitle(){
		return this.title;
	}
	public void setUserid(String kuserid){
		this.userid = kuserid;
	}
	public String getUserid(){
		return this.userid;
	}
	public void setName(String kname){
		this.name = kname;
	}
	public String getName(){
		return this.name;
	}
	public void setNewdate(String da){
		this.newdate = da;
	}
	public String getNewdate(){
		return this.newdate; 
	}
	public void setNewtime(String ti){
		this.newtime = ti;
	}
	public String getNewtime(){
		return this.newtime;
	}
}
