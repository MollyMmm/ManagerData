package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SoilBean;
import cn.com.adminData.service.SoilServiceImpl;

public class SoilDelServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		SoilServiceImpl soil=new SoilServiceImpl();
		SoilBean soilM=new SoilBean();
		HttpSession session = request.getSession();
		
		soilM.setId(Integer.parseInt(request.getParameter("ID")));
		boolean bool=soil.deleteSoil(soilM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=soil").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del").forward(request, response);
		}
	}

}