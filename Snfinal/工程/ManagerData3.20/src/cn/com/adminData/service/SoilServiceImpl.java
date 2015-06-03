package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.SoilBean;
import cn.com.adminData.service.SoilService.Soil;
import cn.com.managerData.util.GetUserCreateTime;
import cn.com.managerData.util.JdbcUtil;

public class SoilServiceImpl implements Soil{

	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	
	public boolean addSoil(SoilBean soil, HttpSession session) {
		GetUserCreateTime time = new GetUserCreateTime();
		//获取当前时间:发布的时候, 更新时间等于发布时间
		time.setCreateTime();
		String nowTime = time.getCreateTime();
		
		String sql = "insert into sellingsoil(id,extendedid,title,soilmessage,tradelocation,publishtime,updatetime,salerid,salername,contactmethod,validdate,isvalid) values(sellinggoods_seq.nextval,"+soil.getExtendedid()+
		",'"+soil.getTitle()+"','"+soil.getProduct_message()+"','"+soil.getTrade_location()+"','"+nowTime+"','"+nowTime+"','"+soil.getSaler_id()+"','"+soil.getSaler_name()+"','"+soil.getContact_method()+"','"+soil.getValid_date()+"','"+soil.getIsvalid()+"')";
System.out.println("------------------------"+sql);
		int operator = 1;
		return dao.update(sql, operator, session);
	}

	public boolean deleteSoil(SoilBean soil, HttpSession session) {
		int id=soil.getId();
		
		String sql = "delete from sellingsoil where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}
	public PageBean select(String con1, String con2, String con3,
			String currentPage) {
		String sql = "select * from sellingsoil where 1=1 "+con1+con2+con3;
		System.out.println("------"+sql);

		PageBean pageBean = dao.searchGoPage(sql, currentPage);
		return pageBean;
	}

	public String selectId(String names, String soilLocation) {
String sql = "select id from sellingsoil where names='"+names+"' and soilLocation ='"+soilLocation+"'";
		
		return String.valueOf(jdbc.query(sql).get(0).get("ID"));	}

	public SoilBean selectOne(String id) {
		SoilBean sellinggoodsN=new SoilBean();
		
		String sql = "select * from sellingsoil where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		
		//存放一个对象的map
		Map<String,Object> sellinggoods = list.get(0);
		
		sellinggoodsN.setId(Integer.parseInt(String.valueOf(sellinggoods.get("ID"))));
		sellinggoodsN.setExtendedid(Integer.parseInt(String.valueOf(sellinggoods.get("EXTENDEDID"))));
		sellinggoodsN.setProduct_message(String.valueOf(sellinggoods.get("SOILMESSAGE")));
		sellinggoodsN.setSaler_id(Integer.parseInt(String.valueOf(sellinggoods.get("SALERID"))));
		sellinggoodsN.setTitle(String.valueOf(sellinggoods.get("TITLE")));
		sellinggoodsN.setContact_method(String.valueOf(sellinggoods.get("CONTACTMETHOD")));
		sellinggoodsN.setPublic_time(String.valueOf(sellinggoods.get("PUBLISHTIME")));
		sellinggoodsN.setSaler_name(String.valueOf(sellinggoods.get("SALERNAME")));
		sellinggoodsN.setTrade_location(String.valueOf(sellinggoods.get("TRADELOCATION")));
		sellinggoodsN.setValid_date(String.valueOf(sellinggoods.get("VALIDDATE")));
		sellinggoodsN.setIsvalid(String.valueOf(sellinggoods.get("ISVALID")));
		sellinggoodsN.setUpdate_time(String.valueOf(sellinggoods.get("UPDATETIME")));
		
		return sellinggoodsN;	
		}

	public PageBean showAll(String sql) {
		return dao.showAll(sql);
		}

	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}

	public boolean updateSoil(SoilBean soil, HttpSession session) {
		GetUserCreateTime time = new GetUserCreateTime();
		//获取当前时间:发布的时候, 更新时间等于发布时间
		time.setCreateTime();
		String nowTime = time.getCreateTime();
		
		String sql = "update sellingsoil set extendedid="+soil.getExtendedid() +",ISVALID='"+soil.getIsvalid()+"',"+
				"salerid="+soil.getSaler_id()+",title='"+soil.getTitle()+"',contactmethod='"+soil.getContact_method()+"'," +
						"SALERNAME='"+soil.getSaler_name()+"',TRADELOCATION='"+soil.getTrade_location()+"',VALIDDATE='"+soil.getValid_date()+"'," +
								"SOILMESSAGE='"+soil.getProduct_message()+"',UPDATETIME='"+nowTime+"'" +
								" where id="+soil.getId();
		
		int operator = 3;
		return dao.update(sql, operator, session);	}

}
