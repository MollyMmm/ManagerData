package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.PostMessageBean;

public interface PostMessageService {
	PageBean showAll(String sql);
	PageBean showOther(PageBean pageBean) ;
	Boolean addPostMessage(PostMessageBean postmessage,HttpSession session);
	Boolean deleteSoilMessage(PostMessageBean postmessage,HttpSession session);
	Boolean updateSoilMessage(PostMessageBean postmessage,HttpSession session);
	PostMessageBean selectOne(String id);
	PageBean select(String con1,String con2,String con3 );//根据三个条件查询


}
