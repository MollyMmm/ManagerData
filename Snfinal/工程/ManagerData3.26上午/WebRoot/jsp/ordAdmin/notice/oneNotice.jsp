<%@ page language="java" import="java.util.*,cn.com.adminData.model.NoticeBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

NoticeBean NoticeM = (NoticeBean) request.getAttribute("NoticeN");
List<Map<String,Object>> typeList = (List<Map<String,Object>>)request.getAttribute("type");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'oneNotice.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
		window.location.href = "<%=path %>/NoticeShowServlet";
	});
	<%--  编辑--%>
	$("#updateBtn").click(function(){
		window.location.href = "<%=path %>/NoticeSelOneServlet?id="+$("#id").val()+"&state=1";
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
		content:'确定要删除此公告信息吗？',
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
               window.location.href = "<%=path%>/NoticeDelServlet?ID="+id;
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
 <table width="100%" height="80%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="center" valign="middle">
					<table class="altrowstable" id="alternatecolor">
							<tr>
								<td >
									Id:
								</td>
								<td>
									<input type="hidden" value="<%=NoticeM.getID()%>" id="id" >
										<span><%=NoticeM.getID() %></span>
								</td>
							</tr>
							<tr>
								<td >
									标识Id:
								</td>
								<td>
									<span > <%=NoticeM.getExtendedId() %></span>
								</td>
							</tr>
							<tr>
								<td>
									题目:
								</td>
								<td>
									<span><%=NoticeM.getTitle()%></span>
								</td>
							</tr>
							<tr>
								<td>
									内容:
								</td>
								<td>
									<span><%=NoticeM.getBody() %></span>
								</td>
							</tr>
							<tr>
								<td>
									梗概:
								</td>
								<td>
								<span><%=NoticeM.getMainBody() %></span>
								</td>
							</tr>
							<tr>
								<td>
									发布时间:
								</td>
								<td>
									<span><%=NoticeM.getPublishTime() %></span>
								</td>
							</tr>
							<tr>
								<td>
									更新时间:
								</td>
								<td>
									<span><%=NoticeM.getUpdateTime() %></span>
								</td>
							</tr>
							<tr>
								<td>
									图片|视频:
								</td>
								<td>
									<span><%=NoticeM.getPicture() %></span>
								</td>
							</tr>
							<tr>
								<td>
									公告类型:
								</td>
								<td>
									
										<span >
									<% for(int i =0;i<typeList.size();i++){
													if(NoticeM.getType()==Integer.parseInt(typeList.get(i).get("ID").toString())){%>
												<%= typeList.get(i).get("ID")%><%=typeList.get(i).get("TYPENAME") %>
													<%}
										} %>
									</span>
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
			</td></tr>
		</table>
	</body>
</html>