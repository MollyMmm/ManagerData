package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.FarmingBean;
import cn.com.adminData.service.FarmingServiceImpl;

public class FarmingAddServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FarmingServiceImpl farmingS=new FarmingServiceImpl();
		FarmingBean farmingM=new FarmingBean();
		HttpSession session = request.getSession();
		
		farmingM.setBody(request.getParameter("body"));
		
		boolean result = farmingS.addFarming(farmingM, session);
		if (result) {
			//��ӳɹ�
			
		//��ȡ��ӳɹ����id
		String id = farmingS.selectId(farmingM.getBody());
		//���ݲ�ѯ����id,��ȡ��id��Ӧ��ȫ������Ϣ,�Զ�����ʽ�洢
		FarmingBean farming = farmingS.selectOne(id);
		//��ֵ,��ת�� Ԥ������
		request.setAttribute("farming", farming);
		request.getRequestDispatcher("/jsp/ordAdmin/farming/viewFarming.jsp").forward(request, response);
		} else {

			//���ʧ��
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}

}