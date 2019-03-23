<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:iterator value="hots">
	<div class="Route">
         <div class="RouteDate">
         	<a href="findFlight?flightId=${fid }">${flDate}</a>
         	<input type="hidden" value="${fid }">
         </div>
         <div class="RouteLocale">
         	<a href="findFlight?flightId=${fid }">${fromCity}-${toCity}</a>
         </div>
         <div class="RoutePrice">
         	<a href="findFlight?flightId=${fid }">${currentDiscount}折</a>
         </div>
         <div class="RoutePrice">
         	<a href="findFlight?flightId=${fid }">￥${currentPrice}</a>
         </div>
   </div>
</s:iterator>
