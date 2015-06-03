package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.FeedbackBean;
import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.service.FeedbackServiceImpl;

public class FeedbackAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		FeedbackServiceImpl Feedback1=new FeedbackServiceImpl();
		FeedbackBean FeedbackM1=new FeedbackBean();
		HttpSession session = request.getSession();
		
		FeedbackM1.setExtendedId(Integer.parseInt(request.getParameter("biaoshiID")));
		FeedbackM1.setUserID(request.getParameter("yonghuID"));
		FeedbackM1.setTitle(request.getParameter("timu"));
		FeedbackM1.setDescription(request.getParameter("neirongmiaoshu"));
		//FeedbackM1.setDeadline(request.getParameter("qiwangqixian"));
		FeedbackM1.setRequire(request.getParameter("yonghuyaoqiu"));
		FeedbackM1.setType(Integer.parseInt(request.getParameter("fankuileixing")));
		//FeedbackM1.setSentTime(request.getParameter("fasongshijian"));
		
		boolean result = Feedback1.addFeedback(FeedbackM1, session);
	
		if(result){
			//��ӳɹ�
			
		//��ȡ��ӳɹ����id
		String id = Feedback1.selectId(FeedbackM1.getTitle(), FeedbackM1.getDescription());
		//���ݲ�ѯ����id,��ȡ��id��Ӧ��ȫ������Ϣ,�Զ�����ʽ�洢
		FeedbackBean FeedbackM = Feedback1.selectOne(id);
		
		//��ֵ,��ת�� Ԥ������
		request.setAttribute("feedback", FeedbackM);
		request.getRequestDispatcher("/jsp/ordAdmin/feedback/viewFeedBack.jsp").forward(request, response);
		//request.getRequestDispatcher("/jsp/ordAdmin/feedback/addSucc.jsp").forward(request, response);
		} else {

			//���ʧ��
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}

}
