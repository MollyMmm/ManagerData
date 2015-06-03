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
    
    <title>My JSP 'message.jsp' starting page</title>
    
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
				case "del":{
						var throughBox = art.dialog.through;
						throughBox({
			  				content:"操作成功!",
			  				icons:"succeed",
			  				time:"2",
			  				lock:true,
			  				close:function() {
			  					window.location.href = "<%=path%>/NoticeTypeServlet?type=type";
			  				}
		  				});
					break;
				}
				case "add":{
						var throughBox = art.dialog.through;
						throughBox({
			  				content:"操作成功!",
			  				icons:"succeed",
			  				time:"2",
			  				lock:true,
			  				close:function() {
			  					art.dialog.close();
			  				}
		  				});
					break;
				}
				case "feedBackDel":{
						var throughBox = art.dialog.through;
						throughBox({
			  				content:"删除反馈类型成功!",
			  				icons:"succeed",
			  				time:"2",
			  				lock:true,
			  				close:function() {
			  					window.location.href = "<%=path%>/FeedBackTypeServlet?type=type";
			  				}
		  				});
					break;
				}
				case "yellowDel":{
						var throughBox = art.dialog.through;
						throughBox({
			  				content:"删除黄页信息成功!",
			  				icons:"succeed",
			  				time:"2",
			  				lock:true,
			  				close:function() {
			  					window.location.href = "<%=path%>/YellowShowServlet";
			  				}
		  				});
					break;
				}
				case "technicalDel":{
						var throughBox = art.dialog.through;
						throughBox({
			  				content:"操作成功!",
			  				icons:"succeed",
			  				time:"2",
			  				lock:true,
			  				close:function() {
			  					window.location.href = "<%=path%>/TechnicalServlet";
			  				}
		  				});
					break;
				}
				case "technicalAdd":{
						var throughBox = art.dialog.through;
						throughBox({
			  				content:"操作成功!",
			  				icons:"succeed",
			  				time:"2",
			  				lock:true,
			  				close:function() {
							art.dialog.close();
			  				window.location.href = "<%=path%>/TechnicalServlet";
			  				}
		  				});
					break;
				}
				
					case "farmingDel":{
						var throughBox = art.dialog.through;
						throughBox({
			  				content:"操作成功!",
			  				icons:"succeed",
			  				time:"2",
			  				lock:true,
			  				close:function() {
							art.dialog.close();
			  					window.location.href = "<%=path%>/FarmingServlet";
			  				}
		  				});
					break;
				}
					
						case "sellingDel":{
						var throughBox = art.dialog.through;
						throughBox({
			  				content:"操作成功!",
			  				icons:"succeed",
			  				time:"2",
			  				lock:true,
			  				close:function() {
							art.dialog.close();
			  					window.location.href = "<%=path%>/SellingServlet";
			  				}
		  				});
					break;
				}
					case "expertDel":{
						var throughBox = art.dialog.through;
						throughBox({
			  				content:"操作成功!",
			  				icons:"succeed",
			  				time:"2",
			  				lock:true,
			  				close:function() {
							art.dialog.close();
			  					window.location.href = "<%=path%>/ExpertShowServlet";
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
