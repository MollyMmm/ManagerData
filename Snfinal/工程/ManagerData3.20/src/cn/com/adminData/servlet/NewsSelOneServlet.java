package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.NewsBean;
import cn.com.adminData.service.NewsServiceImpl;

public class NewsSelOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsServiceImpl news=new NewsServiceImpl();
 
		String state = request.getParameter("state");
		
		String id = request.getParameter("id");		 
		NewsBean newsN = news.selectOne(id);
 
		request.setAttribute("news", newsN);
		
		if(state.equals("1")){
			//±à¼­
			request.getRequestDispatcher("/jsp/ordAdmin/news/updateNews.jsp").forward(request, response);
		}else{
			//²é¿´
			request.getRequestDispatcher("/jsp/ordAdmin/news/oneNews.jsp").forward(request, response);
		}
	}

}
