package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SoilBean;
import cn.com.adminData.service.SoilServiceImpl;

public class SoilUpServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SoilServiceImpl selling=new SoilServiceImpl();
		SoilBean sellingM=new SoilBean();
		
		HttpSession session = request.getSession();
		
		sellingM.setId(Integer.parseInt(request.getParameter("ID")));
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
		
		boolean update=selling.updateSoil(sellingM, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=soil").forward(request, response);
	
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del").forward(request, response);
		}
	}
}