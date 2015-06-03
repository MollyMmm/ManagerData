package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.PublicityBean;

public class PublicityService {
	public interface Publicity {
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean) ;
		boolean addPublicity(PublicityBean Publicity,HttpSession session);
		boolean updatePublicity(PublicityBean Publicity,HttpSession session);
		boolean deletePublicity(PublicityBean Publicity,HttpSession session);
		PublicityBean selectOne(String id);
		PageBean select(String con1,String con2,String con3,String currentPage);
	}
}
