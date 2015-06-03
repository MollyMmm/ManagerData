<%@ page language="java" import="java.util.*,cn.com.adminData.model.ExpertMessageBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ExpertMessageBean ExpertMessageN=(ExpertMessageBean)request.getAttribute("ExpertMessageN");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>专家信息表更新页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	--><link rel="stylesheet" href="css/table.css" type="text/css"
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
     <form action="<%=path %>/ExpertMessageUpServlet" method="post">
			<table class="altrowstable" id="alternatecolor">
				<tr>
					<td> 
						Id: 
					</td>
					<td>
						<input type="text" value="<%=ExpertMessageN.getId()%>" name="Id">
					</td>
				</tr>
				<tr>
					<td>
						标识Id:
					</td>
					<td>
						<input type="text" value="<%=ExpertMessageN.getExtendedId()%>"
							name="ExtendedId">
					</td>
				</tr>
				<tr>
					<td>
						姓名:
					</td>
					<td>
						<input type="text" value="<%=ExpertMessageN.getNames()%>"
							name="Names">
					</td>
				</tr>
				<tr>
					<td>
						头像:
					</td>
					<td>
						<input type="text" value="<%=ExpertMessageN.getHead_Portrait()%>"
							name="Head_Portrait">
					</td>
				</tr>
				<tr>
					<td>
						出生年月:
					</td>
					<td>
						<input type="text" value="<%=ExpertMessageN.getBirth()%>"
							name="Birth">
					</td>
				</tr>
				<tr>
					<td>
						专业方向:
					</td>
					<td>
						<input type="text" value="<%=ExpertMessageN.getMajor()%>"
							name="Major">
					</td>
				</tr>
				<tr>
					<td>
						值班时段:
					</td>
					<td>
						<input type="text" value="<%=ExpertMessageN.getDutyTime()%>"
							name="DutyTime">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" style="padding-left: 40px;">
						<input type="submit" value="更新">
						<input type="reset" value="重置">
						<a href="<%=path %>/ExpertMessageServlet"><input type="button" value="取消"></a>
					</td>
				</tr>
			</table>
		</form></td></tr></table>
  </body>
</html>
