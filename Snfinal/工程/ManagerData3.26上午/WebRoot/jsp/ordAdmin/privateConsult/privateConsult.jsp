<%@ page language="java"
	import="java.util.*,cn.com.adminData.model.PageBean,java.lang.String"
	pageEncoding="UTF-8"%>
<%@page import="sun.org.mozilla.javascript.internal.regexp.SubString"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	String num =String.valueOf(request.getAttribute("num"));
	PageBean pageBean = (PageBean) request.getAttribute("privateconsult");
	List<Map<String, Object>> list = pageBean.getList();
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>私人咨询页面显示</title>

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
			location = "<%=path%>/PrivateConsultServlet?currentPage="+currentPage.value;
		
		}
//根据输入的页数进行跳转
function Other(){
	var txtPage = document.getElementById("textfield");
	var goPage = parseInt(txtPage.value);
	if(goPage>=1&&goPage<=<%=pageBean.getTotalPage()%>){
	location = "<%=path%>/PrivateConsultServlet?currentPage="+goPage;
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
			var biaoshi = (leixing1.value==undefined||leixing1.value=="")?"":"&leixing1="+leixing1.value;
			var title = (leixing1.value==undefined||leixing2.value=="")?"":"&leixing2="+leixing1.value;
			var difang = (leixing1.value==undefined||leixing2.value=="")?"":"&leixing3="+leixing1.value;
			location = "<%=path%>/PrivateConsultSearchServlet?currentPage="+currentPage.value+biaoshi+title+difang;
		
		}
//根据输入的页数进行跳转
function Other(){
	var txtPage = document.getElementById("textfield");
	var goPage = parseInt(txtPage.value);
	
	if(goPage>=1&&goPage<=<%=pageBean.getTotalPage()%>){
		var biaoshi = (leixing1.value==undefined||leixing1.value=="")?"":"&leixing1="+leixing1.value;
		var title = (leixing1.value==undefined||leixing2.value=="")?"":"&leixing2="+leixing1.value;
		var difang = (leixing1.value==undefined||leixing2.value=="")?"":"&leixing3="+leixing1.value;
		location = "<%=path%>/PrivateConsultSearchServlet?currentPage="+goPage+biaoshi+title+difang;
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
</script>
	</head>

	<body>
		<div style="margin-right: 10px; width: 850px">
			<form action="<%=path%>/PrivateConsultSearchServlet" method="post">
				<table>
					<tr>
						<td>
						
						<input type="hidden"  name="search" value="1"/>
						
							<font
								style="font-family: 微软雅黑; color: #333333;">标识ID：</font>
							<input type="text" name="leixing1" id="leixing1" value="<%=request.getParameter("leixing1") == null ? "":request.getParameter("leixing1") %>">
						</td>
						<td>
							<font
								style="font-family: 微软雅黑; color: #333333;">咨询时间：</font>
							<input type="text" name="leixing2" id="leixing2" value="<%=request.getParameter("leixing2") == null ? "":request.getParameter("leixing2") %>">
						</td>
						<td>
							<font
								style="font-family: 微软雅黑; color: #333333;">咨询内容：</font>
							<input type="text" name="leixing3" id="leixing3" value="<%=request.getParameter("leixing3") == null ? "":request.getParameter("leixing3") %>">
						</td>
						<td>
							<input type="submit" value="搜索">
							<a href="<%=path%>/jsp/ordAdmin/privateConsult/addConsult.jsp"><input
									type="button" value="添加">
							</a>
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
								<%if(request.getAttribute("leixing1") != null) {%>标识ID：<%=request.getAttribute("leixing1")%><%}%>
								<%if(request.getAttribute("leixing2") != null) {%>咨询时间：<%=request.getAttribute("leixing2")%><%}%>
								<%if(request.getAttribute("leixing3") != null) {%>咨询内容：<%=request.getAttribute("leixing3")%><%}%>
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
								用户ID
							</th>
							<th>
								咨询内容
							</th>
							<th>
								咨询时间
							</th>
							
							<th>
								咨询类型
							</th>
							<th>
								回复内容
							</th>
							<th>
								回复时间
							</th>
							<th>
								操作
							</th>
						</tr>
						<%
							for (int i = 0; i < list.size(); i++) {
								Map<String, Object> consult = list.get(i);
								String consulting = consult.get("CONSULTING_BODY").toString();
								String reply = consult.get("REPLY_BODY").toString();
							
						%><tr>

							<td><%=consult.get("ID")%></td>
							<td><%=consult.get("EXTENDEDID")%></td>
							<td><%=consult.get("USERID")%></td>
							<td><% if(consulting.length()>15){%><%=consulting.substring(0,15)+"..."%><% }else{%><%=consulting%><%}%></td>
							<td><%=consult.get("CONSULTING_TIME")%></td>
							<%--<td><%=consult.get("DEADLINE")%></td>隐藏期望期限--%>
							<td><%=consult.get("CONSULTING_TYPE")%></td>
							<td><% if(reply.length()>15){%><%=reply.substring(0,15)+"..."%><% }else{%><%=reply%><%}%></td>
							<td><%=consult.get("REPLY_TIME")%></td>
							<td>
								<a
									href="<%=path%>/PrivateConsultSelOne?id=<%=consult.get("ID")%>">编辑</a>|
								<a
									href="<%=path%>/PrivateConsultDeleteServlet?ID=<%=consult.get("ID")%>">删除</a>
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
										<%System.out.print("---++_---"+pageBean.getCurrentPage()+"___________==="); %>


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
			<%} %>
		</table>

	</body>
</html>