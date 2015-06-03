package cn.com.adminData.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.model.YellowPageBean;
import cn.com.adminData.service.YellowServiceImpl;
import cn.com.managerData.util.UploadFileUtil;

public class YellowAddServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		YellowServiceImpl yellow1=new YellowServiceImpl();
		YellowPageBean yellowM1=new YellowPageBean();
		HttpSession session = request.getSession();
		
		//接收多种类型的表单
		Map<String, String> map = UploadFileUtil.fileUpload(request);
		
		yellowM1.setPicture(map.get("fileName"));
		yellowM1.setExtendedId(Integer.parseInt(map.get("biaoshiID")));
		yellowM1.setInstitution_Name(map.get("jigouming"));	
		yellowM1.setContactMethod(map.get("lianxifangshi"));
		yellowM1.setLocation(map.get("jigoudizhi"));
		
		boolean result = yellow1.addYellow(yellowM1, session);
		if (result) {
			//添加成功
			
		//获取添加成功后的id
		String id = yellow1.selectId(yellowM1.getInstitution_Name(), yellowM1.getContactMethod());
		//根据查询到的id,获取该id对应的全部的信息,以对象形式存储
		YellowPageBean yellowM = yellow1.selectOne(id);
		
		//传值,跳转到 预览界面
		request.setAttribute("yellow", yellowM);
		request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/viewYellowPage.jsp").forward(request, response);
		} else {

			//添加失败
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
		//request.getRequestDispatcher("/jsp/ordAdmin/yellowPage/addSucc.jsp").forward(request, response);
	}

}
