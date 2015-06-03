package cn.com.adminData.model;




public class PrivateConsultBean {
	private int Id;
	private int ExtendedId;
	private int UserId;
	private String Consulting_Body;
	private String Consulting_Time;
	private String Deadline;
	private String Consulting_Type;
	private String Reply_Body; 
	private String Reply_Time;
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
	public String getConsulting_Body() {
		return Consulting_Body;
	}
	public void setConsulting_Body(String consultingBody) {
		Consulting_Body = consultingBody;
	}
	
	public String getConsulting_Time() {
		return Consulting_Time;
	}
	public void setConsulting_Time(String consultingTime) {
		Consulting_Time = consultingTime;
	}
	public String getDeadline() {
		return Deadline;
	}
	public void setDeadline(String deadline) {
		Deadline = deadline;
	}
	public String getConsulting_Type() {
		return Consulting_Type;
	}
	public void setConsulting_Type(String consultingType) {
		Consulting_Type = consultingType;
	}
	public String getReply_Body() {
		return Reply_Body;
	}
	public void setReply_Body(String replyBody) {
		Reply_Body = replyBody;
	}
	public String getReply_Time() {
		return Reply_Time;
	}
	public void setReply_Time(String replyTime) {
		Reply_Time = replyTime;
	} 

}
