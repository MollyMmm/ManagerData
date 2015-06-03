package cn.com.managerData.servlet.power;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.service.PowerService;

public class PowerServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PowerService powerService = new PowerService();
		
		/*//弹窗 -权限1-权限2-。。。*id
		String power = request.getParameter("powerStr");
		String[] str = power.split("*");
		String id = str[1];
		//String[] power[0]为""
		String[] powerStr = str[0].split("-");
System.out.println(powerStr[0]+"--------------power[0]");
		List<List<Map<String, Object>>> powerAll = powerService.powerAll(powerStr, id);
		*/
		
		String role_id = request.getParameter("role_id");
System.out.println("ser -----"+role_id);
		List<List<Map<String, Object>>> power = powerService.powerStatue(role_id);
		request.setAttribute("power", power);
		//跳到查看单个权限组的权限
		request.getRequestDispatcher("/superAdmin/power/powerManeger.jsp").forward(
				request, response);
	}

}
