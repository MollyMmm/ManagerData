<%@ page language="java" import="java.util.*,cn.com.adminData.model.FeedbackBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

FeedbackBean FeedbackN=(FeedbackBean)request.getAttribute("FeedbackN");
List<Map<String,Object>> typeList = (List<Map<String,Object>>)request.getAttribute("type");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>反馈表更新页面</title>
    
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
			
			<script src="<%=path%>/js/jquery.js">
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

$(function(){
	$("#cancleBtn").click(function(){
		window.location.href = "<%=path %>/FeedBackShowServlet";
	});
});
</script>

  </head>
  
  <body>
  <table width="100%" height="80%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="center" valign="middle">
     <form action="<%=path %>/FeedbackUpServlet" method="post">
			<table class="altrowstable" id="alternatecolor">
				<tr>
					<td> 
						Id: 
					</td>
					<td>
						<input type="text" value="<%=FeedbackN.getID()%>" name="Id">
					</td>
				</tr>
				<tr>
					<td>
						标识Id:
					</td>
					<td>
						<input type="text" value="<%=FeedbackN.getExtendedId()%>"
							name="ExtendedId">
					</td>
				</tr>
				<tr>
					<td>
						用户ID:
					</td>
					<td>
						<input type="text" value="<%=FeedbackN.getUserID()%>"
							name="UserID">
					</td>
				</tr>
				<tr>
					<td>
						题目:
					</td>
					<td>
						<input type="text" value="<%=FeedbackN.getTitle()%>"
							name="Title">
					</td>
				</tr>
				<tr>
					<td>
						内容描述:
					</td>
					<td><textarea rows="7" cols="20"  name="Description"><%=FeedbackN.getDescription()%></textarea>
						
					</td>
				</tr>
				<!-- 
				<tr>
					<td>
						期望期限:
					</td>
					<td>
						<input type="text" value="<%=FeedbackN.getDeadline()%>"
							name="Deadline">
					</td>
				</tr> -->
				<tr>
					<td>
						用户要求:
					</td>
					<td>				
							<textarea rows="3" cols="20"  name="Require"><%=FeedbackN.getRequire()%></textarea>
					</td>
				</tr>
				<tr>
					<td>
						反馈类型:
					</td>
					<td>
						<select name="Type">
									<% for(int i =0;i<typeList.size();i++){
										%><option value="<%= typeList.get(i).get("ID")%>" <%if(FeedbackN.getType()==Integer.parseInt(typeList.get(i).get("ID").toString())){%>selected="selected"<%}%>><%= typeList.get(i).get("ID")%><%=typeList.get(i).get("TYPENAME") %></option><% 
									} %>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						发送时间:
					</td>
					<td>
						<input type="text" value="<%=FeedbackN.getSentTime()%>"
							name="SentTime" readonly="readonly">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" style="padding-left: 40px;">
						<input type="submit" value="更新">
						<input type="reset" value="重置">
						<!-- <a href="<%=path %>/FeedBookShowServlet"> --><input type="button" value="取消"  id="cancleBtn">
					</td>
				</tr>
			</table>
		</form></td></tr></table>
  </body>
</html>
