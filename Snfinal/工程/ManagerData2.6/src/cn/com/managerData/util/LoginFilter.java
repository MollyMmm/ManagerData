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
	 * �ж��û��Ƿ��¼�Ĺ���������ֹ�Ƿ���¼��
	
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



		//��ǰ������ʵ�¼ҳ��
		  if(servetPaht.contains("login/login.jsp")||servetPaht.contains("images/")){
			  chain.doFilter(request, response);
			  return;
		  }else{
		//��ǰ���ʵĲ���admin�µĵ�½ҳ���ж��û��Ƿ��Ѿ���¼
			  
			//��ȡ��session����
			HttpSession  session=request.getSession();
			//��λ�ȡapplication��
			//ServletContext   application=request.getSession().getServletContext();
			//admin�ļ����£�����admin_login.jsp��¼ҳ�⣬����ҳ������¼����ܷ��ʣ�����ֱ����ת����½ҳ
			//����ڹ��������ж��û��Ƿ��Ѿ���¼��
			AdimnInfo admin = (AdimnInfo)session.getAttribute("admin");
			if(admin!=null){
				
				//��ȡ����Ա���
				int identity = admin.getIdentity();
				
				if (identity == 1 && servetPaht.contains("admin/")) {
					
					// �û�Ϊ��������Ա����ͨ��·��������ͨ����Ա���棬��ת����½ҳ
					request.getRequestDispatcher("/login/login.jsp").forward(
							request, response);
				} else if (identity == 0 && servetPaht.contains("superAdmin/")) {
					
					// �û�Ϊ��ͨ����Ա����ͨ��·�����ʳ�������Ա���棬��ת����½ҳ
					request.getRequestDispatcher("/login/login.jsp").forward(
							request, response);
				} else {
					
					// �û��Ѿ��ɹ���¼�������������ִ��
					chain.doFilter(request, response);
				}

			} else {
				
				// �û�û�е�¼����ת����½ҳ
				request.getRequestDispatcher("/login/login.jsp").forward(
						request, response);
			}
		  }
		}

/*		String currentURL = request.getRequestURI(); //ȡ�ø�Ŀ¼����Ӧ�ľ���·��: 

		String targetURL = currentURL.substring(currentURL.indexOf("/", 1),  
		currentURL.length()); //��ȡ����ǰ�ļ������ڱȽ� 
System.out.println(targetURL);
		HttpSession session = request.getSession(false);  

		if (!"/login/login.jsp".equals(targetURL)) { 
		//�жϵ�ǰҳ�Ƿ����ض����Ժ�ĵ�¼ҳ��ҳ�棬����ǾͲ���session���жϣ���ֹ������ѭ�� 
		if (session == null || session.getAttribute("admin") == null) { 
		//*�û���¼�Ժ����ֶ����session 
System.out.println("request.getContextPath()=" + request.getContextPath());  
		response.sendRedirect(request.getContextPath() + "/login/login.jsp");  
		//���sessionΪ�ձ�ʾ�û�û�е�¼���ض���login.jspҳ�� 
		return;  
		} 
		} 
		chain.doFilter(request, response);*/
		
		
	/*	String servetPaht=	request.getServletPath();
		String  requestUrl=request.getRequestURL().toString();
	System.out.println("servetPaht:"+servetPaht);
	System.out.println("requestUrl:"+requestUrl);
		
	//��ǰ������ʵ�¼ҳ��
	  if(requestUrl.contains("login/login.jsp")){
		  chain.doFilter(request, response);
		  return;
	  }else{
	//��ǰ���ʵĲ���admin�µĵ�½ҳ���ж��û��Ƿ��Ѿ���¼
		//��ȡ��session����
		HttpSession  session = request.getSession();
		//admin�ļ����£�����login/login.jsp��¼ҳ�⣬����ҳ������¼����ܷ��ʣ�����ֱ����ת����½ҳ
		//����ڹ��������ж��û��Ƿ��Ѿ���¼��
		AdimnInfo admin =(AdimnInfo)session.getAttribute("admin");
		if(admin!=null){
			//�û��Ѿ��ɹ���¼�������������ִ��
			chain.doFilter(request, response);
		}else{
			//�û�û�е�¼����ת����½ҳ
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
	  }*/
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		 
		
	}

}
