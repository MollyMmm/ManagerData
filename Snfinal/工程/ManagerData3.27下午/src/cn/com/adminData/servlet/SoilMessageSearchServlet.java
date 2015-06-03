package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.SoilMessageServiceImpl;

public class SoilMessageSearchServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			SoilMessageServiceImpl SoilMessage=new SoilMessageServiceImpl();
      	String EXTENDEDID = request.getParameter("leixing1")==""||request.getParameter("leixing1")==null?"":" and EXTENDEDID like '%"+request.getParameter("leixing1")+"%'";
         String NAME = request.getParameter("leixing2")==""||request.getParameter("leixing2")==null?"":" and NAMES like '%"+request.getParameter("leixing2")+"%'";
         String TYPE = request.getParameter("leixing3")==""||request.getParameter("leixing3")==null?"":" and TYPE like '%"+request.getParameter("leixing3")+"%'";
 System.out.println(request.getParameter("leixing3"));     
       PageBean pagebean =  SoilMessage.select(EXTENDEDID, NAME, TYPE);
       request.setAttribute("soilMessage", pagebean);
    // Ìõ¼þ»ØÏÔ
   	
		request.setAttribute("leixing1", request.getParameter("leixing1"));
		request.setAttribute("leixing2", request.getParameter("leixing2"));
		request.setAttribute("leixing3", request.getParameter("leixing3"));
       request.getRequestDispatcher("/jsp/ordAdmin/soilMessage/soilMessage.jsp").forward(request, response);
		
	}

}
