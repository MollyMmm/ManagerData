package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.GoodsMessageBean;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.GoodsMessageService.GoodsMessage;
import cn.com.managerData.util.JdbcUtil;

public class GoodsMessageServiceImpl implements GoodsMessage{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	public boolean addGoodsMessage(GoodsMessageBean GoodsMessage,HttpSession session) {
		int ExtendedId = GoodsMessage.getExtendedId();
		String Names=GoodsMessage.getName();
		String Picture=GoodsMessage.getPicture();
		int Price=GoodsMessage.getPrice();
		int PrePrice=GoodsMessage.getPrePrice();
		String Introduction=GoodsMessage.getIntroduction();
		
	
		String sql="insert into GoodsMessage (id,ExtendedId,Names,Picture,Price,PrePrice,Introduction) values(GoodsMessage_seq.nextval,"+ExtendedId+",'"+Names+"','"+Picture+"',"+Price+","+PrePrice+",'"+Introduction+"')";
		int operator = 1;
		return dao.update(sql, operator, session);
	}
	public boolean deleteGoodsMessage(GoodsMessageBean GoodsMessage,HttpSession session) {
		int id = GoodsMessage.getID();
		String sql = "delete from GoodsMessage where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}
	public GoodsMessageBean selectOne(String id) {
		GoodsMessageBean GoodsMessageN=new GoodsMessageBean();
		String sql = "select * from GoodsMessage where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		//存放一个对象的map
		Map<String,Object> GoodsMessage = list.get(0);
		GoodsMessageN.setID(Integer.parseInt(String.valueOf(GoodsMessage.get("ID"))));
		GoodsMessageN.setExtendedId(Integer.parseInt(String.valueOf(GoodsMessage.get("EXTENDEDID"))));
		GoodsMessageN.setName(String.valueOf(GoodsMessage.get("NAMES")));
		GoodsMessageN.setPicture(String.valueOf(GoodsMessage.get("PICTURE")));
		GoodsMessageN.setPrice(Integer.parseInt(String.valueOf(GoodsMessage.get("PRICE"))));
		GoodsMessageN.setPrePrice(Integer.parseInt(String.valueOf(GoodsMessage.get("PREPRICE"))));
		GoodsMessageN.setIntroduction(String.valueOf(GoodsMessage.get("INTRODUCTION")));
		return GoodsMessageN;
	}
	public PageBean showAll(String sql) {
		
		return dao.showAll(sql);
	}

	public boolean updateGoodsMessage(GoodsMessageBean GoodsMessage,
			HttpSession session) {
		int id=GoodsMessage.getID();
		String ExtendedId = String.valueOf(GoodsMessage.getExtendedId());
		String Names=GoodsMessage.getName();
		String Picture=GoodsMessage.getPicture();
		String Price=String.valueOf(GoodsMessage.getPrice());
		String PrePrice=String.valueOf(GoodsMessage.getPrePrice());
		String Introduction=GoodsMessage.getIntroduction();
		String sql="update GoodsMessage set ExtendedId="+ExtendedId+",Names='"+Names+"',Picture='"+Picture+"',Price="+Price+",PrePrice="+PrePrice+",Introduction='"+Introduction+"' where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, operator, session);
		
	}
	//根据条件查询函数
	public PageBean select(String con1, String con2, String con3) {

		String sql = "select * from GoodsMessage where 1=1"+con1+con2+con3;
System.out.println("------"+sql);
		//通过id查询数据  
		return dao.showAll(sql);
}
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}}
