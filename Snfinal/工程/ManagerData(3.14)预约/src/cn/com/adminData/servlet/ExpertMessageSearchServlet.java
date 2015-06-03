package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.ExpertMessageServiceImpl;

public class ExpertMessageSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ExpertMessageServiceImpl ExpertMessage = new ExpertMessageServiceImpl();
      	String EXTENDEDID = request.getParameter("leixing1")==""||request.getParameter("leixing1")==null?"":" and EXTENDEDID like '%"+request.getParameter("leixing1")+"%'";
         String NAMES = request.getParameter("leixing2")==""||request.getParameter("leixing2")==null?"":" and NAMES like '%"+request.getParameter("leixing2")+"%'";
         String BIRTH = request.getParameter("leixing3")==""||request.getParameter("leixing3")==null?"":" and BIRTH like '%"+request.getParameter("leixing3")+"%'";
 System.out.println(request.getParameter("leixing3"));     
       PageBean pagebean =  ExpertMessage.select(EXTENDEDID, NAMES, BIRTH);
       request.setAttribute("expertmessage", pagebean);
    // Ìõ¼þ»ØÏÔ
      	
		request.setAttribute("leixing1", request.getParameter("leixing1"));
		request.setAttribute("leixing2", request.getParameter("leixing2"));
		request.setAttribute("leixing3", request.getParameter("leixing3"));
       request.getRequestDispatcher("/jsp/ordAdmin/expertMessage/expertMessage.jsp").forward(request, response);
	}

}
