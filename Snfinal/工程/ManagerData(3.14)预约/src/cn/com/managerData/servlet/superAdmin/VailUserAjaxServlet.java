package cn.com.managerData.servlet.superAdmin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.service.AdminInfoSerive;

public class VailUserAjaxServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		AdminInfoSerive ais = new AdminInfoSerive();
	
		String userName = request.getParameter("userName");
		
		//AJAX实现 账号是否已经存在的验证 bool 参数userName
		boolean isVail = ais.isHave(userName);
		
	String info = isVail?"0":"1";//true账户已经存在	--0 ；   账户可以用  --1  ；		

		PrintWriter out = response.getWriter();
		out.write(info);
		out.flush();
		out.close();

	}
}
