package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.NoticeServiceImpl;

public class NoticeSearchServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeServiceImpl Notice = new NoticeServiceImpl();
      	String EXTENDEDID = request.getParameter("leixing1")==""||request.getParameter("leixing1")==null?"":" and EXTENDEDID like '%"+request.getParameter("leixing1")+"%'";
         String TITLE = request.getParameter("leixing2")==""||request.getParameter("leixing2")==null?"":" and TITLE like '%"+request.getParameter("leixing2")+"%'";
         String BODY = request.getParameter("leixing3")==""||request.getParameter("leixing3")==null?"":" and BODY like '%"+request.getParameter("leixing3")+"%'";
 System.out.println(request.getParameter("leixing3"));     
       PageBean pagebean =  Notice.select(EXTENDEDID, TITLE, BODY);
       request.setAttribute("notice", pagebean);
    // Ìõ¼þ»ØÏÔ
      	
		request.setAttribute("leixing1", request.getParameter("leixing1"));
		request.setAttribute("leixing2", request.getParameter("leixing2"));
		request.setAttribute("leixing3", request.getParameter("leixing3"));
       request.getRequestDispatcher("/jsp/ordAdmin/notice/notice.jsp").forward(request, response);
		
	}

}
