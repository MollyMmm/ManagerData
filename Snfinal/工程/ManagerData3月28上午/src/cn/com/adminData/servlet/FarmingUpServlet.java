package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.FarmingBean;
import cn.com.adminData.service.FarmingServiceImpl;

public class FarmingUpServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FarmingServiceImpl farming=new FarmingServiceImpl();
		FarmingBean farmingN=new FarmingBean();
		
		HttpSession session = request.getSession();
		farmingN.setId(Integer.parseInt(request.getParameter("Id")));
	
		farmingN.setBody(request.getParameter("Body"));
		farmingN.setUserid(Integer.parseInt(request.getParameter("UserId")));
		
		farmingN.setDatetime(request.getParameter("DateTime"));
		
		boolean update=farming.updateFarming(farmingN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=farmingDel").forward(request, response);
	
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del").forward(request, response);
		}
	}
}