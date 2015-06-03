package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.FarmingBean;
import cn.com.adminData.service.FarmingServiceImpl;

public class FarmingSelOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FarmingServiceImpl farming=new FarmingServiceImpl();
 
		String state = request.getParameter("state");
		
		String id = request.getParameter("id");		 
		FarmingBean farmingN = farming.selectOne(id);
 
		request.setAttribute("farming", farmingN);
		
		if(state.equals("1")){
			//±à¼­
			request.getRequestDispatcher("/jsp/ordAdmin/farming/updateFarming.jsp").forward(request, response);
		}else{
			//²é¿´
			request.getRequestDispatcher("/jsp/ordAdmin/farming/oneFarming.jsp").forward(request, response);
		}
	}

}
