package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SellingGoodsBean;
import cn.com.adminData.model.PageBean;

public class SellingGoodsService {
	public interface  SellingGoods{
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean) ;
		boolean addSellingGoods(SellingGoodsBean sellingGoods,HttpSession session);
		boolean updateSellingGoodse(SellingGoodsBean sellingGoods,HttpSession session);
		boolean deleteSellingGoods(SellingGoodsBean sellingGoods,HttpSession session);
		SellingGoodsBean selectOne(String id);
		PageBean select(String con1,String con2,String con3,String currentPage);
		String selectId(String title,String body);
	}

}
