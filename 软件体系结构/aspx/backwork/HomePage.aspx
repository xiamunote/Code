<%@ Page Language="C#" AutoEventWireup="true" CodeFile="HomePage.aspx.cs" Inherits="backwork_HomePage" %>

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
            CellPadding="4" ForeColor="Black" GridLines="Vertical" Height="445px" OnPageIndexChanging="GridView1_PageIndexChanging"
            Style="z-index: 100; left: 1px; font: caption; position: absolute; top: 0px;
            text-align: center" Width="947px" OnRowDataBound="GridView1_RowDataBound" 
            Font-Size="Small" >
            <PagerSettings FirstPageText="首页" LastPageText="尾页" Mode="NextPreviousFirstLast"
                NextPageText="下页" PreviousPageText="上页" />
            <FooterStyle BackColor="#CCCC99" />
            <Columns>
                <asp:BoundField DataField="company_type" HeaderText="航空公司" />
                <asp:BoundField DataField="starting_city" HeaderText="出发城市" />
                <asp:BoundField DataField="terminus_city" HeaderText="抵达城市" />
                <asp:BoundField DataField="OneWay_price" HeaderText="机票单价" />
                <asp:BoundField DataField="flight_type" HeaderText="航班类型" />
                <asp:BoundField DataField="starting_date" HeaderText="航班日期" />
                <asp:BoundField DataField="starting_time" HeaderText="起飞时间" />
                <asp:BoundField DataField="arriving_time" HeaderText="降落时间" />
                <asp:BoundField DataField="bunk_type" HeaderText="机舱类型" />
                <asp:BoundField DataField="starting_airport" HeaderText="起飞机场" />
                <asp:BoundField DataField="arriving_airport" HeaderText="降落机场" />
                <asp:BoundField DataField="num" HeaderText="库存票量" />
            </Columns>
            <RowStyle BackColor="#F7F7DE"  Font-Size="Small"/>
            <SelectedRowStyle BackColor="#CE5D5A" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#F7F7DE" ForeColor="Black" HorizontalAlign="Right" Font-Size="Small" />
            <HeaderStyle BackColor="#4f91c3" Font-Bold="True" ForeColor="White" Font-Size="Small" />
            <AlternatingRowStyle BackColor="White" />
        </asp:GridView>
    
    </div>
    </form>
</body>
</html>
