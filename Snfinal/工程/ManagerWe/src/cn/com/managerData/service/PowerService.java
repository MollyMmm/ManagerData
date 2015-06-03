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
	// 生命实例化jdbc工具类
	private JdbcUtil db = new JdbcUtil();

	/***
	 * 分页查询1，无条件查询
	 * 
	 * @param currentPage
	 * @return
	 */
	public PageBean listByPage(String currentPage) {
		// 生命实例化PageBean对象
		PageBean pageBean = new PageBean();
		// sql-----
		String sql = "select role_name from power_role";
		System.out.println(sql);

		// 如果是 第一次访问查询页面 currentPage为null
		if (currentPage != null) {// 如果非null
			// 封装当前页到pageBean对象
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
		}

		int count = db.getCount(sql);
		// 总记录数
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

	/***
	 * Ajax- 有条件分页查询
	 * 
	 * @param power_name
	 * 
	 * @return
	 */
	public PageBean listByPage(String currentPage, String power_name) {
		// 生命实例化PageBean对象
		PageBean pageBean = new PageBean();

		// 如果是 第一次访问查询页面 currentPage为null
		if (currentPage != null) {// 如果非null
			// 封装当前页到pageBean对象
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
		}

		// 判断查询条件的参数

		power_name = (power_name == null || power_name == "") ? ""
				: (" and power_name like '%" + power_name + "%'");

		// sql------------
		String sql = "select role_name from power_role where 1=1" + power_name;
		System.out.println(sql);

		int count = db.getCount(sql);
		// 总记录数
		pageBean.setTotal(count);

		// 总页数
		pageBean.setTotalPage(count);

		// 把原生sql处理成, 三层嵌套的分页的sql语句
		pageBean.setSql(sql);

		// 封装结果集,通过pageBean中的三层嵌套的sql
		pageBean.setList(db.query(pageBean.getSql()));

		// ---ajax传递sql非常危险,所以重置为""
		pageBean.setNullsSql();

		// 返回pageBean对象
		return pageBean;
	}

	/**
	 * 根据角色名查询父级权限
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
	 * 查询单个用户所有父类具有的所有的子类权限
	 * 
	 * @param powerStr
	 * @param id
	 * @return
	 */
	public List<List<Map<String, Object>>> powerAll(String[] powerStr, String id) {
		List<List<Map<String, Object>>> power = new ArrayList<List<Map<String, Object>>>();
		for (int i = 1; i < powerStr.length; i++) {
			// 权限父级名字：power[i]
			String sqlStart = "select pp.power_name,pp.power_id,r.role_id,r.role_name,pp.power_pid from"
					+ " power_power pp, link_power_role lpr, power_role r where pp.power_id=lpr.power_id and lpr.role_id=r.role_id";
			String sql = "select distinct pp.power_name,t.role_name,t.power_name,t.power_id,t.role_id"
					+ " from power_power pp,("
					+ sqlStart
					+ ")t"
					+ " where pp.power_id=t.power_pid and t.role_id="
					+ id
					+ " and pp.power_name='" + powerStr[i] + "'";

			// list最后一个map元素是父级菜单的名字,其他的都是子级的权限map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("powerFather", powerStr[i]);

			if (db.query(sql).size() != 0) {
				// 查询到的子级菜单的名称
				List<Map<String, Object>> powerList = db.query(sql);
				powerList.add(map);
				power.add(powerList);
			}
		}
		return power;
	}

	/**
	 * 从权限表里获取固定的父级权限
	 * 
	 * @return
	 */
	public List<Map<String, Object>> selectFather() {
		String sql = "select power_id,power_name from power_power where power_pid=-1";
		List<Map<String, Object>> fatherList = db.query(sql);
		return fatherList;
	}

	/**
	 * 从权限表里获取固定的子级权限
	 * 
	 * @return
	 */
	public List<List<Map<String, Object>>> selectSon() {
		// 调用方法获取固定的父级权限
		List<Map<String, Object>> fatherList = selectFather();
		List<List<Map<String, Object>>> power = new ArrayList<List<Map<String, Object>>>();

		// list最后一个map元素是父级菜单的名字,其他的都是子级的权限map

		for (int i = 0; i < fatherList.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String fatherName = (String) fatherList.get(i).get("POWER_NAME");
			System.out.println("父级权限的名字" + fatherName);
			map.put("powerFather", fatherName);
			Number fatherId = (Number) fatherList.get(i).get("POWER_ID");
			System.out.println("父级权限的id" + fatherId);
			map.put("fatherID", fatherId);

			String sql = "select power_id,power_name from power_power where power_pid="
					+ fatherId;
			List<Map<String, Object>> powerList = db.query(sql);
			System.out.println("----子级权限----"
					+ (Number) powerList.get(0).get("POWER_ID"));
			System.out.println("----子级权限----"
					+ (String) powerList.get(0).get("POWER_NAME"));
			powerList.add(map);
			power.add(powerList);
		}

		return power;
	}

	/**
	 * 修改单个用户的权限的时候回显数据
	 * 
	 * @param role_id
	 * @return 第一个list的第一个list中的第一个map放role 的name,第一个list的第一个list中的第2个map放role
	 *         的id ,第二个list放时间的list以后的list放子级的权限，每个list是一个父级权限,子级list---
	 *         sonStatue最后一个map元素是父级菜单的名字只有一个元素,其他的都是子级（增加、删除、修改）的权限map有多个元素,
	 */
	public List<List<Map<String, Object>>> powerStatue(String role_id) {
		List<List<Map<String, Object>>> power = new ArrayList<List<Map<String, Object>>>();

		// power的第一个元素是role
		Map<String, Object> roleId = new HashMap<String, Object>();
		roleId.put("ROLE_ID", role_id);
		System.out.println("----角色----" + role_id);
		String sqlRole = "select role_name from power_role where role_id="
				+ role_id;
		List<Map<String, Object>> role = db.query(sqlRole);
		System.out
				.println("----角色----" + (String) role.get(0).get("ROLE_NAME"));
		role.add(roleId);
		power.add(role);

		// power 的第二个元素是date
		String sqlDate = "select * from power_date";
		List<Map<String, Object>> date = db.query(sqlDate);
		power.add(date);

		// 调用方法获取固定的子级权限集合
		List<List<Map<String, Object>>> sonList = selectSon();

		// 遍历子级权限用来确定状态
		for (int i = 0; i < sonList.size(); i++) {
			List<Map<String, Object>> sonStatue = new ArrayList<Map<String, Object>>();

			// 一个父级拥有的所有子级
			List<Map<String, Object>> son = sonList.get(i);
			// 遍历单个子级
			for (int j = 0; j < son.size() - 1; j++) {
				Map<String, Object> selectSon = new HashMap<String, Object>();

				// 一个子级
				Map<String, Object> sonMap = son.get(j);
				Number sonId = (Number) sonMap.get("POWER_ID");
				String sonName = (String) sonMap.get("POWER_NAME");
				selectSon.put("POWER_ID", sonId);
				selectSon.put("POWER_NAME", sonName);

				// 还得加上时间，end_date在今天之后
				String sql = "select d.date_id as date_id,d.date_name as date_name from link_power_role lpr,power_date d where lpr.power_id="
						+ sonId
						+ " and lpr.date_id=d.date_id and lpr.role_id="
						+ role_id;
				if (db.query(sql).size() == 0) {
					// 如果该用户没有这个权限, 只用设置状态为0代表不存在此权限（增加、删除、修改）
					selectSon.put("statue", "0");
					System.out.println("----------------0----------------");

				} else {
					// 该用户有这个权限
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
			// 子级list---sonStatue最后一个map元素是父级菜单的名字,其他的都是子级的权限map
			Map<String, Object> fatherMap = new HashMap<String, Object>();
			fatherMap.put("powerFather", fatherName);
			fatherMap.put("fatherId", fatherId);
			sonStatue.add(fatherMap);
			// 将子级list放到父级list中
			power.add(sonStatue);
		}
		return power;

	}

	/**
	 * 添加权限
	 * 
	 * @param role
	 * @param date
	 * @return boolean 执行是否成功
	 * @throws ParseException
	 */
	public boolean addRole(RoleBean role, PowerBean[] power)
			throws ParseException {
		PowerInfoService powerinfo = new PowerInfoService();

		// 添加权限组
		boolean addPowerGroup = powerinfo.addPower(role);

		// 给权限组分配权限
		role.setRole_id(powerinfo.getId(role));
		boolean add = addPower(role, power);

		if (addPowerGroup && add) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 更新权限组的权限
	 * 
	 * @param role
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public boolean updatePower(RoleBean role, PowerBean[] power)
			throws ParseException {

		// 先删除
		boolean delOld = deletePower(role);
		//后添加
		boolean add = addPower(role, power);

		if (add && delOld) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 删除某个权限组具有的具体的权限
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
	 * 给权限组分配权限
	 * 
	 * @param role
	 * @param power
	 * @return
	 * @throws ParseException
	 */
	public boolean addPower(RoleBean role, PowerBean[] power)
			throws ParseException {
		boolean add = true;

		// 后添加
		for (int i = 0; i < power.length; i++) {
			GetUserCreateTime time = new GetUserCreateTime();
			DateInfoService dateinfo = new DateInfoService();
			DateBean date = power[i].getDate();
			// 根据天的ID获取它的天数
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
