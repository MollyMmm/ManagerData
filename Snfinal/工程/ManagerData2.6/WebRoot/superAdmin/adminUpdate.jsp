<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Map<String,Object> map = (Map<String,Object>)request.getAttribute("map");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminUpdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/artDialog4.1.6/skins/blue.css" />
	<script src="<%=path%>/js/jquery.js"></script>
	<script src="<%=path%>/artDialog4.1.6/artDialog.source.js"></script>
	<script src="<%=path%>/artDialog4.1.6/plugins/iframeTools.source.js"></script>
<script type="text/javascript">
<%--//按钮：取消--关闭此对话框  --%>
$(function(){
	$("#cancleBtn").click(function(){
		art.dialog.close();
	});
	});
<%-- //加载时,根据传递来的值确定性别--%>
function postSex(){
	var PostSex = $("#postSex").val();
	if(PostSex=="男"){
		$("#man").attr("checked","checked");
	}else{
		$("#woman").attr("checked","checked");
	}
}
<%-- //修改密码--弹窗     --%>
function updateP(id){
	art.dialog.data('id', id);
		art.dialog.open('<%=path%>/superAdmin/updatePassword.jsp', {
				title: '修改普通管理员密码',
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
				
			});
	}

</script>
  </head>
  
  <body onload="postSex();">
<form action="<%=path %>/ConUpdateAdminServlet" method="post">
<table>
			<caption>
				普通理员信息
			</caption>
			<tr>
					<td>
						<input type="hidden" name="id" value="<%=map.get("ID")%>" />
					</td>
				</tr>

				<tr>
					<td align="right">
						账号
					</td>
					<td>
						<input type="text" name="user" value="<%=map.get("USERNAME")==null?"":map.get("USERNAME")%>" readonly/>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						邮箱地址
					</td>
					<td>
						<input type="text" name="email" value="<%=map.get("EMAIL")==null?"":map.get("EMAIL")%> " />
					</td>
				</tr>
				<tr>
					<td align="right">
						手机号
					</td>
					<td>
						<input type="text" name="tele" value="<%=map.get("TELE")==null?"":map.get("TELE")%>" />
					</td>
				</tr>
				<tr>
					<td align="right">
						 性别
					</td>
					<td>
						<input type="hidden" name="sex" id="postSex" value="<%=map.get("SEX")==null?"":map.get("SEX")%>" />
						<input type="radio" name="sex" value="男"  id="man"/>男
						<input type="radio" name="sex" value="女" id="woman"/>女
					</td>
				</tr>
				<tr>
					<td align="right">
						真实姓名 
					</td>
					<td>
						<input type="text" name="realName" value="<%=map.get("REALNAME")==null?"":map.get("REALNAME")%>" />
					</td>
				</tr>
				<tr><td colspan="2">
						<a href="javascript:void(0)" id="<%=map.get("ID")%>" onclick="updateP(this.id)">修改密码</a>
					</td>
				</tr>
			<tr><td colspan="2" align="center">
						<input type="submit" value="确认修改" />
					
						<input type="reset" value="重置" />
					
						<input type="button" value="取消" id="cancleBtn"/>
					</td>
				</tr>
			</table>
</form>
	</body>
 
</html>
