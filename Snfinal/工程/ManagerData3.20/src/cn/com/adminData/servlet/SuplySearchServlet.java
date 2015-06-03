package cn.com.adminData.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.SuplyServiceImpl;

public class SuplySearchServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SuplyServiceImpl suply = new SuplyServiceImpl();
		
      	String EXTENDEDID = request.getParameter("leixing1")==""||request.getParameter("leixing1")==null?"":" and EXTENDEDID like '%"+request.getParameter("leixing1")+"%'";
        String NAMES = request.getParameter("leixing2")==""||request.getParameter("leixing2")==null?"":" and NAMES like '%"+request.getParameter("leixing2")+"%'";
        String INTRODUCTION = request.getParameter("leixing3")==""||request.getParameter("leixing3")==null?"":" and INTRODUCTION like '%"+request.getParameter("leixing3")+"%'";
 System.out.println(request.getParameter("leixing3"));     
 		String currentPage = "";

	if (request.getParameter("search") != null&& request.getParameter("search").equals("1")) {
		//点击搜索按钮
		currentPage = "1";
	} else {
		//在搜索条件下的页面跳转(上一页---)
		currentPage = request.getParameter("currentPage");
System.out.println("--------ssssssss--------"+ request.getParameter("currentPage"));
	}
       PageBean pagebean =  suply.select(EXTENDEDID, NAMES, INTRODUCTION,currentPage);
  
       request.setAttribute("suply", pagebean);
       
		int num = 2;
		request.setAttribute("num", num);
       
    // 条件回显
		request.setAttribute("leixing1", request.getParameter("leixing1"));
		request.setAttribute("leixing2", request.getParameter("leixing2"));
		request.setAttribute("leixing3", request.getParameter("leixing3"));

       request.getRequestDispatcher("/jsp/ordAdmin/suply/suply.jsp").forward(request, response);
		
	}

}