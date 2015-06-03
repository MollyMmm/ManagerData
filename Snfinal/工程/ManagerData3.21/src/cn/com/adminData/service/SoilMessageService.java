package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.SoilMessageBean;

public interface SoilMessageService {
	PageBean showAll(String sql);
	PageBean showOther(PageBean pageBean) ;
	Boolean addSoilMessage(SoilMessageBean message,HttpSession session);
	Boolean deleteSoilMessage(SoilMessageBean message,HttpSession session);
	Boolean updateSoilMessage(SoilMessageBean message,HttpSession session);
	SoilMessageBean selectOne(String id);	
	PageBean select(String con1,String con2,String con3 );//根据三个条件查询
}
