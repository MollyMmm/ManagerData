package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.PrivateConsultBean;

public interface PrivateConsultService {
	PageBean showAll(String sql);
	PageBean showOther(PageBean pageBean) ;
	Boolean addPrivateConsult(PrivateConsultBean consult,HttpSession session);//�������
	Boolean deletePrivateConsult(PrivateConsultBean consult,HttpSession session);//ɾ������
	Boolean updatePrivateConsult(PrivateConsultBean consult,HttpSession session);//�����ڲ�ѯһ������֮���ã��������ݲ���
	PrivateConsultBean selectOne(String id);//�����������ã���ѯһ�����ݳ�����ʾ�����޸�����
	PageBean select(String con1,String con2,String con3 );//��������������ѯ
}
