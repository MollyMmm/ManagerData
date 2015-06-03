<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="adminList.aspx.cs" Inherits="Snfinal01.asp.superAdmin.admin.adminList" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>

<link rel="stylesheet" href="css/table.css" type="text/css"
	media="screen" />


<script type="text/javascript"\ src="js/jquery.js">
</script>

<script type="text/javascript"
	src="My97DatePicker/WdatePicker.js">
</script>

<link rel="stylesheet" type="text/css"
	href="artDialog4.1.6/skins/blue.css" />

<script type="text/javascript" src="artDialog4.1.6/artDialog.source.js">
</script>
<script type="text/javascript" src="artDialog4.1.6/jquery.artDialog.source.js">
</script>
<script type="text/javascript"
     src="artDialog4.1.6/plugins/iframeTools.source.js">
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
        art.dialog.open('./adminAdd.aspx', {
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
		            window.location.href = "./adminList.aspx";
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
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
    </form>
</body>
</html>
