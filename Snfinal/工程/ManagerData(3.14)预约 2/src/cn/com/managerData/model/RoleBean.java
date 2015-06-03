package cn.com.managerData.model;

import java.util.HashSet;
import java.util.Set;



public class RoleBean {
/**私有的属性，公有的方法**/
	/**主键ID*/
	private int role_id;
	/**角色名称*/
	private String role_name;
	/**角色描述*/
	private String role_desc;
	/**角色状态
	 * 
	 * 1：激活 2：禁用
	 * 
	 * */
	
	private Set<AdminInfo> userSet = new HashSet<AdminInfo>();
	

	public Set<AdminInfo> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<AdminInfo> userSet) {
		this.userSet = userSet;
	}
	private String role_status = "1";
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int roleId) {
		role_id = roleId;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String roleName) {
		role_name = roleName;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String roleDesc) {
		role_desc = roleDesc;
	}
	public String getRole_status() {
		return role_status;
	}
	public void setRole_status(String roleStatus) {
		role_status = roleStatus;
	}
	@Override
	public String toString() {
		return "Role [role_desc=" + role_desc + ", role_id=" + role_id
				+ ", role_name=" + role_name + ", role_status=" + role_status
				+ ", userSet=" + userSet + "]";
	}
}
