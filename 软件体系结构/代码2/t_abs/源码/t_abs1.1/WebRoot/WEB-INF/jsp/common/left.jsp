<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!-- 引入日期控件 -->
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/datepicker/WdatePicker.js"></script>

<!-- 引入城市控件css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/coolcity.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/coolcity_color.css" />

<script type="text/javascript" 
	src="${pageContext.request.contextPath}/scripts/city.js"></script>

<!-- 左侧机票预订与会员登录-->
<div id="leftside">
	<!-- 机票预订-->
	<div id="booking">
		<form id="searchflight" action="list.action" method="post">
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td class="height27">
									出&nbsp;&nbsp;发&nbsp;&nbsp;地
								</td>
								<td>
									<input id="orgCity_m" name="startAirport"
										class="booking_ipttext_131"
										onclick="showCities(event,'orgCity_m',1);"/>
								</td>
							</tr>
							<tr>
								<td class="height27">
									目&nbsp;&nbsp;的&nbsp;&nbsp;地
								</td>
								<td>
									<input id="depcity_m" name="endAirport"
										class="booking_ipttext_131"
										onclick="showCities(event,'depcity_m',1);"/>
								</td>
							</tr>
							
							<tr>
								<td class="height27">
									出发时间
								</td>
								<td>
									<!-- 日期控件，请参考http://www.my97.net/ -->
									<input id="d12" name="startDate" onfocus="WdatePicker()"
										class="booking_ipttext_131" />

								</td>
							</tr>
							<tr>
							</tr>
							<tr>
								<td class="height30" colspan="2">
									<input name="inpNext" type="submit" class="search" id="inpNext"
										value="" onclick="return checkNull();">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

			<!--城市选择-->
			<div id="cool_address">
				<div id="address_warp">
					<div id="address_message">
						<div style="float:left;width: 150px;text-align: left">
							城市选择列表
						</div>
						<div style="float:right;width: 30px">
							<a href="#" onclick="hiddenCities()">
								<img src="images/window_close.jpg" >
							</a>
						</div>
					</div>
					<div style="clear:both;"></div>
					<div id="address_list"></div>
					<div class="address_pagebreak" id="address_p">
						<a id="address_arrowl" href="#" name="p">&lt;-</a>
						<a href="#" name="page_num">1</a>
						<a href="#" name="page_num">2</a>
						<a href="#" name="page_num">3</a>
						<a href="#" name="page_num">4</a>
						<a href="#" name="page_num">5</a>
						<a href="#" name="page_num">6</a>
						<a href="#" name="page_num">7</a>
						<a href="#" name="page_num">8</a>
						<a href="#" name="page_num">9</a>
						<a href="#" name="page_num">10</a>
						<a href="#" name="page_num">11</a>
						<a href="#" name="page_num">12</a>
						<a id="address_arrowr" href="#" name="n">-&gt;</a>
					</div>
				</div>
			</div>
		</form>
	</div>

	<!--会员登录-->
	<s:if test="#session['user']!=null">
		<div id="subuserlogin">
			<h1>
				用户信息
			</h1>
			<table class="loginbox">
				<tr>
					<td colspan="2" class="userinfo_header"></td>
				</tr>
				<tr>
					<td class="userinfo">
						<!-- 调用查询用户信息的action -->
						<a href="userInfo.action"> - 用户信息</a>
					</td>
					<td class="userinfo">
						<a href="myordersPage.action"> - 我的订单</a>
					</td>
				</tr>
				<tr>
					<td class="userinfo">
						<a href="updateUserForm.action"> - 修改资料</a>
					</td>
					<td class="userinfo">
						<a href="passwordModifyPage.action"> - 修改密码</a>
					</td>
				</tr>
				<tr>
					<td class="userinfo" colspan="2">
						<a href="passengerList.action"> - 常用乘机人</a>
					</td>
				</tr>
			</table>
		</div>
	</s:if>
</div>