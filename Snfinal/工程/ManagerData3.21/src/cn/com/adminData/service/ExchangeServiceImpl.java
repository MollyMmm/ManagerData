package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.ExchangeBean;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.ExchangeService.Exchange;
import cn.com.managerData.util.JdbcUtil;

public class ExchangeServiceImpl implements Exchange {
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	public PageBean showAll(String sql) {
		
		return dao.showAll(sql);
	}
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}
	
	public boolean updateExchange(ExchangeBean Exchange, HttpSession session) {
		int id=Exchange.getId();
		String tel=Exchange.getTel();
		String sorce=String.valueOf(Exchange.getScorce());
		String sql="update sorces set u_sorce="+sorce+" where u_id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, operator, session);
	}
	public PageBean select(String con1, String con2) {
		String sql = "select Personsn.Phonenumber,Sorces.U_SORCE from Personsn inner join Sorces on Personsn.id= Sorces.u_id where 1=1"+con1+con2;
		
				//通过id查询数据  
				return dao.showAll(sql);
	}
	
	
	}
	
	


