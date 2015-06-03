package cn.com.adminData.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.TechnicalBean;
import cn.com.adminData.service.TechnicalServiceImpl;

public class TechnicalSelOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TechnicalServiceImpl Technical=new TechnicalServiceImpl();
 
		String state = request.getParameter("state");
		
		String id = request.getParameter("id");		 
		TechnicalBean TechnicalN = Technical.selectOne(id);
 
		request.setAttribute("technical", TechnicalN);
		
		if(state.equals("1")){
			//±à¼­
			request.getRequestDispatcher("/jsp/ordAdmin/technical/updateTechnical.jsp").forward(request, response);
		}else{
			//²é¿´
			request.getRequestDispatcher("/jsp/ordAdmin/technical/oneTechnical.jsp").forward(request, response);
		}
	}

}
