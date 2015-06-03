package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.FarmingBean;
import cn.com.adminData.service.FarmingServiceImpl;

public class FarmingAddServlet extends HttpServlet {

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		this.doPost(request, response);
	}

	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FarmingServiceImpl farmingS=new FarmingServiceImpl();
		FarmingBean farmingM=new FarmingBean();
		HttpSession session = request.getSession();
		
		farmingM.setBody(request.getParameter("body"));
		farmingM.setUserid(Integer.parseInt(request.getParameter("userid")));
		
		boolean result = farmingS.addFarming(farmingM, session);
		if (result) {
			//添加成功
			
		//获取添加成功后的id
		String id = farmingS.selectId(farmingM.getBody());
		//根据查询到的id,获取该id对应的全部的信息,以对象形式存储
		FarmingBean farming = farmingS.selectOne(id);
		//传值,跳转到 预览界面
		request.setAttribute("farming", farming);
		request.getRequestDispatcher("/jsp/ordAdmin/farming/viewFarming.jsp").forward(request, response);
		} else {

			//添加失败
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}

}