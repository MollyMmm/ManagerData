package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.NewsBean;
import cn.com.adminData.service.NewsServiceImpl;

public class NewsAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NewsServiceImpl newsS=new NewsServiceImpl();
		NewsBean newsM=new NewsBean();
		HttpSession session = request.getSession();
		
		newsM.setExtendedId(Integer.parseInt(request.getParameter("extendedId")));
		newsM.setTitle(request.getParameter("title"));
		newsM.setBody(request.getParameter("body"));
		newsM.setMainBody(request.getParameter("mainBody"));
		
		boolean result = newsS.addnews(newsM, session);
		if (result) {
			//添加成功
			
		//获取添加成功后的id
		String id = newsS.selectId(newsM.getTitle(), newsM.getBody());
		//根据查询到的id,获取该id对应的全部的信息,以对象形式存储
		NewsBean news = newsS.selectOne(id);
		//传值,跳转到 预览界面
		request.setAttribute("news", news);
		request.getRequestDispatcher("/jsp/ordAdmin/news/viewNews.jsp").forward(request, response);
		} else {

			//添加失败
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}
}