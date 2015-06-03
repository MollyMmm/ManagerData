package cn.com.managerData.superAdmin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.service.AdimnInfoSerive;


public class deleteAdminServlet extends HttpServlet {

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 5929725452078075596L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
//接收要删除的管理员的ID
		String id = request.getParameter("id");
		// 执行删除操作-----参数id
		AdimnInfoSerive ais = new AdimnInfoSerive();
		boolean result = ais.deleteAdmin(id);
	/*	String sql = "delete from admininfo where id="+id;
		jdbc.update(sql);*/
		if (result) {
			//成功删除后刷新显示
			response.sendRedirect(request.getContextPath()
					+ "/superAdmin/message.jsp?message=delete");
		} else {
			// 失败删除后刷新显示
			response.sendRedirect(request.getContextPath()
					+ "/superAdmin/error.jsp?message=delete");
		}
 
	}

}
