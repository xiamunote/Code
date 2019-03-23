<%@ Page Language="C#" AutoEventWireup="true" CodeFile="TimeDifference.aspx.cs" Inherits="TimeDifference" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>机票预订</title>
    <style type="text/css">
        .style1
        {
            height: 23px;
            width: 280px;
        }
        .style2
        {
            width: 280px;
            font-size: small;
            color: #FFFFFF;
        }
        .style5
        {
            height: 23px;
            width: 290px;
        }
        .style6
        {
            width: 290px;
            font-size: small;
            color: #FFFFFF;
        }
        .style7
        {
            height: 23px;
            width: 251px;
        }
        .style8
        {
            width: 251px;
            font-size: small;
            color: #FFFFFF;
        }
        .style9
        {
            font-size: small;
            color: #FFFFFF;
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
    <table style="width: 1200px" background="images/bg3.gif" cellpadding="0" cellspacing="0" >
        <tr>
            <td style="width: 90%; height: 50px; " >
                <asp:Label ID="date" runat="server" Text="Label" Width="134px" Font-Bold="True"
                    Font-Names="华文仿宋" ForeColor="#b22222"></asp:Label>
                <asp:Label ID="weekdate" runat="server" Font-Bold="True" Font-Names="华文仿宋" ForeColor="#b22222"
                    Text="Label" Width="74px"></asp:Label>
                     </td>
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
                
            </td>
        </tr>
    </table>
  
    <table style="background-color :#5296b5; width :1200px">
                   <tr><td height="44" >        &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;         
        <asp:Label ID="Label1" runat="server" 
            Text="Label" Width="451px" style="color: #FFFFFF; font-weight: 700; font-size: large"></asp:Label>
           </td></tr> <tr><td>
        <table  border ="1"   align=center  style ="border-collapse :collapse ">
            <tr>
                <td align="center" nowrap="nowrap" 
                    style="background-color: lightsteelblue; font-weight: bold; font-size: medium; font-family: 微软雅黑;" 
                    valign="middle" class="style5">
                    国     家</td>
                <td align="center" nowrap="nowrap" 
                    style="background-color: lightsteelblue; font-weight: bold; font-size: medium; font-family: 微软雅黑;" 
                    valign="middle" class="style7">
                    城     市</td>
                <td align="center" nowrap="nowrap" 
                    style="background-color: lightsteelblue; font-weight: bold; font-size: medium; font-family: 微软雅黑;" 
                    valign="middle" class="style1">
                    与北京时差</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    美    国</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    旧  金  山</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -16</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    墨 西 哥</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    墨西哥城</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -15</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    美    国</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    纽     约</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -13</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    巴 拿 马</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    巴拿马城</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -13</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    加 拿 大</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    蒙特利尔</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -13</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    古    巴</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    哈  瓦  那</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -13</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    法    国</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    巴     黎</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -8</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    英    国</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    伦     敦</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -8</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    意 大 利</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    罗     马</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -7</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    东    德</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    柏     林</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -7</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    波    兰</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    华     沙</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -7</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    瑞    士</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    日  内  瓦</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -7</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    捷    克</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    布  拉 格</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -7</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    匈 牙 利</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    布达佩斯</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -7</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    罗马尼亚</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    布加勒斯特</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -6</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    新 加 坡</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    新  加  坡</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -0.30</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    印    尼</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    雅  加  达</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -0.30</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    马来西亚</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    吉  隆  坡</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -0.30</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    菲 律 宾</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    马  尼  拉</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -0.30</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    斯里兰卡</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    科  伦  城</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -2.30</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    朝    鲜</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    平     壤</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    +1</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    日    本</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    东     京</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    +1</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    澳大利亚</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    悉     尼</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    +2（夏时制）</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    埃    及</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    开     罗</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -6</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    印    度</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    新  德  里</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -2.30</td>
            </tr>
            <tr>
                <td align="center" nowrap="nowrap" valign="middle" class="style6">
                    俄 罗 斯</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style8">
                    莫  斯  科</td>
                <td align="center" nowrap="nowrap" valign="middle" class="style2">
                    -5</td>
            </tr>
            <tr>
                <td align="left" colspan="3" nowrap="nowrap" valign="middle" class="style9">
                    注意：夏时制时仅仅相差一小时。（北京——悉尼）。</td>
            </tr>
        </table>
      </td></tr></table> 
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
