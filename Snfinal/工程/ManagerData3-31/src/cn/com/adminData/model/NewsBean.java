package cn.com.adminData.model;

public class NewsBean {

	private Integer id;
	private Integer extendedId;
	private String title;
	private String mainBody;
	private String body;
	private String public_time;
	private String update_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getExtendedId() {
		return extendedId;
	}
	public void setExtendedId(Integer extendedId) {
		this.extendedId = extendedId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMainBody() {
		return mainBody;
	}
	public void setMainBody(String mainBody) {
		this.mainBody = mainBody;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getPublic_time() {
		return public_time;
	}
	public void setPublic_time(String publicTime) {
		public_time = publicTime;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String updateTime) {
		update_time = updateTime;
	}
	
}
