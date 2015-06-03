package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.FarmingBean;
import cn.com.adminData.model.PageBean;

public class FarmingService {
	public interface  Farming {
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean) ;
		boolean addFarming(FarmingBean farming,HttpSession session);
		boolean updateFarming(FarmingBean farming,HttpSession session);
		boolean deleteFarming(FarmingBean farming,HttpSession session);
		FarmingBean selectOne(String id);
		PageBean select(String con1,String currentPage);
		String selectId(String body);
	}

}
