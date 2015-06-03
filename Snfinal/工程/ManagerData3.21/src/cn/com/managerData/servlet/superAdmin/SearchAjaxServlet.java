package cn.com.managerData.servlet.superAdmin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.model.PageBean;
import cn.com.managerData.service.UserService;

import com.google.gson.Gson;

public class SearchAjaxServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();
		PageBean pageBean = new PageBean();
		
		String user = request.getParameter("user");
		String realName = request.getParameter("realName");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String tele = request.getParameter("tele");
		String creatTime = request.getParameter("creatTime");
		String currentPage =Integer.toString(pageBean.getCurrentPage());
		//AJAX实现查询是否已经存在的验证 list 参数user realName sex email tele

		
		pageBean=userService.listByPage(currentPage, user, realName, sex, email, tele,creatTime);
		//List<Map<String,Object>> list = pageBean.getList();
		
		Gson gson = new Gson();
		String json = gson.toJson(pageBean);
		//String json = gson.toJson(list);
	PrintWriter out = response.getWriter();
		
		out.write(json);
		
		out.flush();
		
		out.close();
	}

}