package edu.njust.entity;

import java.util.Date;

import edu.njust.utils.CalendarUtil;

public class Course {
	
	private String name;
	private String creator;
	private Date createDate;

	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public Course(String name,String creator, Date date) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.creator = creator;
		this.createDate = date;
	}
	
	public Course(String name,String creator) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.creator = creator;
		this.createDate = null;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getCreator(){
		return this.creator;
	}
	
	public void setCreator(String creator){
		this.creator = creator;
	}
	
	public Date getCreateDate(){
		return this.createDate;
	}
	
	public String getFormattedDate(){
		String dateStr = CalendarUtil.dateFormat(this.createDate);
		//System.out.println(dateStr);
		return dateStr;
	}
	
	public void setCreateDate(Date date){
		this.createDate = date;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
