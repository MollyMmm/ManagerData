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
		
		String EXYENDEDID = request.getParameter("leixing1") == ""|| request.getParameter("leixing1") == null ? "": " and EXYENDEDID like '%" + request.getParameter("leixing1")+ "%'";
		String INSTITUTION_NAME = request.getParameter("leixing2") == ""|| request.getParameter("leixing2") == null ? "": " and INSTITUTION_NAME like '%"+ request.getParameter("leixing2") + "%'";
		String CONTACTMETHOD = request.getParameter("leixing3") == ""|| request.getParameter("leixing3") == null ? "": " and CONTACTMETHOD like '%"+ request.getParameter("leixing3") + "%'";
		String currentPage = "";

		if (request.getParameter("search") != null&& request.getParameter("search").equals("1")) {
			//点击搜索按钮
			currentPage = "1";
		} else {
			//点击下一页等按钮
			currentPage = request.getParameter("currentPage");
System.out.println("--------ssssssss--------"+ request.getParameter("currentPage"));
		}
		
		PageBean pagebean = yellow.select(EXYENDEDID, INSTITUTION_NAME,CONTACTMETHOD,currentPage);
		request.setAttribute("yellowPage", pagebean);

		int num = 2;
		request.setAttribute("num", num);
		
		// 条件回显	
		request.setAttribute("leixing1", request.getParameter("leixing1"));
		request.setAttribute("leixing2", request.getParameter("leixing2"));
		request.setAttribute("leixing3", request.getParameter("leixing3"));

		request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/yellowPage.jsp").forward(request, response);

	}

}
