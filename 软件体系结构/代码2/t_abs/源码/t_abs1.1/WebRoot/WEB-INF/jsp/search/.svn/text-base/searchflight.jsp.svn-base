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

		<!-- 城市控件 -->
		<!--
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity_color.css">
  		-->

		<script language="javascript">
        	
        	//如果没有座位，则不能提交
           $(function(){
           	  $("#Button2").click(function(){

           	  	var val=$('input:radio[name="buy"]:checked')
           	  		.parent().parent().find(".seatsRemain").text();
           	  	
				if(val.trim() == '无'){
					alert("无座位");
					return false;
				}
            	
            	return true;
           	  });
           });

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
						<table>
							<tr>
								<td align="left" class="font_black12">
									<img
										src="${pageContext.request.contextPath}/images/icon_hbcx.gif">
									<a href="#" class="black">航线查询</a> -&gt;
									<a href="#" class="red">选择航班</a> -&gt;
									<a href="#" class="black">填写资料</a>-&gt;
									<a href="#" class="black">支付</a>-&gt;
									<a href="#" class="black">出票</a>
								</td>
							</tr>
							<tr>
								<td class="line"></td>
							</tr>
						</table>
						<br />
						<!--查询结果的表头-->
						<form action="getPreorder.action" method="post">
							<table class="searchFlight">
								<tr>
									<td class="bold700">
										直飞航班&gt;&gt;
									</td>
									<td class="td_bottom_padd1">
										<span class="red">自</span>
										<span class="font_black14"> <s:property
												value="startAirport" /> </span>
										<span class="red">至</span>
										<span class="font_black14"><s:property
												value="endAirport" /> </span>
									</td>
									<td>
										<span id="fltDate"><s:property value="startDate" /> </span>
									</td>
								</tr>
								<tr>
									<td colspan="3" class="search_dateorder">
										<!-- 
										<a href="#">8月24日</a> |
										<a href="#">8月25日</a> |
										<a href="#">8月26日</a> |
										<a href="#">8月27日</a> |
										<a href="#">8月28日</a> |
										<a href="#">8月29日</a> |
										<a href="#">8月30日</a> |
										<input name="newFlightDay" type="text" class="textbox width60"
											id="newFlightDay">
										<img src="${pageContext.request.contextPath}/images/data.gif"
											name="dateLinkNewflight" id="dateLinkNewflight">
										 -->
										<a></a>
									</td>
								</tr>
							</table>
							<!--承运1-->
							<s:iterator value="flight01_list">
								<table cellpadding="0" cellspacing="0" class="tickets">
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

										<td class="td_bg border_grey_bottom">
											<div class="aclogo_dxh">
												${flightNum }
											</div>
										</td>
										<td class="td_bg border_grey_bottom">
											<span class="font_black12">${flDate}</span>
										</td>
										<td class="td_bg border_grey_bottom">
											${flDepartureTime }
										</td>
										<td class="td_bg border_grey_bottom">
											${flArrivalTime }
										</td>
										<td class="td_bg border_grey_bottom">
											${planeModel }
										</td>
										<td class="td_bg border_grey_bottom">
											${routeDistance }KM
										</td>
									</tr>
									<tr>
										<td class="td_bg font_grey12bold">
											产品名称
										</td>
										<td class="td_bg font_grey12bold">
											剩余座位
										</td>
										<td class="td_bg font_grey12bold">
											票价
										</td>
										<td class="td_bg font_grey12bold">
											优惠价
										</td>
										<td class="td_bg font_grey12bold">
											机建燃油费
										</td>

										<td class="td_bg font_grey12bold">
											选择
										</td>
									</tr>
									<tr class="trout1" onmouseover="this.className='trout1_hover';"
										onmouseout="this.className='trout1';">
										<td>
											<table>
												<tr>
													<td class="width50percent">
														头等舱
													</td>
												</tr>
											</table>
										</td>
										<td  class="seatsRemain">
											<s:if test="fseatsRemain<=0"> 无 </s:if>
											<s:else> ${ fseatsRemain} </s:else>
										</td>
										<td>
											<del>
												${fullPrice*1.8 }
											</del>
										</td>
										<td>
											<div class="font_red14boldcandara">
												${fullPrice*currentDiscount*1.8 }
											</div>
										</td>
										<td>
											${tax1Price }+${tax2Price }
										</td>
										<td>
											<input type="radio" name="buy" value="${fid }_F">
										</td>
									</tr>

									<tr>
										<td colspan="7" class="dotbottom"></td>
									</tr>
									<tr class="trout1" onmouseover="this.className='trout1_hover';"
										onmouseout="this.className='trout1';">
										<td>
											<table>
												<tr>
													<td class="width50percent">
														公务舱
													</td>
												</tr>
											</table>
										</td>
										<td class="seatsRemain">
											<s:if test="bseatsRemain<=0"> 无 </s:if>
											<s:else> ${ bseatsRemain} </s:else>
										</td>
										<td>
											<del>
												${fullPrice*1.5 }
											</del>
										</td>
										<td>
											<div class="font_red14boldcandara">
												${fullPrice*currentDiscount*1.5 }
											</div>
										</td>
										<td>
											${tax1Price }+${tax2Price }
										</td>

										<td>
											<input type="radio" name="buy" value="${fid }_B">
										</td>
									</tr>
									<tr>
										<td colspan="7" class="dotbottom"></td>
									</tr>
									<tr class="trout1" onmouseover="this.className='trout1_hover';"
										onmouseout="this.className='trout1';">
										<td>
											<table>
												<tr>
													<td class="width50percent">
														经济舱
													</td>
												</tr>
											</table>
										</td>
										<td class="seatsRemain">
											<s:if test="eseatsRemain<=0"> 无 </s:if>
											<s:else> ${ eseatsRemain} </s:else>
										</td>
										<td>
											<del>
												${fullPrice }
											</del>
										</td>
										<td>
											<div class="font_red14boldcandara">
												${fullPrice*currentDiscount }
											</div>
										</td>
										<td>
											${tax1Price }+${tax2Price }
										</td>

										<td>
											<input type="radio" name="buy" value="${fid }_E"
												checked="checked">
										</td>
									</tr>
									<tr>
										<td colspan="7" class="dotbottom">
										</td>
									</tr>
								</table>
							</s:iterator>

							<s:if test="!flight01_list.isEmpty()">
								<!--选择旅客人数-->
								<table class="searchFlight select_pepole" cellpadding="0"
									cellspacing="0">
									<tr>
										<td
											class="select_pepole_header font_black12bold border_rightbottom">
											请选择旅客人数：
										</td>
									</tr>
									<tr>
										<td class="border_rightbottom height40">
											成人
											<select name="adult" id="adult">
												<option value=1 selected="selected">
													1
												</option>
												<option value=2>
													2
												</option>
												<option value=3>
													3
												</option>
												<option value=4>
													4
												</option>
												<option value=5>
													5
												</option>
												<option value=6>
													6
												</option>
												<option value=7>
													7
												</option>
												<option value=8>
													8
												</option>
												<option value=9>
													9
												</option>
											</select>
											儿童
											<select name="child" id="child">
												<option value=0 selected="selected">
													0
												</option>
												<option value=1>
													1
												</option>
												<option value=2>
													2
												</option>
												<option value=3>
													3
												</option>
												<option value=4>
													4
												</option>
												<option value=5>
													5
												</option>
											</select>
											婴儿
											<select name="infaint" id="infaint">
												<option value=0 selected="selected">
													0
												</option>
												<option value=1>
													1
												</option>
												<option value=2>
													2
												</option>
												<option value=3>
													3
												</option>
												<option value=4>
													4
												</option>
												<option value=5>
													5
												</option>
											</select>
										</td>
									</tr>
									<tr>
										<td class="border_rightbottom">
											&nbsp;儿童指年龄满两周岁（含）但不满十二周岁的人。儿童旅客需持有户口簿或其他有效身份证件办理乘机手续。无成人陪伴儿童不支持网站购票，请旅客前往当地海航直属售票处购票。
											<br>
											&nbsp;婴儿是指年龄在两周（含）以上但不满两周岁的人。婴儿旅客需持有户口簿、出生证或其他有效身份证件办理乘机手续。
										</td>
									</tr>
								</table>
								<table class="button_list">
									<tr>
										<td>
											<input type="submit" class="ipt" id="Button2" value="下一步">
										</td>
									</tr>
								</table>
							</s:if>
							<s:else>
								<hr />
								没有航班信息
							</s:else>
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