package cn.com.managerData.servlet.superAdmin;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.managerData.service.AdminInfoSerive;

public class UpdateAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ȡҪ�޸ĵĹ���Ա��ID
		String id = request.getParameter("id");
		// �����ݿ��в�ѯ���ù���Ա������Ϣ---list ����id
		AdminInfoSerive ais = new AdminInfoSerive();
		Map<String, Object> map = ais.selectOneAdmin(id);

		// ��ת��ʾ
		request.setAttribute("map", map);
		request.getRequestDispatcher("/jsp/superAdmin/adminUpdate.jsp").forward(
				request, response);
	}

}
