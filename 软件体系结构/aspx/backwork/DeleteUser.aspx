<%@ Page Language="C#" AutoEventWireup="true" CodeFile="DeleteUser.aspx.cs" Inherits="backwork_DeleteUser" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" Style="text-align: center; font-size:small font: caption; z-index: 100; left: 0px; position: absolute; top: 0px;" Width="947px" AllowPaging="True"  OnRowDeleting="GridView1_RowDeleting" OnPageIndexChanging="GridView1_PageIndexChanging" CellPadding="4" ForeColor="Black" GridLines="Vertical" BackColor="White" BorderColor="#DEDFDE"  BorderStyle="None" BorderWidth="1px" OnRowDataBound="GridView1_RowDataBound">
            <Columns>
                <asp:BoundField DataField="user_name" HeaderText="用户名" />
                <asp:CommandField ButtonType="Button" HeaderText="操作" ShowDeleteButton="True" />
            </Columns>
            <PagerSettings FirstPageText="首页" LastPageText="尾页" NextPageText="下页"
                PreviousPageText="上页" Mode="NextPreviousFirstLast" />
            <FooterStyle BackColor="#CCCC99" />
            <RowStyle BackColor="#F7F7DE" Font-Size="Small"  Height ="28"/>
            <SelectedRowStyle BackColor="#CE5D5A" Font-Bold="True" ForeColor="White"  Height ="28"/>
            <PagerStyle BackColor="#F7F7DE" ForeColor="Black" HorizontalAlign="Right" Font-Size="Small" />
            <HeaderStyle BackColor="#4f91c3" Font-Bold="True" ForeColor="white" Font-Size="Small" />
            <AlternatingRowStyle BackColor="White" />
        </asp:GridView>
        &nbsp; &nbsp;</div>
    </form>
</body>
</html>
