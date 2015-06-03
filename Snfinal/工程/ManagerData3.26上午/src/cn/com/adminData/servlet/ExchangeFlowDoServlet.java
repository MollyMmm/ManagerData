package cn.com.adminData.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.adminData.service.ExchangeServiceImpl;
import cn.com.managerData.util.JdbcUtil;

public class ExchangeFlowDoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		JdbcUtil jdbc = new JdbcUtil();
		String id = request.getParameter("id");
		// 要减少的积分
		int flow = Integer.parseInt(request.getParameter("flow"));

		// 从数据库中获取该用户原有的积分
		String sql = "select u_sorce from sorces where id=" + id;
		List<Map<String, Object>> list = jdbc.query(sql);
		String oldSorce = (String) list.get(0).get("U_SORCE");
		int newSorce = Integer.parseInt(oldSorce) - flow;
		if (newSorce >= 0) {
			String newSql = "update sorces set u_sorce=" + newSorce
					+ " where id=" + id;
			 jdbc.update(newSql);

			//流量输出数量插入的表
			ExchangeServiceImpl Exchange = new ExchangeServiceImpl();
			HttpSession session = request.getSession();
			String AdName = session.getAttribute("admin").toString();
			int Flow = Integer.parseInt(request.getParameter("flow"));
			String Amount = "";
			if (Flow == 50) {
				Amount = "10";
			} else if (Flow == 100) {
				Amount = "12";
			} else if(Flow == 200){
				Amount = "30";
			}

			boolean insert = Exchange.insertExchange(id, "a", Amount,
					AdName, session);

			if (insert) {
				request.getRequestDispatcher("ExchangeShowServlet").forward(
						request, response);
				
			
		}
		
	}
	}}


