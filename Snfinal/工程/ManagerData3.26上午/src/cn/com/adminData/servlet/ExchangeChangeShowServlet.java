package cn.com.adminData.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.ExchangeServiceImpl;
import cn.com.managerData.util.JdbcUtil;

public class ExchangeChangeShowServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExchangeServiceImpl Exchange=new ExchangeServiceImpl();
		JdbcUtil jdbc = new JdbcUtil();
		PageBean pageBean= new PageBean();
		String sql="select Charge.id,Charge.ExtendedID,Charge.ChargeType,Charge.Amount,Charge.AdName,Personsn.Phonenumber from Charge inner join Personsn on Charge.id=Personsn.id";

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
	

	request.setAttribute("change", pageBean);

	request.getRequestDispatcher("/jsp/ordAdmin/exchange/change.jsp").forward(request, response);

		
	}

}
