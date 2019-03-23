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
							航&nbsp;班&nbsp;号
							<input type="text" name="flightno" value="">
							<br>
							<br>

							机&nbsp;&nbsp;&nbsp;&nbsp;型
							<input type="text" name="flighttype" value="">
							<br>
							<br>

							起点站
							<input type="text" name="qdzhan" value="">
							<br>
							<br>

							终点站
							<input type="text" name="zhdzhan" value="">
							<br>
							<br>
							
							起飞时间
							<input type="text" name="leavetime" value="">
							<br>
							<br>

							到达时间
							<input type="text" name="arrivetime" value="">
							<br>
							<br>
							经济舱票数
							<input type="text" name="softtotal" value="">
							<br>
							<br>
							经济舱价格
							<input type="text" name="softprice" value="">
							<br>
							<br>
							商务舱票数
							<input type="text" name="hardtotal" value="">
							<br>
							<br>
							商务舱价格
							<input type="text" name="hardprice" value="">
							<br>
							<br>
							
							<input type="submit" name="sub" value="确定">
							<input type="submit" name="subm" value="重置">

						</center>
						<a href="index.jsp">返回首页</a>
					</html:form>
				
	</body>
</html>
<html:javascript formName="flight" />