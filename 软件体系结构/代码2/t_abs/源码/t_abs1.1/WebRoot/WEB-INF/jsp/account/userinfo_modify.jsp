<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>途乐航空[官方网站] – 北京达内科技有限公司</title>
		<link rel="SHORTCUT ICON"
			href="${pageContext.request.contextPath}/images/favicon.ico" />
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common_color.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/account.css" />
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/account_color.css" />


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
									<a href="#" class="red">会员信息</a>
								</td>
							</tr>
							<tr>
								<td class="line"></td>
							</tr>
						</table>
						<form action="updateUser.action" method="post">
							<table cellpadding="5" cellspacing="0"
								class="border_red register">
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
										<s:hidden name="user.userLoginName"></s:hidden>
										<s:hidden name="user.userId"></s:hidden>
										<s:hidden name="user.userState"></s:hidden>
									</td>
								</tr>
								<tr>
									<td class="bottom_border_red register_leftinfo">
										<span class="font_grey12_2">真实姓名：</span>
									</td>
									<td class="bottom_border_red">
										<s:textfield name="user.userName"></s:textfield>
									</td>
								</tr>
								<!-- 
								<tr>
									<td class="bottom_border_red register_leftinfo">
										用户状态：
									</td>
									<td class="bottom_border_red">
										<s:select list='#{"A":"A","B":"B"}' name="user.userState">
										</s:select>
									</td>
								</tr>
								 -->
								<tr>
									<td class="bottom_border_red register_leftinfo">
										用户乘客类型：
									</td>
									<td class="bottom_border_red">
										<s:select list='#{"A":"成人","C":"儿童","I":"婴儿"}'
											name="user.userPassengerType">
										</s:select>
									</td>
								</tr>
								<tr>
									<td class="bottom_border_red register_leftinfo">
										移动电话：
									</td>
									<td class="bottom_border_red">
										<s:textfield name="user.userTelephone"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="bottom_border_red register_leftinfo">
										证件类型：
									</td>
									<td class="bottom_border_red">
										<s:select list='#{"NI":"身份证","PP":"护照" , "OT":"其它"}'
											name="user.userCertifType">
										</s:select>
									</td>
								</tr>
								<tr>
									<td class="bottom_border_red register_leftinfo">
										证件号码：
									</td>
									<td class="bottom_border_red">
										<s:textfield name="user.userCertifNum"></s:textfield>
									</td>
								</tr>
								<tr>
									<td class="bottom_border_red register_leftinfo">
										电子邮件：
									</td>
									<td class="bottom_border_red">
										<s:textfield name="user.userEmail"></s:textfield>
									</td>
								</tr>

								<tr>
									<td class="bottom_border_red register_leftinfo">
										注册日期：
									</td>
									<td class="bottom_border_red">
										<s:textfield name="user.userCreationDate"></s:textfield>
									</td>
								</tr>
								
							</table>
							<table class="button_list">
								<tr>
									<td>
										<input name="inpNext" type="submit" class="ipt" id="Button1"
											value="修改资料">
										<input name="inpNext" type="reset" class="ipt" id="Button2"
											value="重  置">
									</td>
								</tr>
							</table>
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
