package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.NewsBean;

public class NewsService {

	public interface News{
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean) ;
		boolean addnews(NewsBean news,HttpSession session);
		boolean updatenews(NewsBean news,HttpSession session);
		boolean deletenews(NewsBean news,HttpSession session);
		NewsBean selectOne(String id);
		PageBean select(String con1,String con2,String con3,String currentPage);
		String selectId(String title,String body);
	}
}
