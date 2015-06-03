package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.service.NoticeServiceImpl;

public class NoticeDelServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getSession().setAttribute("admin", "admin");
		NoticeServiceImpl Notice=new NoticeServiceImpl();
		NoticeBean NoticeM=new NoticeBean();
		HttpSession session = request.getSession();
		NoticeM.setID(Integer.parseInt(request.getParameter("ID")));
		boolean bool=Notice.deleteNotice(NoticeM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/notice/deleteSucc.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/ordAdmin/notice/deleteFail.jsp").forward(request, response);
		}
	}

}
