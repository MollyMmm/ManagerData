package cn.com.adminData.model;

public class YellowPageBean {
	/**
	 * Id
	 */
	private int Id;
	/**
	 * 机构名称
	 */
	private int ExtendedId;
	
	private String Institution_Name;
	/**
	 * 联系方式
	 */
	private String ContactMethod;
	/**
	 * 地址
	 */
	private String Location;
	private String picture;
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getExtendedId() {
		return ExtendedId;
	}
	public void setExtendedId(int extendedId) {
		ExtendedId = extendedId;
	}
	public String getInstitution_Name() {
		return Institution_Name;
	}
	public void setInstitution_Name(String institution_Name) {
		Institution_Name = institution_Name;
	}
	public String getContactMethod() {
		return ContactMethod;
	}
	public void setContactMethod(String contactMethod) {
		ContactMethod = contactMethod;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
	

}
