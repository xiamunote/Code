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

		<!-- 客户端验证 -->
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

		<!-- 城市控件 -->
		<!--
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/coolcity_color.css">
  		-->


		<script type="text/javascript">
	//###客户端验证###
	$(document).ready(function(){
		$.formValidator.initConfig({
			formID:"regForm",
			debug:false,
			submitOnce:true,
			onError:function(msg,obj,errorlist){
				$("#errorlist").empty();
				$.map(errorlist,function(msg){
					$("#errorlist").append("<li>" + msg + "</li>")
				});
				alert(msg);
			},
			submitAfterAjaxPrompt : '有数据正在异步验证，请稍等...'
		});
	
		$("#regLoginName")
		.formValidator({
			onShow:"请输入用户名",
			onFocus:"用户名至少5个字符,最多10个字符",
			onCorrect:"该用户名可用"})
		.inputValidator({
			min:5,max:10,
			onError:"你输入的用户名非法,请确认"})
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
			onWait : "正在对用户名进行合法性校验，请稍候..."})
		.defaultPassed();
		
		$("#regPassword")
		.formValidator({
			onShow:"请输入密码",
			onFocus:"至少6个长度",
			onCorrect:"密码合法"})
		.inputValidator({
			min:6,
			empty:{
				leftEmpty:false,
				rightEmpty:false,
				emptyError:"密码两边不能有空符号"},
				onError:"密码不能为空,请确认"});
		
		$("#regPassword2")
		.formValidator({
			onShow:"输再次输入密码",
			onFocus:"至少6个长度",
			onCorrect:"密码一致"})
		.inputValidator({
			min:6,
			empty:{
				leftEmpty:false,
				rightEmpty:false,
				emptyError:"重复密码两边不能有空符号"},
				onError:"重复密码不能为空,请确认"})
		.compareValidator({
			desID:"regPassword",
			operateor:"=",
			onError:"两次密码不一致,请确认"});
	
		$("#regEmail")
		.formValidator({
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
			
		$("#regUserName")
		.formValidator({
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
	
	
	//###城市控件###
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

				<!-- 左侧-->
				<s:include value="/WEB-INF/jsp/common/left.jsp">
				</s:include>

				<!-- 右侧-->
				<div id="main">
					<div id="maincontent">
						<form id="regForm" name="regForm" action="register02.action"
							method="post">
							<table>
								<tr>
									<td class="font_black12">
										<img
											src="${pageContext.request.contextPath}/images/icon_hbcx.gif">
										您现在的位置：
										<a href="#" class="black">首页</a> -&gt;
										<a href="#" class="red">用户注册</a>
									</td>
								</tr>
								<tr>
									<td class="line"></td>
								</tr>
							</table>
							<table class="border_red register" cellspacing="0"
								cellpadding="5">
								<tr>
									<td colspan="3" class="register_header bold700">
										必填
										<span class="bold400">（带<span class="red">*</span>项为必填项）</span>
									</td>
								</tr>
								<tr>
									<td class="bottom_border_red register_leftinfo height30">
										用户名：
									</td>
									<td class="bottom_border_red register_inputinfo">
										<input name="regLoginName" type="text"
											class="register width160" id="regLoginName">
										<span class="red bold400">*</span>
									</td>
									<td class="register_errortext">
										<span id="regLoginNameTip"></span>
									</td>
								</tr>
								<tr>
									<td class="bottom_border_red register_leftinfo height30">
										密码：
									</td>
									<td class="bottom_border_red register_inputinfo">
										<input id="regPassword" name="regPassword" type="password"
											class="register width160">
										<span class="red bold400">*</span>
									</td>
									<td class="register_errortext">
										<span id="regPasswordTip"></span>
									</td>
								</tr>
								<tr>
									<td class="bottom_border_red register_leftinfo height30">
										重新输入密码：
									</td>
									<td class="bottom_border_red register_inputinfo">
										<input type="password" class="register width160"
											id="regPassword2" name="regPassword2" value="">
										<span class="red bold400">*</span>
									</td>
									<td class="register_errortext">
										<span id="regPassword2Tip"></span>
									</td>
								</tr>
								<tr>
									<td class="bottom_border_red register_leftinfo height30">
										真实姓名：
									</td>
									<td class="bottom_border_red register_inputinfo">
										<input id="regUserName" name="regUserName" type="text"
											class="register width160">
										<span class="red bold400">*</span>
									</td>
									<td class="register_errortext">
										<span id="regUserNameTip"></span>
									</td>
								</tr>
								<tr>
									<td class="bottom_border_red register_leftinfo height30">
										常用邮箱：
									</td>
									<td class="bottom_border_red register_inputinfo">
										<input id="regEmail" name="regEmail" type="text"
											class="register width160" />
										<span class="red bold400">*</span>
									</td>
									<td class="register_errortext">
										<span id="regEmailTip"></span>
									</td>
								</tr>
							</table>
							<table cellpadding="5" cellspacing="0"
								class="border_red register">
								<tr>
									<td colspan="2" class="register_header bold700">
										建议填写
										<span class="red bold400"> （为了便于通知航班变更等信息，
											建议用户填写至少一种联系电话。 首都航空不会绑定任何收费服务） </span>
									</td>
								</tr>
								<tr>
									<td
										class="bottom_border_red register_leftinfo height30 width88">
										移动电话：
									</td>
									<td class="bottom_border_red">
										<input type="text" class="register width160" id="regTelephone"
											name="regTelephone">
									</td>
								</tr>
								<tr>
									<td
										class="bottom_border_red register_leftinfo height30 width88">
										证件类型：
									</td>
									<td class="bottom_border_red">
										<select id="regUserCertifType" name="regUserCertifType">
											<option value="身份证">
												身份证
											</option>
											<option value="护照">
												护照
											</option>
											<option value="军官证">
												军官证
											</option>
											<option value="其它">
												其它
											</option>
										</select>
									</td>
									<td class="register_errortext">
										&nbsp;
									</td>
								</tr>
								<tr>
									<td
										class="bottom_border_red register_leftinfo height30 width88">
										证件号码：
									</td>
									<td class="bottom_border_red">
										<input type="text" class="register width160"
											name="regUserCertifNum" id="regUserCertifNum">

									</td>
									<td class="register_errortext">

									</td>
								</tr>
							</table>

							<table cellpadding="5" cellspacing="0"
								class="border_red register">
								<tr>
									<td colspan="3" class="bottom_border_red padding_left25">
										您是否愿意接受来自首都航空的邮件：
										<input id="acceptMail" type="radio" value="yes">
										是
										<input id="acceptMail" type="radio" value="no"
											checked="checked">
										否
									</td>
								</tr>
							</table>
							<table class="register_text">
								<tr>
									<td>
										<input type="checkbox" name="checkbox" id="checkbox">
										<span class="red bold400">注册前阅读并同意</span> 《散客用户注册协议》
									</td>
								</tr>
								<tr>
									<td>
										<input type="submit" class="ipt" value="完成注册">
										<input name="inpNext" type="reset" class="ipt" id="ipt"
											value="重新填写">
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
