<%@page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!-- 头部-->
<div id="header">
    <!-- 头部右上角子菜单开始-->
    <div id="logo"></div>
    <div id="topnav">

        
        <s:if test="#session['user']==null">
        	<!--会员登录开始-->
	        <form id="loginForm" method="post" 
	        name="loginForm" action="login.action">
	            <div id="toplogin">
	                用户名：<input id="userName" class="textbox" 
	                type="text" name="userName">
	                密码：<input id="password" class="textbox" 
	                type="password" name="password">
	                验证码：<input id="j_captcha_response" 
	                class="textbox_vericode" type="text" 
	                name="userNumber">
	                <img  id="jcaptcha" class="verycode" title="点击更换验证码" 
	            	src="checkcode.action"
	            	onclick="$('#jcaptcha').attr('src','checkcode.action?'+Math.random());" />
	                <div id="loginbanner">
	                    <input class="btn_login" value="登 录" 
	                    type="submit" name="inpLogin" />
	                    <input class="btn_login" value="注 册" 
	                    type=button name="registerUser"
	                    onclick="location.replace('registerUserPage.action');">
	                </div>
	            </div>
	      </form>
        </s:if>
        <s:else>
        	<div id="toplogin">
			欢迎您，<s:property value="#session.user.userName" />
			<br>		
			<a href="userInfo.action" class="loginned"> 用户信息</a>
			<a href="myordersPage.action" class="loginned">| 我的订单</a>
			<a href="updateUserForm.action" class="loginned">| 修改资料</a>
			<a href="passwordModifyPage.action" class="loginned">| 修改密码</a>
			<input name="registerUser" type="button" 
			class="ipt" value="退出登录" onclick="location.href='logout.action';">
			</div>
        </s:else>
    </div>
    
    <div id="line"></div>
    <div id="menu">
        <ul class="jl-menu">
            <li class="current">
            <a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
            <li class="current">
            <a href="multiwayPage.action">在线购票</a></li>
            <li class="current">
            <a href="listBranch.action">营业网点</a></li>	<!-- 查询营业网点 -->
            <li class="current">
            <a href="onlineHelpPage.action">在线帮助</a></li>
            <li class="current">
            <a href="aboutPage.action">关于我们</a></li>
            <li class="current">
            <a href="loginPage.action">用户登录</a></li>
        </ul>
     </div>
</div>