package cn.com.managerData.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GetUserCreateTime {
private String createTime;

	public String getCreateTime() {
	return createTime;
}
	/**
	 * 获取当前时间
	 */
public void setCreateTime() {
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String createTime = sdf.format(date);
	this.createTime = createTime;
System.out.println(createTime);
}

public String getAddTime(int addDay) throws ParseException{
	Calendar dayc = new GregorianCalendar();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date = sdf.parse(this.createTime);
	dayc.setTime(date);
	dayc.add(Calendar.DATE, addDay);
	Date dtnew=dayc.getTime();
    String dateNew = sdf.format(dtnew);
    return dateNew;
}
}
