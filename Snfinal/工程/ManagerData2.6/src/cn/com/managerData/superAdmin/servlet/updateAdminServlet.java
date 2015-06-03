package cn.com.managerData.superAdmin.servlet;

import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.service.AdimnInfoSerive;


public class updateAdminServlet extends HttpServlet {

 
	/**
	 * 
	 */
	private static final long serialVersionUID = 4921490456279243637L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
System.out.println("修改");		
 //获取要修改的管理员的ID
		String id = request.getParameter("id");
		//从数据库中查询到该管理员所有信息---list 参数id
		AdimnInfoSerive ais = new AdimnInfoSerive();
		Map<String,Object> map=ais.selectOneAdmin(id);
	
		/*String sql = "select * from admininfo where id='"+id+"'";
		Map<String,Object> map=jdbc.query(sql).get(0);*/
		//跳转显示
		 request.setAttribute("map", map);
		 request.getRequestDispatcher("/superAdmin/adminUpdate.jsp").forward(request,response);
	}

}
