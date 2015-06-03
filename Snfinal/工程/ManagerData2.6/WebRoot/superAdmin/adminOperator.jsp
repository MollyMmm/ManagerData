<%@ page language="java"
	import="java.util.*,cn.com.manager.model.PageBean" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<Map<String, Object>> list = null;
	String isAjax = "";
	PageBean pageBean = new PageBean();
	if (request.getAttribute("pageBean") != null) {
		//从请求中获取pageBean对象
		pageBean = (PageBean) request.getAttribute("pageBean");
		//获取pageBean对象的结果集
		list = pageBean.getList();
		isAjax = "show";
	} else {

		isAjax = "ajax";
	}
%>

<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'adminOperator.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="X-UA-Compatible" content="IE=7" />

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

		<script type="text/javascript"
			src="<%=path%>/js/jquery.tablesorter.min.js">
</script>


		<script type="text/javascript">
<%--创建--%>
			$(function(){
			$("#create").click(function(){ 
				
				art.dialog.data('create', '1');
				art.dialog.data('userName', $("#user").val());
				art.dialog.data('realName',$("#realName").val());
				art.dialog.data('sex',$("#sex").val());
				//sex'$("#sex").val(),
				art.dialog.data('email',$("#email").val());
				art.dialog.data('tele',$("#tele").val());
				art.dialog.data('creatTime',$("#creatTime").val());
				art.dialog.data('textfield',$("#textfield").val());
				
				adminAdd();
		});
		
});
<%--新增--%>
		$(function(){
			$("#addAdmin").click(function(){ 
				adminAdd();
				});
			});
//增加的弹出层
		function adminAdd(){
			 art.dialog.open('<%=path%>/superAdmin/adminAdd.jsp', {
				title: '添加普通管理员',
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
<%--编辑--%>
function updateDialog(id)
{
	 art.dialog.open('<%=path%>/updateAdminServlet?id='+id, {
				title: '修改普通管理员信息',
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
<%--删除--%>
function deleteDialog(id){
	<%--	
	art.dialog({
				title:'删除',
				content:'确定要删除此管理员吗？',
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
				button: [
		        {
		            name: '确定',
		            callback: function () {
		               window.location.href = "<%=path%>/deleteAdminServlet?id='+id";
		            },
		            focus: true
		        },
		        {
		            name: '取消',
		           
		        }
		    ]
			});
	 --%>
	 var throughBox = art.dialog.through;
	throughBox({
	    title:'删除',
		content:'确定要删除此管理员吗？',
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
               window.location.href = "<%=path%>/deleteAdminServlet?id='+id";
            },
            focus: true
        },
        {
            name: '取消',
           
        }
    ]
	 });
	 
	 
	 
}
<%--全选--%>
		$(function(){
			$("#all").click(function(){
			getCheck();
		});	});
			function getCheck() {
				var all = document.getElementById("all");
				
				var hs = document.getElementsByName("checkbox2");
				for(var i = 0; i < hs.length; i ++) {
					hs[i].checked = all.checked;
					
				}
			}
//焦点离开进行AJAX信息交互
		$(function(){
		$(":text").blur(function ()
		{
			goOtherPage();
		});
	});
		$(function(){
		$("#sex").change(function ()
			{
				searchAdmin();
			});
	});
		<%--//验证输入字符是否合法,拦截单引号---前台的拦截 可以通过伪造绕过----
		function vailFit()
		{
			var vail = $(":text").val();

			if(vail.contains("'"))
			{
				alert("单引号无法识别，请重新输入！");
				
				return false;
				}else{
					return true;
				}
	}--%>
	//跳转拦截不存在页
	function goOtherPage(){
		var total = $("#pageMessAll").html();
		var input = $("#textfield").val();
		
		if(input==""){
			searchAdmin();
		}else if(parseInt(input) <= parseInt(total)){
			searchAdmin();
		}else
		{
			alert("不存在此页，请重新输入！");
		}
	}
<%-- Ajax--%>
	function searchAdmin()
	{
		$.post(
		"<%=path%>/SearchAjaxServlet",
			      //拼接字符串    
				{
					user:$("#user").val(),
					realName:$("#realName").val(),
					sex:$("#sex").find("option:selected").val(),
					//sex:$("#sex").val(),
					email:$("#email").val(),
					tele:$("#tele").val(),
					creatTime:$("#creatTime").val(),
					textfield:$("#textfield").val()
			
				},
				
				function(json) {
					$(".info").remove();
						
							//alert(json);pageTotal
					$("#pageTotal").html(json.total);
					var page = json.total=="0"?"0":json.currentPage;
					$("#pageMess").html(page);
					$("#pageMessAll").html(json.totalPage);
				     
					if(json.list==""){
						//如果没有信息，创建按钮可以用,搜索不能用
						$("#create").attr("disabled",false);
						$("#search").attr("disabled",true);
						
						var user = $("#user").val();
						var realName = $("#realName").val();
						var email = $("#email").val();
						var tele = $("#tele").val();
						var userInfo = user==""?"":"账户为"+user;
						var realNameInfo =realName==""?"":"真实姓名为"+realName;
						var emailInfo = email==""?"":"邮箱地址为"+email;
						var teleInfo = tele==""?"":"手机号为"+tele;
								
						var info =userInfo+realNameInfo+emailInfo+teleInfo;
		
						$("#tab").append( "<tr class='info'><td colspan='7'>您搜索的"+info+"的用户不存在，如需添加请点击创建按钮！</td></tr>");
						
					}else{
						//如果有信息，创建按钮不可以用，搜索能用
						$("#create").attr("disabled",true);
						$("#search").attr("disabled",false);
						//Ajax显示查询到的用户
					$(json).each(function(i,o){
//alert(json.list[i].USERNAME); 
					
					for(i=0;i<o.list.length;i++)
						{
							if(o.list[i]!=undefined)
							{
									$("#tab").append( "<tr class='info'>"
					           
					           +"<td height='20' bgcolor='#FFFFFF'><div align='center' class='STYLE1'>" 
					           +"<div align='center'>"+(o.list[i].USERNAME==undefined?"":o.list[i].USERNAME)
					           +"</div>" 
					           +"</div>" 
					           +"</td>" 
					           +"<td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE1'>"+o.list[i].C_T+ "</span>" +
					           "</div></td>"
					            +"<td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE1'>"+(o.list[i].REALNAME==undefined?"":o.list[i].REALNAME)+ "</span></div></td>"
					            +"<td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE1'>"+(o.list[i].SEX==undefined?"":o.list[i].SEX)+"</span></div></td>"
					            +"<td bgcolor='#FFFFFF'><div align='center'><span class='STYLE1'>"+(o.list[i].EMAIL==undefined?"":o.list[i].EMAIL)+"</span></div></td>"
					            +"<td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE1'>"+(o.list[i].TELE==undefined?"":o.list[i].TELE)+"</span></div></td>"
					            +"<td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE4'>" +
					            "<img src='images/edt.gif' width='16' height='16' />" +
					            "<a href='"+$("#path").text()+"/updateAdminServlet?id="+o.list[i].C_ID+"'>编辑</a>" +
					            "&nbsp; &nbsp;<img src='images/del.gif' width='16' height='16' />" +
					            "<a href='"+$("#path").text()+"/deleteAdminServlet?id='"+o.list[i].C_ID+"'>删除</a>" +
					            "</span>" +
					            "</div>" +
					            "</td>"
					          +"</tr>");  
							}
						}						
					});
						
					}
			
					
			},
				
				"json"
	);
	}
	
<%-- 转到多少页
		 $(function(){
			 $("#goOther").click(function(){
				var total = $("#pageMessAll").val();
				var input = $("#goOther").val();
				if(input<=total){
					searchAdmin();
				}else{
					alert("不存在此页，请重新输入！");
				}
				 
			 });
		 });
--%>
	 <%-- 创建
	$(function(){
		$("#create").click(function(){
			if($(".info").length==0){
				createAdmin();
			}
		});
	});
	function createAdmin()
	{
		if($("#createDiv")!=undefined)
			{
				$("#createDiv").remove();
			}
		
		$("#createDiv").remove();
		$("#page").append(
		"<div id ='createDiv'><form action=<%=path%>/adminAddServlet method='post'>" +
		" <table> 	<caption>普通理员信息</caption><tr><td>" +
		
		"</td></tr><tr><td>账号</td><td>" +
		"<input type='text' name='user' value='"+$("#user").val()+"' /></td>" +
		"<input type='hidden' name='creatTime' value='"+new Date.getTime()+"' /></td></tr>" +
		"<tr><td>密码</td><td>" +
		"<input type='text' name='password' value='"+$("#password").val()+"' /></td></tr>" +
		"<tr><td>邮箱地址</td><td>" +
		"<input type='text' name='email' value='"+$("#email").val()+"' /></td></tr>" +
		"<tr><td>手机号</td><td>" +
		"<input type='text' name='tele' value='"+$("#tele").val()+"' /></td></tr>" +
		"<tr><td>性别</td><td>" +
		"<input type='text' name='sex' value='"+$("#sex").find("option:selected").text() +"' /></td></tr>" +
		"<tr><td>真实姓名 </td><td>" +
		"<input type='text' name='realName' value='"+$("#realName").val()+"' /></td></tr>" +
		"<tr><td><input type='button' value='添加' id='createCon'/></td>" +
		"<td><input type='reset' value='重置' /></td></tr></table>"	
		);
		
		 $("#tab").append( "<tr class='info'>"
			            +"<td height='20' bgcolor='#FFFFFF'><div align='center'><input type='checkbox' name='checkbox2' value='checkbox' />"
			           +" </div></td>"
			           +"<td height='20' bgcolor='#FFFFFF'><div align='center' class='STYLE1'>" 
			           +"<div align='center'>"+$("#user").val()
			           +"</div>" 
			           +"</div>" 
			           +"</td>" 
			           +"<td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE1'></span></div></td>"
			            +"<td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE1'>"+$("#realName").val()+ "</span></div></td>"
			            +"<td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE1'>"+$("#sex").find("option:selected").text()+"</span></div></td>"
			            +"<td bgcolor='#FFFFFF'><div align='center'><span class='STYLE1'>"+$("#email").val()+"</span></div></td>"
			            +"<td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE1'>"+$("#tele").val()+"</span></div></td>"
			            +"<td height='20' bgcolor='#FFFFFF'><div align='center'><span class='STYLE4'>" +
			            "<img src='images/edt.gif' width='16' height='16' />" +
			            "<a >编辑</a>" +
			            "&nbsp; &nbsp;<img src='images/del.gif' width='16' height='16' />" +
			            "<a >删除</a>" +
			            "</span>" +
			            "</div>" +
			            "</td>"
			          +"</tr>");  
						 
	}
	--%>
//确认创建么?
        <%--
        $("createCon").cilck(function(){
        	jPrompt("您确定添加吗?", , "添加", function(info){
        		//----------回调函数
        	});
        	
        });
        --%>
	
	//跳转
		function goPage(btn)
		{
			var id = btn.id;
			var currentPage = document.getElementById("currentPage");
			
			switch(id)
			{
				case "fp":
					currentPage.value = 1;
					break;
				case "pp":
					
						currentPage.value=(parseInt(currentPage.value)>1)?(parseInt(currentPage.value)-1):1;
					
					break;
				case "np":
					currentPage.value=(parseInt(currentPage.value)<<%=pageBean.getTotalPage()%>)?(parseInt(currentPage.value)+1):<%=pageBean.getTotalPage()%>;
					break;
				case "lp":
					currentPage.value = <%=pageBean.getTotalPage()%>;
					break;
			}
			location = "<%=path%>/adminServlet?currentPage="+currentPage.value;
		
		}

		
var highlightcolor = '#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,
var clickcolor = '#51b2f6';

$(function() {

	$(".info").mouseover(function() {
		$(this).children("td").css("background", highlightcolor);
	}).mouseout(function() {
		$(this).children("td").css("background", "#FFFFFF");
	});
});
	
<%-- 排序插件--%>
$(document).ready(function() 
    { 
        $("#tab").tablesorter(); 
    } 
); 
</script>

		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}

.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>

	</head>


	<table align="center" border="0">
		<tr>
			<td class="STYLE1">
				账号:
			</td>
			<td>
				<input type="text" id="user" style="overflow: visible" size="18"
					maxlength="50">

				<input type="hidden" id="password" />
				<input type="hidden" id="isAjax" value="<%=isAjax%>">
				<input type="hidden" id="path" value="<%=path%>">
				<input type="hidden" value="<%=pageBean.getCurrentPage()%>"
					name="currentPage" id="currentPage" />


			</td>


			<td class="STYLE1">
				真实姓名:
			</td>
			<td id="text_style">
				<input type="text" id="realName" size="19" />
			</td>
			<td class="STYLE1">
				性别:
			</td>
			<td>
				<%--<input type="text" id="sex" />--%>

				<select id="sex">
					<option value="男">
						男
					</option>
					<option value="女">
						女
					</option>
					<option value="all" selected="selected">
						全部
					</option>
				</select>


			</td>
		</tr>
		<tr>
			<td class="STYLE1">
				邮箱地址:
			</td>
			<td>
				<input type="text" id="email" size="18" />
			</td>
			<td class="STYLE1">
				手机号:
			</td>
			<td>
				<input type="text" id="tele" size="19" />
			</td>
			<td class="STYLE1">
				创建时间:
			</td>
			<td>
				<input class="Wdate" type="text"
					onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"
					id="creatTime" size="16" />
			</td>
		</tr>

		<tr align="center">
			<td align="center" colspan="6">
				<input type="button" id="search" value="搜索" />
				<input type="button" id="create" value="创建" disabled />

			</td>
		</tr>
	</table>
	<!--
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" background="images/tab_05.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="12" height="30">
							<img src="images/tab_03.gif" width="12" height="30" />
						</td>
						<td>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="23%" valign="middle">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>

												<td width="95%" class="STYLE1">
													<span class="STYLE1">用户账号：</span>
													<input type="text" id="user" style="overflow: visible"
														size="10" maxlength="50">

													<input type="hidden" id="password" />
													<input type="hidden" id="isAjax" value="<%=isAjax%>">
													<input type="hidden" id="path" value="<%=path%>">
													<input type="hidden" value="<%=pageBean.getCurrentPage()%>"
														name="currentPage" id="currentPage" />
												</td>
											</tr>
										</table>
									</td>
									<td width="23%">
										<span class="STYLE1">真实姓名：</span>

										<input type="text" id="realName" size="10" />
									</td>
									<td width="23%">
										<span class="STYLE1">性别：</span>

										<select id="sex">
											<option value="男">
												男
											</option>
											<option value="女">
												女
											</option>
											<option value="all" selected="selected">
												全部
											</option>
										</select>
									</td>
									<td width="23%">
										<span class="STYLE1">手机号码：</span>

										<input type="text" id="tele" size="10" />
									</td>


								</tr>
							</table>
						</td>
						<td width="16">
							<img src="images/tab_07.gif" width="16" height="30" />
						</td>
					</tr>
				</table>
			</td>
		</tr>


		<tr>
			<td height="30" background="images/tab_19.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="12" height="35">
							<img src="images/tab_18.gif" width="12" height="35" />
						</td>
						<td width="100%" height="20">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr >
									<td width="23%">
										<span class="STYLE1">邮箱地址：</span>

										<input type="text" id="tele" size="10" />
									</td>
									<td width="23%">
										<span class="STYLE1">创建时间：</span>

										<input class="Wdate" type="text"
							onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"
							id="creatTime" size="16"  />
									</td>
									<td width="23%">
										<input type="button" id="search" value="搜索" />
										<input type="button" id="create" value="创建" disabled />
									</td>
									<td width="23%">
									</td>

								</tr>
							</table>
						</td>
						<td width="16">
							<img src="images/tab_20.gif" width="16" height="35" />
						</td>
					</tr>
					</table>
</table>

-->

	<div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30" background="images/tab_05.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="30">
								<img src="images/tab_03.gif" width="12" height="30" />
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="46%" valign="middle">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="5%">
														<div align="center">
															<img src="images/tb.gif" width="16" height="16" />
														</div>
													</td>
													<td width="95%" class="STYLE1">
														<span class="STYLE3">管理员信息</span>
													</td>
												</tr>
											</table>
										</td>
										<td width="54%">
											<table border="0" align="right" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="60">
														<table width="90%" border="0" cellpadding="0"
															cellspacing="0">
															<tr>
																<td class="STYLE1">
																	<div align="center">
																		<img src="images/22.gif" width="14" height="14" />
																	</div>
																</td>
																<td class="STYLE1">
																	<div align="center">
																		<%--href="<%=path %>/superAdmin/adminAdd.jsp"  --%>
																		<a href="javascript:void(0)" id="addAdmin">新增 </a>
																	</div>
																</td>
															</tr>
														</table>
													</td>

												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
							<td width="16">
								<img src="images/tab_07.gif" width="16" height="30" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="8" background="images/tab_12.gif">
								&nbsp;
							</td>
							<td>


								<table id="tab" class="tablesorter" width="100%" border="0"
									cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
									<thead>
										<tr>
											<th width="18%" height="22" background="images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">账号</span>
												</div>
											</th>
											<th width="12%" height="22" background="images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">创建时间</span>
												</div>
											</th>
											<th width="14%" height="22" background="images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">真实姓名</span>
												</div>
											</th>
											<th width="4%" background="images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">性别</span>
												</div>
											</th>
											<th width="11%" height="22" background="images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">邮箱</span>
												</div>
											</th>
											<th width="11%" height="22" background="images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">手机号码</span>
												</div>
											</th>
											<th width="15%" height="22" background="images/bg.gif"
												bgcolor="#FFFFFF" class="STYLE1">
												<div align="center">
													基本操作
												</div>
											</th>
										</tr>
									</thead>
									<%--
          <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center">
              <input type="checkbox" name="checkbox" value="checkbox" />
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center">01</div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">34324</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">13813916585</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">2007-11-16 15:00:20 </span></div></td>
            <td bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">tiezhu0902@163.com</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">南京科技股份有限公司…</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4"><img src="images/edt.gif" width="16" height="16" />编辑&nbsp; &nbsp;<img src="images/del.gif" width="16" height="16" />删除</span></div></td>
          </tr>
          --%>

									<tbody>
										<%
														for (int i = 0; i < list.size(); i++) {
															Map<String, Object> map = list.get(i);
													%>

										<tr class="info">

											<td height="20" bgcolor="#FFFFFF">
												<div align="center" class="STYLE1">
													<div align="center"><%=map.get("USERNAME") == null ? "" : map
						.get("USERNAME")%></div>
												</div>
											</td>

											<td height="20" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"><%=map.get("CREATETIME") == null ? "" : map
						.get("CREATETIME")%> </span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"><%=map.get("REALNAME") == null ? "" : map
						.get("REALNAME")%></span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"><%=map.get("SEX") == null ? "" : map.get("SEX")%>
													</span>
												</div>
											</td>
											<td bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"><%=map.get("EMAIL") == null ? "" : map.get("EMAIL")%></span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"><%=map.get("TELE") == null ? "" : map.get("TELE")%></span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE4"><img src="images/edt.gif"
															width="16" height="16" /> <a href="javascript:void(0)"
														id="<%=map.get("ID")%>" onclick="updateDialog(this.id);">编辑</a>&nbsp;<%--<%=path%>/updateAdminServlet?id=<%=map.get("ID")%> --%>
														&nbsp;<img src="images/del.gif" width="16" height="16" /><a
														href="javascript:void(0)" id="<%=map.get("ID")%>"
														onclick="deleteDialog(this.id);">删除</a> <%--<%=path%>/deleteAdminServlet?id=<%=map.get("ID")%>" --%>
													</span>
												</div>
											</td>
										</tr>
										<%
														}
													%>
									</tbody>
								</table>
							</td>
							<td width="8" background="images/tab_15.gif">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>





			<tr>
				<td height="1"></td>
			</tr>
			<tr>
				<td height="35" background="images/tab_19.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="35">
								<img src="images/tab_18.gif" width="12" height="35" />
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td class="STYLE4" id="pageInfo">
											&nbsp;&nbsp; 共有
											<span id="pageTotal"> <%=pageBean.getTotal()%> </span>
											条记录，当前第
											<span id="pageMess"> <%=(pageBean.getTotal() == 0 ? "0" : pageBean
					.getCurrentPage())%></span>/
											<span id="pageMessAll"><%=pageBean.getTotalPage()%> </span> 页

										</td>
										<td>
											<table border="0" align="right" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="40">

														<img src="images/first.gif" width="37" height="15" id="fp"
															onclick="goPage(this);" />
													</td>
													<td width="45">
														<img src="images/back.gif" width="43" height="15" id="pp"
															onclick="goPage(this);" />
													</td>
													<td width="45">
														<img src="images/next.gif" width="43" height="15" id="np"
															onclick="goPage(this);" />
													</td>
													<td width="40">
														<img src="images/last.gif" width="37" height="15" id="lp"
															onclick="goPage(this);" />
													</td>
													<td width="100">
														<div align="center">
															<span class="STYLE1">转到第 <input id="textfield"
																	type="text" size="4"
																	style="height: 12px; width: 20px; border: 1px solid #999999;" />
																页 </span>
														</div>
													</td>
													<td width="40">
														<img src="images/go.gif" width="37" height="15"
															id="goOther" />
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
							<td width="16">
								<img src="images/tab_20.gif" width="16" height="35" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

	</div>
	</body>
</html>