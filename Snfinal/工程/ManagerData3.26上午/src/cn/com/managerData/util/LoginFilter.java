package cn.com.managerData.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.managerData.model.AdminInfo;









public class LoginFilter implements Filter{
	/**
	 * 判断用户是否登录的过滤器（防止非法登录）
	
	 *
	 */
	
	public void destroy() {
		 
			
		
	}

	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		 
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		

		String servetPaht = request.getServletPath();
		String  requestUrl = request.getRequestURL().toString();
		
System.out.println("servetPaht:"+servetPaht);
System.out.println("requestUrl:"+requestUrl);



		//当前请求访问登录页面
		  if(!servetPaht.contains("jsp/superAdmin/")&&!servetPaht.contains("jsp/ordAdmin")){
			  chain.doFilter(request, response);
			  return;
		  }else{
			  
			  System.out.println("servetPaht:"+servetPaht);
			  System.out.println("requestUrl:"+requestUrl);

			  
		//当前访问的不是admin下的登陆页，判断用户是否已经登录
			  
			//获取到session对象
			HttpSession  session=request.getSession();
			//如何获取application？
			//ServletContext   application=request.getSession().getServletContext();
			//admin文件夹下，除了admin_login.jsp登录页外，其他页面必须登录后才能访问，否则直接跳转到登陆页
			//如何在过滤器内判断用户是否已经登录？
			AdminInfo admin = (AdminInfo)session.getAttribute("admin");
			if(admin!=null){
				
				//获取管理员身份
				int identity = admin.getIdentity();
				
				if (identity == 1 && servetPaht.contains("admin/")) {
					
					// 用户为超级管理员但是通过路径访问普通管理员界面，跳转到登陆页
					request.getRequestDispatcher("/jsp/login/login.jsp").forward(
							request, response);
				} else if (identity == 0 && servetPaht.contains("superAdmin/")) {
					
					// 用户为普通管理员但是通过路径访问超级管理员界面，跳转到登陆页
					request.getRequestDispatcher("/jsp/login/login.jsp").forward(
							request, response);
				} else {
					
					// 用户已经成功登录，请求继续向下执行
					chain.doFilter(request, response);
				}

			} else {
				
				// 用户没有登录，跳转到登陆页
				request.getRequestDispatcher("/jsp/login/login.jsp").forward(
						request, response);
			}
		  }
		  
		  
		  
		}


	
	public void init(FilterConfig arg0) throws ServletException {
		 
		
	}

}
