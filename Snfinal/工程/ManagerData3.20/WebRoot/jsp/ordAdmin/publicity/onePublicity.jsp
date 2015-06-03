<%@ page language="java" import="java.util.*,cn.com.adminData.model.PublicityBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

PublicityBean Publicity =(PublicityBean) request.getAttribute("Publicity");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'onePublicity.jsp' starting page</title>
    
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
	
		<link rel="stylesheet" type="text/css"
	href="<%=path%>/artDialog4.1.6/skins/blue.css" />
<script src="<%=path%>/artDialog4.1.6/artDialog.source.js">
</script>
<script src="<%=path%>/artDialog4.1.6/jquery.artDialog.source.js">
</script>
<script src="<%=path%>/artDialog4.1.6/plugins/iframeTools.source.js">
</script>

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
	<%-- 返回--%>
	$("#cancleBtn").click(function(){
		window.location.href = "<%=path %>/PublicityShowServlet";
	});
	<%--  编辑--%>
	$("#updateBtn").click(function(){
		window.location.href = "<%=path %>/PublicitySelOneServlet?id="+$("#id").val()+"&state=1";
	});
		<%-- 删除--%>
	$("#delBtn").click(function(){
		deleteDialog($("#id").val());
	});
});


	function deleteDialog(id){
	 var throughBox = art.dialog.through;
	throughBox({
	    title:'删除',
		content:'确定要删除此政策法规吗？',
		time:1200,
		 //遮罩层
	    lock:true,
	    // 透明度
	    opacity: 0.87,	
	    //不许拖拽
	    drag: false,
	    resize: false,
	    width:'30%',
	    height:'70%',
		button: [
        {
            name: '确定',
            callback: function () {
               window.location.href = "<%=path%>/PubliciityDelServlet?ID="+id;
            },
            focus: true
        },
        {
            name: '取消',
           
        }
    ]
	 });	 
}
</script>
  </head>
 <body>
  		<table class="altrowstable" id="alternatecolor">
  			<tr>
  				<td>ID</td>
  				<td>
  					<input type="hidden"  value="<%=Publicity.getID() %>"  id="id"/>
  				
  				  	<span><%=Publicity.getID() %></span>
  				
  			</tr>
  			<tr>
  					<td>
									标识ID:
								</td>
								<td>
									
										<span><%=Publicity.getID_item() %></span>
								</td>
							</tr>
							<tr>
								<td>
									名字:
								</td>
								<td>
										<span><%=Publicity.getName() %></span>
								</td>
							</tr>
							<tr>
								<td>
									题目:
								</td>
								<td>
									<span><%=Publicity.getTitle() %></span>
								</td>
							</tr>
							<tr>
								<td>
									内容:
								</td>
								<td>
										<span><%=Publicity.getBodys() %></span>
								</td>
							</tr>
							<tr>
								<td>
									类型:
								</td>
								<td>
										<span><%=Publicity.getType() %></span>
								</td>
							</tr>
							<tr>
								<td>
									发布时间:
								</td>
								<td>
										<span><%=Publicity.getStart_time() %></span>>
								</td>
							</tr>
							<tr>

								<td>
									更新时间:
								</td>
								<td>
										<span><%=Publicity.getUpdate_time() %></span>
								</td>
							</tr>
							<tr>
								<td>
									过程:
								</td>
								<td>
										<span><%=Publicity.getProcess() %></span>
								</td>
							</tr>

							<tr>
								<td colspan="2" style="padding-left: 40px;">
									<input type="button" value="编辑" id="updateBtn">
									<input type="button" value="删除" id="delBtn">
							<input type="button" value="返回"  id="cancleBtn">
								</td>
							</tr>
						</table>
	
	</body>
</html>