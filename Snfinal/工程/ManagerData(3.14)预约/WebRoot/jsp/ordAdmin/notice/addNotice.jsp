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

		<title>公告信息添加页面</title>

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
					<form method="post" action="<%=path%>/NoticeAddServlet">
						<table class="altrowstable" id="alternatecolor">
							<tr>

								<td>
									标识ID:
								</td>
								<td>
									<input type="text" name="biaoshiID">
								</td>
							</tr>
							<tr>
								<td>
									题目：
								</td>
								<td>
									<input type="text" name="timu">
								</td>
							</tr>
							<tr>

								<td>
									内容:
								</td>
								<td>
									<input type="text" name="neirong">
								</td>
							</tr>
							<tr>
								<td>
									梗概：
								</td>
								<td>
									<input type="text" name="genggai">
								</td>
							</tr>
							<tr>

								<td>
									发布时间:
								</td>
								<td>
									<input type="text" name="fabushijian">
								</td>
							</tr>
							<tr>
								<td>
									更新时间：
								</td>
								<td>
									<input type="text" name="gengxinshijian">
								</td>
							</tr>
							<tr>

								<td>
									图片|视频:
								</td>
								<td>
									<input type="text" name="tupian">
								</td>
							</tr>
							<tr>
								<td>
									公告类型:
								</td>
								<td>
									<input type="text" name="gonggaoleixing">
								</td>
							</tr>
							<tr>

								<td colspan="2" style="padding-left: 70px;">
									<input type="submit" value="添加">
									<a href="<%=path%>/NoticeShowServlet"><input type="button"
											value="取消">
									</a>
							</tr>

						</table>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>