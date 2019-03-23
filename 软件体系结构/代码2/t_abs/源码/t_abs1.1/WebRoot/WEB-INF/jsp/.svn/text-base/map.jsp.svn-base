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
			href="${pageContext.request.contextPath}/css/account.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/account_color.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/index.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/index_color.css">

		<!-- jquery -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/jquery-1.4.3.js"></script>

		<!-- 城市控件 -->
		<!--
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity_color.css">
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
										网点名称
									</td>
									<td>
										所属地区
									</td>
									<td>
										详细地址
									</td>
									<td>
										联系电话
									</td>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="branchList">
									<tr class="flightRow"
										onmouseover="this.className='flightRow_hover';"
										onmouseout="this.className='flightRow';">
										<td>
											${branchName }
										</td>
										<td>
											${city }
										</td>
										<td>
											${branchAddress }
										</td>
										<td>
											${branchTelephone1 }
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
