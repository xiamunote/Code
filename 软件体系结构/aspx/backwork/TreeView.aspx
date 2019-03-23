<%@ Page Language="C#" AutoEventWireup="true" CodeFile="TreeView.aspx.cs" Inherits="backwork_login" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>后台管理</title>
</head>
<body>
    <form id="form1" runat="server">
    
    <div>
        <table>
            <tr>
                <td style="height: 159px; background-image: url(../images/bg1.gif);" colspan="2">
                 <img src ="../images/l.png" />
                    <asp:ImageButton ID="unlogin_b" runat="server" ImageUrl="~/images/1.png" OnClick="unlogin_b_Click1"
                        Style="z-index: 100; left: 1026px; position: absolute; top: 145px" />
                    <asp:Label ID="Label1" runat="server" Style="z-index: 101; left: 114px; font: caption;
                        color: #4f91c3; position: absolute; top: 156px" Text="Label" Width="130px"></asp:Label>
                    <asp:Label ID="Label2" runat="server" Style="z-index: 103; left: 34px; font: caption;
                        color: #4f91c3; position: absolute; top: 156px" Text="登录用户："></asp:Label>
                </td>
            </tr>
            <tr>
                <td style="width: 157px; height: 445px; border-right: #1e0b92 1px solid; border-top: #1e0b92 1px solid; border-left: #1e0b92 1px solid; border-bottom: #1e0b92 1px solid;">
                <asp:TreeView ID="TreeView1" runat="server" Height="242px" Style="z-index: 100; left: 13px;
                        position: absolute; top: 212px" Width="1px" ExpandDepth="0">
                        <Nodes>
                            <asp:TreeNode Text="登录管理" Value="登录管理">
                                <asp:TreeNode Text="添加用户" Value="添加用户" NavigateUrl="~/backwork/AddUser.aspx" Target="frame"></asp:TreeNode>
                                <asp:TreeNode Text="修改密码" Value="修改密码" NavigateUrl="~/backwork/AlterPW.aspx" Target="frame"></asp:TreeNode>
                                <asp:TreeNode Text="删除用户" Value="删除用户" NavigateUrl="~/backwork/DeleteUser.aspx" Target="frame"></asp:TreeNode>
                            </asp:TreeNode>
                            <asp:TreeNode Text="数据管理" Value="数据管理">
                                <asp:TreeNode NavigateUrl="~/backwork/AddFlightInfor.aspx" Target="frame" Text="添加航班信息"
                                    Value="添加航班信息"></asp:TreeNode>
                                <asp:TreeNode NavigateUrl="~/backwork/UpDateFlight.aspx" Target="frame" Text="修改库存机票"
                                    Value="修改库存机票"></asp:TreeNode>
                                <asp:TreeNode NavigateUrl="~/backwork/HomePage.aspx" Target="frame" Text="查看库存票数"
                                    Value="查看库存票数"></asp:TreeNode>
                            </asp:TreeNode>
                            <asp:TreeNode Text="订单管理" Value="订单管理">
                                <asp:TreeNode Text="查看客户订单" Value="查看客户订单" NavigateUrl="~/backwork/LookOrder.aspx" Target="frame"></asp:TreeNode>
                            </asp:TreeNode>
                            <asp:TreeNode Text="投诉意见处理" Value="投诉意见处理">
                                <asp:TreeNode Text="查看客户意见" Value="查看客户意见" NavigateUrl="~/backwork/LookSug.aspx" Target="frame"></asp:TreeNode>
                            </asp:TreeNode>
                        </Nodes>
                        <RootNodeStyle Font-Bold="True" ForeColor="Gray" Font-Names="微软雅黑" />
                        <LeafNodeStyle Font-Names="微软雅黑" ForeColor="Gray" Font-Bold="False" />
                    </asp:TreeView>
                    <asp:Image ID="Image1" runat="server" Height="30px" ImageUrl="~/images/pointout_line.jpg"
                        Style="z-index: 102; left: 11px; position: absolute; top: 179px" Width="162px" />
                    <asp:Label ID="Label3" runat="server" Text="后台导航"  
                        Style="z-index: 103; left: 19px; position: absolute; top: 185px; color: #FFFFFF; font-weight: 700;"></asp:Label>
                </td>
                <td style="width: 947px; height: 445px; border-top-width: 1px; border-left-width: 1px; border-left-color: #1e0b92; border-bottom-width: 1px; border-bottom-color: #1e0b92; border-top-color: #1e0b92; border-right-width: 1px; border-right-color: #1e0b92;">
                <iframe src="HomePage.aspx" style="height: 445px; width: 945px; z-index: 100; left: 175px; position: absolute; top: 180px; border-right: #1e0b92 1px solid; border-top: #1e0b92 1px solid; border-left: #1e0b92 1px solid; border-bottom: #1e0b92 1px solid; background-color: #ffcc99;" frameborder="0" height="640" name="frame" scrolling="no" width="586" id="IFRAME1" ></iframe>
                </td>
            </tr>
            <tr>
                <td background="../images/bg11.gif" align="right" width="258" height="52" colspan="2">
                   </td>
            </tr>
        </table>

    </div>
    </form>
</body>
</html>
