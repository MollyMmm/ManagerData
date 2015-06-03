<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="update.aspx.cs" Inherits="Snfinal01.asp.ordAdmin.update" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
</head>
<body>
    <form id="updateForm" runat="server" >
        <asp:HiddenField ID="pageInfoHid" runat="server" />
        <asp:HiddenField ID="idHid" runat="server" />
        <div runat="server" id="bodyDiv">          
            <asp:DataList ID="DataList1" runat="server">
                <HeaderTemplate><table></HeaderTemplate>
                <EditItemTemplate>
                    
                </EditItemTemplate>
                <FooterTemplate>
                    <tr><td colspan="2" align="center"> <input type="reset" value="重置" />
                    <input type="submit" value="提交" /></td></tr>
                   
                    </table>
                </FooterTemplate>
            </asp:DataList>
        </div>
    </form>
</body>
</html>
