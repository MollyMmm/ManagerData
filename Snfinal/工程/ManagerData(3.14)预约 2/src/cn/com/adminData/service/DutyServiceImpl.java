
package cn.com.adminData.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.service.DutyService.Duty;
import cn.com.managerData.util.JdbcUtil;

public class DutyServiceImpl implements Duty{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	/**
	 * 根据 具体哪天 查询 专家名称    获得的map : <day,e_name>
	 */

	public List<Map<String, Object>> searchOne(String year,String month,String day) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String date = year+"/"+month+"/"+day;
		
		String sql = "select e.names,d.id from duty d,ExpertMessage e where e.id=d.e_id and d.day='"+ date + "'";
System.out.println(sql);	
//执行查询操作
		List<Map<String, Object>> list = jdbc.query(sql);
System.out.println(list.size());	
		return list;
	}

}

