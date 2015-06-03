package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SoilMessageBean;
import cn.com.adminData.service.SoilMessageServiceImpl;

public class SoilMessageUpServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SoilMessageServiceImpl SoilMessage=new SoilMessageServiceImpl();
		SoilMessageBean SoilMessageN=new SoilMessageBean();
		HttpSession session = request.getSession();
		SoilMessageN.setId(Integer.parseInt(request.getParameter("Id")));
		SoilMessageN.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		SoilMessageN.setNames(request.getParameter("Name"));
		SoilMessageN.setPicture(request.getParameter("Picture"));
		SoilMessageN.setPrice((Integer.parseInt(request.getParameter("Price"))));
		SoilMessageN.setConversionProperty(request.getParameter("Conversion_Property"));
		SoilMessageN.setSoilArea(request.getParameter("SoilArea"));
		SoilMessageN.setNegotiableYear(request.getParameter("Negotiable_Year"));
		SoilMessageN.setSurplusYear(request.getParameter("SurplusYear"));
		SoilMessageN.setLandWarrants(request.getParameter("Land_Warrants"));
		SoilMessageN.setSoilUsing(request.getParameter("SoilUsing"));
		SoilMessageN.setType(request.getParameter("Type"));
		SoilMessageN.setValiddate(request.getParameter("Validdate"));
		boolean update=SoilMessage.updateSoilMessage(SoilMessageN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/soilMessage/updateSucc.jsp").forward(request, response);
	
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/soilMessage/updateFail.jsp").forward(request, response);

		}
	
	}

}
