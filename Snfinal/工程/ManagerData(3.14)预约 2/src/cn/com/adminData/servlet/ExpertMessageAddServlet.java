package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.ExpertMessageBean;
import cn.com.adminData.service.ExpertMessageServiceImpl;

public class ExpertMessageAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ExpertMessageServiceImpl consult = new ExpertMessageServiceImpl();
		ExpertMessageBean consultM = new ExpertMessageBean();
		HttpSession session = request.getSession();
		consultM.setId(Integer.parseInt(request.getParameter("id")));
		consultM.setExtendedId(Integer.parseInt(request.getParameter("extendedid")));
		consultM.setNames(request.getParameter("names"));
		consultM.setHead_Portrait(request.getParameter("headportrait"));
		consultM.setBirth(request.getParameter("birth"));
		consultM.setMajor(request.getParameter("major"));
		consultM.setDutyTime(request.getParameter("dutytime"));
		consult.addExpertMessage(consultM, session);
		request.getRequestDispatcher("/jsp/ordAdmin/expertMessage/addSucc.jsp").forward(request, response);
	}
}
