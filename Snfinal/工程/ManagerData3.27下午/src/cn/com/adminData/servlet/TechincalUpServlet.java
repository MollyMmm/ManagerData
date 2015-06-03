package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.TechnicalBean;
import cn.com.adminData.service.TechnicalServiceImpl;



public class TechincalUpServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TechnicalServiceImpl Techincal=new TechnicalServiceImpl();
		TechnicalBean TechnicalN=new TechnicalBean();
		
		HttpSession session = request.getSession();
		TechnicalN.setId(Integer.parseInt(request.getParameter("Id")));
		TechnicalN.setExtendedid((Integer.parseInt(request.getParameter("ExtendedId"))));
		TechnicalN.setTitle(request.getParameter("Title"));
		TechnicalN.setBody(request.getParameter("Body"));
		TechnicalN.setName(request.getParameter("Name"));
		TechnicalN.setType(request.getParameter("Type"));
		TechnicalN.setPublishtime(request.getParameter("PublishTime"));
		
		boolean update=Techincal.updateTechnical(TechnicalN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=technicalAdd").forward(request, response);
	
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del").forward(request, response);
		}
	}
}