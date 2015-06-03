package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.SellingSoilServiceImpl;
import cn.com.managerData.util.JdbcUtil;

public class SellingSoilServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SellingSoilServiceImpl sellingsoil = new SellingSoilServiceImpl();
		JdbcUtil jdbc = new JdbcUtil();
		PageBean pageBean = new PageBean();
		String sql = "select * from SellingSoil";
		if (request.getParameter("currentPage") != null) {
			// 从 信息页跳过来
			String currentPage = request.getParameter("currentPage");
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
			// 查询所有用户信息 list 参数sql
			pageBean.setSql(sql);
			int count = jdbc.getCount(sql);
			pageBean.setTotal(count);
			pageBean.setTotalPage(count);
			pageBean = sellingsoil.showOther(pageBean);

		} else {
			// 登陆页跳出来

			pageBean = sellingsoil.showAll(sql);
		}		
		request.setAttribute("sellingsoil", pageBean);
		request.getRequestDispatcher("/jsp/ordAdmin/sellingSoil/sellingSoil.jsp").forward(request, response);
	}

}
