<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>Insert title here</title>
	</head>
	<body background="image/hb.jpg">< < �û�����
		<form action="updateuser.do?method=updateuser" method="post">
			<table align="center" border="0">
				<tr>
					<td>
						�û�ID
					</td>
					<td>
						<input type="text" name="userid" value="${updateUser.userid }">
					</td>

				</tr>
				<tr>
					<td>
						�û���
					</td>
					<td>
						<input type="text" name="username" value="${updateUser.username }">
					</td>
				</tr>
				<tr>
					<td>
						��ʵ����
					</td>
					<td>
						<input type="text" name="realname" value="${updateUser.realname }">
					</td>
				</tr>
				<tr>
					<td>
						����
					</td>
					<td>
						<input type="text" name="password" value="${updateUser.password }">
					</td>
				</tr>
				<tr>
					<td>
						����
					</td>
					<td>
						<input type="text" name="age" value="${updateUser.age }">
					</td>
				</tr>
				<tr>
					<td>
						�����ʼ�
					</td>
					<td>
						<input type="text" name="email" value="${updateUser.email }">
					</td>
				</tr>
			</table>
			<center>
				<input type="submit" name="sub" value="ȷ��">
				<input type="reset" name="res" value="����">
				<a href="index.jsp">������ҳ</a>
			</center>
		</form>
	</body>
</html>