package cn.com.manager.model;

import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;

public class PowerBean {
	/** ˽�е����ԣ����еķ��� **/

	/** ����ID */
	private Integer power_id;
	/** �˵��� */
	private String power_name;
	/** �˵�·�� */
	private String power_url;
	/** ���ڵ�ID */
	private Integer parent_id;
	/** �˵�״̬ 1������ 2������ */
	private String power_status = "1";
	/** ͼ�� */
	private String power_icon;
	/** ��չ���� */
	private String power_position;
	/** ʱ����� */
	private DateBean date;

	/** ��Чʱ�� */
	private Integer power_date;

	

	public Integer getPower_id() {
		return power_id;
	}



	public void setPower_id(Integer powerId) {
		power_id = powerId;
	}



	public String getPower_name() {
		return power_name;
	}



	public void setPower_name(String powerName) {
		power_name = powerName;
	}



	public String getPower_url() {
		return power_url;
	}



	public void setPower_url(String powerUrl) {
		power_url = powerUrl;
	}



	public Integer getParent_id() {
		return parent_id;
	}



	public void setParent_id(Integer parentId) {
		parent_id = parentId;
	}



	public String getPower_status() {
		return power_status;
	}



	public void setPower_status(String powerStatus) {
		power_status = powerStatus;
	}



	public String getPower_icon() {
		return power_icon;
	}



	public void setPower_icon(String powerIcon) {
		power_icon = powerIcon;
	}



	public String getPower_position() {
		return power_position;
	}



	public void setPower_position(String powerPosition) {
		power_position = powerPosition;
	}



	public DateBean getDate() {
		return date;
	}



	public void setDate(DateBean date) {
		this.date = date;
	}



	public Integer getPower_date() {
		return power_date;
	}



	public void setPower_date(Integer powerDate) {
		power_date = powerDate;
	}



	public String toString() {
		return "powers [power_icon=" + power_icon + ", power_id=" + power_id
				+ ", power_name=" + power_name + ", power_position="
				+ power_position + ", power_status=" + power_status
				+ ", power_url=" + power_url + ", parent_id=" + parent_id
				+ "]";
	}
}