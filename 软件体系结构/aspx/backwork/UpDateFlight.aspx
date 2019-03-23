<%@ Page Language="C#" AutoEventWireup="true" CodeFile="UpDateFlight.aspx.cs" Inherits="backwork_UpDateFlight" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AutoGenerateColumns="False"
            BackColor="White" BorderColor="#DEDFDE" BorderStyle="None" BorderWidth="1px"
            CellPadding="4" ForeColor="Black" GridLines="Vertical" Height="452px" OnPageIndexChanging="GridView1_PageIndexChanging"
            OnRowDeleting="GridView1_RowDeleting" Style="z-index: 100; left: 1px; font: caption;
            position: absolute; top: 0px; text-align: center" Width="947px" OnRowEditing="GridView1_RowEditing" OnRowDataBound="GridView1_RowDataBound">
            <PagerSettings FirstPageText="首页" LastPageText="尾页" Mode="NextPreviousFirstLast"
                NextPageText="下页" PreviousPageText="上页" />
            <FooterStyle BackColor="#CCCC99" />
            <Columns>
                <asp:BoundField DataField="company_type" HeaderText="航空公司" />
                <asp:BoundField DataField="starting_city" HeaderText="出发城市" />
                <asp:BoundField DataField="terminus_city" HeaderText="抵达城市" />
                <asp:BoundField DataField="starting_date" HeaderText="出发日期" />
                <asp:BoundField DataField="flight_type" HeaderText="航班类型" />
                <asp:CommandField ButtonType="Button" EditText="详情" HeaderText="更新" ShowEditButton="True" />
                <asp:CommandField ButtonType="Button" HeaderText="操作" ShowDeleteButton="True" />
            </Columns>
            <RowStyle BackColor="#F7F7DE"  Height ="27" Font-Size =Small />
            <SelectedRowStyle BackColor="#CE5D5A" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#F7F7DE" ForeColor="Black" HorizontalAlign="Right" />
            <HeaderStyle BackColor="#4f91c3" Font-Bold="True" ForeColor="white" Height ="32" />
            <AlternatingRowStyle BackColor="White" />
        </asp:GridView>
    
    </div>
    </form>
</body>
</html>
