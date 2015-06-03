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
			//��ӳɹ�
			
		//��ȡ��ӳɹ����id
		String id = newsS.selectId(newsM.getTitle(), newsM.getBody());
		//���ݲ�ѯ����id,��ȡ��id��Ӧ��ȫ������Ϣ,�Զ�����ʽ�洢
		NewsBean news = newsS.selectOne(id);
		//��ֵ,��ת�� Ԥ������
		request.setAttribute("news", news);
		request.getRequestDispatcher("/jsp/ordAdmin/news/viewNews.jsp").forward(request, response);
		} else {

			//���ʧ��
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}
}