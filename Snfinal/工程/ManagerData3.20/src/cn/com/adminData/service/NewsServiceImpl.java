package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.NewsBean;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.NewsService.News;
import cn.com.managerData.util.GetUserCreateTime;
import cn.com.managerData.util.JdbcUtil;

public class NewsServiceImpl implements News{

	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	
	public boolean addnews(NewsBean news, HttpSession session) {
	GetUserCreateTime time = new GetUserCreateTime();
		
		int ExtendedId = news.getExtendedId();
		String Title=news.getTitle();
		String Body=news.getBody();
		String MainBody=news.getMainBody();
		
		time.setCreateTime();
		String nowTime = time.getCreateTime();
		
		String sql = "insert into news(ID,EXTENDEDID,TITLE,MAINBODY,BODY,PUBLISH_TIME,UPDATE_TIME) values(news_seq.nextval,"+ExtendedId+",'"+Title+"','"+MainBody+"','"+Body+"','"+nowTime+"','"+nowTime+"')";
System.out.println("------------------------"+sql);
		int operator = 1;
		return dao.update(sql, operator, session);
	}

	public boolean deletenews(NewsBean news, HttpSession session) {
		int id=news.getId();
		String sql = "delete from news where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}

	public PageBean select(String con1, String con2, String con3,
			String currentPage) {
		String sql = "select * from news where 1=1 "+con1+con2+con3;
System.out.println("------"+sql);

		PageBean pageBean = dao.searchGoPage(sql, currentPage);
		return pageBean;
	}

	public String selectId(String title, String body) {
		String sql = "select id from news where title='"+title+"' and body ='"+body+"'";
		
		return String.valueOf(jdbc.query(sql).get(0).get("ID"));	}

	public NewsBean selectOne(String id) {
NewsBean newsN=new NewsBean();
		
		String sql = "select * from news where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		
		//存放一个对象的map
		Map<String,Object> news = list.get(0);
		newsN.setId(Integer.parseInt(String.valueOf(news.get("ID"))));
		newsN.setExtendedId(Integer.parseInt(String.valueOf(news.get("EXTENDEDID"))));
		newsN.setTitle(String.valueOf(news.get("TITLE")));
		newsN.setBody(String.valueOf(news.get("BODY")));
		newsN.setPublic_time(String.valueOf(news.get("PUBLISH_TIME")));
		newsN.setMainBody(String.valueOf(news.get("MAINBODY")));
		newsN.setUpdate_time(String.valueOf(news.get("UPDATE_TIME")));
		
		return newsN;
	}

	public PageBean showAll(String sql) {
		return dao.showAll(sql);
	}

	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}

	public boolean updatenews(NewsBean news, HttpSession session) {
		GetUserCreateTime time = new GetUserCreateTime();
		
		time.setCreateTime();
		String nowTime = time.getCreateTime();
		
		String sql = "update news set EXTENDEDID="+news.getExtendedId()+",title='"+news.getTitle()+"',mainbody='"+news.getMainBody()+"'," +
				"body='"+news.getBody()+"',update_time='"+nowTime+"' where id="+news.getId();
		int operator = 3;
		return dao.update(sql, operator, session);
	}

}
