package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.GoodsMessageBean;
import cn.com.adminData.model.PageBean;


public class GoodsMessageService {
	public interface GoodsMessage {
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean) ;
		boolean addGoodsMessage(GoodsMessageBean GoodsMessage,HttpSession session);
		boolean updateGoodsMessage(GoodsMessageBean GoodsMessage,HttpSession session);
		boolean deleteGoodsMessage(GoodsMessageBean GoodsMessage,HttpSession session);
		GoodsMessageBean selectOne(String id);
		PageBean select(String con1,String con2,String con3);
	}

}
