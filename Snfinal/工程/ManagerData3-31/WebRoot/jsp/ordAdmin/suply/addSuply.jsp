<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addSuply.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<%=path%>/js/jquery.js">
</script>

	<link rel="stylesheet" href="css/table.css" type="text/css"
			media="screen" />

<link rel="stylesheet" type="text/css"
	href="<%=path%>/artDialog4.1.6/skins/blue.css" />
<script src="<%=path%>/artDialog4.1.6/artDialog.source.js">
</script>
<script src="<%=path%>/artDialog4.1.6/jquery.artDialog.source.js">
</script>
<script src="<%=path%>/artDialog4.1.6/plugins/iframeTools.source.js">
</script>

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

<%--//按钮：取消--关闭此对话框  --%>
$(function(){
	$("#cancleBtn").click(function(){
		art.dialog.close();
	});
	});
</script>
	</head>

	<body>
		<table width="100%" height="80%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="center" valign="middle">
					<form method="post" action="<%=path%>/SuplyAddServlet"  enctype = "multipart/form-data">
						<table class="altrowstable" id="alternatecolor">
							<tr>

								<td>
									标识ID:
								</td>
								<td>
									<input type="text" name="extendedId">
								</td>
							</tr>
							<tr>
								<td>
									商品名：
								</td>
								<td>
									<input type="text" name="names">
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
								<td>
									价格：
								</td>
								<td>
									<input type="text" name="price" />
								</td>
							</tr>
								<tr>
								<td>
									原价:
								</td>
								<td>
									<input type="text" name="preprice" />
								</td>
							</tr>
							<tr>
								<td>
									商品描述:
								</td>
								<td>
									<textarea rows="7" cols="20" name="introduction"></textarea>
								</td>
							</tr>
							
							<tr>
								<td colspan="2" style="padding-left: 70px;">
									<input type="submit" value="添加">
								
								<input type="button"  value="取消"  id="cancleBtn" >
							
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>
