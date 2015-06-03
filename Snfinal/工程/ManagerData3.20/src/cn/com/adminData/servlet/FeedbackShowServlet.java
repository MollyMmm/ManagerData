package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.FeedbackServiceImpl;

import cn.com.managerData.util.JdbcUtil;

public class FeedbackShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		FeedbackServiceImpl Feedback = new FeedbackServiceImpl();
		JdbcUtil jdbc = new JdbcUtil();
		PageBean pageBean = new PageBean();
		
		String sql = "select f.ID,f.EXTENDEDID,f.USERID,f.TITLE,f.DESCRIPTION,f.REQUIRE,f.TYPE,f.SENTTIME,ft.typename  from Feedback f,FeedbackType ft where f.type=ft.id";
		if (request.getParameter("currentPage") != null) {
			// �� ��Ϣҳ������
			String currentPage = request.getParameter("currentPage");
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
			// ��ѯ�����û���Ϣ list ����sql
			pageBean.setSql(sql);
			int count = jdbc.getCount(sql);
			pageBean.setTotal(count);
			pageBean.setTotalPage(count);
			pageBean = Feedback.showOther(pageBean);

		} else {
			// ��½ҳ������

			pageBean = Feedback.showAll(sql);
		}
		
		// ֱ����ʾ,���ǲ�ѯ
		int num = 1;
		request.setAttribute("num", num);

		System.out.println("-------------1-------------------");		
		request.setAttribute("Feedback", pageBean);
		request.getRequestDispatcher("/jsp/ordAdmin/feedback/feedback.jsp").forward(request, response);
	}

}
