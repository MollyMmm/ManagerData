package cn.com.managerData.servlet.superAdmin;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.service.AdminInfoSerive;

public class UpdateAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取要修改的管理员的ID
		String id = request.getParameter("id");
		// 从数据库中查询到该管理员所有信息---list 参数id
		AdminInfoSerive ais = new AdminInfoSerive();
		Map<String, Object> map = ais.selectOneAdmin(id);

		// 跳转显示
		request.setAttribute("map", map);
		request.getRequestDispatcher("/jsp/superAdmin/adminUpdate.jsp").forward(
				request, response);
	}

}
