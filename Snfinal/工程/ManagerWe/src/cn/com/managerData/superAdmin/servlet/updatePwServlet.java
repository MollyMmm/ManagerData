package cn.com.managerData.superAdmin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.manager.model.AdimnInfo;
import cn.com.managerData.service.AdimnInfoSerive;
import cn.com.managerData.util.PasswordMd5;

public class updatePwServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7804828615373058586L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdimnInfo admin = new AdimnInfo();
		PasswordMd5 md5 = new PasswordMd5();
		 AdimnInfoSerive ais = new AdimnInfoSerive();

System.out.println("----1111-执行更新");
	//更新条件:ID ------参数: 
	admin.setId(Integer.parseInt(request.getParameter("id"))) ;
	
	admin.setPassword(md5.generatePassword(request.getParameter("password")));
	
	
System.out.println("-----22222执行更新");
	 //执行更新操作-----

	boolean result = ais.updatePw(admin);
System.out.println("-----执行更新");
		if (result) {
			// 更新 成功 后
			response.sendRedirect(request.getContextPath()
					+ "/superAdmin/message.jsp?message=password");
		} else {
			// 更新 失败 后
			response.sendRedirect(request.getContextPath()
					+ "/superAdmin/error.jsp?message=password");
		}
	}

}
