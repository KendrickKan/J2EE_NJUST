package njust.dataclass;

import java.sql.*;

public class course {

	private int id;
	private String title;
	private String userid;
	private String name;
	private Date newdate;
	private Time newtime;
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
	public void setNewdate(Date da){
		this.newdate = da;
	}
	public Date getNewdate(){
		return this.newdate; 
	}
	public void setNewtime(Time ti){
		this.newtime = ti;
	}
	public Time getNewtime(){
		return this.newtime;
	}
}
