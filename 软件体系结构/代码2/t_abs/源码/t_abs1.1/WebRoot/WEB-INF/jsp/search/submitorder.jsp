<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>途乐航空[官方网站] – 北京达内科技有限公司</title>
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
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
						<table>
							<tr>
								<td align="left" class="font_black12">
									<img
										src="${pageContext.request.contextPath}/images/icon_hbcx.gif">
									<a href="#" class="black">航线查询</a> -&gt;
									<a href="#" class="black">选择航班</a> -&gt;
									<a href="#" class="black">填写资料</a>-&gt;
									<a href="#" class="red">支付</a>-&gt;
									<a href="#" class="black">出票</a>
								</td>
							</tr>
							<tr>
								<td class="line"></td>
							</tr>
						</table>
						<!--成功提示信息-->
						<div class="order_success_info">
							<span> 恭喜您，订单生成成功！ 订单号：<s:property value="orderId"/>, 请您完成订单支付！</span>
							<br>
							注意：您需要在30分钟内完成在线支付和后续操作。 超过30分钟，航空公司将不保证您的订单有效。
						</div>
						<!--旅客信息-->
						<table class="order_person_header">
							<tr>
								<td class="font_black12 bold700">
									旅客信息
								</td>
								<td></td>
							</tr>
						</table>
						<table class="order_person_info" cellspacing="0">
							<tr>
								<th>
									序号
								</th>
								<th>
									姓名
								</th>
								<th>
									证件类型
								</th>
								<th>
									证件号码
								</th>
								<th>
									保险
								</th>
							</tr>

							<s:iterator value="listAdult" status="n">
								<tr>
									<td>
										成人${n.count}
									</td>
									<td>
										<s:property value="psgName" />
									</td>
									<td>
										<s:property value="psgCertifType" />
									</td>
									<td>
										<s:property value="psgCertifNum" />
									</td>
									<td>
										保险1份&nbsp;
										<span>￥20</span>
									</td>
								</tr>
							</s:iterator>
							<s:iterator value="listChild" status="n">
								<tr>
									<td>
										儿童${n.count}
									</td>
									<td>
										<s:property value="psgName" />
									</td>
									<td>
										<s:property value="psgCertifType" />
									</td>
									<td>
										<s:property value="psgCertifNum" />
									</td>
									<td>
										保险1份&nbsp;
										<span>￥20</span>
									</td>
								</tr>
							</s:iterator>
							<s:iterator value="listInfaint" status="n">
								<tr>
									<td>
										婴儿${n.count}
									</td>
									<td>
										<s:property value="psgName" />
									</td>
									<td>
										<s:property value="psgCertifType" />
									</td>
									<td>
										<s:property value="psgCertifNum" />
									</td>
									<td>
										保险1份&nbsp;
										<span>￥20</span>
									</td>
								</tr>
							</s:iterator>
						</table>

						<!--联系人信息-->
						<table class="order_person_header">
							<tr>
								<td class="font_black12 bold700">
									联系人信息
								</td>
								<td></td>
							</tr>
						</table>
						<table class="order_person_info" cellspacing="0">
							<tr>
								<th>
									联系人姓名
								</th>
								<th>
									联系人手机
								</th>
								<th>
									电子邮件
								</th>
							</tr>
							<tr>
								<td>
									<s:property value="#session.user.userName" />
								</td>
								<td>
									<s:property value="#session.user.userTelephone" />
								</td>
								<td>
									<s:property value="#session.user.userEmail" />
								</td>
							</tr>

						</table>
						<!--航班信息-->
						<table class="order_person_header">
							<tr>
								<td class="font_black12 bold700">
									航班信息
								</td>
								<td></td>
							</tr>
						</table>
						<table class="order_flight" cellpadding="0" cellspacing="0">
							<tr>
								<td class="font_grey12bold td_title">
									航班号
								</td>
								<td class="font_grey12bold td_title">
									航班日期
								</td>
								<td class="font_grey12bold td_title">
									起飞时间
								</td>
								<td class="font_grey12bold td_title">
									到达时间
								</td>
								<td class="font_grey12bold td_title">
									机型
								</td>
								<td class="font_grey12bold td_title">
									飞行里程
								</td>
							</tr>
							<tr>
								<td>
									<input type="hidden" name="fid" value="${fl.fid }">
									<b><s:property value="fl.flightNum" /> </b>
								</td>
								<td>
									<b><s:property value="fl.flDate" /> </b>
								</td>
								<td>
									<b><s:property value="fl.flDepartureTime" /> </b>
								</td>
								<td>
									<b><s:property value="fl.flArrivalTime" /> </b>
								</td>
								<td>
									<b><s:property value="fl.planeModel" /> </b>
								</td>
								<td>
									<b><s:property value="fl.routeDistance" /> </b>
								</td>
							</tr>
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