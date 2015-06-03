package cn.com.managerData.servlet.superAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.service.AdminInfoSerive;

public class DeleteAdminServlet extends HttpServlet {

	 	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 		this.doPost(request, response);
		}

	 
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			
	//接收要删除的管理员的ID
			String id = request.getParameter("id");
			// 执行删除操作-----参数id
			AdminInfoSerive ais = new AdminInfoSerive();
			boolean result = ais.deleteAdmin(id);
		 
			if (result) {
				//成功删除后刷新显示
				response.sendRedirect(request.getContextPath()
						+ "/jsp/superAdmin/message.jsp?message=delete");
			} else {
				// 失败删除后刷新显示
				response.sendRedirect(request.getContextPath()
						+ "/jsp/superAdmin/error.jsp?message=delete");
			}
	 
		}

	}
