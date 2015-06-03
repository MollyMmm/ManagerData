package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.FeedbackBean;
import cn.com.adminData.service.FeedbackServiceImpl;

public class FeedbackAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		FeedbackServiceImpl Feedback1=new FeedbackServiceImpl();
		FeedbackBean FeedbackM1=new FeedbackBean();
		HttpSession session = request.getSession();
		
		FeedbackM1.setExtendedId(Integer.parseInt(request.getParameter("biaoshiID")));
		FeedbackM1.setUserID(request.getParameter("yonghuID"));
		FeedbackM1.setTitle(request.getParameter("timu"));
		FeedbackM1.setDescription(request.getParameter("neirongmiaoshu"));
		FeedbackM1.setDeadline(request.getParameter("qiwangqixian"));
		FeedbackM1.setRequire(request.getParameter("yonghuyaoqiu"));
		FeedbackM1.setType(Integer.parseInt(request.getParameter("fankuileixing")));
		FeedbackM1.setSentTime(request.getParameter("fasongshijian"));
		Feedback1.addFeedback(FeedbackM1, session);
		request.getRequestDispatcher("/jsp/ordAdmin/feedback/addSucc.jsp").forward(request, response);
		
	}

}
