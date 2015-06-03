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
		
		String state = request.getParameter("state");
		
		String id = request.getParameter("id");
		PublicityBean PublicityN=Publicity.selectOne(id);
		
		request.setAttribute("Publicity", PublicityN);
		
		//request.getRequestDispatcher("/jsp/ordAdmin/publicity/updatePublicity.jsp").forward(request, response);
		if(state.equals("1")){
			//±à¼­
			request.getRequestDispatcher("/jsp/ordAdmin/publicity/updatePublicity.jsp").forward(request, response);
		}else{
			//²é¿´
			request.getRequestDispatcher("/jsp/ordAdmin/publicity/onePublicity.jsp").forward(request, response);
		}

	}

}
