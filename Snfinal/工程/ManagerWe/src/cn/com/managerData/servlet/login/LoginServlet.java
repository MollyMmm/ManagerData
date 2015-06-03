package cn.com.managerData.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.manager.model.AdimnInfo;
import cn.com.managerData.service.AdimnInfoSerive;

 

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
System.out.println("----1111-执行登陆判断");
		AdimnInfo admin = new AdimnInfo();
		AdimnInfoSerive ais = new AdimnInfoSerive();
		HttpSession session=request.getSession();
		
System.out.println("----2222-执行登陆判断");
//验证验证码
		String clientRandom = request.getParameter("randomTxt");
		String random =session.getAttribute("RANDOM").toString();
System.out.println(clientRandom + "::正确的" + random);
		

		if(clientRandom.equals(random)){
			
			// 获取输入的账号以及密码	
			admin.setUserName(request.getParameter("UserName"));
			admin.setPassword(request.getParameter("password"));
				
				// -------调用int函数,参数UserName,Password超级管理员返回1,普通管理员 返回0,不是管理员返回-1,
		System.out.println("----333333-执行登陆判断"+request.getParameter("password"));
				
				int isAdmin = ais.isAdmin(admin.getUserName(), admin.getPassword());
		System.out.println("----4444444-执行登陆判断");	
				
				switch (isAdmin) {
				case 1: {
					// 超级管理员级
					admin.setIdentity(1);
					session.setAttribute("admin", admin);
					
					response.sendRedirect(request.getContextPath()
							+ "/superAdmin/index.html");
					
					break;
				}
				case 0: {// 普通管理员
					admin.setIdentity(0);
					session.setAttribute("admin", admin);
					response.sendRedirect(request.getContextPath() + "/admin/main.jsp");
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
