package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.SellingSoilBean;
import cn.com.adminData.service.SellingSoilServiceImpl;

public class SellingSoilSelOneServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		SellingSoilServiceImpl consult = new SellingSoilServiceImpl();
			
		String id = request.getParameter("id");
		//���ݴ��ݹ�����ID��ȡһ������
		System.out.println("-----------1--");
		SellingSoilBean consultM = consult.selectOne(id);
		//��ת����ֵ
		request.setAttribute("consultM", consultM);
		request.getRequestDispatcher("/jsp/ordAdmin/sellingSoil/updateSellingSoil.jsp").forward(request, response);
		
	}

}
