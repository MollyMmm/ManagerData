<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String loginInfo = "";
	if (request.getAttribute("strInfo") != null) {
		System.out.println(request.getAttribute("strInfo").toString());
		loginInfo = request.getAttribute("strInfo").toString();
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<link rel="stylesheet" href="<%=path%>/css/add.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/index.css" type="text/css" media="screen" />

<script src="<%=path%>/js/jquery.js">
</script>
<script type="text/javascript">
<%--获取验证码--%>
function getNewRandom(){
			document.getElementById("randImg").src = "<%=path%>/images/random.jsp?time="
			+ Math.random();
	}
</script>

</head>
<body onload="getNewRandom();">
 <div class="layout_top_header">
            <div style="float: left"><span style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #8d8d8d">抚松县管理后台</span></div>
    </div>
  <div style="background-color: rgb(228,228,228);height: 100%;">
<table width="100%" height="80%" border="0" cellspacing="0"
	cellpadding="0">
<tr>
		<td align="center" valign="middle">
		<form action="<%=path%>/LoginServlet" method="post">
		<table>
		<tr>
		<td>
		
		<div class="control-group">
				<label class="laber_from"> 用户名 </label>
				<div class="controls">
					<input class="input_from" type="text" name="UserName" placeholder="请输入账号">
					<p class=help-block></p>
				</div>
		</td>
		</tr>
		<tr>
		<td>
		<div class="control-group">
				<label class="laber_from"> 密码 </label>
				<div class="controls">
					<input class="input_from" type="password" placeholder=" 请输入密码"
						name="password">
					<p class=help-block></p>
				</div>
			</div>
		</td>
		</tr>
		<tr>
		<td>
		<div id="random">
			<label class="laber_from"> 验证码</label>
							<input name="randomTxt" type="text" size="4" /> 
							<br>
							<a
					href="javascript:void(0)" onclick="getNewRandom()"><img
					id="randImg" src="<%=path%>/images/random.jsp" /> </a>
							
			</div>
			<div id="error-tip">
				<span id="infoSpan"> <font size='2' color='red'><%=loginInfo%></font>
				</span>
			</div>
		</td>
		</tr>
		<tr>
		<td>
		<div class="control-group">
				<label class="laber_from"></label>
				<div class="controls">
					<input type="submit" class="btn btn-success"
						style="width: 120px; background-color: orange" value="提交" /> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" class="btn btn-success"
						style="width: 120px; background-color: orange" value="重置" />
				</div>
			</div>
		</td></tr>
		
		</table>
		</form>
		</td>
		</tr>
		</table>
 </div>
</body>
</html>
