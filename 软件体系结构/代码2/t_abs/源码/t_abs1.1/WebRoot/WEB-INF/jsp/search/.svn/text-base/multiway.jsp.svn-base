<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>途乐航空[官方网站] – 北京达内科技有限公司</title>
		<link rel="SHORTCUT ICON"
			href="${pageContext.request.contextPath}/images/favicon.ico">
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common_color.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/order.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/order_color.css">

		<!-- jquery -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/jquery-1.4.3.js"></script>


		<script language="javascript">   

           //检查输入是否为null
           function checkForm2(){
           		if($("#m_orgCity_m_1").val() == ""){
           			alert("出发地不能为空");
           			return false;
           		}else if($("#m_orgCity_m_2").val() == ""){
           			alert("目的城市不能为空");
           			return false;
           		}
           		return true;
           }
          
        </script>
	</head>
	<body>
		<div id="page">
			<!-- 头部-->
			<!-- 引入头部文件 -->
			<s:include value="/WEB-INF/jsp/common/header.jsp">
			</s:include>

			<!-- 页面主体-->
			<div id="subpage">

				<!-- 左侧 -->
				<s:include value="/WEB-INF/jsp/common/left.jsp">
				</s:include>

				<!-- 右侧-->
				<div id="main">
					<div id="maincontent">
						<form action="list.action" method="post">
							<table class="multiway">
								<tr>
									<td class="headerInfo">
										<p>
											<img
												src="${pageContext.request.contextPath}/images/icon_1.gif">
											&nbsp;&nbsp;查询航班信息
										</p>
									</td>
								</tr>
								<tr>
									<td>
										<table cellspacing="0" cellpadding="0">
											<tr>
												<td width="1" class="line_seperate"></td>
												<td class="flight_city">
													出发城市：
													<input id="m_orgCity_m_1" class="textbox width120"
													name="startAirport" onclick="showCities(event,'m_orgCity_m_1',1);">
												</td>
												<td class="flight_city">
													到达城市：
													<input id="m_orgCity_m_2" name="endAirport"
													class="textbox width120" onclick="showCities(event,'m_orgCity_m_2',1);">
												</td>
												<td>
													出发日期：
													<!-- 日期控件，请参考http://www.my97.net/ -->
													<input id="d123" name="startDate" onfocus="WdatePicker()" />
													<img onclick="WdatePicker({el:'d123'})"
														src="${pageContext.request.contextPath}/datepicker/skin/datePicker.gif"
														width="24" height="30" align="absmiddle">
												</td>
											</tr>
										</table>
									</td>
								</tr>

								<tr>
									<td class="search_button">
										<input name="inpNext" type="submit" class="ipt" value="查　询" 
										onclick="return checkForm2();">
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>

			<!-- 底部版权信息开始-->
			<s:include value="/WEB-INF/jsp/common/footer.jsp">
			</s:include>

		</div>
		<div id="spring" class="backgroundimg"></div>
	</body>
</html>
