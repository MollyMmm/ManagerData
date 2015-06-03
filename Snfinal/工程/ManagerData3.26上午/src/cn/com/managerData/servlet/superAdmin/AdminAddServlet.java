package cn.com.managerData.servlet.superAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.model.AdminInfo;
import cn.com.managerData.service.AdminInfoSerive;
import cn.com.managerData.util.GetUserCreateTime;
import cn.com.managerData.util.PasswordMd5;

public class AdminAddServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 //增加管理员
		AdminInfo admin = new AdminInfo();
		AdminInfoSerive ais = new AdminInfoSerive();
		PasswordMd5 md5 = new PasswordMd5();
		GetUserCreateTime ctime = new GetUserCreateTime();
		
	admin.setUserName(request.getParameter("userName"));
	admin.setPassword(md5.generatePassword(request.getParameter("password")));
	admin.setEmail(request.getParameter("email"));
	admin.setTele(request.getParameter("tele"));
	admin.setSex(request.getParameter("sex"));
	admin.setRealName(request.getParameter("realName"));
System.out.println("--------------------1------------------------");
	//---获取年月日
	ctime.setCreateTime();
	admin.setCreatTime(ctime.getCreateTime());
	
	boolean result = ais.addAdimn(admin);
	if(result){
		//更新   成功  后
		 response.sendRedirect(request.getContextPath()+"/jsp/superAdmin/message.jsp?message=add");
	}else{
		//更新  失败  后
		 response.sendRedirect(request.getContextPath()+"/jsp/superAdmin/error.jsp?message=add");
	}
	 
	
		
	}

}
