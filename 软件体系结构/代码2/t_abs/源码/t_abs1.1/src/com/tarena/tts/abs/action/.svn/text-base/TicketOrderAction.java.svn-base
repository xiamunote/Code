package com.tarena.tts.abs.action;

import java.util.Date;
import java.util.List;
import com.tarena.tts.abs.biz.OrderBiz;
import com.tarena.tts.abs.biz.impl.OrderBizImpl;
import com.tarena.tts.abs.entity.User;
import com.tarena.tts.abs.vo.TicketOrder01;

/**
 * @ file_name TicketOuerder01Action.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 24, 20126:25:03 PM
 * @ description
 * @ reviewed_by 
 */
public class TicketOrderAction extends BaseAction{
	
	//input
	private Long orderId_input;
	private Date orderDate1;
	private Date orderDate2;
	private String orderState_input;
	private String fromCity;
	private String toCity;
	
	//output
	private List<TicketOrder01> orderList;

	
	@Override
	public String execute() throws Exception {
		
		OrderBiz biz = new OrderBizImpl();
		
		User user = (User)session.get("user");
		
		orderList = biz.findMyOrders(
				orderId_input,
				orderDate1, 
				orderDate2, 
				"".equals(orderState_input)?null:orderState_input, 
				"".equals(fromCity)?null:fromCity, 
				"".equals(toCity)?null:toCity , 
				user.getUserId());		
		
		return "success";
	}

	
	public Long getOrderId_input() {
		return orderId_input;
	}
	public void setOrderId_input(Long orderId_input) {
		this.orderId_input = orderId_input;
	}
	public Date getOrderDate1() {
		return orderDate1;
	}
	public void setOrderDate1(Date orderDate1) {
		this.orderDate1 = orderDate1;
	}
	public Date getOrderDate2() {
		return orderDate2;
	}
	public void setOrderDate2(Date orderDate2) {
		this.orderDate2 = orderDate2;
	}
	public String getOrderState_input() {
		return orderState_input;
	}
	public void setOrderState_input(String orderState_input) {
		this.orderState_input = orderState_input;
	}

	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public List<TicketOrder01> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<TicketOrder01> orderList) {
		this.orderList = orderList;
	}

}
