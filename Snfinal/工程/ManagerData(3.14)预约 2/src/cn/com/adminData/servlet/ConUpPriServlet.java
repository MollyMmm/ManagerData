package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PrivateConsultBean;
import cn.com.adminData.service.PrivateConsultServiceImpl;

public class ConUpPriServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrivateConsultServiceImpl consult = new PrivateConsultServiceImpl();
		PrivateConsultBean consultM = new PrivateConsultBean();
		HttpSession session = request.getSession();
		
		consultM.setId(Integer.parseInt(request.getParameter("Id")));
		consultM.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		consultM.setUserId((Integer.parseInt(request.getParameter("UserId"))));
		consultM.setConsulting_Body(request.getParameter("Consulting_Body"));
		consultM.setConsulting_Time(request.getParameter("Consulting_Time"));
		consultM.setDeadline(request.getParameter("Deadline"));  
		consultM.setConsulting_Type(request.getParameter("Consulting_Type"));
		consultM.setReply_Body(request.getParameter("Reply_Body"));
		consultM.setReply_Time(request.getParameter("Reply_Time"));
		
		
		
		boolean update = consult.updatePrivateConsult(consultM, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/privateConsult/updateSucc.jsp").forward(request, response);
			
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/privateConsult/updateFail.jsp").forward(request, response);
		}
	}

}
