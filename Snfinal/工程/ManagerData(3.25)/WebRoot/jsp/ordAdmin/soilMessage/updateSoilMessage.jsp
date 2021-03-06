<%@ page language="java" import="java.util.*,cn.com.adminData.model.SoilMessageBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SoilMessageBean SoilMessageN=(SoilMessageBean)request.getAttribute("SoilMessageN");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>土地信息表更新页面</title>
    
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
     <form action="<%=path %>/SoilMessageUpServlet" method="post">
			<table class="altrowstable" id="alternatecolor">
				<tr>
					<td>
						Id:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getId()%>" name="Id">
					</td>

					<td>
						标识Id:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getExtendedId()%>"
							name="ExtendedId">
					</td>
				</tr>
				<tr>
					<td>
						土地名称:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getNames()%>"
							name="Name">
					</td>
				
					<td>
						图片:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getPicture()%>"
							name="Picture">
					</td>
				</tr>
				<tr>
					<td>
						价格:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getPrice()%>"
							name="Price">
					</td>
				<td>
						流转性质:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getConversionProperty()%>"
							name="Conversion_Property">
					</td>
				</tr>
				<tr>
					<td>
						土地面积:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getSoilArea()%>"
							name="SoilArea">
					</td>
				
					<td>
						可流转年限:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getNegotiableYear()%>"
							name="Negotiable_Year">
					</td>
				</tr>
				<tr>
					<td>
						剩余年限:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getSurplusYear()%>"
							name="SurplusYear">
					</td>
				
					<td>
						土地权证:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getLandWarrants()%>"
							name="Land_Warrants">
					</td>
				</tr>
				<tr>
					<td>
						用途:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getSoilUsing()%>"
							name="SoilUsing">
					</td>
				
					<td>
						土地类型:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getType()%>"
							name="Type">
					</td>
				
			       </tr>
				   <tr>
					<td>
						是否失效:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getValiddate()%>"
							name="Validdate">
					</td>
					<td>
						土地位置:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getSoilLocation()%>"
							name="SoilLocation">
					</td>
					</tr>
					<tr>
					<td>
						联系方式:
					</td>
					<td>
						<input type="text" value="<%=SoilMessageN.getContactWay()%>"
							name="ContactWay">
					</td>
				</tr>
				
				
				
				<tr>
					<td colspan="4" style="padding-left: 165px;">
						<input type="submit" value="更新">
						<input type="reset" value="重置">
						<a href="<%=path %>/MessageShowServlet"><input type="button" value="取消"></a>
					</td>
				</tr>
			</table>
		</form></td></tr></table>
  </body>
</html>
