package cn.com.adminData.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.GoodsMessageBean;
import cn.com.adminData.service.GoodsMessageServiceImpl;
import cn.com.managerData.util.UploadFileUtil;

public class GoodsMessageAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GoodsMessageServiceImpl GoodsMessage1=new GoodsMessageServiceImpl();
		GoodsMessageBean GoodsMessageM1=new GoodsMessageBean();
		HttpSession session = request.getSession();
		
		Map<String, String> map = UploadFileUtil.fileUpload(request);
		
		GoodsMessageM1.setExtendedId(Integer.parseInt(map.get("biaoshiID")));
		GoodsMessageM1.setName(map.get("shangpuming"));
		GoodsMessageM1.setPicture(map.get("fileName"));
		GoodsMessageM1.setIntroduction(map.get("shangpumiaoshu"));
		GoodsMessageM1.setAddress(map.get("shangpudizhi"));
		GoodsMessage1.addGoodsMessage(GoodsMessageM1, session);
		request.getRequestDispatcher("/jsp/ordAdmin/goodsMessage/addSucc.jsp").forward(request, response);
	}

}
