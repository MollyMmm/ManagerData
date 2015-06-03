package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.PostMessageBean;
import cn.com.managerData.util.JdbcUtil;

public class PostMessageServiceImpl implements PostMessageService{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	public Boolean addPostMessage(PostMessageBean postmessage,
			HttpSession session) {
		//-------�����漰�ϴ�ͼƬ����û����
		String ExtendedId = String.valueOf(postmessage.getExtendedId());
		String UserId = String.valueOf(postmessage.getUserId());
		String Title = postmessage.getTitle();
		String Bodys = postmessage.getBodys();
		String SentTime = postmessage.getSentTime();

		String sql = "insert into PostMessage(id,ExtendedId,UserId,Title,Bodys,SentTime) values(SoilMessage_seq.nextval,"+ExtendedId+",'"+UserId+"','"+Title+"','"+Bodys+"','"+SentTime+"')";
		int operate = 1;
		return dao.update(sql,operate, session);
	}
	public Boolean deleteSoilMessage(PostMessageBean postmessage,
			HttpSession session) {
		int id = postmessage.getId();
		String sql = "delete from PostMessage where id="+String.valueOf(id);	
		int operate = 2;
		return dao.update(sql,operate,session);
	}
	public PostMessageBean selectOne(String id) {
		PostMessageBean consultM = new PostMessageBean();
		String sql = "select * from PostMessage where id="+id;
		//ͨ��id��ѯ����
		List<Map<String,Object>> list = dao.showOne(sql);
		//���һ�������map
		Map<String,Object> consult = list.get(0);//map�����еĵ�һ������
		//��ֵ��ʼ������consultM
		
		consultM.setSentTime(String.valueOf(consult.get("SENTTIME"))); 
		consultM.setExtendedId(Integer.parseInt(String.valueOf(consult.get("EXTENDEDID"))));
		consultM.setId(Integer.parseInt(String.valueOf(consult.get("ID"))));
		consultM.setBodys(String.valueOf(consult.get("BODYS")));
		consultM.setTitle(String.valueOf(consult.get("TITLE")));
		consultM.setUserId(Integer.parseInt(String.valueOf(consult.get("USERID"))));//��ֵ����������consultM
		return consultM;
	}
	public PageBean showAll(String sql) {
	return dao.showAll(sql);
	}
	public Boolean updateSoilMessage(PostMessageBean postmessage,
			HttpSession session) {
		String UserId =  String.valueOf(postmessage.getUserId());
		String ExtendedId = String.valueOf(postmessage.getExtendedId());
		int id = postmessage.getId();
		String Title = postmessage.getTitle();
		String Bodys = postmessage.getBodys();
		String SentTime = postmessage.getSentTime();
		//ƴ���ַ���
		String sql = "update SoilMessage set UserID="+UserId+",ExtendedId="+ExtendedId+",Title='"+Title+"',Bodys='"+Bodys+"',SentTime='"+SentTime+"' where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operate = 3;//1.��2.ɾ3.��
		return dao.update(sql,operate, session);//ִ��sql���
	}
	public PageBean select(String con1, String con2, String con3) {
		String sql = "select * from PostMessage where 1=1"+con1+con2+con3;
		System.out.println("------"+sql);
				//ͨ��id��ѯ����  
				return dao.showAll(sql);
	}
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}
	
}
