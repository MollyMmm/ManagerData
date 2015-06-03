package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PostMessageBean;
import cn.com.adminData.service.PostMessageServiceImpl;

public class PostMessageSelOneServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		PostMessageServiceImpl consult = new PostMessageServiceImpl();
			
		String id = request.getParameter("id");
		//根据传递过来的ID获取一个对象
		PostMessageBean consultM = consult.selectOne(id);
		//跳转并传值
		System.out.print("-----------selone--------");
		request.setAttribute("consultM", consultM);
		request.getRequestDispatcher("/jsp/ordAdmin/postMessage/updateMessage.jsp").forward(request, response);
		
	}

}
