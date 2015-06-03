package cn.com.managerData.service;

import java.util.List;
import java.util.Map;

import cn.com.managerData.model.AdminInfo;
import cn.com.managerData.util.JdbcUtil;
import cn.com.managerData.util.PasswordMd5;

public class AdminInfoSerive {
	JdbcUtil db = new JdbcUtil();

	/**
	 * 增加管理员
	 * @param admin
	 * @return 添加是否成功bool
	 */
	public boolean addAdimn(AdminInfo admin) {
		String[] sqls = new String[2];
		String sql = "INSERT INTO admininfo(ID,USERNAME,PASSWORD,REALNAME,EMAIL,SEX,TELE,CREATETIME) VALUES (admininfo_seq.nextval,'"
				+ admin.getUserName()
				+ "','"
				+ admin.getPassword()
				+ "','"
				+ admin.getRealName()
				+ "','"
				+ admin.getEmail()
				+ "','"
				+ admin.getSex() + "','" + admin.getTele()+"','" + admin.getCreatTime()+ "')";
System.out.println(sql);
		
		sqls[0]=sql;
		sql = "INSERT INTO admin(ID,USERNAME,PASSWORD,IDENTITY) VALUES (admin_seq.nextval,'"
				+ admin.getUserName()
				+ "','"
				+ admin.getPassword()+"',0)";
		System.out.println(sql);
		sqls[1]=sql;
		
		int[] resultAdmin = db.batch(sqls);
		if(resultAdmin[0] != -1&&resultAdmin[1] !=-1){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 更改管理员信息
	 * 
	 * @param admin
	 */
	public boolean updateAdmin(AdminInfo admin) {
		String sql = "UPDATE admininfo SET USERNAME='" + admin.getUserName()
				+ "',REALNAME='"
				+ admin.getRealName() + "',EMAIL='" + admin.getEmail()
				+ "',SEX='" + admin.getSex() + "',TELE='"
				+ admin.getTele()  + "' WHERE ID='" + admin.getId() + "'";
 System.out.println(sql);
		int result = db.update(sql);
		if(result != -1){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 更改密码
	 * @param id
	 * @param password
	 */
	public boolean updatePw(AdminInfo admin) {
		String sql = "UPDATE admininfo SET PASSWORD='" + admin.getPassword() + "' WHERE ID='" + admin.getId() + "'";
 System.out.println(sql);
		int result = db.update(sql);
		if (result != -1) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 删除管理员
	 * 
	 * @param id
	 */
	public boolean deleteAdmin(String id) {
		String sql0 = "DELETE FROM admininfo WHERE ID=" + id;
		String sql1 = "DELETE FROM admin WHERE ID=" + id;
System.out.println(sql0+"----"+sql1);
		String[] sqls = new String[2];

		sqls[0] = sql0;
		sqls[1] = sql1;
		int[] result = db.batch(sqls);
		
		if (result[0] != -1&&result[1] != -1) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 删除所有管理员
	 * 
	 * @param id
	 */
	public boolean deleteAllAdmin() {
		String sql = "DELETE FROM admininfo";
System.out.println(sql);
		int result = db.update(sql);
		if(result != -1){
			return true;
		}else{
			return false;
		}
 
	}
	/**
	 * 查询所有管理员
	 * 
	 * @return
	 */
	public List<Map<String, Object>> selectAdmin() {
		String sql = "select *from admininfo";
 System.out.println(sql);		
		List<Map<String, Object>> list = db.query(sql);
		return list;
	}

	/**
	 * 查询单个管理员
	 * 
	 * @return
	 */
	public Map<String, Object> selectOneAdmin(String id) {
		String sql = "select *from admininfo WHERE ID=" + id;
System.out.println(sql);
		Map<String, Object> map = db.query(sql).get(0);
		return map;
	}
	/**
	 * 查询管理员密码
	 * @param id
	 * @return
	 */
	public String selectPw(String id){
		String sql = "select PASSWORD from admininfo WHERE ID=" + id;
System.out.println(sql);
		String password = db.query(sql).get(0).get("PASSWORD").toString();
		return password;
	}
	/***
	 * 判断将要增加的管理员的 账户是否存在
	 * @param username
	 * @return
	 */
	public boolean isHave(String username)
	{
		String sql = "select *from admininfo WHERE USERNAME='" + username+"'";
System.out.println(sql);
		List<Map<String, Object>> list = db.query(sql);
		if(list.size()==0)
		{
			//不存在
			return false;
		}else
		{
			//存在
			return true;
		}
	}
	
/**
 * 判断管理员登陆
 * @param userName
 * @param password
 * @return    
 */
	public int isAdmin(String userName, String password) {
		PasswordMd5 md5 = new PasswordMd5();
		
		if(userName==""||password=="")
		{
			return -1;
		}
		
		String Passwordmd5 = md5.generatePassword(password);
		
		String sql = "select identity FROM admin WHERE USERNAME='" + userName
				+ "' and PASSWORD ='" + Passwordmd5 + "'";
		
System.out.println(sql);
		
		List<Map<String, Object>> list = db.query(sql);
		
		if (list.size()==0) {
			// 账号或密码错误
System.out.println("--------------------该用户不存在");
			return -1;
		} else {
			String obj = list.get(0).get("IDENTITY").toString();
			
System.out.println("--------------------" +obj);
			
			if (obj.equals("1")) {
				// 超级管理员级
System.out.println("--------------------超级管理员");
				return 1;
			} else {// 普通管理员
System.out.println("--------------------普通管理员 ");
				return 0;
			}
		}

	}
}