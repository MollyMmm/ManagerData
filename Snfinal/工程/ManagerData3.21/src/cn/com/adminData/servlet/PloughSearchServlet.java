package cn.com.adminData.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.GoodsMessageServiceImpl;
import cn.com.adminData.service.PloughServiceImpl;

public class PloughSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PloughServiceImpl Plough = new PloughServiceImpl();
      	String EXTENDEDID = request.getParameter("leixing1")==""||request.getParameter("leixing1")==null?"":" and EXTENDEDID like '%"+request.getParameter("leixing1")+"%'";
 System.out.println(request.getParameter("leixing1"));   
      	String SOILTEXTURE = request.getParameter("leixing2")==""||request.getParameter("leixing2")==null?"":" and SOILTEXTURE like '%"+request.getParameter("leixing2")+"%'";
System.out.println(request.getParameter("leixing2"));   
      	String SOILCONDITION = request.getParameter("leixing3")==""||request.getParameter("leixing3")==null?"":" and SOILCONDITION like '%"+request.getParameter("leixing3")+"%'";
 System.out.println(request.getParameter("leixing3"));     
       PageBean pagebean =  Plough.select(EXTENDEDID, SOILTEXTURE, SOILCONDITION);
       request.setAttribute("plough", pagebean);
    // Ìõ¼þ»ØÏÔ
   	
		request.setAttribute("leixing1", request.getParameter("leixing1"));
		request.setAttribute("leixing2", request.getParameter("leixing2"));
		request.setAttribute("leixing3", request.getParameter("leixing3"));
    
       request.getRequestDispatcher("/jsp/ordAdmin/plough/plough.jsp").forward(request, response);
		
	}

}
