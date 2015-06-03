package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.YellowPageBean;
import cn.com.managerData.util.JdbcUtil;

public class YellowServiceImpl implements YellowService{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	
//删除信息
	public boolean deleteYellow(YellowPageBean yellow,HttpSession session) {
		int id = yellow.getId();
		String sql = "delete from YellowPage where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}

	
//根据id查询，然后更新
	public YellowPageBean selectOne(String id) {
		YellowPageBean YellowPageN=new YellowPageBean();
		
		String sql = "select * from YellowPage where id="+id;
System.out.println("-------------------"+sql);
		List<Map<String,Object>> list = dao.showOne(sql);
		//存放一个对象的map
	
		Map<String,Object> YellowPage = list.get(0);
		YellowPageN.setId(Integer.parseInt(String.valueOf(YellowPage.get("ID"))));
	
		YellowPageN.setExtendedId(Integer.parseInt(String.valueOf(YellowPage.get("EXYENDEDID"))));
	
		YellowPageN.setInstitution_Name(String.valueOf(YellowPage.get("INSTITUTION_NAME")));

		YellowPageN.setContactMethod(String.valueOf(YellowPage.get("CONTACTMETHOD")));

		YellowPageN.setLocation(String.valueOf(YellowPage.get("LOCATION")));

		return YellowPageN;
	}

//查询所有信息
	public PageBean showAll(String sql) {
		
		return dao.showAll(sql);
	}


//添加信息
	public boolean addYellow(YellowPageBean yellow, HttpSession session) {
		String ExyendedId = String.valueOf(yellow.getExtendedId());
		String Institution_Name=yellow.getInstitution_Name();
		String ContactMethod=yellow.getContactMethod();
		String Location=yellow.getLocation();
		String sql="insert into YellowPage (id,ExyendedId,Institution_Name,ContactMethod,Location) values(YellowPage_seq.nextval,"+ExyendedId+",'"+Institution_Name+"','"+ContactMethod+"','"+Location+"')";
		int operator = 1;
		return dao.update(sql, operator, session);
	}
	
	
//更新信息
	public boolean updateYellow(YellowPageBean yellow, HttpSession session) {
		int id=yellow.getId();
		String ExtendedId = String.valueOf(yellow.getExtendedId());
		String Institution_Name=yellow.getInstitution_Name();
		String ContactMethod=yellow.getContactMethod();
		String Location=yellow.getLocation();
		String sql="update YellowPage set ExyendedId="+ExtendedId+",Institution_Name='"+Institution_Name+"',ContactMethod='"+ContactMethod+"',Location='"+Location+"' where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, operator, session);
	}
	
	
//根据条件查询
	public PageBean select(String con1,String con2,String con3)
	{
		String sql = "select * from YellowPage where 1=1"+con1+con2+con3;
System.out.println("------"+sql);
		//通过id查询数据 
		return dao.showAll(sql);
	}


	public PageBean showOther(PageBean pageBean) {
		
		return dao.showOther(pageBean);
	}


}
