<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>Insert title here</title>
	</head>
	<body background="image/hb.jpg">

		<form action="deleteflight.do?method=deleteflight" name="testForm"
			method="post" onsubmit="return deleteFlight()">
			<table border="1" align="center">
				<tr>
					<td>
						ѡ��
					</td>
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

				<c:forEach items="${listFlight}" var="item">
					<tr>
						<td>
							<input type="checkbox" name="flightid" value="${item.flightid }">
						</td>
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
						</td>
						<td>
							${item.softprice}
						</td>
						<td>
							${item.hardtotal}
						</td>
						<td>
							${item.hardprice}
						</td>

						<td>
							<html:link action="modify.do?method=modify&id=${item.flightid }">�޸�</html:link>
						</td>
					</tr>

				</c:forEach>

			</table>
			
			<p align="center">
				<input type="button" name="but" value="����"
					onclick="location.href='add.do?method=add'">
				<input type="submit" name="butt" value="ɾ��">
			</p>

			<logic:greaterThan value="1" name="currentpage">
				<a href="flightManager.do?method=listFlight&curr=1">��ҳ</a>
				<a href="flightManager.do?method=listFlight&curr=${currentpage-1}">��һҳ</a>

			</logic:greaterThan>
			&nbsp;&nbsp;
			<strong>��${currentpage}ҳ/��${page}ҳ</strong> &nbsp;&nbsp;
			<logic:lessThan value="${page}" name="currentpage">

				<a href="flightManager.do?method=listFlight&curr=${currentpage+1}">��һҳ</a>	&nbsp;&nbsp;
				<a href="flightManager.do?method=listFlight&curr=${page}">ĩҳ</a>

			</logic:lessThan>
			<a href="index.jsp">������ҳ</a>
		</form>

	</body>
</html>
<!--  -->

<script>
	function deleteFlight(){
		select=false;
		for(var i=0;i<testForm.length;i++){
			if(testForm.elements[i].type=="checkbox"&&testForm.elements[i].name=="flightid"){
				select=testForm.elements[i].checked;
				if(select==true){
					break;
				}
			}
		}
		if(select==false){
			alert("δѡ�д�ɾ������");
		}
		return select;
	}
</script>

