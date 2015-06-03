package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PloughBean;
import cn.com.adminData.service.PloughServiceImpl;

public class PloughDelServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		PloughServiceImpl Plough=new PloughServiceImpl();
		PloughBean PloughM=new PloughBean();
		HttpSession session = request.getSession();
		PloughM.setID(Integer.parseInt(request.getParameter("ID")));
		boolean bool=Plough.deletePlough(PloughM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/plough/deleteSucc.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/ordAdmin/plough/deleteFail.jsp").forward(request, response);
		}
	
	}

}
