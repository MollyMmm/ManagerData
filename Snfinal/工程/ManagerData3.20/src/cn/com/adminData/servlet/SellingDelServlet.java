package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SellingGoodsBean;
import cn.com.adminData.service.SellingGoodsServiceImpl;

public class SellingDelServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		SellingGoodsServiceImpl selling=new SellingGoodsServiceImpl();
		SellingGoodsBean sellingM=new SellingGoodsBean();
		HttpSession session = request.getSession();
		
		sellingM.setId(Integer.parseInt(request.getParameter("ID")));
		boolean bool=selling.deleteSellingGoods(sellingM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=sellingDel").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del").forward(request, response);
		}
	}

}
