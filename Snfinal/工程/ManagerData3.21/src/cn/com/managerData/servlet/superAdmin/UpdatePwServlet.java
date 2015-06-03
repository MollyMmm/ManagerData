package cn.com.managerData.servlet.superAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.model.AdminInfo;
import cn.com.managerData.service.AdminInfoSerive;
import cn.com.managerData.util.PasswordMd5;

public class UpdatePwServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminInfo admin = new AdminInfo();
		PasswordMd5 md5 = new PasswordMd5();
		AdminInfoSerive ais = new AdminInfoSerive();

		// 更新条件:ID ------参数:
		admin.setId(Integer.parseInt(request.getParameter("id")));

		admin.setPassword(md5.generatePassword(request.getParameter("password")));

		// 执行更新操作-----

		boolean result = ais.updatePw(admin);

		if (result) {
			// 更新 成功 后
			response.sendRedirect(request.getContextPath()
					+ "/jsp/superAdmin/message.jsp?message=password");
		} else {
			// 更新 失败 后
			response.sendRedirect(request.getContextPath()
					+ "/jsp/superAdmin/error.jsp?message=password");
		}
	}

}
