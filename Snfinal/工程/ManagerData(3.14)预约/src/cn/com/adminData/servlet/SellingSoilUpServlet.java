package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SellingSoilBean;
import cn.com.adminData.service.SellingSoilServiceImpl;

public class SellingSoilUpServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SellingSoilServiceImpl consult = new SellingSoilServiceImpl();
		SellingSoilBean consultM = new SellingSoilBean();
		HttpSession session = request.getSession();
		
		consultM.setId(Integer.parseInt(request.getParameter("Id")));
		consultM.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		consultM.setSalerId((Integer.parseInt(request.getParameter("SalerId"))));
		consultM.setTitle(request.getParameter("Title"));
		consultM.setTradeLocation(request.getParameter("TradeLocation"));
		consultM.setPublishTime(request.getParameter("PublishTime"));  
		consultM.setUpdateTime(request.getParameter("UpdateTime"));
		consultM.setSalerName(request.getParameter("SalerName"));
		consultM.setContactMethod(request.getParameter("ContactMethod"));
		consultM.setValidDate(request.getParameter("ValidDate"));
		consultM.setIsValid(request.getParameter("IsValid"));
		consultM.setSoilMessage((Integer.parseInt(request.getParameter("SoilMessage"))));
		
		boolean update = consult.updateSellingSoil(consultM, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/sellingSoil/updateSucc.jsp").forward(request, response);
			
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/sellingSoil/updateFail.jsp").forward(request, response);

		}
	}

}
