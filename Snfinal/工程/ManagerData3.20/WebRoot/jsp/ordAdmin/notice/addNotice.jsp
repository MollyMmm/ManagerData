<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
			List<Map<String,Object>> typeList = (List<Map<String,Object>>)request.getAttribute("type");
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
			
			<script type="text/javascript"
	src="<%=path%>/My97DatePicker/WdatePicker.js">
</script>

<script src="<%=path%>/js/jquery.js">
</script>

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
					<form method="post" action="<%=path%>/NoticeAddServlet"  enctype = "multipart/form-data">
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
									<textarea rows="7" cols="20" name="neirong"></textarea>
								</td>
							</tr>
							<tr>
								<td>
									梗概：
								</td>
								<td>
									<textarea rows="3" cols="20" name="genggai"></textarea>
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
									公告类型:
								</td>
								<td>
									
									<select name="gonggaoleixing">
									<% for(int i =0;i<typeList.size();i++){
										%><option value="<%= typeList.get(i).get("ID")%>"><%= typeList.get(i).get("ID")%><%=typeList.get(i).get("TYPENAME") %></option><% 
									} %>
									</select>
								</td>
							</tr>
							<tr>

								<td colspan="2" style="padding-left: 70px;">
									<input type="submit" value="添加">
								<!-- 	<a href="<%=path%>/NoticeShowServlet"> -->
								<input type="button"  value="取消"  id="cancleBtn" >
							
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>