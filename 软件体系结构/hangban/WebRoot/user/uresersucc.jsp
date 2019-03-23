<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<tiles:insert page="utiles.jsp" >
		
		<tiles:put name="ubody" value="/user/resersucc.jsp"></tiles:put>
		
	</tiles:insert>
</body>
</html>