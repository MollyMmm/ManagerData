package cn.com.managerData.servlet.power;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.manager.model.PageBean;
import cn.com.managerData.service.PowerService;

public class PowerShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageBean pageBean = new PageBean();
		PowerService userService = new PowerService();

		String currentPage = "";

		if (request.getParameter("currentPage") != null) {
			// �� ��Ϣҳ������
			currentPage = request.getParameter("currentPage");
		} else {
			// ��ҳ������
			currentPage = Integer.toString(pageBean.getCurrentPage());
		}

		// ��ѯ�����û���Ϣ list ����sql
		pageBean = userService.listByPage(currentPage);
		
		List<List<Map<String, Object>>> power =(List<List<Map<String, Object>>>) userService.getPower(pageBean);

		request.setAttribute("power", power);
		request.getRequestDispatcher("/superAdmin/power/powerCenter.jsp").forward(
				request, response);
	}

}
