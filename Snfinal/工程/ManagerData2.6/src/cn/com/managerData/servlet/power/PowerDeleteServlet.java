package cn.com.managerData.servlet.power;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.manager.model.RoleBean;
import cn.com.managerData.service.PowerInfoService;
import cn.com.managerData.service.PowerService;

public class PowerDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoleBean role = new RoleBean();
		PowerService powerService = new PowerService();
		PowerInfoService power = new PowerInfoService();
		System.out.println("delete ----------");
		role.setRole_id(Integer.parseInt(request.getParameter("role_id")));
				
		boolean result = powerService.deletePower(role);
		boolean result2 = power.deletePower(role);
		System.out.println("ok - delete ----------");
		
		if (result&&result2) {
			// 更新 成功 后
			response.sendRedirect(request.getContextPath()
					+ "/superAdmin/message.jsp?message=deletePower");
		} else {
			// 更新 失败 后
			response.sendRedirect(request.getContextPath()
					+ "/superAdmin/error.jsp?message=deletePower");
		}
	}

}
