package cn.com.managerData.model;

import java.util.HashSet;
import java.util.Set;

public class PowerInfo {
	/** ˽�е����ԣ����еķ��� **/

	/** ����ID */
	private Integer powerId;
	/** �˵��� */
	private String powerName;
	/** �˵�·�� */
	private String powerUrl;
	/** ���ڵ�ID */
	private Integer parentId;
	/** �˵�״̬ 1������ 0������ */
	private String powerStatus = "1";
	/** ͼ�� */
	private String powerIcon;
	/** ��չ���� */
	private String powerPosition;
	/** ʱ����� */
	private DateBean date;

	/** ��Чʱ�� */
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