package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.SoilBean;
import cn.com.adminData.service.SoilServiceImpl;

public class SoilSelOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SoilServiceImpl selling=new SoilServiceImpl();
 
		String state = request.getParameter("state");
		
		String id = request.getParameter("id");		 
		SoilBean sellingN = selling.selectOne(id);
 
		request.setAttribute("soil", sellingN);
		
		if(state.equals("1")){
			//±à¼­
			request.getRequestDispatcher("/jsp/ordAdmin/soil/updateSoil.jsp").forward(request, response);
		}else{
			//²é¿´
			request.getRequestDispatcher("/jsp/ordAdmin/soil/oneSoil.jsp").forward(request, response);
		}
	}

}