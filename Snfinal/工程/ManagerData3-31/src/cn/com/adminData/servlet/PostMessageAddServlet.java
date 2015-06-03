package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PostMessageBean;
import cn.com.adminData.service.PostMessageServiceImpl;

public class PostMessageAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PostMessageServiceImpl consult = new PostMessageServiceImpl();
		PostMessageBean consultM = new PostMessageBean();
		HttpSession session = request.getSession();
		consultM.setId(Integer.parseInt(request.getParameter("id")));
		consultM.setExtendedId(Integer.parseInt(request.getParameter("extendedid")));
		consultM.setUserId(Integer.parseInt(request.getParameter("userid")));
		consultM.setTitle(request.getParameter("title"));
		consultM.setBodys(request.getParameter("bodys"));
		consultM.setSentTime(request.getParameter("senttime"));
		consult.addPostMessage(consultM, session);
		request.getRequestDispatcher("/jsp/ordAdmin/postMessage/addSucc.jsp").forward(request, response);
		
	}

}
