<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>途乐航空[官方网站] – 北京达内科技有限公司</title>
		<link rel="SHORTCUT ICON"
			href="${pageContext.request.contextPath}/images/favicon.ico">
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
		<meta name="description"
			content="北京途乐航空官方网站，北京途乐航空有限公司，是一家总部位于北京的公共运输航空公司。途乐航空秉承“安全、简单、亲和”的服务理念，为旅客提供特色化的菜单式服务和舒适、方便、快捷的出行服务体验提供机票预订及航班动态查询服务。途乐航空电话订票热线 95071999。">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common_color.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/account.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/account_color.css">

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

				<!-- 左侧-->
				<s:include value="/WEB-INF/jsp/common/left.jsp">
				</s:include>

				<!-- 右侧-->
				<div id="main">
					<div id="maincontent">
						<img src="${pageContext.request.contextPath}/images/reg.gif"
							class="regchoose" usemap="#Map">
						<map name="Map" id="Map">
							<area shape="rect" coords="243,87,356,198"
								href="${pageContext.request.contextPath}/account/register_user.jsp" />
							<area shape="rect" coords="387,86,503,199"
								href="${pageContext.request.contextPath}/account/register_company.jsp" />
						</map>
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
