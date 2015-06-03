package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.NoticeService.Notice;
import cn.com.managerData.model.AdminInfo;
import cn.com.managerData.util.GetUserCreateTime;
import cn.com.managerData.util.JdbcUtil;

public class NoticeServiceImpl implements Notice{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();

	
	public boolean addNotice(NoticeBean notice,HttpSession session) {
		GetUserCreateTime time = new GetUserCreateTime();
		
		int ExtendedId = notice.getExtendedId();
		String Title=notice.getTitle();
		String Body=notice.getBody();
		String MainBody=notice.getMainBody();
		String Picture=notice.getPicture();
		int Type=notice.getType();
		//发布者
		AdminInfo admin = (AdminInfo)session.getAttribute("admin");
		String adminName = admin.getUserName();
		//获取当前时间:发布的时候, 更新时间等于发布时间
		time.setCreateTime();
		String nowTime = time.getCreateTime();
		
		String sql="insert into Notice(id,ExtendedId,Title,Body,MainBody,PublishTime,UpdateTime,Picture,Type,editor) values(Notice_seq.nextval,?,?,?,?,?,?,?,?,?)";
System.out.println("------------------------"+sql);

		Object[] columns = {ExtendedId,Title,Body,MainBody,nowTime,nowTime,Picture,Type,"@"+adminName};
		int operator = 1;
		return dao.update(sql,columns, operator, session);
	}
	/***
	 * 删除公告信息
	 */
	public boolean deleteNotice(NoticeBean notice,HttpSession session) {
		int id=notice.getID();
		String sql = "delete from Notice where id=?";
		Object[] ids={String.valueOf(id)};
		
		int operator = 2;
		return dao.update(sql,ids, operator, session);
	}
	/**
	 * 查询一条公告信息
	 */
	public NoticeBean selectOne(String id) {
		NoticeBean NoticeN=new NoticeBean();
		
		String sql = "select * from Notice where id=?";
		Object[] ids = {id};
		List<Map<String,Object>> list = dao.showOne(sql,ids);
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
	/**
	 * 显示全部公告信息
	 */
	public PageBean showAll(String sql) {
		return dao.showAll(sql, null);
	}
/**
 * 更新公告信息
 */
	public boolean updateNotice(NoticeBean notice, HttpSession session) {
		GetUserCreateTime time = new GetUserCreateTime();
		
		int id=notice.getID();
		String ExtendedId = String.valueOf(notice.getExtendedId());
		String Title=notice.getTitle();
		String Body=notice.getBody();
		String MainBody=notice.getMainBody();
		String Picture=notice.getPicture();
		String Type=String.valueOf(notice.getType());
		//获取当前时间为更新时间
		time.setCreateTime();
		String UpdateTime=time.getCreateTime();
		//获取原有的发布者
		String oldSql = "select editor from Notice where id=?";
		Object[] ids = {String.valueOf(id)};
		
		String oldEditor = (String)jdbc.query(oldSql,ids).get(0).get("EDITOR");
		
		//获取当前的发布者
		AdminInfo admin = (AdminInfo)session.getAttribute("admin");
		String adminName = admin.getUserName();
		
		// 新的发布者
		String newEditor = oldEditor +"@"+ adminName;
		
		String sql="update Notice set ExtendedId=?,Title=?,Body=?,MainBody=?,UpdateTime=?,Picture=?,Type=?,editor=? where id=?";
		System.out.println("-------------"+sql);		
		Object[] columns = {ExtendedId,Title,Body,MainBody,UpdateTime,Picture,Type,newEditor,String.valueOf(id)};
		int operator = 3;
		return dao.update(sql,columns, operator, session);
	}
	/**根据条件查询函数
	 * 
	 */
	public PageBean select(String con1, String con2, String con3,String currentPage) {

		String sql = "select n.id,n.EXTENDEDID,n.TITLE,n.BODY,n.MAINBODY,n.PUBLISHTIME,n.UPDATETIME,n.PICTURE,n.TYPE,n.EDITOR,nt.typename from Notice n,noticetype nt where n.type=nt.id"+con1+con2+con3;
System.out.println("------"+sql);
		PageBean pageBean = dao.searchGoPage(sql, currentPage);
		return pageBean;

	}
	
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean,null);
	}
	/**
	 * 根据题目跟内容 查询 id
	 */
	public String selectId(String title,String body){
		String sql = "select id from notice where title=? and body =?";
		Object[] params = {title,body};
		return String.valueOf(jdbc.query(sql,params).get(0).get("ID"));
	}
}
