<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>Insert title here</title>
	</head>
	<body background="image/hb.jpg">
		
					<form action="managerselect.do?method=managerselect" method="post">
						<center>
							�����
							<input type="text" name="flightno">
							Ԥ����
							<input type="text" name="username" >
							<input type="submit" name="sub" value="������ѯ">
							<br>
						</center>
						<table border="1" align="center">
							<tr>

								<td>
									�����
								</td>
								<td>
									Ԥ����
								</td>
								<td>
									����
								</td>
								<td>
									���վ
								</td>
								<td>
									�յ�վ
								</td>
								<td>
									���ʱ��
								</td>
								<td>
									����ʱ��
								</td>
								<td>
									Ԥ��ʱ��
								</td>
										<td>
									���ò�Ʊ��
								</td>
								<td>
									�����Ʊ��
								</td>
								<td>
									�ܼ۸�
								</td>
							</tr>

							<c:forEach items="${reserveflight}" var="item">
								<tr>
									<td>
										${item.flight.flightno }
									</td>
									<td>
										${item.userinfo.username }
									</td>
									<td>
										${item.flight.flighttype }
									</td>
									<td>
										${item.flight.qdzhan }
									</td>
									<td>
										${item.flight.zhdzhan }
									</td>
									<td>
										${item.flight.leavetime }
									</td>
									<td>
										${item.flight.arrivetime }
									</td>
									<td>
										${item.reservtime }
									</td>
									<td>
									${item.softnumber}<font color="red">��</font>
								</td>
								<td>
									${item.hardnumber}<font color="red">��</font>
								</td>
								<td>
									${item.totalprices}<font color="red">Ԫ</font>
								</td>
								</tr>
							</c:forEach>
						</table>
						<br>
						<a href="index.jsp">������ҳ</a>
					</form>
				
	</body>
</html>