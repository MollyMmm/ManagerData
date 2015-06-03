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

		<title>My JSP 'left.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<%=path %>/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$("#spanUser").click(function(){
			$("#menuUser").slideToggle();
		});
		$("#spanInfo").click(function(){
			$("#menuInfo").slideToggle();
		});
	});

</script>
	</head>

	<body>
		<ul>

			<li>
				<span id="spanUser">对用户的操作</span>
				<div id="menuUser">
					<ul>
						<li>
							<a href="<%=path%>/admin/----" target="right">查看</a>
						</li>
						<li>
							<a href="<%=path%>/admin/----" target="right">编辑</a>
						</li>
						<li>
							<a href="<%=path%>/admin/----" target="right">权限分配</a>
						</li>
					</ul>

				</div>
			</li>
		</ul>


		<ul>

			<li>
				<span id="spanInfo">对信息的操作</span>
				<div id="menuInfo">
					<ul>
						<li>
							<a href="<%=path%>/admin/----" target="right">----</a>
						</li>
						<li>
							<a href="<%=path%>/admin/----" target="right">---</a>
						</li>
						<li>
							<a href="<%=path%>/admin/----" target="right">-----</a>
						</li>
					</ul>
				</div>
			</li>
		</ul>
	</body>
</html>
