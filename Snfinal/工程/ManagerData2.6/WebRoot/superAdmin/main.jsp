<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>万良服务平台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 


<noframes>
</noframes>
  <frameset rows =  "70,*" frameBorder=0 border=0 frameSpacing=0>
 	<frame src="<%=path %>/superAdmin/top.jsp" noresize = "noresize" scrolling = "no" frameBorder=0/>
 	<frame src = "<%=path %>/superAdmin/bottom.jsp" />
 </frameset>
</html>
