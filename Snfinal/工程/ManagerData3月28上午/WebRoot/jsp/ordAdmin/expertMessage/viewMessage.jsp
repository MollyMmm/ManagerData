<%@ page language="java" import="java.util.*,cn.com.adminData.model.ExpertMessageBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

ExpertMessageBean ExpertMessageN = (ExpertMessageBean)request.getAttribute("expertMessage");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewMessage.jsp' starting page</title>
    
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

	<link rel="stylesheet" type="text/css" href="<%=path %>/artDialog4.1.6/skins/blue.css" />
	<script src="<%=path%>/artDialog4.1.6/artDialog.source.js"></script>
	<script src="<%=path%>/artDialog4.1.6/jquery.artDialog.source.js"></script>
	<script src="<%=path%>/artDialog4.1.6/plugins/iframeTools.source.js"></script>
			
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

function addCon(){
	art.dialog.close();
	window.location.href = "<%=path%>/ExpertMessageServlet";
}

function addMore(){
		var id = document.getElementById("id").value;
	window.location.href = "<%=path%>/ExpertMessageDeleteServlet?ID="+id;
}
</script>
  </head>
  
  <body>
  		<table class="altrowstable" id="alternatecolor">
  			<tr>
  				<td>ID</td>
  				<td>
  					<input type="hidden"  value="<%=ExpertMessageN.getId() %>"  id="id"/>
  				
  				  	<span><%=ExpertMessageN.getId() %></span>
  				
  			</tr>
  			<tr>
  				<td>标识ID</td>
  				<td>
  					<span > <%=ExpertMessageN.getExtendedId() %></span>
  			</tr>
  				<tr>
					<td>
						姓名:
					</td>
					<td>
					<span > <%=ExpertMessageN.getNames() %></span>
					</td>
				</tr>
				<tr>
					<td>
						头像:
					</td>
					<td>
					<span > <%=ExpertMessageN.getHead_Portrait() %></span>
					</td>
				</tr>
				<tr>
					<td>
						出生年月:
					</td>
					<td>
					<span > <%=ExpertMessageN.getBirth() %></span>
					</td>
				</tr>
				<tr>
				
				<td>
				专家介绍:
				</td>
				<td>
				<span > <%=ExpertMessageN.getInfo() %></span>
				</td>
				</tr>
				<tr>
					<td>
						专业方向:
					</td>
					<td>
					<span > <%=ExpertMessageN.getMajor() %></span>
					</td>
				</tr>
				<tr>
					<td>
						值班时段:
					</td>
					<td>
					<span > <%=ExpertMessageN.getDutyTime() %></span>
					</td>
				</tr>
  		<tr>
  			<td colspan="2" align="center">
  				<input type="submit" value="确认"  onclick="addCon();"/>
  				<input type="button" value="重新添加"  onclick="addMore();"/>
  			</td>
  			
  		</tr>
  		</table>
  </body>
</html>
