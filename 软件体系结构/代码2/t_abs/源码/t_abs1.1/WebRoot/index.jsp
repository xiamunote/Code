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
			href="${pageContext.request.contextPath}/css/index.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/index_color.css">


		<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/jquery-1.4.3.js">
        </script>

		<!-- 查询城市需要的css样式 -->
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity_color.css">

		<!-- 引入日期控件 -->
		<script language="javascript" type="text/javascript"
			src="${pageContext.request.contextPath}/datepicker/WdatePicker.js"></script>
		<script language="javascript" type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/city.js"></script>


		<script language="javascript">
            function ShowDiv(index) {
                var tabID = "tbc_0" + index;
                var divs = document.getElementById("divTabDivs").childNodes;
                for(var i=0;i<divs.length;i++) {
                    var divChild = divs[i];
                    if (divChild.nodeName == "DIV") {
                        if (divChild.id == tabID)
                            divChild.style.display = "block";
                        else
                            divChild.style.display = "none";
                    }
                }
                //修改页签的样式
                var tabs = 
                	document.getElementById("tb_").getElementsByTagName("li");
                for (var i = 0; i < tabs.length; i++) {
                    tabs[i].className = "normaltab";
                }
                document.getElementById(
                	"tb_" + index.toString()).className = "hovertab";
            }

            
           //加载推荐航班
           $(function(){
           		$("#lineContent").load("hotFlights.action");
           });
 
           //加载最新资讯
           $(function(){
           		$("#smsg").load("newFlights.action");
           });
           
          
        </script>
	</head>
	<body>
		<div id="page">
			<!-- 头部-->
			<!-- 引入头部文件 -->
			<s:include value="/WEB-INF/jsp/common/header.jsp">
			</s:include>

			<!-- box1：机票预订及FLASH广告横栏-->
			<div id="box1">
				<!--查询航班-->
				<div id="airticketsbooking">
					<div class="w936">
						<div id="tb_" class="indextab">
							<ul>
								<li id="tb_1" class="hovertab" onclick="ShowDiv(1);">
									<a href="#">查询航班</a>
								</li>
								<li id="tb_2" class="normaltab">
									<a href="list01.action"> 航班动态查询</a>
								</li>
								<li id="tb_3" class="normaltab" onclick="ShowDiv(3);">
									<a href="#">客票验真</a>
								</li>
							</ul>
						</div>
						<div class="ctt" id="divTabDivs">
							<div id="tbc_01" class="displaytab">
								<form id="searchflight" method="post" action="list.action">
									<table>
										<tbody>
										
											<tr>
												<td>
													<table>
														<tr>
															<td class="bookingdetail">
																出&nbsp;&nbsp;发&nbsp;&nbsp;地
															</TD>
															<td colSpan=3>
																<input id="orgCity_m" name="startAirport"
																	class="ipttext"
																	onclick="showCities(event,'orgCity_m',1);">
															</td>
														</tr>
														<tr>
															<td class="bookingdetail">
																目&nbsp;&nbsp;的&nbsp;&nbsp;地
															</td>
															<td colSpan=3>
																<input id="depcity_m" name="endAirport" class="ipttext"
																	onclick="showCities(event,'depcity_m',1);">
															</td>
														</tr>
														<tr>
															<td class="bookingdetail">
																出发时间
															</td>
															<td>
																<!-- 日期控件，请参考http://www.my97.net/ -->
																<input id="d12" name="startDate" onfocus="WdatePicker()" />
																<img onclick="WdatePicker({el:'d12'})"
																	src="${pageContext.request.contextPath}/datepicker/skin/datePicker.gif"
																	width="24" height="30" align="absmiddle">
															</td>
															<td></td>
															<td></td>
														</tr>
														<tr>

														</tr>
														<tr>
															<td class="bookingdetail" colSpan="4">
																<input id="inpNext" class="search" type="submit"
																	name="inpNext" value=" " onclick="return checkNull();"/>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									
									<!--城市选择-->
									<div id="cool_address" >
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
							<div id="tbc_03" class="undisplaytab kpyz">
								<h1>
									客票验真
								</H1>
								<p>
									&nbsp;
								</p>
								<P>
									首都航空所有机票信息您可登录中国民航信息网络—
									<span class="sty0417">信天游网站</span> 在页面右侧验真栏输入旅客姓名及客票号码进行验真。
									机票未使用一年内可查询，已使用机票三个月内可查验。 确认要验证请
									<span class="normaltab"> <a class="st2"
										href="www.tarena.com" target="_self">点击这里</a> </span>我们将为您跳转至信天游网站
								</p>
								<p>
									<img
										src="${pageContext.request.contextPath}/images/kepiaoyanzhen.jpg"
										width="117" height="66">
								</p>
							</div>
						</div>
					</div>
				</div>
				<!--Flash广告-->
				<div id="flashbox">
					<div id="idContainer2" class="container">
						<ul id="idNum" class="flashnumber">
							<li class="on">
								1
							</li>
							<li>
								2
							</li>
							<li>
								3
							</li>
							<li>
								4
							</li>
							<li>
								5
							</li>
						</ul>
					</div>
				</div>
				<!--广告图片开始-->
				<div id="adpic">
					<ul>
						<li class="pic1">
							<a href="#" target="_self">手机客户端</a>
						</li>
						<li class="pic2">
							<a title="酒店预订" href="#" target="_self">酒店预订</a>
						</li>
						<li class="pic3">
							<a title="订票热线" href="#">订票热线</a>
						</li>
					</ul>
				</div>
			</div>
			<!-- box2：推荐航线-最新资讯横栏-->
			<div id="box2">
				<!--推荐航线-->
				<div id="recommendedRoute">
					<div id="recommendedRoutebox">
						<div class="tilRed">
							<div>
								<a href="#" target="_self"> <img title="更多航线..."
									src="${pageContext.request.contextPath}/images/more.gif">
								</a>
							</div>
							推荐航线
						</div>
						<div id="__AD_recommendedRoute">
							<div id="lineContent">
								<img
									src="${pageContext.request.contextPath}/images/indicator.gif">
								数据加载中……
							</div>
						</div>
					</div>
				</div>
				<!--最新资讯-->
				<DIV id="news">
					<DIV class="newstil">
						<DIV>
							<A href="newsPage.action" target="_self"> <IMG
									title="更多资讯..."
									src="${pageContext.request.contextPath}/images/more.gif">
							</A>
						</DIV>
						最新资讯
					</DIV>
					<DIV class=newsBox>
						<DIV id="smsg">
							<IMG
								src="${pageContext.request.contextPath}/images/indicator.gif">
							数据加载中……
						</DIV>
					</DIV>
				</DIV>
				<!--视频广告-->
				<DIV id="advedio">
					<EMBED height="190" type="application/x-shockwave-flash"
						align="middle" width="190"
						src="http://player.youku.com/player.php/sid/XMTgyNDk5NTEy/v.swf"
						allowScriptAccess="sameDomain" quality="high"></EMBED>
					<DIV id="advediotil">
						途乐航空与张艺谋合作公司形象宣传片
					</DIV>
				</DIV>
			</DIV>
			<!-- box3：网上彩票及合作伙伴横栏-->
			<div id="box3">
				<ul>
					<li class="ad1">
						<img src="images/products2.jpg" usemap="#paylogo">
						<map name="paylogo">
							<area href="#" s hape="rect" target="_self" coords="42,40,138,73">
						</map>
					</li>
					<li class="ad2">
						<img src="${pageContext.request.contextPath}/images/weibo.jpg"
							usemap="#bloglogo">
						<map name="bloglogo">
							<area href="#" shape="rect" target="_self" coords=11,40,62,68>
							<area href="#" shape="rect" target="_self" coords=69,41,118,67>
							<area href="#" shape="rect" target="_self" coords=126,40,174,67>
						</map>
					</li>
					<li class="p1">
						<a title="海航旅业" href="#" target="_self">海航旅业</a>
					</li>
					<li class="p2">
						<a title="天津航空" href="#" target="_self">天津航空</a>
					</li>
					<li class="p3">
						<a title="祥鹏航空" href="#" target="_self">祥鹏航空</a>
					</li>
					<li class="p4">
						<a title="西部航空" href="#" target="_self">西部航空</a>
					</li>
					<li class="p5">
						<a title="海南航空" href="#" target="_self">海南航空</a>
					</li>
				</ul>
			</div>

			<!-- 底部版权信息开始-->
			<s:include value="/WEB-INF/jsp/common/footer.jsp">
			</s:include>

		</div>
		<div id="spring" class="backgroundimg"></div>
	</body>
</html>
