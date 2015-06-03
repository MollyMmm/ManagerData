<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=Utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	Map<String, Object> map = (Map<String, Object>)request.getAttribute("map");
	String[] weeks = { "", "日", "一", "二", "三", "四", "五", "六" };

	String[] days = new String[42];

	for (int i = 0; i < 42; i++) {

		days[i] = "";

	}

	//标准日历系统的当前时间

	GregorianCalendar currentDay = new GregorianCalendar();

	//年

	int year = currentDay.get(Calendar.YEAR);

	//月，由于取值范围为0-11，实际月份需+1

	int month = currentDay.get(Calendar.MONTH);

	//日

	int today = currentDay.get(Calendar.DAY_OF_MONTH);

	//星期，取值范围为1-7，且以星期日为每周第一天的美国标准

	int weekday = currentDay.get(Calendar.DAY_OF_WEEK);

	//得到标准日历系统的当前时间输出字符串

	String now = year + "年" + (month + 1) + "月" + today + "日" + " 星期"
			+ weeks[weekday];

	//创建日历

	Calendar calendar = Calendar.getInstance();

	//月份为当前月

	calendar.set(Calendar.MONTH, month);

	//年份为当前年

	calendar.set(Calendar.YEAR, year);

	//每周第一天为星期日

	calendar.setFirstDayOfWeek(Calendar.SUNDAY);

	//该月的第一天

	calendar.set(Calendar.DAY_OF_MONTH, 1);

	//第一天的星期

	int firstIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1;

	//这个月最大天数

	int maxIndex = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

	//得到该月日数字符串

	for (int i = 0; i < maxIndex; i++) {

		//int需转换为字符串

		days[firstIndex + i] = String.valueOf(i + 1);

	}
%>
<%@page import="java.util.GregorianCalendar"%>

<%@page import="java.util.Calendar"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<base href="<%=basePath%>">

		<title>专家预约日历</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
		<link rel="stylesheet" href="css/table.css" type="text/css"
			media="screen" />



		<script type="text/javascript">
//显示当前的时分秒
function showTime(showWhere) {

	var now = new Date();

	var hour = now.getHours();

	var minu = now.getMinutes();

	var sec = now.getSeconds();

	if (hour < 10)
		hour = "0" + hour;

	if (minu < 10)
		minu = "0" + minu;

	if (sec < 10)
		sec = "0" + sec;

	showWhere.value = " " + hour + ":" + minu + ":" + sec;

	setTimeout("showTime(time)", 1000)

}
</script>

	</head>

	<body onload="showTime(time)">
		<table width="100%" height="80%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="center" valign="middle">
					<table class="altrowstable" id="alternatecolor"
						style="width: 600px; height: 500px;">

						<tr height="40">

							<td colspan="7" align="center" style="border: 0 solid"><%=now%>


								<input type="text" style="border: 0; background-color: #F9F9F9"
									id="time" size="9" readonly="readonly">

							</td>

						</tr>

						<tr height="30" bgcolor="#F0F0F0" align="center">

							<td style="border: 1 solid;">
								日
							</td>

							<td style="border: 1 solid;">
								一
							</td>

							<td style="border: 1 solid;">
								二
							</td>

							<td style="border: 1 solid;">
								三
							</td>

							<td style="border: 1 solid;">
								四
							</td>

							<td style="border: 1 solid;">
								五
							</td>

							<td style="border: 1 solid;">
								六
							</td>

						</tr>

						<%
							for (int i = 0; i < 6; i++) {
						%>

						<tr height="30">
							<%
								for (int j = i * 7; j < (i + 1) * 7; j++) {

										if ((j - firstIndex + 1) == today) {
							%>

							<td height="25" bgcolor="gray" style="border: 1 solid">
								<font color="#FFFFFF"><b><%=days[j]%></b> </font><br>
								
								<%if(map.get(days[j])!=null){
								List<Map<String, Object>> list = (List<Map<String, Object>>)map.get(days[j]);
								for( int k = 0;k<list.size();k++){
								%>
								<span>
								<%=list.get(k).get("E.NAME")%>
								</span>
								<%
								}
								} %>
								
							</td>

							<%
								} else {
							%>

							<td height="25" style="border: 1 solid; padding-top: 3px;"><%=days[j]%>
							
							<br>
								<!-- 如果这一天有专家,显示专家的名字 -->
								<%if(map.get(days[j])!=null){
									List<Map<String, Object>> list = (List<Map<String, Object>>)map.get(days[j]);
										for(int k = 0;k<list.size();k++){
								%>
								<span>
											<%=list.get(k).get("E.NAME")%>
								</span>
								<%
										}
								} %>
							</td>

							<%
								}

									}
							%>

						</tr>


						<%
							}
						%>

					</table>
				</td>
			</tr>
		</table>

	</body>
</html>
