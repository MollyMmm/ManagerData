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

		// ��������:ID ------����:
		admin.setId(Integer.parseInt(request.getParameter("id")));

		admin.setPassword(md5.generatePassword(request.getParameter("password")));

		// ִ�и��²���-----

		boolean result = ais.updatePw(admin);

		if (result) {
			// ���� �ɹ� ��
			response.sendRedirect(request.getContextPath()
					+ "/jsp/superAdmin/message.jsp?message=password");
		} else {
			// ���� ʧ�� ��
			response.sendRedirect(request.getContextPath()
					+ "/jsp/superAdmin/error.jsp?message=password");
		}
	}

}
