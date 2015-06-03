package cn.com.adminData.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.service.DutyServiceImpl;
import cn.com.managerData.util.GetUserCreateTime;


public class DutyShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DutyShowServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			GetUserCreateTime  nowDate = new GetUserCreateTime();
			DutyServiceImpl dutyS = new DutyServiceImpl();
			Map<String, Object> map = new HashMap<String, Object>();
			
			//获取当前时间
			nowDate.setCreateTime();
			String[] today = nowDate.getCreateTime().split("/");
			String year = String.valueOf(today[0]);
			String month = String.valueOf(today[1]);
			String day = String.valueOf(today[2]);
			int dayInt = Integer.parseInt(day);

		for (int j = dayInt; j < 32; j++) {

			List<Map<String, Object>> list = dutyS.searchOne(year, month,String.valueOf(j));
		
			if (list.size() > 0) {
				map.put(String.valueOf(j), list);
System.out.println("------------date-----------"+j);	
			}

			// for (int i = 0; i < list.size(); i++) {
			// map.put(day, list.get(i).get("E.NAME"));
			// }
		}
			
			request.setAttribute("map", map);
			request.getRequestDispatcher("/jsp/ordAdmin/duty/calendar.jsp").forward(request, response);
			
		}

}
