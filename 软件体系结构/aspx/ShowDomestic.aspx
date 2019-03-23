<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ShowDomestic.aspx.cs" Inherits="ShowDomestic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
       <table width="1200px" border="0" cellpadding="0" cellspacing="0" background="images/bg1.gif">
        <tr>
            <td width="100%" align="left" height="100">
             <img src ="images/l.png" />
            </td>
            <td>
                <img src="images/spacer.gif" width="101" height="1" /><br>
            </td>
        </tr>
    </table>
    <table style="width: 1200px" background="images/bg3.gif" cellpadding="0" cellspacing="0" >
        <tr>
            <td style="width: 90%; height: 50px; " >
                <asp:Label ID="date" runat="server" Text="Label" Width="134px" Font-Bold="True"
                    Font-Names="华文仿宋" ForeColor="#b22222"></asp:Label>
                <asp:Label ID="weekdate" runat="server" Font-Bold="True" Font-Names="华文仿宋" ForeColor="#b22222"
                    Text="Label" Width="74px"></asp:Label>
                     &nbsp;</td>
            <td style="width: 90%; height: 50px; " >
                     <asp:LinkButton ID="LinkButton1" runat="server" ForeColor="#b22222"  Font-Overline =false 
                    PostBackUrl="~/backwork/Login.aspx" style="float :right ;    "
                             Width="84px" >后台登录</asp:LinkButton>
            </td>
        </tr>
        <tr>
            <td style="width: 90%; height: 50px; text-align: center;" colspan="2">
               <asp:LinkButton ID="outside_button" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Underline="false" ForeColor="white" Width="200px" PostBackUrl="~/OverseaSelect.aspx">国际机票</asp:LinkButton>
                <asp:LinkButton ID="inside_button" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Underline="False" ForeColor="white" Width="200px" PostBackUrl="~/DomesticSelecet.aspx">国内机票</asp:LinkButton>
                <asp:LinkButton ID="suggesttion_button" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Underline="False" ForeColor="white" Width="200px" PostBackUrl="~/Suggest.aspx">建议和投诉</asp:LinkButton>
                <asp:LinkButton ID="time_button" runat="server" Font-Overline="False" ForeColor="White"
                    Font-Bold="True" Font-Names="微软雅黑" Width="150px" Font-Underline="False" PostBackUrl="~/TimeDifference.aspx">世界时差</asp:LinkButton>
                <asp:LinkButton ID="payment_button" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Overline="False" ForeColor="white" Width="200px" Font-Underline="False"
                    PostBackUrl="~/Payment.aspx">付款方式</asp:LinkButton>
            </td>
        </tr>
      
    </table>
    <div>
   
    
         <table style="z-index: 106; left: 10px; width:1200px; position: absolute; top: 284px;background-color: #5296b5;
             height: 542px">
             <tr>
                 <td style="width: 100px">
                     <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AutoGenerateColumns="False"
                         BackColor="White" BorderColor="#DEDFDE" BorderStyle="None" BorderWidth="1px"
                         CellPadding="4" ForeColor="Black" GridLines="Vertical" Height="517px" PageSize="15" OnRowEditing="GridView1_RowEditing" OnRowDataBound="GridView1_RowDataBound"
                         Style="font: caption; text-align: center" Width="943px" OnPageIndexChanging="GridView1_PageIndexChanging">
                         <PagerSettings FirstPageText="首页" LastPageText="尾页" NextPageText="下页"
                             PreviousPageText="上页" Mode="NextPrevious" />
                         <FooterStyle BackColor="#CCCC99" />
                         <Columns>
                             <asp:BoundField DataField="company_type" HeaderText="航空公司" />
                             <asp:BoundField DataField="starting_city" HeaderText="出发城市" />
                             <asp:BoundField DataField="terminus_city" HeaderText="抵达城市" />
                             <asp:BoundField DataField="OneWay_price" HeaderText="单程票价" />
                             <asp:BoundField DataField="GoAndBack_price" HeaderText="往返票价" />
                             <asp:BoundField DataField="flight_type" HeaderText="飞机型号" />
                             <asp:BoundField DataField="starting_time" HeaderText="起飞时间" />
                             <asp:BoundField DataField="arriving_time" HeaderText="抵达时间" />
                             <asp:CommandField ButtonType="Button" EditText="预定" ShowEditButton="True" />
                         </Columns>
                         <RowStyle BackColor="#F7F7DE"  Font-Size =X-Small />
                         <SelectedRowStyle BackColor="#CE5D5A" Font-Bold="True" ForeColor="White" />
                         <PagerStyle BackColor="#F7F7DE" ForeColor="Black" HorizontalAlign="Right" />
                         <HeaderStyle BackColor="#6B696B" Font-Bold="True" ForeColor="White" />
                         <AlternatingRowStyle BackColor="White" />
                         <EmptyDataTemplate >抱歉，您查询的信息不存在</EmptyDataTemplate>
                     </asp:GridView>
                 </td>
             </tr>
         </table>
         <asp:Label ID="Label1" runat="server" Font-Bold="True" Font-Names="华文仿宋" ForeColor="#404040"
             Style="z-index: 107; left: 26px; position: absolute; top: 263px" Text="Label"
             Width="166px"></asp:Label>
    </div>
    </form>
</body>
</html>
