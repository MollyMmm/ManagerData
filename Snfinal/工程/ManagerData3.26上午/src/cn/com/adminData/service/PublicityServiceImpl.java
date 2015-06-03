package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.PublicityBean;
import cn.com.adminData.service.PublicityService.Publicity;
import cn.com.managerData.util.JdbcUtil;

public class PublicityServiceImpl implements Publicity{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	public boolean addPublicity(PublicityBean Publicity,HttpSession session) {
		String Title=Publicity.getTitle();
		String Bodys=Publicity.getBodys();
		String Type=Publicity.getType();
		String Start_time=Publicity.getStart_time();
		String Update_time=Publicity.getUpdate_time();
		int Process=Publicity.getProcess();
		String Name=Publicity.getName();
		String ID_item=Publicity.getID_item();
		String sql="insert into Publicity (id,Title,Bodys,Type,Start_time,Update_time,Process,Name,ID_item) values(Publicity_seq.nextval,'"+Title+"','"+Bodys+"','"+Type+"',to_date('"+Start_time+"','yyyy/mm/dd'),to_date('"+Update_time+"','yyyy/mm/dd'),"+Process+",'"+Name+"','"+ID_item+"')";
System.out.println("--------------------"+sql);
		int operator = 1;
		return dao.update(sql, operator, session);
	}
	public boolean deletePublicity(PublicityBean Publicity,HttpSession session) {
		int id = Publicity.getID();
		String sql = "delete from Publicity where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}
	public PublicityBean selectOne(String id) {
		PublicityBean PublicityN=new PublicityBean();
		String sql = "select * from Publicity where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		//存放一个对象的map
		Map<String,Object> Publicity = list.get(0);
		PublicityN.setID(Integer.parseInt(String.valueOf(Publicity.get("ID"))));
		PublicityN.setTitle(String.valueOf(Publicity.get("TITLE")));
		PublicityN.setBodys(String.valueOf(Publicity.get("BODYS")));
		PublicityN.setType(String.valueOf(Publicity.get("TYPE")));
		PublicityN.setStart_time(String.valueOf(Publicity.get("START_TIME")));
		PublicityN.setUpdate_time(String.valueOf(Publicity.get("UPDATE_TIME")));
		PublicityN.setProcess(Integer.parseInt(String.valueOf(Publicity.get("PROCESS"))));
		PublicityN.setName(String.valueOf(Publicity.get("NAME")));
		PublicityN.setID_item(String.valueOf(Publicity.get("ID_ITEM")));
		return PublicityN;
	}
	public PageBean showAll(String sql) {
		return dao.showAll(sql);
	}

	public boolean updatePublicity(PublicityBean Publicity, HttpSession session) {
		int id=Publicity.getID();
		String Title=Publicity.getTitle();
		String Type=Publicity.getType();
		String Start_time=Publicity.getStart_time();
		String Update_time=Publicity.getUpdate_time();
		String Process=String.valueOf(Publicity.getProcess());
		String Name=Publicity.getName();
		String ID_item=Publicity.getID_item();
		String sql="update Publicity set Title='"+Title+"',Type='"+Type+"',Start_time=to_date('"+Start_time+"','yyyy/mm/dd'),Update_time=to_date('"+Update_time+"','yyyy/mm/dd'),Process="+Process+",Name='"+Name+"' ,ID_item='"+ID_item+"'where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, operator, session);
	}
	//根据条件查询函数
	public PageBean select(String con1, String con2, String con3) {

		String sql = "select * from Publicity where 1=1"+con1+con2+con3;
System.out.println("------"+sql);
		//通过id查询数据  
		return dao.showAll(sql);
	}
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}
}
