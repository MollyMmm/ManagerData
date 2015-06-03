package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.SuplyBean;
import cn.com.adminData.service.SuplyServiceImpl;

public class SuplySelOneServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SuplyServiceImpl suply=new SuplyServiceImpl();
 
		String state = request.getParameter("state");
		
		String id = request.getParameter("id");		 
		SuplyBean suplyN = suply.selectOne(id);
 
		request.setAttribute("suply", suplyN);
		
		if(state.equals("1")){
			//±à¼­
			request.getRequestDispatcher("/jsp/ordAdmin/suply/updateSuply.jsp").forward(request, response);
		}else{
			//²é¿´
			request.getRequestDispatcher("/jsp/ordAdmin/suply/oneSuply.jsp").forward(request, response);
		}
	}

}