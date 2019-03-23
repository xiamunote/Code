<%@ Page Language="C#" AutoEventWireup="true" CodeFile="DomesticSelecet.aspx.cs"
    Inherits="domesticselecet" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>机票预订</title>


    <style type="text/css">
        .style1
        {
            height: 24px;
            width: 95px;
        }
        .style2
        {
            width: 95px;
        }
        body{ width:1200px;}
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
    <table style="width: 1200px" background="images/bg3.gif" cellpadding="0" cellspacing="0">
        <tr>
            <td style="width: 90%; height: 50px;">
                <asp:Label ID="date" runat="server" Text="Label" Width="134px" Font-Bold="True"
                    Font-Names="华文仿宋" ForeColor="#b22222"></asp:Label>
                <asp:Label ID="weekdate" runat="server" Font-Bold="True" Font-Names="华文仿宋" ForeColor="#b22222"
                    Text="Label" Width="74px"></asp:Label>
                &nbsp;
            </td>
            <td style="width: 90%; height: 50px;">
                <asp:LinkButton ID="LinkButton1" runat="server" ForeColor="#b22222" Font-Overline="false"
                    PostBackUrl="~/backwork/Login.aspx" Style="float: right;" Width="84px">后台登录</asp:LinkButton>
            </td>
        </tr>
        <tr>
            <td style="width:1000; height: 50px; text-align: center;" colspan="2">
                <asp:LinkButton ID="outside_button" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Underline="false" ForeColor="white" Width="200px" PostBackUrl="~/OverseaSelect.aspx">国际机票</asp:LinkButton>
                <asp:LinkButton ID="inside_button" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Underline="False" ForeColor="white" Width="200px" PostBackUrl="~/DomesticSelecet.aspx">国内机票</asp:LinkButton>
                <asp:LinkButton ID="suggesttion_button" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Underline="False" ForeColor="white" Width="200px" 
                    PostBackUrl="~/Suggest.aspx" onclick="suggesttion_button_Click">建议和投诉</asp:LinkButton>
                <asp:LinkButton ID="time_button" runat="server" Font-Overline="False" ForeColor="White"
                    Font-Bold="True" Font-Names="微软雅黑" Width="150px" Font-Underline="False" PostBackUrl="~/TimeDifference.aspx">世界时差</asp:LinkButton>
                <asp:LinkButton ID="payment_button" runat="server" Font-Bold="True" Font-Names="微软雅黑"
                    Font-Overline="False" ForeColor="White" Width="200px" Font-Underline="False"
                    PostBackUrl="~/Payment.aspx">付款方式</asp:LinkButton>
              
            </td>
        </tr>
        <tr>
            <td style="width: 100px; height: 38px;" colspan="2">
            </td>
        </tr>
    </table>
    <table width="1200px" height="500" style="background-color: #5296b5">
        <tr>
            <td>
                <table style="border: thin solid lightgrey; width: 269px; background-color :White;
                    height:100%; color: #666666;">
                    <tr>
                        <td style="width: 100px; height: 32px; background-image: url(images/pointout_line.jpg);"
                            colspan="2">
                          
                            <asp:Label ID="dmselect" runat="server" Text="Label" Width="216px" Height="4px"
                                ForeColor="White" style="font-size: small; font-weight: 700"></asp:Label>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: left;" class="style1">
                            <asp:Label ID="startcity" runat="server" Text="Label" ForeColor="White" 
                                Style="text-align: left; color: #666666; font-size: small;"></asp:Label>
                        </td>
                        <td style="width: 100px; height: 24px">
                            <asp:DropDownList ID="startcity_list" runat="server" Width="126px">
                                <asp:ListItem>北京</asp:ListItem>
                                <asp:ListItem>上海</asp:ListItem>
                                <asp:ListItem>广州</asp:ListItem>
                                <asp:ListItem>哈尔滨</asp:ListItem>
                            </asp:DropDownList>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: left;" class="style1">
                            <asp:Label ID="backdate" runat="server" Text="Label" ForeColor="White" 
                                Style="text-align: left; color: #666666; font-size: small;"></asp:Label>
                        </td>
                        <td style="width: 100px; height: 24px">
                            <asp:TextBox ID="backdate_box" runat="server" Width="128px"></asp:TextBox>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: left;" class="style1">
                            &nbsp;</td>
                        <td style="width: 100px; height: 24px">
                            <asp:Button ID="Button1" runat="server" Text="日期选择" Width="83px" 
                                onclick="Button1_Click" />
                            <asp:Calendar ID="Calendar1" runat="server" Visible =False 
                                onselectionchanged="Calendar1_SelectionChanged" BackColor="White" 
                                BorderColor="#999999" CellPadding="4" DayNameFormat="Shortest" 
                                Font-Names="Verdana" Font-Size="8pt" ForeColor="Black" Height="180px" 
                                Width="200px" >
                                <SelectedDayStyle BackColor="#666666" Font-Bold="True" ForeColor="White" />
                                <SelectorStyle BackColor="#CCCCCC" />
                                <WeekendDayStyle BackColor="#FFFFCC" />
                                <TodayDayStyle BackColor="#CCCCCC" ForeColor="Black" />
                                <OtherMonthDayStyle ForeColor="#808080" />
                                <NextPrevStyle VerticalAlign="Bottom" />
                                <DayHeaderStyle BackColor="#CCCCCC" Font-Bold="True" Font-Size="7pt" />
                                <TitleStyle BackColor="#999999" BorderColor="Black" Font-Bold="True" />
                            </asp:Calendar>
                        </td>
                    </tr>
                    <tr>
                        <td class="style1">
                            <asp:Label ID="startdate" runat="server" Text="Label" ForeColor="White" 
                                Style="text-align: left; color: #666666; font-size: small;"></asp:Label>
                        </td>
                        <td style="width: 100px; height: 24px;">
                            <asp:TextBox ID="startdate_box" runat="server" Width="128px" Height="22px"></asp:TextBox>
                        </td>
                    </tr>
                    <tr>
                        <td class="style1">
                            &nbsp;</td>
                        <td style="width: 100px; height: 24px;">
                            <asp:Button ID="Button2" runat="server" Text="日期选择" Width="83px" 
                                onclick="Button2_Click" />
                            <asp:Calendar ID="Calendar2" runat="server"  Visible =False 
                                onselectionchanged="Calendar2_SelectionChanged" BackColor="White" 
                                BorderColor="#999999" CellPadding="4" DayNameFormat="Shortest" 
                                Font-Names="Verdana" Font-Size="8pt" ForeColor="Black" Height="180px" 
                                Width="200px">
                                <SelectedDayStyle BackColor="#666666" Font-Bold="True" ForeColor="White" />
                                <SelectorStyle BackColor="#CCCCCC" />
                                <WeekendDayStyle BackColor="#FFFFCC" />
                                <TodayDayStyle BackColor="#CCCCCC" ForeColor="Black" />
                                <OtherMonthDayStyle ForeColor="#808080" />
                                <NextPrevStyle VerticalAlign="Bottom" />
                                <DayHeaderStyle BackColor="#CCCCCC" Font-Bold="True" Font-Size="7pt" />
                                <TitleStyle BackColor="#999999" BorderColor="Black" Font-Bold="True" />
                            </asp:Calendar>
                        </td>
                    </tr>
                    <tr>
                        <td class="style1">
                            <asp:Label ID="arrivelcity" runat="server" Text="Label" 
                                Style="text-align: left; color: #666666; font-size: small;" 
                                ForeColor="White"></asp:Label>
                        </td>
                        <td style="width: 100px; height: 24px;">
                            <asp:TextBox ID="arrivelcity_box" runat="server" Width="128px"></asp:TextBox>
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 51px; text-align: center;" colspan="2">
                            <asp:ImageButton ID="reset_button" runat="server" ImageUrl="~/images/reset_button.png"
                                OnClick="reset_button_Click" />
                            &nbsp;&nbsp;
                            <asp:ImageButton ID="select_button" runat="server" ImageUrl="~/images/select_button.jpg"
                                OnClick="select_button_Click" />
                            &nbsp;
                        </td>
                    </tr>
                    <tr><td height="360" class="style2"></td></tr>
                </table>
            </td>
            <td valign="top">
                <table style="left: 287px; position: absolute; height: 44px; background-color: #5296b5">
                    <tr>
                        <td style="background-image: url(images/pointout_line.jpg); width: 98px; height: 34px;
                            font: caption; border-right: lightgrey thin solid; border-top: lightgrey thin solid;
                            border-left: lightgrey thin solid; border-bottom: lightgrey thin solid;">
                            &nbsp;&nbsp;&nbsp;
                            <asp:Label ID="extra_table" runat="server" Text="Label" Width="103px" 
                                ForeColor="White" style="font-size: medium"></asp:Label>
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 434px;" align="left" valign="top">
                            <asp:GridView ID="GridView1" runat="server" Height="363px" AutoGenerateColumns="False"
                                Style=" text-align: center" AllowPaging="True" Font-Size="Small"
                                BackColor="White" BorderColor="#DEDFDE" BorderStyle="None" BorderWidth="1px"
                                CellPadding="4" ForeColor="Black" GridLines="Vertical" PageSize="15" OnRowEditing="GridView1_RowEditing"
                                OnRowDataBound="GridView1_RowDataBound" OnPageIndexChanging="GridView1_PageIndexChanging"
                                Width="903px">
                                <Columns>
                                    <asp:BoundField DataField="company_type" HeaderText="航空公司" />
                                    <asp:BoundField DataField="starting_city" HeaderText="出发城市" />
                                    <asp:BoundField DataField="terminus_city" HeaderText="抵达城市" />
                                    <asp:BoundField DataField="OneWay_price" HeaderText="单程票价" />
                                    <asp:BoundField DataField="GoAndBack_price" HeaderText="往返票价" />
                                    <asp:BoundField DataField="flight_type" HeaderText="飞机型号" />
                                    <asp:BoundField DataField="starting_time" HeaderText="起飞时间" />
                                    <asp:BoundField DataField="arriving_time" HeaderText="抵达时间" />
                                    <asp:CommandField ButtonType="Button" EditText="预定" ShowEditButton="True" />
                                </Columns>
                                <PagerSettings FirstPageText="首页" LastPageText="尾页" NextPageText="下页" PreviousPageText="上页"
                                    Mode="NextPreviousFirstLast" />
                                <RowStyle BackColor="#F7F7DE" Font-Size="x-Small" />
                                <SelectedRowStyle BackColor="#CE5D5A" Font-Bold="True" ForeColor="White" />
                                <PagerStyle BackColor="#F7F7DE" ForeColor="Black" HorizontalAlign="Right" Font-Size="Small" />
                                <HeaderStyle BackColor="#f4b200" Font-Bold="True" ForeColor="White" Font-Size="Small" />
                                <AlternatingRowStyle BackColor="White" />
                            </asp:GridView>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    
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
