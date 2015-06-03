package cn.com.adminData.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SoilMessageBean;
import cn.com.adminData.service.SoilMessageServiceImpl;
import cn.com.managerData.util.UploadFileUtil;

public class SoilMessageAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SoilMessageServiceImpl consult = new SoilMessageServiceImpl();
		SoilMessageBean consultM = new SoilMessageBean();
		HttpSession session = request.getSession();
		
		Map<String, String> map = UploadFileUtil.fileUpload(request);
		
		//consultM.setId(Integer.parseInt(map.get("id")));
		consultM.setExtendedId(Integer.parseInt(map.get("extendedid")));
		consultM.setNames(map.get("names"));
		consultM.setPicture(map.get("fileName"));
		consultM.setPrice((Integer.parseInt(map.get("price"))));
		consultM.setConversionProperty(map.get("conversionproperty"));
		consultM.setSoilArea(map.get("soilarea"));
		consultM.setNegotiableYear(map.get("negotiableyear"));
		consultM.setSurplusYear(map.get("surplusyear"));
		consultM.setLandWarrants(map.get("landwarrants"));
		consultM.setSoilUsing(map.get("soilusing"));
		consultM.setType(map.get("type"));
		consult.addSoilMessage(consultM, session);
		request.getRequestDispatcher("/jsp/ordAdmin/soilMessage/addSucc.jsp").forward(request, response);
		
	}

}
