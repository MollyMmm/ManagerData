package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.ExpertMessageBean;
import cn.com.adminData.model.TechnicalBean;
import cn.com.adminData.service.ExpertMessageServiceImpl;

public class ExpertMessageAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ExpertMessageServiceImpl consult = new ExpertMessageServiceImpl();
		ExpertMessageBean consultM = new ExpertMessageBean();
		HttpSession session = request.getSession();
		
		//consultM.setId(Integer.parseInt(request.getParameter("id")));
		consultM.setExtendedId(Integer.parseInt(request.getParameter("extendedid")));
		consultM.setNames(request.getParameter("names"));
		consultM.setHead_Portrait(request.getParameter("headportrait"));
		consultM.setBirth(request.getParameter("birth"));
		consultM.setMajor(request.getParameter("major"));
		consultM.setDutyTime(request.getParameter("dutytime"));
		consultM.setInfo(request.getParameter("info"));
		
		boolean result = consult.addExpertMessage(consultM, session);
		
	//	request.getRequestDispatcher("/jsp/ordAdmin/expertMessage/addSucc.jsp").forward(request, response);
		if (result) {
			//添加成功
			
		//获取添加成功后的id
		String id = consult.selectId(consultM.getNames(), consultM.getInfo());
		//根据查询到的id,获取该id对应的全部的信息,以对象形式存储
		ExpertMessageBean expertMessage = consult.selectOne(id);
		//传值,跳转到 预览界面
		request.setAttribute("expertMessage", expertMessage);
		request.getRequestDispatcher("/jsp/ordAdmin/expertMessage/viewMessage.jsp").forward(request, response);
		} else {

			//添加失败
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}

	
	}
