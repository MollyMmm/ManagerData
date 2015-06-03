package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.YellowPageBean;
import cn.com.adminData.service.YellowServiceImpl;

public class YellowUpServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		YellowServiceImpl Yellow=new YellowServiceImpl();
		YellowPageBean YellowN=new YellowPageBean();
		HttpSession session = request.getSession();

		YellowN.setId(Integer.parseInt(request.getParameter("Id")));
		
		YellowN.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		
		YellowN.setInstitution_Name(request.getParameter("Institution_Name"));
		
		YellowN.setContactMethod(request.getParameter("ContactMethod"));
		
		YellowN.setLocation(request.getParameter("Location"));
		
		boolean update=Yellow.updateYellow(YellowN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/updateSucc.jsp").forward(request, response);
		}else
		{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/updateFail.jsp").forward(request, response);

		}
		
	}

}
