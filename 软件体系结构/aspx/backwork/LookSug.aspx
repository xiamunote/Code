<%@ Page Language="C#" AutoEventWireup="true" CodeFile="LookSug.aspx.cs" Inherits="backwork_LookSug" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" Height="452px"
            
            Style="font: caption; text-align: center; z-index: 100; left: 0px; position: absolute; top: 0px;" 
            Width="947px" AllowPaging="True" OnRowDeleting="GridView1_RowDeleting1" 
            OnPageIndexChanging="GridView1_PageIndexChanging" CellPadding="4" 
            ForeColor="Black" GridLines="Vertical" BackColor="White" BorderColor="#DEDFDE" 
            BorderStyle="None" BorderWidth="1px" OnRowEditing="GridView1_RowEditing" 
            OnRowDataBound="GridView1_RowDataBound" Font-Size="Small">
            <Columns>
                <asp:BoundField DataField="consumer_name" HeaderText="客户姓名" />
                <asp:BoundField DataField="suggestion" HeaderText="投诉和意见" />
                <asp:BoundField DataField="email" HeaderText="邮箱地址" />
                <asp:BoundField DataField="mobile_phone" HeaderText="手机" />
                <asp:BoundField DataField="telephone" HeaderText="电话" />
                <asp:CommandField ButtonType="Button" EditText="详细" HeaderText="查看" ShowEditButton="True" />
                <asp:CommandField ButtonType="Button" HeaderText="操作" ShowDeleteButton="True" />
            </Columns>
            <PagerSettings FirstPageText="首页" LastPageText="尾页"
                NextPageText="下页" PreviousPageText="上页" Mode="NextPreviousFirstLast" />
            <FooterStyle BackColor="#CCCC99"  />
            <RowStyle BackColor="#F7F7DE" Height ="27"  Font-Size =Small />
            <SelectedRowStyle BackColor="#CE5D5A" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#F7F7DE" ForeColor="Black" HorizontalAlign="Right" />
            <HeaderStyle BackColor="#4f91c3" Font-Bold="True" ForeColor="White" />
            <AlternatingRowStyle BackColor="White" />
        </asp:GridView>
    
    </div>
    </form>
</body>
</html>
