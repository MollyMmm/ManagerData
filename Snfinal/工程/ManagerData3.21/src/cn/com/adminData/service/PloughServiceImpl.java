package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.PloughBean;
import cn.com.adminData.service.PloughService.Plough;
import cn.com.managerData.util.JdbcUtil;


public class PloughServiceImpl implements Plough{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	
	
	public boolean addPlough(PloughBean Plough, HttpSession session) {
		int ExtendedId = Plough.getExtendedId();
		String SoilTexture=Plough.getSoilTexture();
		String SoilCondition=Plough.getSoilCondition();
		String Vestigital=Plough.getVestigital();
		String Location=Plough.getLocation();
		String sql="insert into Plough (id,ExtendedId,SoilTexture,SoilCondition,Vestigital,Location) values(Plough_seq.nextval,"+ExtendedId+",'"+SoilTexture+"','"+SoilCondition+"','"+Vestigital+"','"+Location+"')";
		int operator = 1;
		return dao.update(sql, operator, session);
		}
	public boolean deletePlough(PloughBean Plough,HttpSession session) {
		int id = Plough.getID();
		String sql = "delete from Plough where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}
	public PloughBean selectOne(String id) {
		PloughBean PloughN=new PloughBean();
		String sql = "select * from Plough where id="+id;
		
		List<Map<String,Object>> list = dao.showOne(sql);
		//存放一个对象的map
	
		Map<String,Object> GoodsMessage = list.get(0);
		
		PloughN.setID(Integer.parseInt(String.valueOf(GoodsMessage.get("ID"))));
		
		PloughN.setExtendedId(Integer.parseInt(String.valueOf(GoodsMessage.get("EXTENDEDID"))));
		PloughN.setSoilTexture(String.valueOf(GoodsMessage.get("SOILTEXTURE")));
		PloughN.setSoilCondition(String.valueOf(GoodsMessage.get("SOILCONDITION")));
		PloughN.setVestigital(String.valueOf(GoodsMessage.get("VESTIGITAL")));
		PloughN.setLocation(String.valueOf(GoodsMessage.get("LOCATION")));
		return PloughN;
	}
	public PageBean showAll(String sql) {
		return dao.showAll(sql);
	}

	public boolean updatePlough(PloughBean Plough, HttpSession session) {
		int id=Plough.getID();
		String ExtendedId = String.valueOf(Plough.getExtendedId());
		String SoilTexture=Plough.getSoilTexture();
		String SoilCondition=Plough.getSoilCondition();
		String Vestigital=Plough.getVestigital();
		String Location=Plough.getLocation();
		String sql="update Plough set ExtendedId="+ExtendedId+",SoilTexture='"+SoilTexture+"',SoilCondition='"+SoilCondition+"',Vestigital='"+Vestigital+"',Location='"+Location+"' where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, operator, session);
	}
	//根据条件查询函数
	public PageBean select(String con1, String con2, String con3) {

		String sql = "select * from Plough where 1=1"+con1+con2+con3;
System.out.println("------"+sql);
		//通过id查询数据  
		return dao.showAll(sql);
}
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}}
