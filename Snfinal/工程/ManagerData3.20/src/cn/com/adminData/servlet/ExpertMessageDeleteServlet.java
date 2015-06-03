package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.ExpertMessageBean;
import cn.com.adminData.service.ExpertMessageServiceImpl;

public class ExpertMessageDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		ExpertMessageServiceImpl consult = new ExpertMessageServiceImpl();
		ExpertMessageBean consultM = new ExpertMessageBean();
		HttpSession session = request.getSession();
		
		consultM.setId(Integer.parseInt(request.getParameter("ID"))); 
		
		boolean bool = consult.deleteMessageService(consultM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=expertDel").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del");
		}
        
	}

}
