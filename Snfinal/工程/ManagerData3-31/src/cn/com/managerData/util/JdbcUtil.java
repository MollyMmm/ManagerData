package cn.com.managerData.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
//	private Statement stmt = null;
	private PreparedStatement preparedStatement = null;  
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

	/** 3.增加*/
	public int update(String sql, Object[] params) {
		try {
			preparedStatement = getConn().prepareStatement(sql);  
            for (int i = 0; i < params.length; i++) {  
                preparedStatement.setObject(i + 1, params[i]);  
            }  
			return preparedStatement.executeUpdate();
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
	public List<Map<String,Object>> query(String sql,Object[] params) {
System.out.println(sql);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			preparedStatement = getConn().prepareStatement(sql);  
            for (int i = 0; i < params.length; i++) {  
                preparedStatement.setObject(i + 1, params[i]);  
            }  
            rs = preparedStatement.executeQuery();
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
	public int[] batch(String[] sqls,Object[][] params){
		try {
			conn = getConn();
			conn.setAutoCommit(false);//�����Զ��ύΪfalse
			
			for(int i = 0;i<sqls.length;i++){
				preparedStatement = conn.prepareStatement(sqls[i]);
				
			    for (int j = 0; j < params.length; i++) {  
	                preparedStatement.setObject(i + 1, params[j]);  
	            }  
			    
			    preparedStatement.addBatch();
			}
					
			return preparedStatement.executeBatch();
			
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
				conn.setAutoCommit(true);  
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
		if(preparedStatement!=null){
			try {
				preparedStatement.close();
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
	
	public int getCount(String sql,Object[] parms) {
		String sql1 = "select count(*) num from ("+ sql +")";
System.out.println("���м�¼��"+Integer.parseInt(this.query(sql1,parms).get(0).get("NUM").toString()));
		return Integer.parseInt(this.query(sql1,parms).get(0).get("NUM").toString());
	}

}
