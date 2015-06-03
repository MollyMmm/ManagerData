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
	 * �ж��û��Ƿ��¼�Ĺ���������ֹ�Ƿ���¼��
	
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



		//��ǰ������ʵ�¼ҳ��
		  if(!servetPaht.contains("jsp/superAdmin/")&&!servetPaht.contains("jsp/ordAdmin")){
			  chain.doFilter(request, response);
			  return;
		  }else{
			  
			  System.out.println("servetPaht:"+servetPaht);
			  System.out.println("requestUrl:"+requestUrl);

			  
		//��ǰ���ʵĲ���admin�µĵ�½ҳ���ж��û��Ƿ��Ѿ���¼
			  
			//��ȡ��session����
			HttpSession  session=request.getSession();
			//��λ�ȡapplication��
			//ServletContext   application=request.getSession().getServletContext();
			//admin�ļ����£�����admin_login.jsp��¼ҳ�⣬����ҳ������¼����ܷ��ʣ�����ֱ����ת����½ҳ
			//����ڹ��������ж��û��Ƿ��Ѿ���¼��
			AdminInfo admin = (AdminInfo)session.getAttribute("admin");
			if(admin!=null){
				
				//��ȡ����Ա���
				int identity = admin.getIdentity();
				
				if (identity == 1 && servetPaht.contains("admin/")) {
					
					// �û�Ϊ��������Ա����ͨ��·��������ͨ����Ա���棬��ת����½ҳ
					request.getRequestDispatcher("/jsp/login/login.jsp").forward(
							request, response);
				} else if (identity == 0 && servetPaht.contains("superAdmin/")) {
					
					// �û�Ϊ��ͨ����Ա����ͨ��·�����ʳ�������Ա���棬��ת����½ҳ
					request.getRequestDispatcher("/jsp/login/login.jsp").forward(
							request, response);
				} else {
					
					// �û��Ѿ��ɹ���¼�������������ִ��
					chain.doFilter(request, response);
				}

			} else {
				
				// �û�û�е�¼����ת����½ҳ
				request.getRequestDispatcher("/jsp/login/login.jsp").forward(
						request, response);
			}
		  }
		  
		  
		  
		}


	
	public void init(FilterConfig arg0) throws ServletException {
		 
		
	}

}
