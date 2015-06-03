package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SoilMessageBean;
import cn.com.adminData.service.SoilMessageServiceImpl;

public class SoilMessageAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SoilMessageServiceImpl consult = new SoilMessageServiceImpl();
		SoilMessageBean consultM = new SoilMessageBean();
		HttpSession session = request.getSession();
		consultM.setId(Integer.parseInt(request.getParameter("id")));
		consultM.setExtendedId(Integer.parseInt(request.getParameter("extendedid")));
		consultM.setType(request.getParameter("type"));
		consultM.setPicture(request.getParameter("picture"));
		consultM.setPrice((Integer.parseInt(request.getParameter("price"))));
		consultM.setConversionProperty(request.getParameter("conversionproperty"));
		consultM.setSoilArea(request.getParameter("soilarea"));
		consultM.setNegotiableYear(request.getParameter("negotiableyear"));
		consultM.setSurplusYear(request.getParameter("surplusyear"));
		consultM.setLandWarrants(request.getParameter("landwarrants"));
		consultM.setSoilUsing(request.getParameter("soilusing"));
		consultM.setType(request.getParameter("type"));
		consult.addSoilMessage(consultM, session);
		request.getRequestDispatcher("/jsp/ordAdmin/soilMessage/addSucc.jsp").forward(request, response);
		
	}

}
