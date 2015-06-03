package cn.com.adminData.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.managerData.model.AdminInfo;
import cn.com.managerData.util.GetUserCreateTime;
import cn.com.managerData.util.JdbcUtil;

public class BaseDaoImpl implements BaseDao{
	JdbcUtil jdbc = new JdbcUtil();
	/**
	 * 以分页形式获取一页的对象
	 */
	public PageBean showAll(String sql) {
		PageBean pageBean = new PageBean();
		
		//根据原生的sql生成分页的sql语句
		pageBean.setSql(sql);
		int count = jdbc.getCount(sql);
		//获取总页数
		pageBean.setTotalPage(count);
		pageBean.setTotal(count);
		//获取一页的所有对象
		pageBean.setList(jdbc.query(pageBean.getSql()));
System.out.println("----page--"+pageBean.getSql()+"---"+pageBean.getList());
		return pageBean;
	}
	/**
	 * 根据ID查询一个对象
	 * @param sql
	 * @return
	 */
	public List<Map<String,Object>> showOne(String sql){
		
		return jdbc.query(sql);
	}
	/**
	 * 执行更改操作
	 * operator   1：增，2：删，3：改
	 * session servlet里的参数
	 * 
	 */
	public boolean update(String sql,int operator,HttpSession session) {
		//执行增加操作
		
		
		//日志管理
		
			GetUserCreateTime time = new GetUserCreateTime();
			time.setCreateTime();
System.out.println("-----------rizhi---------");			
			AdminInfo admin = (AdminInfo)session.getAttribute("admin");
			String adminName = admin.getUserName();
System.out.println(adminName);
			String adminSql = "select id from admininfo where username='"+adminName+"'";

			String adminId = String.valueOf(jdbc.query(adminSql).get(0).get("ID"));
System.out.println("--------------------"+adminId);
			String date = time.getCreateTime();
			String operatorSql = "insert into ManagerOperator(operate_id,admin_id,datetime,admin_operate) values" +
					"(managerOperator_seq.nextval,"+adminId+",'"+date+"',"+operator+")";
System.out.println("--------------------"+operatorSql);			
			String sqls[] = new String[2];
			sqls[0]=sql;
System.out.println("--------------------"+sql);				
			sqls[1]=operatorSql;
			int[] operatorAdd = jdbc.batch(sqls);
			if(operatorAdd[0]!=-1&&operatorAdd[1]!=-1){
				return true;
			}else{
				return false;
			}
	}
	/**
	 * 分页跳转查询
	 */
	public PageBean showOther(PageBean pageBean) {
		
		pageBean.setList(jdbc.query(pageBean.getSql()));
		
		return pageBean;
	}
	/**
	 * 查询条件下的页面跳转
	 */
	public PageBean searchGoPage(String sql, String currentPage) {
		PageBean pageBean = new PageBean();

		// 封装当前页到pageBean对象
		pageBean.setCurrentPage(Integer.parseInt(currentPage));
		int count = jdbc.getCount(sql);
		// 总记录数
		pageBean.setTotal(count);

		// 总页数
		pageBean.setTotalPage(count);

		// 把原生sql处理成, 三层嵌套的分页的sql语句
		pageBean.setSql(sql);

		// 封装结果集,通过pageBean中的三层嵌套的sql
		pageBean.setList(jdbc.query(pageBean.getSql()));

		// ---ajax传递sql非常危险,所以重置为“”
		pageBean.setNullsSql();

		return pageBean;
	}
}
	

