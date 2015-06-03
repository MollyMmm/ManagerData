package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.SellingGoodsBean;
import cn.com.adminData.service.SellingGoodsServiceImpl;

public class SellingSelOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SellingGoodsServiceImpl selling=new SellingGoodsServiceImpl();
 
		String state = request.getParameter("state");
		
		String id = request.getParameter("id");		 
		SellingGoodsBean sellingN = selling.selectOne(id);
 
		request.setAttribute("selling", sellingN);
		
		if(state.equals("1")){
			//±à¼­
			request.getRequestDispatcher("/jsp/ordAdmin/sellinggoods/updateSelling.jsp").forward(request, response);
		}else{
			//²é¿´
			request.getRequestDispatcher("/jsp/ordAdmin/sellinggoods/oneSelling.jsp").forward(request, response);
		}
	}

}