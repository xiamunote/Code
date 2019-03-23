<%@ Page Language="C#" AutoEventWireup="true" CodeFile="DetaildeSuggestion.aspx.cs" Inherits="backwork_DetaildeSuggestion" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
    <style type="text/css">
        .style1
        {
            font-size: medium;
            color: #FFFFFF;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <table style="z-index:100; font-size:small; left: 0px; font: caption; color: dimgray; position: absolute;
            top: 0px">
            <tr>
                <td colspan="6" style="background-image: url(../images/pointout_line.jpg); height: 27px">
                &nbsp; &nbsp; <span class="style1">填写意见</span></td>
            </tr>
            <tr>
                <td style="width: 163px; height: 62px">
                </td>
                <td style="width: 150px; height: 62px">
                </td>
                <td style="width: 174px; height: 62px">
                </td>
                <td style="width: 126px; height: 62px">
                </td>
                <td style="width: 112px; height: 62px">
                </td>
                <td style="width: 471px; height: 62px">
                </td>
            </tr>
            <tr>
                <td style="width: 163px">
                </td>
                <td style="width: 150px; text-align: right">
                    <asp:Label ID="Label1" runat="server" Text="客户姓名：" style="font-size: small"></asp:Label></td>
                <td style="width: 174px">
                    <asp:Label ID="Label5" runat="server" Text="Label" Width="172px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 126px; text-align: right">
                    <asp:Label ID="Label3" runat="server" Text="手      机：" style="font-size: small"></asp:Label></td>
                <td style="width: 112px">
                    <asp:Label ID="Label7" runat="server" Text="Label" Width="172px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 471px">
                </td>
            </tr>
            <tr>
                <td style="width: 163px">
                </td>
                <td style="width: 150px; text-align: right">
                    <asp:Label ID="Label2" runat="server" Text="邮箱地址：" style="font-size: small"></asp:Label></td>
                <td style="width: 174px">
                    <asp:Label ID="Label6" runat="server" Text="Label" Width="172px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 126px; text-align: right">
                    <asp:Label ID="Label4" runat="server" Text="固定电话：" style="font-size: small"></asp:Label></td>
                <td style="width: 112px">
                    <asp:Label ID="Label8" runat="server" Text="Label" Width="172px" 
                        style="font-size: small"></asp:Label></td>
                <td style="width: 471px">
                </td>
            </tr>
            <tr>
                <td style="width: 163px">
                </td>
                <td style="width: 150px; text-align: right">
                    <asp:Label ID="Label9" runat="server" Text="意见内容：" style="font-size: small"></asp:Label></td>
                <td colspan="3" rowspan="2">
                    <asp:TextBox ID="TextBox1" runat="server" Height="120px" TextMode="MultiLine" Width="441px"></asp:TextBox></td>
                <td style="width: 471px">
                </td>
            </tr>
            <tr>
                <td style="width: 163px; height: 111px">
                </td>
                <td style="width: 150px; height: 111px">
                </td>
                <td style="width: 471px; height: 111px">
                </td>
            </tr>
            <tr>
                <td style="width: 163px; height: 189px">
                </td>
                <td style="width: 150px; height: 189px">
                </td>
                <td style="width: 174px; height: 189px">
                </td>
                <td style="width: 126px; height: 189px">
                    <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/images/return.png" OnClick="ImageButton1_Click" /></td>
                <td style="width: 112px; height: 189px">
                </td>
                <td style="width: 471px; height: 189px">
                </td>
            </tr>
        </table>
    
    </div>
    </form>
</body>
</html>
