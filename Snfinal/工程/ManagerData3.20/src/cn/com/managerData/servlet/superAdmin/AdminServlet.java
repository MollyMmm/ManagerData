package cn.com.managerData.servlet.superAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.model.PageBean;
import cn.com.managerData.service.UserService;

public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageBean pageBean = new PageBean();
		UserService userService = new UserService();

		String currentPage = "";

		if (request.getParameter("currentPage") != null) {
			// �� ��Ϣҳ������
			currentPage = request.getParameter("currentPage");
System.out.println("--------1-------");
		} else {
			// ��½ҳ������
			currentPage = Integer.toString(pageBean.getCurrentPage());
		}

		// ��ѯ�����û���Ϣ list ����sql
		pageBean = userService.listByPage(currentPage);

		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/jsp/superAdmin/adminOperator.jsp").forward(
				request, response);
	}

}
