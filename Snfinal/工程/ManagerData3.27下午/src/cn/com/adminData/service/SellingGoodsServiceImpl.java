package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.SellingGoodsBean;
import cn.com.adminData.service.SellingGoodsService.SellingGoods;
import cn.com.managerData.util.JdbcUtil;

public class SellingGoodsServiceImpl implements SellingGoods{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	
	public boolean addSellingGoods(SellingGoodsBean sellingGoods,
			HttpSession session) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteSellingGoods(SellingGoodsBean sellingGoods,
			HttpSession session) {
		int id=sellingGoods.getId();
		String sql = "delete from goods where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}

	public PageBean select(String con1, String con2, String con3,
			String currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	public String selectId(String title, String body) {
		// TODO Auto-generated method stub
		return null;
	}

	public SellingGoodsBean selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageBean showAll(String sql) {
		return dao.showAll(sql);
	}

	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}

	public boolean updateSellingGoodse(SellingGoodsBean sellingGoods,
			HttpSession session) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
