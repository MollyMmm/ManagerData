<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>土地信息添加页面</title>
    
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
			<form method="post" action="<%=path%>/SoilMessageAddServlet">
				<table class="altrowstable" id="alternatecolor">
					<tr>
						<td>
							ID:
						</td>
						<td><input type="text" name="id"></td>
						<td>
							标识:
						</td>
						<td><input type="text" name="extendedid"></td>
					</tr>
					<tr>
						<td>
							土地名称:
						</td>
						<td><input type="text" name="names"></td>
						<td>
							图片:
						</td>
						<td><input type="text" name="picture"></td>
					</tr>
					<tr>
						<td>
							价格:
						</td>
						<td><input type="text" name="price"></td>
						<td>
							流转性质:
						</td>
						<td><input type="text" name="conversionproperty"></td>
					</tr>
					<tr>
						<td>
							土地面积:
						</td>
						<td><input type="text" name="soilarea"></td>
						<td>
							可流转年限:
						</td>
						<td><input type="text" name="negotiableyear"></td>
					</tr>
					<tr>
						<td>
							剩余年限:
						</td>
						<td><input type="text" name="surplusyear"></td>
						<td>
							土地权证:
						</td>
						<td><input type="text" name="landwarrants"></td>
					</tr>
					<tr>
						<td>
							用途:
						</td>
						<td><input type="text" name="soilusing"></td>
						<td>
							土地类型:
						</td>
						<td><input type="text" name="type"></td>
					</tr>
					<tr>
					<td colspan="4" style="padding-left: 190px;">
									<input type="submit" value="添加">
									<a href="<%=path%>/MessageShowServlet"><input
											type="button" value="取消"> </a></tr>
					
				</table>
			</form>
		</td></tr></table>  </body>
</html>
