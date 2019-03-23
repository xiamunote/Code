<%@ Page Language="C#" AutoEventWireup="true" CodeFile="OrderForm.aspx.cs" Inherits="OrderForm" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>填写订单</title>
    <style type="text/css">
        .style1
        {
            font-size: small;
            color: #FEFFFF;
        }
        .style2
        {
            color: #FEFFFF;
        }
        .style3
        {
            
            width: 158px;
           
          
            color: #FEFFFF;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
   <table width="1200px" border="0" cellpadding="0" cellspacing="0" background="images/bg1.gif">
        <tr>
            <td width="100%" align="left" height="90">
             <img src ="images/l.png" />
            </td>
            <td>
                <img src="images/spacer.gif" width="101" height="1" /><br>
            </td>
        </tr>
    </table>   
    <div style ="width :1200px; background-color : #5296b5">
        <table style="width: 500px; height: 23px; border-top-width: thin; border-left-width: thin; border-left-color: #6699ff; border-bottom-width: thin; border-bottom-color: #6699ff; border-top-color: #6699ff; border-right-width: thin; border-right-color: #6699ff;">
            <tr>
                <td style=" font: caption; width: 158px;
                    height: 30px" colspan="2">
                    <span class="style2">&nbsp; &nbsp;</span><span class="style1">填写订单：</span></td>
            </tr>
            <tr>
                <td style="font: caption; text-align: right;" class="style3">
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
                    <asp:Label ID="Label1" runat="server" Text="联系人：" Width="64px" 
                        style="font-size: small"></asp:Label>
                  
                    </td>
                <td  >
                    <asp:TextBox ID="relator" runat="server"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                        ControlToValidate="relator" ErrorMessage="*" ></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td style="font: caption; text-align: right;" class="style3">
                    <asp:Label ID="Label2" runat="server" Text="E_mail：" 
                        Width="64px" style="text-align: right; font-size: small;"></asp:Label>
                    </td>
                <td >
                    <asp:TextBox ID="email" runat="server"></asp:TextBox>
                    <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" 
                        ControlToValidate="email" ErrorMessage="*"
                        ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator>
                    </td>
            </tr>
            <tr>
                <td style="font: caption; text-align: right;" class="style3">
                    <asp:Label ID="Label4" runat="server"  Text="电  话：" Width="64px" 
                        style="text-align: right; font-size: small;"></asp:Label>
                    </td>
                <td >
                    <asp:TextBox ID="mobilephone" runat="server"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
                        ControlToValidate="mobilephone" ErrorMessage="*"></asp:RequiredFieldValidator>
                    </td>
            </tr>
            <tr>
                <td style="font: caption; text-align: right;" class="style3">
                    <asp:Label ID="Label3" runat="server" Text="手  机：" 
                        Width="64px" style="font-size: small"></asp:Label>
                    </td>
                <td style="font: caption; " >
                    <asp:TextBox ID="telephone" runat="server"></asp:TextBox>
                    </td>
            </tr>
            <tr>
                <td style="font: caption; text-align: right;" class="style3">
                    <asp:Label ID="Label5" runat="server" Height="12px"  Text="身份证号：" 
                        Width="74px" style="font-size: small"></asp:Label>
                    </td>
                <td style="font: caption; " >
                    <asp:TextBox ID="id" runat="server"></asp:TextBox>
                    <asp:RegularExpressionValidator ID="RegularExpressionValidator2" runat="server" ControlToValidate="id"
                        ErrorMessage="*" 
                       
                        ValidationExpression="\d{17}[\d|X]|\d{15}"></asp:RegularExpressionValidator>
                </td>
            </tr>
            <tr>
                <td style="font: caption; text-align: right;" class="style3">
                    <asp:Label ID="Label6" runat="server"  Text="地 址：" style="font-size: small"></asp:Label>
                </td>
                <td style="font: caption; " >
                    <asp:TextBox ID="address" runat="server" Height="44px"  TextMode="MultiLine" Width="301px"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="address"
                        ErrorMessage="*" 
                      ></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center" >
                    <asp:Button ID="submit_button" runat="server" Height="22px" OnClick="submit_button_Click"
                       Text="预定" ToolTip="group" Width="47px" />
                </td>
            </tr>
        </table>
    
    </div> 
    </form>
</body>
</html>
