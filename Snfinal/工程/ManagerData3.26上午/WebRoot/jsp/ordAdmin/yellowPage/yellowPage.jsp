<%@ page language="java"
	import="java.util.*,cn.com.adminData.model.PageBean"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String num = String.valueOf(request.getAttribute("num"));
	PageBean pageBean = (PageBean) request.getAttribute("yellowPage");
	List<Map<String, Object>> list = pageBean.getList();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>黄页信息显示</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">

	-->
	
	<script type="text/javascript"
	src="<%=path%>/js/jquery.js">
</script>

<link rel="stylesheet" type="text/css"
	href="<%=path%>/artDialog4.1.6/skins/blue.css" />
<script src="<%=path%>/artDialog4.1.6/artDialog.source.js">
</script>
<script src="<%=path%>/artDialog4.1.6/jquery.artDialog.source.js">
</script>
<script src="<%=path%>/artDialog4.1.6/plugins/iframeTools.source.js">
</script>
		<link rel="stylesheet" href="css/table.css" type="text/css"
			media="screen" />
		<script type="text/javascript">
<%switch (Integer.parseInt(num)) {
			case 1:%>
//跳转
function goPage(btn) {
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
			location = "<%=path%>/PrivateConsultServlet?currentPage="+currentPage.value;
		
		}
//根据输入的页数进行跳转
function Other(){
	var txtPage = document.getElementById("textfield");
	var goPage = parseInt(txtPage.value);
	if(goPage>=1&&goPage<=<%=pageBean.getTotalPage()%>){
	location = "<%=path%>/YellowShowServlet?currentPage="+goPage;
	}	
	}
<%break;
			case 2:%>
//跳转
function goPage(btn) {
	var id = btn.id;
	var currentPage = document.getElementById("currentPage");
	var leixing1 = document.getElementById("leixing1");
	var leixing2 = document.getElementById("leixing2");
	var leixing3 = document.getElementById("leixing3");
switch(id)
			{
				case "fp":
					<%System.out.print("能不能出来了");%>
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
			var biaoshi = (leixing1.value==undefined||leixing1.value=="")?"":"&leixing1="+leixing1.value;
			var title = (leixing1.value==undefined||leixing2.value=="")?"":"&leixing2="+leixing1.value;
			var difang = (leixing1.value==undefined||leixing2.value=="")?"":"&leixing3="+leixing1.value;
			location = "<%=path%>/YellowSearchServlet?currentPage="+currentPage.value+biaoshi+title+difang;
		
		}
//根据输入的页数进行跳转
function Other(){
	var txtPage = document.getElementById("textfield");
	var goPage = parseInt(txtPage.value);
	
	if(goPage>=1&&goPage<=<%=pageBean.getTotalPage()%>){
		var biaoshi = (leixing1.value==undefined||leixing1.value=="")?"":"&leixing1="+leixing1.value;
		var title = (leixing1.value==undefined||leixing2.value=="")?"":"&leixing2="+leixing1.value;
		var difang = (leixing1.value==undefined||leixing2.value=="")?"":"&leixing3="+leixing1.value;
		location = "<%=path%>/YellowSearchServlet?currentPage="+goPage+biaoshi+title+difang;
	}		
}
<%break;
			}%>
		
function altRows(id) {
	if (document.getElementsByTagName) {

		var table = document.getElementById(id);
		var rows = table.getElementsByTagName("tr");

		for (i = 0; i < rows.length; i++) {
			if (i % 2 == 0) {
				rows[i].className = "evenrowcolor";
			} else {
				rows[i].className = "oddrowcolor";
			}
		}
	}
}

window.onload = function() {
	altRows('alternatecolor');
}

<%--删除--%>
function deleteDialog(id){
	 var throughBox = art.dialog.through;
	throughBox({
	    title:'删除',
		content:'确定要删除此黄页信息吗？',
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
               window.location.href = "<%=path%>/YellowDelServlet?ID="+id;
            },
            focus: true
        },
        {
            name: '取消',
           
        }
    ]
	 });	 	 
}

$(function(){
	<%-- 增加黄页信息--%>
	$("create").click(function(){
		yellowAdd();
	});
});
//增加的弹出层
function yellowAdd(){
	 art.dialog.open('<%=path%>/jsp/ordAdmin/yellowPage/addYellow.jsp', {
				title: '添加黄页信息',
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
	  					window.location.href = "<%=path%>/YellowShowServlet";
	  				}
				
				});
}
</script>
	</head>

	<body>
		<div style="margin-right: 10px; width: 850px">
			<form action="<%=path%>/YellowSearchServlet" method="post">
				<table>
					<tr>

						<td>
							<input type="hidden"  name="search" value="1"/>
						</td>

						<td>
							<font
								style="font-family: 微软雅黑; color: #333333;">标识ID：</font>
							<input type="text" name="leixing1" value="<%=request.getParameter("leixing1") == null ? "" : request
					.getParameter("leixing1")%>">
						</td>
						<td>
							<font
								style="font-family: 微软雅黑; color: #333333;">机构名：</font>
							<input type="text" name="leixing2"  value="<%=request.getParameter("leixing2") == null ? "" : request
					.getParameter("leixing2")%>">
						</td>
						<td>
							<font style="font-family: 微软雅黑; color: #333333;">联系方式：</font>
							<input type="text" name="leixing3"	value="<%=request.getParameter("leixing3") == null ? "" : request
					.getParameter("leixing3")%>">
						</td>
						<td>
							<input type="submit" value="搜索">
							<!-- <a href="jsp/ordAdmin/yellowPage/addYellow.jsp">-->
							<input type="button" value="创建" id="create"> 
						</td>
					</tr>
				</table>
			</form>
		</div>

		<table width="100%" height="80%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="center" valign="middle">
					<table class="altrowstable" id="alternatecolor">

						<%
							if (list.size() == 0) {

								//搜索信息不存在
						%>
								
								<tr>
								
								<td>
								您搜索的
								<%
																	if (request.getAttribute("leixing1") != null) {
																%>标识ID：<%=request.getAttribute("leixing1")%><%
																	}
																%>
								<%
									if (request.getAttribute("leixing2") != null) {
								%>机构名称：<%=request.getAttribute("leixing2")%><%
									}
								%>
								<%
									if (request.getAttribute("leixing3") != null) {
								%>联系方式：<%=request.getAttribute("leixing3")%><%
									}
								%>
								信息不存在，如需创建，请点击创建按钮！
								</td>
								</tr>
								
								<%
																	} else {
																		String currentPage = String.valueOf(pageBean.getCurrentPage());
																		String totalPage = String.valueOf(pageBean.getTotalPage());
																		Map<String, Object> map = list.get(0);
																%>
						<tr>
							<th>
								ID
							</th>
							<th>
								标识
							</th>
							<th>
								机构名
							</th>
							<th>
								联系方式
							</th>
							<th>
								机构地址
							</th>
							<th>图片</th>
							<th>
								操作
							</th>
						</tr>
						<%
							for (int i = 0; i < list.size(); i++) {
									Map<String, Object> yellow = list.get(i);
						%><tr>

							<td><%=yellow.get("ID")%></td>
							<td><%=yellow.get("EXYENDEDID")%></td>
							<td><%=yellow.get("INSTITUTION_NAME")%></td>
							<td><%=yellow.get("CONTACTMETHOD")%></td>
							<td><%=yellow.get("LOCATION")%></td>
							<td><%=yellow.get("PICTURE")%></td>
							<td>
								<a href="<%=path%>/YellowSelOneServlet?id=<%=yellow.get("ID")%>">编辑</a>|
								<a 
								href="javascript:void(0)" id="<%=yellow.get("ID")%>" onclick="deleteDialog(this.id)">删除</a>
							</td>
						</tr>
						<%
							}
						%>
					</table>


				</td>
			</tr>
			<tr>
				<td align="center" valign="middle">
					<table style="font-family: 微软雅黑;">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>

										<td>
											<input type="hidden" value="<%=pageBean.getCurrentPage()%>"
												name="currentPage" id="currentPage" />
										</td>
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
																	style="height: 15px; width: 20px; border: 1px solid #999999;" />
																页 </span>
														</div>
													</td>
													<td width="40">
														<img src="images/go.gif" width="37" height="15"
															id="goOther" onclick="Other();" />
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
			</tr>
			<%
				}
			%>
		</table>
	</body>
</html>
