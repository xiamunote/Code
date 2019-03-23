<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>途乐航空[官方网站] – 北京达内科技有限公司</title>
		<link rel="SHORTCUT ICON" href="/images/favicon.ico">
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/common_color.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/account.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/account_color.css">

		<!-- 用于客户端验证 -->
		<script
			src="${pageContext.request.contextPath}/scripts/jquery-1.4.4.min.js"
			type="text/javascript"></script>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/css/validator.css"/>
		<script
			src="${pageContext.request.contextPath}/scripts/formValidator-4.0.1.min.js"
			type="text/javascript" charset="UTF-8"></script>
		<script
			src="${pageContext.request.contextPath}/scripts/formValidatorRegex.js"
			type="text/javascript" charset="UTF-8"></script>

		<script type="text/javascript">
	$(document).ready(function(){
	//检查登录表单项
		$.formValidator.initConfig({
			validatorGroup:"1",
			submitButtonID:"loginSubmit",
			debug:false,
			submitOnce:true
		});
	
		$("#password3")
		.formValidator({
			validatorGroup:"1",
			onShow:"请输入密码",
			onFocus:"需要6-20个长度",
			onCorrect:"密码格式正确"})
		.inputValidator({
			min:6,
			max:20
		});
		
		$("#loginName3")
		.formValidator({
			validatorGroup:"1",
			onShow:"请输入用户名",
			onFocus:"用户名至少5个字符,最多10个字符",
			onCorrect:"用户名格式正确"})
		.inputValidator({
			min:5,
			max:10,
			onError:"用户名格式错误"})
	
	//检查注册表单项
		$.formValidator.initConfig({
			validatorGroup:"2",
			submitButtonID:"registSubmit",
			debug:false,
			submitOnce:true,
			submitAfterAjaxPrompt : '有数据正在异步验证，请稍等...'
		});
	
		$("#loginName1")
		.formValidator({
			validatorGroup:"2",
			onShow:"请输入用户名",
			onFocus:"用户名至少5个字符,最多10个字符",
			onCorrect:"该用户名可用"})
		.inputValidator({
			min:5,max:10,
			onError:"用户名格式错误"})
	    .ajaxValidator({
			dataType : "json",
			async : true,
			url : "checkUser.action",
			success : function(ok){
			    return ok;
	         },
			buttons: $("#button"),
			error: function(jqXHR, textStatus){
				alert("服务器没有返回数据，可能服务器忙，请重试");},
			onError : "该用户名已占用",
			onWait : "正在对用户名进行合法性校验，请稍候..."});
		
		$("#password1")
		.formValidator({
			validatorGroup:"2",
			onShow:"请输入密码",
			onFocus:"需要6-20个长度",
			onCorrect:"密码合法"})
		.inputValidator({
			min:6,
			max:20,
			empty:{
				leftEmpty:false,
				rightEmpty:false,
				emptyError:"密码两边不能有空符号"},
				onError:"密码不能为空,请确认"});
		
		$("#password2")
		.formValidator({
			validatorGroup:"2",
			onShow:"输再次输入密码",
			onFocus:"需要6-20个长度",
			onCorrect:"密码一致"})
		.inputValidator({
			min:6,
			max:20,
			empty:{
				leftEmpty:false,
				rightEmpty:false,
				emptyError:"重复密码两边不能有空符号"},
				onError:"重复密码不能为空,请确认"})
		.compareValidator({
			desID:"password1",
			operateor:"=",
			onError:"两次密码不一致,请确认"});
	
		$("#email")
		.formValidator({
			validatorGroup:"2",
			onShow:"请输入邮箱",
			onFocus:"邮箱6-100个字符,输入正确了才能离开焦点",
			onCorrect:"恭喜你,你输对了",
			defaultValue:"@"})
		.inputValidator({
			min:6,
			max:100,
			onError:"你输入的邮箱长度非法,请确认"})
		.regexValidator({
			regExp:"^([\\w-.]+)@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.)|(([\\w-]+.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$",
			onError:"你输入的邮箱格式不正确"});
			
		$("#userName3")
		.formValidator({
			validatorGroup:"2",
			onShow:"请输入真实姓名",
			onFocus:"至少2个长度",
			onCorrect:"OK"})
		.inputValidator({
			min:2,
			empty:{
				leftEmpty:false,
				rightEmpty:false,
				emptyError:"姓名两边不能有空符号"},
				onError:"不合法,请确认"});
	});
	
	</script>
	</head>

	<body>
		<div id="page">
			<!-- 头部-->
			<!-- 引入头部文件 -->
			<s:include value="/WEB-INF/jsp/common/header.jsp">
			</s:include>

			<!-- 主体内容 -->
			<div id="subpage">
				<div id="userloginwarp">
					<div id="login">
						<form id="loginForm3" action="login.action" method="post">
							<table>
								<tr>
									<td class="width23percent logintext">
										用户名：
									</td>
									<td class="width77percent">
										<input name="userName" type="text" id="loginName3" value=""
											class="ipts1">
									</td>
									<td>
										<div id="loginName3Tip" style="width: 250px"></div>
									</td>
								</tr>
								<tr>
									<td class="width23percent logintext">
										密&nbsp;&nbsp;&nbsp;&nbsp;码：
									</td>
									<td>
										<input name="password" type="password" id="password3"
											class="ipts1">
									</td>
									<td>
										<div id="password3Tip" style="width: 250px"></div>
									</td>
								</tr>
								<tr>
									<td class="width23percent logintext">
										验证码：
									</td>
									<td>
										<input name="userNumber" type="text" id="j_captcha_response2"
											class="ipts2">
										<img id="Img1" src="checkcode.action"
											onclick="$('#Img1').attr('src','checkcode.action?'+Math.random());"
											title="点击更换验证码">
										${checkcodeErr}
									</td>
								</tr>
								<tr>
									<td colspan="2" class="width23percent">
										<input id="loginSubmit" name="loginSubmit" type="submit"
											class="iptlg" value="" />
										
									</td>
								</tr>
							</table>
						</form>
					</div>


					<div id="register">

						<form id="regForm" name="regForm" method="post"
							action="register01.action">
							<h1>
								个人用户
							</h1>
							<div class="rigform">
								<table>
									<tr></tr>
									<tr>
										<td class="width20percent">
											用户名：
										</td>
										<td>
											<input id="loginName1" name="loginName" class="ipts3"
												value="tolo" />
										</td>
										<td>
											<div id="loginName1Tip" style="width: 250px"></div>
										</td>
									</tr>
									<tr>
										<td class="width20percent">
											密&nbsp;&nbsp;&nbsp;&nbsp;码：
										</td>
										<td>
											<input id="password1" name="password" type="password"
												class="ipts3" value="" />
										</td>
										<td>
											<div id="password1Tip" style="width: 250px"></div>
										</td>
									</tr>
									<tr>
										<td class="width20percent">
											重复密码：
										</td>
										<td>
											<input id="password2" name="password2" type="password"
												class="ipts3" value="" />
										</td>
										<td>
											<div id="password2Tip" style="width: 250px"></div>
										</td>
									</tr>
									<tr>
										<td class="width20percent">
											电子邮件：
										</td>
										<td>
											<input id="email" name="email" type="text" class="ipts3" />
										</td>
										<td>
											<div id="emailTip" style="width: 250px"></div>
										</td>
									</tr>
									<tr>
										<td class="width20percent">
											真实姓名：
										</td>
										<td>
											<input id="userName3" name="userName" type="text"
												class="ipts3">
										</td>
										<td>
											<div id="userName3Tip" style="width: 250px"></div>
										</td>
									</tr>
									<tr>
										<td class="width20percent">
											移动电话：
										</td>
										<td>
											<input id="telephone" name="telephone" type="text"
												class="ipts3" />
										</td>
									</tr>

									<tr>
										<td class="width20percent">
											&nbsp;
										</td>
										<td>
											<input id="registSubmit" name="registSubmit" type="submit" class="iptre"
												value="" />
										</td>
									</tr>
								</table>
							</div>
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
