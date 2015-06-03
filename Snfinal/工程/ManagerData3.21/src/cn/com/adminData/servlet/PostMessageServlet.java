package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.PostMessageServiceImpl;
import cn.com.managerData.util.JdbcUtil;

public class PostMessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		PostMessageServiceImpl postmessage = new PostMessageServiceImpl();
		JdbcUtil jdbc = new JdbcUtil();
		PageBean pageBean = new PageBean();
		String sql = "select * from PostMessage";
		if (request.getParameter("currentPage") != null) {
			// 从 信息页跳过来
			String currentPage = request.getParameter("currentPage");
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
			// 查询所有用户信息 list 参数sql
			pageBean.setSql(sql);
			int count = jdbc.getCount(sql);
			pageBean.setTotal(count);
			pageBean.setTotalPage(count);
			pageBean = postmessage.showOther(pageBean);

		} else {
			// 登陆页跳出来

			pageBean = postmessage.showAll(sql);
		}
	
		request.setAttribute("postmessage", pageBean);
		request.getRequestDispatcher("/jsp/ordAdmin/postMessage/postMessage.jsp").forward(request, response);
	}
}