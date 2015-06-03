package cn.com.managerData.servlet.superAdmin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.service.AdminInfoSerive;
import cn.com.managerData.util.PasswordMd5;

public class VailPwAjaxServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PasswordMd5 md5 = new PasswordMd5();
		AdminInfoSerive ais = new AdminInfoSerive();

		// 更新条件:ID ------参数:
		String id = request.getParameter("id");
		String passwordInput = md5.generatePassword(request
				.getParameter("password"));
		String password = ais.selectPw(id);

		String info = "";
		if (passwordInput.equals(password)) {
			info = "1";
		} else {
			info = "0";
		}

		PrintWriter out = response.getWriter();
		out.write(info);

		out.flush();
		out.close();

	}

}
