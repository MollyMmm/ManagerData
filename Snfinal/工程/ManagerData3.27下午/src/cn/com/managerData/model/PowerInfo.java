package cn.com.managerData.model;

import java.util.HashSet;
import java.util.Set;

public class PowerInfo {
	/** 私有的属性，公有的方法 **/

	/** 主键ID */
	private Integer powerId;
	/** 菜单名 */
	private String powerName;
	/** 菜单路径 */
	private String powerUrl;
	/** 父节点ID */
	private Integer parentId;
	/** 菜单状态 1：激活 0：禁用 */
	private String powerStatus = "1";
	/** 图标 */
	private String powerIcon;
	/** 扩展属性 */
	private String powerPosition;
	/** 时间对象 */
	private DateBean date;

	/** 有效时间 */
	private Integer powerDate;
	public Integer getPowerId() {
		return powerId;
	}


	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}


	public String getPowerName() {
		return powerName;
	}


	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}


	public String getPowerUrl() {
		return powerUrl;
	}


	public void setPowerUrl(String powerUrl) {
		this.powerUrl = powerUrl;
	}


	public Integer getParentId() {
		return parentId;
	}


	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


	public String getPowerStatus() {
		return powerStatus;
	}


	public void setPowerStatus(String powerStatus) {
		this.powerStatus = powerStatus;
	}


	public String getPowerIcon() {
		return powerIcon;
	}


	public void setPowerIcon(String powerIcon) {
		this.powerIcon = powerIcon;
	}


	public String getPowerPosition() {
		return powerPosition;
	}


	public void setPowerPosition(String powerPosition) {
		this.powerPosition = powerPosition;
	}


	public DateBean getDate() {
		return date;
	}


	public void setDate(DateBean date) {
		this.date = date;
	}


	public Integer getPowerDate() {
		return powerDate;
	}


	public void setPowerDate(Integer powerDate) {
		this.powerDate = powerDate;
	}


	public Set<RoleInfo> getRoleSet() {
		return roleSet;
	}


	public void setRoleSet(Set<RoleInfo> roleSet) {
		this.roleSet = roleSet;
	}


	private Set<RoleInfo> roleSet = new HashSet<RoleInfo>();
	

	public String toString() {
		return "powers [power_icon=" + powerIcon + ", power_id=" + powerId
				+ ", power_name=" + powerName + ", power_position="
				+ powerPosition + ", power_status=" + powerStatus
				+ ", power_url=" + powerUrl + ", parent_id=" + parentId
				+ "]";
	}
}