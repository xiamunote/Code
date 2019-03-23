<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>途乐航空[官方网站] – 北京达内科技有限公司</title>
        <link rel="SHORTCUT ICON" href="${pageContext.request.contextPath}/images/favicon.ico">
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
        <link rel="stylesheet" type="text/css" 
        href="${pageContext.request.contextPath}/css/common.css">
        <link rel="stylesheet" type="text/css" 
        href="${pageContext.request.contextPath}/css/common_color.css">
        <link rel="stylesheet" type="text/css" 
        href="${pageContext.request.contextPath}/css/account.css">
        <link rel="stylesheet" type="text/css" 
        href="${pageContext.request.contextPath}/css/account_color.css">
        <link rel="stylesheet" type="text/css" 
        href="${pageContext.request.contextPath}/css/thickbox.css" />
        <script type="text/javascript" 
        src="${pageContext.request.contextPath}/scripts/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" 
        src="${pageContext.request.contextPath}/scripts/thickbox-compressed.js"></script>
        <script type="text/javascript" 
        src="${pageContext.request.contextPath}/scripts/configuration.js"></script>
        
        <!-- 查询城市需要的css样式 -->
        <!-- 
        <link rel="stylesheet" type="text/css" 
        href="${pageContext.request.contextPath}/css/coolcity.css">
        <link rel="stylesheet" type="text/css" 
        href="${pageContext.request.contextPath}/css/coolcity_color.css">
        -->
        
        <script type="text/javascript">
            
            //分页按钮的处理
        	function changePage (pageNum){
        	  if(pageNum<1){
        	  	pageNum = 1;
        	  }else if(pageNum > ${totalPage}){
        	  	pageNum = ${totalPage};
        	  }
        	  window.location = "passengerList.action?page="+pageNum;
        	}
        	
        	$(function(){
        		//分页跳转按钮的处理
        		$("#jumpBtn").click(function(){
        			var p = $("#jumpPageInput").val();
        			if(isNaN(p)){
        				alert("页数输入格式错误");
        			}else{
        				changePage(p);
        			}
        		});
        	});
        	
        	$(function(){
        	    //弹出窗口的“提交”按钮处理
				$("#popBox").submit(function(){
				    var flag1 = true;
				    var flag2 = true;
					$("#psgNameError").html("");
					$("#psgCertifNumError").html("");
					//检查输入项
					if($("#psgName").val() == ""){
						$("#psgNameError").html("乘客名不能为空");
						flag1 = false;
					}
					if($("#psgCertifNum").val() == ""){
						$("#psgCertifNumError").html("证件号不能为空");
						flag2 = false;
					}
					return flag1&&flag2;
					
				});
			});
			
        	//选中列表记录的处理
        	function setPassengerBox(trObj){
        	   $("#psgNameError").html("");
			   $("#psgCertifNumError").html("");
        	   var psgId = $(trObj).attr("id");
        	   var psgName = $(trObj).find(".psgName").text();
        	   var psgCertifType = $(trObj).find(".psgCertifType").text();
        	   var psgCertifNum = $(trObj).find(".psgCertifNum").text();
        	   var psgType = $(trObj).find(".psgType").text();
        	   var refUserId = $(trObj).find(".refUserId").text();
        	   $("#psgId").val(psgId);
        	   $("#psgName").val(psgName);
        	   $("#psgCertifType").val(psgCertifType);
        	   $("#psgCertifNum").val(psgCertifNum);
        	   $("#psgType").val(psgType);
        	   $("#refUserId").val(refUserId);
        	   $(trObj).siblings().removeClass("passengerRow_selected");//将其他tr取消选中样式
        	   $(trObj).removeClass("passengerRow_hover");//取消mouseover样式
        	   $(trObj).addClass("passengerRow_selected");//添加选中样式
        	   $(trObj).unbind();//取消当前tr鼠标移上去和移开事件
        	   //将其他tr添加鼠标移上去和移开事件
        	   $(trObj).siblings().bind("mouseover",function(){
        			$(this).addClass("passengerRow_hover");
        		});
        		$(trObj).siblings().bind("mouseout",function(){
        			$(this).removeClass("passengerRow_hover");
        		});
        	}
        	 
        	
        	$(function(){
        		$("tr.passengerRow").bind("mouseover",function(){
        			$(this).addClass("passengerRow_hover");
        		});
        		$("tr.passengerRow").bind("mouseout",function(){
        			$(this).removeClass("passengerRow_hover");
        		});
        		
        		//点添加按钮时，先清空弹出框信息
        		$("#addBtn").click(function(){
        		   //清除输入项的错误提示信息
        		   $("#psgNameError").html("");
			       $("#psgCertifNumError").html("");
			       //清除表单输入项
        		   $("#psgId").val("");
	        	   $("#psgName").val("");
	        	   $("#psgCertifType").val("");
	        	   $("#psgCertifNum").val("");
	        	   $("#psgType").val("");
	        	   $("#refUserId").val("");
        		});
        		
        		
        		//点更新按钮时，如果未选择记录，则关闭修改提示框
				$("#updateBtn").click(function(){
					if($("#psgId").val() == ""){
						tb_remove();
					}
				});
				
				//点删除按钮时，删除记录
				$("#deleteBtn").click(function(){
					var psgId = $("#psgId").val();
					if(psgId == ""){
						alert("请选择要删除的记录");
					}else{
						if(confirm("确认删除吗？")){
							window.location="deletePassenger.action?id="+psgId+"&page="+${page};
						}
					}
				});

        	});
        	
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
	            <s:include 
           		value="/WEB-INF/jsp/common/left.jsp">
           		</s:include>
  	            
   	            <!-- 右侧-->
               <div id="main">
                    <div id="maincontent">		
                        <table>
	                        <tr>
		                        <td align="left" class="font_black12">
		                            <img src="${pageContext.request.contextPath}/images/icon_hbcx.gif">
		                            您现在的位置：<a href="#" class="black">首页</a> -&gt;
		                            <a href="#" class="black">会员管理</a> -&gt;
		                            <a href="#" class="red">常用乘机人管理</a>
		                        </td>
		                    </tr>
	                        <tr>
		                        <td class="line"></td>
	                        </tr>
                        </table>                     
                        <table cellpadding="5" cellspacing="0" class="orders">
	                        <thead>
	                            <tr>
	                                <td class="tableHeader" 
	                                onmouseover="this.className='tableHeaderOver';"  
	                                onmouseout="this.className='tableHeader';">
	                                    <span class="columnSeparator" >&#160;</span>
	                                    <div class="headerTitle" >序号</div>
	                                </td>
	                                <td class="tableHeader" 
	                                onmouseover="this.className='tableHeaderOver';"  
	                                onmouseout="this.className='tableHeader';">
	                                    <span class="columnSeparator" >&#160;</span>
	                                    <div class="headerTitle" >姓名</div>
	                                </td> 
	                                <td class="tableHeader" 
	                                onmouseover="this.className='tableHeaderOver';"  
	                                onmouseout="this.className='tableHeader';">
	                                    <span class="columnSeparator" >&#160;</span>
	                                    <div class="headerTitle" >旅客类别</div>
	                                </td>
	                                <td class="tableHeader" 
	                                onmouseover="this.className='tableHeaderOver';"  
	                                onmouseout="this.className='tableHeader';">
	                                    <span class="columnSeparator" >&#160;</span>
	                                    <div class="headerTitle" >证件类型</div>
	                                </td>
	                                <td class="tableHeader" 
	                                onmouseover="this.className='tableHeaderOver';"  
	                                onmouseout="this.className='tableHeader';">
	                                    <span class="columnSeparator" >&#160;</span>
	                                    <div class="headerTitle" >证件号</div>
	                                </td> 
                                    
	                            </tr>
	                        </thead> 
	                        <tbody>
	                        <s:iterator value="passengers" status="stat">
	                            <tr id="${psgId }" class="passengerRow" onclick="setPassengerBox(this)" >
	                                <td>${stat.count }</td>
	                                <td class="psgName">${psgName }</td>
	                                <td class="psgType">${psgType }</td>
	                                <td class="psgCertifType">${psgCertifType }</td>
	                                <td class="psgCertifNum">${psgCertifNum }</td>
									
	                            </tr>
	                        </s:iterator>
	                        </tbody>
                        </table>
                        <div id="ec_toolbar"  class="toolbar"> 
	                        <table id="ec_toolbarTable"  class="toolbarTable"  
	                        cellpadding="0"  cellspacing="0" >
	                            <tr>
	                                <td class="extendTool" >                             
                                        <input type="button" class="ipt thickbox"  id="addBtn" value="添加"
                                        alt="#TB_inline?height=296&width=400&inlineId=hidden-box-add&modal=true"/>
                                        <input type="button" class="ipt thickbox"  id="updateBtn"  value="修改"
                                        alt="#TB_inline?height=296&width=400&inlineId=hidden-box-add&modal=true"/>
                                        <input type="button" class="ipt" id="deleteBtn" value="删除"/>
                                    </td> 
                                    <td class="exportTool" ></td> 
                                    <td class="pageNavigationTool">
                                        <input type="button" onclick="changePage(1)"  class="pageNav firstPageD" title="第一页">
                                        <input type="button" onclick="changePage(${page-1 })" class="pageNav prevPageD"  title="上一页">
                                    </td>
                                    <td class="pageNavigationTool">
                                        <input type="button" onclick="changePage(${page+1 })"  class="pageNav nextPageD" title="下一页" >
                                        <input type="button" onclick="changePage(${totalPage })" class="pageNav lastPageD" title="最末页">
                                    </td> 
                                    <td class="pageJumpTool">
                                        <input type="button" id="jumpBtn"  class="pageNav jumpPage" >
                                        <input type="text"  value="${page }" id="jumpPageInput"  class="jumpPageInput">/${totalPage }页
                                    </td> 
                                    
                                </tr> 
	                        </table>
                        </div>                     
  	                </div>
               </div>
            </div>
            <!-- 底部版权信息开始-->
            <div class="clear"></div>
            <div id="footer">
                <div id="copyright">                   
                    <br>版权所有2007-2010北京首都航空有限公司海南易建科技股份有限公司
                    <a href="#" target="_self">mail to webmaster</a>&nbsp;&nbsp;
                    <a href="#">隐私条款</a> 
                    <a href="#">免责声明</a><br>
                    <a href="#">琼icp备08100707号</a> 
                </div>
            </div>
        </div>
        <div id="spring" class="backgroundimg"></div>
        <!--乘机人弹出框的div-->
        <div id="hidden-box-add" class="hidden-box" style="display:none;">
            <form action="updatePassenger.action" method="post" id="popBox">            
                <div class="popup-box">
                    <div class="popup-box-header">
                        <span>添加常用乘机人</span>
                        <a href="#" onclick="javascript:tb_remove();">
                            <img src="${pageContext.request.contextPath}/images/cross_grey_small.png" />
                        </a>
                    </div>
                    <div class="popup-box-content">
                        <div class="text-info">姓名：</div>
                        <div class="input-info">
                            <input id="psgName"  name="passenger.psgName" class="register" type="text" />
                            <span class="input-notification error" id="psgNameError"></span>
                        </div>
                        <div class="clear"></div>
                        <div class="text-info">旅客类别：</div>
                        <div class="input-info">
                            <select id="psgType"  name="passenger.psgType">
                                <option value="A">成人</option>
                                <option value="C">儿童</option>
                                <option value="I">婴儿</option>
                            </select>
                        </div>
                        <div class="clear"></div>
                        <div class="text-info">证件类别：</div>
                        <div class="input-info">
                            <select id="psgCertifType" name="passenger.psgCertifType">
                                <option>身份证</option>
                                <option>护照</option>
                                <option>其他证件</option>
                            </select>
                        </div>
                        <div class="clear"></div>
                        <div class="text-info">证件号：</div>
                        <div class="input-info">
                            <input id="psgCertifNum"  name="passenger.psgCertifNum" class="register" type="text" />
                            <span class="input-notification error" id="psgCertifNumError"></span>
                        </div>
                    </div>
                    <input type="hidden"  name="passenger.psgId" id="psgId">
                    <div class="popup-box-footer">
                        <input id="submitBtn" class="ipt" type="submit" value="提交" />
                        <input class="ipt" type="button" value="取消" 
                        onclick="javascript:tb_remove();" />
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>


