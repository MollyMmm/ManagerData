package cn.com.adminData.model;

public class PostMessageBean {
	private int Id;
	private int ExtendedId;
	private int UserId;
	private String Title;
	private String Bodys;
	private String SentTime;
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
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getBodys() {
		return Bodys;
	}
	public void setBodys(String bodys) {
		Bodys = bodys;
	}
	public String getSentTime() {
		return SentTime;
	}
	public void setSentTime(String sentTime) {
		SentTime = sentTime;
	}


}
