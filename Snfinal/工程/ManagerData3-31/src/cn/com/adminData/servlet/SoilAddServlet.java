package cn.com.adminData.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.SellingGoodsBean;
import cn.com.adminData.model.SoilBean;
import cn.com.adminData.service.SoilServiceImpl;
import cn.com.managerData.util.UploadFileUtil;

public class SoilAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SoilServiceImpl soil=new SoilServiceImpl();
		SoilBean soilM=new SoilBean();
		HttpSession session = request.getSession();

		soilM.setExtendedid(Integer.parseInt(request.getParameter("EXTENDEDID")));
		soilM.setTitle(request.getParameter("TITLE"));
		soilM.setProduct_message(request.getParameter("PRODUCTMESSAGE"));
		soilM.setTrade_location(request.getParameter("TRADELOCATION"));
		soilM.setPublic_time(request.getParameter("PUBLISHTIME"));
		soilM.setUpdate_time(request.getParameter("UPDATETIME"));
		soilM.setSaler_id(Integer.parseInt(request.getParameter("SALERID")));
		soilM.setSaler_name(request.getParameter("SALERNAME"));
		soilM.setContact_method(request.getParameter("CONTACTMETHOD"));
		soilM.setValid_date(request.getParameter("VALIDDATE"));
		soilM.setIsvalid(request.getParameter("ISVALID"));
		
		boolean result = soil.addSoil(soilM, session);
		if (result) {
			//添加成功
			
		//获取添加成功后的id
		String id = soil.selectId(soilM.getTitle(), soilM.getProduct_message());
		//根据查询到的id,获取该id对应的全部的信息,以对象形式存储
		SoilBean selling = soil.selectOne(id);
		//传值,跳转到 预览界面
		request.setAttribute("soil", selling);
		request.getRequestDispatcher("/jsp/ordAdmin/soil/viewSoil.jsp").forward(request, response);
		} else {

			//添加失败
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}

	}

