<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="page.aspx.cs" Inherits="Snfinal01.asp.ordAdmin.page" %>
<%@ Import Namespace="Snfinal01.src.model" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html>
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=7" />

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
        }
    </script>
</head>
<body >
    <form id="form1" runat="server">
        <asp:HiddenField ID="pageHid" runat="server" />


        <div>
            <div id="pageHead" style="margin-right: 10px; width: 850px" runat="server">

                <asp:DataList ID="searchDlist" runat="server" >

                    <ItemTemplate> 
                    

                            <%#Eval("TrName") %>
                            <asp:TextBox ID="textbox1" runat="server"></asp:TextBox>

                      
                    </ItemTemplate>
                    <FooterTemplate>

                                 <input type="button" id="searchBtn" value="搜索" />
                                <input type="button" id="creatBtn" value="创建" />
                     
                    </FooterTemplate>
                </asp:DataList>
            </div>
            <%-- 内容--%>
            <div id="pageBody" runat="server">

                <%-- 
                                    <table>
                    <tr><%for (int i = 0; i < head.Length;i++ ) 
                          {
                               %>
                                <td><%=head[i].TrName %></td>
                        <%
                          } %>

                    </tr>
             
                    --%>

                <asp:DataList ID="bodylist" runat="server" OnDeleteCommand="thNameDlist_DeleteCommand" OnEditCommand="bodylist_EditCommand" OnUpdateCommand="thNameDlist_UpdateCommand"
                   OnItemDataBound="bodylist_ItemDataBound" >
                    <HeaderTemplate>
                        <asp:DataList ID="headDataList" runat="server" >
                            <ItemTemplate>
                                <%#Eval("id") %>
                            </ItemTemplate>
                        </asp:DataList>
                    </HeaderTemplate>
                    <ItemTemplate>

                           <%for (int i = 0; i < body.Length;i++ ) 
                          {
                               tdName = body[i].Name;
                               %>
                                <td><%#Eval(tdName) %></td>
                        <%
                          } %>
                         <td>

          <asp:Button ID="Button_ed" runat="server" CommandName="edit" Text="编辑" CommandArgument='<%#Eval("id") %>'/> 
          <asp:Button ID="deleteBtn" runat="server"  CommandName="delete" Text="删除" CommandArgument='<%#Eval("id") %>'
               OnClientClick="return confirm(&quot;确认删除？&quot;);"/>
                         </td>

                      
<%--
   <asp:DataList ID="bodyDataList" runat="server" RepeatColumns=<%= body.Length%>>
                            <ItemTemplate>
                                <%#Eval("Name") %>
                            </ItemTemplate>
                        </asp:DataList>   
                    

     --%>
                    </ItemTemplate>
         
                    <EditItemTemplate>
                        <table>
                            <%
                                for(int i = 0;i<editPage.Rows[0].ItemArray.Length;i++){
                                  editThName = thNameS[i].TrName;
                                  editName = thNameS[i].Name;
                                  type = thNameS[i].Type;
                                  %>
                                  <tr>
                                      <td>
                                          <%#Eval(editThName) %>                                    
                                      </td>
                                      <td>
                                          <%
                                              switch(type) 
                                            {
                                                case 1: 
                                                    {
                                                        %>
                                           <asp:TextBox ID="TextBox1" runat="server" > </asp:TextBox>
                                                        <%
                                                        //文本框
                                                        break;
                                                    }
                                                case 2: 
                                                    {
                                                        %>
                                          <asp:TextBox ID="TextBox2" textMode="MultiLine" Width="100px" Height="70px" runat="server"></asp:TextBox>
                                                        <%
                                                        //大文本
                                                        break;
                                                    }
                                                case 3:
                                                    {
                                                        %>
                                          <asp:Image ID="Image1" runat="server"  ImageUrl='<%#Bind("editName") %>'/>
                                          <%
                                                        //图片
                                                        break; 
                                                    }
                                                case 7:
                                                    {
                                                        %>
                                          <asp:Calendar ID="Calendar1" runat="server" Caption='<%#Bind("editName") %>'></asp:Calendar>
                                          <%
                                                        //日期控件
                                                        break; 
                                                    }
                                            }
                                             %>
                                         
                                      </td>
                                  </tr>
                            <%
                              } %>
                           
                            <tr>
                                <td colspan="2" align="center">
                                    <asp:Button ID="updateBtn" runat="server" CommandArgument='<%#Eval("id") %>'
                                     CommandName="update" Text="更新" />
                                    
                                    <asp:Button ID="cancelBtn" runat="server" CommandName="cancel" Text="取消" />
                                </td>
                            </tr>
                        </table>                      
                    </EditItemTemplate>  
                               
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

                                        <img src="./../../images/first.gif" width="37" height="15" id="fp"
                                            onclick="goPage(this);" />
                                    </td>
                                    <td width="45">
                                        <img src="./../../images/back.gif" width="43" height="15" id="pp"
                                            onclick="goPage(this);" />
                                    </td>
                                    <td width="45">
                                        <img src="./../../images/next.gif" width="43" height="15" id="np"
                                            onclick="goPage(this);" />
                                    </td>
                                    <td width="40">
                                        <img src="./../../images/last.gif" width="37" height="15" id="lp"
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
                                        <img src="./../../images/go.gif" width="37" height="15"
                                            id="goOther" onclick="Other();" alt="NextPage"/>
                                    </td>
                                </tr>
                            </table>
                            </table>
            </div>
        </div>
    </form>
</body>
</html>
