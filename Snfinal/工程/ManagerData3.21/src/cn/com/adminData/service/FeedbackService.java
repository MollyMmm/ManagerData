package cn.com.adminData.service;

import javax.servlet.http.HttpSession;

import cn.com.adminData.model.FeedbackBean;
import cn.com.adminData.model.PageBean;

public class FeedbackService {
	public interface Feedback {
		PageBean showAll(String sql);
		PageBean showOther(PageBean pageBean) ;
		boolean addFeedback(FeedbackBean Feedback,HttpSession session);
		boolean updateFeedback(FeedbackBean Feedback,HttpSession session);
		boolean deleteFeedback(FeedbackBean Feedback,HttpSession session);
		FeedbackBean selectOne(String id);
		PageBean select(String con1,String con2,String con3);
}
}
