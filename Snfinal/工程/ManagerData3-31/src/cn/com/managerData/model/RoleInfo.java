package cn.com.managerData.model;

import java.util.HashSet;
import java.util.Set;

public class RoleInfo {
	/**����ID*/
	private int roleId;
	/**��ɫ����*/
	private String roleName;
	/**��ɫ����*/
	private String roleDesc;
	/**��ɫ״̬
	 * 
	 * 1������ 0������
	 * 
	 * */
	private Integer roleStatus;
	
	private Set<AdminInfo> adminSet = new HashSet<AdminInfo>();
	private Set<PowerInfo> powerSet = new HashSet<PowerInfo>();
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public Integer getRoleStatus() {
	return roleStatus;
}
public void setRoleStatus(Integer roleStatus) {
	this.roleStatus = roleStatus;
}
	public Set<AdminInfo> getAdminSet() {
		return adminSet;
	}
	public void setAdminSet(Set<AdminInfo> adminSet) {
		this.adminSet = adminSet;
	}
	public Set<PowerInfo> getPowerSet() {
		return powerSet;
	}
	public void setPowerSet(Set<PowerInfo> powerSet) {
		this.powerSet = powerSet;
	}
	
}
