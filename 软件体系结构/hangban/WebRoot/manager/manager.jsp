<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>Insert title here</title>
	</head>
	<body background="image/hb.jpg">
		<table border="1" align="center" width="1000" height="450">
			<tr>
				<td colspan="2" align="center">
					<jsp:include page="/manager/header.jsp" flush="true"></jsp:include>
					
				</td>
			</tr>
			<tr>
				<td>
					<jsp:include page="/manager/leftMana.jsp" flush="true"></jsp:include>
				</td>
				<td>
					<tiles:insert attribute="ubody"></tiles:insert>
					
				</td>
			</tr>
		</table>
	</body>
</html>