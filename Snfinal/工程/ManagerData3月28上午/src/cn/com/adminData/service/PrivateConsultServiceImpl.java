package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.PrivateConsultBean;
import cn.com.managerData.util.JdbcUtil;

public class PrivateConsultServiceImpl implements PrivateConsultService {
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();

	public Boolean addPrivateConsult(PrivateConsultBean consult,// 添加
			HttpSession session) {
		// ---此功能应该不存在
		int UserId = 1;
		// --
		String ExtendedId = String.valueOf(consult.getExtendedId());
		String Consulting_Body = consult.getConsulting_Body();
		String Consulting_Time = consult.getConsulting_Time();
		String Deadline = consult.getDeadline();
		String Consulting_Type = consult.getConsulting_Type();
		String Reply_Body = consult.getReply_Body();
		String Reply_Time = consult.getReply_Time();
		// 插入的sql
		String sql = "insert into PrivateConsult(id,ExtendedId,Userid,Consulting_Body,Consulting_Time,Deadline,Consulting_Type,Reply_Body,Reply_Time) values(PrivateConsult_seq.nextval,"
				+ ExtendedId
				+ ","
				+ UserId
				+ ",'"
				+ Consulting_Body
				+ "','"
				+ Consulting_Time
				+ "','"
				+ Deadline
				+ "','"
				+ Consulting_Type
				+ "','" + Reply_Body + "','" + Reply_Time + "')";
		System.out.println("-------------" + sql);
		int operate = 1;// 1.增2.删3.改
		return dao.update(sql, operate, session);

	}

	public Boolean deletePrivateConsult(PrivateConsultBean consult, // 删除
			HttpSession session) {
		int id = consult.getId();
		String sql = "delete from PrivateConsult where id="
				+ String.valueOf(id);
		int operate = 2;// 1.增2.删3.改
		return dao.update(sql, operate, session);// 执行sql语句
	}

	public PageBean showAll(String sql) { // 显示所有
		return dao.showAll(sql);
	}

	// ------这里是半夜写的！！---------------------------
	public Boolean updatePrivateConsult(PrivateConsultBean consult, // 更新操作
			HttpSession session) {
		String UserId = String.valueOf(consult.getUserId());
		String ExtendedId = String.valueOf(consult.getExtendedId());
		int id = consult.getId();
		String Consulting_Body = consult.getConsulting_Body();
		String Consulting_Time = consult.getConsulting_Time();
		String Deadline = consult.getDeadline();
		String Consulting_Type = consult.getConsulting_Type();
		String Reply_Body = consult.getReply_Body();
		String Reply_Time = consult.getReply_Time();
		// 拼接字符串
		String sql = "update PrivateConsult set UserID=" + UserId
				+ ",ExtendedId=" + ExtendedId + ",Consulting_Body='"
				+ Consulting_Body + "',Consulting_Time='" + Consulting_Time
				+ "',Deadline='" + Deadline + "',Consulting_Type='"
				+ Consulting_Type + "',Reply_Body='" + Reply_Body
				+ "',Reply_Time='" + Reply_Time + "' where id="
				+ String.valueOf(id);
		System.out.println("-------------" + sql);
		int operate = 3;// 1.增2.删3.改
		return dao.update(sql, operate, session);// 执行sql语句
	}

	public PrivateConsultBean selectOne(String id) { // 查询一个数据
		PrivateConsultBean consultM = new PrivateConsultBean();
		String sql = "select * from PrivateConsult where id=" + id;
		// 通过id查询数据
		List<Map<String, Object>> list = dao.showOne(sql);
		// 存放一个对象的map
		Map<String, Object> consult = list.get(0);// map对象中的第一条数据
		consultM.setConsulting_Body(String.valueOf(consult
				.get("CONSULTING_BODY")));// 存值开始进对象consultM
		consultM.setConsulting_Time(String.valueOf(consult
				.get("CONSULTING_TIME")));
		consultM.setConsulting_Type(String.valueOf(consult
				.get("CONSULTING_TYPE")));
		consultM.setDeadline(String.valueOf(consult.get("DEADLINE")));
		consultM.setExtendedId(Integer.parseInt(String.valueOf(consult
				.get("EXTENDEDID"))));
		consultM.setId(Integer.parseInt(String.valueOf(consult.get("ID"))));
		consultM.setReply_Body(String.valueOf(consult.get("REPLY_BODY")));
		consultM.setReply_Time(String.valueOf(consult.get("REPLY_TIME")));
		consultM.setUserId(Integer.parseInt(String.valueOf(consult
				.get("USERID"))));// 存值结束进对象consultM
		return consultM;
	}

	// 根据条件查询函数
	public PageBean select(String con1, String con2, String con3,
			String currentPage) {

		String sql = "select * from PrivateConsult where 1=1" + con1 + con2
				+ con3;
		System.out.println("------" + sql);
		
		PageBean pageBean = dao.searchGoPage(sql, currentPage);
		return pageBean;
		/*PageBean pageBean = new PageBean();

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

		return pageBean;*/
	}

	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}
}
