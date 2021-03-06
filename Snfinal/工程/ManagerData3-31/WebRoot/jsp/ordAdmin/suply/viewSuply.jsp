<%@ page language="java" import="java.util.*,cn.com.adminData.model.SuplyBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

SuplyBean suplyM = (SuplyBean)request.getAttribute("suply");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewSuply.jsp' starting page</title>
    
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
	window.location.href = "<%=path%>/SuplyServlet";
}

function addMore(){
		var id = document.getElementById("id").value;
	window.location.href = "<%=path%>/SuplyDelServlet?ID="+id;
}
</script>
  </head>
  
  <body>
  		<table class="altrowstable" id="alternatecolor">
  			<tr>
  				<td>ID</td>
  				<td>
  					<input type="hidden"  value="<%=suplyM.getId() %>"  id="id"/>
  				
  				  	<span><%=suplyM.getId() %></span>
  				
  			</tr>
  			<tr>
  				<td>标识ID</td>
  				<td>
  					<span > <%=suplyM.getExtendedId() %></span>
  			</tr>
  			<tr>
  				<td>商品名</td>
  				<td>
  					<span><%=suplyM.getNames()%></span>
  				</td>
  			</tr>
  					<tr>
  				<td>图片</td>
  				<td>
  					<span><%=suplyM.getPicture() %></span>
  				</td>
  			</tr>
  			<tr>
  				<td>价格</td>
  				<td>	
  				<span><%=suplyM.getPrice() %></span>
  				</td>
  			</tr>
  			<tr>
  				<td>原价格</td>
  				<td>
  					<span><%=suplyM.getPreprice() %></span>
  			</tr>
  			<tr>
  				<td>商品描述</td>
  				<td>
  					<span><%=suplyM.getIntroduction() %></span>
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