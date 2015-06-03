package cn.com.managerData.superAdmin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.manager.model.AdimnInfo;
import cn.com.managerData.service.AdimnInfoSerive;
import cn.com.managerData.util.GetUserCreateTime;
import cn.com.managerData.util.PasswordMd5;

public class adminAddServlet extends HttpServlet {

 
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

	 //���ӹ���Ա
		AdimnInfo admin = new AdimnInfo();
		AdimnInfoSerive ais = new AdimnInfoSerive();
		PasswordMd5 md5 = new PasswordMd5();
		GetUserCreateTime ctime = new GetUserCreateTime();
		
System.out.println("----1111-ִ������");
	
	
	admin.setUserName(request.getParameter("userName"));
	admin.setPassword(md5.generatePassword(request.getParameter("password")));
	admin.setEmail(request.getParameter("email"));
	admin.setTele(request.getParameter("tele"));
	admin.setSex(request.getParameter("sex"));
	admin.setRealName(request.getParameter("realName"));

	//---��ȡ������
	ctime.setCreateTime();
	admin.setCreatTime(ctime.getCreateTime());
System.out.println("-----22222ִ������");
	
	boolean result = ais.addAdimn(admin);
	if(result){
		//����   �ɹ�  ��
		 response.sendRedirect(request.getContextPath()+"/superAdmin/message.jsp?message=add");
	}else{
		//����  ʧ��  ��
		 response.sendRedirect(request.getContextPath()+"/superAdmin/error.jsp?message=add");
	}
	 
	
		
	}

}
