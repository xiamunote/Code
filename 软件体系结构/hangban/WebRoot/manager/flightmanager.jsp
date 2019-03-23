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
						选中
					</td>
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
							<html:link action="modify.do?method=modify&id=${item.flightid }">修改</html:link>
						</td>
					</tr>

				</c:forEach>

			</table>
			
			<p align="center">
				<input type="button" name="but" value="新增"
					onclick="location.href='add.do?method=add'">
				<input type="submit" name="butt" value="删除">
			</p>

			<logic:greaterThan value="1" name="currentpage">
				<a href="flightManager.do?method=listFlight&curr=1">首页</a>
				<a href="flightManager.do?method=listFlight&curr=${currentpage-1}">上一页</a>

			</logic:greaterThan>
			&nbsp;&nbsp;
			<strong>第${currentpage}页/共${page}页</strong> &nbsp;&nbsp;
			<logic:lessThan value="${page}" name="currentpage">

				<a href="flightManager.do?method=listFlight&curr=${currentpage+1}">下一页</a>	&nbsp;&nbsp;
				<a href="flightManager.do?method=listFlight&curr=${page}">末页</a>

			</logic:lessThan>
			<a href="index.jsp">返回首页</a>
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
			alert("未选中待删除的行");
		}
		return select;
	}
</script>

