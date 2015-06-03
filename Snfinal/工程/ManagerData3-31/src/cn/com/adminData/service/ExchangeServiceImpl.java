package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.sun.org.apache.regexp.internal.recompile;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.ExchangeBean;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.ExchangeService.Exchange;
import cn.com.managerData.util.JdbcUtil;

public class ExchangeServiceImpl implements Exchange {
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	public PageBean showAll(String sql) {
		
		return dao.showAll(sql, null);
	}
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean, null);
	}
	
	public boolean updateExchange(ExchangeBean Exchange, HttpSession session) {
		int id=Exchange.getId();
		String tel=Exchange.getTel();
		String sorce=String.valueOf(Exchange.getScorce());
		String sql="update sorces set u_sorce="+sorce+" where u_id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, null, operator, session);
	}
	public PageBean select(String con1, String con2) {
		String sql = "select Personsn.Phonenumber,Sorces.U_SORCE from Personsn inner join Sorces on Personsn.id= Sorces.u_id where 1=1"+con1+con2;
	
				//通过id查询数据  
				return dao.showAll(sql, null);
	}
	public boolean insertExchange(String con1,String  con2, String con3,String con4,HttpSession session) {
		
		
		String sql =" insert into Charge (id,PersonID,ChargeType,Amount,AdName)values (Charge_seq.nextval,'"+con1+"','"+con2+"','"+con3+"','"+con4+"')";
		int operator = 1;
		return dao.update(sql, operator, session);
		
		
		
	}

	}
	
	


