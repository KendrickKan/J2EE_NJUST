package edu.njust.entity;

public class Login {
    private String name;
    private String pwd;  
    
    public Login(){}
    
    public Login(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
    
    
}
