package cn.com.adminData.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.util.JdbcUtil;

public class ExchangeDoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JdbcUtil jdbc = new JdbcUtil();
		
		//�������û�
		String id = request.getParameter("id");
		//Ҫ���ٵĻ���
		int sorce = Integer.parseInt(request.getParameter("sorce"));
		System.out.println("------------"+sorce);
		//�����ݿ��л�ȡ���û�ԭ�еĻ���
		String sql = "select u_sorce from sorces where u_id="+id;
		System.out.println("------------"+sql);
		List<Map<String,Object>> list = jdbc.query(sql);
		
		String oldSorce =(String)list.get(0).get("U_SORCE");
		System.out.println((String)list.get(0).get("U_SORCE"));
		System.out.println(oldSorce);
		System.out.println(Integer.parseInt(oldSorce));
		int newSorce = Integer.parseInt(oldSorce) - sorce;
		
		String newSql = "update sorces set u_sorce="+newSorce+" where u_id="+id;
		System.out.print("---------------"+sql);
		int result = jdbc.update(newSql);
		
		if(result==-1){
			//����ʧ��
		}else{
			//���ĳɹ�
			request.getRequestDispatcher("/ExchangeShowServlet").forward(request, response);
		}
	}

}
