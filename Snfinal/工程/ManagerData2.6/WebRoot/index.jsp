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
	System.out.println(loginInfo);
%>


		<!DOCTYPE html>
<html lang="en">
<head>

<base href="<%=basePath%>">
<meta charset="utf-8" />
<title>万良新农村建设农民生产生活服务平台</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<link href="./css/bootstrap-responsive.min.css" rel="stylesheet" />
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
	rel="stylesheet" />
<link href="./css/font-awesome.css" rel="stylesheet" />
<link href="./css/adminia.css" rel="stylesheet" />
<link href="./css/adminia-responsive.css" rel="stylesheet" />
<link href="./css/pages/login.css" rel="stylesheet" />

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
		  	<script type="text/javascript">
function focusTest(t) {
	t.value = "";
	t.style.color = "#000000";
}
<%--获取验证码--%>
function getNewRandom(){
			document.getElementById("randImg").src = "<%=path %>/images/random.jsp?time="+Math.random();
		}
</script>
    
</head>

<body style="background-color: rgb(235, 247, 253)">

	<div class="navbar navbar-fixed-top">

		<div class="navbar-inner" style="background-color: rgb(69, 75, 84)">

			<div class="container">
				<a class="btn btn-navbar" > <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" style="font-size: 30px">万良新农村建设农民生产生活服务平台</a>

			</div>
			<!-- /container -->

		</div>
		<!-- /navbar-inner -->

	</div>
	<!-- /navbar -->


	<div id="login-container">


		<div id="login-header" style="background-color: white ">

			<h3>登录</h3>

		</div>
		<!-- /login-header -->

		<div id="login-content" class="clearfix">

			<form action="<%=path%>/LoginServlet" method="post">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="UserName">用户名</label>
						<div class="controls">
							<input type="text"  name="UserName" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">密码</label>
						<div class="controls">
							<input type="password"  id="password" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="yanzheng">验证码</label>
						
						
					<!-- !!!!!!!!!!!!!!!验证码!!!!!!!!!!!!! -->				
						
						<div>
							<input  type="text" name="randomTxt" id="yanzheng" size="10px"/>
							<a href="javascript:void(0)" onclick="getNewRandom()"><img
											id="randImg" src="<%=path%>/images/random.jsp" />
									</a>
										
						</div>
					</div>
					
					<!-- !!!!!!!!!!!!!!!错误提示!!!!!!!!!!!!! -->
					<div id="error-tip">
						<span id="infoSpan"> <font size='2' color='red'><%=loginInfo%></font></span>
					</div>
				</fieldset>
				<div id="remember-me" class="pull-left">
					<input type="checkbox" name="remember" id="remember" /> <label
						id="remember-label" for="remember">记住用户名</label>
				</div>
				<div class="pull-right">
					<button type="submit" class="btn btn-warning btn-large">登录</button>
					
					<button type="reset" class="btn btn-warning btn-large" >重置</button>
				</div>
			</form>

		</div>
		<!-- /login-content -->



	
	<!-- /login-wrapper -->




</div>
</body>
</html>