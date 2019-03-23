<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AddFlightInfor.aspx.cs" Inherits="backwork_AddFlightInfor" %>


<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">

<script type="text/javascript" src="../js/calendar.js"></script>
    <title>无标题页</title>
    <style type="text/css">
        .style2
        {
            width: 100px;
            font-size: x-small;
        }
        .style5
        {
            font-size: x-small;
        }
        .style6
        {
            font-weight: 700;
            color: #FFFFFF;
        }
        .style7
        {
            font-size: medium;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        &nbsp;&nbsp;
        <table style="z-index: 101; left: 0px; font: caption; color: dimgray; position: absolute;
            top: 0px;">
            <tr>
                <td colspan="9" style="background-image: url(../images/pointout_line.jpg); height: 27px">
              &nbsp;&nbsp;&nbsp;<span class="style6"> <span class="style7">添加航班信息 </span></span> </td>
            </tr>
            <tr>
                <td style="width: 147px; height: 78px">
                </td>
                <td style="width: 123px; height: 78px">
                </td>
                <td style="width: 100px; height: 78px">
                </td>
                <td style="width: 29px; height: 78px">
                </td>
                <td style="width: 116px; height: 78px">
                </td>
                <td style="width: 100px; height: 78px">
                </td>
                <td style="width: 28px; height: 78px">
                </td>
                <td style="width: 166px; height: 78px">
                </td>
                <td style="width: 283px; height: 78px">
                </td>
            </tr>
            <tr>
                <td style="width: 147px">
                </td>
                <td style="width: 123px; text-align: right" class="style5">
                    <asp:Label ID="Label1" runat="server" Text="航空公司："></asp:Label></td>
                <td class="style2">
                    <asp:DropDownList ID="DropDownList1" runat="server" Width="154px" >
                        <asp:ListItem>中国国航</asp:ListItem>
                        <asp:ListItem>联合航空</asp:ListItem>
                        <asp:ListItem>东方航空</asp:ListItem>
                        <asp:ListItem>南方航空</asp:ListItem>
                        <asp:ListItem>上海航空</asp:ListItem>
                        <asp:ListItem>大新华航空</asp:ListItem>
                        <asp:ListItem>四川航空</asp:ListItem>
                        <asp:ListItem>深圳航空</asp:ListItem>
                        <asp:ListItem>厦门航空</asp:ListItem>
                        <asp:ListItem>海南航空</asp:ListItem>
                        <asp:ListItem>吉祥航空</asp:ListItem>
                        <asp:ListItem>港龙航空</asp:ListItem>
                        <asp:ListItem>大韩航空</asp:ListItem>
                        <asp:ListItem>韩亚航空</asp:ListItem>
                        <asp:ListItem>日本航空</asp:ListItem>
                        <asp:ListItem>全日空航空</asp:ListItem>
                        <asp:ListItem>国泰航空</asp:ListItem>
                        <asp:ListItem>美大陆航空</asp:ListItem>
                        <asp:ListItem>美联航</asp:ListItem>
                    </asp:DropDownList></td>
                <td style="width: 29px">
                </td>
                <td style="width: 116px; text-align: right" class="style5">
                    <asp:Label ID="Label7" runat="server" Text="出发日期："></asp:Label></td>
                <td class="style2">
                    <asp:TextBox ID="statedate" runat="server" ontextchanged="adate_TextChanged"></asp:TextBox></td>
                <td style="width: 28px">
                </td>
                <td style="width: 166px">
                </td>
                <td style="width: 283px">
                </td>
            </tr>
            <tr>
                <td style="width: 147px">
                </td>
                <td style="width: 123px; text-align: right" class="style5">
                    <asp:Label ID="Label2" runat="server" Text="出发城市："></asp:Label></td>
                <td class="style2">
                    <asp:DropDownList ID="DropDownList3" runat="server" Width="154px">
                        <asp:ListItem>北京</asp:ListItem>
                        <asp:ListItem>上海</asp:ListItem>
                        <asp:ListItem>广州</asp:ListItem>
                        <asp:ListItem>哈尔滨</asp:ListItem>
                    </asp:DropDownList></td>
                <td style="width: 29px">
                </td>
                <td style="width: 116px; text-align: right" class="style5">
                    <asp:Label ID="Label8" runat="server" Text="回程日期："></asp:Label></td>
                <td class="style2">
                    <asp:TextBox ID="bdate" runat="server"></asp:TextBox></td>
                <td style="width: 28px">
                </td>
                <td style="width: 166px">
                </td>
                <td style="width: 283px">
                </td>
            </tr>
            <tr>
                <td style="width: 147px">
                </td>
                <td style="width: 123px; text-align: right" class="style5">
                    <asp:Label ID="Label3" runat="server" Text="抵达城市："></asp:Label></td>
                <td class="style2">
                    <asp:TextBox ID="backcity" runat="server"></asp:TextBox></td>
                <td style="width: 29px" class="style5">
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="backcity"
                        ErrorMessage="*" ValidationGroup="q"></asp:RequiredFieldValidator></td>
                <td style="width: 116px; text-align: right" class="style5">
                    <asp:Label ID="Label9" runat="server" Text="起飞时间："></asp:Label></td>
                <td class="style2">
                    <asp:TextBox ID="atime" runat="server"></asp:TextBox></td>
                <td style="width: 28px">
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ControlToValidate="atime"
                        ErrorMessage="*" ValidationGroup="q"></asp:RequiredFieldValidator></td>
                <td style="width: 166px">
                    <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ControlToValidate="atime"
                        ErrorMessage="时间格式00：00" 
                        ValidationExpression="^([0-1][0-9]|[2][0-3]):([0-5][0-9])$" ValidationGroup="q" 
                        style="font-size: small"></asp:RegularExpressionValidator></td>
                <td style="width: 283px">
                </td>
            </tr>
            <tr>
                <td style="width: 147px">
                </td>
                <td style="width: 123px; text-align: right" class="style5">
                    <asp:Label ID="Label4" runat="server" Text="单程票价："></asp:Label></td>
                <td class="style2">
                    <asp:TextBox ID="aprice" runat="server"></asp:TextBox></td>
                <td style="width: 29px" class="style5">
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="aprice"
                        ErrorMessage="*" ValidationGroup="q"></asp:RequiredFieldValidator></td>
                <td style="width: 116px; text-align: right" class="style5">
                    <asp:Label ID="Label10" runat="server" Text="降落时间："></asp:Label></td>
                <td class="style2">
                    <asp:TextBox ID="btime" runat="server"></asp:TextBox></td>
                <td style="width: 28px">
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ControlToValidate="btime"
                        ErrorMessage="*" ValidationGroup="q"></asp:RequiredFieldValidator></td>
                <td style="width: 166px">
                    <asp:RegularExpressionValidator ID="RegularExpressionValidator2" runat="server" ControlToValidate="atime"
                        ErrorMessage="时间格式00：00" 
                        ValidationExpression="^([0-1][0-9]|[2][0-3]):([0-5][0-9])$" ValidationGroup="q" 
                        style="font-size: small"></asp:RegularExpressionValidator></td>
                <td style="width: 283px">
                </td>
            </tr>
            <tr>
                <td style="width: 147px">
                </td>
                <td style="width: 123px; text-align: right" class="style5">
                    <asp:Label ID="Label5" runat="server" Text="往返票价："></asp:Label></td>
                <td class="style2">
                    <asp:TextBox ID="bprice" runat="server"></asp:TextBox></td>
                <td style="width: 29px">
                </td>
                <td style="width: 116px; text-align: right" class="style5">
                    <asp:Label ID="sap" runat="server" Text="起飞机场："></asp:Label></td>
                <td class="style2">
                    <asp:DropDownList ID="DropDownList5" runat="server" Width="154px">
                        <asp:ListItem>首都机场</asp:ListItem>
                        <asp:ListItem>双流机场</asp:ListItem>
                        <asp:ListItem>羽田机场</asp:ListItem>
                        <asp:ListItem>成田机场</asp:ListItem>
                        <asp:ListItem>洛杉矶机场</asp:ListItem>
                        <asp:ListItem>肯尼迪机场</asp:ListItem>
                        <asp:ListItem>纽约克机场</asp:ListItem>
                        <asp:ListItem>纽约机场</asp:ListItem>
                        <asp:ListItem>仁川机场</asp:ListItem>
                        <asp:ListItem>江北机场</asp:ListItem>
                        <asp:ListItem>太平机场</asp:ListItem>
                        <asp:ListItem>浦东机场</asp:ListItem>
                        <asp:ListItem>香港机场</asp:ListItem>
                        <asp:ListItem>高崎机场</asp:ListItem>
                    </asp:DropDownList></td>
                <td style="width: 28px">
                </td>
                <td style="width: 166px">
                </td>
                <td style="width: 283px">
                </td>
            </tr>
            <tr>
                <td style="width: 147px">
                </td>
                <td style="width: 123px; text-align: right" class="style5">
                    <asp:Label ID="Label11" runat="server" Text="机票数量："></asp:Label></td>
                <td class="style2">
                    <asp:TextBox ID="num" runat="server"></asp:TextBox></td>
                <td style="width: 29px">
                </td>
                <td style="width: 116px; text-align: right" class="style5">
                    <asp:Label ID="aap" runat="server" Text="降落机场："></asp:Label></td>
                <td class="style2">
                    <asp:DropDownList ID="DropDownList6" runat="server" Width="154px">
                        <asp:ListItem>首都机场</asp:ListItem>
                        <asp:ListItem>双流机场</asp:ListItem>
                        <asp:ListItem>洛杉矶机场</asp:ListItem>
                        <asp:ListItem>纽约克机场</asp:ListItem>
                        <asp:ListItem>纽约机场</asp:ListItem>
                        <asp:ListItem>肯尼迪机场</asp:ListItem>
                        <asp:ListItem>仁川机场</asp:ListItem>
                        <asp:ListItem>羽田机场</asp:ListItem>
                        <asp:ListItem>成田机场</asp:ListItem>
                        <asp:ListItem>太平机场</asp:ListItem>
                        <asp:ListItem>江北机场</asp:ListItem>
                        <asp:ListItem>浦东机场</asp:ListItem>
                        <asp:ListItem>香港机场</asp:ListItem>
                        <asp:ListItem>高崎机场</asp:ListItem>
                    </asp:DropDownList></td>
                <td style="width: 28px">
                </td>
                <td style="width: 166px">
                </td>
                <td style="width: 283px">
                </td>
            </tr>
            <tr>
                <td style="width: 147px">
                </td>
                <td style="width: 123px; text-align: right" class="style5">
                    <asp:Label ID="Label6" runat="server" Text="飞机型号："></asp:Label></td>
                <td class="style2">
                    <asp:DropDownList ID="DropDownList2" runat="server" Width="154px">
                        <asp:ListItem>波音737（中）</asp:ListItem>
                        <asp:ListItem>波音747（大）</asp:ListItem>
                        <asp:ListItem>波音777（大）</asp:ListItem>
                        <asp:ListItem>空客300（大）</asp:ListItem>
                        <asp:ListItem>空客319（中）</asp:ListItem>
                        <asp:ListItem>空客320（中）</asp:ListItem>
                        <asp:ListItem>空客321（中）</asp:ListItem>
                        <asp:ListItem>空客330（大）</asp:ListItem>
                        <asp:ListItem>麦道90（中）</asp:ListItem>
                        <asp:ListItem>JET</asp:ListItem>
                        <asp:ListItem>EQV</asp:ListItem>
                        <asp:ListItem>MU271/MU587</asp:ListItem>
                        <asp:ListItem>MU588/MU5103</asp:ListItem>
                        <asp:ListItem>NH906/NH955</asp:ListItem>
                        <asp:ListItem>CX6893/CX880</asp:ListItem>
                        <asp:ListItem>CX841/CX6880</asp:ListItem>
                        <asp:ListItem>OZ334/OZ222</asp:ListItem>
                        <asp:ListItem>OZ221/OZ331</asp:ListItem>
                    </asp:DropDownList></td>
                <td style="width: 29px">
                </td>
                <td style="width: 116px; text-align: right" class="style5">
                    <asp:Label ID="Label12" runat="server" Text="机舱类型："></asp:Label></td>
                <td class="style2">
                    <asp:DropDownList ID="DropDownList4" runat="server" Width="154px">
                        <asp:ListItem>经济舱</asp:ListItem>
                        <asp:ListItem>头等舱</asp:ListItem>
                    </asp:DropDownList></td>
                <td style="width: 28px">
                </td>
                <td style="width: 166px">
                </td>
                <td style="width: 283px">
                </td>
            </tr>
            <tr>
                <td style="width: 147px; height: 42px">
                </td>
                <td style="width: 123px; height: 42px">
                </td>
                <td style="width: 100px; height: 42px">
                    <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/images/yesButton.png"
                        OnClick="ImageButton1_Click" ValidationGroup="q" />
                </td>
                <td style="width: 29px; height: 42px">
                </td>
                <td style="width: 116px; height: 42px">
                    <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/images/reset.png"
                        OnClick="ImageButton2_Click" />
                </td>
                <td style="width: 100px; height: 42px">
                </td>
                <td style="width: 28px; height: 42px">
                </td>
                <td style="width: 166px; height: 42px">
                </td>
                <td style="width: 283px; height: 42px">
                </td>
            </tr>
            <tr>
                <td style="width: 147px">
                </td>
                <td style="width: 123px">
                </td>
                <td style="width: 100px; text-align: right">
                    &nbsp;</td>
                <td style="width: 29px">
                </td>
                <td style="width: 116px; text-align: right">
                    &nbsp;</td>
                <td style="width: 100px">
                </td>
                <td style="width: 28px">
                </td>
                <td style="width: 166px">
                </td>
                <td style="width: 283px">
                </td>
            </tr>
            <tr>
                <td style="width: 147px; height: 200px">
                </td>
                <td style="width: 123px; height: 200px">
                </td>
                <td style="width: 100px; height: 200px">
                </td>
                <td style="width: 29px; height: 200px">
                </td>
                <td style="width: 116px; height: 200px">
                </td>
                <td style="width: 100px; height: 200px">
                </td>
                <td style="width: 28px; height: 200px">
                </td>
                <td style="width: 166px; height: 200px">
                </td>
                <td style="width: 283px; height: 200px">
                </td>
            </tr>
        </table>
    
    </div>
    </form>
</body>
</html>
