package cn.com.adminData.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SellingGoodsBean;
import cn.com.adminData.model.SoilBean;
import cn.com.adminData.service.SoilServiceImpl;
import cn.com.managerData.util.UploadFileUtil;

public class SoilAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SoilServiceImpl soil=new SoilServiceImpl();
		SoilBean soilM=new SoilBean();
		HttpSession session = request.getSession();

		soilM.setExtendedid(Integer.parseInt(request.getParameter("EXTENDEDID")));
		soilM.setTitle(request.getParameter("TITLE"));
		soilM.setProduct_message(request.getParameter("PRODUCTMESSAGE"));
		soilM.setTrade_location(request.getParameter("TRADELOCATION"));
		soilM.setPublic_time(request.getParameter("PUBLISHTIME"));
		soilM.setUpdate_time(request.getParameter("UPDATETIME"));
		soilM.setSaler_id(Integer.parseInt(request.getParameter("SALERID")));
		soilM.setSaler_name(request.getParameter("SALERNAME"));
		soilM.setContact_method(request.getParameter("CONTACTMETHOD"));
		soilM.setValid_date(request.getParameter("VALIDDATE"));
		soilM.setIsvalid(request.getParameter("ISVALID"));
		
		boolean result = soil.addSoil(soilM, session);
		if (result) {
			//��ӳɹ�
			
		//��ȡ��ӳɹ����id
		String id = soil.selectId(soilM.getTitle(), soilM.getProduct_message());
		//���ݲ�ѯ����id,��ȡ��id��Ӧ��ȫ������Ϣ,�Զ�����ʽ�洢
		SoilBean selling = soil.selectOne(id);
		//��ֵ,��ת�� Ԥ������
		request.setAttribute("soil", selling);
		request.getRequestDispatcher("/jsp/ordAdmin/soil/viewSoil.jsp").forward(request, response);
		} else {

			//���ʧ��
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}

	}

