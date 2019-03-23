<%@ page language="java" import="java.util.*;" pageEncoding="gb2312"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<html>
	<head>
		<title>My JSP 'regist.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->



		<script language="javascript">
			
			 var http_request=false;
			 
			 function checkusername(){
    	
    				var un = document.getElementById("username");
	    		if( un.value==""){
	    	
	    			alert("用户名不能为空");
	    			return
	    			
	    		}
	    	
	    			    	// 服务器实现（AJAX）
   	    // （1）建立通讯对象，实现与服务器之间的交互
    				http_request = new ActiveXObject("Microsoft.XMLHTTP");
    	// （2）指定接收服务器处理结果的函数
    				http_request.onreadystatechange = AfterCheck;
    	// （3）指定服务器的处理对象（JSP、DO），通过链接传递数据
					var url = "CheckUser.jsp?username="+un.value;
		// （4）指定提交方式与路径
					http_request.open("Get", url, true);
		// （5）发送请求
					http_request.send();
   		 }
    
   		 function AfterCheck(){
    	 // （6）判断状态（readystate），4 表示处理结果返回，可以接收
    			if (http_request.readystate == 4){
    		// （7）通过读取属性ResponseText，获取处理结果
					if(http_request.ResponseText == 1){
						alert("用户已存在");
					}else{
						alert("用户名尚未使用");	
									
					}
				}
	
			}
			
			function regist(){	
				var registform = document.getElementById("registform");			
				var username = document.getElementById("username").value;
				var registform = document.getElementById("registform");
				
			if(username==""){
			
				alert("用户名不能为空");
				return
			}else{
			 
				registform.submit();
			}
			
			
		}
	
	</script>


	</head>

	<body bgcolor="#c0c0c0">
		<br>

		<center>
			欢迎注册在线机票预订系统
			<hr>
			<br>
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td>
									<img src="image/title3.jpg" alt="用户注册" align="middle" />
								</td>
							</tr>
						</table>
					</td>
					<td>
						<html:form action="regist.do?method=regist" method="post">
							<table>
								<caption>
									* 为填项，请慎重填写
								</caption>
								<tr>
									<td>
										用户名 :
									</td>
									<td>
										<input type="text" name="username" id="username"
											onblur="checkusername()">
										<span onclick="checkusername()" style="cursor: band">*
											为自己注册一个独一无二的名字</span>

									</td>
								</tr>
								<tr>
									<td>
										真实姓名 :
									</td>
									<td>
										<input type="text" name="realname" id="realname">
									</td>
								</tr>
								<tr>
									<td>
										密&nbsp; 码 :
									</td>
									<td>
										<input type="password" name="password" id="password">
										*
									</td>
								</tr>
								<tr>
									<td>
										年龄:
									</td>
									<td>
										<input type="text" name="age" value="">
										* 请输入整数
									</td>
								</tr>
								<tr>
									<td>
										性别
									</td>
									<td>
										<input type="radio" name="sex" value="男" checked>
										男
										<input type="radio" name="sex" value="女">
										女
									</td>
								</tr>

								<tr>
									<td>
										email &nbsp;:
									</td>
									<td>
										<input type="text" name="email" id="email">
										*
									</td>
								</tr>

								<tr>
									<td>
										角&nbsp; 色 :
									<td>
										<input type="radio" name="ismanager" value="1" checked>
										普通用户
										<input type="radio" name="ismanager" value="2">
										管理员
									</td>
								</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" name="sub" value="确定">
					<input type="reset" name="subm" value="重置">
				</td>
			</tr>

							</table>
						</html:form>
					</td>
				</tr>
				
				<tr></tr>

			</table>
		</center>
	</body>
</html>
