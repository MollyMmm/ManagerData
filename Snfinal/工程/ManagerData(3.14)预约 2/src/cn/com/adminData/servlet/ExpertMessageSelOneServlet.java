package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.ExpertMessageBean;
import cn.com.adminData.service.ExpertMessageServiceImpl;

public class ExpertMessageSelOneServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		ExpertMessageServiceImpl ExpertMessage = new ExpertMessageServiceImpl();
		String id = request.getParameter("id");
		ExpertMessageBean ExpertMessageN=ExpertMessage.selectOne(id);
		request.setAttribute("ExpertMessageN", ExpertMessageN);
		request.getRequestDispatcher("/jsp/ordAdmin/expertMessage/updateMessage.jsp").forward(request, response);
		
	}

}
