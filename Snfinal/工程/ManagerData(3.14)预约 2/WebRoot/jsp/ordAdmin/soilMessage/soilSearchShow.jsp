<%@ page language="java"
	import="java.util.*,cn.com.adminData.model.PageBean"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	PageBean pageBean = (PageBean) request.getAttribute("SoilMessage");
	List<Map<String, Object>> list = pageBean.getList();
	String currentPage = String.valueOf(pageBean.getCurrentPage());
	String totalPage = String.valueOf(pageBean.getTotalPage());
	//Map<String, Object> map = list.get(0);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>土地信息表显示页面</title>

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
			<th>标识ID
			</th>
			<th>土地名称
			</th>
			<th>图片
			</th>
			<th>价格
			</th>
			<th>流转性质
			</th>
			<th>土地面积
			</th>
			<th>可流转年限
			</th>
			<th>剩余年限
			</th>
			<th>土地权证
			</th>
			<th>用途
			</th>
			<th>土地类型
			</th>
			<th>是否失效
			</th>
			</tr>
			<%
			
			for (int i = 0;i<list.size();i++){
			Map<String,Object> SoilMessage= list.get(i);
				%><tr>
				
				<td><%= SoilMessage.get("ID")%></td>
				<td><%= SoilMessage.get("EXTENDEDID")%></td>
				<td><%= SoilMessage.get("NAMES")%></td>
				<td><%= SoilMessage.get("PICTURE")%></td>
				<td><%= SoilMessage.get("PRICE")%></td>
				<td><%= SoilMessage.get("CONVERSION_PROPERTY")%></td>
				<td><%= SoilMessage.get("SOILAREA")%></td>
				<td><%= SoilMessage.get("NEGOTIABLE_YEAR")%></td>
				<td><%= SoilMessage.get("SURPLUSYEAR")%></td>
				<td><%= SoilMessage.get("LAND_WARRANTS")%></td>
				<td><%= SoilMessage.get("SOILUSING")%></td>
				<td><%= SoilMessage.get("TYPE")%></td>
				<td><%= SoilMessage.get("VALIDDATE")%></td>
				
				
				
				
				</tr>
			<% 
			}
			 %>
			 <% 
			}
			 %>
			</table>	
			
			
		</td></tr></table>	</body>
</html>