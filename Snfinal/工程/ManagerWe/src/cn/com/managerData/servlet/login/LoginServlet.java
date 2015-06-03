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
System.out.println("----1111-ִ�е�½�ж�");
		AdimnInfo admin = new AdimnInfo();
		AdimnInfoSerive ais = new AdimnInfoSerive();
		HttpSession session=request.getSession();
		
System.out.println("----2222-ִ�е�½�ж�");
//��֤��֤��
		String clientRandom = request.getParameter("randomTxt");
		String random =session.getAttribute("RANDOM").toString();
System.out.println(clientRandom + "::��ȷ��" + random);
		

		if(clientRandom.equals(random)){
			
			// ��ȡ������˺��Լ�����	
			admin.setUserName(request.getParameter("UserName"));
			admin.setPassword(request.getParameter("password"));
				
				// -------����int����,����UserName,Password��������Ա����1,��ͨ����Ա ����0,���ǹ���Ա����-1,
		System.out.println("----333333-ִ�е�½�ж�"+request.getParameter("password"));
				
				int isAdmin = ais.isAdmin(admin.getUserName(), admin.getPassword());
		System.out.println("----4444444-ִ�е�½�ж�");	
				
				switch (isAdmin) {
				case 1: {
					// ��������Ա��
					admin.setIdentity(1);
					session.setAttribute("admin", admin);
					
					response.sendRedirect(request.getContextPath()
							+ "/superAdmin/index.html");
					
					break;
				}
				case 0: {// ��ͨ����Ա
					admin.setIdentity(0);
					session.setAttribute("admin", admin);
					response.sendRedirect(request.getContextPath() + "/admin/main.jsp");
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
