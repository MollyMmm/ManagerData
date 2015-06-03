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

		<title>私人咨询添加页面</title>

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
					<form method="post" action="<%=path%>/PrivateConsultAddServlet">
						<table class="altrowstable" id="alternatecolor">
							<tr>
								<td>
									标识:
								</td>
								<td>
									<input type="text" name="extendedid">
								</td>
							</tr>
							<tr>
								<td>
									用户ID:
								</td>
								<td>
									<input type="text" name="userid">
								</td>
							</tr>
							<tr>

								<td>
									咨询内容:
								</td>
								<td>
									<input type="text" name="neirong">
								</td>
							</tr>
							<tr>
								<td>
									咨询时间:
								</td>
								<td>
									<input type="text" name="time">
								</td>
							</tr>
							<tr>

								<td>
									期望期限:
								</td>
								<td>
									<input type="text" name="qixian">
								</td>
							</tr>
							<tr>
								<td>
									咨询类型:
								</td>
								<td>
									<input type="text" name="leixing">
								</td>
							</tr>
							<tr>

								<td>
									回复内容:
								</td>
								<td>
									<input type="text" name="huifuneirong">
								</td>
							</tr>
							<tr>
								<td>
									回复时间:
								</td>
								<td>
									<input type="text" name="huifu">
								</td>

							</tr>
							<tr>
								<td colspan="2" style="padding-left: 65px;">
									<input type="submit" value="添加">
									<a href="<%=path%>/PrivateConsultServlet"><input
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
