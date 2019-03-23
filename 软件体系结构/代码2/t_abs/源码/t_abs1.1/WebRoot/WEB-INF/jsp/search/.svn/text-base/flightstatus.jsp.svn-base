<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>途乐航空[官方网站] – 北京达内科技有限公司</title>
		<link rel="SHORTCUT ICON"
			href="${pageContext.request.contextPath}/images/favicon.ico">
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
		<meta name="keywords" content="北京途乐航空有限公司 北京 途乐 途乐航空 机票">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common_color.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/order.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/order_color.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/account.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/account_color.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/index.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/index_color.css">

		<!-- jquery -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/jquery-1.4.3.js" ></script>
		
		
		<!-- 查询城市需要的css样式 -->
		<!-- 
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity_color.css" />         
         -->
         
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
						<table cellpadding="5" cellspacing="0" class="flightStatus">
							<thead>
								<tr class="flightStatusHeader">
									<td>
										航班号
									</td>
									<td>
										起飞机场
									</td>
									<td>
										到达机场
									</td>
									<td>
										起飞时间
									</td>
									<td>
										到达时间
									</td>
									<td>
										航班型号
									</td>
									<td>
										航班距离
									</td>
									<td>
										价格
									</td>
									<td>
										状态
									</td>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="Flight01List">
									<tr class="flightRow"
										onmouseover="this.className='flightRow_hover';"
										onmouseout="this.className='flightRow';">
										<td>
											<a href="findFlight?flightId=<s:property value="fid"/>">
												<span class="red"><s:property value="flightNum" />
											</span> </a>
										</td>
										<td>
											<s:property value="fromAirportFullName" />
										</td>
										<td>
											<s:property value="toAirportFullName" />
										</td>
										<td>
											<s:property value="flDepartureTime" />
										</td>
										<td>
											<s:property value="flArrivalTime" />
										</td>
										<td>
											<s:property value="planeModel" />
										</td>
										<td>
											<s:property value="routeDistance" />
										</td>
										<td>
											<s:property value="price" />
										</td>
										<td>
											<img src="${pageContext.request.contextPath}/images/h_dg.gif"
												title="到达" />
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
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
