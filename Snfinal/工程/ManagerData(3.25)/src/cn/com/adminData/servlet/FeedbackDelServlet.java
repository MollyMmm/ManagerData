package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.FeedbackBean;
import cn.com.adminData.service.FeedbackServiceImpl;

public class FeedbackDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FeedbackServiceImpl Feedback=new FeedbackServiceImpl();
		FeedbackBean FeedbackM=new FeedbackBean();
		HttpSession session = request.getSession();
		FeedbackM.setID(Integer.parseInt(request.getParameter("ID")));
		boolean bool=Feedback.deleteFeedback(FeedbackM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/feedback/deleteSucc.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/ordAdmin/feedback/deleteFail.jsp").forward(request, response);
		}
	}

}
