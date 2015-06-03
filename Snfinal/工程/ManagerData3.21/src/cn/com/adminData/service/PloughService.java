package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.PloughBean;


public class PloughService {
	public interface Plough {
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean) ;
		boolean addPlough(PloughBean Plough,HttpSession session);
		boolean updatePlough(PloughBean Plough,HttpSession session);
		boolean deletePlough(PloughBean Plough,HttpSession session);
		PloughBean selectOne(String id);
		PageBean select(String con1,String con2,String con3);
	}
}
