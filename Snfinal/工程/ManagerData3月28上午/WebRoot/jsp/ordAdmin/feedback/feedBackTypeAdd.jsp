<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'feedBackTypeAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<%=path %>/artDialog4.1.6/skins/blue.css" />
<script src="<%=path%>/js/jquery.js"></script>
<script src="<%=path%>/artDialog4.1.6/artDialog.source.js"></script>
<script src="<%=path%>/artDialog4.1.6/plugins/iframeTools.source.js"></script>

<script type="text/javascript">

</script>
  </head>
  
  <body>
  		<form action="<%=path %>/FeedBackTypeAddServlet"  method="post" id="pageForm">
				类型名称:<input type="text" name="type"/>
				<input type="submit" value="确认添加"  id="submitBtn"/>
 		</form>
  </body>
</html>
