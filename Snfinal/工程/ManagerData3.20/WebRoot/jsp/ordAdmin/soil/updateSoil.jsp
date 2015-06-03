<%@ page language="java" import="java.util.*,cn.com.adminData.model.SoilBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

SoilBean sellingN = (SoilBean)request.getAttribute("soil");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateSoil.jsp' starting page</title>
    
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
		window.location.href = "<%=path %>/SoilServlet";
	});
});

</script>
	</head>
	<body>
		<table width="100%" height="80%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="center" valign="middle">
					<form action="<%=path%>/SoilUpServlet" method="post">
						<table class="altrowstable" id="alternatecolor">
							<tr>
								<td class="td">
									Id:
								</td>
								<td>
									<input type="hidden" value="<%=sellingN.getId()%>" name="ID" >
									<span><%=sellingN.getId()%></span>
								</td>
							</tr>
							<tr>
								<td class="td">
									标识Id:
								</td>
								<td>
									<input type="text" value="<%=sellingN.getExtendedid()%>"
										name="EXTENDEDID">
								</td>
							</tr>
							<tr>
								<td>
									题目:
								</td>
								<td>
									<input type="text" value="<%=sellingN.getTitle()%>" name="TITLE">
								</td>
							</tr>
							<tr>
								<td>
									出让土地信息:
								</td>
								<td>
									<textarea name="PRODUCT_MESSAGE" rows="7" cols="20"><%=sellingN.getProduct_message()%></textarea>
								</td>
							</tr>
							<tr>
								<td>
									发布时间:
								</td>
								<td>
									<input type="hidden"  value="<%=sellingN.getPublic_time()%>"	name="PUBLISH_TIME"  >
										<span><%=sellingN.getPublic_time()%></span>
								</td>
							</tr>
							<tr>
								<td>
									更新时间:
								</td>
								<td>
									<input type="hidden" value="<%=sellingN.getUpdate_time()%>"
										name="UPDATE_TIME" >
										<span><%=sellingN.getUpdate_time()%></span>
								</td>
							</tr>
							<tr>
								<td>
									用户ID:
								</td>
								<td>
										<input type="text" value="<%=sellingN.getSaler_id()%>"
										name="SALER_ID" >
								</td>
							</tr>

							<tr>
								<td>
									用户姓名:
								</td>
								<td>
										<input type="text" value="<%=sellingN.getSaler_name()%>"
										name="SALER_NAME" >
								</td>
							</tr>
						<tr>
								<td>
											用户联系方式:
								</td>
								<td>
										<input type="text" value="<%=sellingN.getContact_method()%>"
										name="CONTACT_METHOD" >
								</td>
							</tr>
							<tr>
								<td>
											交易地点:
								</td>
								<td>
										<input type="text" value="<%=sellingN.getTrade_location()%>"
										name="TRADE_LOCATION" >
								</td>
							</tr>
							<tr>
								<td>
									有效期:
								</td>
								<td>
										<input type="text" value="<%=sellingN.getValid_date()%>"
										name="VALID_DATE" >
								</td>
							</tr>
							<tr>
								<td>
									是否有效:
								</td>
							
								<td>
								<select name="ISVAID" >
								<option value="是"  <%if(sellingN.getIsvalid().equals("是")){%>selected="selected"<% } %> >是</option>
								<option value="否"  <%if(sellingN.getIsvalid().equals("否")){%>selected="selected"<% } %> >否</option>
								</select>
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