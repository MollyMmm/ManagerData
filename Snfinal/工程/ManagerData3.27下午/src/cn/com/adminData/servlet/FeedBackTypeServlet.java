package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.service.FeedBackTypeServiceImpl;

public class FeedBackTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FeedBackTypeServiceImpl feed = new FeedBackTypeServiceImpl();
		
		String type = request.getParameter("type");
		
		request.setAttribute("type", feed.allType());
		if(type.equals("feedback")){
		request.getRequestDispatcher("/jsp/ordAdmin/feedback/addFeedback.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/jsp/ordAdmin/feedback/feedBackType.jsp").forward(request, response);
		}
	}

}
