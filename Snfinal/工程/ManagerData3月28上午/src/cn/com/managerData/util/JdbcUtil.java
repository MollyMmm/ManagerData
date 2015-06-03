package cn.com.managerData.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**JDBC������*/
public class JdbcUtil {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;



	/** 1.������ (��̬�����) */
	static {
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/** 2.��ȡ���� */
	public Connection getConn() {
		try {
			conn = DriverManager.getConnection("proxool.datasource1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/** 3.���²��� */
	public int update(String sql) {
		try {
			stmt = getConn().createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			release();
		}
	}
	
	/** 4.��ѯ���� */
	/*public ResultSet query(String sql) {
		try {
			stmt = getConn().createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return rs;
	}*/
	public List<Map<String,Object>> query(String sql) {
System.out.println(sql);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			stmt = getConn().createStatement();
			rs = stmt.executeQuery(sql);
			/*------�����rsת��ΪList<Map<String,Object>>-----*/
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();//��ý�����ֶεĸ���
			
			while(rs.next()){
				Map<String,Object> map = new HashMap<String,Object>();
				for(int i = 0 ; i < count ; i++){
					String key = rsmd.getColumnName(i+1);
//System.out.println("-----------key-----------------"+key);
					Object value = rs.getObject(key);
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally{
			release();
		}
		return list;
	}
	
	/**5.��������(����)*/
	public int[] batch(String[] sqls){
		try {
			conn = getConn();
			conn.setAutoCommit(false);//�����Զ��ύΪfalse
			stmt = conn.createStatement();
			for(String sql : sqls){
				stmt.addBatch(sql);//���sql����������
			}
			return stmt.executeBatch();
		} catch (SQLException e) {
			try {
				conn.rollback();//����ع� 
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return null;
		} finally{
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			release();
		}
	}
	
	/**6.�ͷ���Դ*/
	public void release(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getCount(String sql) {
		String sql1 = "select count(*) num from ("+ sql +")";
System.out.println("���м�¼��"+Integer.parseInt(this.query(sql1).get(0).get("NUM").toString()));
		return Integer.parseInt(this.query(sql1).get(0).get("NUM").toString());
	}

}
