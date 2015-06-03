package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.NoticeService.Notice;
import cn.com.managerData.model.AdminInfo;
import cn.com.managerData.util.JdbcUtil;

public class NoticeServiceImpl implements Notice{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	public boolean addNotice(NoticeBean notice,HttpSession session) {
		int ExtendedId = notice.getExtendedId();
		String Title=notice.getTitle();
		String Body=notice.getBody();
		String MainBody=notice.getMainBody();
		String PublishTime=notice.getPublishTime();
		String UpdateTime=notice.getUpdateTime();
		String Picture=notice.getPicture();
		int Type=notice.getType();
		AdminInfo admin = (AdminInfo)session.getAttribute("admin");
		String adminName = admin.getUserName();
		
		String sql="insert into Notice(id,ExtendedId,Title,Body,MainBody,PublishTime,UpdateTime,Picture,Type,editor) values(Notice_seq.nextval,"+ExtendedId+",'"+Title+"','"+Body+"','"+MainBody+"','"+PublishTime+"','"+UpdateTime+"','"+Picture+"',"+Type+",@"+adminName+")";
System.out.println("------------------------"+sql);
		int operator = 1;
		return dao.update(sql, operator, session);
	}
	public boolean deleteNotice(NoticeBean notice,HttpSession session) {
		int id=notice.getID();
		String sql = "delete from Notice where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}
	public NoticeBean selectOne(String id) {
		NoticeBean NoticeN=new NoticeBean();
		String sql = "select * from Notice where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		//存放一个对象的map
		Map<String,Object> notice = list.get(0);
		NoticeN.setID(Integer.parseInt(String.valueOf(notice.get("ID"))));
		NoticeN.setExtendedId(Integer.parseInt(String.valueOf(notice.get("EXTENDEDID"))));
		NoticeN.setTitle(String.valueOf(notice.get("TITLE")));
		NoticeN.setBody(String.valueOf(notice.get("BODY")));
		NoticeN.setMainBody(String.valueOf(notice.get("MAINBODY")));
		NoticeN.setPublishTime(String.valueOf(notice.get("PUBLISHTIME")));
		NoticeN.setUpdateTime(String.valueOf(notice.get("UPDATETIME")));
		NoticeN.setPicture(String.valueOf(notice.get("PICTURE")));
		NoticeN.setType(Integer.parseInt(String.valueOf(notice.get("TYPE"))));
		return NoticeN;
	}
	public PageBean showAll(String sql) {
		return dao.showAll(sql);
	}

	public boolean updateNotice(NoticeBean notice, HttpSession session) {
		int id=notice.getID();
		String ExtendedId = String.valueOf(notice.getExtendedId());
		String Title=notice.getTitle();
		String Body=notice.getBody();
		String MainBody=notice.getMainBody();
		String PublishTime=notice.getPublishTime();
		String UpdateTime=notice.getUpdateTime();
		String Picture=notice.getPicture();
		String Type=String.valueOf(notice.getType());
		String sql="update Notice set ExtendedId="+ExtendedId+",Title='"+Title+"',Body='"+Body+"',MainBody='"+MainBody+"',PublishTime='"+PublishTime+"',UpdateTime='"+UpdateTime+"',Picture='"+Picture+"',Type="+Type+" where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, operator, session);
	}
	//根据条件查询函数
	public PageBean select(String con1, String con2, String con3) {

		String sql = "select * from Notice where 1=1"+con1+con2+con3;
System.out.println("------"+sql);
		//通过id查询数据  
		return dao.showAll(sql);
	}
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}
}
