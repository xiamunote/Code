package com.tarena.tts.abs.entity;

import java.util.Date;

/**
 * 机票订单类
 * @author liangjq
 */

public class TicketOrder implements java.io.Serializable {

	// Fields
	private long orderId;
	private Integer userId;
	private double orderMoney;
	private Date orderDate;
	private String orderState;
	private String paymentRecord;
	private String flightId;
	private String cabinClass;
	
	
	
	@Override
	public String toString() {
		return "orderId: "+orderId+"\n"
		+"userId: "+userId+"\n"
		+"orderMoney: "+orderMoney+"\n"
		+"orderDate: "+orderDate+"\n"
		+"orderState: "+orderState+"\n"
		+"paymentRecord: "+paymentRecord+"\n"
		+"flightId: "+flightId+"\n"
		+"cabinClass: "+cabinClass+"\n";
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
		final TicketOrder other = (TicketOrder) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}

	/**
	 * 订单编号(毫秒数)
	 * @ long getOrderId(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:15:47 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public long getOrderId() {
		return this.orderId;
	}
	
	/**
	 * 订单编号(毫秒数)
	 * @ void setOrderId(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:19:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * 用户编号
	 * @ Integer getUserId(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:19:20 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getUserId() {
		return this.userId;
	}
	
	/**
	 * 用户编号
	 * @ void setUserId(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:19:28 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * 订单金额
	 * @ double getOrderMoney(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:19:32 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getOrderMoney() {
		return this.orderMoney;
	}
	
	/**
	 * 订单金额
	 * @ void setOrderMoney(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:19:41 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setOrderMoney(double orderMoney) {
		this.orderMoney = orderMoney;
	}
	
	/**
	 * 预订日期
	 * @ Date getOrderDate(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:19:45 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Date getOrderDate() {
		return this.orderDate;
	}
	
	/**
	 * 预订日期
	 * @ void setOrderDate(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:19:55 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	/**
	 * 订单状态 ‘等待支付（E）’，‘取消（C）’，‘失效（D）’，‘已支付（P）’
	 * @ String getOrderState(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:19:59 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getOrderState() {
		return this.orderState;
	}
	
	/**
	 * 订单状态 ‘等待支付（E）’，‘取消（C）’，‘失效（D）’，‘已支付（P）’
	 * @ void setOrderState(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:20:13 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	
	/**
	 * 支付记录，如：‘信用卡支付 ’
	 * @ String getPaymentRecord(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:20:19 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getPaymentRecord() {
		return this.paymentRecord;
	}
	
	/**
	 * 支付记录，如：‘信用卡支付 ’
	 * @ void setPaymentRecord(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:20:48 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPaymentRecord(String paymentRecord) {
		this.paymentRecord = paymentRecord;
	}
	
	/**
	 * 航班编号
	 * @ String getFlightId(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:20:59 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getFlightId() {
		return this.flightId;
	}
	
	/**
	 * 航班编号
	 * @ void setFlightId(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:21:23 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	
	/**
	 * 舱位
	 * @ String getCabinClass(TicketOrder)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 30, 20123:43:07 PM
	 * @ description
	 * f表示	头等舱
	 * c表示	公务舱
	 * y表示	经济舱 
	 * @ reviewed_by
	 */
	public String getCabinClass() {
		
//		if("f".equals(cabinClass))
//			return "头等舱";
//		if("c".equals(cabinClass))
//			return "公务舱";
//		if("y".equals(cabinClass))
//			return "经济舱";
		
		return cabinClass;
	}
	
	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}

}