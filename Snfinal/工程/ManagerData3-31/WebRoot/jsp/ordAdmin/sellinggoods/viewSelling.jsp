<%@ page language="java" import="java.util.*,cn.com.adminData.model.SellingGoodsBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

SellingGoodsBean sellingM = (SellingGoodsBean)request.getAttribute("selling");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewSelling.jsp' starting page</title>
    
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
	window.location.href = "<%=path%>/SellingServlet";
}

function addMore(){
		var id = document.getElementById("id").value;
	window.location.href = "<%=path%>/SellingDelServlet?id="+id;
}
</script>
  </head>
  
  <body>
  		<table class="altrowstable" id="alternatecolor">
  			<tr>
  				<td>ID</td>
  				<td>
  					<input type="hidden"  value="<%=sellingM.getId() %>"  id="id"/>
  				
  				  	<span><%=sellingM.getId() %></span>
  				
  			</tr>
  			<tr>
  				<td>标识ID</td>
  				<td>
  					<span > <%=sellingM.getExtendedid() %></span>
  			</tr>
  			<tr>
  				<td>题目</td>
  				<td>
  					<span><%=sellingM.getTitle()%></span>
  				</td>
  			</tr>
  					<tr>
  				<td>商品信息</td>
  				<td>
  					<span><%=sellingM.getProduct_message() %></span>
  				</td>
  			</tr>
  			<tr>
  				<td>发布时间</td>
  				<td>	
  				<span><%=sellingM.getPublic_time() %></span>
  				</td>
  			</tr>
  			<tr>
  				<td>更新时间</td>
  				<td>
  					<span><%=sellingM.getUpdate_time() %></span>
  			</tr>
  			<tr>
  				<td>用户ID</td>
  				<td>
  					<span><%=sellingM.getSaler_id() %></span>
  			</tr>
  			<tr>
  				<td>用户姓名</td>
  				<td>
  					<span><%=sellingM.getSaler_name() %></span>
  			</tr>
  			<tr>
  				<td>用户联系方式</td>
  				<td>
  					<span><%=sellingM.getContact_method()%></span>
  			</tr>
  			<tr>
  				<td>有效期</td>
  				<td>
  					<span><%=sellingM.getValid_date() %></span>
  			</tr>
  		<tr>
  				<td>是否有效</td>
  				<td>
  					<span><%=sellingM.getIsvalid()%></span>
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

