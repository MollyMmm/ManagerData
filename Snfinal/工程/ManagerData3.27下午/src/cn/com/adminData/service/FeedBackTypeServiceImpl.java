package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.service.FeedBackTypeService.FeedBackType;
import cn.com.managerData.util.JdbcUtil;

public class FeedBackTypeServiceImpl implements FeedBackType{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	
	/**
	 * 显示全部公告类型
	 */
	public List<Map<String, Object>> allType() {
		String sql = "select *from FeedBackType";
		return jdbc.query(sql);
	}
/**
 *删除反馈类型 : 根据id
 */
	public boolean delType(String id,HttpSession session) {
		String sql = "delete from FeedBackType where id="+id;
		
		return dao.update(sql, 2, session);
	}
/**
 * 添加反馈类型
 */
	public boolean addType(String type,HttpSession session) {
		String sql = "insert into FeedBackType(id,typename) values (FeedBackType_seq.nextval,'"+type+"')";
System.out.println(sql);
		//boolean result =(jdbc.update(sql)==1)?true:false;
		return dao.update(sql, 1, session);
	}


}
