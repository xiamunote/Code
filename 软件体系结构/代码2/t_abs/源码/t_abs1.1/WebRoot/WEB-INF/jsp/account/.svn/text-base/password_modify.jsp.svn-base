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
		<script
			src="${pageContext.request.contextPath}/scripts/jquery-1.4.4.min.js"
			type="text/javascript"></script>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/css/validator.css"></link>
		<script
			src="${pageContext.request.contextPath}/scripts/formValidator-4.0.1.min.js"
			type="text/javascript" charset="UTF-8"></script>
		<script
			src="${pageContext.request.contextPath}/scripts/formValidatorRegex.js"
			type="text/javascript" charset="UTF-8"></script>

		<script language="javascript">
		
		$(function(){
		//设置全局初始参数
			$.formValidator.initConfig({
				formID:"form1",
				debug:false,
				submitOnce:true,
				onSuccess:function(){
	       			$.ajax({
	       				url:"modifyPassword.action",
	       				data:{
	       					oldPassword:$("#oldPassword").val(),
	       					newPassword:$("#newPassword").val()
	       				},
	       				async:false,
	       				success:function(ok){
	       					if(ok){
	       						alert("修改成功！");
	       					}else{
	       						alert("修改失败！");
	       					}
	       				}
	       			});
	       			return false;
				  }
			});
			
			$("#oldPassword").formValidator({
				onShow:"请输入旧密码",
				onFocus:"密码位数必须在6-20位之间",
				onCorrect:"旧密码格式正确"
			}).inputValidator({
				min:6,
				max:20,
				onError:"旧密码格式错误"
			});
			$("#newPassword").formValidator({
				onShow:"请输入新密码",
				onFocus:"密码位数必须在6-20位之间",
				onCorrect:"新密码格式正确"
			}).inputValidator({
				min:6,
				max:20,
				onError:"新密码格式错误"
			});
			
			$("#confirmPassword").formValidator({
				onShow:"请输入确认密码",
				onFocus:"确认密码位数必须在6-20位之间",
				onCorrect:"确认密码格式正确"
			}).inputValidator({
				min:6,
				max:20,
				onError:"确认密码格式错误"
			}).compareValidator({
			desID:"newPassword",
			operateor:"=",
			onError:"两次密码不一致,请确认"});
		});
		
		
           ;
        
            
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
									<a href="#" class="red">修改密码</a>
								</td>
							</tr>
							<tr>
								<td class="line"></td>
							</tr>
						</table>
						<form id="form1" action="" method="post">
						<table cellpadding="5" cellspacing="0" class="border_red register">
							<tr>
								<td colspan="2" class="register_header bold700">
									修改密码
								</td>
							</tr>
							<tr>
								<td class="bottom_border_red register_leftinfo height30">
									旧密码：
								</td>
								<td class="bottom_border_red">
									<input type="password" class="register width140" id="oldPassword">
									<span class="red">*</span>
									<span id="oldPasswordTip"></span>
								</td>
							</tr>
							<tr>
								<td class="bottom_border_red register_leftinfo height30">
									新密码：
								</td>
								<td class="bottom_border_red">
									<input type="password" class="register width140" id="newPassword">
									<span class="red">*</span>
									<span id="newPasswordTip"></span>
								</td>
							</tr>
							<tr>
								<td class="bottom_border_red register_leftinfo height30">
									新密码确认：
								</td>
								<td class="bottom_border_red">
									<input type="password" class="register width140"
										id="confirmPassword">
									<span class="red">*</span>
									<span id="confirmPasswordTip"></span>
								</td>
							</tr>
						</table>
						<table class="button_list">
							<tr>
								<td>
									<input type="submit" class="ipt" id="ConfirmBtn" value="确认">
									<input type="button" class="ipt" id="Button2" value="返回">
								</td>
							</tr>
						</table>
						</form>
					</div>
				</div>
			</div>
			<!-- 底部版权信息开始-->
			<div class="clear"></div>
			<s:include value="/WEB-INF/jsp/common/footer.jsp">
			</s:include>
		</div>
		<div id="spring" class="backgroundimg"></div>
	</body>
</html>
