package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.SoilServiceImpl;
import cn.com.managerData.util.JdbcUtil;

public class SoilServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SoilServiceImpl soil = new SoilServiceImpl();
		JdbcUtil jdbc = new JdbcUtil();
		PageBean pageBean = new PageBean();
		
		String sql = "select * from sellingsoil";
		if (request.getParameter("currentPage") != null) {
			// �� ��Ϣҳ������
			String currentPage = request.getParameter("currentPage");
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
			// ��ѯ�����û���Ϣ list ����sql
			pageBean.setSql(sql);
			int count = jdbc.getCount(sql);
			pageBean.setTotal(count);
			pageBean.setTotalPage(count);
			pageBean = soil.showOther(pageBean);

		} else {
			// ��½ҳ������

			pageBean = soil.showAll(sql);
		}
System.out.println("-------------1-------------------"+sql);	



		// ֱ����ʾ,���ǲ�ѯ
		int num = 1;
		request.setAttribute("num", num);

		request.setAttribute("soil", pageBean);
		request.getRequestDispatcher("/jsp/ordAdmin/soil/soil.jsp").forward(request, response);
		
	}

}
