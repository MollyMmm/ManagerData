<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>My JSP 'adminPower.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<table>
			<caption>
				普通理员权限分配
			</caption>
<tr>
			<th>
				账号
			</th>
			<th>
				密码
			</th>

			<th>
				权限
			</th>
</tr>

			<tr>
				<td>
					账号
				</td>
				<td>
					密码
				</td>

				<td>

					修改
					<input type="checkbox" name="Power" value="editInfo" />
					添加
					<input type="checkbox" name="Power" value="addInfo" />
					删除
					<input type="checkbox" name="Power" value="deleteInfo" />
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="button" value="确认修改"/>
					
				</td>
			</tr>
		</table>
	</body>
</html>
