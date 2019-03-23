<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AddUser.aspx.cs" Inherits="backwork_AddUser" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
    <style type="text/css">
        .style1
        {
            font-size: x-small;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <table style="z-index: 100; left: 0px; position: absolute; top: 0px; font: caption; height: 570px; " frame="void">
            <tr>
                <td colspan="4" style="background-image: url(../images/kettle_2.gif); background-repeat :no-repeat  ; background-color :#ecedf4; height: 33px">
                </td>
            </tr>
            <tr>
                <td style="width: 300px; height: 97px">
                </td>
                <td style="width: 97px; height: 97px">
                </td>
                <td style="width: 199px; height: 97px">
                </td>
                <td style="width: 488px; height: 97px">
                </td>
            </tr>
            <tr>
                <td style="width: 300px">
                </td>
                <td style="width: 97px">
                    <asp:Label ID="Label1" runat="server" Text="用户名：" style="font-size: x-small"></asp:Label></td>
                <td style="width: 199px">
                    <asp:TextBox ID="newname" runat="server" Width="139px"></asp:TextBox>
                    <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ControlToValidate="newname"
                        ErrorMessage="*" ValidationExpression="^[a-zA-Z]\w{5,17}$" ValidationGroup="q"></asp:RegularExpressionValidator>
                </td>
                <td style="width: 488px; color: #ff0000;" class="style1">
                    (用户名以字母开头，长度在6-18之间，由字母、数字、下划线组成)</td>
            </tr>
            <tr>
                <td style="width: 300px; height: 28px">
                </td>
                <td style="width: 97px; height: 28px;">
                    <asp:Label ID="Label2" runat="server" Text="密  码：" style="font-size: x-small"></asp:Label></td>
                <td style="width: 199px; height: 28px;">
                    <asp:TextBox ID="inputpw" runat="server" TextMode="Password"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="inputpw"
                        ErrorMessage="*" ValidationGroup="q"></asp:RequiredFieldValidator></td>
                <td style="width: 488px; height: 28px">
                </td>
            </tr>
            <tr>
                <td style="width: 300px; height: 21px">
                </td>
                <td style="width: 97px; height: 21px">
                    <asp:Label ID="Label3" runat="server" Text="确认密码：" style="font-size: x-small"></asp:Label></td>
                <td style="width: 199px; height: 21px">
                    <asp:TextBox ID="TextBox1" runat="server" TextMode="Password"></asp:TextBox>
                    <asp:CompareValidator ID="CompareValidator1" runat="server" ControlToCompare="inputpw"
                        ControlToValidate="TextBox1" ErrorMessage="密码不一致" Width="72px" 
                        style="z-index: 100; left: 467px; position: absolute; top: 201px" 
                        ValidationGroup="q" Font-Size="Small"></asp:CompareValidator>
                </td>
                <td style="width: 488px; height: 21px">
                </td>
            </tr>
            <tr>
                <td colspan="1" style="width: 300px; height: 33px">
                </td>
                <td colspan="2" style="height: 33px">
                    &nbsp;
                    <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/images/yesButton.png" OnClick="ImageButton1_Click" ValidationGroup="q" />
                    <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/images/reset.png" OnClick="ImageButton2_Click" /></td>
                <td colspan="1" style="width: 488px; height: 33px">
                </td>
            </tr>
            <tr>
                <td colspan="1" style="width: 300px; height: 397px">
                </td>
                <td colspan="2" style="height: 397px">
                </td>
                <td colspan="1" style="width: 488px; height: 397px">
                </td>
            </tr>
        </table>
    
    </div>
    </form>
</body>
</html>
