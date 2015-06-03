package cn.com.managerData.superAdmin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.manager.model.PageBean;
import cn.com.managerData.service.UserService;

public class adminServlet extends HttpServlet {

 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7046064893932345845L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageBean pageBean= new PageBean();
		UserService userService = new UserService();
		
		
		String currentPage="";
		
		if(request.getParameter("currentPage")!=null){
			//�� ��Ϣҳ������
			 currentPage = request.getParameter("currentPage");
		}else{
			//��½ҳ������
			currentPage =Integer.toString(pageBean.getCurrentPage());
		}
		
		
		
		
 //��ѯ�����û���Ϣ list ����sql
		 pageBean=userService.listByPage(currentPage);
		
		 
		 request.setAttribute("pageBean", pageBean);
		 request.getRequestDispatcher("/superAdmin/adminOperator.jsp").forward(request,response);
	}

}
