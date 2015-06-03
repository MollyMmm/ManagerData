package cn.com.adminData.model;

public class ExpertMessageBean {
	private int Id;
	private int ExtendedId;
	private String Names;
	private String Head_Portrait;
	private String Birth;
	private String Major;
	private String DutyTime;
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
	public String getNames() {
		return Names;
	}
	public void setNames(String names) {
		Names = names;
	}
	public String getHead_Portrait() {
		return Head_Portrait;
	}
	public void setHead_Portrait(String headPortrait) {
		Head_Portrait = headPortrait;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getDutyTime() {
		return DutyTime;
	}
	public void setDutyTime(String dutyTime) {
		DutyTime = dutyTime;
	}
}
