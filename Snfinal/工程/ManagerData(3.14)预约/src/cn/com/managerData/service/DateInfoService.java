package cn.com.managerData.service;


import cn.com.managerData.model.DateBean;
import cn.com.managerData.util.JdbcUtil;

public class DateInfoService {
	JdbcUtil db = new JdbcUtil();
	/**
	 * 获取date_num,通过id
	 * @param dateBean
	 * @return
	 */
public int getDateNum(DateBean dateBean){
	System.out.println("-----date---"+dateBean.getDate_id());
		String sql = "select date_num from power_date WHERE date_id=" + dateBean.getDate_id();
	System.out.println(sql);
			String date_num = db.query(sql).get(0).get("DATE_NUM").toString();
			return Integer.parseInt(date_num);
}

}
