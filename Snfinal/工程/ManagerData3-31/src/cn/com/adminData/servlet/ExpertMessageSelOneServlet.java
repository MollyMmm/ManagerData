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
		
		String state = request.getParameter("state");
		
		String id = request.getParameter("id");
		
		ExpertMessageBean ExpertMessageN=ExpertMessage.selectOne(id);
		
		request.setAttribute("ExpertMessageN", ExpertMessageN);
		if(state.equals("1")){
			//±à¼­
			request.getRequestDispatcher("/jsp/ordAdmin/expertMessage/updateMessage.jsp").forward(request, response);
		}else{
			//²é¿´
			request.getRequestDispatcher("/jsp/ordAdmin/expertMessage/oneMessage.jsp").forward(request, response);
		}
		//request.getRequestDispatcher("/jsp/ordAdmin/expertMessage/updateMessage.jsp").forward(request, response);
		
	}

}
