<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="page.aspx.cs" Inherits="Snfinal01.asp.ordAdmin.page" %>
<%@ Import Namespace="Snfinal01.src.model" %>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>

    <link rel="stylesheet" href="css/table.css" type="text/css"
        media="screen" />


    <link rel="stylesheet" type="text/css"
        href="artDialog4.1.6/skins/blue.css" />
    <script type="text/javascript" src="artDialog4.1.6/artDialog.source.js">
    </script>
    <script type="text/javascript" src="artDialog4.1.6/jquery.artDialog.source.js">
    </script>
    <script type="text/javascript" src="artDialog4.1.6/plugins/iframeTools.source.js">
    </script>

    <script type="text/javascript">
        <%-- 控制表格 隔行变色--%>
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
        

        window.onload = function () {
            altRows('alternatecolor');
        }
    </script>
</head>
<body>
    <form id="form1" runat="server">
        <asp:HiddenField ID="pageHid" runat="server" />


        <div>
            <div id="pageHead" style="margin-right: 10px; width: 850px" runat="server">
                <asp:DataList ID="searchDlist" runat="server" >
                    <HeaderTemplate>
                        <table>
                             <tr>
                    </HeaderTemplate>
                    <ItemTemplate>
                        <td><%#Eval("TrName") %></td>
                       </td>
                    </ItemTemplate>
                    <FooterTemplate>
                        <td><input type="button" id="searchBtn" name="搜索" />
                            <input type="button" id="creatBtn" name="创建" />
                        </td>
                            </tr>
                        </table>
                    </FooterTemplate>
                </asp:DataList>
            </div>
            <%-- 内容--%>
            <div id="pageBody" runat="server">
                <asp:DataList ID="thNameDlist" runat="server" OnDeleteCommand="thNameDlist_DeleteCommand" OnUpdateCommand="thNameDlist_UpdateCommand"
                    >
                    <HeaderTemplate>
                        <table>
                    </HeaderTemplate>
                    <ItemTemplate>
                     <tr>


                            <td><%#Eval("TrName") %></td>
                                   <td><%#Eval("TrName") %></td>
                                   <td><%#Eval("TrName") %></td>
                                
                           <td>

                           </td>

                     </tr>            

                    </ItemTemplate>
         
                    <FooterTemplate>
                        </table>
                    </FooterTemplate>
                </asp:DataList>
            </div>

            <div id="pageLast">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>
                            <asp:HiddenField ID="currentPage" runat="server" />
                        </td>
                        <td class="STYLE4" id="pageInfo">&nbsp;&nbsp; 共有

                            <asp:Label ID="pageTotal" runat="server" Text="Label"></asp:Label>	
                            									
                            条记录，当前第
                            <asp:Label ID="pageMess" runat="server" Text="Label"></asp:Label>/
                            <asp:Label ID="pageMessAll" runat="server" Text="Label"></asp:Label>页

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
                                            <span class="STYLE1">转到第
                                                  <asp:TextBox ID="textfield" runat="server" Width="19px"></asp:TextBox>
                                                页 </span>
                                        </div>
                                    </td>
                                    <td width="40">
                                        <img src="images/go.gif" width="37" height="15"
                                            id="goOther" onclick="Other();" />
                                    </td>
                                </tr>
                            </table>
                            </table>
            </div>
        </div>
    </form>
</body>
</html>
