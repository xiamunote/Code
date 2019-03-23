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
							航班号
							<input type="text" name="flightno">
							预定人
							<input type="text" name="username" >
							<input type="submit" name="sub" value="立即查询">
							<br>
						</center>
						<table border="1" align="center">
							<tr>

								<td>
									航班号
								</td>
								<td>
									预定人
								</td>
								<td>
									机型
								</td>
								<td>
									起点站
								</td>
								<td>
									终点站
								</td>
								<td>
									起飞时间
								</td>
								<td>
									到达时间
								</td>
								<td>
									预定时间
								</td>
										<td>
									经济舱票数
								</td>
								<td>
									商务舱票数
								</td>
								<td>
									总价格
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
									${item.softnumber}<font color="red">张</font>
								</td>
								<td>
									${item.hardnumber}<font color="red">张</font>
								</td>
								<td>
									${item.totalprices}<font color="red">元</font>
								</td>
								</tr>
							</c:forEach>
						</table>
						<br>
						<a href="index.jsp">返回首页</a>
					</form>
				
	</body>
</html>