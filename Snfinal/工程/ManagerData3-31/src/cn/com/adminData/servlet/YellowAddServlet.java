package cn.com.adminData.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.model.YellowPageBean;
import cn.com.adminData.service.YellowServiceImpl;
import cn.com.managerData.util.UploadFileUtil;

public class YellowAddServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		YellowServiceImpl yellow1=new YellowServiceImpl();
		YellowPageBean yellowM1=new YellowPageBean();
		HttpSession session = request.getSession();
		
		//���ն������͵ı�
		Map<String, String> map = UploadFileUtil.fileUpload(request);
		
		yellowM1.setPicture(map.get("fileName"));
		yellowM1.setExtendedId(Integer.parseInt(map.get("biaoshiID")));
		yellowM1.setInstitution_Name(map.get("jigouming"));	
		yellowM1.setContactMethod(map.get("lianxifangshi"));
		yellowM1.setLocation(map.get("jigoudizhi"));
		
		boolean result = yellow1.addYellow(yellowM1, session);
		if (result) {
			//��ӳɹ�
			
		//��ȡ��ӳɹ����id
		String id = yellow1.selectId(yellowM1.getInstitution_Name(), yellowM1.getContactMethod());
		//���ݲ�ѯ����id,��ȡ��id��Ӧ��ȫ������Ϣ,�Զ�����ʽ�洢
		YellowPageBean yellowM = yellow1.selectOne(id);
		
		//��ֵ,��ת�� Ԥ������
		request.setAttribute("yellow", yellowM);
		request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/viewYellowPage.jsp").forward(request, response);
		} else {

			//���ʧ��
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
		//request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/addSucc.jsp").forward(request, response);
	}

}
