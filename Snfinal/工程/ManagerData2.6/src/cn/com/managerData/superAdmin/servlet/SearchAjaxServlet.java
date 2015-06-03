package cn.com.managerData.superAdmin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.manager.model.PageBean;
import cn.com.managerData.service.UserService;

import com.google.gson.Gson;

public class SearchAjaxServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1261770509348004779L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService userService = new UserService();
		PageBean pageBean = new PageBean();

		/*System.out.println("------22222");
		String creatTime = request.getParameter("creatTime")
				.replaceAll("'", "");
		System.out.println("------333");
		String user = request.getParameter("user").replaceAll("'", "");
		System.out.println("------22333");
		String realName = request.getParameter("realName").replaceAll("'", "");
		System.out.println("------2222333");
		String sex = request.getParameter("sex").replaceAll("'", "");
		String email = request.getParameter("email");
		String tele = request.getParameter("tele").replaceAll("'", "");
		String currentPage = "";
		System.out.println("------333");*/
		 

		String creatTime = request.getParameter("creatTime");
System.out.println(creatTime);
		String user = request.getParameter("user");
		System.out.println("------22333");
		String realName = request.getParameter("realName");
		System.out.println("------2222333");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String tele = request.getParameter("tele");
		String currentPage = "";
		if (request.getParameter("textfield") == null
				|| request.getParameter("textfield") == "") {
			currentPage = Integer.toString(pageBean.getCurrentPage());
			System.out.println("------22222");
		} else {
			currentPage = request.getParameter("textfield");
			System.out.println(currentPage);
		}

		// AJAX实现查询是否已经存在的验证 list 参数user realName sex email tele

		pageBean = userService.listByPage(currentPage, user, realName, sex,
				email, tele, creatTime);

		/*
		 * System.out.println("------111");
		 * 
		 * String json = new JSONSerializer() .include("list")
		 * .serialize(pageBean);
		 */

		System.out.println("------111");

		/* List<Map<String,Object>> list = pageBean.getList(); */
		/**/

		// 把pageBean对象序列化成json
		Gson gson = new Gson();

		String json = gson.toJson(pageBean);
		System.out.println(json);
		PrintWriter out = response.getWriter();

		out.write(json);

		out.flush();

		out.close();
	}
}
