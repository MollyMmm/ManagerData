package cn.com.managerData.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.managerData.model.AdminInfo;
import cn.com.managerData.service.AdminInfoSerive;



 

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminInfo admin = new AdminInfo();
		AdminInfoSerive ais = new AdminInfoSerive();
		HttpSession session=request.getSession();
		
//验证验证码
		//传递过来的
		String clientRandom = request.getParameter("randomTxt");
		//正确的
		String random =session.getAttribute("RANDOM").toString();

		

		if(clientRandom.equals(random)){
			
			// 获取输入的账号以及密码	
			admin.setUserName(request.getParameter("UserName"));
			admin.setPassword(request.getParameter("password"));
				
				// 调用int函数,参数UserName,Password超级管理员返回1,普通管理员 返回0,不是管理员返回-1,				
				int isAdmin = ais.isAdmin(admin.getUserName(), admin.getPassword());	
System.out.println("----------------------------"+request.getParameter("UserName"));
				switch (isAdmin) {
				case 1: {
					// 超级管理员级
					admin.setIdentity(1);
	
					session.setAttribute("admin", admin);

					//System.out.println(request.getContextPath());
					response.sendRedirect(request.getContextPath()+"/jsp/superAdmin/index.html");
					
										
					break;
				}
				case 0: {// 普通管理员
					admin.setIdentity(0);
					session.setAttribute("admin", admin);
					
					response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/backDemo.jsp");
				
					break;
				}
				default: {
					// 账号或密码错误
					request.setAttribute("strInfo", "对不起,您输入的账号或密码错误,请重新输入!");
					request.getRequestDispatcher(
							 "/jsp/login/login.jsp").forward(
							request, response);

					break;
				}
				}
		}else{
			request.setAttribute("strInfo", "验证码输入错误,请重新输入!");
			request.getRequestDispatcher(
					 "/jsp/login/login.jsp").forward(
					request, response);
		}
	

	}

}
