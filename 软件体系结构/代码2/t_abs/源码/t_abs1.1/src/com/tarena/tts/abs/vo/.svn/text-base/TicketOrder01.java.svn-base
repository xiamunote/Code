package com.tarena.tts.abs.vo;

import java.util.Date;

/**
 * @ file_name Order01.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 24, 20123:45:34 PM
 * @ description
 * @ reviewed_by 
 */
public class TicketOrder01 {
	
	private long orderId;		//订单号
	private String flightNum;	//航班编号
	private String flDate;		//航班日期
	private String flTime;		//起飞时间
	private Integer seatsOrder;	//订座编码
	private double totalPrice;	//订单总额(机票价格+燃油税+机场建设税)
	private String orderState;	//订单状态
	private Date orderDate;		//订票时间

	@Override
	public String toString() {
		return "orderId:" + orderId + "\n" +
		"flightNum:" + flightNum + "\n" +
		"flDate:" + flDate + "\n" +
		"flTime:" + flTime + "\n"+
		"seatsOrder:" + seatsOrder + "\n"+
		"totalPrice:" + totalPrice + "\n"+
		"orderState:" + orderState + "\n"+
		"orderDate:" + orderDate + "\n";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TicketOrder01 other = (TicketOrder01) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public String getFlDate() {
		return flDate;
	}
	public void setFlDate(String flDate) {
		this.flDate = flDate;
	}
	public String getFlTime() {
		return flTime;
	}
	public void setFlTime(String flTime) {
		this.flTime = flTime;
	}
	public Integer getSeatsOrder() {
		return seatsOrder;
	}
	public void setSeatsOrder(Integer seatsOrder) {
		this.seatsOrder = seatsOrder;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
