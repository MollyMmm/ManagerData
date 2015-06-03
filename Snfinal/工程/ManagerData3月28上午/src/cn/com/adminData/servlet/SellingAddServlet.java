package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SellingGoodsBean;
import cn.com.adminData.service.SellingGoodsServiceImpl;

public class SellingAddServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SellingGoodsServiceImpl sellingS=new SellingGoodsServiceImpl();
		SellingGoodsBean sellingM=new SellingGoodsBean();
		HttpSession session = request.getSession();
		
		sellingM.setExtendedid(Integer.parseInt(request.getParameter("EXTENDEDID")));
		sellingM.setTitle(request.getParameter("TITLE"));
		sellingM.setProduct_message(request.getParameter("PRODUCT_MESSAGE"));
		sellingM.setTrade_location(request.getParameter("TRADE_LOCATION"));
		sellingM.setPublic_time(request.getParameter("PUBLISH_TIME"));
		sellingM.setUpdate_time(request.getParameter("UPDATE_TIME"));
		sellingM.setSaler_id(Integer.parseInt(request.getParameter("SALER_ID")));
		sellingM.setSaler_name(request.getParameter("SALER_NAME"));
		sellingM.setContact_method(request.getParameter("CONTACT_METHOD"));
		sellingM.setValid_date(request.getParameter("VALID_DATE"));
		sellingM.setIsvalid(request.getParameter("ISVAID"));
		
		boolean result = sellingS.addSellingGoods(sellingM, session);
		if (result) {
			//��ӳɹ�
			
		//��ȡ��ӳɹ����id
		String id = sellingS.selectId(sellingM.getTitle(), sellingM.getProduct_message());
		//���ݲ�ѯ����id,��ȡ��id��Ӧ��ȫ������Ϣ,�Զ�����ʽ�洢
		SellingGoodsBean selling = sellingS.selectOne(id);
		//��ֵ,��ת�� Ԥ������
		request.setAttribute("selling", selling);
		request.getRequestDispatcher("/jsp/ordAdmin/selling/viewSelling.jsp").forward(request, response);
		} else {

			//���ʧ��
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}

}
