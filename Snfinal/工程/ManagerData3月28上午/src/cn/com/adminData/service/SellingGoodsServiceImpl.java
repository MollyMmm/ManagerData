package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.SellingGoodsBean;
import cn.com.adminData.service.SellingGoodsService.SellingGoods;
import cn.com.managerData.util.GetUserCreateTime;
import cn.com.managerData.util.JdbcUtil;

public class SellingGoodsServiceImpl implements SellingGoods{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	
	public boolean addSellingGoods(SellingGoodsBean sellingGoods,
			HttpSession session) {
		GetUserCreateTime time = new GetUserCreateTime();
		//获取当前时间:发布的时候, 更新时间等于发布时间
		time.setCreateTime();
		String nowTime = time.getCreateTime();
		
		String sql = "insert into sellinggoods(id,extendedid,title,product_message,trade_location,public_time,update_time,saler_id,saler_name,contact_method,valid_date,isvalid) values(sellinggoods_seq.nextval,"+sellingGoods.getExtendedid()+
		",'"+sellingGoods.getTitle()+"','"+sellingGoods.getProduct_message()+"','"+sellingGoods.getTrade_location()+"','"+nowTime+"','"+nowTime+"','"+sellingGoods.getSaler_id()+"','"+sellingGoods.getSaler_name()+"','"+sellingGoods.getContact_method()+"','"+sellingGoods.getValid_date()+"','"+sellingGoods.getIsvalid()+"')";
System.out.println("------------------------"+sql);
		int operator = 1;
		return dao.update(sql, operator, session);
	}

	public boolean deleteSellingGoods(SellingGoodsBean sellingGoods,
			HttpSession session) {
		int id=sellingGoods.getId();
		
		String sql = "delete from goods where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}

	public PageBean select(String con1, String con2, String con3,
			String currentPage) {
		String sql = "select * from sellinggoods where 1=1 and"+con1+con2+con3;
		System.out.println("------"+sql);

				PageBean pageBean = dao.searchGoPage(sql, currentPage);
				return pageBean;	}

	public String selectId(String title, String product_message) {
String sql = "select id from sellinggoods where title='"+title+"' and product_message ='"+product_message+"'";
		
		return String.valueOf(jdbc.query(sql).get(0).get("ID"));
	}

	public SellingGoodsBean selectOne(String id) {
SellingGoodsBean sellinggoodsN=new SellingGoodsBean();
		
		String sql = "select * from sellinggoods where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		
		//存放一个对象的map
		Map<String,Object> sellinggoods = list.get(0);
		
		sellinggoodsN.setId(Integer.parseInt(String.valueOf(sellinggoods.get("ID"))));
		sellinggoodsN.setExtendedid(Integer.parseInt(String.valueOf(sellinggoods.get("EXTENDEDID"))));
		sellinggoodsN.setProduct_message(String.valueOf(sellinggoods.get("PRODUCT_MESSAGE")));
		sellinggoodsN.setSaler_id(Integer.parseInt(String.valueOf(sellinggoods.get("SALER_ID"))));
		sellinggoodsN.setTitle(String.valueOf(sellinggoods.get("TITLE")));
		sellinggoodsN.setContact_method(String.valueOf(sellinggoods.get("CONTACT_METHOD")));
		sellinggoodsN.setPublic_time(String.valueOf(sellinggoods.get("PUBLISH_TIME")));
		sellinggoodsN.setSaler_name(String.valueOf(sellinggoods.get("SALER_NAME")));
		sellinggoodsN.setTrade_location(String.valueOf(sellinggoods.get("TRADE_LOCATION")));
		sellinggoodsN.setValid_date(String.valueOf(sellinggoods.get("VALID_DATE")));
		sellinggoodsN.setIsvalid(String.valueOf(sellinggoods.get("ISVALID")));
		sellinggoodsN.setUpdate_time(String.valueOf(sellinggoods.get("UPDATE_TIME")));
		
		return sellinggoodsN;
	}

	public PageBean showAll(String sql) {
		return dao.showAll(sql);
	}

	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}

	public boolean updateSellingGoodse(SellingGoodsBean sellingGoods,
			HttpSession session) {
		GetUserCreateTime time = new GetUserCreateTime();
		//获取当前时间:发布的时候, 更新时间等于发布时间
		time.setCreateTime();
		String nowTime = time.getCreateTime();
		
		String sql = "update sellinggoods set extendedid='"+sellingGoods.getExtendedid()+"',product_message='"+sellingGoods.getProduct_message()+"'," +
				"saler_id="+sellingGoods.getSaler_id()+",title='"+sellingGoods.getTitle()+"',contact_method='"+sellingGoods.getContact_method()+"'," +
						"SALER_NAME='"+sellingGoods.getSaler_name()+"',TRADE_LOCATION='"+sellingGoods.getTrade_location()+"',VALID_DATE='"+sellingGoods.getValid_date()+"'," +
								"PRODUCT_MESSAGE='"+sellingGoods.getProduct_message()+"',UPDATE_TIME='"+nowTime+"'" +
								" where id="+sellingGoods.getId();
		
		int operator = 3;
		return dao.update(sql, operator, session);
		}
}
