package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.model.TechnicalBean;
import cn.com.adminData.service.TechnicalServiceImpl;

public class TechnicalAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TechnicalServiceImpl technicalS=new TechnicalServiceImpl();
		TechnicalBean technicalM=new TechnicalBean();
		HttpSession session = request.getSession();
		
		technicalM.setExtendedid(Integer.parseInt(request.getParameter("extendedid")));
		technicalM.setTitle(request.getParameter("title"));
		technicalM.setBody(request.getParameter("body"));
		technicalM.setName(request.getParameter("name"));
		technicalM.setType(request.getParameter("type"));
		
		boolean result = technicalS.addTechnical(technicalM, session);
		if (result) {
			//添加成功
			
		//获取添加成功后的id
		String id = technicalS.selectId(technicalM.getTitle(), technicalM.getBody());
		//根据查询到的id,获取该id对应的全部的信息,以对象形式存储
		TechnicalBean technical = technicalS.selectOne(id);
		//传值,跳转到 预览界面
		request.setAttribute("technical", technical);
		request.getRequestDispatcher("/jsp/ordAdmin/technical/viewTechnical.jsp").forward(request, response);
		} else {

			//添加失败
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}
}
