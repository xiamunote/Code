<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>途乐航空[官方网站] – 北京达内科技有限公司</title>
		<link rel="SHORTCUT ICON" href="/images/favicon.ico">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common_color.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/order.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/order_color.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/thickbox.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/jquery-1.3.2.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/thickbox-compressed.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/configuration.js"></script>

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
			function delObjectTag(value){
				var className;
				var index;
				if(value.match("adult_")){
					className=".A";
					index=value.charAt(value.length-1)-'0';
				}else if(value.match("infaint_")){
					className=".I";
					index=value.charAt(value.length-1)-'0';
				}else if(value.match("child_")){
					className=".C";
					index=value.charAt(value.length-1)-'0';
				}
				
				var trs = $(className);
				for(i=index; i<trs.length-1; i++){
					jQuery(jQuery(trs[i]).find("td").get(1)).find("input").val(jQuery(jQuery(trs[i+1]).find("td").get(1)).find("input").val());
					jQuery(jQuery(trs[i]).find("td").get(3)).find("input").val(jQuery(jQuery(trs[i+1]).find("td").get(3)).find("input").val());
					var options1 = jQuery(jQuery(trs[i]).find("td").get(2)).find("select").find("option");
					var options2 = jQuery(jQuery(trs[i+1]).find("td").get(2)).find("select").find("option");
					var select1 = jQuery(jQuery(trs[i+1]).find("td").get(2)).find("select").get(0);
					jQuery(jQuery(trs[i]).find("td").get(2)).find("select").get(0).selectedIndex=jQuery(jQuery(trs[i+1]).find("td").get(2)).find("select").get(0).selectedIndex;
				}	
				jQuery(trs[trs.length-1]).remove();
			}
		
			var objectTag;
			function getObjectTag(value) {
				objectTag = value;
			}
            
            //1 点选登录用户关联的passenger(成人)
            function selectPassenger_adult() {
            	var value = $("input[name='psgAdult']:checked").val();
           	
            	$.ajax({
            		url: "findThePassenger.action",
            		type: "post",
            		dataType: "json",
            		data: "passengerId=" + value,
            		success: function ok(passenger) {
            		    
						var type = passenger.psgCertifType;
						var id_adult = "#id_adult_" + objectTag;
						var name_adult = "#name_adult_" + objectTag;
						var certif_type_adult = "#certif_type_adult_"+ objectTag +" option[value='"+type+"']";
						var certif_num_adult = "#certif_num_adult_" + objectTag;
						$(id_adult).attr("value", passenger.psgId);
						$(name_adult).attr("value" , passenger.psgName);
						$(certif_type_adult).attr("selected","selected");
						$(certif_num_adult).attr("value" , passenger.psgCertifNum);
	           		}
            	});
            	
            	//div消失
            	tb_remove();
            }
            
            //2 点选登录用户关联的passenger(小孩)
            function selectPassenger_child() {
            	var value = $("input[name='psgChild']:checked").val();
            	$.ajax({
            		url: "findThePassenger.action",
            		type: "post",
            		dataType: "json",
            		data: "passengerId=" + value,
            		success: function ok(passenger) {
            			var type = passenger.psgCertifType;
            			var id_child = "#id_child_" + objectTag;
						var name_child = "#name_child_" + objectTag;
						var certif_type_child = "#certif_type_child_"+ objectTag +" option[value='"+type+"']";
						var certif_num_child = "#certif_num_child_" + objectTag;
						$(id_child).attr("value", passenger.psgId);
						$(name_child).attr("value" , passenger.psgName);
						$(certif_type_child).attr("selected","selected");
						$(certif_num_child).attr("value" , passenger.psgCertifNum);
	           		}
            	});
            	
            	//div消失
            	tb_remove();
            }
            
            //3 点选登录用户关联的passenger(婴儿)
            function selectPassenger_infant() {
            	var value = $("input[name='psgInfant']:checked").val();
            	$.ajax({
            		url: "findThePassenger.action",
            		type: "post",
            		dataType: "json",
            		data: "passengerId=" + value,
            		success: function ok(passenger) {
            			var type = passenger.psgCertifType;
            			var id_infant = "#id_infant_" + objectTag;
            			var name_infant = "#name_infant_" + objectTag;
						var certif_type_infant = "#certif_type_infant_"+ objectTag +" option[value='"+type+"']";
						var certif_num_infant = "#certif_num_infant_" + objectTag;
						$(id_infant).attr("value", passenger.psgId);
						$(name_infant).attr("value" , passenger.psgName);
						$(certif_type_infant).attr("selected","selected");
						$(certif_num_infant).attr("value" , passenger.psgCertifNum);
	           		}
            	});
            	
            	//div消失
            	tb_remove();
            }
            
            //检查是否同意电子订票规则
            function promise(){
            	//检查是否非空
            	if(!checkNotNull()){
            		return false;
            	}
            	//检查是否同意了规定
            	var flag = $("#confirmBox").attr("checked");
            	if(flag==false){
            		alert("请阅读并同意《海航国内航班电子客票规定》");
            	}
            	return flag && notNull;
            }
            
            //检查填写的信息是否非空
            function checkNotNull(){
            	var inputs = document.getElementsByTagName("input");
            	for(i=0; i<inputs.length; i++){
            		if(inputs[i].className.match("textbox width")){
						if(inputs[i].value==""){
							alert("请认真填写 \"旅客信息\"");
							return false;
						}
            		}
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
						<form action="submitorder.action" onsubmit="return promise()" method="POST">
							<table>
								<tr>
									<td align="left" class="font_black12">
										<img
											src="${pageContext.request.contextPath}/images/icon_hbcx.gif">
										<a href="#" class="black">航线查询</a> -&gt;
										<a href="#" class="black">选择航班</a> -&gt;
										<a href="#" class="red">填写资料</a>-&gt;
										<a href="#" class="black">支付</a>-&gt;
										<a href="#" class="black">出票</a>
									</td>
								</tr>
								<tr>
									<td class="line"></td>
								</tr>
							</table>
							
							<!--旅客信息-->
							<table class="order_person_header">
								<tr>
									<td class="font_black12 bold700">
										-请输入旅客信息-
									</td>

									<td class="font_orange12 alignRight">
										为确保积分成功，请值机时出示常旅客卡
									</td>
								</tr>
							</table>
							<table id="aaa" class="order_person_info" cellspacing="0">
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
										常用乘机人
									</th>
								</tr>
								<s:iterator begin="1" end="#request.adult" status="n">
								<%--<s:debug></s:debug>--%>
									<tr class="A">
										<td>
											<input type="hidden" value="A" name="listAdult[${n.index}].psgType">
											<input type="hidden" name="listAdult[${n.index}].psgId" id="id_adult_${n.index }">
											成人${n.count}
										</td>
										<td>
											<input id="name_adult_${n.index }" type="text" class="textbox width80"
												name="listAdult[${n.index}].psgName">
											<span class="red">*</span>
										</td>
										<td>
											<select id="certif_type_adult_${n.index}" name="listAdult[${n.index}].psgCertifType">
												<option value="NI">
													身份证
												</option>
												<option value="PP">
													有效护照
												</option>
												<option value="JG">
													军官证
												</option>
												<option value="ID">
													其它
												</option>
											</select>
										</td>
										<td>
											<input id="certif_num_adult_${n.index}" type="text" class="textbox width140"
												name="listAdult[${n.index}].psgCertifNum">
											<span class="red">*</span>
										</td>
										<td>
											<a title="Edit"
												href="#TB_inline?height=200&width=450&inlineId=hidden-box-add_adult&modal=true"
												class="thickbox"
												onclick="getObjectTag(${n.index});">
												<img src="${pageContext.request.contextPath}/images/add.jpg" />
											</a> &nbsp;选择
											<a title="Delete"
												href="javascript:;"
												onclick="delObjectTag('adult_'+${n.index});">
												<img src="${pageContext.request.contextPath}/images/del.jpg" />
											</a> &nbsp;删除
										</td>
									</tr>
								</s:iterator>
								<s:iterator begin="1" end="#request.child" status="n">
									<tr class="C">
										<td>
											<input type="hidden" name="listChild[${n.index}].psgId" id="id_child_${n.index }">
											<input type="hidden" name="listChild[${n.index}].psgType" value="C">
											儿童${n.count}
										</td>
										<td>
											<input id="name_child_${n.index }" type="text" class="textbox width80"
												name="listChild[${n.index}].psgName">
											<span class="red">*</span>
										</td>
										<td>
											<select id="certif_type_child_${n.index }" name="listChild[${n.index}].psgCertifType">
												<option value="NI">
													身份证
												</option>
												<option value="PP">
													有效护照
												</option>
												<option value="ID">
													其它
												</option>
											</select>
										</td>
										<td>
											<input id="certif_num_child_${n.index }" 
											type="text" class="textbox width140"
											name="listChild[${n.index}].psgCertifNum">
											<span class="red">*</span>
										</td>
										<td>
											<a title="Edit"
												href="#TB_inline?height=200&width=450&inlineId=hidden-box-add_child&modal=true"
												class="thickbox"
												onclick="getObjectTag(${n.index });"> <img
													src="${pageContext.request.contextPath}/images/add.jpg" />
											</a> &nbsp;选择
											
											<a title="Delete"
												href="javascript:;"
												onclick="delObjectTag('child_'+${n.index});"> <img
													src="${pageContext.request.contextPath}/images/del.jpg" />
											</a> &nbsp;删除
										</td>
									</tr>
								</s:iterator>
								<s:iterator begin="1" end="#request.infaint" status="n">
									<tr class="I">
										<td>
											<input type="hidden" name="listInfaint[${n.index}].psgId" id="id_infant_${n.index }">
											<input type="hidden" name="listInfaint[${n.index}].psgType"
												value="I">
											婴儿${n.count}
										</td>
										<td>
											<input id="name_infant_${n.index }" type="text" class="textbox width80"
											name="listInfaint[${n.index}].psgName">
											<span class="red">*</span>
										</td>
										<td>
											<select id="certif_type_infant_${n.index}" 
											name="listInfaint[${n.index}].psgCertifType">
												<option value="NI">
													身份证
												</option>
												<option value="PP">
													有效护照
												</option>
												<option value="ID">
													其它
												</option>
											</select>
										</td>
										<td>
											<input id="certif_num_infant_${n.index }" 
											type="text" class="textbox width140"
											name="listInfaint[${n.index}].psgCertifNum">
											<span class="red">*</span>
										</td>
										<td>
											<a title="Edit"
												href="#TB_inline?height=200&width=450&inlineId=hidden-box-add_infaint&modal=true"
												class="thickbox"
												onclick="getObjectTag(${n.index });"> <img
													src="${pageContext.request.contextPath}/images/add.jpg" />
											</a> &nbsp;选择
											<a title="Delete"
												href="javascript:;"
												onclick="delObjectTag('infaint_'+${n.index });"> <img
													src="${pageContext.request.contextPath}/images/del.jpg" />
											</a> &nbsp;删除
										</td>
									</tr>
								</s:iterator>
							</table>

							<!--航班信息-->
							<table class="order_person_header">
								<tr>
									<td class="font_black12 bold700">
										-您所在机票的航班信息-
									</td>
									<td class="font_orange12 alignRight">
										&nbsp;
									</td>
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
									<td class="font_grey12bold td_title">
										最低票价
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
									<td>
										<b>￥<s:property value="fl.fullPrice*fl.currentDiscount" />
										</b>
									</td>
								</tr>
							</table>

							<!--票价信息-->
							<table class="order_person_header">
								<tr>
									<td class="font_black12 bold700">
										-票价信息-
									</td>
									<td class="font_orange12 alignRight">
										货币类型 人民币 CNY
									</td>
								</tr>
							</table>
							<table cellpadding="5" cellspacing="0" class="order_flight">
								<tr>
									<th>
										乘客类型
									</th>
									<th>
										人数
									</th>
									<th>
										产品
									</th>
									<th>
										应付价
									</th>
									<th>
										燃油税
									</th>
									<th>
										机场税
									</th>
								</tr>

								<!-- 订单总价分3个计算方式，
								头等舱的公布运价为基准票价×1.8，
								公务舱的公布运价为基准票价×1.5，
								经济舱的公布运价为基准票价×1.0 -->
								<s:if test='"经济舱".equals(cabinClassName)'>

									<!-- 1 如果成人人数(adult)大于等于1时，显示如下表格 -->
									<s:if test="adult>=1">
										<tr class="height25">
											<td>
												成人
											</td>
											<td>
												<s:property value="adult" />
											</td>
											<td title="舱位信息">
												<s:property value="cabinClassName" />
												<input value="${cabinClassName }" name="cabinClass"
													type="hidden">
											</td>
											<td>
												￥
												<s:property value="adult" />
												*
												<s:property value="fl.fullPrice*fl.currentDiscount" />
											</td>
											<td>
												￥
												<s:property value="adult" />
												*
												<s:property value="fl.tax1Price" />
											</td>
											<td>
												￥
												<s:property value="adult" />
												*
												<s:property value="fl.tax2Price" />
											</td>
										</tr>
									</s:if>

									<!-- 2 如果小孩(child)人数大于等于1，显示如下表格 -->
									<s:if test="child>=1">
										<tr class="height25">
											<td>
												小孩
											</td>
											<td>
												<s:property value="child" />
											</td>
											<td title="舱位信息">
												<s:property value="cabinClassName" />

											</td>
											<td>
												<!-- 乘客类型折扣（Passenger Discount）：
												不同乘客类型在基准票价基础上的价格系数，
												成人为1.0，儿童为0.5，婴儿为0.1 -->
												￥
												<s:property value="child" />
												*
												<s:property value="fl.fullPrice*fl.currentDiscount" />
												*0.5
											</td>
											<td>
												<!-- 燃油税：儿童票为0.5，婴儿票免收燃油税 -->
												￥
												<s:property value="child" />
												*
												<s:property value="fl.tax1Price" />
												* 0.5
											</td>
											<td>
												<!-- 机场建设费：儿童和婴儿都不收取机场建设费 -->
												￥0
											</td>
										</tr>
									</s:if>

									<!-- 3 如果婴儿(child)人数大于等于1，显示如下表格 -->
									<s:if test="infaint>=1">
										<tr class="height25">
											<td>
												婴儿
											</td>
											<td>
												<s:property value="infaint" />
											</td>
											<td title="舱位信息">
												<s:property value="cabinClassName" />

											</td>
											<td>
												<!-- 乘客类型折扣（Passenger Discount）：
												不同乘客类型在基准票价基础上的价格系数，
												成人为1.0，儿童为0.5，婴儿为0.1 -->
												￥
												<s:property value="infaint" />
												*
												<s:property value="fl.fullPrice*fl.currentDiscount" />
												*0.1
											</td>
											<td>
												<!-- 燃油税：儿童票为0.5，婴儿票免收燃油税 -->
												￥0

											</td>
											<td>
												<!-- 燃油税：儿童票为0.5，婴儿票免收燃油税 -->
												￥0
											</td>
										</tr>
									</s:if>

									<tr>
										<td class="order_flight_footer"></td>
										<td colspan="7" align="right"
											class="order_flight_footer bold700">
											订单总价：￥
											<s:property
												value="(fl.tax1Price + fl.tax2Price + fl.fullPrice*fl.currentDiscount) * adult 
											+ (fl.tax1Price + fl.tax2Price + fl.fullPrice*fl.currentDiscount) * child
											+ (fl.tax1Price + fl.tax2Price + fl.fullPrice*fl.currentDiscount) * infaint " />
											元

											<input name="orderMoney" value="<s:property
												value="(fl.tax1Price + fl.tax2Price + fl.fullPrice*fl.currentDiscount) * adult 
											+ (fl.tax1Price + fl.tax2Price + fl.fullPrice*fl.currentDiscount) * child
											+ (fl.tax1Price + fl.tax2Price + fl.fullPrice*fl.currentDiscount) * infaint " />" type="hidden">
										</td>
									</tr>
								</s:if>

								<s:if test='"公务舱".equals(cabinClassName)'>

									<!-- 1 如果成人人数(adult)大于等于1时，显示如下表格 -->
									<s:if test="adult>=1">
										<tr class="height25">
											<td>
												成人
											</td>
											<td>
												<s:property value="adult" />
											</td>
											<td title="舱位信息">
												<s:property value="cabinClassName" />
												<input value="${cabinClassName }" name="cabinClass"
													type="hidden">
											</td>
											<td>
												￥
												<s:property value="adult" />
												*
												<s:property value="fl.fullPrice*fl.currentDiscount" />
												* 1.5
											</td>
											<td>
												￥
												<s:property value="adult" />
												*
												<s:property value="fl.tax1Price" />
											</td>
											<td>
												￥
												<s:property value="adult" />
												*
												<s:property value="fl.tax2Price" />
											</td>
										</tr>
									</s:if>

									<!-- 2 如果小孩(child)人数大于等于1，显示如下表格 -->
									<s:if test="child>=1">
										<tr class="height25">
											<td>
												小孩
											</td>
											<td>
												<s:property value="child" />
											</td>
											<td title="舱位信息">
												<s:property value="cabinClassName" />

											</td>
											<td>
												<!-- 公务舱票价为经济舱的1.5倍 -->
												<!-- 乘客类型折扣（Passenger Discount）：
												不同乘客类型在基准票价基础上的价格系数，
												成人为1.0，儿童为0.5，婴儿为0.1 -->
												￥
												<s:property value="child" />
												*
												<s:property value="fl.fullPrice*fl.currentDiscount" />
												* 1.5 * 0.5
											</td>
											<td>
												<!-- 燃油税：儿童票为0.5，婴儿票免收燃油税 -->
												￥
												<s:property value="child" />
												*
												<s:property value="fl.tax1Price" />
												* 0.5
											</td>
											<td>
												<!-- 机场建设费：儿童和婴儿都不收取机场建设费 -->
												￥ 0
											</td>
										</tr>
									</s:if>

									<!-- 3 如果婴儿(child)人数大于等于1，显示如下表格 -->
									<s:if test="infaint>=1">
										<tr class="height25">
											<td>
												婴儿
											</td>
											<td>
												<s:property value="infaint" />
											</td>
											<td title="舱位信息">
												<s:property value="cabinClassName" />

											</td>
											<td>
												<!-- 公务舱票价为经济舱的1.5倍 -->
												<!-- 乘客类型折扣（Passenger Discount）：
												不同乘客类型在基准票价基础上的价格系数，
												成人为1.0，儿童为0.5，婴儿为0.1 -->
												￥
												<s:property value="infaint" />
												*
												<s:property value="fl.fullPrice*fl.currentDiscount" />
												* 1.5 * 0.1
											</td>
											<td>
												<!-- 燃油税：儿童票为0.5，婴儿票免收燃油税 -->
												￥0
											</td>
											<td>
												<!-- 机场建设费：儿童和婴儿都不收取机场建设费 -->
												￥0
											</td>
										</tr>
									</s:if>

									<tr>
										<td class="order_flight_footer"></td>
										<td colspan="7" align="right"
											class="order_flight_footer bold700">
											订单总价：￥
											<s:property
												value="(fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.5) * adult 
											+ (fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.5) * child
											+ (fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.5) * infaint  " />
											元

											<input name="orderMoney"
												value="${ (fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.8) * adult 
											+ (fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.8) * child
											+ (fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.8) * infaint}"
												type="hidden">
										</td>
									</tr>
								</s:if>

								<s:if test='"头等舱".equals(cabinClassName)'>

									<!-- 1 如果成人人数(adult)大于等于1时，显示如下表格 -->
									<s:if test="adult>=1">
										<tr class="height25">
											<td>
												成人
											</td>
											<td>
												<s:property value="adult" />
											</td>
											<td title="舱位信息">
												<s:property value="cabinClassName" />
												<input value="${cabinClassName }" name="cabinClass"
													type="hidden">
											</td>
											<td>
												<!-- 公务舱票价为经济舱的1.8倍 -->
												￥
												<s:property value="adult" />
												*
												<s:property value="fl.fullPrice*fl.currentDiscount" />
												* 1.8
											</td>
											<td>
												￥
												<s:property value="adult" />
												*
												<s:property value="fl.tax1Price" />
											</td>
											<td>
												￥
												<s:property value="adult" />
												*
												<s:property value="fl.tax2Price" />
											</td>
										</tr>
									</s:if>

									<!-- 2 如果小孩(child)人数大于等于1，显示如下表格 -->
									<s:if test="child>=1">
										<tr class="height25">
											<td>
												小孩
											</td>
											<td>
												<s:property value="child" />
											</td>
											<td title="舱位信息">
												<s:property value="cabinClassName" />

											</td>
											<td>
												<!-- 乘客类型折扣（Passenger Discount）：
												不同乘客类型在基准票价基础上的价格系数，
												成人为1.0，儿童为0.5，婴儿为0.1 -->
												￥
												<s:property value="child" />
												*
												<s:property value="fl.fullPrice*fl.currentDiscount" />
												* 1.8 * 0.5
											</td>
											<td>
												<!-- 燃油税：儿童票为0.5，婴儿票免收燃油税 -->
												￥
												<s:property value="child" />
												*
												<s:property value="fl.tax1Price" />
												* 0.5
											</td>
											<td>
												<!-- 机场建设费:儿童和婴儿都不收取机场建设费 -->
												￥0
											</td>
										</tr>
									</s:if>

									<!-- 3 如果婴儿(child)人数大于等于1，显示如下表格 -->
									<s:if test="infaint>=1">
										<tr class="height25">
											<td>
												婴儿
											</td>
											<td>
												<s:property value="infaint" />
											</td>
											<td title="舱位信息">
												<s:property value="cabinClassName" />

											</td>
											<td>
												<!-- 乘客类型折扣（Passenger Discount）：
												不同乘客类型在基准票价基础上的价格系数，
												成人为1.0，儿童为0.5，婴儿为0.1 -->
												￥
												<s:property value="infaint" />
												*
												<s:property value="fl.fullPrice*fl.currentDiscount" />
												* 1.8 * 0.1
											</td>
											<td>
												<!-- 燃油税：儿童票为0.5，婴儿票免收燃油税 -->
												￥0

											</td>
											<td>
												<!-- 机场建设费:儿童和婴儿都不收取机场建设费 -->
												￥0
											</td>
										</tr>
									</s:if>

									<tr>
										<td class="order_flight_footer"></td>
										<td colspan="7" align="right"
											class="order_flight_footer bold700">
											订单总价：￥
											<s:property
												value="(fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.8) * adult 
											+ (fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.8) * child
											+ (fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.8) * infaint  " />
											元

											<input name="orderMoney"
												value="${(fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.8) * adult 
													+ (fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.8) * child
													+ (fl.tax1Price + fl.tax2Price + (fl.fullPrice*fl.currentDiscount)* 1.8) * infaint }"
												type="hidden">



										</td>
									</tr>
								</s:if>

							</table>

							<!--操作提示和按钮-->
							<table class="button_list">
								<tr>
									<td class="paddingLeft">
										<input type="checkbox" name="confirmBox" onclick="promise()" id="confirmBox"
											value="checkbox">
										<span class="font_black12">已阅读并接受</span>
										<a href="#" target="_self"> <span class="red">《海航国内航班电子客票规定》
										</span> </a>
									</td>
								</tr>
								<tr>
									<td class="td_bottom">
										<!-- 使用JS脚本返回上一个页面 -->
										<input type="button" class="ipt" id="Button1" value="上一步"
											onclick="history.go(-1);">
										<input type="submit" class="ipt" id="Button2" value="下一步">
									</td>
								</tr>
							</table>

							<!--说明-->
							<table class="order_person_header">
								<tr>
									<td align="left" class="font_word12hui">
										您在填写信息时请留意：
										<br />
										1、标注
										<span class="red">* </span> 的项目为必填项，有关资料请如实填写并确保 与有效证件内容相符。
										<br />
										2、“旅客姓名”只支持简体中文或英文姓名输入。
										<br />
										3、当输入英文姓名时，请务必在姓和名之间 添加/作为姓名分隔符号， 如：Owen/Michell
										<br />
										4、英文姓名中只能出现一个姓名分隔符号； 若证件姓名中包含其他符号（例如，等）时，请一律省略。
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>

			<!-- 底部版权信息开始-->
			<div class="clear"></div>
			<div id="footer">
				<div id="copyright">
					<br>
					版权所有2007-2010北京首都航空有限公司海南易建科技股份有限公司
					<a href="#">mail to webmaster</a>&nbsp;&nbsp;
					<a href="#">隐私条款</a>
					<a href="#">免责声明</a>
					<br>
					<a href="#">琼icp备08100707号</a>
				</div>
			</div>
		</div>

		<div id="spring" class="backgroundimg"></div>

		<!--添加乘机人弹出框的div(成人)-->
		<div id="hidden-box-add_adult" class="hidden-box" style="display: none;">
				<div class="popup-box">
					<div class="popup-box-header">
						<span>常用乘机人(成人)</span>
						<a href="#" onclick="javascript:tb_remove();"> 
						<img src="${pageContext.request.contextPath}/images/cross_grey_small.png" />
						</a>
					</div>
					<div class="popup-box-content height100">
						<table>
							<s:iterator value="psgAdult">
								<tr>
									<td>
										<input value="<s:property value="psgId"/>" 
											type="radio"
											name="psgAdult" />
										<label for="rad1">
											<s:property value="psgName" />
										</label>
									</td>
								</tr>

							</s:iterator>

						</table>
					</div>
					<div class="popup-box-footer">
						<input class="ipt" type="button" value="选择"
							onclick="selectPassenger_adult()" />
						<input class="ipt" type="button" value="取消"
							onclick="javascript:tb_remove();" />
					</div>
				</div>
		</div>
		
		<!--添加乘机人弹出框的div(小孩)-->
		<div id="hidden-box-add_child" class="hidden-box" style="display: none;">
			<form>
				<div class="popup-box">
					<div class="popup-box-header">
						<span>常用乘机人(小孩)</span>
						<a href="#" onclick="javascript:tb_remove();"> <img
								src="${pageContext.request.contextPath}/images/cross_grey_small.png" />
						</a>
					</div>
					<div class="popup-box-content height100">
						<table>
							
							<s:iterator value="psgChild" status="n">

								<tr>
									<td>
										<input value="<s:property value="psgId"/>" 
											type="radio"
											name="psgChild" />
										<label for="rad1">
											<s:property value="psgName" />
										</label>
									</td>
								</tr>

							</s:iterator>

						</table>
					</div>
					<div class="popup-box-footer">
						<input class="ipt" type="button" value="选择"
							onclick="selectPassenger_child()" />
						<input class="ipt" type="button" value="取消"
							onclick="javascript:tb_remove();" />
					</div>
				</div>
			</form>
		</div>
		
		<!--添加乘机人弹出框的div(婴儿)-->
		<div id="hidden-box-add_infaint" class="hidden-box" style="display: none;">
			<form>
				<div class="popup-box">
					<div class="popup-box-header">
						<span>常用乘机人(婴儿)</span>
						<a href="#" onclick="javascript:tb_remove();"> <img
								src="${pageContext.request.contextPath}/images/cross_grey_small.png" />
						</a>
					</div>
					<div class="popup-box-content height100">
						<table>

							<s:iterator value="psgInfant" status="n">
								<tr>
									<td>
										<input value="<s:property value="psgId"/>" 
											type="radio"
											name="psgInfant" />
										<label for="rad1">
											<s:property value="psgName" />
										</label>
									</td>
								</tr>

							</s:iterator>

						</table>
					</div>
					<div class="popup-box-footer">
						<input class="ipt" type="button" value="选择"
							onclick="selectPassenger_infant()" />
						<input class="ipt" type="button" value="取消"
							onclick="javascript:tb_remove();" />
					</div>
				</div>
				<div style="color:red">
		<s:fielderror />
		</div>
			</form>
		</div>
		
	</body>
</html>