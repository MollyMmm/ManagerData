<%@ page language="java"
	import="java.util.*,cn.com.adminData.model.NoticeBean"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	NoticeBean NoticeN = (NoticeBean) request.getAttribute("NoticeN");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>公告信息更新页面</title>

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
					<form action="<%=path%>/NoticeUpServlet" method="post">
						<table class="altrowstable" id="alternatecolor">
							<tr>
								<td class="td">
									Id:
								</td>
								<td>
									<input type="text" value="<%=NoticeN.getID()%>" name="Id">
								</td>
							</tr>
							<tr>
								<td class="td">
									标识Id:
								</td>
								<td>
									<input type="text" value="<%=NoticeN.getExtendedId()%>"
										name="ExtendedId">
								</td>
							</tr>
							<tr>
								<td>
									题目:
								</td>
								<td>
									<input type="text" value="<%=NoticeN.getTitle()%>" name="Title">
								</td>
							</tr>
							<tr>
								<td>
									内容:
								</td>
								<td>
									<input type="text" value="<%=NoticeN.getBody()%>" name="Body">
								</td>
							</tr>
							<tr>
								<td>
									梗概:
								</td>
								<td>
									<input type="text" value="<%=NoticeN.getMainBody()%>"
										name="MainBody">
								</td>
							</tr>
							<tr>
								<td>
									发布时间:
								</td>
								<td>
									<input type="text" value="<%=NoticeN.getPublishTime()%>"
										name="PublishTime">
								</td>
							</tr>
							<tr>
								<td>
									更新时间:
								</td>
								<td>
									<input type="text" value="<%=NoticeN.getUpdateTime()%>"
										name="UpdateTime">
								</td>
							</tr>
							<tr>
								<td>
									图片|视频:
								</td>
								<td>
									<input type="text" value="<%=NoticeN.getPicture()%>"
										name="Picture">
								</td>
							</tr>
							<tr>
								<td>
									公告类型:
								</td>
								<td>
									<input type="text" value="<%=NoticeN.getType()%>" name="Type">
								</td>
							</tr>

							<tr>
								<td colspan="2" style="padding-left: 40px;">
									<input type="submit" value="更新">
									<input type="reset" value="重置">
									<a href="<%=path %>/NoticeShowServlet"><input type="button" value="取消"></a>
								</td>
							</tr>
						</table>
			</form></td></tr>
		</table>
	</body>
</html>
