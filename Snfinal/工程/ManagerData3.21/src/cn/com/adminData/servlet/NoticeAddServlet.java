package cn.com.adminData.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.NoticeBean;
import cn.com.adminData.service.NoticeServiceImpl;
import cn.com.managerData.util.UploadFileUtil;


public class NoticeAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NoticeServiceImpl Notice1=new NoticeServiceImpl();
		NoticeBean NoticeM1=new NoticeBean();
		HttpSession session = request.getSession();

		//���ն������͵ı�
		Map<String, String> map = UploadFileUtil.fileUpload(request);
		
		NoticeM1.setExtendedId(Integer.parseInt(map.get("biaoshiID")));
		NoticeM1.setTitle(map.get("timu"));
		NoticeM1.setBody(map.get("neirong"));
		NoticeM1.setMainBody(map.get("genggai"));
		NoticeM1.setPublishTime(map.get("fabushijian"));
		NoticeM1.setUpdateTime(map.get("gengxinshijian"));
		NoticeM1.setPicture(map.get("fileName"));
		NoticeM1.setType(Integer.parseInt(map.get("gonggaoleixing")));
		
System.out.println(" -----------���ͼƬ4---------");	
		Notice1.addNotice(NoticeM1, session);
System.out.println(" -----------���ͼƬ5---------");	
		request.getRequestDispatcher("/jsp/ordAdmin/notice/addSucc.jsp").forward(request, response);
	
	}

}
