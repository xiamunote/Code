<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>Insert title here</title>
	</head>
	<body background="../image/hb.jpg">
		
					<html:form action="addflight.do?method=addflight" method="post"
						onsubmit="return validateFlight(this)">
						<center>
							��&nbsp;��&nbsp;��
							<input type="text" name="flightno" value="">
							<br>
							<br>

							��&nbsp;&nbsp;&nbsp;&nbsp;��
							<input type="text" name="flighttype" value="">
							<br>
							<br>

							���վ
							<input type="text" name="qdzhan" value="">
							<br>
							<br>

							�յ�վ
							<input type="text" name="zhdzhan" value="">
							<br>
							<br>
							
							���ʱ��
							<input type="text" name="leavetime" value="">
							<br>
							<br>

							����ʱ��
							<input type="text" name="arrivetime" value="">
							<br>
							<br>
							���ò�Ʊ��
							<input type="text" name="softtotal" value="">
							<br>
							<br>
							���òռ۸�
							<input type="text" name="softprice" value="">
							<br>
							<br>
							�����Ʊ��
							<input type="text" name="hardtotal" value="">
							<br>
							<br>
							����ռ۸�
							<input type="text" name="hardprice" value="">
							<br>
							<br>
							
							<input type="submit" name="sub" value="ȷ��">
							<input type="submit" name="subm" value="����">

						</center>
						<a href="index.jsp">������ҳ</a>
					</html:form>
				
	</body>
</html>
<html:javascript formName="flight" />