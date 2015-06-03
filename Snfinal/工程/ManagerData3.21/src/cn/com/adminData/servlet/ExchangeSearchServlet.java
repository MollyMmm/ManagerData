package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.ExchangeServiceImpl;
import cn.com.adminData.service.GoodsMessageService.GoodsMessage;

public class ExchangeSearchServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ExchangeServiceImpl Exchange = new ExchangeServiceImpl();
      	String PHONENUMBER = request.getParameter("leixing1")==""||request.getParameter("leixing1")==null?"":" and PHONENUMBER like '%"+request.getParameter("leixing1")+"%'";
      	String selected = request.getParameter("integral");
      	String U_SORCE ="";
      	if(selected.equals("integral1")){
      		U_SORCE = " and U_SORCE>=50 and U_SORCE<=200";
      	}else if(selected.equals("integral2")){
      		U_SORCE = " and U_SORCE>=201 and U_SORCE<=400";
      	}else if(selected.equals("integral3")){
      		U_SORCE = " and U_SORCE>=401 and U_SORCE<=2000";
      	}else {
      		U_SORCE = " and U_SORCE>=0 and U_SORCE<=0";}
      	
       PageBean pagebean =  Exchange.select(PHONENUMBER, U_SORCE);
       request.setAttribute("Exchange", pagebean);
    // Ìõ¼þ»ØÏÔ
   	
		request.setAttribute("leixing1", request.getParameter("leixing1"));
		request.setAttribute("integral", request.getParameter("integral"));
		
       request.getRequestDispatcher("/jsp/ordAdmin/exchange/exchange.jsp").forward(request, response);
	}

}
