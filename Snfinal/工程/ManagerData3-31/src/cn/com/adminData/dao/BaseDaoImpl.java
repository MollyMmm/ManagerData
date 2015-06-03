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
	 * �Է�ҳ��ʽ��ȡһҳ�Ķ���
	 */
	public PageBean showAll(String sql,Object[] params) {
		PageBean pageBean = new PageBean();
		
		//����ԭ����sql���ɷ�ҳ��sql���
		pageBean.setSql(sql);
		int count = jdbc.getCount(sql,params);
		//��ȡ��ҳ��
		pageBean.setTotalPage(count);
		pageBean.setTotal(count);
		//��ȡһҳ�����ж���
		pageBean.setList(jdbc.query(pageBean.getSql(),params));
System.out.println("----page--"+pageBean.getSql()+"---"+pageBean.getList());
		return pageBean;
	}
	/**
	 * ����ID��ѯһ������
	 * @param sql
	 * @return
	 */
	public List<Map<String,Object>> showOne(String sql,Object[] params){
		
		return jdbc.query(sql,params);
	}
	/**
	 * ִ�и��Ĳ���
	 * operator   1������2��ɾ��3����
	 * session servlet��Ĳ���
	 * 
	 */
	public boolean update(String sql,Object[] params,int operator,HttpSession session) {
		//ִ�����Ӳ���
		
		
		//��־����
		
			GetUserCreateTime time = new GetUserCreateTime();
			time.setCreateTime();
System.out.println("-----------rizhi---------");			
			AdminInfo admin = (AdminInfo)session.getAttribute("admin");
			String adminName = admin.getUserName();
System.out.println(adminName);

			String adminSql = "select id from admininfo where username=?";
			String[] username ={adminName}; 
			String adminId = String.valueOf(jdbc.query(adminSql,username).get(0).get("ID"));
System.out.println("--------------------"+adminId);

			String date = time.getCreateTime();
			String operatorSql = "insert into ManagerOperator(operate_id,admin_id,datetime,admin_operate) values" +
					"(managerOperator_seq.nextval,?,?,?)";
			Object[] operatorSqls={adminId,date,operator};
System.out.println("--------------------"+operatorSql);			
			String sqls[] = {sql,operatorSql};
			Object[][] columns = {params,operatorSqls};
System.out.println("--------------------"+sql);				
			int[] operatorAdd = jdbc.batch(sqls,columns);
			if(operatorAdd[0]!=-1&&operatorAdd[1]!=-1){
				return true;
			}else{
				return false;
			}
	}
	/**
	 * ��ҳ��ת��ѯ
	 */
	public PageBean showOther(PageBean pageBean,Object[] params) {
		
		pageBean.setList(jdbc.query(pageBean.getSql(),params));
		
		return pageBean;
	}
	/**
	 * ��ѯ�����µ�ҳ����ת
	 */
	public PageBean searchGoPage(String sql,Object[] params,String currentPage) {
		PageBean pageBean = new PageBean();

		// ��װ��ǰҳ��pageBean����
		pageBean.setCurrentPage(Integer.parseInt(currentPage));
		int count = jdbc.getCount(sql,params);
		// �ܼ�¼��
		pageBean.setTotal(count);

		// ��ҳ��
		pageBean.setTotalPage(count);

		// ��ԭ��sql�����, ����Ƕ�׵ķ�ҳ��sql���
		pageBean.setSql(sql);

		// ��װ�����,ͨ��pageBean�е�����Ƕ�׵�sql
		pageBean.setList(jdbc.query(pageBean.getSql(),params));

		// ---ajax����sql�ǳ�Σ��,��������Ϊ����
		pageBean.setNullsSql();

		return pageBean;
	}
}
	

