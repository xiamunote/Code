<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
	<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>Insert title here</title>
	</head>
	<body background="image/hb.jpg">
		

					<html:form action="updateflight.do?method=updateflight" method="post" onsubmit="return validateFlight(this)">
						<table border="0" align="center">
							<tr>
								<td>
									����ID
								</td>
								<td>
									<input type="text" name="flightid"
										value="${updateFlight.flightid }">
								</td>
							</tr>
							<tr>
								<td>
									�����
								</td>
								<td>
									<input type="text" name="flightno"
										value="${updateFlight.flightno }">
								</td>
							</tr>
							<tr>
								<td>
									��&nbsp;&nbsp;��
								</td>
								<td>
									<input type="text" name="flighttype"
										value="${updateFlight.flighttype }">
								</td>
							</tr>
							<tr>
								<td>
									���վ
								</td>
								<td>
									<input type="text" name="qdzhan"
										value="${updateFlight.qdzhan }">
								</td>
							</tr>							<tr>
								<td>
									�յ�վ
								</td>
								<td>
									<input type="text" name="zhdzhan"
										value="${updateFlight.zhdzhan }">
								</td>
							</tr>
							<tr>
								<td>
									���ʱ��
								</td>
								<td>
									<input type="text" name="leavetime"
										value="${updateFlight.leavetime }">
								</td>
							</tr>
							<tr>
								<td>
									����ʱ��
								</td>
								<td>
									<input type="text" name="arrivetime"
										value="${updateFlight.arrivetime }">
								</td>
							</tr>
							<tr>
								<td>
									����Ʊ��
								</td>
								<td>
									<input type="text" name="softtotal"
										value="${updateFlight.softtotal }">
								</td>
							</tr>
							<tr>
								<td>
									�����۸�
								</td>
								<td>
									<input type="text" name="softprice"
										value="${updateFlight.softprice }">
								</td>
							</tr>
							<tr>
								<td>
									Ӳ��Ʊ��
								</td>
								<td>
									<input type="text" name="hardtotal"
										value="${updateFlight.hardtotal }">
								</td>
							</tr>
							<tr>
								<td>
									Ӳ���۸�
								</td>
								<td>
									<input type="text" name="hardprice"
										value="${updateFlight.hardprice }">
								</td>
							</tr>

						</table>
						<center>
							<input type="submit" name="sub" value="ȷ��">
							<input type="submit" name="subm" value="����">
						</center>
					<a href="index.jsp">������ҳ</a>
					</html:form>
				
	</body>
</html>
<html:javascript formName="flight"/>
