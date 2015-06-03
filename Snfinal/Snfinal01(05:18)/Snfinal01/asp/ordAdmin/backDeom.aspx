<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="backDeom.aspx.cs" Inherits="Snfinal01.asp.ordAdmin.backDeom" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html>
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=7" />

	<title>抚松三农后台管理</title>

		<link rel="stylesheet" href="../../css/index.css" type="text/css"
			media="screen" />

		<script type="text/javascript" src="../../js/jquery.min.js">
</script>
		<script type="text/javascript" src="../../js/tendina.min.js">
</script>
		<script type="text/javascript" src="../../js/common.js">
</script>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
        <form runat="server" id="form1">
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
									href="./../login/login.aspx"><i class="icon-signout glyph-icon"></i>
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
							<%-- <a href="javascript:openDivWindow('page_content','公告管理','page.aspx?page=notice')" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>公告管理</a>--%>
                    <a href="./page.aspx?page=notice" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>公告管理</a>
						</li>
						<li>
							<a href="./page.aspx?page=publicity" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>政策管理</a>
						</li>
                        <%--
                            <li>
							<a href="./page.aspx?page=selling" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>农资采购</a>
						</li>
							<li>
							<a href="./page.aspx?page=farming" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>农事提醒</a>
						</li>
                             --%>
						
							<li>
							<a href="./page.aspx?page=news" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>时事新闻</a>
						</li>
					</ul>
				</li>
				<li class="childUlLi">
					<a href="user.html" target="menuFrame"> <i
						class="glyph-icon icon-reorder"></i>信息管理</a>
					<ul>
						<%--
                            <li>
							<a href="./page.aspx?page=soil" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>出让土地信息</a>
						</li>
					
						<li>
							<a href="./page.aspx?page=suply" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i> 供求信息</a>
						</li>
                             --%>
						
						  <li>
                             <%-- <iframe height="100%" width="100%" frameborder="0" name="center" src="page.aspx">土地信息
                                  </iframe>--%>

							<a href="./page.aspx?page=soilmessage" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>土地信息</a>
						</li>
                          <li>
							<a href="./page.aspx?page=goodsmessage" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>商品信息</a>
						</li>
                          <li>
							<a href="./page.aspx?page=yellowpage" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>黄页信息</a>
						</li>
                          <li>
							<a href="./page.aspx?page=advertisment" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>广告信息</a>
						</li>
						<li>
							<a href="./page.aspx?page=technical" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>技术信息</a>
						</li>
						<li>
							<a href="./page.aspx?page=expertmessage" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>专家信息</a>
						</li>
					</ul>
				</li>
					
				<li class="childUlLi">
					<a href="#"> <i class="glyph-icon  icon-location-arrow"></i>论坛互动管理</a>
					<ul>
						<li>`
							<a href="./page.aspx?page=postMessage" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>农民发帖</a>
						</li>
						<li>
							<a href="./page.aspx?page=feedback" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>反馈问题</a>
						</li>

					</ul>
				</li>
			</ul>
		</div>
		<!--菜单-->
		<div id="layout_right_content" class="layout_right_content">

			<div class="route_bg">
				<a href="javascript:void(0)" target="menuFrame">主页</a><i
					class="glyph-icon icon-chevron-right"></i>
				<a href="javascript:void(0)">菜单管理</a>
			</div>
			<div class="mian_content">
				<div id="page_content">
                
                        <iframe id="menuFrame" name="menuFrame" src="./page.aspx?page=notice"
						style="width:100%;height:100%;" scrolling="yes"   frameborder="0"
						></iframe>
                        
					
				</div>
			</div>
		</div>
		<div class="layout_footer">
			<p>
				© 2015 - 物联网与云计算
			</p>
		</div>
            </form>
        <%-- 
            <script language="javascript">

    window.onload = function ()
    {

        window.frames["menuFrame"].location.reload()

    }


</script>
            --%>

	</body>
   
</html>