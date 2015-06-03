package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.GoodsMessageBean;
import cn.com.adminData.service.GoodsMessageServiceImpl;

public class GoodsMessageSelOneServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodsMessageServiceImpl GoodsMessage=new GoodsMessageServiceImpl();
		String id = request.getParameter("id");
		GoodsMessageBean GoodsMessageN=GoodsMessage.selectOne(id);
		request.setAttribute("GoodsMessageN", GoodsMessageN);
		request.getRequestDispatcher("/jsp/ordAdmin/goodsMessage/updateGoodsMessage.jsp").forward(request, response);
		
	}

}
