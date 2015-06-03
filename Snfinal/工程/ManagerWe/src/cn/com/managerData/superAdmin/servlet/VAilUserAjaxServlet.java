package cn.com.managerData.superAdmin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.service.AdimnInfoSerive;

public class VAilUserAjaxServlet extends HttpServlet {

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 8112063568028271103L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		AdimnInfoSerive ais = new AdimnInfoSerive();
System.out.println("----0000----");		
		String userName = request.getParameter("userName");
System.out.println("----111----");			
		//AJAX实现 账号是否已经存在的验证 bool 参数userName
		boolean isVail = ais.isHave(userName);
System.out.println(isVail);			
	String info = isVail?"0":"1";//true账户已经存在	--0 ；   账户可以用  --1  ；
System.out.println("----3333----");			

		PrintWriter out = response.getWriter();
		out.write(info);
		System.out.println("----4444----");
		out.flush();
		out.close();

	}
}
