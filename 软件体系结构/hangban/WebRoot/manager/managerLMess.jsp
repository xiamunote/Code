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
	<body background="image/hb.jpg">
		
					<form action="" method="post">

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
									起飞地点
								</td>
								<td>
									到达地点
								</td>
								<td>
									购经济舱票数
								</td>
								<td>
									购商务舱票数
								</td>
								<td>
									总金额
								</td>
								<td>
									预定时间
								</td>
							</tr>
					<c:forEach items="${selectLflight}" var="item">
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
										${item.flight.qdzhan}
									</td>
									<td>
										${item.flight.zhdzhan}
									</td>
									
									<td>
										${item.softnumber}
									</td>
									<td>
										${item.hardnumber}
									</td>
									<td>
										${item.totalprices}
									</td>
															
									<td>
										<fmt:formatDate value="${item.reservtime}" pattern="yyyy-MM-dd hh:mm" />
									</td>
								</tr>
							</c:forEach>
							
						</table>
					<a href="index.jsp">返回首页</a>
					</form>
				
	</body>
</html>