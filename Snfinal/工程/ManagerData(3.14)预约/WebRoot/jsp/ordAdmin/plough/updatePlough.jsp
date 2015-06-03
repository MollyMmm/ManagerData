<%@ page language="java" import="java.util.*,cn.com.adminData.model.PloughBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
PloughBean PloughN=(PloughBean)request.getAttribute("PloughN");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>耕地检测表更新页面</title>
    
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
    <form action="<%=path %>/PloughUpServlet" method="post">
			<table class="altrowstable" id="alternatecolor">
				<tr>
					<td>
						Id:
					</td>
					<td>
						<input type="text" value="<%=PloughN.getID()%>" name="Id">
					</td>
				</tr>
				<tr>
					<td>
						标识Id:
					</td>
					<td>
						<input type="text" value="<%=PloughN.getExtendedId()%>"
							name="ExtendedId">
					</td>
				</tr>
				<tr>
					<td>
						土质:
					</td>
					<td>
						<input type="text" value="<%=PloughN.getSoilTexture()%>"
							name="SoilTexture">
					</td>
				</tr>
				<tr>
					<td>
						墑情描述:
					</td>
					<td>
						<input type="text" value="<%=PloughN.getSoilCondition()%>"
							name="SoilCondition">
					</td>
				</tr>
				<tr>
					<td>
						要素残留:
					</td>
					<td>
						<input type="text" value="<%=PloughN.getVestigital()%>"
							name="Vestigital">
					</td>
				</tr>
				<tr>
					<td>
						位置:
					</td>
					<td>
						<input type="text" value="<%=PloughN.getLocation()%>"
							name="Location">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" style="padding-left: 41px;">
						<input type="submit" value="更新">
						<input type="reset" value="重置">
					<a href="<%=path %>/PloughShowServlet">	<input type="button" value="取消"></a>
					</td>
				</tr>
			</table>
		</form></td></tr></table>
  </body>
</html>
