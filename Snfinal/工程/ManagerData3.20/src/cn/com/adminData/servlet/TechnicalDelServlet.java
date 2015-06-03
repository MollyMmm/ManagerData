package cn.com.adminData.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.TechnicalBean;
import cn.com.adminData.service.TechnicalServiceImpl;

public class TechnicalDelServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		TechnicalServiceImpl Technical=new TechnicalServiceImpl();
		TechnicalBean TechnicalM=new TechnicalBean();
		HttpSession session = request.getSession();
		
		TechnicalM.setId(Integer.parseInt(request.getParameter("ID")));
		boolean bool=Technical.deleteTechnical(TechnicalM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=technicalDel").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del").forward(request, response);
		}
	}

}
