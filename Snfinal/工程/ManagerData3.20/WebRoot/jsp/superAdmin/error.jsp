<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String message = request.getParameter("message");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/artDialog4.1.6/skins/blue.css" />
	
	<script src="<%=path%>/artDialog4.1.6/artDialog.source.js"></script>
	<script src="<%=path%>/artDialog4.1.6/jquery.artDialog.source.js"></script>
	<script src="<%=path%>/artDialog4.1.6/plugins/iframeTools.source.js"></script>
		
	<script type = "text/javascript">
		function doMessage() {
			var message = document.getElementById("message").value;
			switch(message){
				case "add":{
					art.dialog({
		  				content:"普通管理员添加失败，请重新添加!",
		  				icons:"error",
		  				lock:true,
		  				ok:function() {
		  					art.dialog.close();
		  				}
		  			});
					break;
				}
				case "update":{
					art.dialog({
		  				content:"普通管理员信息更改失败，请重新更改！",
		  				icons:"error",
		  				lock:true,
		  				ok:function() {
		  					art.dialog.close();
		  				}
		  			});
					break;
				}
					case "delete":{
						var throughBox = art.dialog.through;
						throughBox({
			  				content:"删除失败!",
			  				icons:"error",
			  				lock:true,
			  				close:function() {
			  					art.dialog.close();
			  				}
		  			});
					break;
				}
					case "password":{
					art.dialog({
		  				content:"密码修改失败!",
		  				icons:"error",
		  				lock:true,
		  				init:function() {
							var iframe = this.iframe.contentWindow;
		   					var top = art.dialog.top;// 引用顶层页面window对象
						},
		  				ok:function() {
		  					art.dialog.close();
		  					
		  				}
		  			});
					break;
				}
				case "updatePower":{
					art.dialog({
		  				content:"权限修改失败!",
		  				icons:"error",
		  				lock:true,
		  				init:function() {
							var iframe = this.iframe.contentWindow;
		   					var top = art.dialog.top;// 引用顶层页面window对象
						},
		  				ok:function() {
		  					art.dialog.close();
		  					
		  				}
		  			});
					break;
				}				
				case "deletePower":{
					art.dialog({
		  				content:"权限删除失败!",
		  				icons:"error",
		  				lock:true,
		  				init:function() {
							var iframe = this.iframe.contentWindow;
		   					var top = art.dialog.top;// 引用顶层页面window对象
						},
		  				ok:function() {
		  					art.dialog.close();
		  					
		  				}
		  			});
					break;
				}
			}
			
		}
	</script>
  </head>
  
  <body onload = "doMessage();">
  		<input type = "hidden" value = "<%=message %>" id = "message" />
  </body>
</html>

