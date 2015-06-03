package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PostMessageBean;
import cn.com.adminData.service.PostMessageServiceImpl;

public class PostMessageDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		PostMessageServiceImpl consult = new PostMessageServiceImpl();
		PostMessageBean consultM = new PostMessageBean();
		HttpSession session = request.getSession();
		
		consultM.setId(Integer.parseInt(request.getParameter("ID"))); 
		boolean bool = consult.deleteSoilMessage(consultM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/postMessage/deleteSucc.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/jsp/ordAdmin/postMessage/deleteFail.jsp").forward(request, response);
		}
        
	}

}
