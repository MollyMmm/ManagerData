package cn.com.adminData.model;


public class NoticeBean {
	private int ID;
	private int ExtendedId;
	private String Title;
	private String Body;
	private String MainBody;
	private String PublishTime;
	private String UpdateTime;
	private String Picture;
	private int Type;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getExtendedId() {
		return ExtendedId;
	}
	public void setExtendedId(int extendedId) {
		ExtendedId = extendedId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public String getMainBody() {
		return MainBody;
	}
	public void setMainBody(String mainBody) {
		MainBody = mainBody;
	}
	public String getPublishTime() {
		return PublishTime;
	}
	public void setPublishTime(String publishTime) {
		PublishTime = publishTime;
	}
	public String getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(String updateTime) {
		UpdateTime = updateTime;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
}
