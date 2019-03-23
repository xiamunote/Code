<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AlterPW.aspx.cs" Inherits="backwork_AlterPassword" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
    <style type="text/css">
        .style1
        {
            height: 97px;
            width: 368px;
        }
        .style2
        {
            height: 26px;
            width: 368px;
        }
        .style3
        {
            width: 368px;
        }
        .style4
        {
            height: 25px;
            width: 368px;
        }
        .style5
        {
            height: 394px;
            width: 368px;
        }
        .style6
        {
            height: 97px;
            width: 124px;
        }
        .style7
        {
            height: 26px;
            width: 124px;
        }
        .style8
        {
            width: 124px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <table style="font: caption; z-index: 100; font-size:small  left: 0px; position: absolute; top: 0px; ">
            <tr>
                <td colspan="4" style="background-image: url(../images/xiugai.gif); background-repeat :no-repeat  ; background-color :#ecedf4; height: 33px">
                    &nbsp;</td>
            </tr>
            <tr>
                <td class="style1">
                </td>
                <td class="style6">
                </td>
                <td style="width: 196px; height: 97px">
                </td>
                <td style="width: 649px; height: 97px">
                </td>
            </tr>
            <tr>
                <td class="style2">
                </td>
                <td class="style7">
                    <asp:Label ID="Label1" runat="server" Text="用 户 名：" style="font-size: x-small"></asp:Label></td>
                <td style="width: 196px; height: 26px;">
                    <asp:Label ID="uname" runat="server" Text="Label" Width="144px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 649px; height: 26px">
                </td>
            </tr>
            <tr>
                <td class="style3">
                </td>
                <td class="style8">
                    <asp:Label ID="Label3" runat="server" Text="新 密 码：" style="font-size: x-small"></asp:Label></td>
                <td style="width: 196px">
                    <asp:TextBox ID="newpw" runat="server" TextMode="Password" ValidationGroup="q"></asp:TextBox></td>
                <td style="width: 649px">
                </td>
            </tr>
            <tr>
                <td class="style3">
                </td>
                <td class="style8">
                    <asp:Label ID="Label4" runat="server" Text="确认密码：" style="font-size: x-small"></asp:Label></td>
                <td style="width: 196px">
                    <asp:TextBox ID="surepw" runat="server" TextMode="Password" ValidationGroup="q"></asp:TextBox>&nbsp;
                    <asp:CompareValidator ID="CompareValidator1" runat="server" ControlToCompare="newpw"
                        ControlToValidate="surepw" ErrorMessage="密码不一致" Width="72px" 
                        ValidationGroup="q" style="font-size: small"></asp:CompareValidator>
                </td>
                <td style="width: 649px">
                    </td>
            </tr>
            <tr>
                <td colspan="1" class="style4">
                </td>
                <td colspan="2" style="height: 25px">
                    &nbsp;<asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/images/yesButton.png" OnClick="ImageButton1_Click" ValidationGroup="q" />
                    <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/images/reset.png" OnClick="ImageButton2_Click" /></td>
                <td colspan="1" style="width: 649px; height: 25px">
                </td>
            </tr>
            <tr>
                <td colspan="1" class="style5">
                </td>
                <td colspan="2" style="height: 394px">
                </td>
                <td colspan="1" style="width: 649px; height: 394px">
                </td>
            </tr>
        </table>
    
    </div>
    </form>
</body>
</html>
