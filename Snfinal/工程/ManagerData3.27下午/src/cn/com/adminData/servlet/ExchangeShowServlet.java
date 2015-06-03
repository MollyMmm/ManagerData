package cn.com.adminData.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.ExchangeServiceImpl;
import cn.com.managerData.util.JdbcUtil;

public class ExchangeShowServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ExchangeServiceImpl Exchange=new ExchangeServiceImpl();
		JdbcUtil jdbc = new JdbcUtil();
		PageBean pageBean= new PageBean();
		String sql="select s.id,u_sorce,phonenumber from sorces s,personsn p where s.u_id=p.id ";
		List<Map<String,Object>> list = jdbc.query(sql);

	if(request.getParameter("currentPage")!=null){
		//从 信息页跳过来
		String currentPage = request.getParameter("currentPage");
		 pageBean.setCurrentPage(Integer.parseInt(currentPage));
		//查询所有用户信息 list 参数sql
			pageBean.setSql(sql);
			int count = jdbc.getCount(sql);
			pageBean.setTotal(count);
			pageBean.setTotalPage(count);
			pageBean= Exchange.showOther(pageBean);
			
	}else{
		
		//登陆页跳出来				
		 pageBean= Exchange.showAll(sql);
	}
	
	
	request.setAttribute("Exchange", pageBean);
	request.getRequestDispatcher("/jsp/ordAdmin/exchange/exchange.jsp").forward(request, response);
	}

}
