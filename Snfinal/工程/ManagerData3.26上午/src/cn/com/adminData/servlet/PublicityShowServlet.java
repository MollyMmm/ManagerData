package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.PublicityServiceImpl;

import cn.com.managerData.util.JdbcUtil;

public class PublicityShowServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		PublicityServiceImpl Publicity = new PublicityServiceImpl();
		JdbcUtil jdbc = new JdbcUtil();
		PageBean pageBean = new PageBean();
			String sql = "select * from Publicity";
			if (request.getParameter("currentPage") != null) {
				// 从 信息页跳过来
				String currentPage = request.getParameter("currentPage");
				pageBean.setCurrentPage(Integer.parseInt(currentPage));
				// 查询所有用户信息 list 参数sql
				pageBean.setSql(sql);
				int count = jdbc.getCount(sql);
				pageBean.setTotal(count);
				pageBean.setTotalPage(count);
				pageBean = Publicity.showOther(pageBean);

			} else {
				// 登陆页跳出来

				pageBean = Publicity.showAll(sql);
			}
	System.out.println("-------------1-------------------");		
			request.setAttribute("Publicity", pageBean);
			request.getRequestDispatcher("/jsp/ordAdmin/publicity/publicity.jsp").forward(request, response);
	}

}
