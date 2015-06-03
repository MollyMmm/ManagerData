package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SuplyBean;
import cn.com.adminData.service.SuplyServiceImpl;

public class SuplyUpServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	SuplyServiceImpl Techincal=new SuplyServiceImpl();
		SuplyBean suplyN=new SuplyBean();
		HttpSession session = request.getSession();
		
		suplyN.setId(Integer.parseInt(request.getParameter("Id")));
		suplyN.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		suplyN.setNames(request.getParameter("Names"));
		suplyN.setPicture(request.getParameter("Picture"));
		suplyN.setPrice(request.getParameter("Price"));
		suplyN.setPreprice(request.getParameter("Preprice"));
		suplyN.setIntroduction(request.getParameter("Introduction"));
		
		boolean update=Techincal.updateSuply(suplyN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=suply").forward(request, response);
	
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del").forward(request, response);
		}
	}
}