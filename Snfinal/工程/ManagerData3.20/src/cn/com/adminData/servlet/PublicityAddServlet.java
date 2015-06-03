package cn.com.adminData.servlet;

import java.io.IOException;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PublicityBean;
import cn.com.adminData.model.TechnicalBean;
import cn.com.adminData.service.PublicityServiceImpl;

public class PublicityAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PublicityServiceImpl Publicity1=new PublicityServiceImpl();
		PublicityBean PublicityM1=new PublicityBean();
		HttpSession session = request.getSession();

		PublicityM1.setTitle(request.getParameter("timu"));
		PublicityM1.setBodys(request.getParameter("neirong"));
		PublicityM1.setType(request.getParameter("leixing"));
		//PublicityM1.setStart_time(request.getParameter("fabushijian"));
		//PublicityM1.setUpdate_time(request.getParameter("gengxinshijian"));
		PublicityM1.setProcess(Integer.parseInt(request.getParameter("guocheng")));
		PublicityM1.setName(request.getParameter("mingzi"));
		PublicityM1.setID_item(request.getParameter("IDitem"));
		
		boolean result = Publicity1.addPublicity(PublicityM1, session);
	//	request.getRequestDispatcher("/jsp/ordAdmin/publicity/addSucc.jsp").forward(request, response);
		if (result) {
			//添加成功
			
		//获取添加成功后的id
		String id = Publicity1.selectId(PublicityM1.getTitle(), PublicityM1.getBodys());
		//根据查询到的id,获取该id对应的全部的信息,以对象形式存储
		PublicityBean Publicity = Publicity1.selectOne(id);
		//传值,跳转到 预览界面
		request.setAttribute("Publicity", Publicity);
		request.getRequestDispatcher("/jsp/ordAdmin/publicity/viewPublicity.jsp").forward(request, response);
		} else {

			//添加失败
			
			 response.sendRedirect(request.getContextPath()+"/jsp/ordAdmin/error.jsp?message=del");
		}
	}

}
