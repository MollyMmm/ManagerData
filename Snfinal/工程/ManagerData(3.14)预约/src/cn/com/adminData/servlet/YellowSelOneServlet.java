package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.YellowPageBean;
import cn.com.adminData.service.YellowServiceImpl;

public class YellowSelOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		YellowServiceImpl YellowPage=new YellowServiceImpl();
		String id = request.getParameter("id");
	System.out.println("-------------------"+id);
		//���ݴ��ݹ�����ID��ȡһ������
		YellowPageBean YellowPageN=YellowPage.selectOne(id);
		//��ת����ֵ
		request.setAttribute("YellowPageN", YellowPageN);
		System.out.println("--------------!!-----");
		request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/updateYellow.jsp").forward(request, response);
		
	}

}
