package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.service.NoticeTypeServiceImpl;

public class NoticeTypeServlet extends HttpServlet {
 
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeTypeServiceImpl notice = new NoticeTypeServiceImpl();
		
		String type = request.getParameter("type");
		
		request.setAttribute("type", notice.allType());
		if(type.equals("notice")){
		request.getRequestDispatcher("/jsp/ordAdmin/notice/addNotice.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/jsp/ordAdmin/notice/noticeType.jsp").forward(request, response);
		}
		
			}

}
