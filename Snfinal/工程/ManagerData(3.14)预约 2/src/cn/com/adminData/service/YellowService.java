package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.YellowPageBean;

public interface YellowService {
	PageBean showOther(PageBean pageBean) ;
	PageBean showAll(String sql);//显示所有信息
	boolean addYellow(YellowPageBean yellow,HttpSession session);//增加信息
	boolean updateYellow(YellowPageBean yellow,HttpSession session);//根据id查询信息，然后更新
	boolean deleteYellow(YellowPageBean yellow,HttpSession session);//删除信息
	YellowPageBean selectOne(String id);//根据单一条件查询信息
	PageBean select(String con1,String con2,String con3);//根据类型查询信息（*好像不用写*）
}
