package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.adminData.dao.BaseDaoImpl;
import cn.com.adminData.model.FeedbackBean;
import cn.com.adminData.model.PageBean;
import cn.com.adminData.service.FeedbackService.Feedback;
import cn.com.managerData.util.GetUserCreateTime;
import cn.com.managerData.util.JdbcUtil;

public class FeedbackServiceImpl implements Feedback{
	JdbcUtil jdbc = new JdbcUtil();
	BaseDaoImpl dao = new BaseDaoImpl();
	
	/**
	 * 添加反馈类型
	 */
	public boolean addFeedback(FeedbackBean Feedback,HttpSession session) {
		GetUserCreateTime time = new GetUserCreateTime();
		
		int ExtendedId = Feedback.getExtendedId();
		String UserID=Feedback.getUserID();
		String Title=Feedback.getTitle();
		String Description=Feedback.getDescription();
		//String Deadline=Feedback.getDeadline();
		String Require=Feedback.getRequire();
		int Type=Feedback.getType();
		//获取系统时间为当前发布时间
		time.setCreateTime();
		String SentTime = time.getCreateTime();
	
		//String sql="insert into Feedback (id,ExtendedId,UserID,Title,Description,Deadline,Require,Type,SentTime) values(Feedback_seq.nextval,"+ExtendedId+","+UserID+",'"+Title+"','"+Description+"','"+Deadline+"','"+Require+"',"+Type+",'"+SentTime+"')";
		String sql="insert into Feedback (id,ExtendedId,UserID,Title,Description,Require,Type,SentTime) values(Feedback_seq.nextval,"+ExtendedId+","+UserID+",'"+Title+"','"+Description+"','"+Require+"',"+Type+",'"+SentTime+"')";
		
		int operator = 1;
		return dao.update(sql, operator, session);
	}
	
	/**
	 * 删除反馈信息
	 */
	public boolean deleteFeedback(FeedbackBean Feedback,HttpSession session) {
		int id = Feedback.getID();
		String sql = "delete from Feedback where id="+String.valueOf(id);
		int operator = 2;
		return dao.update(sql, operator, session);
	}
/**
 * 以分页形式获取全部的信息
 */
	public PageBean showAll(String sql) {
		return dao.showAll(sql);
	}
/**
 * 更新反馈信息
 */
	public boolean updateFeedback(FeedbackBean Feedback, HttpSession session) {
		int id=Feedback.getID();
		String ExtendedId = String.valueOf(Feedback.getExtendedId());
		String UserID=Feedback.getUserID();
		String Title=Feedback.getTitle();
		String Description=Feedback.getDescription();
		//String Deadline=Feedback.getDeadline();
		String Require=Feedback.getRequire();
		String Type= String.valueOf(Feedback.getType());
		//String SentTime=Feedback.getSentTime();
		//String sql="update Feedback set ExtendedId="+ExtendedId+",UserID='"+UserID+"',Title='"+Title+"',Description='"+Description+"',Deadline='"+Deadline+"',Require='"+Require+"',Type="+Type+",SentTime='"+SentTime+"' where id="+String.valueOf(id);
		String sql="update Feedback set ExtendedId="+ExtendedId+",UserID='"+UserID+"',Title='"+Title+"',Description='"+Description+"',Require='"+Require+"',Type="+Type+" where id="+String.valueOf(id);
		System.out.println("-------------"+sql);		
		int operator = 3;
		return dao.update(sql, operator, session);
	}
	/**
	 * 根据id查询一个反馈对象的信息
	 */
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
	/**
	 * 根据条件查询函数
	 */
	public PageBean select(String con1, String con2, String con3,String currentPage) {

		String sql = "select ft.TYPENAME,f.ID,f.EXTENDEDID,f.USERID,f.TITLE,f.DESCRIPTION,f.DEADLINE,f.REQUIRE,f.TYPE,f.SENTTIME from Feedback f,FEEDBACKTYPE ft where f.TYPE=ft.id"+con1+con2+con3;
System.out.println("------"+sql);
		//通过id查询数据 
		PageBean pageBean = dao.searchGoPage(sql, currentPage);
		return pageBean;
	}
	
	public PageBean showOther(PageBean pageBean) {
		return dao.showOther(pageBean);
	}
	/**
	 * 根据题目跟内容 查询 id
	 */
	public String selectId(String title,String body){
		String sql = "select id from Feedback where title='"+title+"' and description ='"+body+"'";
		
		return String.valueOf(jdbc.query(sql).get(0).get("ID"));
	}
}
