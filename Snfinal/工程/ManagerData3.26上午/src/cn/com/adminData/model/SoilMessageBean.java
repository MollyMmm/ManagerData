package cn.com.adminData.model;

public class SoilMessageBean {
	private int Id;
	private int ExtendedId;
	private String Names;
	private String Picture;
	private int Price;
	private String ConversionProperty;
	private String SoilArea;
	private String NegotiableYear;
	private String SurplusYear;
	private String LandWarrants;
	private String SoilUsing;
	private String Type;
	private String Validdate;
	private String SoilLocation;
	private String ContactWay;
	
	public String getValiddate() {
		return Validdate;
	}
	public void setValiddate(String validdate) {
		Validdate = validdate;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
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
	public String getNames() {
		return Names;
	}
	public void setNames(String names) {
		Names = names;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}

	public String getConversionProperty() {
		return ConversionProperty;
	}
	public void setConversionProperty(String conversionProperty) {
		ConversionProperty = conversionProperty;
	}
	public String getSoilArea() {
		return SoilArea;
	}
	public void setSoilArea(String soilArea) {
		SoilArea = soilArea;
	}
	public String getNegotiableYear() {
		return NegotiableYear;
	}
	public void setNegotiableYear(String negotiableYear) {
		NegotiableYear = negotiableYear;
	}
	public String getSurplusYear() {
		return SurplusYear;
	}
	public void setSurplusYear(String surplusYear) {
		SurplusYear = surplusYear;
	}
	public String getLandWarrants() {
		return LandWarrants;
	}
	public void setLandWarrants(String landWarrants) {
		LandWarrants = landWarrants;
	}
	public String getSoilUsing() {
		return SoilUsing;
	}
	public void setSoilUsing(String soilUsing) {
		SoilUsing = soilUsing;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getSoilLocation(){
		return SoilLocation;
	}
	public void setSoilLocation(String soilLocation) {
	         SoilLocation=soilLocation;		
	}
	public String getContactWay(){
		return ContactWay;
	}
	public void setContactWay(String contactway) {
		ContactWay=contactway;
		
	}

}
