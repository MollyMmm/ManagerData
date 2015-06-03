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
			//添加成功
			
		//获取添加成功后的id
		String id = sellingS.selectId(sellingM.getTitle(), sellingM.getProduct_message());
		//根据查询到的id,获取该id对应的全部的信息,以对象形式存储
		SellingGoodsBean selling = sellingS.selectOne(id);
		//传值,跳转到 预览界面
		request.setAttribute("selling", selling);
		request.getRequestDispatcher("/jsp/ordAdmin/selling/viewSelling.jsp").forward(request, response);
		} else {

			//添加失败
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}

}
