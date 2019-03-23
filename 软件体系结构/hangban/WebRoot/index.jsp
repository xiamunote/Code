<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body background="image/bg.jpg">
  <center>
    <html:form action="login.do?method=login" method="post" onsubmit="return validateLoginForm(this)"> 
   <table  border="0">
   		<tr ><th colspan="2">航班预订系统</th></tr>
   		<tr>
   			<td>
   				用户名
   			</td>
   			<td>
   				 <input type="text" name="username" value=""><br><br>
   			</td>
   		</tr>
   		<tr>
   			<td>
   				 密&nbsp;&nbsp;码&nbsp;
   			</td>
   			<td>
   				<input type="password" name="password" value=""><br><br>
   			</td>
   		</tr>
   		<tr>
   			<td>
   				身&nbsp;&nbsp;份
   			</td>
   			<td>
   				<input type="radio" name="ismanager" value="1">普通用户
				<input type="radio" name="ismanager" value="2">管理员<br><br>
   			</td>
   		</tr>
   			<tr>
   			<td>
   			
   			</td>
   			<td>
   				<input type="submit" name="sub" value="登录">
				<input type="button" name="but" value="立即注册" onclick="location.href='regist.jsp'"> <br>
   			</td>
   		</tr>
		
		<html:errors/>
		</table>
	</html:form> 
	</center>
  </body>
</html>
<html:javascript formName="loginForm"/>

