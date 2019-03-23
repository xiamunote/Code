package com.tarena.tts.abs.vo;

import java.io.Serializable;
import java.util.Date;

public class Orderdetail02 implements Serializable {
	private static final long serialVersionUID = 7961387706714194883L;
	
	private Long orderId; //订单
	private String orderMoney; //订单总额
	private String orderDate; //订单日期
	private String orderDateLimit; //出票时限
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderDateLimit() {
		return orderDateLimit;
	}
	public void setOrderDateLimit(String orderDateLimit) {
		this.orderDateLimit = orderDateLimit;
	}
}
