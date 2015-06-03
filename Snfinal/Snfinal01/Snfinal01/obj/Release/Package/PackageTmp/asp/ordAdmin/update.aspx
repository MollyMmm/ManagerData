<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="update.aspx.cs" Inherits="Snfinal01.asp.ordAdmin.update" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:HiddenField ID="pageInfoHid" runat="server" />
        <asp:HiddenField ID="idHid" runat="server" />
    <div runat="server" id="bodyDiv">
        <asp:DataList ID="dlt_xxx" runat="server">
            <ItemTemplate>
                <asp:Button ID="Button1" runat="server" Text="Button" />
            </ItemTemplate>
        </asp:DataList>
    </div>
    </form>
</body>
</html>
