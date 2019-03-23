<%@ Page Language="C#" AutoEventWireup="true" CodeFile="UpDateStock.aspx.cs" Inherits="backwork_UpDateStock" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
    <style type="text/css">
        .style1
        {
            color: white;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    <table style="z-index: 100; font-size:small; left: 0px; font: caption; color: dimgray; position: absolute;
            top: 0px; ">
            <tr>
                <td colspan="6" 
                    style="background-image: url('../images/pointout_line.jpg'); height: 27px; font-size: medium;">
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="style1">更新航班信息</span></td>
            </tr>
            <tr>
                <td style="width: 130px; height: 67px">
                </td>
                <td style="width: 138px; height: 67px">
                </td>
                <td style="width: 150px; height: 67px">
                </td>
                <td style="width: 110px; height: 67px">
                </td>
                <td style="width: 211px; height: 67px">
                </td>
                <td style="width: 290px; height: 67px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="width: 138px; text-align: right">
                    <asp:Label ID="Label7" runat="server" Text="航空公司：" style="font-size: small"></asp:Label></td>
                <td style="width: 150px">
                    <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox></td>
                <td style="width: 110px; text-align: right;">
                    <asp:Label ID="Label2" runat="server" Text="出发日期：" style="font-size: small"></asp:Label></td>
                <td style="width: 211px">
                    <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox></td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px; height: 21px">
                </td>
                <td style="width: 138px; height: 21px; text-align: right">
                    <asp:Label ID="Label8" runat="server" Text="航班类型：" style="font-size: small"></asp:Label></td>
                <td style="width: 150px; height: 21px">
                    <asp:TextBox ID="TextBox4" runat="server"></asp:TextBox></td>
                <td style="width: 110px; height: 21px; text-align: right;">
                    <asp:Label ID="Label3" runat="server" Text="返程日期：" style="font-size: small"></asp:Label></td>
                <td style="width: 211px; height: 21px">
                    <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox></td>
                <td style="width: 290px; height: 21px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="width: 138px; text-align: right">
                    <asp:Label ID="Label9" runat="server" Text="机舱类型：" style="font-size: small"></asp:Label></td>
                <td style="width: 150px">
                    <asp:TextBox ID="TextBox5" runat="server"></asp:TextBox></td>
                <td style="width: 110px">
                </td>
                <td style="width: 211px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px; height: 10px">
                </td>
                <td style="width: 138px; height: 10px; text-align: right">
                    <asp:Label ID="Label10" runat="server" Text="机票数量：" style="font-size: small"></asp:Label></td>
                <td style="width: 150px; height: 10px">
                    <asp:TextBox ID="TextBox6" runat="server"></asp:TextBox></td>
                <td style="width: 110px; height: 10px">
                </td>
                <td style="width: 211px; height: 10px">
                </td>
                <td style="width: 290px; height: 10px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="width: 138px; text-align: right">
                    <asp:Label ID="Label11" runat="server" Text="机票单价：" style="font-size: small"></asp:Label></td>
                <td style="width: 150px">
                    <asp:TextBox ID="TextBox7" runat="server"></asp:TextBox></td>
                <td style="width: 110px; text-align: right;">
                    <asp:Label ID="Label1" runat="server" Text="返程单价：" style="font-size: small"></asp:Label></td>
                <td style="width: 211px">
                    <asp:TextBox ID="TextBox12" runat="server"></asp:TextBox></td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="width: 138px; text-align: right">
                    <asp:Label ID="Label12" runat="server" Text="出发城市：" style="font-size: small"></asp:Label></td>
                <td style="width: 150px">
                    <asp:TextBox ID="TextBox8" runat="server"></asp:TextBox></td>
                <td style="width: 110px; text-align: right">
                    <asp:Label ID="Label14" runat="server" Text="起飞机场：" style="font-size: small"></asp:Label></td>
                <td style="width: 211px">
                    <asp:TextBox ID="TextBox13" runat="server"></asp:TextBox></td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="width: 138px; text-align: right">
                    <asp:Label ID="Label13" runat="server" Text="前往城市：" style="font-size: small"></asp:Label></td>
                <td style="width: 150px">
                    <asp:TextBox ID="TextBox9" runat="server"></asp:TextBox></td>
                <td style="width: 110px; text-align: right">
                    <asp:Label ID="Label15" runat="server" Text="降落机场：" style="font-size: small"></asp:Label></td>
                <td style="width: 211px">
                    <asp:TextBox ID="TextBox14" runat="server"></asp:TextBox></td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="width: 138px; text-align: right">
                    <asp:Label ID="Label16" runat="server" Text="起飞时间：" style="font-size: small"></asp:Label></td>
                <td style="width: 150px">
                    <asp:TextBox ID="TextBox10" runat="server"></asp:TextBox></td>
                <td style="width: 110px">
                </td>
                <td style="width: 211px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="width: 138px; text-align: right">
                    <asp:Label ID="Label17" runat="server" Text="降落时间：" style="font-size: small"></asp:Label></td>
                <td style="width: 150px">
                    <asp:TextBox ID="TextBox11" runat="server"></asp:TextBox></td>
                <td style="width: 110px">
                </td>
                <td style="width: 211px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="width: 138px">
                </td>
                <td style="width: 150px">
                </td>
                <td style="width: 110px">
                </td>
                <td style="width: 211px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="width: 138px; text-align: right;">
                    </td>
                <td style="width: 150px">
                    <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/images/yesButton.png"
                        OnClick="ImageButton1_Click" /></td>
                <td style="width: 110px">
                    <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/images/reset.png"
                         /></td>
                <td style="width: 211px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px; height: 247px">
                </td>
                <td style="width: 138px; height: 247px">
                </td>
                <td style="width: 150px; height: 247px">
                </td>
                <td style="width: 110px; height: 247px">
                </td>
                <td style="width: 211px; height: 247px">
                </td>
                <td style="width: 290px; height: 247px">
                </td>
            </tr>
        </table>
    </div>
    </form>
</body>
</html>
