package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PloughBean;
import cn.com.adminData.service.PloughServiceImpl;

public class PloughAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PloughServiceImpl Plough1=new PloughServiceImpl();
		PloughBean PloughM1=new PloughBean();
		HttpSession session = request.getSession();
		
		PloughM1.setExtendedId(Integer.parseInt(request.getParameter("biaoshiID")));
		PloughM1.setSoilTexture(request.getParameter("tuzhi"));
		PloughM1.setSoilCondition(request.getParameter("diqingmiaoshu"));
		PloughM1.setVestigital(request.getParameter("yaosucanliu"));
		PloughM1.setLocation(request.getParameter("weizhi"));
		Plough1.addPlough(PloughM1, session);
		request.getRequestDispatcher("/jsp/ordAdmin/plough/addSucc.jsp").forward(request, response);
	}

}
