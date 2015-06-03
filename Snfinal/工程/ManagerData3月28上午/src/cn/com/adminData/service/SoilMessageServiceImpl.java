package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.SoilMessageBean;
import cn.com.managerData.util.JdbcUtil;

public class SoilMessageServiceImpl implements SoilMessageService{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	/**
	 * 增加土壤信息
	 */
	public Boolean addSoilMessage(SoilMessageBean message, HttpSession session) {
		//-------这里涉及上传图片，还没有做
		
		String ExtendedId = String.valueOf(message.getExtendedId());
		String Names = message.getNames();
		String Picture=message.getPicture();
		String Price =String.valueOf( message.getPrice());
		String ConversionProperty = message.getConversionProperty();
		String SoilArea = message.getSoilArea();
		String NegotiableYear = message.getNegotiableYear();
		String SurplusYear = message.getSurplusYear();
		String LandWarrants = message.getLandWarrants();
		String SoilUsing = message.getSoilUsing();
		String Type = message.getType();
		String ValidDate = message.getValiddate();
		String Soillocation = message.getSoilLocation();
		String ContactWay=message.getContactWay();
		
         
		String sql = "insert into SoilMessage(id,ExtendedId,Names,Picture,Price,Conversion_Property,SoilArea," +
		"Negotiable_Year,SurplusYear,SoilUsing,Land_Warrants,Type,ValidDate,SoilLocation,ContactWay) values(SoilMessage_seq.nextval,"+ExtendedId+",'"+Names+"','"+Picture+"',"+Price+",'"+ConversionProperty+"','"+SoilArea+"','"+NegotiableYear+"','"+SurplusYear+"','"+SoilUsing+"','"+LandWarrants+"','"+Type+"','"+ValidDate+"','"+Soillocation+"','"+ContactWay+"')";
		int operate = 1;
		return dao.update(sql,operate, session);
	}


	public Boolean deleteSoilMessage(SoilMessageBean message,
			HttpSession session) {
		int id = message.getId();
		String sql = "delete from SoilMessage where id="+String.valueOf(id);	
		int operate=2;
		return dao.update(sql,operate,session);
	}
	public SoilMessageBean selectOne(String id) {
		SoilMessageBean SoilMessageN=new SoilMessageBean();
		String sql = "select * from SoilMessage where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		//存放一个对象的map
		Map<String,Object> SoilMessage = list.get(0);
		SoilMessageN.setId(Integer.parseInt(String.valueOf(SoilMessage.get("ID"))));
		SoilMessageN.setExtendedId(Integer.parseInt(String.valueOf(SoilMessage.get("EXTENDEDID"))));
		SoilMessageN.setNames(String.valueOf(SoilMessage.get("NAMES")));
		SoilMessageN.setPicture(String.valueOf(SoilMessage.get("PICTURE")));
		SoilMessageN.setPrice(Integer.parseInt(String.valueOf(SoilMessage.get("PRICE"))));
		SoilMessageN.setConversionProperty(String.valueOf(SoilMessage.get("CONVERSION_PROPERTY")));
		SoilMessageN.setSoilArea(String.valueOf(SoilMessage.get("SOILAREA")));
		SoilMessageN.setNegotiableYear(String.valueOf(SoilMessage.get("NEGOTIABLE_YEAR")));
		SoilMessageN.setSurplusYear(String.valueOf(SoilMessage.get("SURPLUSYEAR")));
		SoilMessageN.setLandWarrants(String.valueOf(SoilMessage.get("LAND_WARRANTS")));
		SoilMessageN.setSoilUsing(String.valueOf(SoilMessage.get("SOILUSING")));
		SoilMessageN.setType(String.valueOf(SoilMessage.get("TYPE")));
		SoilMessageN.setValiddate(String.valueOf(SoilMessage.get("VALIDDATE")));
		SoilMessageN.setValiddate(String.valueOf(SoilMessage.get("SOILLOCATION")));
		SoilMessageN.setValiddate(String.valueOf(SoilMessage.get("CONTACTWAY")));
		
		return SoilMessageN;
	}
	public PageBean showAll(String sql) {
		// TODO Auto-generated method stub
		return dao.showAll(sql); 
	}
	public Boolean updateSoilMessage(SoilMessageBean message,
			HttpSession session) {
		int id=message.getId();
		String ExtendedId = String.valueOf(message.getExtendedId());
		String Name=message.getNames();
		String Picture=message.getPicture();
		String Price=String.valueOf(message.getPrice());
		String Conversion_Property=message.getConversionProperty();
		String SoilArea=message.getSoilArea();
		String Negotiable_Year=message.getNegotiableYear();
		String SurplusYear=message.getSurplusYear();
		String Land_Warrants=message.getLandWarrants();
		String SoilUsing=message.getSoilUsing();
		String Type=message.getType();
		String Validdate=message.getValiddate();
		String SoilLocation=message.getSoilLocation();
		String ContactWay=message.getContactWay();
		
		String sql="update SoilMessage set ExtendedId="+ExtendedId+",Names='"+Name+"',Picture='"+Picture+"',Price="+Price+",Conversion_Property='"+Conversion_Property+"' ,SoilArea='"+SoilArea+"',Negotiable_Year='"+Negotiable_Year+"',SurplusYear='"+SurplusYear+"',Land_Warrants='"+Land_Warrants+"',SoilUsing='"+SoilUsing+"',Type='"+Type+"',Validdate='"+Validdate+"',SoilLocation='"+SoilLocation+"',ContactWay='"+ContactWay+"' where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, operator, session);
	}


	public PageBean select(String con1, String con2, String con3) {
		String sql = "select * from SoilMessage where 1=1"+con1+con2+con3;
		System.out.println("------"+sql);
				//通过id查询数据  
				return dao.showAll(sql);
	}


	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}




}
