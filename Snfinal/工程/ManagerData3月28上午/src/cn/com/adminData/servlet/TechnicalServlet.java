package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.TechnicalServiceImpl;
import cn.com.managerData.util.JdbcUtil;

public class TechnicalServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TechnicalServiceImpl technical = new TechnicalServiceImpl();
		JdbcUtil jdbc = new JdbcUtil();
		PageBean pageBean = new PageBean();
		
		String sql = "select * from technical";
		if (request.getParameter("currentPage") != null) {
			// �� ��Ϣҳ������
			String currentPage = request.getParameter("currentPage");
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
			// ��ѯ�����û���Ϣ list ����sql
			pageBean.setSql(sql);
			int count = jdbc.getCount(sql);
			pageBean.setTotal(count);
			pageBean.setTotalPage(count);
			pageBean = technical.showOther(pageBean);

		} else {
			// ��½ҳ������

			pageBean = technical.showAll(sql);
		}
System.out.println("-------------1-------------------"+sql);	



		// ֱ����ʾ,���ǲ�ѯ
		int num = 1;
		request.setAttribute("num", num);

		request.setAttribute("technical", pageBean);
		request.getRequestDispatcher("/jsp/ordAdmin/technical/technical.jsp").forward(request, response);
		
	}

}
