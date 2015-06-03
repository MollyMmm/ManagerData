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

		<title>黄页信息添加页面</title>

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
					<form method="post" action="<%=path%>/YellowAddServlet" enctype = "multipart/form-data">
						<table class="altrowstable" id="alternatecolor">
							<tr>

								<td>
									标识:
								</td>
								<td>
									<input type="text" name="biaoshiID">
								</td>
							</tr>
							<tr>
								<td>
									机构名：
								</td>
								<td>
									<input type="text" name="jigouming">
								</td>
							</tr>
							<tr>

								<td>
									联系方式:
								</td>
								<td>
									<input type="text" name="lianxifangshi">
								</td>
							</tr>
							<tr>
								<td>
									机构地址:
								</td>
								<td>
									<textarea rows="2" cols="20"  name="jigoudizhi"></textarea>
								</td>
							</tr>
							<tr>

								<td>
									图片|视频:
								</td>
								<td>
									<input type = "file" name = "fileName" />
								</td>
							</tr>
							
							<tr>

								<td colspan="2" style="padding-left: 65px;">
									<input type="submit" value="添加">
									<a href="<%=path%>/YellowShowServlet"><input type="button"
											value="取消"> </a>
								</td>
							</tr>

						</table>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>