package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.SoilMessageBean;
import cn.com.adminData.service.SoilMessageServiceImpl;

public class SoilMessageSelOneServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SoilMessageServiceImpl SoilMessage=new SoilMessageServiceImpl();
		String id = request.getParameter("id");
		SoilMessageBean SoilMessageN=SoilMessage.selectOne(id);
		request.setAttribute("SoilMessageN", SoilMessageN);
		request.getRequestDispatcher("/jsp/ordAdmin/soilMessage/updateSoilMessage.jsp").forward(request, response);
		
	}

}
