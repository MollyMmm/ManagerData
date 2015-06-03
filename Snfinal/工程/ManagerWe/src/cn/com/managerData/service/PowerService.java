package cn.com.managerData.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.manager.model.DateBean;
import cn.com.manager.model.PageBean;
import cn.com.manager.model.PowerBean;
import cn.com.manager.model.RoleBean;
import cn.com.managerData.util.GetUserCreateTime;
import cn.com.managerData.util.JdbcUtil;

public class PowerService {
	// ����ʵ����jdbc������
	private JdbcUtil db = new JdbcUtil();

	/***
	 * ��ҳ��ѯ1����������ѯ
	 * 
	 * @param currentPage
	 * @return
	 */
	public PageBean listByPage(String currentPage) {
		// ����ʵ����PageBean����
		PageBean pageBean = new PageBean();
		// sql-----
		String sql = "select role_name from power_role";
		System.out.println(sql);

		// ����� ��һ�η��ʲ�ѯҳ�� currentPageΪnull
		if (currentPage != null) {// �����null
			// ��װ��ǰҳ��pageBean����
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
		}

		int count = db.getCount(sql);
		// �ܼ�¼��
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

	/***
	 * Ajax- ��������ҳ��ѯ
	 * 
	 * @param power_name
	 * 
	 * @return
	 */
	public PageBean listByPage(String currentPage, String power_name) {
		// ����ʵ����PageBean����
		PageBean pageBean = new PageBean();

		// ����� ��һ�η��ʲ�ѯҳ�� currentPageΪnull
		if (currentPage != null) {// �����null
			// ��װ��ǰҳ��pageBean����
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
		}

		// �жϲ�ѯ�����Ĳ���

		power_name = (power_name == null || power_name == "") ? ""
				: (" and power_name like '%" + power_name + "%'");

		// sql------------
		String sql = "select role_name from power_role where 1=1" + power_name;
		System.out.println(sql);

		int count = db.getCount(sql);
		// �ܼ�¼��
		pageBean.setTotal(count);

		// ��ҳ��
		pageBean.setTotalPage(count);

		// ��ԭ��sql�����, ����Ƕ�׵ķ�ҳ��sql���
		pageBean.setSql(sql);

		// ��װ�����,ͨ��pageBean�е�����Ƕ�׵�sql
		pageBean.setList(db.query(pageBean.getSql()));

		// ---ajax����sql�ǳ�Σ��,��������Ϊ""
		pageBean.setNullsSql();

		// ����pageBean����
		return pageBean;
	}

	/**
	 * ���ݽ�ɫ����ѯ����Ȩ��
	 * 
	 * @param pageBean
	 * @return
	 */
	public List<List<Map<String, Object>>> getPower(PageBean pageBean) {
		List<Map<String, Object>> roleList = pageBean.getList();
		List<List<Map<String, Object>>> power = new ArrayList<List<Map<String, Object>>>();
		int roleSize = roleList.size();

		for (int i = 0; i < roleSize; i++) {
			String roleName = (String) roleList.get(i).get("ROLE_NAME");
			String sqlStart = "select pp.power_name,pp.power_id,r.role_name,pp.power_pid,r.role_id from power_power pp, link_power_role lpr, power_role r "
					+ "where pp.power_id=lpr.power_id and lpr.role_id=r.role_id and r.role_name='"
					+ roleName + "'";
			String sql = "select distinct pp.power_name as power,t.role_name as role,t.role_id as id from power_power pp,("
					+ sqlStart + ")t where pp.power_id=t.power_pid";
			System.out.println(i);
			if (db.query(sql).size() != 0) {
				power.add(db.query(sql));
			}

		}
		return power;
	}

	/**
	 * ��ѯ�����û����и�����е����е�����Ȩ��
	 * 
	 * @param powerStr
	 * @param id
	 * @return
	 */
	public List<List<Map<String, Object>>> powerAll(String[] powerStr, String id) {
		List<List<Map<String, Object>>> power = new ArrayList<List<Map<String, Object>>>();
		for (int i = 1; i < powerStr.length; i++) {
			// Ȩ�޸������֣�power[i]
			String sqlStart = "select pp.power_name,pp.power_id,r.role_id,r.role_name,pp.power_pid from"
					+ " power_power pp, link_power_role lpr, power_role r where pp.power_id=lpr.power_id and lpr.role_id=r.role_id";
			String sql = "select distinct pp.power_name,t.role_name,t.power_name,t.power_id,t.role_id"
					+ " from power_power pp,("
					+ sqlStart
					+ ")t"
					+ " where pp.power_id=t.power_pid and t.role_id="
					+ id
					+ " and pp.power_name='" + powerStr[i] + "'";

			// list���һ��mapԪ���Ǹ����˵�������,�����Ķ����Ӽ���Ȩ��map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("powerFather", powerStr[i]);

			if (db.query(sql).size() != 0) {
				// ��ѯ�����Ӽ��˵�������
				List<Map<String, Object>> powerList = db.query(sql);
				powerList.add(map);
				power.add(powerList);
			}
		}
		return power;
	}

	/**
	 * ��Ȩ�ޱ����ȡ�̶��ĸ���Ȩ��
	 * 
	 * @return
	 */
	public List<Map<String, Object>> selectFather() {
		String sql = "select power_id,power_name from power_power where power_pid=-1";
		List<Map<String, Object>> fatherList = db.query(sql);
		return fatherList;
	}

	/**
	 * ��Ȩ�ޱ����ȡ�̶����Ӽ�Ȩ��
	 * 
	 * @return
	 */
	public List<List<Map<String, Object>>> selectSon() {
		// ���÷�����ȡ�̶��ĸ���Ȩ��
		List<Map<String, Object>> fatherList = selectFather();
		List<List<Map<String, Object>>> power = new ArrayList<List<Map<String, Object>>>();

		// list���һ��mapԪ���Ǹ����˵�������,�����Ķ����Ӽ���Ȩ��map

		for (int i = 0; i < fatherList.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String fatherName = (String) fatherList.get(i).get("POWER_NAME");
			System.out.println("����Ȩ�޵�����" + fatherName);
			map.put("powerFather", fatherName);
			Number fatherId = (Number) fatherList.get(i).get("POWER_ID");
			System.out.println("����Ȩ�޵�id" + fatherId);
			map.put("fatherID", fatherId);

			String sql = "select power_id,power_name from power_power where power_pid="
					+ fatherId;
			List<Map<String, Object>> powerList = db.query(sql);
			System.out.println("----�Ӽ�Ȩ��----"
					+ (Number) powerList.get(0).get("POWER_ID"));
			System.out.println("----�Ӽ�Ȩ��----"
					+ (String) powerList.get(0).get("POWER_NAME"));
			powerList.add(map);
			power.add(powerList);
		}

		return power;
	}

	/**
	 * �޸ĵ����û���Ȩ�޵�ʱ���������
	 * 
	 * @param role_id
	 * @return ��һ��list�ĵ�һ��list�еĵ�һ��map��role ��name,��һ��list�ĵ�һ��list�еĵ�2��map��role
	 *         ��id ,�ڶ���list��ʱ���list�Ժ��list���Ӽ���Ȩ�ޣ�ÿ��list��һ������Ȩ��,�Ӽ�list---
	 *         sonStatue���һ��mapԪ���Ǹ����˵�������ֻ��һ��Ԫ��,�����Ķ����Ӽ������ӡ�ɾ�����޸ģ���Ȩ��map�ж��Ԫ��,
	 */
	public List<List<Map<String, Object>>> powerStatue(String role_id) {
		List<List<Map<String, Object>>> power = new ArrayList<List<Map<String, Object>>>();

		// power�ĵ�һ��Ԫ����role
		Map<String, Object> roleId = new HashMap<String, Object>();
		roleId.put("ROLE_ID", role_id);
		System.out.println("----��ɫ----" + role_id);
		String sqlRole = "select role_name from power_role where role_id="
				+ role_id;
		List<Map<String, Object>> role = db.query(sqlRole);
		System.out
				.println("----��ɫ----" + (String) role.get(0).get("ROLE_NAME"));
		role.add(roleId);
		power.add(role);

		// power �ĵڶ���Ԫ����date
		String sqlDate = "select * from power_date";
		List<Map<String, Object>> date = db.query(sqlDate);
		power.add(date);

		// ���÷�����ȡ�̶����Ӽ�Ȩ�޼���
		List<List<Map<String, Object>>> sonList = selectSon();

		// �����Ӽ�Ȩ������ȷ��״̬
		for (int i = 0; i < sonList.size(); i++) {
			List<Map<String, Object>> sonStatue = new ArrayList<Map<String, Object>>();

			// һ������ӵ�е������Ӽ�
			List<Map<String, Object>> son = sonList.get(i);
			// ���������Ӽ�
			for (int j = 0; j < son.size() - 1; j++) {
				Map<String, Object> selectSon = new HashMap<String, Object>();

				// һ���Ӽ�
				Map<String, Object> sonMap = son.get(j);
				Number sonId = (Number) sonMap.get("POWER_ID");
				String sonName = (String) sonMap.get("POWER_NAME");
				selectSon.put("POWER_ID", sonId);
				selectSon.put("POWER_NAME", sonName);

				// ���ü���ʱ�䣬end_date�ڽ���֮��
				String sql = "select d.date_id as date_id,d.date_name as date_name from link_power_role lpr,power_date d where lpr.power_id="
						+ sonId
						+ " and lpr.date_id=d.date_id and lpr.role_id="
						+ role_id;
				if (db.query(sql).size() == 0) {
					// ������û�û�����Ȩ��, ֻ������״̬Ϊ0�������ڴ�Ȩ�ޣ����ӡ�ɾ�����޸ģ�
					selectSon.put("statue", "0");
					System.out.println("----------------0----------------");

				} else {
					// ���û������Ȩ��
					Map<String, Object> selectAlreadySon = db.query(sql).get(0);
					selectSon.put("DATE_ID", selectAlreadySon.get("DATE_ID"));
					selectSon.put("DATE_NAME", selectAlreadySon
							.get("POWER_NAME"));

					selectSon.put("statue", "1");
					System.out.println("----------------1----------------");
				}

				sonStatue.add(selectSon);
			}

			String fatherName = (String) son.get(son.size() - 1).get(
					"powerFather");
			Number fatherId = (Number) son.get(son.size() - 1).get("fatherID");
			// �Ӽ�list---sonStatue���һ��mapԪ���Ǹ����˵�������,�����Ķ����Ӽ���Ȩ��map
			Map<String, Object> fatherMap = new HashMap<String, Object>();
			fatherMap.put("powerFather", fatherName);
			fatherMap.put("fatherId", fatherId);
			sonStatue.add(fatherMap);
			// ���Ӽ�list�ŵ�����list��
			power.add(sonStatue);
		}
		return power;

	}

	/**
	 * ���Ȩ��
	 * 
	 * @param role
	 * @param date
	 * @return boolean ִ���Ƿ�ɹ�
	 * @throws ParseException
	 */
	public boolean addRole(RoleBean role, PowerBean[] power)
			throws ParseException {
		PowerInfoService powerinfo = new PowerInfoService();

		// ���Ȩ����
		boolean addPowerGroup = powerinfo.addPower(role);

		// ��Ȩ�������Ȩ��
		role.setRole_id(powerinfo.getId(role));
		boolean add = addPower(role, power);

		if (addPowerGroup && add) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ����Ȩ�����Ȩ��
	 * 
	 * @param role
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public boolean updatePower(RoleBean role, PowerBean[] power)
			throws ParseException {

		// ��ɾ��
		boolean delOld = deletePower(role);
		//�����
		boolean add = addPower(role, power);

		if (add && delOld) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ɾ��ĳ��Ȩ������еľ����Ȩ��
	 * 
	 * @param role
	 * @return
	 */
	public boolean deletePower(RoleBean role) {

		String sql = "delete from link_power_role where role_id='"
				+ role.getRole_id() + "'";
		System.out.println(sql);
		int result = db.update(sql);
		if (result != -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��Ȩ�������Ȩ��
	 * 
	 * @param role
	 * @param power
	 * @return
	 * @throws ParseException
	 */
	public boolean addPower(RoleBean role, PowerBean[] power)
			throws ParseException {
		boolean add = true;

		// �����
		for (int i = 0; i < power.length; i++) {
			GetUserCreateTime time = new GetUserCreateTime();
			DateInfoService dateinfo = new DateInfoService();
			DateBean date = power[i].getDate();
			// �������ID��ȡ��������
			date.setDate_num(dateinfo.getDateNum(date));
			System.out.println(i);
			time.setCreateTime();
			String endTime = time.getAddTime(date.getDate_num());
			String sql = "insert into link_power_role(power_id,role_id,date_id,end_date) values("
					+ power[i].getPower_id()
					+ ","
					+ role.getRole_id()
					+ ","
					+ date.getDate_id()
					+ ",to_date('"
					+ endTime
					+ "','yyyy-mm-dd'))";
			System.out.println(sql);
			int result = db.update(sql);
			if (result != -1) {
				add = add && true;
			} else {
				add = add && false;
			}
		}
		return add;
	}
}
