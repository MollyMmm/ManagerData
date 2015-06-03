package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PrivateConsultBean;
import cn.com.adminData.service.PrivateConsultServiceImpl;

public class PrivateConsultDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		PrivateConsultServiceImpl consult = new PrivateConsultServiceImpl();
		PrivateConsultBean consultD = new PrivateConsultBean();
		HttpSession session = request.getSession();
		
		consultD.setId(Integer.parseInt(request.getParameter("ID"))); 
		boolean bool = consult.deletePrivateConsult(consultD, session);
System.out.println("--------------"+bool);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/privateConsult/deleteSucc.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/jsp/ordAdmin/privateConsult/deleteFail.jsp").forward(request, response);
		}
        
	}

}
