package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.GoodsMessageBean;
import cn.com.adminData.service.GoodsMessageServiceImpl;

public class GoodsMessageUpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		GoodsMessageServiceImpl GoodsMessage=new GoodsMessageServiceImpl();
		GoodsMessageBean GoodsMessageN=new GoodsMessageBean();
		HttpSession session = request.getSession();
		GoodsMessageN.setID(Integer.parseInt(request.getParameter("Id")));
		GoodsMessageN.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		GoodsMessageN.setName(request.getParameter("Names"));
		GoodsMessageN.setPicture(request.getParameter("Picture"));
		GoodsMessageN.setAddress(request.getParameter("Address"));
		GoodsMessageN.setIntroduction(request.getParameter("Introduction"));
		boolean update=GoodsMessage.updateGoodsMessage(GoodsMessageN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/goodsMessage/updateSucc.jsp").forward(request, response);
	
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/goodsMessage/updateFail.jsp").forward(request, response);
		}
		
		
	}

}
