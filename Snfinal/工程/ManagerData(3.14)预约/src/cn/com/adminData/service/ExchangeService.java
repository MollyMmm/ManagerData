package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.ExchangeBean;
import cn.com.adminData.model.GoodsMessageBean;
import cn.com.adminData.model.PageBean;

public class ExchangeService {
	public interface  Exchange{
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean);
		PageBean select(String con1,String con2,String con3);
		boolean updateExchange(ExchangeBean Exchange,HttpSession session);
	}

}
