<%@ page language="java"
	import="java.util.*,cn.com.manager.model.PageBean" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	List<Map<String, Object>> user_list = null;
	String isAjax = "";
	//List<Map<String, Object>>
	List<List<Map<String, Object>>> power = null;
	if (request.getAttribute("power") != null) {
		//从请求中获取power 对象
		power = (List<List<Map<String, Object>>>) request
				.getAttribute("power");

		isAjax = "show";
	} else {

		isAjax = "ajax";
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'powerCenter.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script src="<%=path%>/js/jquery.js">
</script>

		<script type="text/javascript"
			src="<%=path%>/My97DatePicker/WdatePicker.js">
</script>

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

//增加的弹出层
		function powerManager(id){
			 art.dialog.open('<%=path%>/PowerServlet?role_id='+id, {
				title: '管理员权限管理',
				time:1200,
				 //遮罩层
			    lock:true,
			    // 透明度
			    opacity: 0.87,	
			    //不许拖拽
			    drag: false,
			    resize: false,
			    width:'30%',
			    height:'80%',
			    init:function() {
					var iframe = this.iframe.contentWindow;
   					var top = art.dialog.top;// 引用顶层页面window对象
				},
				close:function() {
	  					window.location.href = "<%=path%>/PowerShowServlet";
	  				}
				
				});
		}

<%--新增--%>
		$(function(){
			$("#addAdmin").click(function(){ 
				adminAdd();
				});
			});
		//增加的弹出层
		function adminAdd(){
			 art.dialog.open('<%=path%>/superAdmin/adminAdd.jsp', {
				title: '添加权限组',
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
	  					window.location.href = "<%=path%>/adminServlet";
	  				}
				
				});
		}
</script>
	</head>

	<body>

		<input type="hidden" id="isAjax" value="<%=isAjax%>">

		权限组名称
		<input type="text" id="power" name="powerTxt" />
		<input type="button" id="search" value="搜索" />
		<input type="button" id="create" value="创建" disabled />
		<table>
			<tr>
				<th>
					权限组名称
				</th>
				<th>
					范围
				</th>

				<th>
					操作
					<a href="javascript:void(0)" id="addAdmin">新增 </a>
				</th>
			</tr>
			<%
				if (power != null) {
					
					for (int i = 0; i < power.size(); i++) {
						String role =(String)power.get(i).get(0).get("ROLE");
						String powerStr = "";
	System.out.println(role);
						Number role_id =(Number)power.get(i).get(0).get("ID");
	System.out.println(role_id);
						 user_list =(List<Map<String, Object>>) power.get(i);
	System.out.println("1-------1------------");
			%>
			<tr>
				<td>
					<%=role %>
				</td>

				<td>
					<dl>
						<%
					
							for (int j = 0; j < user_list.size(); j++) {
								String name = (String) user_list.get(j).get(
										"POWER");
								
	System.out.println(name);
	System.out.println("2-------2------------");
				%>

						<dt><%=name %>
						</dt>

						<%
					}
						
				%>
					</dl>
				</td>
				<td>
					<a href="javascript:void(0)" id="<%=role_id%>" onclick="powerManager(this.id);">操作</a>
				</td>
			</tr>
			<%
							}
							}
						%>


		</table>
	</body>
</html>
