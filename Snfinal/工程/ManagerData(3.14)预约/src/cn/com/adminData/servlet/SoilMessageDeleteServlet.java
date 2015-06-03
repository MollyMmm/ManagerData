package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SoilMessageBean;
import cn.com.adminData.service.SoilMessageServiceImpl;

public class SoilMessageDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		SoilMessageServiceImpl consult = new SoilMessageServiceImpl();
		SoilMessageBean consultM = new SoilMessageBean();
		HttpSession session = request.getSession();
		
		consultM.setId(Integer.parseInt(request.getParameter("ID"))); 
		boolean bool = consult.deleteSoilMessage(consultM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/soilMessage/deleteSucc.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/jsp/ordAdmin/soilMessage/deleteFail.jsp").forward(request, response);
		}
        
	}

}
