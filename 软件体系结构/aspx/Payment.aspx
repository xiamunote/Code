<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Payment.aspx.cs" Inherits="Payment" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>机票预订</title>
    <style type="text/css">
        .style2
        {
            width: 100px;
            height: 67px;
            font-size: small;
        }
        .style3
        {
            width: 485px;
            color: white;
            height: 67px;
        }
        .style4
        {
            width: 100px;
            height: 32px;
            font-size: small;
        }
        .style5
        {
            width: 485px;
            height: 32px;
            font-size: small;
        }
        .style6
        {
            width: 100px;
            height: 38px;
            font-size: small;
        }
        .style7
        {
            width: 485px;
            height: 38px;
            font-size: small;
        }
        .style8
        {
            width: 100px;
            height: 252px;
            font-size: small;
        }
        .style9
        {
            width: 485px;
            height: 252px;
            font-weight: bold;
            color: white;
        }
        .style10
        {
            width: 100px;
            height: 72px;
            font-size: small;
        }
        .style11
        {
            width: 485px;
            height: 72px;
            font-size: small;
        }
        .style12
        {
            font-size: small;
        }
    </style>
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
    <table style="width:1200px" background="images/bg3.gif" cellpadding="0" cellspacing="0" >
        <tr>
            <td style="width: 90%; height: 50px; " >
                <asp:Label ID="date" runat="server" Text="Label" Width="134px" Font-Bold="True"
                    Font-Names="华文仿宋" ForeColor="#b22222"></asp:Label>
                <asp:Label ID="weekdate" runat="server" Font-Bold="True" Font-Names="华文仿宋" ForeColor="#b22222"
                    Text="Label" Width="74px"></asp:Label>
                     &nbsp;</td>
            <td style="width: 90%; height: 50px; " >
                     <asp:LinkButton ID="LinkButton2" runat="server" ForeColor="#b22222"  Font-Overline =false 
                    PostBackUrl="~/backwork/Login.aspx" style="float :right ;    "
                             Width="84px" >后台登录</asp:LinkButton>
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
   
      
        <div style=" background-color :#5296b5; color :White; height :600;  width :1200px ">
            <table width ="800"  border =1 
                style ="border-collapse :collapse; height: 435px;" align=center >
                <tr>
                    <td nowrap="nowrap" style="font-weight: bold;" class="style6">
                        送票服务</td>
                    <td nowrap="nowrap" style="font-weight: bold; " align="left" class="style7">
                        注：如果您需要送票服务，请确认您个人信息是否正确，以便工作人员与您取得联系</td>
                </tr>
                <tr>
                    <td nowrap="nowrap" style="font-weight: bold;" class="style4">
                        上门取票</td>
                    <td nowrap="nowrap" style="font-weight: bold; " class="style5">
                        北京市海淀区茂昌街航空大厦8楼</td>
                </tr>
                <tr>
                    <td nowrap="nowrap" style="font-weight: bold;" class="style2">
                        银行电汇</td>
                    <td nowrap="nowrap" style="font-weight: bold; " class="style3">
                        <span class="style12">开户名称：春秋航空公司</span><br class="style12" />
                        <span class="style12">开户支行：中国工商银行银行北京崇文支行</span><br class="style12" />
                        <span class="style12">汇款账号：6567673254里65654</span></td>
                </tr>
                <tr>
                    <td nowrap="nowrap" style="font-weight: bold;" class="style8">
                        个人账户</td>
                    <td nowrap="nowrap" class="style9">
                        <span class="style12">1、中国建设银行</span><br class="style12" />
                        <span class="style12">持卡人：李强
                        卡号：0454565656565656565</span><br class="style12" />
                        <span class="style12">2)交通银行</span><br class="style12" />
                        <span class="style12">持卡人：李强
                        卡号：0565656565656556562</span><br class="style12" />
                        <span class="style12">3、中国工商银行</span><br class="style12" />
                        <span class="style12">持卡人：李强
                        卡号：7435546745565655354</span><br class="style12" />
                        <span class="style12">4、招商银行</span><br class="style12" />
                        <span class="style12">持卡人：李强
                        卡号：23434567654567887654</span><br class="style12" />
                        <span class="style12">5、中国农业银行</span><br class="style12" />
                        <span class="style12">持卡人：李强
                        卡号：66344554544545456555</span><br class="style12" />
                        <span class="style12">6、中国银行</span><br class="style12" />
                        <span class="style12">持卡人：李强</span><br class="style12" />
                        <span class="style12">卡号：4567787785789898550</span><br class="style12" />
                        <span class="style12">7、浦东发展银行</span><br class="style12" />
                        <span class="style12">持卡人：李强
                        卡号：056757676784324565655</span></td>
                </tr>
                <tr>
                    <td nowrap="nowrap" style="font-weight: bold;" class="style10">
                        电话</td>
                    <td nowrap="nowrap" style="font-weight: bold; " class="style11">
                        051-90865443 &nbsp;&nbsp; 136623589604</td>
                </tr>
                </table>
        </div>
      
    <table width="1200px" border="0" cellpadding="0" cellspacing="0" style =" clear :both " >
        <tr>
            <td background="images/bg11.gif" align="right" width="258" height="52">
                <img src="images/spacer.gif" width="101" height="1"><br>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>
