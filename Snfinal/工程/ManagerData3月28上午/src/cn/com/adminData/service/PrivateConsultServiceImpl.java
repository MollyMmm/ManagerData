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

	public Boolean addPrivateConsult(PrivateConsultBean consult,// ���
			HttpSession session) {
		// ---�˹���Ӧ�ò�����
		int UserId = 1;
		// --
		String ExtendedId = String.valueOf(consult.getExtendedId());
		String Consulting_Body = consult.getConsulting_Body();
		String Consulting_Time = consult.getConsulting_Time();
		String Deadline = consult.getDeadline();
		String Consulting_Type = consult.getConsulting_Type();
		String Reply_Body = consult.getReply_Body();
		String Reply_Time = consult.getReply_Time();
		// �����sql
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
		int operate = 1;// 1.��2.ɾ3.��
		return dao.update(sql, operate, session);

	}

	public Boolean deletePrivateConsult(PrivateConsultBean consult, // ɾ��
			HttpSession session) {
		int id = consult.getId();
		String sql = "delete from PrivateConsult where id="
				+ String.valueOf(id);
		int operate = 2;// 1.��2.ɾ3.��
		return dao.update(sql, operate, session);// ִ��sql���
	}

	public PageBean showAll(String sql) { // ��ʾ����
		return dao.showAll(sql);
	}

	// ------�����ǰ�ҹд�ģ���---------------------------
	public Boolean updatePrivateConsult(PrivateConsultBean consult, // ���²���
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
		// ƴ���ַ���
		String sql = "update PrivateConsult set UserID=" + UserId
				+ ",ExtendedId=" + ExtendedId + ",Consulting_Body='"
				+ Consulting_Body + "',Consulting_Time='" + Consulting_Time
				+ "',Deadline='" + Deadline + "',Consulting_Type='"
				+ Consulting_Type + "',Reply_Body='" + Reply_Body
				+ "',Reply_Time='" + Reply_Time + "' where id="
				+ String.valueOf(id);
		System.out.println("-------------" + sql);
		int operate = 3;// 1.��2.ɾ3.��
		return dao.update(sql, operate, session);// ִ��sql���
	}

	public PrivateConsultBean selectOne(String id) { // ��ѯһ������
		PrivateConsultBean consultM = new PrivateConsultBean();
		String sql = "select * from PrivateConsult where id=" + id;
		// ͨ��id��ѯ����
		List<Map<String, Object>> list = dao.showOne(sql);
		// ���һ�������map
		Map<String, Object> consult = list.get(0);// map�����еĵ�һ������
		consultM.setConsulting_Body(String.valueOf(consult
				.get("CONSULTING_BODY")));// ��ֵ��ʼ������consultM
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
				.get("USERID"))));// ��ֵ����������consultM
		return consultM;
	}

	// ����������ѯ����
	public PageBean select(String con1, String con2, String con3,
			String currentPage) {

		String sql = "select * from PrivateConsult where 1=1" + con1 + con2
				+ con3;
		System.out.println("------" + sql);
		
		PageBean pageBean = dao.searchGoPage(sql, currentPage);
		return pageBean;
		/*PageBean pageBean = new PageBean();

		// ��װ��ǰҳ��pageBean����
		pageBean.setCurrentPage(Integer.parseInt(currentPage));
		int count = jdbc.getCount(sql);
		// �ܼ�¼��
		pageBean.setTotal(count);

		// ��ҳ��
		pageBean.setTotalPage(count);

		// ��ԭ��sql�����, ����Ƕ�׵ķ�ҳ��sql���
		pageBean.setSql(sql);

		// ��װ�����,ͨ��pageBean�е�����Ƕ�׵�sql
		pageBean.setList(jdbc.query(pageBean.getSql()));

		// ---ajax����sql�ǳ�Σ��,��������Ϊ����
		pageBean.setNullsSql();

		return pageBean;*/
	}

	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}
}
