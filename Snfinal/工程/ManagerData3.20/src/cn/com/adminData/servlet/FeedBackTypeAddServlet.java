package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.service.FeedBackTypeServiceImpl;

public class FeedBackTypeAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FeedBackTypeServiceImpl feedback = new FeedBackTypeServiceImpl();
		HttpSession session = request.getSession();
		
		String type = request.getParameter("type");
		
System.out.println("---------------------"+type);		
		boolean result =feedback.addType(type,session);
		if(result){
			//                                                     
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/message.jsp?message=add");
		}else{
			//	
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}

}
