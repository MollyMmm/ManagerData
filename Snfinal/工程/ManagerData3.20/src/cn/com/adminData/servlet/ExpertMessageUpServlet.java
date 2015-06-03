package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.ExpertMessageBean;
import cn.com.adminData.service.ExpertMessageServiceImpl;

public class ExpertMessageUpServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ExpertMessageServiceImpl ExpertMessage = new ExpertMessageServiceImpl();
		ExpertMessageBean ExpertMessageN=new ExpertMessageBean();
		HttpSession session = request.getSession();
		
		ExpertMessageN.setId(Integer.parseInt(request.getParameter("Id")));
		ExpertMessageN.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		ExpertMessageN.setNames(request.getParameter("Names"));
		ExpertMessageN.setHead_Portrait(request.getParameter("Head_Portrait"));
		ExpertMessageN.setBirth(request.getParameter("Birth"));
		ExpertMessageN.setMajor(request.getParameter("Major"));
		ExpertMessageN.setDutyTime(request.getParameter("DutyTime"));
		ExpertMessageN.setInfo(request.getParameter("Info"));
		
		boolean update=ExpertMessage.updateMessageService(ExpertMessageN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=expertDel").forward(request, response);
	
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del").forward(request, response);
		}
	}

}
