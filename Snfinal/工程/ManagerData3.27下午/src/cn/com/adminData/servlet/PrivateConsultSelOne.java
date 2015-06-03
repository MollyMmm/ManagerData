package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PrivateConsultBean;
import cn.com.adminData.service.PrivateConsultServiceImpl;

public class PrivateConsultSelOne extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		PrivateConsultServiceImpl consult = new PrivateConsultServiceImpl();
			
		String id = request.getParameter("id");
		//���ݴ��ݹ�����ID��ȡһ������
		PrivateConsultBean consultM = consult.selectOne(id);
		//��ת����ֵ
		request.setAttribute("consultM", consultM);
		request.getRequestDispatcher("/jsp/ordAdmin/privateConsult/updatePri.jsp").forward(request, response);
		
	}

}
