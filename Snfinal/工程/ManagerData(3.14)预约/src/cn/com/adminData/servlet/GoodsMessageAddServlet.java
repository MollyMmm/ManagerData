package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.GoodsMessageBean;
import cn.com.adminData.service.GoodsMessageServiceImpl;

public class GoodsMessageAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		GoodsMessageServiceImpl GoodsMessage1=new GoodsMessageServiceImpl();
		GoodsMessageBean GoodsMessageM1=new GoodsMessageBean();
		HttpSession session = request.getSession();
		
		GoodsMessageM1.setExtendedId(Integer.parseInt(request.getParameter("biaoshiID")));
		GoodsMessageM1.setName(request.getParameter("shangpinming"));
		GoodsMessageM1.setPicture(request.getParameter("tupian"));
		GoodsMessageM1.setPrice(Integer.parseInt(request.getParameter("jiage")));
		GoodsMessageM1.setPrePrice(Integer.parseInt(request.getParameter("yuanjiage")));
		GoodsMessageM1.setIntroduction(request.getParameter("shangpinmiaoshu"));
		GoodsMessage1.addGoodsMessage(GoodsMessageM1, session);
		request.getRequestDispatcher("/jsp/ordAdmin/goodsMessage/addSucc.jsp").forward(request, response);
	}

}
