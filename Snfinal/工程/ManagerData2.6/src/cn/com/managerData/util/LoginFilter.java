package cn.com.managerData.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.manager.model.AdimnInfo;





public class LoginFilter implements Filter{
	/**
	 * 判断用户是否登录的过滤器（防止非法登录）
	
	 *
	 */
	@Override
	public void destroy() {
		 
			
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		 
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		String servetPaht = request.getServletPath();
		String  requestUrl = request.getRequestURL().toString();
		
System.out.println("servetPaht:"+servetPaht);
System.out.println("requestUrl:"+requestUrl);



		//当前请求访问登录页面
		  if(servetPaht.contains("login/login.jsp")||servetPaht.contains("images/")){
			  chain.doFilter(request, response);
			  return;
		  }else{
		//当前访问的不是admin下的登陆页，判断用户是否已经登录
			  
			//获取到session对象
			HttpSession  session=request.getSession();
			//如何获取application？
			//ServletContext   application=request.getSession().getServletContext();
			//admin文件夹下，除了admin_login.jsp登录页外，其他页面必须登录后才能访问，否则直接跳转到登陆页
			//如何在过滤器内判断用户是否已经登录？
			AdimnInfo admin = (AdimnInfo)session.getAttribute("admin");
			if(admin!=null){
				
				//获取管理员身份
				int identity = admin.getIdentity();
				
				if (identity == 1 && servetPaht.contains("admin/")) {
					
					// 用户为超级管理员但是通过路径访问普通管理员界面，跳转到登陆页
					request.getRequestDispatcher("/login/login.jsp").forward(
							request, response);
				} else if (identity == 0 && servetPaht.contains("superAdmin/")) {
					
					// 用户为普通管理员但是通过路径访问超级管理员界面，跳转到登陆页
					request.getRequestDispatcher("/login/login.jsp").forward(
							request, response);
				} else {
					
					// 用户已经成功登录，请求继续向下执行
					chain.doFilter(request, response);
				}

			} else {
				
				// 用户没有登录，跳转到登陆页
				request.getRequestDispatcher("/login/login.jsp").forward(
						request, response);
			}
		  }
		}

/*		String currentURL = request.getRequestURI(); //取得根目录所对应的绝对路径: 

		String targetURL = currentURL.substring(currentURL.indexOf("/", 1),  
		currentURL.length()); //截取到当前文件名用于比较 
System.out.println(targetURL);
		HttpSession session = request.getSession(false);  

		if (!"/login/login.jsp".equals(targetURL)) { 
		//判断当前页是否是重定向以后的登录页面页面，如果是就不做session的判断，防止出现死循环 
		if (session == null || session.getAttribute("admin") == null) { 
		//*用户登录以后需手动添加session 
System.out.println("request.getContextPath()=" + request.getContextPath());  
		response.sendRedirect(request.getContextPath() + "/login/login.jsp");  
		//如果session为空表示用户没有登录就重定向到login.jsp页面 
		return;  
		} 
		} 
		chain.doFilter(request, response);*/
		
		
	/*	String servetPaht=	request.getServletPath();
		String  requestUrl=request.getRequestURL().toString();
	System.out.println("servetPaht:"+servetPaht);
	System.out.println("requestUrl:"+requestUrl);
		
	//当前请求访问登录页面
	  if(requestUrl.contains("login/login.jsp")){
		  chain.doFilter(request, response);
		  return;
	  }else{
	//当前访问的不是admin下的登陆页，判断用户是否已经登录
		//获取到session对象
		HttpSession  session = request.getSession();
		//admin文件夹下，除了login/login.jsp登录页外，其他页面必须登录后才能访问，否则直接跳转到登陆页
		//如何在过滤器内判断用户是否已经登录？
		AdimnInfo admin =(AdimnInfo)session.getAttribute("admin");
		if(admin!=null){
			//用户已经成功登录，请求继续向下执行
			chain.doFilter(request, response);
		}else{
			//用户没有登录，跳转到登陆页
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
	  }*/
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		 
		
	}

}
