package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PrivateConsultBean;
import cn.com.adminData.service.PrivateConsultServiceImpl;

public class PrivateConsultAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrivateConsultServiceImpl consult = new PrivateConsultServiceImpl();
		PrivateConsultBean consultM = new PrivateConsultBean();
		HttpSession session = request.getSession();
		
		consultM.setExtendedId(Integer.parseInt(request.getParameter("extendedid")));
		consultM.setUserId(Integer.parseInt(request.getParameter("userid")));
		consultM.setConsulting_Body(request.getParameter("neirong"));
		consultM.setConsulting_Time(request.getParameter("time"));
		consultM.setDeadline(request.getParameter("qixian"));
		consultM.setConsulting_Type(request.getParameter("leixing"));
		consultM.setReply_Body((request.getParameter("huifuneirong")));
		consultM.setReply_Time((request.getParameter("huifu")));
		consult.addPrivateConsult(consultM, session);
		request.getRequestDispatcher("/jsp/ordAdmin/privateConsult/addSucc.jsp").forward(request, response);
		

	}

}
