<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>Insert title here</title>
	</head>
	<body background="image/hb.jpg">
		<form action="deleteuser.do?method=deleteuser" method="post">
			<table border="1" align="center">
				<tr>
					<td>
						选中 
					</td>
					<td>
						用户名
					</td>
					<td>
						真实姓名
					</td>
					<td>
						密码
					</td>
					<td>
						年龄
					</td>
					<td>
						电子邮件
					</td>
					<td>
						操作
					</td>
				</tr>

				<c:forEach items="${listuser}" var="item">
					<tr>
						<td>
							<input type="checkbox" name="userid" value="${item.userid}">
						</td>
						<td>
							${item.username}
						</td>
						<td>
							${item.realname}
						</td>
						<td>
							${item.password}
						</td>
						<td>
							${item.age}
						</td>
						<td>
							${item.email}
						</td>
						<td>
							<html:link action="modifyUser.do?method=modifyUser&userid=${item.userid}">修改</html:link>
						</td>
					</tr>
				</c:forEach>
			</table>
				<center>
					<input type="button" name="but" value="新增用户信息" onclick="location.href='addU.do?method=add'">
					<input type="submit" name="sub" value="删除用户信息">
				</center>
		</form>
	</body>
</html>