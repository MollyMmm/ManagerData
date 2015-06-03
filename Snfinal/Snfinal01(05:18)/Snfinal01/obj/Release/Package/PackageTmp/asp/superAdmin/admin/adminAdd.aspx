<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="adminAdd.aspx.cs" Inherits="Snfinal01.asp.superAdmin.admin.adminAdd" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title></title>
    <link rel="stylesheet" type="text/css"
        href="artDialog4.1.6/skins/blue.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="artDialog4.1.6/artDialog.source.js"></script>
    <script type="text/javascript" src="artDialog4.1.6/plugins/iframeTools.source.js"></script>

    <script type="text/javascript">
<%--//按钮：取消--关闭此对话框  --%>
        $(function () {
            $("#cancleBtn").click(function () {
                art.dialog.close();
            });
        });
<%--//加载时，判断是创建还是添加 --%>
        function onloadAdmin() {
            if (art.dialog.data('create') == "1") {
                $("#userName").val(art.dialog.data('userName'));
                $("#realName").val(art.dialog.data('realName'));
                $("#sex").val(art.dialog.data('sex'));
                $("#email").val(art.dialog.data('email'));
                $("#tele").val(art.dialog.data('tele'));
            }
        }

<%--//验证两次密码是否相同--%>
        $(function () {
            $("#passwordSec").blur(function () {
                isSame();
            });
        });
        //进行判断:两次密码是否相同
        function isSame() {

            if ($("#password").val() != $("#passwordSec").val()) {
                $("#passwordSpan").html("<font color = 'red'>两次输入的密码不一样，请重新输入！</font>");
                return false;
            } else {
                return true;
            }

        }

<%--//验证账户 --%>
        $(function () {
            $("#userName").blur(function () {

                vailUsername();
            });
        });
        //验证输入的账户是否可用
        var b = false;
        //用户名不为空
        function vailUsername() {
            //window.setTimeout("alert(111)", "1000");
            vailUser();
            var bool = b;
            if ($("#userName").val() == "") {
                $("#userSpan").html("<font color = 'red'>请输入用户名</font>");
                return false;
            } else {
                if (!bool) {
                    $("#userSpan").html("<font color='red'>对不起，此账户已存在。</font>");
                    return false;
                } else {
                    $("#userSpan").html("<font color = 'green'>可以使用</font>");
                    return true;
                }
            }
        }
        //Ajax 获取账户
        function vailUser() {
            $.post(
                "<%=Request.Url.AbsoluteUri%>",
				{
				    userName: $("#userName").val(),
				},
				function (text) {
				    var t = text;
				    if (t == 1) {
				        b = true;
				    } else {
				        b = false;
				    }
				    $("#ajax").html(text);
				},
				"text"
				);
    }
<%--//提交表单  --%>

        $(function () {
            $("#submitBtn").click(function () {
                if (vailAll()) {
                    $("#pageForm").submit();
                } else {
                    alert("不满足条件，请修改后提交！");
                }
            });
        });
<%--//验证所有是否满足条件  --%>
        function vailAll() {
            return vailUsername() && isSame();
        }
    </script>

</head>

<body onload="onloadAdmin();">
    <form id="pageForm" runat="server">
        <table>


            <tr>
                <td align="right">账号</td>
                <td>
                    <%--存放账户是否可用 --%>
                    <input type="hidden" id="ajax" />
                    <asp:TextBox ID="userName" runat="server"></asp:TextBox>
                    <span id="userSpan"><font color='red'>*不可为空</font></span>
                </td>
            </tr>
            <tr>
                <td align="right">密码</td>
                <td>
                    <asp:TextBox ID="password" type="password" runat="server"></asp:TextBox>
                    <span id="passwordFirstSpan"><font color='red'>*不可为空</font></span></td>
            </tr>
            <tr>
                <td align="right">再次输入密码</td>
                <td>
                    <asp:TextBox ID="passwordSec" type="password" runat="server"></asp:TextBox>
                    <span id="passwordSpan"></span></td>
            </tr>
            <tr>
                <td align="right">邮箱地址</td>
                <td>
                    <asp:TextBox ID="email" runat="server"></asp:TextBox>
                    
            </tr>
            <tr>
                <td align="right">手机号</td>
                <td>
                    <asp:TextBox ID="tele" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td align="right">性别</td>
                <td>
                    <asp:RadioButton ID="man" runat="server" GroupName="sex" checked="true" Text="男"/>男
                    <asp:RadioButton ID="woman" runat="server" GroupName="sex" Text="女"/>女
                   </td>
            </tr>
            <tr>
                <td align="right">真实姓名</td>
                <td>
                    <asp:TextBox ID="realName" runat="server"></asp:TextBox> 
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <asp:Button ID="submitBtn" runat="server" Text="确认添加" />
                    <input type="reset" value="重置" />
                    <input type="button" value="取消" id="cancleBtn" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
