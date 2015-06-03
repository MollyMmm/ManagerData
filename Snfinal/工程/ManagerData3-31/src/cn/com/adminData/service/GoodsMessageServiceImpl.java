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
		String Address=GoodsMessage.getAddress();
		String Introduction=GoodsMessage.getIntroduction();
		
	
		String sql="insert into ShopsMessage (id,ExtendedId,Names,Picture,Introduction,Address) values(ShopsMessage_seq.nextval,"+ExtendedId+",'"+Names+"','"+Picture+"','"+Introduction+"','"+Address+"')";
		int operator = 1;
		return dao.update(sql, operator, session);
	}
	public boolean deleteGoodsMessage(GoodsMessageBean GoodsMessage,HttpSession session) {
		int id = GoodsMessage.getID();
		String sql = "delete from ShopsMessage where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}
	public GoodsMessageBean selectOne(String id) {
		GoodsMessageBean GoodsMessageN=new GoodsMessageBean();
		String sql = "select * from ShopsMessage where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		//存放一个对象的map
		Map<String,Object> GoodsMessage = list.get(0);
		GoodsMessageN.setID(Integer.parseInt(String.valueOf(GoodsMessage.get("ID"))));
		GoodsMessageN.setExtendedId(Integer.parseInt(String.valueOf(GoodsMessage.get("EXTENDEDID"))));
		GoodsMessageN.setName(String.valueOf(GoodsMessage.get("NAMES")));
		GoodsMessageN.setPicture(String.valueOf(GoodsMessage.get("PICTURE")));
		GoodsMessageN.setAddress(String.valueOf(GoodsMessage.get("ADDRESS")));
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
		String Address=GoodsMessage.getAddress();
		String Introduction=GoodsMessage.getIntroduction();
		String sql="update Shopsmessage set ExtendedId="+ExtendedId+",Names='"+Names+"',Picture='"+Picture+",Introduction='"+Introduction+",Address='"+Address+"' where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, operator, session);
		
	}
	//根据条件查询函数
	public PageBean select(String con1, String con2, String con3) {

		String sql = "select * from ShopsMessage where 1=1"+con1+con2+con3;
System.out.println("------"+sql);
		//通过id查询数据  
		return dao.showAll(sql);
}
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}}
