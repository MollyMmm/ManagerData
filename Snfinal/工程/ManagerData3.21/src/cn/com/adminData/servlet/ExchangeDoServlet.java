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
		
		//�����ݿ��л�ȡ���û�ԭ�еĻ���
		String sql = "select u_sorce from sorces where id="+id;
		
		List<Map<String,Object>> list = jdbc.query(sql);
		String oldSorce =(String)list.get(0).get("U_SORCE");
		
		int newSorce = Integer.parseInt(oldSorce) - sorce;
	if(newSorce>=0){
		String newSql = "update sorces set u_sorce="+newSorce+" where id="+id;
		
		int result = jdbc.update(newSql);
		
		if(result==-1){
			//����ʧ��
		}else{
			//���ĳɹ�,����ˢ��session
			request.getRequestDispatcher("/ExchangeShowServlet").forward(request, response);
		}
	}
	else{
		request.getRequestDispatcher("/jsp/ordAdmin/exchange/exchangeFail.jsp").forward(request, response);
	}
	}}
