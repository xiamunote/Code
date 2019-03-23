<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>Insert title here</title>
	</head>
	<body>
		
					<form action="" method="post">			
						<table border="1" align="center">
							<tr>

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
									经济舱票数
								</td>
								<td>
									经济舱价格
								</td>
								<td>
									商务舱票数
								</td>
								<td>
									商务舱价格
								</td>
								<td>
									操作
								</td>
							</tr>

							<c:forEach items="${reserselect}" var="item">
								<tr>

									<td>
										${item.flightno}
									</td>
									<td>
										${item.flighttype}
									</td>
									<td>
										${item.qdzhan }
									</td>
									<td>
										${item.zhdzhan }
									</td>
									<td>
										${item.leavetime}
									</td>
									<td>
										${item.arrivetime}
									</td>
									<td>
										${item.softtotal}
										<font color="red">张</font>
									</td>
									<td>
										${item.softprice}
										<font color="red">元</font>
									</td>
									<td>
										${item.hardtotal}
										<font color="red">张</font>
									</td>
									<td>
										${item.hardprice}
										<font color="red">元</font>
									</td>
									<td>
										<a href="reser.do?method=reserflight1&fid=${item.flightid}">预定</a>
									</td>
								</tr>
							</c:forEach>
						</table><br>
						<a href="index.jsp">返回首页</a>
					</form>
			
			

	</body>
</html>