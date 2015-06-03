<%@ page language="java"
	import="java.util.*,cn.com.adminData.model.PageBean"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	PageBean pageBean = (PageBean) request.getAttribute("consult");
	List<Map<String, Object>> list = pageBean.getList();
	String currentPage = String.valueOf(pageBean.getCurrentPage());
	String totalPage = String.valueOf(pageBean.getTotalPage());
	//Map<String, Object> map = list.get(0);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>论坛发帖查找页面显示</title>

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
				<%
					if (list.size() == 0) {
				%><tr>
					<td>
						<a href="#">对不起，搜索失败请点击创建</a>
					</td>
				</tr>
				<%
					} else {
				%>
				<tr>
					<th>
						ID
					</th>
					<th>
						标识
					</th>
					<th>
						题目
					</th>
					<th>
						交易地点
					</th>
					<th>
						发布时间
					</th>
					<th>
						更新时间
					</th>
					<th>
						用户ID
					</th>
					<th>
						用户姓名
					</th>
					<th>
						用户联系方式
					</th>
					<th>
						广告有效期
					</th>
					<th>
						是否失效
					</th>
					<th>
						土地信息
					</th>

				</tr>
				<%
					for (int i = 0; i < list.size(); i++) {
							Map<String, Object> consult = list.get(i);
				%><tr>

					<td><%=consult.get("ID")%></td>
					<td><%=consult.get("EXTENDEDID")%></td>
					<td><%=consult.get("TITLE")%></td>
					<td><%=consult.get("TRADELOCATION")%></td>
					<td><%=consult.get("PUBLISHTIME")%></td>
					<td><%=consult.get("UPDATETIME")%></td>
					<td><%=consult.get("SALERID")%></td>
					<td><%=consult.get("SALERNAME")%></td>
					<td><%=consult.get("CONTACTMETHOD")%></td>
					<td><%=consult.get("VALIDDATE")%></td>
					<td><%=consult.get("ISVALID")%></td>
					<td><%=consult.get("SOILMESSAGE")%></td>

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