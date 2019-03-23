           //显示及隐藏城市选择
            var inputCity = "";
            function showCities(ev ,inputId, page) {
      
                //记录要输入信息的文本框
                inputCity = inputId;
				//发送ajax请求，加载城市列表
				$.ajax({
						url: "getCities.action",
						type: "post",
						data: {"page":page},
						dataType: "json",
						success: function(data, textStatus) {
							$("#address_list").empty();
							//显示城市列表
							for(var i = 0; i < data.length; i++) {
								$("#address_list")
									.append($("<a>" 
										+ data[i].citySpellName +"<span>"
										+ data[i].cityName +"</span></a>")
									.attr("id", data[i].cityId)
									.data("cityId", data[i].cityId)
									.data("cityName", data[i].cityName)
									.click(function(){
										$('#cool_address').hide();
										var name = $(this).data("cityName");
										$("#"+inputCity).val(name);
										
									})
								);
							}
							//设置div位置
			                $("#cool_address").show();
			                //分页时不重新设置div位置
			                if(ev != null){}{
			                  var cityDiv = document.getElementById("cool_address");
			                  var mousePos = mouseCoords(ev);
			                  cityDiv.style.left = mousePos.x;
			                  cityDiv.style.top = mousePos.y;
			                }
						}
					});
            }
            
            //隐藏城市选择div
            function hiddenCities(){
            	$("#cool_address").hide();
            }
            
            //获取焦点坐标，(兼容IE和Firfox)
            function mouseCoords(ev1)
			{
				var ev = ev1 || window.event;
				if(ev.pageX || ev.pageY){
					return {x:ev.pageX, y:ev.pageY};
				}
				return {
						x:ev.clientX + document.body.scrollLeft - document.body.clientLeft,
						y:ev.clientY + document.body.scrollTop - document.body.clientTop
				};
			}

            
  
           //添加分页事件
           $(function(){
           	  $("a[name='page_num']").live("click",function(){
           	  	var pageNum = parseInt($(this).text());
           	  	showCities(null,inputCity,pageNum);
           	  });
           });
           //检查输入是否为null
           function checkNull(){
           		if($("#orgCity_m").val() == ""){
           			alert("出发地不能为空");
           			return false;
           		}else if($("#depcity_m").val() == ""){
           			alert("目的城市不能为空");
           			
           			return false;
           		}
           		
           		return true;
           }