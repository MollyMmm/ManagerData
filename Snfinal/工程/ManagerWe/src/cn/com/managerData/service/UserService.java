package cn.com.managerData.service;

import cn.com.manager.model.PageBean;
import cn.com.managerData.util.JdbcUtil;

public class UserService {
	// 生命实例化jdbc工具类
	private JdbcUtil db = new JdbcUtil();

	public PageBean listByPage(String currentPage) {
		// 生命实例化PageBean对象
		PageBean pageBean = new PageBean();
		// sql-----
		String sql = "select * from adminInfo";

		// 如果是 第一次访问查询页面 currentPage为null
		if (currentPage != null) {// 如果非null
			// 封装当前页到pageBean对象
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
		}
		
		int count = db.getCount(sql);
		//总记录数
		pageBean.setTotal(count);
		
		// 总页数
		pageBean.setTotalPage(count);

		// 把原生sql处理成, 三层嵌套的分页的sql语句
		pageBean.setSql(sql);

		// 封装结果集,通过pageBean中的三层嵌套的sql

		pageBean.setList(db.query(pageBean.getSql()));

		// 返回pageBean对象
		return pageBean;
	}

	public PageBean listByPage(String currentPage, String user,
			String realName, String sex, String email, String tele,String creatTime) {
		// 生命实例化PageBean对象
		PageBean pageBean = new PageBean();


		// 如果是 第一次访问查询页面 currentPage为null
		if (currentPage != null) {// 如果非null
			// 封装当前页到pageBean对象
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
		}

		// 判断查询条件的参数
		creatTime = (creatTime == null || creatTime == "") ? "" : (" and createTime = to_date('" + creatTime+ "','yyyy-mm-dd')"
				);
		user = (user == null || user == "") ? "" : (" and username like '%"
				+ user + "%'");
		realName = (realName == null || realName == "") ? ""
				: (" and realName like '%" + realName + "%'");
		if(sex.equals("all"))
		{
			sex = "";
		}else
		{
			sex = (sex == null || sex == "") ? ""
					: (" and sex='" + sex + "'");
		}
		
		email = (email == null || email == "") ? "" : (" and email like '%"
				+ email + "%'");
		tele = (tele == null || tele == "") ? ""
				: (" and tele like '%" + tele + "%'");

		// sql------------
		String sql = "select a.tele,a.username,a.realname,a.sex,a.email,to_char(id) as c_id, to_char(createtime,'yyyy-mm-dd') as c_t from admininfo a where 1 = 1" + user + realName
				+ sex + email + tele + creatTime;
System.out.println(sql);

		int count = db.getCount(sql);
		//总记录数
		pageBean.setTotal(count);
		
		// 总页数
		pageBean.setTotalPage(count);

		// 把原生sql处理成, 三层嵌套的分页的sql语句
		pageBean.setSql(sql);

		// 封装结果集,通过pageBean中的三层嵌套的sql
		pageBean.setList(db.query(pageBean.getSql()));
		
		//---ajax传递sql非常危险,所以重置为“”
		pageBean.setNullsSql();
		
		// 返回pageBean对象
		return pageBean;
	}
}