package cn.com.adminData.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SuplyBean;
import cn.com.adminData.service.SuplyServiceImpl;
import cn.com.managerData.util.UploadFileUtil;

public class SuplyAddServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SuplyServiceImpl suply1=new SuplyServiceImpl();
		SuplyBean suplyM1=new SuplyBean();
		HttpSession session = request.getSession();

		//���ն������͵ı�
		Map<String, String> map = UploadFileUtil.fileUpload(request);
		
		suplyM1.setExtendedId(Integer.parseInt(map.get("extendedId")));
		suplyM1.setNames(map.get("names"));
		suplyM1.setPrice(map.get("price"));
		suplyM1.setPreprice(map.get("preprice"));
		suplyM1.setPicture(map.get("fileName"));
		suplyM1.setIntroduction(map.get("introduction"));
		
System.out.println(" -----------���ͼƬ4---------");	
		boolean result = suply1.addSuply(suplyM1, session);
		
System.out.println(" -----------���ͼƬ5---------");	

		if (result) {
			//��ӳɹ�
			
		//��ȡ��ӳɹ����id
		String id = suply1.selectId(suplyM1.getNames(), suplyM1.getIntroduction());
		//���ݲ�ѯ����id,��ȡ��id��Ӧ��ȫ������Ϣ,�Զ�����ʽ�洢
		SuplyBean suplyM = suply1.selectOne(id);
		//��ֵ,��ת�� Ԥ������
		request.setAttribute("suply", suplyM);
		request.getRequestDispatcher("/jsp/ordAdmin/suply/viewSuply.jsp").forward(request, response);
		} else {

			//���ʧ��
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}

}