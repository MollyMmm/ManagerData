<%@ page language="java" import="java.util.*,cn.com.adminData.model.PageBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

PageBean pageBean = (PageBean) request.getAttribute("farming");
List<Map<String, Object>> list = pageBean.getList();

String num =String.valueOf(request.getAttribute("num"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'farming.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/table.css" type="text/css"
			media="screen" />
			
  <link rel="stylesheet" type="text/css"
	href="<%=path%>/artDialog4.1.6/skins/blue.css" />
<script src="<%=path%>/artDialog4.1.6/artDialog.source.js">
</script>
<script src="<%=path%>/artDialog4.1.6/jquery.artDialog.source.js">
</script>
<script src="<%=path%>/artDialog4.1.6/plugins/iframeTools.source.js">
</script>
<script src="<%=path%>/js/jquery.js">
</script>
		<script type="text/javascript">
		
		<%switch(Integer.parseInt(num)){
		case 1 :
		%>
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
			location = "<%=path%>/FarmingServlet?currentPage="+currentPage.value;
		
		}
//根据输入的页数进行跳转
function Other(){
	var txtPage = document.getElementById("textfield");
	var goPage = parseInt(txtPage.value);
	if(goPage>=1&&goPage<=<%=pageBean.getTotalPage()%>){
	location = "<%=path%>/FarmingServlet?currentPage="+goPage;
	}	
	}
<% 	
break;
		case 2:
%>
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
			//var biaoshi = (leixing1.value==undefined||leixing1.value=="")?"":"&leixing1="+leixing1.value;
			var title = (leixing2.value==undefined||leixing2.value=="")?"":"&leixing2="+leixing2.value;
			//var difang = (leixing1.value==undefined||leixing2.value=="")?"":"&leixing3="+leixing1.value;
			location = "<%=path%>/FarmingSearchServlet?currentPage="+currentPage.value+title;
			//biaoshi+title;
			//+difang;
		
		}
//根据输入的页数进行跳转
function Other(){
	var txtPage = document.getElementById("textfield");
	var goPage = parseInt(txtPage.value);
	
	if(goPage>=1&&goPage<=<%=pageBean.getTotalPage()%>){
		//var biaoshi = (leixing1.value==undefined||leixing1.value=="")?"":"&leixing1="+leixing1.value;
		var title = (leixing2.value==undefined||leixing2.value=="")?"":"&leixing2="+window.encodeURI(window.encodeURI(leixing2.value));
	//	var difang = (leixing1.value==undefined||leixing2.value=="")?"":"&leixing3="+leixing1.value;
	alert(title);
		location = "<%=path%>/FarmingSearchServlet?currentPage="+goPage+title;
		//biaoshi+title;
		//+difang;
	}		
}
<%
break;
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
		content:'确定要删除此农事提醒吗？',
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
               window.location.href = "<%=path%>/FarmingDelServlet?ID="+id;
            },
            focus: true
        },
        {
            name: '取消',
           
        }
    ]
	 });	 	 
}
<%--添加农事提醒--%>
		function FarmingAdd(id){
			 art.dialog.open('<%=path%>/jsp/ordAdmin/farming/addFarming.jsp', {
				title: '添加农事提醒',
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
	  					window.location.href = "<%=path%>/FarmingServlet";
	  				}
				
				});
		}

</script>
	</head>

	<body>
		<div style="margin-right: 10px; width: 850px">
			<form action="<%=path%>/FarmingSearchServlet" method="post" >
				<table>
					<tr>
					<td>
							<input type="hidden"  name="search" value="1"/>
							
							<font
								style="font-family: 微软雅黑; color: #333333;">内容：</font>
							<input type="text" name="leixing2" id="leixing2" value="<%=request.getParameter("leixing2") == null ? "":request.getParameter("leixing2") %>">
						</td>
						
						<td>
							<input type="submit" value="搜索">
							<!-- <a href="jsp/ordAdmin/notice/addNotice.jsp">  -->
							<input type="button" value="创建" onclick="farmingAdd(this.id);"  id="farming">
						
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
								
								<%if(request.getAttribute("leixing2") != null) {%>内容：<%=request.getAttribute("leixing2")%><%}%>
								
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
							发布人账号
							</th>
							<th>
								内容
							</th>
							<th>
								发布时间
							</th>
							<th>
								操作
							</th>
						</tr>
						<%
							for (int i = 0; i < list.size(); i++) {
								Map<String, Object> farming = list.get(i);
								String body = String.valueOf(farming.get("BODY"));
						%><tr>

							<td><%=farming.get("ID")%></td>
							<td><%=farming.get("USERID")%></td>
							<td><%if(body.length()>10){%><%=body.substring(0,9)+"..."%><%}else{%><%=body%><%}%></td>
							<td><%=farming.get("DATETIME")%></td>
							<td>
								<a
									href="<%=path%>/FarmingSelOneServlet?id=<%=farming.get("ID")%>&state=1">编辑</a>|
								<a href="javascript:void(0)" id="<%=farming.get("ID")%>" onclick="deleteDialog(this.id)">删除</a>|
								<a	href="<%=path%>/FarmingSelOneServlet?id=<%=farming.get("ID")%>&state=0">查看</a>
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
			<%} %>
		</table>

	</body>
</html>
