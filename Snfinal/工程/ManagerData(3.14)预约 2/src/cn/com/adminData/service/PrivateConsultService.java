package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.PrivateConsultBean;

public interface PrivateConsultService {
	PageBean showAll(String sql);
	PageBean showOther(PageBean pageBean) ;
	Boolean addPrivateConsult(PrivateConsultBean consult,HttpSession session);//添加数据
	Boolean deletePrivateConsult(PrivateConsultBean consult,HttpSession session);//删除数据
	Boolean updatePrivateConsult(PrivateConsultBean consult,HttpSession session);//这里在查询一个数据之后用，更新数据操作
	PrivateConsultBean selectOne(String id);//更改数据是用，查询一个数据出来显示，来修改数据
	PageBean select(String con1,String con2,String con3 );//根据三个条件查询
}
