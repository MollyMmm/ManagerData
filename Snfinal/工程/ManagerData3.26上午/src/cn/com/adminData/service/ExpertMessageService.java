package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.ExpertMessageBean;
import cn.com.adminData.model.PageBean;

public interface ExpertMessageService {
	PageBean showAll(String sql);
	PageBean showOther(PageBean pageBean) ;
	Boolean addExpertMessage(ExpertMessageBean message,HttpSession session);
	Boolean deleteMessageService(ExpertMessageBean message,HttpSession session);
	Boolean updateMessageService(ExpertMessageBean message,HttpSession session);
	ExpertMessageBean selectOne(String id);
	PageBean select(String con1,String con2,String con3 );//根据三个条件查询

}
