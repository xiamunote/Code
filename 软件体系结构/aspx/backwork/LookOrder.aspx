<%@ Page Language="C#" AutoEventWireup="true" CodeFile="LookOrder.aspx.cs" Inherits="backwork_LookOrder" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" Height="452px"
            Style="font: caption; font-size:small ; text-align: center; z-index: 100; left: 0px; position: absolute; top: 0px;" Width="947px" AllowPaging="True" OnPageIndexChanging="GridView1_PageIndexChanging1" OnRowDeleting="GridView1_RowDeleting1" CellPadding="4" ForeColor="Black" GridLines="Vertical" OnRowDataBound="GridView1_RowDataBound" OnRowEditing="GridView1_RowEditing" OnSelectedIndexChanging="GridView1_SelectedIndexChanging" BackColor="White" BorderColor="#DEDFDE" BorderStyle="None" BorderWidth="1px">
            <Columns>
                <asp:BoundField DataField="relationer" HeaderText="客户姓名" />
                <asp:BoundField DataField="mobile_phone" HeaderText="移动电话" />
                <asp:BoundField DataField="stacity" HeaderText="出发城市" />
                <asp:BoundField DataField="arrcity" HeaderText="前往城市" />
                <asp:BoundField DataField="company" HeaderText="航空公司" />
                <asp:BoundField DataField="flighttype" HeaderText="航班号" />
                <asp:BoundField HeaderText="状态" DataField="try" />
                <asp:CommandField ButtonType="Button" SelectText="处理/取消" ShowSelectButton="True" HeaderText="审核" />
                <asp:CommandField HeaderText="查看" ShowEditButton="True" ButtonType="Button" EditText="详细信息" />
                <asp:CommandField ButtonType="Button" HeaderText="操作" ShowDeleteButton="True" />
            </Columns>
            <PagerSettings FirstPageText="首页" LastPageText="尾页"
                NextPageText="下页" PreviousPageText="上页" Mode="NextPreviousFirstLast" />
            <FooterStyle BackColor="#CCCC99" />
           <RowStyle BackColor="#F7F7DE"  Height ="28" Font-Size =Small />
            <SelectedRowStyle BackColor="#CE5D5A" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#F7F7DE" ForeColor="Black" HorizontalAlign="Right" />
            <HeaderStyle BackColor="#4f91c3" Font-Bold="True" ForeColor="White" />
            <AlternatingRowStyle BackColor="White" />
        </asp:GridView>
        &nbsp;&nbsp;</div>
    </form>
</body>
</html>
