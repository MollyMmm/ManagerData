package cn.com.adminData.model;

public class GoodsMessageBean {
private int ID;
private int ExtendedId;
private String Names;
private String Picture;
private String Address;
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
private String Introduction;
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
public String getName() {
	return Names;
}
public void setName(String names) {
	Names = names;
}
public String getPicture() {
	return Picture;
}
public void setPicture(String picture) {
	Picture = picture;
}
public String getIntroduction() {
	return Introduction;
}
public void setIntroduction(String introduction) {
	Introduction = introduction;
}

}
