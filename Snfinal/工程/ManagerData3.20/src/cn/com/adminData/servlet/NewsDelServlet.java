package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.NewsBean;
import cn.com.adminData.service.NewsServiceImpl;

public class NewsDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		NewsServiceImpl news=new NewsServiceImpl();
		NewsBean newsM=new NewsBean();
		HttpSession session = request.getSession();
		
		newsM.setId(Integer.parseInt(request.getParameter("ID")));
		boolean bool=news.deletenews(newsM, session);
		if(bool){
			request.getRequestDispatcher("/jsp/ordAdmin/message.jsp?message=news").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/ordAdmin/error.jsp?message=del").forward(request, response);
		}
	}

}

