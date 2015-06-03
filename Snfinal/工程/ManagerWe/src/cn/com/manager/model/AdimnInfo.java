package cn.com.manager.model;

public class AdimnInfo {
	private int id;

	private int identity;
	private String userName;
	private String password;
	private String realName;
	private String creatTime;
	private String email;
	private String sex;
	private String tele;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	

	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTele() {
		return tele;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public int getIdentity() {
		return identity;
	}

}
