<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
	<body background="image/hb.jpg"><br>< < �û�����
    <html:form action="adduser.do?method=adduser" method="post">
    	<table border="0" align="center">
    		<tr>
					<td>  
						�û���  
					<br><br></td>
					<td>
						<input type="text" name="username" value="">
					</td>
					
			</tr>
			<tr>
					<td>
						��ʵ����
					</td>
					<td>
						<input type="text" name="realname" value="">
					</td>
					
			</tr>
			<tr>
					<td>
						����
					</td>
					<td>
						<input type="text" name="password" value="">
					</td>
					
			</tr>
			<tr>
					<td>
						����
					</td>
					<td>
						<input type="text" name="age" value="">
					</td>
					
			</tr>
			<tr>
					<td>
						�����ʼ�
					</td>
					<td>
						<input type="text" name="email" value="">
					</td>
					
			</tr>
    	</table>
    		<center>
    			<input type="submit" name="sub" value="ȷ��">
    			<input type="reset" name="sub" value="����">
    			<a href="index.jsp">������ҳ</a>
    		</center>
    		
    </html:form>
  </body>
</html>
