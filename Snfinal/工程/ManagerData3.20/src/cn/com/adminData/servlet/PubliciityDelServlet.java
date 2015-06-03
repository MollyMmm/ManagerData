package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PublicityBean;
import cn.com.adminData.service.PublicityServiceImpl;

public class PubliciityDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("--------2222222222--");
		
		PublicityServiceImpl Publicity=new PublicityServiceImpl();
		PublicityBean PublicityM=new PublicityBean();
		HttpSession session = request.getSession();
		PublicityM.setID(Integer.parseInt(request.getParameter("ID")));
		boolean bool=Publicity.deletePublicity(PublicityM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/publicity/deleteSucc.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/ordAdmin/publicity/deleteFail.jsp").forward(request, response);
		}
		
	}

}
