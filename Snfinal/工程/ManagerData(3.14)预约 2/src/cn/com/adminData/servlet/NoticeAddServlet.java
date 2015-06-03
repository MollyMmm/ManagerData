package cn.com.adminData.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.service.NoticeServiceImpl;

public class NoticeAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		NoticeServiceImpl Notice1=new NoticeServiceImpl();
		NoticeBean NoticeM1=new NoticeBean();
		HttpSession session = request.getSession();
		
		NoticeM1.setExtendedId(Integer.parseInt(request.getParameter("biaoshiID")));
		NoticeM1.setTitle(request.getParameter("timu"));
		NoticeM1.setBody(request.getParameter("neirong"));
		NoticeM1.setMainBody(request.getParameter("genggai"));
		NoticeM1.setPublishTime(request.getParameter("fabushijian"));
		NoticeM1.setUpdateTime(request.getParameter("gengxinshijian"));
		NoticeM1.setPicture(request.getParameter("tupian"));
		NoticeM1.setType(Integer.parseInt(request.getParameter("gonggaoleixing")));
		Notice1.addNotice(NoticeM1, session);
		request.getRequestDispatcher("/jsp/ordAdmin/notice/addSucc.jsp").forward(request, response);
	
	}

}
