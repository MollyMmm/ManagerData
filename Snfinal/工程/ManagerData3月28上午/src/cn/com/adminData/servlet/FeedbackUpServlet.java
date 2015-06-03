package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.FeedbackBean;
import cn.com.adminData.service.FeedbackServiceImpl;

public class FeedbackUpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FeedbackServiceImpl Feedback=new FeedbackServiceImpl();
		FeedbackBean FeedbackN=new FeedbackBean();
		
		HttpSession session = request.getSession();
		FeedbackN.setID(Integer.parseInt(request.getParameter("Id")));
		FeedbackN.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		FeedbackN.setUserID(request.getParameter("UserID"));
		FeedbackN.setTitle(request.getParameter("Title"));
		//FeedbackN.setDescription(request.getParameter("Description"));
		FeedbackN.setDeadline(request.getParameter("Deadline"));
		FeedbackN.setRequire(request.getParameter("Require"));
		FeedbackN.setType((Integer.parseInt(request.getParameter("Type"))));
		//FeedbackN.setSentTime(request.getParameter("SentTime"));
		
		boolean update=Feedback.updateFeedback(FeedbackN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/feedback/updateSucc.jsp").forward(request, response);
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/feedback/updateFail.jsp").forward(request, response);
		}
	}

}
