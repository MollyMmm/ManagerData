<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'flow.jsp' starting page</title>
    
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
function altRows(id) {
	if (document.getElementsByTagName) {

		var table = document.getElementById(id);
		var rows = table.getElementsByTagName("tr");

		for (i = 0; i < rows.length; i++) {
			if (i % 2 == 0) {
				rows[i].className = "evenrowcolor";
			} else {
				rows[i].className = "oddrowcolor";
			}
		}
	}
}

window.onload = function() {
	altRows('alternatecolor');
}
</script>
	</head>

	<body>
	
	
	<div style="padding-left: 200px; padding-top: 50px;">
	<form action="<%=path %>/ExchangeFlowDoServlet" method="post">
			<table class="altrowstable" id="alternatecolor">
			<tr><td> <input type="hidden" name="id" value="<%=request.getParameter("id") %>"/></td>
			<td>
			用户手机号：<%=request.getParameter("tele") %>
			</td>
			</tr>
			<tr>
			<th>需要的积分
			</th>
			<th>可兑换的流量
			</th>
			
			</tr>
			<tr>
			<td><input type="radio" name="flow" value="50"/>50</td>
			<td>5M</td>
			
			</tr>
			<tr>
			<td><input type="radio" name="flow" value="100"/>100</td>
			<td>12M</td>
			
			</tr>
			<tr>
			<td><input type="radio" name="flow" value="200"/>200</td>
			<td>30M</td>
		
			</tr>
			<tr>
			<td colspan="2"><a href="<%=path %>/ExchangeShowServlet">返回</a>
			
			<input type="submit" value="兑换"/>
			</td>
			</tr>
			</table>	
			
		</form>
		</div>
	</body>
</html>

