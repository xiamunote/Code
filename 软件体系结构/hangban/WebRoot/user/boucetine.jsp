<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>Insert title here</title>
	</head>

	<body>
		退票页面

		
					<form action="boucetine.do?method=boucetine1" method="post">
						<table border="1" align="center">
							<tr>
								<td>
									预定人
								</td>
								<td>
									航班号
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
								<td>
									操作
								</td>
							</tr>
						<c:forEach items="${listall}" var="item">
							<tr>
								<td>
									${item.userinfo.username}
								</td>
								<td>
									${item.flight.flightno}
								</td>
								<td>
									${item.flight.flighttype}
								</td>
								<td>
									${item.flight.qdzhan }
								</td>
								<td>
									${item.flight.zhdzhan }
								</td>
								<td>
									${item.flight.leavetime}
								</td>
								<td>
									${item.flight.arrivetime}
								</td>
								<td>
									<fmt:formatDate value="${item.reservtime}" pattern="yyyy-MM-dd hh:mm" />
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
								<td>
									<a href="boucetine.do?method=boucetine1&reservid=${item.reservid}&softnumber=${item.softnumber}&hardnumber=${item.hardnumber }">退票</a>
								</td>
								
							</tr>
						</c:forEach>
						</table>
						<a href="index.jsp">返回首页</a>
					</form>
				
	</body>
</html>