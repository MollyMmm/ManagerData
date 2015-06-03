package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.SoilServiceImpl;
import cn.com.managerData.util.JdbcUtil;

public class SoilServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SoilServiceImpl soil = new SoilServiceImpl();
		JdbcUtil jdbc = new JdbcUtil();
		PageBean pageBean = new PageBean();
		
		String sql = "select * from sellingsoil";
		if (request.getParameter("currentPage") != null) {
			// 从 信息页跳过来
			String currentPage = request.getParameter("currentPage");
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
			// 查询所有用户信息 list 参数sql
			pageBean.setSql(sql);
			int count = jdbc.getCount(sql);
			pageBean.setTotal(count);
			pageBean.setTotalPage(count);
			pageBean = soil.showOther(pageBean);

		} else {
			// 登陆页跳出来

			pageBean = soil.showAll(sql);
		}
System.out.println("-------------1-------------------"+sql);	



		// 直接显示,不是查询
		int num = 1;
		request.setAttribute("num", num);

		request.setAttribute("soil", pageBean);
		request.getRequestDispatcher("/jsp/ordAdmin/soil/soil.jsp").forward(request, response);
		
	}

}
