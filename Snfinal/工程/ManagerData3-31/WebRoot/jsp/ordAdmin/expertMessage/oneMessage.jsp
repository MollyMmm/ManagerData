<%@ page language="java" import="java.util.*,cn.com.adminData.model.ExpertMessageBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

ExpertMessageBean ExpertMessageN = (ExpertMessageBean)request.getAttribute("ExpertMessageN");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'oneMessage.jsp' starting page</title>
    
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
		window.location.href = "<%=path %>/ExchangeShowServlet";
	});
	<%--  编辑--%>
	$("#updateBtn").click(function(){
		window.location.href = "<%=path %>/ExpertMessageSelOneServlet?id="+$("#id").val()+"&state=1";
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
		content:'确定要删除此专家信息吗？',
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
               window.location.href = "<%=path%>/ExpertMessageDeleteServlet?ID="+id;
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
  					<input type="hidden"  value="<%=ExpertMessageN.getId() %>"  id="id"/>
  				
  				  	<span><%=ExpertMessageN.getId() %></span>
  				
  			</tr>
  			<tr>
  				<td>标识ID</td>
  				<td>
  					<span > <%=ExpertMessageN.getExtendedId() %></span>
  			</tr>
  				<tr>
					<td>
						姓名:
					</td>
					<td>
					<span > <%=ExpertMessageN.getNames() %></span>
					</td>
				</tr>
				<tr>
					<td>
						头像:
					</td>
					<td>
					<span > <%=ExpertMessageN.getHead_Portrait() %></span>
					</td>
				</tr>
				<tr>
					<td>
						出生年月:
					</td>
					<td>
					<span > <%=ExpertMessageN.getBirth() %></span>
					</td>
				</tr>
				<tr>
				
				<td>
				专家介绍:
				</td>
				<td>
				<span > <%=ExpertMessageN.getInfo() %></span>
				</td>
				</tr>
				<tr>
					<td>
						专业方向:
					</td>
					<td>
					<span > <%=ExpertMessageN.getMajor() %></span>
					</td>
				</tr>
				<tr>
					<td>
						值班时段:
					</td>
					<td>
					<span > <%=ExpertMessageN.getDutyTime() %></span>
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