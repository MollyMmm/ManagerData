<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<List<Map<String, Object>>> power = null;
	if (request.getAttribute("power") != null) {
		//从请求中获取power 对象
		power = (List<List<Map<String, Object>>>) request
				.getAttribute("power");
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'powerManeger.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
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
<script type="text/javascript">
	<%--//按钮：取消--关闭此对话框  --%>
$(function(){
	
	$("#cancleBtn").click(function(){
		art.dialog.close();
	});
});
<%--//按钮：删除该组 --%>
$(function(){
		
	$("#deleteBtn").click(function(){
		
		window.location.href = "<%=path%>/PowerDeleteServlet?role_id="+$("#role_id").val();
		art.dialog.close();
	});
});
<%--全选 ----父级对子级产生影响 --%>
function selectAll(fatherC){
	var father = $(fatherC);
	var fatherId = $(fatherC).attr("id");
	
	var son = $("input[name='"+fatherId+"']");
	
	//alert(father.attr("checked"));
	
	
	son.attr("checked", fatherC.checked);
	
	
	//alert(son.attr("checked"));
	/*
	var sonId = son.attr("id")
	alert(son.attr("checked") );
	son.attr("checked") = father.attr("checked");
	$("input[name='"+sonId+"']").attr("disabled",false);
	*/
}
<%--选中子级则父级被选中--%>


$(function() {
	$(".father").click(function() {
		selectAll(this);
	});
	
});


</script>


	</head>

	<body>
		<h3 align="center"><%=(String) power.get(0).get(0).get("ROLE_NAME")%></h3>
		<form action="PowerUpdateServlet" method="post">
		<div>
			<input type="hidden" name="role_id" id="role_id"
				value="<%=String.valueOf(power.get(0).get(1).get("ROLE_ID"))%>" />
			<%
				List<Map<String, Object>> date = power.get(1);
				
			for (int i = 2; i < power.size(); i++) {
					List<Map<String, Object>> faterPowerList = power.get(i);
					String fatherId = String.valueOf(faterPowerList.get(
							faterPowerList.size() - 1).get("fatherId"));
					String fatherName = (String) faterPowerList.get(
							faterPowerList.size() - 1).get("powerFather");
			%><dl>
				<dt><input type="checkbox" id="<%=fatherId%>" class="father" onclick=""/><%=fatherName%></dt>
				<%
				//遍历子级权限 
					for (int j = 0; j < faterPowerList.size() - 1; j++) {
				%>
				<dd>
					<%--
					<input type="hidden" id="<%=fatherId%>" />

					--%>
					<%
					//如果子级权限存在，则选中
						if ((String) faterPowerList.get(j).get("statue") == "1") {
							String selectDate = String.valueOf( faterPowerList.get(j).get("DATE_ID"));
							String sonId = String.valueOf(faterPowerList.get(j).get("POWER_ID"));
					%>
					<input type="checkbox" name="<%=fatherId %>" checked="checked"
						value="<%=sonId%>" id="<%=sonId%>">
					<%=faterPowerList.get(j).get("POWER_NAME")%>
					<select class ="date" name="<%= sonId%>">
					<option value="kong" >  </option>
					<%
					for(int k = 0;k<date.size();k++){
						String date_name = (String)date.get(k).get("DATE_NAME");
						String date_id = String.valueOf(date.get(k).get("DATE_ID"));
						%>
						<option  value="<%= date_id%>" <%if(selectDate.equals(date_id)){%>selected="selected"<%} %>><%=date_name %></option>
						<% 
					}%>
					</select>
					<% 
						} else {
							//如果该子级权限不存在，则不被选中
							String sonId = String.valueOf(faterPowerList.get(j).get("POWER_ID"));
					%>
					<input type="checkbox" name="<%=fatherId %>"
						value="<%=sonId%>"  id="<%=sonId%>">
					<%=faterPowerList.get(j).get("POWER_NAME")%>
					<select class ="date" name="<%=sonId%>" disabled="disabled">
					<option value="kong" selected="selected">  </option>
					<%
					//遍历日期
					for(int k = 0;k<date.size();k++){
						String date_name = String.valueOf(date.get(k).get("DATE_NAME"));
						String date_id = String.valueOf(date.get(k).get("DATE_ID"));
						%>
						<option  value="<%= date_id%>"><%=date_name %></option>
						<% 
					}%>
					</select>
					<%
						}
					%>

				</dd>
				<%
					}
				%>
			</dl>
			<%
				}
			%>
			<input type="submit" value="确认修改">
			<input type="reset" value="重置">
			<input type="button" value="删除该组" id="deleteBtn">
			<input type="button" value="取消" id="cancleBtn">
		</div>
		</form>
	</body>
</html>
