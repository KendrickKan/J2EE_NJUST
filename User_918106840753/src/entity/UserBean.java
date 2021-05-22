package entity;

public class UserBean {
	private String name,psd;

	public UserBean(String name, String psd) {
		super();
		this.name = name;
		this.psd = psd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}
	
}
