<%@ page language="java"
	import="java.util.*,cn.com.managerData.model.PageBean"
	pageEncoding="UTF-8"%>
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

<link rel="stylesheet" href="css/table.css" type="text/css"
	media="screen" />


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
			 art.dialog.open('<%=path%>/jsp/superAdmin/adminAdd.jsp', {
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
	  					window.location.href = "<%=path%>/AdminServlet";
	  				}
				
				});
		}
<%--编辑--%>
function updateDialog(id)
{
	 art.dialog.open('<%=path%>/UpdateAdminServlet?id='+id, {
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
					window.location.href = "<%=path%>/AdminServlet";
				}
			});
}
<%--删除--%>
function deleteDialog(id){
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
               window.location.href = "<%=path%>/DeleteAdminServlet?id="+id;
            },
            focus: true
        },
        {
            name: '取消',
           
        }
    ]
	 });	 	 
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
					email:$("#email").val(),
					tele:$("#tele").val(),
					creatTime:$("#creatTime").val(),
					textfield:$("#textfield").val()
			
				},
				
				function(json) {
					$(".info").remove();
	//alert(json);
					$("#pageTotal").html(json.total);
	//alert("---jsontotal---"+json.total);
					var page = json.total=="0"?"0":json.currentPage;
	//alert("---page---"+page);				
					$("#pageMess").html(page);
		//alert("---totalpage---"+json.totalPage);
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
		
				$(json).each(function(i,o){
					
					for(i=0;i<o.list.length;i++)
						{
							if(o.list[i]!=undefined)
							{
									$("#tab").append( "<tr class='info'><td>"+(o.list[i].USERNAME==undefined?"":o.list[i].USERNAME)+"</td><td>"+

o.list[i].C_T+"</td><td>"+(o.list[i].REALNAME==undefined?"":o.list[i].REALNAME)+"</td><td>"+(o.list[i].SEX==undefined?"":o.list[i].SEX)+

"</td><td>"+(o.list[i].EMAIL==undefined?"":o.list[i].EMAIL)+"</td><td>"+(o.list[i].TELE==undefined?"":o.list[i].TELE)+"</td><td>"+

"<img src='images/edt.gif' width='16' height='16' /> <a href='javascript:void(0)' id='"+o.list[i].C_ID+"' onclick='updateDialog(this.id);'>编辑</a>"+

"&nbsp; &nbsp;<img src='images/del.gif' width='16' height='16' /><a href='javascript:void(0)' id='"+o.list[i].C_ID+"' onclick='deleteDialog(this.id);'>删除</a>"+

"</td></tr>"

);
							}
						}						
					});						
					}
			
					
			},
				
				"json"
	);
	}
	
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
			location = "<%=path%>/AdminServlet?currentPage=" + currentPage.value;

	}
<%-- 排序插件
	$(document).ready(function() {
		$("#tab").tablesorter();
	});
	--%>
	
<%-- 表格样式--%>
	function altRows(id) {
		if (document.getElementsByTagName) {

			var table = document.getElementById(id);
			var rows = table.getElementsByTagName("tr");

			for (i = 0; i < rows.length; i++) {
				if (i % 2 == 0) {
					rows[i].className = "evenrowcolor info";
				} else {
					rows[i].className = "oddrowcolor info";
				}
			}
		}
	}

	window.onload = function() {
		altRows('tab');
	}
</script>
</head>



<table width="100%" height="80%" border="0" cellspacing="0"
	cellpadding="0">
	<tr>
		<td align="center" valign="middle">
			<div style="margin-right: 10px; width: 850px">
				<table align="center">
					<tr>
						<td><font
							style="font-family: verdana, arial, sans-serif; font-size: 15px; color: #333333;">账号：
						</font>
						<td><input type="text" id="user" style="overflow: visible"
							size="18" maxlength="50"> <input type="hidden"
							id="password" /> <input type="hidden" id="isAjax"
							value="<%=isAjax%>"> <input type="hidden" id="path"
							value="<%=path%>"> <input type="hidden"
							value="<%=pageBean.getCurrentPage()%>" name="currentPage"
							id="currentPage" /></td>
						<td><font
							style="font-family: verdana, arial, sans-serif; font-size: 15px; color: #333333;">真实姓名：</font></td>
						<td><input type="text" id="realName" size="19" /></td>
						<td><font
							style="font-family: verdana, arial, sans-serif; font-size: 15px; color: #333333;">性别:</font></td>
						<td><select id="sex">
								<option value="男">男</option>
								<option value="女">女</option>
								<option value="all" selected="selected">全部</option>
						</select></td>
					</tr>
					<tr>
						<td><font
							style="font-family: verdana, arial, sans-serif; font-size: 15px; color: #333333;">邮箱地址：
						</font></td>
						<td><input type="text" id="email" size="18" /></td>
						<td><font
							style="font-family: verdana,  arial, sans-serif; font-size: 15px; color: #333333;">手机号：</font></td>
						<td><input type="text" id="tele" size="19" /></td>
						<td><font
							style="font-family: verdana, arial, sans-serif; font-size: 15px; color: #333333;">创建时间:</font></td>
						<td><input class="Wdate" type="text"
							onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"
							id="creatTime" size="16" /></td>

					</tr>
					<tr>
						<td align="center" colspan="6"><input type="button"
							id="search" value="搜索" /> <input type="button" id="create"
							value="创建" disabled /> <a href="javascript:void(0)"
							id="addAdmin">新增 </a></td>
					</tr>
				</table>




			</div>
		</td>
	</tr>



	<tr>
		<td align="center" valign="middle">

			<table class="altrowstable" id="tab">
				<thead>
					<tr>
						<th>账号</th>
						<th>创建时间</th>
						<th>真实姓名</th>
						<th>性别</th>
						<th>邮箱</th>
						<th>手机号码</th>
						<th>基本操作</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < list.size(); i++) {
							Map<String, Object> map = list.get(i);
					%>

					<tr class="info">

						<td align="center"><%=map.get("USERNAME") == null ? "" : map
						.get("USERNAME")%></td>
						<td><%=map.get("CREATETIME") == null ? "" : map
						.get("CREATETIME")%></td>
						<td><%=map.get("REALNAME") == null ? "" : map
						.get("REALNAME")%></td>
						<td><%=map.get("SEX") == null ? "" : map.get("SEX")%></td>
						<td><%=map.get("EMAIL") == null ? "" : map.get("EMAIL")%></td>
						<td><%=map.get("TELE") == null ? "" : map.get("TELE")%></td>
						<td><img src="images/edt.gif" width="16" height="16" /> <a
							href="javascript:void(0)" id="<%=map.get("ID")%>"
							onclick="updateDialog(this.id);">编辑</a>&nbsp; &nbsp;<img
							src="images/del.gif" width="16" height="16" /><a
							href="javascript:void(0)" id="<%=map.get("ID")%>"
							onclick="deleteDialog(this.id);">删除</a></td>

					</tr>
					<%
						}
					%>
				
			</table>
			<table align="center">
				<tr>
					<td class="STYLE4" id="pageInfo" colspan="7">&nbsp;&nbsp; 共有 <span
						id="pageTotal"> <%=pageBean.getTotal()%>
					</span> 条记录，当前第 <span id="pageMess"> <%=(pageBean.getTotal() == 0 ? "0" : pageBean
					.getCurrentPage())%></span>/ <span id="pageMessAll"><%=pageBean.getTotalPage()%>
					</span> 页 <img src="images/first.gif" width="37" height="15" id="fp"
						onclick="goPage(this);" /> <img src="images/back.gif" width="43"
						height="15" id="pp" onclick="goPage(this);" /><img
						src="images/next.gif" width="43" height="15" id="np"
						onclick="goPage(this);" /><img src="images/last.gif" width="37"
						height="15" id="lp" onclick="goPage(this);" /> <span
						class="STYLE1">转到第 <input id="textfield" type="text"
							size="4"
							style="height: 12px; width: 20px; border: 1px solid #999999;" />
							页
					</span> <img src="images/go.gif" width="37" height="15" id="goOther" />
					</td>


				</tr>
			</table>
		</td>
	</tr>
	</tbody>
</table>


</body>
</html>

