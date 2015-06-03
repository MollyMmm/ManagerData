<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="Snfinal01.asp.login.login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>

    <link rel="stylesheet" href="../../css/add.css" type="text/css"
        media="screen" />
    <link rel="stylesheet" href="../../css/index.css" type="text/css" media="screen" />

    <script type="text/javascript" src="../../js/jquery.js">
    </script>
    <script type="text/javascript">
        <%-- 获取新的验证码--%>
        function getNewRandom()
        {
            document.getElementById("randImg").src = document.getElementById("randImg").src + '?';
        }
    </script>
</head>
<body style="background-color: rgb(228,228,228); ">
    <form runat="server">
    <div class="layout_top_header">
        <div style="float: left"><span style="font-size: 16px; line-height: 45px; padding-left: 20px; color: #8d8d8d">抚松县管理后台</span></div>
    </div>
    <div style="height: 100%;">
        <table style="width: 100%; height: 80%; border: 0; margin-top: 82px;">
            <tr>
                <td valign="middle" align="center">

                        <table>
                            <tr>
                                <td>

                                    <div class="control-group">
                                        <asp:Label
                                            runat="server"
                                            class="laber_from"> 用户名 </asp:Label>
                                        <div class="controls">
                                           
                                            <asp:TextBox
                                                ID="userNameTxt"
                                                class="input_from" 
                                                 name="UserName"
                                                 placeholder="请输入账号"
                                                 runat="server" />
                                           <%-- 
                                                   <asp:RegularExpressionValidator ID="PwdValidator" runat="server" ControlToValidate="passwordTxt"

                                                  ErrorMessage="请输入合法字符!" ValidationExpression='[\w| !"§$%&amp;/()=\-?\*]*' />
                                                <asp:RequiredFieldValidator ID="userNameRequiredValidator" runat="server" 
                                                    ControlToValidate="userNameTxt"  ErrorMessage="请不要输入特殊字符!" ValidationExpression="[\w| ]*"  /> --%>
                                              
                                         
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="control-group">
                                        <asp:Label
                                            runat="server"
                                            class="laber_from"> 密码 </asp:Label>
                                        <div class="controls">
                                            <asp:TextBox

                                                class="input_from"
                                                type="password"
                                                placeholder="请输入密码"
                                                name="password"
                                                ID="passwordTxt" 
                                                                                                
                                                runat="server"/>

                                        
                                            <p class="help-block">
                                                <asp:Label ID="passwordLbl"
                                                     runat="server" >
                                             
                                                </asp:Label>

                                            </p>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div id="random">
                                        <label class="laber_from">验证码</label>
                                        <asp:TextBox ID="randomTxt" runat="server"></asp:TextBox>

                                        <br />
                                                  
                                        <asp:ImageButton ID="randImg" runat="server" Width="100" Height="30" OnClick="randImg_Click"/>
                                        
                                    </div>
                                    <div id="error-tip">
                                        <asp:Label ID="infoSpan" runat="server"> <font size='2' color='red'></font>
                                        </asp:Label>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="control-group">
                                        <div class="controls">
                                            <asp:Button ID="submitBtm" runat="server" Text="提交" class="btn btn-success"
                                                style="width: 120px; background-color: orange" OnClick="submitBtm_Click"/>

                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
                                            <asp:Button ID="resetBtn" class="btn btn-success"
                        style="width: 120px; background-color: orange" runat="server" Text="重置" />
                                        </div>
                                    </div>
                                </td>
                            </tr>

                        </table>
                </td>
            </tr>
        </table>
    </div>
    </form>
</body>
</html>
