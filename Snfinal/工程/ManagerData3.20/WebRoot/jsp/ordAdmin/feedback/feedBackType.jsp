<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<Map<String,Object>> typeList = (List<Map<String,Object>>)request.getAttribute("type");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'feedBackType.jsp' starting page</title>
    
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

		<script type="text/javascript">
		
		<%--删除--%>
function deleteDialog(id){
	 var throughBox = art.dialog.through;
	throughBox({
	    title:'删除',
		content:'确定要删除此反馈类型吗？',
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
               window.location.href = "<%=path%>/FeedBackTypeDelServlet?ID="+id;
            },
            focus: true
        },
        {
            name: '取消',
        }
    ]
	 });	 	 
}
	<%--增加--%>
		function addType(){
			 art.dialog.open('<%=path%>/jsp/ordAdmin/feedback/feedBackTypeAdd.jsp', {
				title: '添加反馈类型',
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
			    init:function() {
					var iframe = this.iframe.contentWindow;
   					var top = art.dialog.top;// 引用顶层页面window对象
				},
				close:function() {
	  				window.location.href = "<%=path%>/FeedbackTypeServlet?type=type";
	  			}
				
				});
		}

		</script>
  </head>

	<body>
		<table>
			<tr>
				<th>ID</th>
				<th>公告类型</th>
				<th>操作</th>
			</tr>
			<%
							for (int i = 0; i < typeList.size(); i++) {
								Map<String, Object> type = typeList.get(i);
							
						%><tr>

							<td><%=type.get("ID")%></td>
							<td><%=type.get("TYPENAME")%></td>
							
							<td>
							
								<a href="javascript:void(0)" id="<%=type.get("ID")%>" onclick="deleteDialog(this.id)">删除</a>
							</td>
						</tr>
						<%
							}
						%>
						<tr><td colspan="3">
						<input type="button" value="添加其他反馈类型"  onclick="addType();"/>
						</td></tr>
		</table>
	</body>
</html>

