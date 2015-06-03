package cn.com.managerData.service;

import java.util.List;
import java.util.Map;

import cn.com.manager.model.AdimnInfo;
import cn.com.managerData.util.JdbcUtil;
import cn.com.managerData.util.PasswordMd5;

public class AdimnInfoSerive {
	JdbcUtil db = new JdbcUtil();

	/**
	 * ���ӹ���Ա
	 * 
	 * @param admin
	 */
	public boolean addAdimn(AdimnInfo admin) {
		String sql = "INSERT INTO admininfo(ID,USERNAME,PASSWORD,REALNAME,EMAIL,SEX,TELE,CREATETIME) VALUES (admininfo_sqe.nextval,'"
				+ admin.getUserName()
				+ "','"
				+ admin.getPassword()
				+ "','"
				+ admin.getRealName()
				+ "','"
				+ admin.getEmail()
				+ "','"
				+ admin.getSex() + "','" + admin.getTele()+"',to_date('" + admin.getCreatTime()+ "','yyyy-mm-dd'))";
System.out.println(sql);
		int resultAdminInfo = db.update(sql);
		
		sql = "INSERT INTO admin(ID,USERNAME,PASSWORD,IDENTITY) VALUES (admin_seq.nextval,'"
				+ admin.getUserName()
				+ "','"
				+ admin.getPassword()+"',0)";
		System.out.println(sql);
		int resultAdmin = db.update(sql);
		if(resultAdminInfo != -1&&resultAdmin !=-1){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * ���Ĺ���Ա��Ϣ
	 * 
	 * @param admin
	 */
	public boolean updateAdmin(AdimnInfo admin) {
		String sql = "UPDATE admininfo SET USERNAME='" + admin.getUserName()
				+ "',PASSWORD='" + admin.getPassword() + "',REALNAME='"
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
	 * ��������
	 * @param id
	 * @param password
	 */
	public boolean updatePw(AdimnInfo admin) {
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
	 * ɾ������Ա
	 * 
	 * @param id
	 */
	public boolean deleteAdmin(String id) {
		String sql = "DELETE FROM admininfo WHERE ID=" + id;
		String sql2 = "DELETE FROM admin WHERE ID=" + id;
System.out.println(sql);
		int result = db.update(sql);
		int result2 = db.update(sql2);
		if (result != -1&&result2 != -1) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * ɾ�����й���Ա
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
	 * ��ѯ���й���Ա
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
	 * ��ѯ��������Ա
	 * 
	 * @return
	 */
	public Map<String, Object> selectOneAdmin(String id) {
		String sql = "select *from admininfo WHERE ID=" + id;
System.out.println(sql);
		Map<String, Object> map = db.query(sql).get(0);
		return map;
	}
	public String selectPw(String id){
		String sql = "select PASSWORD from admininfo WHERE ID=" + id;
System.out.println(sql);
		String password = db.query(sql).get(0).get("PASSWORD").toString();
		return password;
	}
	/***
	 * �жϽ�Ҫ���ӵĹ���Ա�� �˻��Ƿ����
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
			//������
			return false;
		}else
		{
			//����
			return true;
		}
	}
	
/**
 * �жϹ���Ա��½
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
			// �˺Ż��������
			System.out.println("--------------------���û�������");
			return -1;
		} else {
			String obj = list.get(0).get("IDENTITY").toString();
			
			System.out.println("--------------------" +obj);
			
			if (obj.equals("1")) {
				// ��������Ա��
				System.out.println("--------------------��������Ա");
				return 1;
			} else {// ��ͨ����Ա
				System.out.println("--------------------��ͨ����Ա ");
				return 0;
			}
		}

	}
}