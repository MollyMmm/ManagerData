package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.model.PageBean;

public class NoticeService {
	public interface Notice {
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean) ;
		boolean addNotice(NoticeBean notice,HttpSession session);
		boolean updateNotice(NoticeBean notice,HttpSession session);
		boolean deleteNotice(NoticeBean notice,HttpSession session);
		NoticeBean selectOne(String id);
		PageBean select(String con1,String con2,String con3);
	}
}
