package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.TechnicalBean;
import cn.com.adminData.service.TechnicalService.Technical;
import cn.com.managerData.util.GetUserCreateTime;
import cn.com.managerData.util.JdbcUtil;

public class TechnicalServiceImpl implements Technical{

	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	
	public boolean addTechnical(TechnicalBean technical, HttpSession session) {
		GetUserCreateTime time = new GetUserCreateTime();
		
		int ExtendedId = technical.getExtendedid();
		String Title=technical.getTitle();
		String Body=technical.getBody();
		String Type=technical.getType();
		String Name = technical.getName();
		
		time.setCreateTime();
		String nowTime = time.getCreateTime();
		
		String sql = "insert into technical(ID,EXTENDEDID,TITLE,NAME,BODY,PUBLISHTIME,TYPE) values(technical_seq.nextval,"+ExtendedId+",'"+Title+"','"+Name+"','"+Body+"','"+nowTime+"','"+Type+"')";
System.out.println("------------------------"+sql);
		int operator = 1;
		return dao.update(sql, operator, session);
	}

	public boolean deleteTechnical(TechnicalBean technical, HttpSession session) {

		int id=technical.getId();
		String sql = "delete from technical where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}

	public PageBean select(String con1, String con2, String con3,
			String currentPage) {
		String sql = "select * from technical where 1=1 "+con1+con2+con3;
System.out.println("------"+sql);

		PageBean pageBean = dao.searchGoPage(sql, currentPage);
		return pageBean;
	}

	public String selectId(String title, String body) {
	String sql = "select id from technical where title='"+title+"' and body ='"+body+"'";
		
		return String.valueOf(jdbc.query(sql).get(0).get("ID"));
	}

	public TechnicalBean selectOne(String id) {
	TechnicalBean TechnicalN=new TechnicalBean();
		
		String sql = "select * from Technical where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		
		//存放一个对象的map
		Map<String,Object> Technical = list.get(0);
		TechnicalN.setId(Integer.parseInt(String.valueOf(Technical.get("ID"))));
		TechnicalN.setExtendedid(Integer.parseInt(String.valueOf(Technical.get("EXTENDEDID"))));
		TechnicalN.setTitle(String.valueOf(Technical.get("TITLE")));
		TechnicalN.setBody(String.valueOf(Technical.get("BODY")));
		TechnicalN.setPublishtime(String.valueOf(Technical.get("PUBLISHTIME")));
		TechnicalN.setType(String.valueOf(Technical.get("TYPE")));
		TechnicalN.setName(String.valueOf(Technical.get("NAME")));
		
		return TechnicalN;
	}

	public PageBean showAll(String sql) {
		return dao.showAll(sql);
		}

	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}

	public boolean updateTechnical(TechnicalBean technical, HttpSession session) {
		
		String sql =" update technical set ExtendedId="+technical.getExtendedid()+",Title='"+technical.getTitle()+"',Body='"+technical.getBody()+"',Name='"+technical.getName()+"',Type='"+technical.getType()+"' where id="+technical.getId();
		
		int operator = 3;
		return dao.update(sql, operator, session);
	}



}
