package cn.com.managerData.servlet.power;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.manager.model.DateBean;
import cn.com.manager.model.PowerBean;
import cn.com.manager.model.RoleBean;
import cn.com.managerData.service.PowerInfoService;
import cn.com.managerData.service.PowerService;

public class PowerUpdateServlet extends HttpServlet {

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PowerInfoService powerinfo = new PowerInfoService();
		PowerService powerService = new PowerService();
		RoleBean role = new RoleBean();
		//获取role
		role.setRole_id(Integer.parseInt(request.getParameter("role_id")));
		role.setRole_name(powerinfo.getName(role));
		
		//获取选中的权限的个数
		int count = 0;
		List<Map<String, Object>> father = powerService.selectFather();
		for(int i = 0;i<father.size();i++){
			String fatherId = String.valueOf(father.get(i).get("POWER_ID"));
			if(request.getParameterValues(fatherId)!= null){			
			String[] son = (String[])request.getParameterValues(fatherId);
			count+=son.length;
			}
		}
		
		PowerBean[] power = new PowerBean[count];
		//获取power
		int index = 0;
			for(int k = 0;k<father.size();k++){
				String fatherId = String.valueOf(father.get(k).get("POWER_ID"));
				if(request.getParameterValues(fatherId)!= null){			
					String[] son = (String[])request.getParameterValues(fatherId);
					for(int j = 0;j<son.length;j++){
						DateBean date = new DateBean();
						String sonId = son[j];
						String powerDate = request.getParameter(sonId);
						power[index] = new PowerBean();
						power[index].setPower_id(Integer.parseInt(sonId));
						date.setDate_id(Integer.parseInt(powerDate));
						power[index].setDate(date);
						index++;
					}
				}
			}
		
		
			try {
				//更新权限
				boolean result = powerService.updatePower(role, power);
				
				if (result) {
					// 更新 成功 后
					response.sendRedirect(request.getContextPath()
							+ "/superAdmin/message.jsp?message=updatePower");
				} else {
					// 更新 失败 后
					response.sendRedirect(request.getContextPath()
							+ "/superAdmin/error.jsp?message=updatePower");
				}
				
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			 
			
			
	}

}
