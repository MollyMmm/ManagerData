package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class FeedBackTypeService {
	public interface FeedBackType{
		public List<Map<String,Object>> allType();
		public boolean addType(String type,HttpSession session);
		public boolean delType(String id,HttpSession session);
	}
}
