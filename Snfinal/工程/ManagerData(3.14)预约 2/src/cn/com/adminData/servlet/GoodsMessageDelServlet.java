package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.GoodsMessageBean;
import cn.com.adminData.service.GoodsMessageServiceImpl;

public class GoodsMessageDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("admin", "admin");
		GoodsMessageServiceImpl GoodsMessage=new GoodsMessageServiceImpl();
		GoodsMessageBean GoodsMessageM=new GoodsMessageBean();
		HttpSession session = request.getSession();
		GoodsMessageM.setID(Integer.parseInt(request.getParameter("ID")));
		boolean bool=GoodsMessage.deleteGoodsMessage(GoodsMessageM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/goodsMessage/deleteSucc.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/ordAdmin/goodsMessage/deleteFail.jsp").forward(request, response);
		}
	}

}
