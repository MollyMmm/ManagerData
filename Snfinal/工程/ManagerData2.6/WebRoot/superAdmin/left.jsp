<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN">
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
		<script src="<%=path %>/js/jquery.js" type="text/javascript">
</script>
		<script type="text/javascript">

function expand(el) {
	childObj = document.getElementById("child" + el);

	if (childObj.style.display == 'none') {
		childObj.style.display = 'block';
	} else {
		childObj.style.display = 'none';
	}
	return;
}<%--
	$(function(){
		$("#spanMenu").click(function(){
			$("#menu").slideToggle();
		});
	});

--%>
</script>
	</head>

	<body>

		<%--
		<ul>

			<li>
				<span id="spanMenu">对普通管理员的操作</span>
				
				<div id="menu">
					<ul>
						<li>
							<a href="<%=path%>/superadmin/adminadd.jsp" target="right">添加</a>
						</li>
						<li>
							<a href="<%=path%>/superadmin/adminShow.jsp" target="right">查看</a>
						</li>
						<li>
							<a href="<%=path%>/superadmin/adminUpdate.jsp" target="right">编辑</a>
						</li>
						<li>
							<a href="<%=path%>/superadmin/adminPower.jsp" target="right">权限分配</a>
						</li>
					</ul>
				</div>
			</li>
		</ul>
	--%>

		<table height="100%" cellSpacing=0 cellPadding=0 width=170
			background="images/menu_bg.jpg" border="0">
			<tr>
				<td valign="top">
					<%--align="middle" --%>
					<table cellSpacing=0 cellPadding=0 width="100%" border=0>

						<tr>
							<td height=10></td>
						</tr>
					</table>
					<table cellSpacing=0 cellPadding=0 width=150 border=0>

						<tr height=22>
							<td style="PaDDING-LEFT: 30px" background=images/menu_bt.jpg>
								<a class="menuParent" onclick="expand(1);"
									href="javascript:void(0);">管理员管理</a>
							</td>
						</tr>
						<tr height=4>
							<td></td>
						</tr>
					</table>
					<table id=child1 style="display: none" cellSpacing=0 cellPadding=0
						width="150" border=0>
						<tr height=20>
							<td align="center" width=30>
								<IMG height=9 src="images/menu_icon.gif" width=9>
							</td>
							<td>
								<a class=menuChild href="<%=path %>/adminServlet" target="right">管理员列表</a>
							</td>
						</tr>


						<tr height=4>
							<td colSpan=2></td>
						</tr>
					</table>
					<table cellSpacing=0 cellPadding=0 width=150 border=0>
						<tr height=22>
							<td style="PaDDING-LEFT: 30px" background=images/menu_bt.jpg>
								<a class=menuParent onclick=expand(2) href="javascript:void(0);">权限管理</a>
							</td>
						</tr>
						<tr height=4>
							<td></td>
						</tr>
					</table>
					<table id=child2 style="display: none" cellSpacing=0 cellPadding=0
						width=150 border=0>
						<tr height=20>
							<td align="center" width=30>
								<IMG height=9 src="images/menu_icon.gif" width=9>
							</td>
							<td>
								<a class=menuChild href="PowerShowServlet" target="right">权限组管理</a>
							</td>
						</tr>
						

						<tr height=4>
							<td colSpan=2></td>
						</tr>
					</table>

					<table cellSpacing=0 cellPadding=0 width=150 border=0>

						<tr height=22>
							<td style="PaDDING-LEFT: 30px" background=images/menu_bt.jpg>
								<a class=menuParent onclick=expand(0) href="javascript:void(0);">个人管理</a>
							</td>
						</tr>
						<tr height=4>
							<td></td>
						</tr>
					</table>
					<table id=child0 style="display: none" cellSpacing=0 cellPadding=0
						width=150 border=0>

						<tr height=20>
							<td align="center" width=30>
								<IMG height=9 src="images/menu_icon.gif" width=9>
							</td>
							<td>
								<a class=menuChild href="#" target="right">修改口令</a>
							</td>
						</tr>
						<tr height=20>
							<td align="center" width=30>
								<IMG height=9 src="images/menu_icon.gif" width=9>
							</td>
							<td>
								<a class=menuChild
									onclick="if (confirm('确定要退出吗？')) return true; else return false;"
									href="<%=path %>/login/login.jsp" target=_top>退出系统</a>
							</td>
						</tr>
					</table>
				</td>
				<td width=1 bgColor=#d1e6f7></td>
			</tr>
		</table>
	</body>
</html>
