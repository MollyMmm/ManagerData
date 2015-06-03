package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SuplyBean;
import cn.com.adminData.service.SuplyServiceImpl;

public class SuplyDelServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		SuplyServiceImpl suply=new SuplyServiceImpl();
		SuplyBean suplyM=new SuplyBean();
		HttpSession session = request.getSession();
		
		suplyM.setId(Integer.parseInt(request.getParameter("ID")));
		boolean bool=suply.deleteSuply(suplyM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=suply").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del").forward(request, response);
		}
	}

}
