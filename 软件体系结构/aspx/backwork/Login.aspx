<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="backwork_login" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
   
</head>
<body>
    <form id="form1" runat="server">
    <div>
   
        <table style="font: caption; z-index: 100; left: 336px; position: absolute; top: 85px; width: 547px; height: 283px; background-image: url(../images/logo.png); border-right: #1b20d8 thin solid; border-top: #1b20d8 thin solid; border-left:#1b20d8 thin solid; border-bottom: #1b20d8 thin solid;">
            <tr>
                <td colspan="2" style="font: caption; height: 89px;text-align: center">
                    </td>
            </tr>
            <tr>
                <td style="width: 160px; height: 11px">
                    <asp:Label ID="Label1" runat="server" Height="14px" Style="z-index: 100; left: 184px;
                        position: absolute; top: 102px; font-size:x-small;" Text="用户名：" 
                        Width="56px"></asp:Label>
                </td>
                <td style="width: 201px; height: 11px">
                    <asp:TextBox ID="TextBox1" runat="server" Width="139px"></asp:TextBox></td>
            </tr>
            <tr>
                <td style="width: 160px; height: 16px">
                    &nbsp;
                    <asp:Label ID="Label2" runat="server" Style="z-index: 100; left: 184px; position: absolute;
                        top: 131px; font-size: x-small;" Text="密　码：" Width="56px"></asp:Label>
                </td>
                <td style="width: 201px; height: 16px">
                    <asp:TextBox ID="TextBox2" runat="server" TextMode="Password"></asp:TextBox></td>
            </tr>
            <tr>
                <td style="width: 160px; height: 16px">
                    <asp:Label ID="idcode" runat="server" Style="z-index: 100; left: 184px; position: absolute;
                        top: 160px; font-size: x-small;" Text="验证码：" Width="56px"></asp:Label>
                </td>
                <td style="width: 201px; height: 16px">
                    <asp:TextBox ID="TextBox3" runat="server" Width="139px"></asp:TextBox></td>
            </tr>
            <tr>
                <td colspan="2" style="height: 35px">
                    <asp:Image ID="showidcode" runat="server" Height="34px" ImageUrl="~/backwork/ValiCode.aspx"
                        Style="z-index: 100; left: 244px; position: absolute; top: 187px" Width="68px" />
                    <asp:LinkButton ID="changeidcode" runat="server" OnClick="changeidcode_Click" Style="z-index: 102;
                        left: 333px; position: absolute; top: 201px; font-size: small;">看不清</asp:LinkButton>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="height: 31px">
                    <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/images/loginButton.png"
                        Style="z-index: 100; left: 149px; position: absolute; top: 227px" OnClick="ImageButton1_Click" Height="28px" Width="87px" />
                    <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/images/reset.png"
                        Style="z-index: 102; left: 310px; position: absolute; top: 227px" Height="28px" Width="87px" OnClick="ImageButton2_Click" />
                </td>
            </tr>
            <tr>
                <td colspan="2" style="height: 16px;">
                </td>
            </tr>
        </table>
    
    </div>
    </form>
</body>
</html>
