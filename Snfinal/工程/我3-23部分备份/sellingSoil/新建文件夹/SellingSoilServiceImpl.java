package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.model.SellingSoilBean;
import cn.com.managerData.util.JdbcUtil;

public class SellingSoilServiceImpl implements SellingSoilService{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	public Boolean addSellingSoil(SellingSoilBean postmessage,
			HttpSession session) {
		//-------�����漰�ϴ�ͼƬ����û����
		String ExtendedId = String.valueOf(postmessage.getExtendedId());
		String Title = postmessage.getTitle();
		String TradeLocation = postmessage.getTradeLocation();
		String PublishTime = postmessage.getPublishTime();
		String UpdateTime = postmessage.getUpdateTime();
		String SalerId =String.valueOf( postmessage.getSalerId());
		String SalerName = postmessage.getSalerName();
		String ContactMethod = postmessage.getContactMethod();
		String ValidDate = postmessage.getValidDate();
		String IsValid = postmessage.getIsValid();
		String SoilMessage = String.valueOf(postmessage.getSoilMessage());

		String sql = "insert into SellingSoil(id,ExtendedId,Title,TradeLocation,PublishTime,UpdateTime,SalerId,SalerName,ContactMethod,ValidDate,IsValid,SoilMessage) values(SoilMessage_seq.nextval,"+ExtendedId+",'"+Title+"','"+TradeLocation+"','"+PublishTime+"','"+UpdateTime+"',"+SalerId+",'"+SalerName+"','"+ContactMethod+"','"+ValidDate+"','"+IsValid+"',"+SoilMessage+")";
		int operate = 1;
System.out.println("------------1-"+sql);
		return dao.update(sql,operate, session);
	}
	
	public Boolean deleteSellingSoil(SellingSoilBean postmessage,
			HttpSession session) {
		int id = postmessage.getId();
		String sql = "delete from SellingSoil where id="+String.valueOf(id);	
		int operate = 2;
		return dao.update(sql,operate,session);
	}
	
	public PageBean showAll(String sql) {
		return dao.showAll(sql);
	}
	public Boolean updateSellingSoil(SellingSoilBean postmessage,
			HttpSession session) {
		System.out.println("-------update------");	
		int id = postmessage.getId();
		String ExtendedId = String.valueOf(postmessage.getExtendedId());
		String SalerId = String.valueOf(postmessage.getSalerId());
		String Title = postmessage.getTitle();
		String TradeLocation = postmessage.getTradeLocation();
		String PublishTime = postmessage.getPublishTime();
		String SalerName = postmessage.getSalerName();
		String ContactMethod = postmessage.getContactMethod(); 
		String ValidDate = postmessage.getValidDate();
		String IsValid = postmessage.getIsValid();
		String SoilMessage = String.valueOf(postmessage.getSoilMessage());
		//ƴ���ַ���
		String sql = "update SellingSoil set Title='"+Title+"',ExtendedId="+ExtendedId+",TradeLocation='"+TradeLocation+"',SalerId="+SalerId+",PublishTime='"+PublishTime+"',SalerName='"+SalerName+"',ContactMethod='"+ContactMethod+"',ValidDate='"+ValidDate+"',IsValid='"+IsValid+"', SoilMessage="+SoilMessage+" where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operate = 3;//1.��2.ɾ3.��
		return dao.update(sql,operate, session);//ִ��sql���
	}
	public SellingSoilBean selectOne(String id) {
		SellingSoilBean consultM = new SellingSoilBean();
		String sql = "select * from SellingSoil where id="+id;
		//ͨ��id��ѯ����
		List<Map<String,Object>> list = dao.showOne(sql);
		//���һ�������map
		Map<String,Object> consult = list.get(0);//map�����еĵ�һ������
		consultM.setTitle(String.valueOf(consult.get("TITLE")));//��ֵ��ʼ������consultM
		consultM.setTradeLocation(String.valueOf(consult.get("TRADELOCATION")));
		consultM.setPublishTime(String.valueOf(consult.get("PUBLISHTIME")));
		consultM.setUpdateTime(String.valueOf(consult.get("UPDATETIME"))); 
		consultM.setSalerName(String.valueOf(consult.get("SALERNAME"))); 
		consultM.setContactMethod(String.valueOf(consult.get("CONTACTMETHOD"))); 
		consultM.setExtendedId(Integer.parseInt(String.valueOf(consult.get("EXTENDEDID"))));
		consultM.setSalerId(Integer.parseInt(String.valueOf(consult.get("SALERID"))));
		consultM.setSoilMessage(Integer.parseInt(String.valueOf(consult.get("SOILMESSAGE"))));
		consultM.setId(Integer.parseInt(String.valueOf(consult.get("ID"))));
		consultM.setValidDate(String.valueOf(consult.get("VALIDDATE")));
		consultM.setIsValid(String.valueOf(consult.get("ISVALID")));
		System.out.print("-------IMPL------");
		//��ֵ����������consultM
		return consultM;
	}

	public PageBean select(String con1, String con2, String con3) {

		String sql = "select * from SellingSoil where 1=1"+con1+con2+con3;
System.out.println("------"+sql);
		//ͨ��id��ѯ����  EXTENDEDID CONSULTING_TIME  REPLY_BODY
		return dao.showAll(sql);
	}

	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}
}
