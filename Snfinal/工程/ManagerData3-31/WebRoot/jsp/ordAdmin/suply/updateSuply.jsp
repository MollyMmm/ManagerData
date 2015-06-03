<%@ page language="java" import="java.util.*,cn.com.adminData.model.SuplyBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

SuplyBean suplyN = (SuplyBean)request.getAttribute("suply");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateSuply.jsp' starting page</title>
    
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
		window.location.href = "<%=path %>/SuplyServlet";
	});
});

</script>
	</head>

	<body>
		<table width="100%" height="80%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="center" valign="middle">
					<form action="<%=path%>/SuplyUpServlet" method="post">
						<table class="altrowstable" id="alternatecolor">
							<tr>
								<td class="td">
									Id:
								</td>
								<td>
									<input type="hidden" value="<%=suplyN.getId()%>" name="Id" >
									<span><%=suplyN.getId()%></span>
								</td>
							</tr>
							<tr>
								<td class="td">
									标识Id:
								</td>
								<td>
									<input type="text" value="<%=suplyN.getExtendedId()%>"
										name="ExtendedId">
								</td>
							</tr>
							<tr>
								<td>
									商品名:
								</td>
								<td>
									<input type="text" value="<%=suplyN.getNames()%>" name="Names">
								</td>
							</tr>
							<tr>
								<td>
									图片:
								</td>
								<td>
										<input type="text" value="<%=suplyN.getPicture()%>"
										name="Picture" >
								</td>
							</tr>
							<tr>
								<td>
									价格:
								</td>
								<td>
									<input type="text"  value="<%=suplyN.getPrice()%>"	name="Price"  >
								</td>
							</tr>
							<tr>
								<td>
									原价:
								</td>
								<td>
									<input type="text" value="<%=suplyN.getPreprice()%>"
										name="Preprice" >
								</td>
							</tr>
								<tr>
								<td>
									商品描述:
								</td>
								<td>
									<textarea name="Introduction" rows="7" cols="20"><%=suplyN.getIntroduction()%></textarea>
								</td>
							</tr>

							<tr>
								<td colspan="2" style="padding-left: 40px;">
									<input type="submit" value="更新">
									<input type="reset" value="重置">
							<input type="button" value="取消"  id="cancleBtn">
								</td>
							</tr>
						</table>
			</form></td></tr>
		</table>
	</body>
</html>