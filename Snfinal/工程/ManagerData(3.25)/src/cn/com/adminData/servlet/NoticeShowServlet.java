package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.NoticeServiceImpl;
import cn.com.managerData.util.JdbcUtil;

public class NoticeShowServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NoticeServiceImpl notice=new NoticeServiceImpl();
		JdbcUtil jdbc = new JdbcUtil();
		PageBean pageBean = new PageBean();
		
		String sql = "select n. id,n.EXTENDEDID,n.EDITOR,n.TITLE,n.BODY,n.MAINBODY,n.PUBLISHTIME,N.UPDATETIME,N.PICTURE,N.TYPE,nt.typename from Notice n,NoticeType nt where n.type=nt.id";
		if (request.getParameter("currentPage") != null) {
			// 从 信息页跳过来
			String currentPage = request.getParameter("currentPage");
			pageBean.setCurrentPage(Integer.parseInt(currentPage));
			// 查询所有用户信息 list 参数sql
			pageBean.setSql(sql);
			int count = jdbc.getCount(sql);
			pageBean.setTotal(count);
			pageBean.setTotalPage(count);
			pageBean = notice.showOther(pageBean);

		} else {
			// 登陆页跳出来

			pageBean = notice.showAll(sql);
		}
System.out.println("-------------1-------------------");	



		// 直接显示,不是查询
		int num = 1;
		request.setAttribute("num", num);

		request.setAttribute("notice", pageBean);
		request.getRequestDispatcher("/jsp/ordAdmin/notice/notice.jsp").forward(request, response);
	
	}

}
