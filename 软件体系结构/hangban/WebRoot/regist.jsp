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
	    	
	    			alert("�û�������Ϊ��");
	    			return
	    			
	    		}
	    	
	    			    	// ������ʵ�֣�AJAX��
   	    // ��1������ͨѶ����ʵ���������֮��Ľ���
    				http_request = new ActiveXObject("Microsoft.XMLHTTP");
    	// ��2��ָ�����շ������������ĺ���
    				http_request.onreadystatechange = AfterCheck;
    	// ��3��ָ���������Ĵ������JSP��DO����ͨ�����Ӵ�������
					var url = "CheckUser.jsp?username="+un.value;
		// ��4��ָ���ύ��ʽ��·��
					http_request.open("Get", url, true);
		// ��5����������
					http_request.send();
   		 }
    
   		 function AfterCheck(){
    	 // ��6���ж�״̬��readystate����4 ��ʾ���������أ����Խ���
    			if (http_request.readystate == 4){
    		// ��7��ͨ����ȡ����ResponseText����ȡ������
					if(http_request.ResponseText == 1){
						alert("�û��Ѵ���");
					}else{
						alert("�û�����δʹ��");	
									
					}
				}
	
			}
			
			function regist(){	
				var registform = document.getElementById("registform");			
				var username = document.getElementById("username").value;
				var registform = document.getElementById("registform");
				
			if(username==""){
			
				alert("�û�������Ϊ��");
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
			��ӭע�����߻�ƱԤ��ϵͳ
			<hr>
			<br>
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td>
									<img src="image/title3.jpg" alt="�û�ע��" align="middle" />
								</td>
							</tr>
						</table>
					</td>
					<td>
						<html:form action="regist.do?method=regist" method="post">
							<table>
								<caption>
									* Ϊ�����������д
								</caption>
								<tr>
									<td>
										�û��� :
									</td>
									<td>
										<input type="text" name="username" id="username"
											onblur="checkusername()">
										<span onclick="checkusername()" style="cursor: band">*
											Ϊ�Լ�ע��һ����һ�޶�������</span>

									</td>
								</tr>
								<tr>
									<td>
										��ʵ���� :
									</td>
									<td>
										<input type="text" name="realname" id="realname">
									</td>
								</tr>
								<tr>
									<td>
										��&nbsp; �� :
									</td>
									<td>
										<input type="password" name="password" id="password">
										*
									</td>
								</tr>
								<tr>
									<td>
										����:
									</td>
									<td>
										<input type="text" name="age" value="">
										* ����������
									</td>
								</tr>
								<tr>
									<td>
										�Ա�
									</td>
									<td>
										<input type="radio" name="sex" value="��" checked>
										��
										<input type="radio" name="sex" value="Ů">
										Ů
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
										��&nbsp; ɫ :
									<td>
										<input type="radio" name="ismanager" value="1" checked>
										��ͨ�û�
										<input type="radio" name="ismanager" value="2">
										����Ա
									</td>
								</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" name="sub" value="ȷ��">
					<input type="reset" name="subm" value="����">
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
