package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.YellowPageBean;
import cn.com.adminData.service.YellowServiceImpl;

public class YellowDelServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("admin", "admin");
		YellowServiceImpl yellow=new YellowServiceImpl();
		YellowPageBean yellowM=new YellowPageBean();
		HttpSession session = request.getSession();
		yellowM.setId(Integer.parseInt(request.getParameter("ID")));
		boolean bool=yellow.deleteYellow(yellowM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/deleteSucc.jsp").forward(request, response);

		}else
		{
			request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/deleteFail.jsp").forward(request, response);
		}
		
	}

}
