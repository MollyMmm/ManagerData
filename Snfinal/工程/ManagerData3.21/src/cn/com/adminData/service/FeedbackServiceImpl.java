package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.FeedbackBean;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.FeedbackService.Feedback;
import cn.com.managerData.util.JdbcUtil;

public class FeedbackServiceImpl implements Feedback{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	public boolean addFeedback(FeedbackBean Feedback,HttpSession session) {
		int ExtendedId = Feedback.getExtendedId();
		String UserID=Feedback.getUserID();
		String Title=Feedback.getTitle();
		String Description=Feedback.getDescription();
		String Deadline=Feedback.getDeadline();
		String Require=Feedback.getRequire();
		int Type=Feedback.getType();
		String SentTime=Feedback.getSentTime();
	
		String sql="insert into Feedback (id,ExtendedId,UserID,Title,Description,Deadline,Require,Type,SentTime) values(Feedback_seq.nextval,"+ExtendedId+","+UserID+",'"+Title+"','"+Description+"','"+Deadline+"','"+Require+"',"+Type+",'"+SentTime+"')";
		int operator = 1;
		return dao.update(sql, operator, session);
	}
	public boolean deleteFeedback(FeedbackBean Feedback,HttpSession session) {
		int id = Feedback.getID();
		String sql = "delete from Feedback where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}

	public PageBean showAll(String sql) {
		return dao.showAll(sql);
	}

	public boolean updateFeedback(FeedbackBean Feedback, HttpSession session) {
		int id=Feedback.getID();
		String ExtendedId = String.valueOf(Feedback.getExtendedId());
		String UserID=Feedback.getUserID();
		String Title=Feedback.getTitle();
		String Description=Feedback.getDescription();
		String Deadline=Feedback.getDeadline();
		String Require=Feedback.getRequire();
		String Type= String.valueOf(Feedback.getType());
		String SentTime=Feedback.getSentTime();
		String sql="update Feedback set ExtendedId="+ExtendedId+",UserID='"+UserID+"',Title='"+Title+"',Description='"+Description+"',Deadline='"+Deadline+"',Require='"+Require+"',Type="+Type+",SentTime='"+SentTime+"' where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, operator, session);
	}
	public FeedbackBean selectOne(String id) {
		FeedbackBean FeedbackN=new FeedbackBean();
        String sql = "select * from Feedback where id="+id;
		List<Map<String,Object>> list = dao.showOne(sql);
		//存放一个对象的map
		Map<String,Object> GoodsMessage = list.get(0);
		FeedbackN.setID(Integer.parseInt(String.valueOf(GoodsMessage.get("ID"))));
		FeedbackN.setExtendedId(Integer.parseInt(String.valueOf(GoodsMessage.get("EXTENDEDID"))));
		FeedbackN.setUserID(String.valueOf(GoodsMessage.get("USERID")));
		FeedbackN.setTitle(String.valueOf(GoodsMessage.get("TITLE")));
		FeedbackN.setDescription(String.valueOf(GoodsMessage.get("DESCRIPTION")));
		FeedbackN.setDeadline(String.valueOf(GoodsMessage.get("DEADLINE")));
		FeedbackN.setRequire(String.valueOf(GoodsMessage.get("REQUIRE")));
		FeedbackN.setType(Integer.parseInt(String.valueOf(GoodsMessage.get("TYPE"))));
		FeedbackN.setSentTime(String.valueOf(GoodsMessage.get("SENTTIME")));
		return FeedbackN;
	}
	//根据条件查询函数
	public PageBean select(String con1, String con2, String con3) {

		String sql = "select * from Feedback where 1=1"+con1+con2+con3;
System.out.println("------"+sql);
		//通过id查询数据 
		return dao.showAll(sql);
	}
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}
	
}
