<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>订单详细信息</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common_color.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/order.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/order_color.css" />

	</head>
	<body class="orderdetail">
		<form name="orderForm" id="orderForm" action="" method="post">
			<table cellpadding="0" cellspacing="0" class="table_orderdetail">
				<tr>
					<td class="table_orderdetail_title">
						订单详细信息
					</td>
				</tr>
				<tr>
					<td align="center">
						<table cellpadding="0" cellspacing="0" class="width97percent">
							<tr>
								<td class="orderdetail_header">
									订单号：
									<s:property value="orderdetail02.orderId" />
									| 订单总金额:
									<s:property value="orderdetail02.orderMoney" />
									| 出票时限:
									<s:property value="orderdetail02.orderDateLimit" />
								</td>
							</tr>
						</table>
						<table class="table_orderdetail_info width97percent"
							cellspacing="0" cellpadding="0">
							<tr>
								<td class="info_title">
									预定日期：
									<s:property value="orderdetail02.orderDate" />
								</td>
								<td class="info_title">
									联系人：
									<s:property value="#session.user.userName" />
								</td>
								<td class="info_title">
									联系电话：
									<s:property value="#session.user.userTelephone" />
								</td>
								<td class="info_title">
									Email：
									<s:property value="#session.user.userEmail" />
								</td>
							</tr>
							<tr>
								<td colspan="5">
									<s:iterator value="orderList" status="n">
										<div class="personInfo">
											第${n.count }位乘客
										</div>
										<table class="left_top_orderpaid" cellpadding="0"
											cellspacing="0">
											<tr>
												<td rowspan="2" class="right_bottom_title">
													旅客
													<br />
													信息
												</td>
												<td class="right_bottom_title_bg">
													姓名
												</td>
												<td class="right_bottom_title_bg">
													证件类型
												</td>
												<td class="right_bottom_title_bg">
													证件号码
												</td>
												<td class="right_bottom_title_bg">
													旅客类型
												</td>
												<td class="right_bottom_title_bg">
													客票类型
												</td>
											</tr>
											<tr>
												<td class="right_bottom_orderpaid">
													<s:property value="psgName" />
												</td>
												<td class="right_bottom_orderpaid">
													<s:property value="psgCertifType" />
												</td>
												<td class="right_bottom_orderpaid">
													<s:property value="psgCertifNum"/>
												</td>
												<td class="right_bottom_orderpaid">
													<s:property value="psgType" />
												</td>
												<td class="right_bottom_orderpaid">
													电子客票
												</td>
											</tr>
										</table>
										<table class="left_top_orderpaid_detail" cellspacing="0"
											cellpadding="0">
											<tr>
												<td rowspan="2" class="right_bottom_title">
													航段
													<br />
													信息
												</td>
												<td class="right_bottom_title_bg">
													航班号
												</td>
												<td class="right_bottom_title_bg">
													日期
												</td>
												<td class="right_bottom_title_bg">
													起飞
												</td>
												<td class="right_bottom_title_bg">
													舱位类别
												</td>
												<td class="right_bottom_title_bg">
													座位号
												</td>
												<td class="right_bottom_title_bg">
													产品名称
												</td>
												<td class="right_bottom_title_bg">
													票号
												</td>
												<td class="right_bottom_title_bg">
													票面价
												</td>
												<td class="right_bottom_title_bg">
													应付票价
												</td>
												<td class="right_bottom_title_bg">
													机建燃油
												</td>
												<td class="right_bottom_title_bg">
													票款总额
												</td>
												<td class="right_bottom_title_bg">
													客票状态
												</td>
											</tr>
											<tr>
												<td class="right_bottom_orderpaid">
													<s:property value="flightNum" />
												</td>
												<td class="right_bottom_orderpaid">
													<s:property value="departureDate" />
												</td>
												<td class="right_bottom_orderpaid">
													<s:property value="departuretime" />
												</td>
												<td class="right_bottom_orderpaid">
													<s:property value="cabinClass" />
												</td>
												<td class="right_bottom_orderpaid">
													座位号
												</td>
												<td class="right_bottom_orderpaid">
													&nbsp;明折明扣&nbsp;
												</td>
												<td class="right_bottom_orderpaid">
													<s:property value="ticketId" />
												</td>
												<td class="right_bottom_orderpaid">
													<s:property value="price" />
												</td>
												<td class="right_bottom_orderpaid">
													<s:property value="ticketPrice" />
												</td>
												<td class="right_bottom_orderpaid">
													<s:property value="tax1Price" />
													/
													<s:property value="tax2Price" />
												</td>
												<td class="right_bottom_orderpaid">
													<s:property value="totalPrice" />
												</td>
												<td class="right_bottom_orderpaid red">
													未出票
												</td>
											</tr>
										</table>
									</s:iterator>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" class="orderpaid_botton_sty" value="关闭窗口"
							onclick="javascript:window.close()" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
