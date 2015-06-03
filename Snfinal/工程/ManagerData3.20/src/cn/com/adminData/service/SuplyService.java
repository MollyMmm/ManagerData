package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.SuplyBean;

public class SuplyService {
	public interface Suply {
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean) ;
		boolean addSuply(SuplyBean suply,HttpSession session);
		boolean updateSuply(SuplyBean suply,HttpSession session);
		boolean deleteSuply(SuplyBean suply,HttpSession session);
		SuplyBean selectOne(String id);
		PageBean select(String con1,String con2,String con3,String currentPage);
		String selectId(String title,String body);
	}

}
