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
		
		<!-- 城市控件 -->
		<!--
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity_color.css">
  		-->

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
                var tabs = document.getElementById("tb_").getElementsByTagName("li");
                for (var i = 0; i < tabs.length; i++) {
                    tabs[i].className = "normaltab";
                }
                document.getElementById("tb_" + index.toString()).className = "hovertab";
            }
        	
        	//显示及隐藏城市选择
            function showCities(isShow,e, inputId) {
                var cityDiv = document.getElementById("cool_address");
                
                //设置位置及是否显示
                if (isShow) {
                    cityDiv.style.display = "block";
                    cityDiv.style.left = e.clientX;
                    cityDiv.style.top = e.clientY;
                    
					$.ajax({
						url: "getCities.action",
						typ: "post",
						data: {a:2},
						dataType: "json",
						success: function(data, textStatus) {
							$("#address_list").empty();
							var v = data;
							for(var i = 0; i < v.length; i++) {
								$("#address_list")
									.append($("<a>" + v[i].citySpellName +"<span>"
										+ v[i].cityName +"</span></a>")
									.attr("id", v[i].cityId)
									.data("cityId", v[i].cityId)
									.data("cityName", v[i].cityName)
									.click(function(){
										$('#cool_address').hide();
										var name = $(this).data("cityName");
									 	$("#"+inputId).val(name);
									})
								);
							} 
						}
					});
                }
                 
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
						<table>
							<tr>
								<td align="left" class="font_black12">
									<img
										src="${pageContext.request.contextPath}/images/icon_hbcx.gif">
									您现在的位置：
									<a href="#" class="black">首页</a> -&gt;
									<a href="#" class="red">会员信息</a>
								</td>
							</tr>
							<tr>
								<td class="line"></td>
							</tr>
						</table>
						<table cellpadding="5" cellspacing="0" class="border_red register">
							<tr>
								<td colspan="2" class="register_header bold700">
									您的基本信息
								</td>
							</tr>
							<tr>
								<td class="bottom_border_red register_leftinfo">
									用户名：
								</td>
								<td class="bottom_border_red">
									<s:property value="user.userLoginName" />
								</td>
							</tr>
							<tr>
								<td class="bottom_border_red register_leftinfo">
									<span class="font_grey12_2">真实姓名：</span>
								</td>
								<td class="bottom_border_red">
									<s:property value="user.userName" />
								</td>
							</tr>
							<!--
							<tr>
							
								<td class="bottom_border_red register_leftinfo">
									用户状态：
								</td>
								
								<td class="bottom_border_red">
									<s:property value="user.userState" />
								</td>
								
							</tr>
							-->
							<tr>
								<td class="bottom_border_red register_leftinfo">
									用户乘客类型：
								</td>
								<td class="bottom_border_red">
									<s:property value="user.userPassengerType" />
								</td>
							</tr>
							<tr>
								<td class="bottom_border_red register_leftinfo">
									移动电话：
								</td>
								<td class="bottom_border_red">
									<s:property value="user.userTelephone" />
								</td>
							</tr>
							<tr>
								<td class="bottom_border_red register_leftinfo">
									证件类型：
								</td>
								<td class="bottom_border_red">
									<s:property value="user.userCertifType" />
								</td>
							</tr>
							<tr>
								<td class="bottom_border_red register_leftinfo">
									证件号码：
								</td>
								<td class="bottom_border_red">
									<s:property value="user.userCertifNum" />
								</td>
							</tr>
							<tr>
								<td class="bottom_border_red register_leftinfo">
									电子邮件：
								</td>
								<td class="bottom_border_red">
									<s:property value="user.userEmail" />
								</td>
							</tr>

							<tr>
								<td class="bottom_border_red register_leftinfo">
									注册日期：
								</td>
								<td class="bottom_border_red">
									<s:property value="user.userCreationDate" />
								</td>
							</tr>
							

						</table>
						<table class="button_list">
							<tr>
								<td>
									<input name="inpNext" type="button" class="ipt" id="Button1"
										value="修改资料" onclick="location.href='updateUserForm.action'">
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
