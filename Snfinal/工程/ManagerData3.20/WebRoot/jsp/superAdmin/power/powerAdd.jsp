<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'powerAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="<%=path %>/dtree/dtree.css">
		<script type="text/javascript" src="<%=path %>/dtree/dtree-ck.compress.js"></script>
		<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
		<script type="text/javascript">
			var d = new dTree('d');
			d.config.check=true;
			/*添加checkbox节点方法完整参数说明
			addCbx(id, pid, name, open, checked, icon, iconOpen)
			id: 节点id（必须唯一，不能重复）, 
			pid: 父级节点id, 
			name: 节点名称 ,
			open: 打开（是：true/否：false）,
			checked: 选中（是：true/否：false/无：'none'）,
			icon: 节点图标 ,
			iconOpen: 节点打开时图标
			*/
			d.addCbx(0,-1,'系统菜单');
			d.addCbx(100,0,'系统管理',true);//打开节点
			d.addCbx(790,100,'菜单管理');
			d.addCbx(800,100,'组织机构');
			d.addCbx(810,100,'用户管理',false,'none');//无checkbox
			d.addCbx(102,0,'系统机构');
			d.addCbx(300,102,'人员管理');
			d.addCbx(301,102,'部门管理');
			d.addCbx(302,102,'机构管理');
			d.addCbx(103,0,'权限管理');
			d.addCbx(400,103,'角色维护');
			d.addCbx(401,103,'功能分配');
			d.addCbx(402,103,'角色分配');	 
			document.write(d);
		</script>
  </head>
  
  <body><%--
		权限组名称
		<input type="text" id="power" name="powerTxt" />
		有效天数
		<select id="sex">
					<option value="1天">
						1天
					</option>
					<option value="2天">
						2天
					</option>
					<option value="10天" selected="selected">
						10天
					</option>
				</select>
		
		<input type="button" id="addDay" value="添加天数组别" onclick=""/>
		
  --%></body>
</html>
