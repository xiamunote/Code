<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Suggest.aspx.cs" Inherits="Suggest" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>机票预订</title>
<script language="javascript" type="text/javascript">



</script>
    <style type="text/css">
        .style1
        {
            color: white;
        }
        .style2
        {
            color: white;
            font-size: medium;
        }
        .style3
        {
            font-size: medium;
        }
        .style4
        {
            font-size: small;
        }
    </style>
</head>
<body >
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
    <div>
    <table style="background-color: #5296b5" width ="1200px"><tr><td>
          
            <table style="z-index: 101; left: 351px; position: relative; top: 0px; width: 711px; height: 23px; border-right: #6699ff thin solid; border-top: #6699ff thin solid; border-left: #6699ff thin solid; border-bottom: #6699ff thin solid;" id="TABLE1" onclick="return TABLE1_onclick()">
            <tr>
                <td style="width: 158px; height: 30px; background-image: url(images/pointout_line.jpg); font: caption;">
                    &nbsp; <span class="style1">&nbsp;<span class="style3">建议和投诉</span></span></td>
            </tr>
            <tr>
                <td style="width: 158px; height: 421px; vertical-align: top; text-align: left; font: caption;">
                    <asp:Label ID="travel_infor" runat="server" Style="z-index: 100; left: 71px; position: absolute;
                        top: 69px; color: #FFFFFF; font-size: small;" Text="请填写您的建议:" Width="127px"></asp:Label>
                    &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;
                    <asp:TextBox ID="inform" runat="server" Height="79px" Style="z-index: 101; left: 71px;
                        position: absolute; top: 87px" Width="341px" TextMode="MultiLine" ValidationGroup="q"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="inform"
                        ErrorMessage="*" Style="z-index: 102; left: 430px; position: absolute; top: 155px"
                        Width="20px" ValidationGroup="q"></asp:RequiredFieldValidator>
                    <asp:Label ID="Label1" runat="server" Style="z-index: 103; left: 83px; position: absolute;
                        top: 212px; color: #FFFFFF; font-size: small;" Text="联系人：" Width="64px"></asp:Label>
                    <asp:Label ID="Label2" runat="server" Style="z-index: 104; left: 83px; position: absolute;
                        top: 254px; text-align: justify; color: #FFFFFF; font-size: small;" Text="E_mail：" 
                        Width="64px"></asp:Label>
                    <asp:Label ID="Label3" runat="server" Style="z-index: 105; left: 83px; position: absolute;
                        top: 298px; text-align: justify; color: #FFFFFF; font-size: small;" Text="手  机：" 
                        Width="64px"></asp:Label>
                    <asp:Label ID="Label4" runat="server" Style="z-index: 106; left: 83px; position: absolute;
                        top: 341px; color: #FFFFFF; font-size: small; right: 560px;" Text="电  话：" 
                        Width="64px"></asp:Label>
                    <asp:TextBox ID="relator" runat="server" Style="z-index: 107; left: 160px; position: absolute;
                        top: 208px" ValidationGroup="q"></asp:TextBox>
                    <asp:TextBox ID="email" runat="server" Style="z-index: 108; left: 160px; position: absolute;
                        top: 251px" ValidationGroup="q"></asp:TextBox>
                    <asp:TextBox ID="mobilephone" runat="server" Style="z-index: 109; left: 160px; position: absolute;
                        top: 294px" ValidationGroup="q"></asp:TextBox>
                    <asp:TextBox ID="telephone" runat="server" Style="z-index: 110; left: 160px; position: absolute;
                        top: 337px"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="*"
                        Style="z-index: 111; left: 325px; position: absolute; top: 213px" ControlToValidate="relator" ValidationGroup="q"></asp:RequiredFieldValidator>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ErrorMessage="*"
                        Style="z-index: 112; left: 325px; position: absolute; top: 298px" ControlToValidate="mobilephone" ValidationGroup="q"></asp:RequiredFieldValidator>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ErrorMessage="*"
                        Style="z-index: 116; left: 325px; position: absolute; top: 256px" ControlToValidate="email" ValidationGroup="q"></asp:RequiredFieldValidator>
                    <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ErrorMessage="*"
                        Style="z-index: 113; left: 325px; position: absolute; top: 256px" ControlToValidate="email" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" ValidationGroup="q"></asp:RegularExpressionValidator>
                    <asp:Button ID="submit_button" runat="server" Height="30px" Style="z-index: 114;
                        left: 210px; vertical-align: middle; position: absolute; top: 392px" Text="提交" Width="69px" OnClick="submit_button_Click1" ValidationGroup="q"  />
                    
                </td>
            </tr>
        </table>
            </td><td>
            
         <table style="z-index: 104; left: 87px; position: absolute; top: 272px; width: 271px; height: 300px; border-right: #6699ff thin solid; border-top: #6699ff thin solid; border-left: #6699ff thin solid; border-bottom: #6699ff thin solid;">
             <tr>
                 <th align="left" style="width: 238px; height: 16px; font: caption; background-image: url(images/pointout_line.jpg);" valign="middle">
                     &nbsp;&nbsp;<span class="style2">投诉细项</span></th>
             </tr>
             <tr>
                 <th align="left"  style="width: 238px; height: 131px; color: dimgray; " valign="middle">
                     <span class="style1">1、</span><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                         mso-bidi-language: AR-SA; color: #FFFFFF;" class="style4">票价较别处为高<br />
                         2、</span><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                             mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                             mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                             mso-bidi-language: AR-SA"><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                         mso-bidi-language: AR-SA; color: #FFFFFF;" class="style4">信息反馈速度慢<br />
                             3、</span></span><span style="font-size: 10.5pt; font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                         mso-bidi-language: AR-SA; color: #FFFFFF;"><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                                 mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                                 mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                                 mso-bidi-language: AR-SA"><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                         mso-bidi-language: AR-SA; color: #FFFFFF;" class="style4">客服人员业务水平较差<br />
                                 4、</span></span><span style="font-size: 10.5pt; font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                             mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                             mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                             mso-bidi-language: AR-SA"><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                                     mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                                     mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                                     mso-bidi-language: AR-SA"><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                         mso-bidi-language: AR-SA; color: #FFFFFF;" class="style4">客服人员服务态度较差<br />
                                     5、</span></span><span style="font-size: 10.5pt; font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                                 mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                                 mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                                 mso-bidi-language: AR-SA"><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                                         mso-bidi-language: AR-SA"><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                         mso-bidi-language: AR-SA; color: #FFFFFF;" class="style4">其它</span></span><span lang="EN-US"><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                                         mso-bidi-language: AR-SA"><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                         mso-bidi-language: AR-SA; color: #FFFFFF;" class="style4">?<br />
                                             <br />
                                             </span></span><span style="font-size: 10.5pt; font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                                     mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                                     mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                                     mso-bidi-language: AR-SA"><span style="font-size: 10.5pt; font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                                         mso-bidi-language: AR-SA">
                                             <span 
                         style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-font-family: Calibri;
                                                 mso-ascii-theme-font: minor-latin; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri;
                                                 mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi;
                                                 mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR-SA" 
                         class="style4">
                                                 投诉电话</span></span><span lang="EN-US" style="font-family: 'Calibri','sans-serif';
                                                     mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-latin; mso-fareast-theme-font: minor-fareast;
                                                     mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi;
                                                     mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR-SA;
                                                     mso-fareast-font-family: 宋体"><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                                         mso-bidi-language: AR-SA"><span style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                         mso-bidi-language: AR-SA; color: #FFFFFF;" class="style4">:85434536<br />
                                                     </span></span></span><span lang="EN-US" style="font-size: 10.5pt; font-family: 'Calibri','sans-serif';
                                                     mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-latin; mso-fareast-theme-font: minor-fareast;
                                                     mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi;
                                                     mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR-SA;
                                                     mso-fareast-font-family: 宋体"><span style="font-size: 10.5pt; font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-fareast;
                                         mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-fareast; mso-bidi-font-family: 'Times New Roman';
                                         mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: ZH-CN;
                                         mso-bidi-language: AR-SA">
                                                     <span 
                         style="font-family: 宋体; mso-bidi-font-size: 11.0pt; mso-ascii-font-family: Calibri;
                                                         mso-ascii-theme-font: minor-latin; mso-fareast-theme-font: minor-fareast; mso-hansi-font-family: Calibri;
                                                         mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi;
                                                         mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR-SA" 
                         class="style4">
                                                         投诉E-mail</span><span lang="EN-US" style="font-family: 'Calibri','sans-serif';
                                                             mso-bidi-font-size: 11.0pt; mso-ascii-theme-font: minor-latin; mso-fareast-theme-font: minor-fareast;
                                                             mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi;
                                                             mso-ansi-language: EN-US; mso-fareast-language: ZH-CN; mso-bidi-language: AR-SA;
                                                             mso-fareast-font-family: 宋体" 
                         class="style4">:wangxy@sina.com</span></span></span></span></span></span></span></span></th>
             </tr>
         </table>
   </td></tr></table>
    </div>
    </form>
</body>
</html>
