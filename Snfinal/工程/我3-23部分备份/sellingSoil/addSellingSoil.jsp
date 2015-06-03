<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>出让土地添加页面</title>

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
					<form method="post" action="<%=path%>/SellingSoilAddServet">
						<table class="altrowstable" id="alternatecolor">
							<tr>

								<td>
									标识:
								</td>
								<td>
									<input type="text" name="extendedid">
								</td>
								<td>
									题目:
								</td>
								<td>
									<input type="text" name="title">
								</td>
							</tr>
							<tr>

								<td>
									交易地点:
								</td>
								<td>
									<input type="text" name="tradelocation">
								</td>
								<td>
									发布时间:
								</td>
								<td>
									<input type="text" name="publishtime">
								</td>
							</tr>
							<tr>

								<td>
									更新时间:
								</td>
								<td>
									<input type="text" name="updatetime">
								</td>

								<td>
									用户Id:
								</td>
								<td>
									<input type="text" name="salerid">
								</td>
							</tr>
							<tr>

								<td>
									用户姓名:
								</td>
								<td>
									<input type="text" name="salername">
								</td>
								<td>
									用户联系方式:
								</td>
								<td>
									<input type="text" name="contactmethod">
								</td>

							</tr>
							<tr>
								<td>
									广告有效期:
								</td>
								<td>
									<input type="text" name="validdate">
								</td>
								<td>
									是否生效:
								</td>
								<td>
									<input type="text" name="lisvalid">
								</td>


							</tr>
							<tr>
								<td>
									土地信息:
								</td>
								<td>
									<input type="text" name="soilmessage">
								</td>
								<td></td><td></td>
							</tr>
							<tr>
								<td colspan="4" style="padding-left: 200px;">
									<input type="submit" value="添加">
									<a href="<%=path%>/SellingSoilServlet"><input
											type="button" value="取消"> </a>
								</td>
							</tr>

						</table>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>
