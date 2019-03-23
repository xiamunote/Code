<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ShowOversea.aspx.cs"
    Inherits="ShowOversea" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>机票预订</title>
</head>
<body>
    <form id="form1" runat="server">
    <table width="1200px" border="0" cellpadding="0" cellspacing="0" background="images/bg1.gif">
        <tr>
            <td width="100%" align="left" height="100">
                <img src="images/l.png" />
            </td>
            <td>
                <img src="images/spacer.gif" width="101" height="1" /><br>
            </td>
        </tr>
    </table>
    <table style="width: 1200px" background="images/bg3.gif" cellpadding="0" cellspacing="0">
        <tr>
            <td style="width: 90%; height: 50px;">
                <asp:Label ID="date" runat="server" Text="Label" Width="134px" Font-Bold="True"
                    Font-Names="华文仿宋" ForeColor="#b22222"></asp:Label>
                <asp:Label ID="weekdate" runat="server" Font-Bold="True" Font-Names="华文仿宋" ForeColor="#b22222"
                    Text="Label" Width="74px"></asp:Label>
                &nbsp;
            </td>
            <td style="width: 90%; height: 50px;">
                <asp:LinkButton ID="LinkButton2" runat="server" ForeColor="#b22222" Font-Overline="false"
                    PostBackUrl="~/backwork/Login.aspx" Style="float: right;" Width="84px">后台登录</asp:LinkButton>
            </td>
        </tr>
        <tr>
            <td style="width: 90%; height: 50px; text-align: center;" colspan="2">
                <asp:LinkButton ID="LinkButton3" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Underline="false" ForeColor="white" Width="200px" PostBackUrl="~/OverseaSelect.aspx">国际机票</asp:LinkButton>
                <asp:LinkButton ID="LinkButton4" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Underline="False" ForeColor="white" Width="200px" PostBackUrl="~/DomesticSelecet.aspx">国内机票</asp:LinkButton>
                <asp:LinkButton ID="LinkButton5" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Underline="False" ForeColor="white" Width="200px" PostBackUrl="~/Suggest.aspx">建议和投诉</asp:LinkButton>
                <asp:LinkButton ID="LinkButton6" runat="server" Font-Overline="False" ForeColor="White"
                    Font-Bold="True" Font-Names="微软雅黑" Width="150px" Font-Underline="False" PostBackUrl="~/TimeDifference.aspx">世界时差</asp:LinkButton>
                <asp:LinkButton ID="LinkButton7" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Overline="False" ForeColor="white" Width="200px" Font-Underline="False"
                    PostBackUrl="~/Payment.aspx">付款方式</asp:LinkButton>
            </td>
        </tr>
        <tr>
            <td style="width: 100px; height: 38px;" colspan="2">
                &nbsp;
            </td>
        </tr>
    </table>
    <div style="width: 1200px; background-color: #5296b5; height: 542px">
   
        <table>
            <tr>
                <td style="width: 100px">
                    <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AutoGenerateColumns="False"
                        BackColor="White" BorderColor="#DEDFDE" BorderStyle="None" BorderWidth="1px"
                        CellPadding="4" ForeColor="Black" GridLines="Vertical" Height="517px" PageSize="15"
                        Style="font: caption; text-align: center" Width="943px" OnPageIndexChanging="GridView1_PageIndexChanging">
                        <PagerSettings FirstPageText="首页" LastPageText="尾页" NextPageText="下页" PreviousPageText="上页"
                            Mode="NextPreviousFirstLast" />
                        <FooterStyle BackColor="#CCCC99" />
                        <Columns>
                            <asp:BoundField DataField="ctype" HeaderText="航空公司" />
                            <asp:BoundField DataField="oprice" HeaderText="单程票价" />
                            <asp:BoundField DataField="bprice" HeaderText="往返票价" />
                            <asp:BoundField DataField="ftype" HeaderText="飞机型号" />
                            <asp:BoundField DataField="stime" HeaderText="起飞时间" />
                            <asp:BoundField DataField="atime" HeaderText="抵达时间" />
                        </Columns>
                        <RowStyle BackColor="#F7F7DE" />
                        <SelectedRowStyle BackColor="#CE5D5A" Font-Bold="True" ForeColor="White" />
                        <PagerStyle BackColor="#F7F7DE" ForeColor="Black" HorizontalAlign="Right" />
                        <HeaderStyle BackColor="#6B696B" Font-Bold="True" ForeColor="White" />
                        <AlternatingRowStyle BackColor="White" />
                    </asp:GridView>
                </td>
            </tr>
        </table>
    </div>
    </form>
    
</body>
</html>
