package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PloughBean;
import cn.com.adminData.service.PloughServiceImpl;

public class PloughSelOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PloughServiceImpl Plough=new PloughServiceImpl();
		String id = request.getParameter("id");
		PloughBean PloughN=Plough.selectOne(id);
		request.setAttribute("PloughN", PloughN);
		request.getRequestDispatcher("/jsp/ordAdmin/plough/updatePlough.jsp").forward(request, response);
		
	}

}
