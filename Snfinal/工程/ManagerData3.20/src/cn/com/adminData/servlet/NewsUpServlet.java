package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.NewsBean;
import cn.com.adminData.service.NewsServiceImpl;

public class NewsUpServlet extends HttpServlet {


	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsServiceImpl news=new NewsServiceImpl();
		NewsBean newsN=new NewsBean();
		HttpSession session = request.getSession();
		
		newsN.setId(Integer.parseInt(request.getParameter("Id")));
		newsN.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		newsN.setTitle(request.getParameter("Title"));
		newsN.setBody(request.getParameter("Body"));
		newsN.setMainBody(request.getParameter("MainBody"));
		newsN.setPublic_time(request.getParameter("Publish_time"));
		newsN.setUpdate_time(request.getParameter("Update_time"));
		
		boolean update=news.updatenews(newsN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=news").forward(request, response);
	
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del").forward(request, response);
		}
	}
}