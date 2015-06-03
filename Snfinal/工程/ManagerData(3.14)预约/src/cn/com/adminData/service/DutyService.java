package cn.com.adminData.service;

import java.util.List;
import java.util.Map;

public class DutyService {
	public interface Duty{
		List<Map<String, Object>> searchOne(String year,String month,String day);
		
	}
}
