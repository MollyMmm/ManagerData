package cn.com.manager.model;

import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;

public class PowerBean {
	/** 私有的属性，公有的方法 **/

	/** 主键ID */
	private Integer power_id;
	/** 菜单名 */
	private String power_name;
	/** 菜单路径 */
	private String power_url;
	/** 父节点ID */
	private Integer parent_id;
	/** 菜单状态 1：激活 2：禁用 */
	private String power_status = "1";
	/** 图标 */
	private String power_icon;
	/** 扩展属性 */
	private String power_position;
	/** 时间对象 */
	private DateBean date;

	/** 有效时间 */
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