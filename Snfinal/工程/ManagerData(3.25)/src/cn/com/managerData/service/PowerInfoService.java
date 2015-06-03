package cn.com.managerData.service;



import cn.com.managerData.model.RoleBean;
import cn.com.managerData.util.JdbcUtil;


public class PowerInfoService {
	JdbcUtil db = new JdbcUtil();
/**
 * 添加权限组
 * @param role
 * @return
 */
	public boolean addPower(RoleBean role){
//------------------------
		
		String sql = "insert into power_role (role_id,role_name) values (role_seq.nextval,'"+role.getRole_name()+"')";
		System.out.println(sql);
		int result = db.update(sql);
		if (result != -1) {
			return true;
		} else {
			return false;
		}
		
	}
	/**
	 * 删除权限组
	 * @param role
	 * @return
	 */
	public boolean deletePower(RoleBean role){

		String sql = "update power_role set role_statue=0 where role_id='"+role.getRole_id()+"'";
		System.out.println(sql);
		int result = db.update(sql);
		if (result != -1) {
			return true;
		} else {
			return false;
		}
		
	}
	/***
	 * 根据角色的名字查ID
	 * @param role
	 * @return
	 */
	public int getId(RoleBean role){
		String sql = "select role_id from power_role WHERE role_name=" + role.getRole_name();
		System.out.println(sql);
				String id = db.query(sql).get(0).get("ROLE_ID").toString();
		return Integer.parseInt(id);
	}
	/***
	 * 根据角色的id查名字
	 * @param role
	 * @return
	 */
	public String getName(RoleBean role){
		String sql = "select role_name from power_role WHERE role_id=" + role.getRole_id();
		System.out.println(sql);
				String name = db.query(sql).get(0).get("ROLE_NAME").toString();
		return name;
	}
}
