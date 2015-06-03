package cn.com.adminData.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.YellowServiceImpl;

public class YellowSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		YellowServiceImpl yellow = new YellowServiceImpl();
		String EXYENDEDID = request.getParameter("leixing1") == ""
				|| request.getParameter("leixing1") == null ? ""
				: " and EXYENDEDID like '%" + request.getParameter("leixing1")
						+ "%'";
		String INSTITUTION_NAME = request.getParameter("leixing2") == ""
				|| request.getParameter("leixing2") == null ? ""
				: " and INSTITUTION_NAME like '%"
						+ request.getParameter("leixing2") + "%'";
		String CONTACTMETHOD = request.getParameter("leixing3") == ""
				|| request.getParameter("leixing3") == null ? ""
				: " and CONTACTMETHOD like '%"
						+ request.getParameter("leixing3") + "%'";
		PageBean pagebean = yellow.select(EXYENDEDID, INSTITUTION_NAME,
				CONTACTMETHOD);
		request.setAttribute("yellowPage", pagebean);

		// Ìõ¼þ»ØÏÔ
	
		request.setAttribute("leixing1", request.getParameter("leixing1"));
		request.setAttribute("leixing2", request.getParameter("leixing2"));
		request.setAttribute("leixing3", request.getParameter("leixing3"));

		request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/yellowPage.jsp")
				.forward(request, response);

	}

}
