package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PublicityBean;
import cn.com.adminData.service.PublicityServiceImpl;
import cn.com.adminData.service.GoodsMessageService.GoodsMessage;

public class PublicityUpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PublicityServiceImpl Publicity=new PublicityServiceImpl();
		PublicityBean PublicityN=new PublicityBean();
		HttpSession session = request.getSession();
		PublicityN.setID(Integer.parseInt(request.getParameter("Id")));
		
		PublicityN.setTitle(request.getParameter("Title"));
		PublicityN.setBodys(request.getParameter("Bodys"));
		PublicityN.setType(request.getParameter("Type"));
		PublicityN.setStart_time(request.getParameter("Start_time"));
		PublicityN.setUpdate_time(request.getParameter("Update_time"));
		PublicityN.setProcess((Integer.parseInt(request.getParameter("Process"))));
		PublicityN.setName(request.getParameter("Name"));
		PublicityN.setID_item(request.getParameter("ID_item"));
		
		boolean update=Publicity.updatePublicity(PublicityN, session);
		if(update){
			//添加成功
			request.getRequestDispatcher("/jsp/ordAdmin/publicity/updateSucc.jsp").forward(request, response);
	
		}else{
			//添加失败
			request.getRequestDispatcher("/jsp/ordAdmin/publicity/updateFail.jsp").forward(request, response);

		}
	}

}
