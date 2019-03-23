<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>Insert title here</title>
	</head>
	<body background="image/hb.jpg">< < 用户管理
		<form action="updateuser.do?method=updateuser" method="post">
			<table align="center" border="0">
				<tr>
					<td>
						用户ID
					</td>
					<td>
						<input type="text" name="userid" value="${updateUser.userid }">
					</td>

				</tr>
				<tr>
					<td>
						用户名
					</td>
					<td>
						<input type="text" name="username" value="${updateUser.username }">
					</td>
				</tr>
				<tr>
					<td>
						真实姓名
					</td>
					<td>
						<input type="text" name="realname" value="${updateUser.realname }">
					</td>
				</tr>
				<tr>
					<td>
						密码
					</td>
					<td>
						<input type="text" name="password" value="${updateUser.password }">
					</td>
				</tr>
				<tr>
					<td>
						年龄
					</td>
					<td>
						<input type="text" name="age" value="${updateUser.age }">
					</td>
				</tr>
				<tr>
					<td>
						电子邮件
					</td>
					<td>
						<input type="text" name="email" value="${updateUser.email }">
					</td>
				</tr>
			</table>
			<center>
				<input type="submit" name="sub" value="确定">
				<input type="reset" name="res" value="重置">
				<a href="index.jsp">返回首页</a>
			</center>
		</form>
	</body>
</html>