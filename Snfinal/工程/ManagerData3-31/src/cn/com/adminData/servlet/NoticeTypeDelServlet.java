package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.service.NoticeTypeServiceImpl;

public class NoticeTypeDelServlet extends HttpServlet {

	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	NoticeTypeServiceImpl notice = new NoticeTypeServiceImpl();
		
		String id = request.getParameter("ID");
		HttpSession session = request.getSession();
				
		boolean result =notice.delType(id,session);
			if (result) {
				// 公告类型删除成功
				response.sendRedirect(request.getContextPath()+ "/jsp/ordAdmin/message.jsp?message=del");
			} else {
				// 删除失败
				response.sendRedirect(request.getContextPath()+ "/jsp/ordAdmin/error.jsp?message=del");
			}
			

	}

}
