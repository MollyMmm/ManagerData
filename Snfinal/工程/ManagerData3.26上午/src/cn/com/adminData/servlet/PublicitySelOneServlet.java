package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PublicityBean;
import cn.com.adminData.service.PublicityServiceImpl;

public class PublicitySelOneServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PublicityServiceImpl Publicity=new PublicityServiceImpl();
		String id = request.getParameter("id");
		PublicityBean PublicityN=Publicity.selectOne(id);
		request.setAttribute("PublicityN", PublicityN);
		request.getRequestDispatcher("/jsp/ordAdmin/publicity/updatePublicity.jsp").forward(request, response);
		

	}

}
