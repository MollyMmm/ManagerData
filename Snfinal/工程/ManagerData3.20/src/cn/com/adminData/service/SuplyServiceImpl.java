package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.SuplyBean;
import cn.com.adminData.service.SuplyService.Suply;
import cn.com.managerData.util.JdbcUtil;

public class SuplyServiceImpl implements Suply{

	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	
	public boolean addSuply(SuplyBean suply, HttpSession session) {
		
		String sql = "insert into goodsmessage(id,extendedid,names,picture,price,preprice,introduction) values(goodsmessage_seq.nextval,"+suply.getExtendedId()+",'"+suply.getNames()+"'," +
				"'"+suply.getPicture()+"','"+suply.getPrice()+"',"+suply.getPreprice()+","+suply.getPreprice()+",'"+suply.getIntroduction()+"')";
		System.out.println("------------------------"+sql);
		int operator = 1;
		return dao.update(sql, operator, session);
	}

	public boolean deleteSuply(SuplyBean suply, HttpSession session) {
	
		int id=suply.getId();
		String sql = "delete from goodsmessage where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}

	public PageBean select(String con1, String con2, String con3,
			String currentPage) {
		String sql = "select * from goodsmessage where 1=1 and"+con1+con2+con3;
		System.out.println("------"+sql);

				PageBean pageBean = dao.searchGoPage(sql, currentPage);
				return pageBean;
			}

	public String selectId(String names, String introduction) {
	String sql = "select id from goodsmessage where names='"+names+"' and introduction ='"+introduction+"'";
		
		return String.valueOf(jdbc.query(sql).get(0).get("ID"));
	}

	public SuplyBean selectOne(String id) {
		SuplyBean suplyN=new SuplyBean();
		
		String sql = "select * from goodsmessage where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		
		//存放一个对象的map
		Map<String,Object> suply = list.get(0);
		suplyN.setId(Integer.parseInt(String.valueOf(suply.get("ID"))));
		suplyN.setExtendedId(Integer.parseInt(String.valueOf(suply.get("EXTENDEDID"))));
		suplyN.setPicture(String.valueOf(suply.get("PICTURE")));
		suplyN.setPrice(String.valueOf(suply.get("PRICE")));
		suplyN.setPreprice(String.valueOf(suply.get("PREPRICE")));
		suplyN.setIntroduction(String.valueOf(suply.get("INTRODUCTION")));
		suplyN.setNames(String.valueOf(suply.get("NAMES")));
		
		return suplyN;
	}
	
	public PageBean showAll(String sql) {
		return dao.showAll(sql);
		}

	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}

	public boolean updateSuply(SuplyBean suply, HttpSession session) {
		String sql = "update goodsmessage set extendedid="+suply.getExtendedId()+",names='"+suply.getNames()+"',picture='"+suply.getPicture()+"',price='"+suply.getPrice()+"',preprice='"+suply.getPreprice()+"',introduction='"+suply.getIntroduction()+"' where id="+suply.getId();
		
		int operator = 3;
		return dao.update(sql, operator, session);
		}
	
}
