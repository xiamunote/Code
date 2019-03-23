<%@ Page Language="C#" AutoEventWireup="true" CodeFile="OverseaSelect.aspx.cs" Inherits="OverseaSelect" %>


<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>机票预订</title>
   
    <style type="text/css">
        .style2
        {
            width: 162px;
            height: 42px;
        }
        .style3
        {
            width: 162px;
            height: 28px;
        }
        .style5
        {
            width: 384px;
            height: 42px;
        }
        .style6
        {
            width: 384px;
            height: 28px;
        }
        .style7
        {
            width: 162px;
            height: 24px;
        }
        .style8
        {
            width: 384px;
            height: 24px;
        }
        .style9
        {
            vertical-align: middle;
            height: 30px;
            color: #FFFFFF;
            font-size: medium;
            background-image: url('images/pointout_line.jpg');
            font-weight: bold;
        }
    </style>
</head>
<body >
    <form id="form1" runat="server">
       <table width="1200px" border="0" cellpadding="0" cellspacing="0" background="images/bg1.gif">
        <tr>
            <td width="1200px" align="left" height="100"> <img src ="images/l.png" />
            </td>
            <td>
                <img src="images/spacer.gif" width="101" height="1" /><br>
            </td>
        </tr>
    </table>
    <table style="width: 1200px" background="images/bg3.gif" cellpadding="0" cellspacing="0" >
        <tr>
            <td style="width:1200px; height: 50px; " >
                <asp:Label ID="date" runat="server" Text="Label" Width="134px" Font-Bold="True"
                    Font-Names="华文仿宋" ForeColor="#b22222"></asp:Label>
                <asp:Label ID="weekdate" runat="server" Font-Bold="True" Font-Names="华文仿宋" ForeColor="#b22222"
                    Text="Label" Width="74px"></asp:Label>
                     </td>
            <td style="width: 1200px; height: 50px; " >
                     <asp:LinkButton ID="LinkButton2" runat="server" ForeColor="#b22222"  Font-Overline =false 
                    PostBackUrl="~/backwork/Login.aspx" style="float :right ;    "
                             Width="84px" >后台登录</asp:LinkButton>
            </td>
        </tr>
        <tr>
            <td style="width: 1200px; height: 50px; text-align: center;" colspan="2">
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
                
            </td>
        </tr>
    </table>
    <div style="vertical-align: top; text-align: left;background-color: #5296b5; width :1200px" >
     
        <table align=center  style="background-color: #5296b5;border-right: #6699ff thin solid; border-top: #6699ff thin solid; border-left: #6699ff thin solid; border-bottom: #6699ff thin solid;">
           <tr><td colspan="2" >   </td></tr>
            <tr>
                <td
                    colspan="2" class="style9">
                    国际机票查询</td>
            </tr>
            <tr>
                <td style="font: caption; vertical-align: bottom; text-align: center; color: dimgray;" 
                    align="left" class="style2">
                    <asp:Label ID="Label2" runat="server"  ForeColor =White  Text="出发城市：" 
                        style="font-size: small"></asp:Label>
                    
                    </td>
                <td style="font: caption; vertical-align: bottom; text-align: left; color: dimgray;" 
                    align="left" class="style5">
                    <asp:DropDownList ID="DropDownList1" runat="server" Width="110px">
                        <asp:ListItem>北京</asp:ListItem>
                        <asp:ListItem>上海</asp:ListItem>
                        <asp:ListItem>广州</asp:ListItem>
                        <asp:ListItem>哈尔滨</asp:ListItem>
                    </asp:DropDownList>
                        
                      </td>
            </tr>
            <tr>
                <td style="font: caption; vertical-align: bottom; text-align: center; color: dimgray;" 
                    align="left" class="style3">
                    <asp:Label ID="Label4" runat="server"  ForeColor =White Text="出发日期：" 
                        style="font-size: small"></asp:Label>
                    </td>
                <td style="font: caption; vertical-align: bottom; text-align: left; color: dimgray;" 
                    align="left" class="style6">
                    <asp:TextBox ID="TextBox1" runat="server" Width="144px" ValidationGroup="z" 
                        style="text-align: left"></asp:TextBox>
                 
                  
                   
                    <asp:Button ID="Button1" runat="server" Text="日期选择" onclick="Button1_Click" />
                  
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="请填写出发日期"
                         ControlToValidate="TextBox1" ValidationGroup="z"></asp:RequiredFieldValidator>
                    <asp:Calendar ID="Calendar1" runat="server" Visible =false
                        onselectionchanged="Calendar1_SelectionChanged"  ></asp:Calendar>
                  
                   
                    </td>
            </tr>
            <tr>
                <td style="font: caption; vertical-align: bottom; text-align: center; color: dimgray;" 
                    align="left" class="style7">
                    <asp:Label ID="Label3" ForeColor =White  runat="server"  Text="抵达城市：" 
                        style="font-size: small"></asp:Label>
                    </td>
                <td style="font: caption; vertical-align: bottom; text-align: left; color: dimgray;" 
                    align="left" class="style8">
                      <asp:TextBox ID="st_city" runat="server" Width="144px" ValidationGroup="z"></asp:TextBox>
                       <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="请填写到抵达城市"
                        ControlToValidate="st_city" ValidationGroup="z"></asp:RequiredFieldValidator>
                    </td>
            </tr>
              <tr>
                <td style="height:49px; font: caption; vertical-align: bottom; text-align:center; color: dimgray;" 
                    align="left" colspan="2">
                    <asp:Button ID="select_button" runat="server" Height="24px"  Text="查询" Width="63px" OnClick="select_button_Click" ValidationGroup="z" />
                    </td>
            </tr>
            </table>
    <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" style =" clear :both " >
        <tr>
            <td background="images/bg11.gif" align="right" width="258" height="52">
                <img src="images/spacer.gif" width="101" height="1"><br>
            </td>
        </tr>
    </table>
    
    </form>
</body>
</html>
