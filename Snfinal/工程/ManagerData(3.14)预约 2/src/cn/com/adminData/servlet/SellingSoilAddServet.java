package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SellingSoilBean;
import cn.com.adminData.service.SellingSoilServiceImpl;

public class SellingSoilAddServet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SellingSoilServiceImpl consult = new SellingSoilServiceImpl();
		SellingSoilBean consultM = new SellingSoilBean();
		HttpSession session = request.getSession();
		
		consultM.setExtendedId(Integer.parseInt(request.getParameter("extendedid")));
		consultM.setTitle(request.getParameter("title"));
		consultM.setTradeLocation(request.getParameter("tradelocation"));
		consultM.setPublishTime(request.getParameter("publishtime"));
		consultM.setUpdateTime(request.getParameter("updatetime"));
		consultM.setSalerId(Integer.parseInt(request.getParameter("salerid")));
		consultM.setSalerName(request.getParameter("salername"));
		consultM.setContactMethod(request.getParameter("contactmethod"));
		consultM.setValidDate(request.getParameter("validdate"));
		consultM.setIsValid(request.getParameter("lisvalid"));
		consultM.setSoilMessage(Integer.parseInt(request.getParameter("soilmessage")));
		consult.addSellingSoil(consultM, session);
		request.getRequestDispatcher("/jsp/ordAdmin/sellingSoil/addSucc.jsp").forward(request, response);
		
	}

}
