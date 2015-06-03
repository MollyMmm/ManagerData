<%@ page language="java"
	import="java.util.*,cn.com.adminData.model.PageBean"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	PageBean pageBean = (PageBean) request.getAttribute("GoodsMessage");
	List<Map<String, Object>> list = pageBean.getList();
	String currentPage = String.valueOf(pageBean.getCurrentPage());
	String totalPage = String.valueOf(pageBean.getTotalPage());
	//Map<String, Object> map = list.get(0);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>商铺信息页面显示</title>

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
	
	<table width="100%" height="80%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="center" valign="middle">
	
			<table class="altrowstable" id="alternatecolor">
			<% if(list.size()==0){
			%><tr><td><a href="#">对不起，搜索失败请点击创建</a></td></tr><% 
			}else{%>
			<tr>
			<th>ID
			</th>
			<th>标识
			</th>
			<th>商铺名
			</th>
			<th>图片
			</th>
			<th>商铺描述
			</th>
			<th>商铺地址
			</th>
			</tr>
			<%
			
			for (int i = 0;i<list.size();i++){
			Map<String,Object> consult= list.get(i);
				%><tr>
				
				<td><%= consult.get("ID")%></td>
				<td><%= consult.get("EXTENDEDID")%></td>
				<td><%= consult.get("NAMES")%></td>
				<td><%= consult.get("PICTURE")%></td>
				<td><%= consult.get("INTRODUCTION")%></td>
				<td><%= consult.get("ADDRESS")%></td>				
				</tr>
			<% 
			}
			 %>
			 <% 
			}
			 %>
			</table>	
			
			
		</td></tr></table>
	</body>
</html>