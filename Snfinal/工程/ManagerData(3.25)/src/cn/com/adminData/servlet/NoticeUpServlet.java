package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.service.NoticeServiceImpl;


public class NoticeUpServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeServiceImpl Notice=new NoticeServiceImpl();
		NoticeBean NoticeN=new NoticeBean();
		
		HttpSession session = request.getSession();
		NoticeN.setID(Integer.parseInt(request.getParameter("Id")));
		NoticeN.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		NoticeN.setTitle(request.getParameter("Title"));
		NoticeN.setBody(request.getParameter("Body"));
		NoticeN.setMainBody(request.getParameter("MainBody"));
		NoticeN.setPicture(request.getParameter("Picture"));
		NoticeN.setType((Integer.parseInt(request.getParameter("Type"))));
		
		boolean update=Notice.updateNotice(NoticeN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/notice/updateSucc.jsp").forward(request, response);
	
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/notice/updateFail.jsp").forward(request, response);
		}
		
		
	}
	
	

}
