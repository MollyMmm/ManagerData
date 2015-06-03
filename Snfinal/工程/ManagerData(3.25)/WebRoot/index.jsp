<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=Utf-8"%>
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

		<title>table样子模版</title>
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
	</head>

	<body>

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
		<div style="margin-right: 10px; width: 850px">
			<table>
				<tr>
					<td>
						<font
							style="font-family: verdana, arial, sans-serif; font-size: 15px; color: #333333;">类型1：</font>
						<input type="text" name="leixing1">
					</td>
					<td>
						<font
							style="font-family: verdana, arial, sans-serif; font-size: 15px; color: #333333;">类型2：</font>
						<input type="text" name="leixing2">
					</td>
					<td>
						<font
							style="font-family: verdana, arial, sans-serif; font-size: 15px; color: #333333;">类型3：</font>
						<input type="text" name="leixing2">
					</td>
					<td>
						<input type="submit" value="搜索">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</div>
		<table width="100%" height="80%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="center" valign="middle">
					
						<table class="altrowstable" id="alternatecolor">
							<tr>
								<th>
									寒心
								</th>
								<th>
									Info Header 2
								</th>
								<th>
									Info Header 3
								</th>
								<th>
									Info Header 4
								</th>
								<th>
									Info Header 5
								</th>
							</tr>
							<tr>
								<td>
									Text 1A
								</td>
								<td>
									Text 1B
								</td>
								<td>
									Text 1C
								</td>
								<td>
									Text 1C
								</td>
								<td>
									Text 1C
								</td>
							</tr>
							<tr>
								<td>
									Text 2A
								</td>
								<td>
									Text 2B
								</td>
								<td>
									Text 2C
								</td>
								<td>
									Text 2C
								</td>
								<td>
									寒心
								</td>
							</tr>

							<tr>
								<td>
									Text 3A
								</td>
								<td>
									Text 3B
								</td>
								<td>
									Text 3C
								</td>
								<td>
									Text 3C
								</td>
								<td>
									Text 3C
								</td>
							</tr>
							<tr>
								<td>
									Text 4A
								</td>
								<td>
									Text 4B
								</td>
								<td>
									Text 4C
								</td>
								<td>
									Text 4C
								</td>
								<td>
									Text 4C
								</td>
							</tr>
							<tr>
								<td>
									Text 5A
								</td>
								<td>
									Text 5B
								</td>
								<td>
									Text 5C
								</td>
								<td>
									Text 5C
								</td>
								<td>
									Text 5C
								</td>
							</tr>
						</table>
						</td>
						</tr>
						</table>
					
	</body>
</html>
