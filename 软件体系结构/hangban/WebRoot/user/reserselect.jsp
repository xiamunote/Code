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
									�����
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
									���ò�Ʊ��
								</td>
								<td>
									���òռ۸�
								</td>
								<td>
									�����Ʊ��
								</td>
								<td>
									����ռ۸�
								</td>
								<td>
									����
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
										<font color="red">��</font>
									</td>
									<td>
										${item.softprice}
										<font color="red">Ԫ</font>
									</td>
									<td>
										${item.hardtotal}
										<font color="red">��</font>
									</td>
									<td>
										${item.hardprice}
										<font color="red">Ԫ</font>
									</td>
									<td>
										<a href="reser.do?method=reserflight1&fid=${item.flightid}">Ԥ��</a>
									</td>
								</tr>
							</c:forEach>
						</table><br>
						<a href="index.jsp">������ҳ</a>
					</form>
			
			

	</body>
</html>