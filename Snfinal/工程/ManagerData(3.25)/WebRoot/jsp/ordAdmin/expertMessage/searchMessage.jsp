<%@ page language="java"
	import="java.util.*,cn.com.adminData.model.PageBean"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	PageBean pageBean = (PageBean) request.getAttribute("ExpertMessage");
	List<Map<String, Object>> list = pageBean.getList();
	String currentPage = String.valueOf(pageBean.getCurrentPage());
	String totalPage = String.valueOf(pageBean.getTotalPage());
	//Map<String, Object> map = list.get(0);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>专家信息查找页面</title>

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
			
			<th>姓名
			</th>
			<th>头像
			</th>
			<th>出生年月
			</th>
			<th>专业方向
			</th>
			<th>值班时段
			</th>
			
			</tr>
			<%
			
			for (int i = 0;i<list.size();i++){
			Map<String,Object> ExpertMessage= list.get(i);
				%><tr>
				
				<td><%= ExpertMessage.get("ID")%></td>
				<td><%= ExpertMessage.get("EXTENDEDID")%></td>
				<td><%= ExpertMessage.get("NAMES")%></td>
				<td><%= ExpertMessage.get("HEAD_PORTRAIT")%></td>
				<td><%= ExpertMessage.get("BIRTH")%></td>
				<td><%= ExpertMessage.get("MAJOR")%></td>
				<td><%= ExpertMessage.get("DUTYTIME")%></td>
				
				
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