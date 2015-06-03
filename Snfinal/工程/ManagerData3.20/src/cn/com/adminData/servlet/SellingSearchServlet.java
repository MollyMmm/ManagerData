package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.SellingGoodsServiceImpl;

public class SellingSearchServlet extends HttpServlet {
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SellingGoodsServiceImpl selling = new SellingGoodsServiceImpl();
		System.out.println("---------------sellinggoods 1 --------");
      	String EXTENDEDID = request.getParameter("leixing1")==""||request.getParameter("leixing1")==null?"":" and EXTENDEDID like '%"+request.getParameter("leixing1")+"%'";
      	System.out.println("---------------sellinggoods 2 --------");
      	String TITLE = request.getParameter("leixing2")==""||request.getParameter("leixing2")==null?"":" and TITLE like '%"+request.getParameter("leixing2")+"%'";
        String BODY = request.getParameter("leixing3")==""||request.getParameter("leixing3")==null?"":" and PRODUCT_MESSAGE like '%"+request.getParameter("leixing3")+"%'";
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
       PageBean pagebean =  selling.select(EXTENDEDID, TITLE, BODY,currentPage);
  
       request.setAttribute("selling", pagebean);
       
		int num = 2;
		request.setAttribute("num", num);
       
    // 条件回显
		request.setAttribute("leixing1", request.getParameter("leixing1"));
		request.setAttribute("leixing2", request.getParameter("leixing2"));
		request.setAttribute("leixing3", request.getParameter("leixing3"));

       request.getRequestDispatcher("/jsp/ordAdmin/sellinggoods/selling.jsp").forward(request, response);
		
	}

}