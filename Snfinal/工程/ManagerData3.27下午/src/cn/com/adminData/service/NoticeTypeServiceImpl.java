package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.service.NoticeTypeService.NoticeType;
import cn.com.managerData.util.JdbcUtil;

public class NoticeTypeServiceImpl  implements NoticeType{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	/**
	 * ��ʾȫ����������
	 */
	public List<Map<String, Object>> allType() {
		String sql = "select *from NoticeType";
		return jdbc.query(sql);
	}
/**
 *ɾ���������� : ����id
 */
	public boolean delType(String id,HttpSession session) {
		String sql = "delete from Noticetype where id="+id;
		
		return dao.update(sql, 2, session);
	}
/**
 * ��ӹ�������
 */
	public boolean addType(String type,HttpSession session) {
		String sql = "insert into noticetype(id,typename) values (noticetype_seq.nextval,'"+type+"')";
System.out.println(sql);
		//boolean result =(jdbc.update(sql)==1)?true:false;
		return  dao.update(sql, 1, session);
	}

}
