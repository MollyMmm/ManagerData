package cn.com.adminData.dao;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;

public interface BaseDao {
	public PageBean showAll(String sql) ;
	public PageBean showOther(PageBean pageBean) ;
	public List<Map<String,Object>> showOne(String sql);
	public boolean update(String sql,int operator,HttpSession session);
	public PageBean searchGoPage(String sql,String currentPage);

}
	
