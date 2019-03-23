<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ManageOrder.aspx.cs" Inherits="ManageOrder" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>航班详细信息</title>
    <style type="text/css">
        .style1
        {
            color: #FFFFFF;
        }
        .style2
        {
            width: 138px;
            height: 32px;
            color: #FFFFFF;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
       <table width="1200px" border="0" cellpadding="0" cellspacing="0" background="images/bg1.gif">
        <tr>
            <td width="100%" align="left" height="90">
             <img src ="images/l.png" />
            </td>
            <td>
                <img src="images/spacer.gif" width="101" height="1" /><br>
            </td>
        </tr>
    </table>
    <table style="width:1200px" background="images/bg3.gif" cellpadding="0" cellspacing="0" >
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
            <td style="width: 1200px; height: 50px; text-align: center;" colspan="2">
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
    
    </div>
        <table style="font: caption; background-color :#5296b5" cellpadding ="0" cellspacing ="0">
            <tr>
                <td style="width: 95px; height: 30px" class="style1">
                    <asp:Label ID="Label1" runat="server" Text="航空公司：" Width="98px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 138px; height: 30px" class="style1">
                    <asp:Label ID="company" runat="server" Text="Label" Width="148px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 61px; height: 30px" class="style1">
                    <asp:Label ID="Label6" runat="server" Text="单程票价：" Width="98px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 150px; height: 30px" class="style1">
                    <asp:Label ID="aprice" runat="server" Text="Label" Width="148px" 
                        style="font-size: small"></asp:Label></td>
            </tr>
            <tr>
                <td style="width: 95px; height: 30px" class="style1">
                    <asp:Label ID="Label2" runat="server" Text="飞机型号：" Width="98px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 138px; height: 30px" class="style1">
                    <asp:Label ID="ftype" runat="server" Text="Label" Width="148px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 61px; height: 30px" class="style1">
                    <asp:Label ID="Label7" runat="server" Text="往返票价：" Width="98px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 150px; height: 30px" class="style1">
                    <asp:Label ID="bprice" runat="server" Text="Label" Width="148px" 
                        style="font-size: small"></asp:Label></td>
            </tr>
            <tr>
                <td style="width: 95px; height: 30px" class="style1">
                    <asp:Label ID="Label3" runat="server" Text="起飞机场：" Width="98px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 138px; height: 30px" class="style1">
                    <asp:Label ID="aport" runat="server" Text="Label" Width="148px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 61px; height: 30px" class="style1">
                    <asp:Label ID="Label8" runat="server" Text="起飞时间：" Width="98px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 150px; height: 30px" class="style1">
                    <asp:Label ID="at" runat="server" Text="Label" Width="148px" 
                        style="font-size: small"></asp:Label></td>
            </tr>
            <tr>
                <td style="width: 95px; height: 30px" class="style1">
                    <asp:Label ID="Label4" runat="server" Text="降落机场：" Width="98px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 138px; height: 30px" class="style1">
                    <asp:Label ID="bport" runat="server" Text="Label" Width="148px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 61px; height: 30px" class="style1">
                    <asp:Label ID="Label9" runat="server" Text="降落时间：" Width="98px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 150px; height: 30px" class="style1">
                    <asp:Label ID="bt" runat="server" Text="Label" Width="148px" 
                        style="font-size: small"></asp:Label></td>
            </tr>
            <tr>
                <td style="width: 95px; height: 30px" class="style1">
                    <asp:Label ID="Label5" runat="server" Text="机舱类型：" Width="98px" 
                        style="font-size: small"></asp:Label></td>
                <td class="style2">
                    <asp:DropDownList ID="bunktype" runat="server">
                        <asp:ListItem>经济舱</asp:ListItem>
                        <asp:ListItem>头等舱</asp:ListItem>
                    </asp:DropDownList></td>
                <td style="width: 61px; height: 32px" class="style1">
                    <asp:Label ID="Label10" runat="server" Text="订票数量：" Width="98px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 150px; height: 32px">
                    <asp:TextBox ID="num" runat="server" Width="43px"></asp:TextBox></td>
            </tr>
            <tr>
                <td style="height: 53px; text-align: center;" colspan="4">
                    <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="填写详单" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:Button ID="Button2" runat="server" Text="关闭窗口" /></td>
            </tr>
           
        </table>
    </form>
</body>
</html>
