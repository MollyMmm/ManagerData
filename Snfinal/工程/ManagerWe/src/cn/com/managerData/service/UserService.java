package cn.com.managerData.service;

import cn.com.manager.model.PageBean;
import cn.com.managerData.util.JdbcUtil;

public class UserService {
	// ����ʵ����jdbc������
	private JdbcUtil db = new JdbcUtil();

	public PageBean listByPage(String currentPage) {
		// ����ʵ����PageBean����
		PageBean pageBean = new PageBean();
		// sql-----
		String sql = "select * from adminInfo";

		// ����� ��һ�η��ʲ�ѯҳ�� currentPageΪnull
		if (currentPage != null) {// �����null
			// ��װ��ǰҳ��pageBean����
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
		}
		
		int count = db.getCount(sql);
		//�ܼ�¼��
		pageBean.setTotal(count);
		
		// ��ҳ��
		pageBean.setTotalPage(count);

		// ��ԭ��sql�����, ����Ƕ�׵ķ�ҳ��sql���
		pageBean.setSql(sql);

		// ��װ�����,ͨ��pageBean�е�����Ƕ�׵�sql

		pageBean.setList(db.query(pageBean.getSql()));

		// ����pageBean����
		return pageBean;
	}

	public PageBean listByPage(String currentPage, String user,
			String realName, String sex, String email, String tele,String creatTime) {
		// ����ʵ����PageBean����
		PageBean pageBean = new PageBean();


		// ����� ��һ�η��ʲ�ѯҳ�� currentPageΪnull
		if (currentPage != null) {// �����null
			// ��װ��ǰҳ��pageBean����
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
		}

		// �жϲ�ѯ�����Ĳ���
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
		//�ܼ�¼��
		pageBean.setTotal(count);
		
		// ��ҳ��
		pageBean.setTotalPage(count);

		// ��ԭ��sql�����, ����Ƕ�׵ķ�ҳ��sql���
		pageBean.setSql(sql);

		// ��װ�����,ͨ��pageBean�е�����Ƕ�׵�sql
		pageBean.setList(db.query(pageBean.getSql()));
		
		//---ajax����sql�ǳ�Σ��,��������Ϊ����
		pageBean.setNullsSql();
		
		// ����pageBean����
		return pageBean;
	}
}