package cn.com.adminData.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.NoticeServiceImpl;

public class NoticeSearchServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeServiceImpl Notice = new NoticeServiceImpl();
		
      	String EXTENDEDID = request.getParameter("leixing1")==""||request.getParameter("leixing1")==null?"":" and n.EXTENDEDID like '%"+request.getParameter("leixing1")+"%'";
        String TITLE = request.getParameter("leixing2")==""||request.getParameter("leixing2")==null?"":" and n.TITLE like '%"+request.getParameter("leixing2")+"%'";
        String BODY = request.getParameter("leixing3")==""||request.getParameter("leixing3")==null?"":" and n.BODY like '%"+request.getParameter("leixing3")+"%'";
 System.out.println(request.getParameter("leixing3"));     
 		String currentPage = "";

	if (request.getParameter("search") != null&& request.getParameter("search").equals("1")) {
		//���������ť
		currentPage = "1";
	} else {
		//�����������µ�ҳ����ת(��һҳ---)
		currentPage = request.getParameter("currentPage");
System.out.println("--------ssssssss--------"+ request.getParameter("currentPage"));
	}
       PageBean pagebean =  Notice.select(EXTENDEDID, TITLE, BODY,currentPage);
  
       request.setAttribute("notice", pagebean);
       
		int num = 2;
		request.setAttribute("num", num);
       
    // ��������
		request.setAttribute("leixing1", request.getParameter("leixing1"));
		request.setAttribute("leixing2", request.getParameter("leixing2"));
		request.setAttribute("leixing3", request.getParameter("leixing3"));

       request.getRequestDispatcher("/jsp/ordAdmin/notice/notice.jsp").forward(request, response);
		
	}

}
