package njust.dataclass;

public class Login {
	private String userid;
	private String name;
	private String password;
	private String academy;
	private String department;
	public Login(){
		
	}
	public Login(String id){
		userid = id;
		name = "";
		password = "";
		academy = "";
		department = "";
	}
	public void setUserid(String id){
		this.userid = id;
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
	public void setPassword(String paw){
		this.password = paw;
	}
	public String getPassword(){
		return this.password;
	}
	public void setAcademy(String aca){
		this.academy = aca;
	}
	public String getAcademy(){
		return this.academy;
	}
	public void setDepartment(String dep){
		this.department = dep;
	}
	public String getDepartment(){
		return this.department;
	}
}
