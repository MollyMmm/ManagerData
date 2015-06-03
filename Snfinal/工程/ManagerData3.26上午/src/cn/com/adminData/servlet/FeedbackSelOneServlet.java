package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.FeedbackBean;
import cn.com.adminData.service.FeedBackTypeServiceImpl;
import cn.com.adminData.service.FeedbackServiceImpl;

public class FeedbackSelOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FeedbackServiceImpl Feedback=new FeedbackServiceImpl();
		FeedBackTypeServiceImpl type = new FeedBackTypeServiceImpl();
		
		String id = request.getParameter("id");
		FeedbackBean FeedbackN=Feedback.selectOne(id);
		
		request.setAttribute("type", type.allType());
		request.setAttribute("FeedbackN", FeedbackN);
		request.getRequestDispatcher("/jsp/ordAdmin/feedback/updateFeedback.jsp").forward(request, response);
	}

}
