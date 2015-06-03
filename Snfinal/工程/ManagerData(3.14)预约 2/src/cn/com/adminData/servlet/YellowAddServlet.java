package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.YellowPageBean;
import cn.com.adminData.service.YellowServiceImpl;

public class YellowAddServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		YellowServiceImpl yellow1=new YellowServiceImpl();
		YellowPageBean yellowM1=new YellowPageBean();
		HttpSession session = request.getSession();

		yellowM1.setExtendedId(Integer.parseInt(request.getParameter("biaoshiID")));
		yellowM1.setInstitution_Name(request.getParameter("jigouming"));	
		yellowM1.setContactMethod(request.getParameter("lianxifangshi"));
		yellowM1.setLocation(request.getParameter("jigoudizhi"));
		yellow1.addYellow(yellowM1, session);
		request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/addSucc.jsp").forward(request, response);
	}

}
