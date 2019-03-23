<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<body>
		<form action="reser.do?method=reserflight" method="post">
		<center>

			<table >

				<tr>


					<td align="center">
						经济舱票数
						<input type="text" name="softnumber" >
					</td>
				</tr>
				
				<tr>


					<td align="center">
						商务舱票数
						<input type="text" name="hardnumber">

					</td>
				</tr>				
				
				<tr>
					<td align="center">
							<input type="submit" name="sub" value="确定">
					</td>
				
				</tr>

			</table>
			</center>
			<a href="index.jsp">返回首页</a>
		</form>
	</body>
</html>
