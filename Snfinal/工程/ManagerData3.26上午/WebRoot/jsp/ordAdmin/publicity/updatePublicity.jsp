<%@ page language="java" import="java.util.*,cn.com.adminData.model.PublicityBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
PublicityBean PublicityN=(PublicityBean)request.getAttribute("PublicityN");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>政策表更新页面</title>
    
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
     <form action="<%=path %>/PublicityUpServlet" method="post">
			<table class="altrowstable" id="alternatecolor">
				<tr>
					<td>
						Id:
					</td>
					<td>
						<input type="text" value="<%=PublicityN.getID()%>" name="Id">
					</td>
				</tr>
				<tr>
					<td>
						题目:
					</td>
					<td>
						<input type="text" value="<%=PublicityN.getTitle()%>"
							name="Title">
					</td>
				</tr>
				<tr>
					<td>
						内容:
					</td>
					<td>
						<input type="text" value="<%=PublicityN.getBodys()%>"
							name="Bodys">
					</td>
				</tr>
				<tr>
					<td>
						类型:
					</td>
					<td>
						<input type="text" value="<%=PublicityN.getType()%>"
							name="Type">
					</td>
				</tr>
				<tr>
					<td>
						发布时间:
					</td>
					<td>
						<input type="text" value="<%=PublicityN.getStart_time()%>"
							name="Start_time">
					</td>
				</tr>
				<tr>
					<td>
						更新时间:
					</td>
					<td>
						<input type="text" value="<%=PublicityN.getUpdate_time()%>"
							name="Update_time">
					</td>
				</tr>
				<tr>
					<td>
						过程:
					</td>
					<td>
						<input type="text" value="<%=PublicityN.getProcess()%>"
							name="Process">
					</td>
				</tr>
					<tr>
					<td>
						名字:
					</td>
					<td>
						<input type="text" value="<%=PublicityN.getName()%>"
							name="Name">
					</td>
				</tr>
					<tr>
					<td>
						标识ID:
					</td>
					<td>
						<input type="text" value="<%=PublicityN.getID_item()%>"
							name="ID_item">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" style="padding-left: 35px;">
						<input type="submit" value="更新">
						<input type="reset" value="重置">
						<a href="<%=path %>/PublicityShowServlet"><input type="button" value="取消"></a>
					</td>
				</tr>
			</table>
		</form></td></tr></table>
  </body>
</html>
