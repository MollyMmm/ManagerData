<%@ page language="java"
	import="java.util.*,cn.com.adminData.model.PageBean"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	PageBean pageBean = (PageBean) request.getAttribute("Exchange");
	List<Map<String, Object>> list = pageBean.getList();

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>积分兑换页面</title>

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
			location = "<%=path%>/ExchangeShowServlet?currentPage="+currentPage.value;
		
		}
//根据输入的页数进行跳转
function Other(){
	var txtPage = document.getElementById("textfield");
	var goPage = parseInt(txtPage.value);
	
	if(goPage>=1&&goPage<=<%=pageBean.getTotalPage()%>){
	location = "<%=path%>/ExchangeShowServlet?currentPage="+goPage;
	}
}		
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
			<form action="<%=path%>/ExchangeSearchServlet" method="post">
				<table>
					<tr>
						<td>
							<input type="hidden" value="<%=pageBean.getCurrentPage()%>"
								name="currentPage" id="currentPage" />
						</td>
						<td>
							<font style="font-family: 微软雅黑; font-size: 15px; color: #333333;">手机号：</font>
							<input type="text" name="leixing1">
						</td>
						<td>
							<font style="font-family: 微软雅黑; font-size: 15px; color: #333333;">积分范围：</font>
							<select name="integral">
<option value="integral1" <%String sorce = "";
if(sorce.equals("integral1")){
%> selected="selected"<%
}
 %>>50-200</option>
<option value="integral2" <%String sorce1 = "";
if(sorce.equals("integral2")){
%> selected="selected"<%
}
 %>>201-400</option>
<option value="integral3" <%String sorce2 = "";
if(sorce.equals("integral3")){
%> selected="selected"<%
}
 %>>401以上</option>
 
</select>
						</td>
						<td>
							<input type="submit" value="搜索">
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
								<%if(request.getAttribute("leixing1") != null) {%>手机号：<%=request.getAttribute("leixing1")%><%}%>
								<%if(request.getAttribute("integral") != null) {%>积分范围：<%=request.getAttribute("integral")%><%}%>
								
								信息不存在！
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
								手机号
							</th>
							<th>
								积分
							</th>
							<th>
								奖励方式
							</th>

						</tr>
						<%
							for (int i = 0; i < list.size(); i++) {
								Map<String, Object> Exchange = list.get(i);
						%><tr>

							<td>
								<input type="hidden" value="<%=Exchange.get("ID")%>" />
								<%=Exchange.get("PHONENUMBER")%></td>
							<td><%=Exchange.get("U_SORCE")%></td>

							<td>
								<a
									href="jsp/ordAdmin/exchange/telephoneCharge.jsp?tele=<%=Exchange.get("PHONENUMBER")%>&&id=<%=Exchange.get("ID")%>">兑换话费</a>|
								<a
									href="jsp/ordAdmin/exchange/flow.jsp?tele=<%=Exchange.get("PHONENUMBER")%>&&id=<%=Exchange.get("ID")%>">兑换流量</a>
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