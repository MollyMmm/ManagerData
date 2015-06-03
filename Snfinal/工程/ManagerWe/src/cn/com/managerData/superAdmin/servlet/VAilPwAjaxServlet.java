package cn.com.managerData.superAdmin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.com.managerData.service.AdimnInfoSerive;
import cn.com.managerData.util.PasswordMd5;

public class VAilPwAjaxServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8967786570893937066L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		PasswordMd5 md5 = new PasswordMd5();
		 AdimnInfoSerive ais = new AdimnInfoSerive();

System.out.println("----1111-执行更新");
	//更新条件:ID ------参数: 
	String id = request.getParameter("id");
	String passwordInput = md5.generatePassword(request.getParameter("password"));
System.out.println(passwordInput+"-----input");	
	String password = ais.selectPw(id);
System.out.println(password+"-----old");		
	String info = "";
	if(passwordInput.equals(password)){
		info="1";
	}else{
		info="0";
	}
System.out.println(info);	
	PrintWriter out = response.getWriter();
	out.write(info);
	System.out.println("----4444----");
	out.flush();
	out.close();
	
	}

}
