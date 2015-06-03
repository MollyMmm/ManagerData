package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PloughBean;
import cn.com.adminData.service.PloughServiceImpl;
import cn.com.adminData.service.GoodsMessageService.GoodsMessage;

public class PloughUpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PloughServiceImpl Plough=new PloughServiceImpl();
		PloughBean PloughN=new PloughBean();
		HttpSession session = request.getSession();
		PloughN.setID(Integer.parseInt(request.getParameter("Id")));
		PloughN.setExtendedId((Integer.parseInt(request.getParameter("ExtendedId"))));
		PloughN.setSoilTexture(request.getParameter("SoilTexture"));
		PloughN.setSoilCondition(request.getParameter("SoilCondition"));
		PloughN.setVestigital(request.getParameter("Vestigital"));
		
		PloughN.setLocation(request.getParameter("Location"));
		boolean update=Plough.updatePlough(PloughN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/plough/updateSucc.jsp").forward(request, response);
	
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/plough/updateFail.jsp").forward(request, response);

		}
	}

}
