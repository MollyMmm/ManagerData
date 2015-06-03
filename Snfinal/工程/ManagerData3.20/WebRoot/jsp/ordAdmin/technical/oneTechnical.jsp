<%@ page language="java" import="java.util.*,cn.com.adminData.model.TechnicalBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

TechnicalBean TechnicalM = (TechnicalBean)request.getAttribute("technical");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'oneTechnical.jsp' starting page</title>
    
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
		window.location.href = "<%=path %>/TechnicalServlet";
	});
	<%--  编辑--%>
	$("#updateBtn").click(function(){
		window.location.href = "<%=path %>/TechnicalSelOneServlet?id="+$("#id").val()+"&state=1";
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
		content:'确定要删除此科技信息吗？',
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
               window.location.href = "<%=path%>/TechnicalDelServlet?ID="+id;
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
  					<input type="hidden"  value="<%=TechnicalM.getId() %>"  id="id"/>
  				
  				  	<span><%=TechnicalM.getId() %></span>
  				
  			</tr>
  			<tr>
  				<td>标识ID</td>
  				<td>
  					<span > <%=TechnicalM.getExtendedid() %></span>
  			</tr>
  			<tr>
  				<td>题目</td>
  				<td>
  					<span><%=TechnicalM.getTitle()%></span>
  				</td>
  			</tr>
  					<tr>
  				<td>科技类型</td>
  				<td>
  					<span><%=TechnicalM.getType() %></span>
  				</td>
  			</tr>
  			<tr>
  				<td>内容</td>
  				<td>	
  				<span><%=TechnicalM.getBody() %></span>
  				</td>
  			</tr>
  			<tr>
  				<td>发布时间</td>
  				<td>
  					<span><%=TechnicalM.getPublishtime() %></span>
  			</tr>
  			<tr>
  				<td>发布者</td>
  				<td>
  					<span><%=TechnicalM.getName() %></span>
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