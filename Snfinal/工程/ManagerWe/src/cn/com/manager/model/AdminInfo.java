package cn.com.manager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AdminInfo {

	private Integer id;

	private Integer identity;
	private String userName;
	private String password;
	private String realName;
	private Date creatTime;
	private String email;
	private String sex;
	private String tele;
	private Set<RoleInfo> roleSet = new HashSet<RoleInfo>();
	
	

	public Set<RoleInfo> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<RoleInfo> roleSet) {
		this.roleSet = roleSet;
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

	

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
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

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}



}

