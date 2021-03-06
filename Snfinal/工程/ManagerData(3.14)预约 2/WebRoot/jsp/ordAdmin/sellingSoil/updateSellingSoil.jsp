<%@ page language="java"
	import="java.util.*,cn.com.adminData.model.SellingSoilBean"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	SellingSoilBean consultM = (SellingSoilBean) request
			.getAttribute("consultM");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>论坛发帖更新页面</title>

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
		<form action="<%=path %>/SellingSoilUpServlet" method="post">
			<table class="altrowstable" id="alternatecolor">
				<tr>
					<td>
						Id:
					</td>
					<td>
						<input type="text" value="<%=consultM.getId()%>" name="Id">
					</td>
				</tr>
				<tr>
					<td>
						标识Id:
					</td>
					<td>
						<input type="text" value="<%=consultM.getExtendedId()%>"
							name="ExtendedId">
					</td>
				</tr>
				<tr>
					<td>
						题目:
					</td>
					<td>
						<input type="text" value="<%=consultM.getTitle()%>"
							name="Title">
					</td>
				</tr>
				<tr>
					<td>
						交易地点:
					</td>
					<td>
						<input type="text" value="<%=consultM.getTradeLocation()%>"
							name="TradeLocation">
					</td>
				</tr>
				<tr>
					<td>
						发布时间:
					</td>
					<td>
						<input type="text" value="<%=consultM.getPublishTime()%>"
							name="PublishTime">
					</td>
				</tr>
				<tr>
					<td>
						更新时间:
					</td>
					<td>
						<input type="text" value="<%=consultM.getUpdateTime()%>"
							name="UpdateTime">
					</td>
				</tr>
				<tr>
					<td>
						用户ID:
					</td>
					<td>
						<input type="text" value="<%=consultM.getSalerId()%>"
							name="SalerId">
					</td>
				</tr>
				<tr>
					<td>
						用户姓名:
					</td>
					<td>
						<input type="text" value="<%=consultM.getSalerName()%>"
							name="SalerName">
					</td>
				</tr>
				<tr>
					<td>
						用户联系方式:
					</td>
					<td>
						<input type="text" value="<%=consultM.getContactMethod()%>"
							name="ContactMethod">
					</td></tr><tr>
					<td>
						广告有效期:
					</td>
					<td>
						<input type="text" value="<%=consultM.getValidDate()%>"
							name="ValidDate">
					</td>
				</tr>
				<tr>
					<td>
						是否失效:
					</td>
					<td>
						<input type="text" value="<%=consultM.getIsValid()%>"
							name="IsValid">
					</td></tr><tr>
					<td>
						土地信息:
					</td>
					<td>
						<input type="text" value="<%=consultM.getSoilMessage()%>"
							name="SoilMessage">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="padding-left: 53px">
						<input type="submit" value="更新">
						<input type="reset" value="重置">
						<a href="<%=path %>/SellingSoilServlet"><input type="button" value="取消"></a>
					</td>
				</tr>
			</table>
		</form>
		</td></tr></table>
	</body>
</html>
