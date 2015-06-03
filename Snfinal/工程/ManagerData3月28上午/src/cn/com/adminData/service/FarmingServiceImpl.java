package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.FarmingBean;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.TechnicalBean;
import cn.com.adminData.service.FarmingService.Farming;
import cn.com.managerData.util.GetUserCreateTime;
import cn.com.managerData.util.JdbcUtil;

public class FarmingServiceImpl implements Farming{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	
	public boolean addFarming(FarmingBean farming, HttpSession session) {
		GetUserCreateTime time = new GetUserCreateTime();
		
		time.setCreateTime();
		String nowTime = time.getCreateTime();
		
		String sql = "insert into farming(ID,BODY,DATETIME,USERID) values(farming_seq.nextval,'"+farming.getBody()+"','"+nowTime+"',"+farming.getUserid()+")";
		
		int operator = 1;
		return dao.update(sql, operator, session);
	}

	public boolean deleteFarming(FarmingBean farming, HttpSession session) {
		int id=farming.getId();
		String sql = "delete from farming where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}

	public PageBean select(String con1,
			String currentPage) {
		String sql = "select * from farming where 1=1 and"+con1;
		System.out.println("------"+sql);

				PageBean pageBean = dao.searchGoPage(sql, currentPage);
				return pageBean;
	}

	public String selectId( String body) {
	String sql = "select id from technical where body ='"+body+"'";
		
		return String.valueOf(jdbc.query(sql).get(0).get("ID"));
	}

	public FarmingBean selectOne(String id) {
		FarmingBean farmingN=new FarmingBean();
		
		String sql = "select * from farming where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		
		//存放一个对象的map
		Map<String,Object> farming = list.get(0);
		farmingN.setId(Integer.parseInt(String.valueOf(farming.get("ID"))));
		farmingN.setUserid((Integer.parseInt(String.valueOf(farming.get("USERID")))));
		farmingN.setBody(String.valueOf(farming.get("BODY")));
		farmingN.setDatetime(String.valueOf(farming.get("DATETIME")));
		
		return farmingN;
	}

	public PageBean showAll(String sql) {
		return dao.showAll(sql);
	}

	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}

	public boolean updateFarming(FarmingBean farming, HttpSession session) {
		String sql = "update farming set userid="+farming.getUserid()+",body='"+farming.getBody()+"' where id="+farming.getId();
		
		int operator = 3;
		return dao.update(sql, operator, session);
	}

	
}
