package cn.com.adminData.model;

public class FeedbackBean {
	private int ID;
	private int ExtendedId;
	private String UserID;
	private String Title;
	private String Description;
	private String Deadline;
	private String Require;
	private int Type;
	private String SentTime;
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
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDeadline() {
		return Deadline;
	}
	public void setDeadline(String deadline) {
		Deadline = deadline;
	}
	public String getRequire() {
		return Require;
	}
	public void setRequire(String require) {
		Require = require;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public String getSentTime() {
		return SentTime;
	}
	public void setSentTime(String sentTime) {
		SentTime = sentTime;
	}

}
