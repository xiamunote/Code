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

		<!-- jquery -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/jquery-1.4.3.js"></script>


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
									您现在的位置：
									<a href="#" class="black">首页</a> -&gt;
									<a href="#" class="black">会员管理</a> -&gt;
									<a href="#" class="red">我的订单</a>
								</td>
							</tr>
							<tr>
								<td class="line"></td>
							</tr>
						</table>
						<form action="listOrder" method="post">
							<table cellpadding="5" cellspacing="0"
								class="border_red register">
								<tr>
									<td class="bottom_border_red order_leftinfo">
										订单号：
									</td>
									<td class="bottom_border_red">
										<input id="orderNo" name="orderId_input" type="text"
											class="register width98">
									</td>
									<td class="bottom_border_red order_leftinfo">
										订票日期：
									</td>
									<td class="bottom_border_red">

										<!-- 日期控件，请参考http://www.my97.net/ -->
										<input id="flightDate1" name="orderDate1"
											class="register width60" onfocus="WdatePicker()" />
										<img onclick="WdatePicker({el:'flightDate1'})"
											src="${pageContext.request.contextPath}/datepicker/skin/datePicker.gif"
											width="24" height="30" align="absmiddle">
										到
										<!-- 日期控件，请参考http://www.my97.net/ -->
										<input id="flightDate2" name="orderDate2"
											class="register width60" onfocus="WdatePicker()" />
										<img onclick="WdatePicker({el:'flightDate2'})"
											src="${pageContext.request.contextPath}/datepicker/skin/datePicker.gif"
											width="24" height="30" align="absmiddle">
									</td>

								</tr>
								<tr>
									<td class="bottom_border_red order_leftinfo">
										<span class="black">订单状态：</span>
									</td>
									<td class="bottom_border_red">
										<input name="orderState" id="paxName" type="text"
											class="register width60">
									</td>

									<td class="bottom_border_red order_leftinfo">
										城市名称：
									</td>

									<td class="bottom_border_red">

										<input id="orgCity_h" name="fromCity" type="text"
											class="register width98" onclick="showCities(event,'orgCity_h',1);">
										至
										<input id="depCity_h" name="toCity" type="text"
											class="register width98" onclick="showCities(event,'depCity_h',1);">
									</td>
								</tr>

								<tr>
									<td colspan="6" align="center" class="height35">
										<input type="submit" class="ipt" id="Button2" value="查询">
									</td>
								</tr>
							</table>
						</form>
						<table cellpadding="5" cellspacing="0" class="orders">
							<thead>
								<tr>
									<td class="tableHeader"
										onmouseover="this.className='tableHeaderOver';"
										onmouseout="this.className='tableHeader';">
										<span class="columnSeparator">&#160;</span>
										<div class="headerTitle">
											序号
										</div>
									</td>
									<td class="tableHeader"
										onmouseover="this.className='tableHeaderOver';"
										onmouseout="this.className='tableHeader';">
										<span class="columnSeparator">&#160;</span>
										<div class="headerTitle">
											订单号
										</div>
									</td>
									<td class="tableHeader"
										onmouseover="this.className='tableHeaderOver';"
										onmouseout="this.className='tableHeader';">
										<span class="columnSeparator">&#160;</span>
										<div class="headerTitle">
											航班号
										</div>
									</td>
									<td class="tableHeader"
										onmouseover="this.className='tableHeaderOver';"
										onmouseout="this.className='tableHeader';">
										<span class="columnSeparator">&#160;</span>
										<div class="headerTitle">
											航班日期
										</div>
									</td>
									<td class="tableHeader"
										onmouseover="this.className='tableHeaderOver';"
										onmouseout="this.className='tableHeader';">
										<span class="columnSeparator">&#160;</span>
										<div class="headerTitle">
											起飞时间
										</div>
									</td>

									<td class="tableHeader"
										onmouseover="this.className='tableHeaderOver';"
										onmouseout="this.className='tableHeader';">
										<span class="columnSeparator">&#160;</span>
										<div class="headerTitle">
											订单总额
										</div>
									</td>
									<td class="tableHeader"
										onmouseover="this.className='tableHeaderOver';"
										onmouseout="this.className='tableHeader';">
										<span class="columnSeparator">&#160;</span>
										<div class="headerTitle">
											状态
										</div>
									</td>
									<td class="tableHeader"
										onmouseover="this.className='tableHeaderOver';"
										onmouseout="this.className='tableHeader';">
										<span class="columnSeparator">&#160;</span>
										<div class="headerTitle">
											订票时间
										</div>
									</td>
								</tr>
							</thead>
							<tbody>

								<s:iterator value="orderList" status="n">
									<tr class="ordersRow">
										<td>
											${n.count}
										</td>
										<td>
											<a
												href="getOrderdetail?orderId=<s:property value="orderId"/>" target="_blank">
												<s:property value="orderId" /> </a>
										</td>
										<td>
											<s:property value="flightNum" />
										</td>
										<td>
											<s:property value="flDate" />
										</td>
										<td>
											<s:property value="flTime" />
										</td>

										<td>
											￥
											<s:property value="totalPrice" />
										</td>
										<td>
											<s:property value="orderState" />
										</td>
										<td>
											<s:property value="orderDate" />
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
