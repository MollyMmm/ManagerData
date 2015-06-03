package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PostMessageBean;
import cn.com.adminData.service.PostMessageServiceImpl;

public class PostMessageUpServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostMessageServiceImpl consult = new PostMessageServiceImpl();
		PostMessageBean consultM = new PostMessageBean();
		HttpSession session = request.getSession();
		
		consultM.setId(Integer.parseInt(request.getParameter("Id")));
		consultM.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		consultM.setUserId((Integer.parseInt(request.getParameter("UserId"))));
		consultM.setTitle(request.getParameter("Title"));
		consultM.setBodys(request.getParameter("Bodys"));
		consultM.setSentTime(request.getParameter("SentTime"));  
		
		
		boolean update = consult.updateSoilMessage(consultM, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/postMessage/updateSucc.jsp").forward(request, response);
			
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/postMessage/updateFail.jsp").forward(request, response);

		}
	}

}
