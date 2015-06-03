package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.SellingSoilBean;

public interface SellingSoilService {
	PageBean showAll(String sql);
	PageBean showOther(PageBean pageBean) ;
	Boolean addSellingSoil(SellingSoilBean postmessage,HttpSession session);
	Boolean deleteSellingSoil(SellingSoilBean postmessage,HttpSession session);
	Boolean updateSellingSoil(SellingSoilBean postmessage,HttpSession session);
	SellingSoilBean selectOne(String id);
	PageBean select(String con1,String con2,String con3 );//根据三个条件查询
}
