package cn.com.adminData.dao;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;

public interface BaseDao {
	public PageBean showAll(String sql,Object[] params) ;
	public PageBean showOther(PageBean pageBean,Object[] params) ;
	public List<Map<String,Object>> showOne(String sql,Object[] params);
	public boolean update(String sql,Object[] params,int operator,HttpSession session);
	public PageBean searchGoPage(String sql,Object[] params,String currentPage);

}
	
