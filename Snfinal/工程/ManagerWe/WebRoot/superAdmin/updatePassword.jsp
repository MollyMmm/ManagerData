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
    
    <title>My JSP 'updatePassword.jsp' starting page</title>
    
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
<%-- //验证两次密码是否相同--%>
$(function(){
	$("#passwordSec").blur(function(){
		isSame();
	});
});
//进行判断
 function isSame(){
	if($("#password").val()!=$("#passwordSec").val())
		{
			$("#passwordSpan").html("<font color = 'red'>两次输入的密码不一样，请重新输入！</font>");
			return false;
		}else
		{
			return true;
		}
}
<%--
//验证原密码是否正确 
$(function(){
	$("#passwordOldInput").blur(function(){
		if(!isOld())
			{
				$("#userSpan").html("<font color='red'>原密码输入错误，请重新输入！</font>");
			}
	});
});--%>
<%-- //验证与原密码是否相同--%>
function isOld(){
	ajaxPw();
	if($("#ajax").val()=="1"){
		//输入原密码正确
			return true;
		}else{
			return false;
		}
}
//ajax判断与原密码是否相同，相同 1 ，不同 0 。
function ajaxPw(){
	$.post(
		"<%=path%>/VAilPwAjaxServlet",
				{
					id:$("#uId").val(),
					password:$("#passwordOldInput").val()
				},
				function(data)
				{
					$("#ajax").val(data);
				},
				"text"
				);
}

<%-- //验证新密码不为空（多少位）--%>
$(function(){
	$("#password").blur(function(){
		if(isEmpty())
			{
				$("#passwordFirstSpan").html("<font color='red'>新密码不能为空！</font>");
			}
	});
});
//密码是否为空
function isEmpty(){
	if($("#password").val()==""){
		//输入的新密码不为空
		return true;
	}else{
		return false;
	}
}
<%-- //获取ID--%>
function getId(){
	$("#uId").val(art.dialog.data('id'));
}
<%-- //验证所有--%>
function vailAll(){
	return !isEmpty()&&isSame();
}
<%-- //提交表单--%>
$(function(){
	$("#sumbitBtn").click(function(){
		if(!isOld()){
			alert("原密码输入错误，请重新输入！")
		}else if(vailAll()){
			$("#pageForm").submit();
		}else{
			alert("不满足条件，请修改后提交！");
		}
	});
});
</script>
  </head>
  
  <body onload="getId();">
 <form action="<%=path %>/updatePwServlet" method="post" id="pageForm">
<table>

				<tr>
					<td align="right">
						原密码
					</td>
					<td>
					
						<input type="hidden" name="id" id="uId"/>
						<input type="hidden"  id="ajax"/>
						<input type="password" name="passwordOldInput" id="passwordOldInput"/>
						<span id="userSpan"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						新密码
					</td>
					<td>
						<input type="password" name="password" id="password"/>
						<span id="passwordFirstSpan"><font color = 'red'>*不可为空</font></span>
						
					</td>
				</tr>
				<tr>
					<td align="right">
						再次输入密码
					</td>
					<td>
						<input type="password" name="passwordSec" id="passwordSec"/>
						<span id="passwordSpan"></span>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="确认修改" id="sumbitBtn"/>
					
						<input type="reset" value="重置" />
					
						<input type="button" value="取消" id="cancleBtn"/>
					</td>
				</tr>
			</table>
</form>
  </body>
</html>
