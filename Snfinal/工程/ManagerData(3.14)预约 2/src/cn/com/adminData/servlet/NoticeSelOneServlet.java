package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.service.NoticeServiceImpl;

public class NoticeSelOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeServiceImpl Notice=new NoticeServiceImpl();
		String id = request.getParameter("id");
		NoticeBean NoticeN=Notice.selectOne(id);
		request.setAttribute("NoticeN", NoticeN);
		request.getRequestDispatcher("/jsp/ordAdmin/notice/updateNotice.jsp").forward(request, response);
	
	}

}
