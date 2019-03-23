<%@ Page Language="C#" AutoEventWireup="true" CodeFile="DetailedInfor.aspx.cs" Inherits="backwork_DetailedInfor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
    <style type="text/css">
        .style2
        {
            width: 192px;
        }
        .style3
        {
            height: 21px;
            width: 192px;
        }
        .style4
        {
            height: 10px;
            width: 192px;
        }
        .style5
        {
            height: 247px;
            width: 192px;
        }
        .style7
        {
            width: 158px;
        }
        .style8
        {
            height: 21px;
            width: 158px;
        }
        .style9
        {
            height: 10px;
            width: 158px;
        }
        .style10
        {
            height: 247px;
            width: 158px;
        }
        </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <table style="z-index: 100; left: 0px; font: caption; color: dimgray; position: absolute;
            top: 0px; font-size:small  ">
            <tr>
                <td style="width: 130px">
                </td>
                <td style="text-align: right" class="style2">
                    <asp:Label ID="Label18" runat="server" Text="行程日期：" style="font-size: small"></asp:Label></td>
                <td style="width: 209px">
                    <asp:Label ID="Label19" runat="server" Text="Label" Width="96px" 
                        Font-Size="Small"></asp:Label></td>
                <td style="width: 162px; text-align :right" >
                    <asp:Label ID="Label7" runat="server" Text="航空公司：" Font-Size="Small"></asp:Label>&nbsp;
                </td>
                <td style="width: 96px">
                    <asp:Label ID="Label26" runat="server" Text="Label" Width="96px" Font-Size="Small"></asp:Label>
                </td>
                <td class="style7">
                </td>
                <td style="width: 96px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="text-align: right" class="style2">
                    <asp:Label ID="Label1" runat="server" Text="客户姓名：" Font-Size="Small"></asp:Label></td>
                <td style="width: 209px">
                    <asp:Label ID="Label20" runat="server" Text="Label" Width="96px" 
                        Font-Size="Small"></asp:Label></td>
                <td style="width: 162px; text-align: right">
                    <asp:Label ID="Label8" runat="server" Text="航班类型：" Font-Size="Small"></asp:Label></td>
                <td style="width: 96px">
                    <asp:Label ID="Label27" runat="server" Text="Label" Width="96px" Font-Size="Small"></asp:Label></td>
                <td class="style7"> 
                </td>
                <td style="width: 96px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px; height: 21px">
                </td>
                <td style="text-align: right" class="style3">
                    <asp:Label ID="Label2" runat="server" Text="身份证号：" Font-Size="Small"></asp:Label></td>
                <td style="width: 209px; height: 21px">
                    <asp:Label ID="Label21" runat="server" Text="Label" Font-Size="Small" Width="180px" ></asp:Label></td>
                <td style="width: 162px; height: 21px; text-align: right">
                    <asp:Label ID="Label9" runat="server" Text="机舱类型：" Font-Size="Small"></asp:Label></td>
                <td style="width: 96px; height: 21px">
                    <asp:Label ID="Label28" runat="server" Text="Label" Width="96px" Font-Size="Small"></asp:Label></td>
                <td class="style8">
                </td>
                <td style="width: 96px; height: 21px">
                </td>
                <td style="width: 290px; height: 21px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="text-align: right" class="style2">
                    <asp:Label ID="Label3" runat="server" Text="电子邮件：" Font-Size="Small"></asp:Label></td>
                <td style="width: 209px">
                    <asp:Label ID="Label22" runat="server" Text="Label" Width="180px" Font-Size="Small"></asp:Label></td>
                <td style="width: 162px; text-align: right">
                    <asp:Label ID="Label10" runat="server" Text="订票数量：" Font-Size="Small"></asp:Label></td>
                <td style="width: 96px">
                    <asp:Label ID="Label29" runat="server" Text="Label" Width="96px" Font-Size="Small"></asp:Label></td>
                <td class="style7">
                </td>
                <td style="width: 96px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px; height: 10px">
                </td>
                <td style="text-align: right" class="style4">
                    <asp:Label ID="Label4" runat="server" Text="手机号码：" Font-Size="Small"></asp:Label></td>
                <td style="width: 209px; height: 10px">
                    <asp:Label ID="Label23" runat="server" Text="Label" Width="120px" Font-Size="Small"></asp:Label></td>
                <td style="width: 162px; height: 10px; text-align: right">
                    <asp:Label ID="Label11" runat="server" Text="机票单价：" Font-Size="Small"></asp:Label></td>
                <td style="width: 96px; height: 10px">
                    <asp:Label ID="Label30" runat="server" Text="Label" Width="96px" Font-Size="Small"></asp:Label></td>
                <td class="style9">
                </td>
                <td style="width: 96px; height: 10px">
                </td>
                <td style="width: 290px; height: 10px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="text-align: right" class="style2">
                    <asp:Label ID="Label5" runat="server" Text="家庭电话：" Font-Size="Small"></asp:Label></td>
                <td style="width: 209px">
                    <asp:Label ID="Label24" runat="server" Text="Label" Width="120px" Font-Size="Small"></asp:Label></td>
                <td style="width: 162px; text-align: right">
                    <asp:Label ID="Label12" runat="server" Text="出发城市：" Font-Size="Small"></asp:Label></td>
                <td style="width: 96px">
                    <asp:Label ID="Label31" runat="server" Text="Label" Width="96px" Font-Size="Small"></asp:Label></td>
                <td class="style7">
                </td>
                <td style="width: 96px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td style="text-align: right" class="style2">
                    <asp:Label ID="Label6" runat="server" Text="详细地址：" Font-Size="Small"></asp:Label></td>
                <td rowspan="4" style="width: 209px; text-align: left">
                    <asp:TextBox ID="TextBox1" runat="server" Height="71px" TextMode="MultiLine" 
                        Width="229px"></asp:TextBox></td>
                <td style="width: 162px; text-align: right">
                    <asp:Label ID="Label13" runat="server" Text="前往城市：" Font-Size="Small"></asp:Label></td>
                <td style="width: 96px">
                    <asp:Label ID="Label32" runat="server" Text="Label" Width="96px" Font-Size="Small"></asp:Label></td>
                <td style="text-align: right" class="style7">
                    &nbsp;</td>
                <td style="width: 96px">
                    &nbsp;</td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td class="style2">
                </td>
                <td style="width: 162px; text-align: right">
                    <asp:Label ID="Label16" runat="server" Text="起飞时间：" Font-Size="Small"></asp:Label></td>
                <td style="width: 96px">
                    <asp:Label ID="Label33" runat="server" Text="Label" Width="96px" Font-Size="Small"></asp:Label></td>
                <td style="text-align: right" class="style7">
                    &nbsp;</td>
                <td style="width: 96px">
                    &nbsp;</td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td class="style2">
                </td>
                <td style="width: 162px; text-align: right">
                    <asp:Label ID="Label17" runat="server" Text="降落时间：" Font-Size="Small"></asp:Label></td>
                <td style="width: 96px">
                    <asp:Label ID="Label34" runat="server" Text="Label" Width="96px" Font-Size="Small"></asp:Label></td>
                <td class="style7">
                </td>
                <td style="width: 96px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td class="style2">
                </td>
                <td style="width: 162px; text-align: right">
                    <asp:Label ID="Label14" runat="server" Text="起飞机场：" Font-Size="Small"></asp:Label></td>
                <td style="width: 96px">
                    <asp:Label ID="Label35" runat="server" Text="Label" Width="96px" Font-Size="Small"></asp:Label></td>
                <td class="style7">
                    <asp:Label ID="Label15" runat="server" Text="降落机场：" Font-Size="Small"></asp:Label>
                </td>
                <td style="width: 96px">
                    <asp:Label ID="Label36" runat="server" Text="Label" Width="96px" Font-Size="Small"></asp:Label>
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td class="style2">
                </td>
                <td style="width: 209px">
                </td>
                <td style="width: 162px">
                </td>
                <td style="width: 96px">
                </td>
                <td class="style7">
                </td>
                <td style="width: 96px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px">
                </td>
                <td class="style2">
                </td>
                <td style="width: 209px; text-align: right;">
                    <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/images/s.png"
                        OnClick="ImageButton1_Click" /></td>
                <td style="width: 162px; text-align: right;">
                    <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/images/c.png"
                        OnClick="ImageButton2_Click" /></td>
                <td style="width: 96px">
                    </td>
                <td class="style7">
                </td>
                <td style="width: 96px">
                </td>
                <td style="width: 290px">
                </td>
            </tr>
            <tr>
                <td style="width: 130px; height: 247px">
                </td>
                <td class="style5">
                </td>
                <td style="width: 209px; height: 247px">
                </td>
                <td style="width: 162px; height: 247px">
                </td>
                <td style="width: 96px; height: 247px">
                </td>
                <td class="style10">
                </td>
                <td style="width: 96px; height: 247px">
                </td>
                <td style="width: 290px; height: 247px">
                </td>
            </tr>
        </table>
    
    </div>
    </form>
</body>
</html>
