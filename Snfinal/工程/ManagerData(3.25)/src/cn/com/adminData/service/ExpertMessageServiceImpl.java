package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.ExpertMessageBean;
import cn.com.adminData.model.PageBean;
import cn.com.managerData.util.JdbcUtil;

public class ExpertMessageServiceImpl implements ExpertMessageService{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	public Boolean addExpertMessage(ExpertMessageBean message,
			HttpSession session) {
		
		//-------这里涉及上传图片，还没有做
		String ExtendedId = String.valueOf(message.getExtendedId());
		String Names = message.getNames();
		String Head_Portrait = message.getHead_Portrait();
		String Birth = message.getBirth();
		String Major = message.getMajor();
		String DutyTime = message.getDutyTime();

		String sql = "insert into ExpertMessage(id,ExtendedId,Names,Head_Portrait,Birth,Major,DutyTime) values(SoilMessage_seq.nextval,"+ExtendedId+",'"+Names+"','"+Head_Portrait+"','"+Birth+"','"+Major+"','"+DutyTime+"')";
		int operate = 1;
		return dao.update(sql,operate, session);
	}
	public Boolean deleteMessageService(ExpertMessageBean message,
			HttpSession session) {
		int id = message.getId();
		String sql = "delete from ExpertMessage where id="+String.valueOf(id);	
		int operate = 2;
		return dao.update(sql,operate,session);
	}
	public ExpertMessageBean selectOne(String id) {
		ExpertMessageBean ExpertMessageN=new ExpertMessageBean();
		String sql = "select * from ExpertMessage where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		//存放一个对象的map
		Map<String,Object> ExpertMessage = list.get(0);
		ExpertMessageN.setId(Integer.parseInt(String.valueOf(ExpertMessage.get("ID"))));
		ExpertMessageN.setExtendedId(Integer.parseInt(String.valueOf(ExpertMessage.get("EXTENDEDID"))));
		ExpertMessageN.setNames(String.valueOf(ExpertMessage.get("NAMES")));
		ExpertMessageN.setHead_Portrait(String.valueOf(ExpertMessage.get("HEAD_PORTRAIT")));
	    ExpertMessageN.setBirth(String.valueOf(ExpertMessage.get("BIRTH")));
		ExpertMessageN.setMajor(String.valueOf(ExpertMessage.get("MAJOR")));
		ExpertMessageN.setDutyTime(String.valueOf(ExpertMessage.get("DUTYTIME")));
		return ExpertMessageN;
	}
	public PageBean showAll(String sql) {
	return dao.showAll(sql);
	}
	public Boolean updateMessageService(ExpertMessageBean message,
			HttpSession session) {
		int id=message.getId();
		String ExtendedId = String.valueOf(message.getExtendedId());
		String Names=message.getNames();
		String Head_Portrait=message.getHead_Portrait();
		String Birth=message.getBirth();
		String Major=message.getMajor();
		String DutyTime=message.getDutyTime();
		String sql="update ExpertMessage set ExtendedId="+ExtendedId+",Names='"+Names+"',Head_Portrait='"+Head_Portrait+"',Birth='"+Birth+"',Major='"+Major+"',DutyTime='"+DutyTime+"' where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, operator, session);
	}
	public PageBean select(String con1, String con2, String con3) {
		String sql = "select * from ExpertMessage where 1=1"+con1+con2+con3;
		System.out.println("------"+sql);
				//通过id查询数据  
				return dao.showAll(sql);
	}
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}
	
	

}
