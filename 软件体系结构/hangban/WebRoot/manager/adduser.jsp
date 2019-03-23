<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
	<body background="image/hb.jpg"><br>< < 用户管理
    <html:form action="adduser.do?method=adduser" method="post">
    	<table border="0" align="center">
    		<tr>
					<td>  
						用户名  
					<br><br></td>
					<td>
						<input type="text" name="username" value="">
					</td>
					
			</tr>
			<tr>
					<td>
						真实姓名
					</td>
					<td>
						<input type="text" name="realname" value="">
					</td>
					
			</tr>
			<tr>
					<td>
						密码
					</td>
					<td>
						<input type="text" name="password" value="">
					</td>
					
			</tr>
			<tr>
					<td>
						年龄
					</td>
					<td>
						<input type="text" name="age" value="">
					</td>
					
			</tr>
			<tr>
					<td>
						电子邮件
					</td>
					<td>
						<input type="text" name="email" value="">
					</td>
					
			</tr>
    	</table>
    		<center>
    			<input type="submit" name="sub" value="确定">
    			<input type="reset" name="sub" value="重置">
    			<a href="index.jsp">返回首页</a>
    		</center>
    		
    </html:form>
  </body>
</html>
