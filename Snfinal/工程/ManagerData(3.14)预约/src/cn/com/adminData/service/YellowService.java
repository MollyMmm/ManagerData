package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.YellowPageBean;

public interface YellowService {
	PageBean showOther(PageBean pageBean) ;
	PageBean showAll(String sql);//��ʾ������Ϣ
	boolean addYellow(YellowPageBean yellow,HttpSession session);//������Ϣ
	boolean updateYellow(YellowPageBean yellow,HttpSession session);//����id��ѯ��Ϣ��Ȼ�����
	boolean deleteYellow(YellowPageBean yellow,HttpSession session);//ɾ����Ϣ
	YellowPageBean selectOne(String id);//���ݵ�һ������ѯ��Ϣ
	PageBean select(String con1,String con2,String con3);//�������Ͳ�ѯ��Ϣ��*������д*��
}
