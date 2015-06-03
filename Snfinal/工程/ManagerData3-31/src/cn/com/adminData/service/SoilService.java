package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.SoilBean;

public class SoilService {

	public interface Soil{
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean) ;
		boolean addSoil(SoilBean soil,HttpSession session);
		boolean updateSoil(SoilBean soil,HttpSession session);
		boolean deleteSoil(SoilBean soil,HttpSession session);
		SoilBean selectOne(String id);
		PageBean select(String con1,String con2,String con3,String currentPage);
		String selectId(String title,String body);

	}
}
