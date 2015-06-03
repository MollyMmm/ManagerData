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
		
//��֤��֤��
		//���ݹ�����
		String clientRandom = request.getParameter("randomTxt");
		//��ȷ��
		String random =session.getAttribute("RANDOM").toString();

		

		if(clientRandom.equals(random)){
			
			// ��ȡ������˺��Լ�����	
			admin.setUserName(request.getParameter("UserName"));
			admin.setPassword(request.getParameter("password"));
				
				// ����int����,����UserName,Password��������Ա����1,��ͨ����Ա ����0,���ǹ���Ա����-1,				
				int isAdmin = ais.isAdmin(admin.getUserName(), admin.getPassword());	
System.out.println("----------------------------"+request.getParameter("UserName"));
				switch (isAdmin) {
				case 1: {
					// ��������Ա��
					admin.setIdentity(1);
	
					session.setAttribute("admin", admin);

					//System.out.println(request.getContextPath());
					response.sendRedirect(request.getContextPath()+"/jsp/superAdmin/index.html");
					
										
					break;
				}
				case 0: {// ��ͨ����Ա
					admin.setIdentity(0);
					session.setAttribute("admin", admin);
					
					response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/backDemo.jsp");
				
					break;
				}
				default: {
					// �˺Ż��������
					request.setAttribute("strInfo", "�Բ���,��������˺Ż��������,����������!");
					request.getRequestDispatcher(
							 "/jsp/login/login.jsp").forward(
							request, response);

					break;
				}
				}
		}else{
			request.setAttribute("strInfo", "��֤���������,����������!");
			request.getRequestDispatcher(
					 "/jsp/login/login.jsp").forward(
					request, response);
		}
	

	}

}
