package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.TechnicalBean;
import cn.com.adminData.model.PageBean;

public class TechnicalService {
	public interface Technical {
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean) ;
		boolean addTechnical(TechnicalBean technical,HttpSession session);
		boolean updateTechnical(TechnicalBean technical,HttpSession session);
		boolean deleteTechnical(TechnicalBean technical,HttpSession session);
		TechnicalBean selectOne(String id);
		PageBean select(String con1,String con2,String con3,String currentPage);
		String selectId(String title,String body);
	}

}
