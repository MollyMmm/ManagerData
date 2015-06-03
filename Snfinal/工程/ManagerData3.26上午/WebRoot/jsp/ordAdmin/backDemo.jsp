<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=7" />
		<base href="<%=basePath%>">

		<title>抚松三农后台管理</title>

		<link rel="stylesheet" href="css/index.css" type="text/css"
			media="screen" />

		<script type="text/javascript" src="js/jquery.min.js">
</script>
		<script type="text/javascript" src="js/tendina.min.js">
</script>
		<script type="text/javascript" src="js/common.js">
</script>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		<!--顶部-->
		<div class="layout_top_header">
			<div style="float: left">
				<h1>
					<span
						style="font-size: 16px; line-height: 45px; padding-left: 20px; color: #8d8d8d">抚松三农管理后台

					</span>
				</h1>
			</div>
			<div id="ad_setting" class="ad_setting">
				<a class="ad_setting_a" href="javascript:; "> <i
					class="icon-user glyph-icon" style="font-size: 20px"></i> <span>管理员</span>
					<i class="icon-chevron-down glyph-icon"></i> </a>
				<ul class="dropdown-menu-uu" style="display: none"
					id="ad_setting_ul">
					<li class="ad_setting_ul_li">
						<a href="javascript:;"><i class="icon-user glyph-icon"></i>
							个人中心 </a>
					</li>
					<li class="ad_setting_ul_li">
						<a href="javascript:;"><i class="icon-cog glyph-icon"></i> 设置
						</a>
					</li>
					<li class="ad_setting_ul_li">
						<a onclick="if (confirm('确定要退出吗？')) return true; else return false;"
									href="<%=path %>/jsp/login/login.jsp"><i class="icon-signout glyph-icon"></i>
							<span class="font-bold">退出</span> </a>
					</li>
				</ul>
			</div>
		</div>
		<!--顶部结束-->
		<!--菜单-->
		<div class="layout_left_menu">
			<ul id="menu">
				<li class="childUlLi">
					<a href="main.html" target="menuFrame"><i
						class="glyph-icon icon-home"></i>首页</a>
					<ul>
					<li>
							<a href="<%=path%>/ExchangeShowServlet" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>积分奖励</a>
						</li>
						<li>
							<a href=""  target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>兑换日志</a>
						</li>
						<li>
							<a href="<%=path%>/NoticeShowServlet" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>公告管理</a>
						</li>
						<li>
							<a href="<%=path%>/PublicityShowServlet" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>政策管理</a>
						</li>

					</ul>
				</li>
				<li class="childUlLi">
					<a href="user.html" target="menuFrame"> <i
						class="glyph-icon icon-reorder"></i>信息管理</a>
					<ul>
						
						<li>
							<a href="<%=path%>/SoilMessageSearchServlet" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>出让土地信息</a>
						</li>
						
						<li>
							<a href="<%=path %>/YellowShowServlet"  target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>村村通</a>
						</li>
						<li>
							<a href="<%=path %>/GoodsMessageShowServlet" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i> 商铺信息</a>
						</li>
						<!--
						<li>
							<a href="<%=path%>/MessageShowServlet" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>土地信息</a>
						</li>
						-->
						<li>
							<a href="<%=path%>/ExpertMessageServlet" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>专家信息</a>
						</li>
					</ul>
				</li>
					<!--
				<li class="childUlLi">
					<a href="role.html" target="menuFrame"> <i
						class="glyph-icon icon-reorder"></i>耕种管理</a>
					<ul>
						<li>
							<a href="<%=path %>/PloughShowServlet" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>耕地检测</a>
						</li>

					</ul>
				</li>
				-->
				<li class="childUlLi">
					<a href="#"> <i class="glyph-icon  icon-location-arrow"></i>论坛互动管理</a>
					<ul>
						<li>
							<a href="<%=path%>/PrivateConsultServlet" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>私人咨询</a>
						</li>
						<li>
							<a href="<%=path%>/PostMessageServlet" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>论坛发帖</a>
						</li>
						<li>
							<a href="<%=path %>/FeedbackShowServlet" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>反馈问题</a>
						</li>

					</ul>
				</li>
			</ul>
		</div>
		<!--菜单-->
		<div id="layout_right_content" class="layout_right_content">

			<div class="route_bg">
				<a href="<%=path%>/index.jsp" target="menuFrame">主页</a><i
					class="glyph-icon icon-chevron-right"></i>
				<a href="#">菜单管理</a>
			</div>
			<div class="mian_content">
				<div id="page_content">
					<iframe id="menuFrame" name="menuFrame" src="<%=path%>/ExchangeShowServlet"
						"style="overflow: visible;" scrolling="yes" frameborder="0"
						width="100%" height="100%"></iframe>
				</div>
			</div>
		</div>
		<div class="layout_footer">
			<p>
				© 2015 - 物联网与云计算
			</p>
		</div>
	</body>
</html>
