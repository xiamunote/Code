package com.tarena.tts.abs.entity;

import java.util.Date;

/**
 * 机票类
 * @author liangjq
 */

public class Ticket implements java.io.Serializable {

	// Fields
	private long ticketId;
	private long orderId;
	private String flightNum;
	private Integer routeId;
	private Date departureDatetime;
	private Date arrivalDatatime;
	
//	private String departureTime;
//	private String arrivalTime;
	
	private int psgId;
	private String cabinClass;
	private Date ticketDate;
	private double ticketPrice;
	private double tax1Price;
	private double tax2Price;
	private double totalPrice;
	private Integer seatsOrder;
	private String changeState;
	private double refundTicketCharge;
	private String restrictions;
	private String agentInfo;
	private String paymentType;
	private String paymentRef;
	private long businessRecordId;
	private String terminalType;
	private String terminalIp;
	
		
	@Override
	public String toString() {
		return "ticketId: "+ticketId+"\n"
		+"flightNum: "+flightNum+"\n"
		+"routeId: "+routeId+"\n"
		+"departureDatetime: "+departureDatetime+"\n"
		+"arrivalDatatime: "+arrivalDatatime+"\n"
		+"psgId: "+psgId+"\n"
		+"cabinClass: "+cabinClass+"\n"
		+"ticketDate: "+ticketDate+"\n"
		+"ticketPrice: "+ticketPrice+"\n"
		+"tax1Price: "+tax1Price+"\n"
		+"tax2Price: "+tax2Price+"\n"
		+"totalPrice: "+totalPrice+"\n"
		+"seatsOrder: "+seatsOrder+"\n"
		+"changeState: "+changeState+"\n"
		+"refundTicketCharge: "+refundTicketCharge+"\n"
		+"restrictions: "+restrictions+"\n"
		+"agentInfo: "+agentInfo+"\n"
		+"paymentType: "+paymentType+"\n"
		+"paymentRef: "+paymentRef+"\n"
		+"businessRecordId: "+businessRecordId+"\n"
		+"terminalType: "+terminalType+"\n"
		+"terminalIp: "+terminalIp+"\n";
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ticketId ^ (ticketId >>> 32));
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
		final Ticket other = (Ticket) obj;
		if (ticketId != other.ticketId)
			return false;
		return true;
	}

	/**
	 * 机票编号(毫秒数)
	 * @ long getTicketId(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:24:44 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public long getTicketId() {
		return this.ticketId;
	}
	
	/**
	 * 机票编号(毫秒数)
	 * @ void setTicketId(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:25:04 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	
	/**
	 * 航班号
	 * @ String getFlightNum(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:25:09 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getFlightNum() {
		return this.flightNum;
	}
	
	/**
	 * 航班号
	 * @ void setFlightNum(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:25:35 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	
	/**
	 * 航线编号
	 * @ Integer getRouteId(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:25:40 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getRouteId() {
		return this.routeId;
	}
	
	/**
	 * 航线编号
	 * @ void setRouteId(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:25:48 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	
	

	public Date getDepartureDatetime() {
		return departureDatetime;
	}

	public void setDepartureDatetime(Date departureDatetime) {
		this.departureDatetime = departureDatetime;
	}

	public Date getArrivalDatatime() {
		return arrivalDatatime;
	}

	public void setArrivalDatatime(Date arrivalDatatime) {
		this.arrivalDatatime = arrivalDatatime;
	}

	/**
	 * 乘客ID
	 * @ int getPsgId(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:26:24 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public int getPsgId() {
		return this.psgId;
	}
	
	/**
	 * 乘客ID
	 * @ void setPsgId(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:26:33 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPsgId(int psgId) {
		this.psgId = psgId;
	}
	

	/**
	 * 舱位等级 'Y'
	 * @ String getCabinClass(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:26:53 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getCabinClass() {
		return this.cabinClass;
	}
	
	/**
	 * 舱位等级 'Y'
	 * @ void setCabinClass(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:27:03 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}
	
	/**
	 * 出票日期时间
	 * @ Date getTicketDate(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:27:09 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Date getTicketDate() {
		return this.ticketDate;
	}
	
	/**
	 * 出票日期时间
	 * @ void setTicketDate(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:27:19 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}
	
	/**
	 * 机票价格
	 * @ double getTicketPrice(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:27:25 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getTicketPrice() {
		return this.ticketPrice;
	}
	
	/**
	 * 机票价格
	 * @ void setTicketPrice(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:27:34 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	/**
	 * 机场税
	 * @ double getTax1Price(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:27:48 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getTax1Price() {
		return this.tax1Price;
	}
	
	/**
	 * 机场税
	 * @ void setTax1Price(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:27:56 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTax1Price(double tax1Price) {
		this.tax1Price = tax1Price;
	}
	
	/**
	 * 燃油税
	 * @ double getTax2Price(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:28:03 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getTax2Price() {
		return this.tax2Price;
	}
	
	/**
	 * 燃油税
	 * @ void setTax2Price(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:28:11 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTax2Price(double tax2Price) {
		this.tax2Price = tax2Price;
	}
	
	/**
	 * 机票总价格
	 * @ double getTotalPrice(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:28:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	/**
	 * 机票总价格
	 * @ void setTotalPrice(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:28:33 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * 订座顺序号: 76
	 * @ Integer getSeatsOrder(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:28:38 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getSeatsOrder() {
		return this.seatsOrder;
	}
	
	/**
	 * 订座顺序号: 76
	 * @ void setSeatsOrder(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:28:49 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setSeatsOrder(Integer seatsOrder) {
		this.seatsOrder = seatsOrder;
	}
	
	/**
	 * 改签状态(‘Y’：可改签‘N’：不可改签)
	 * @ String getChangeState(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:28:58 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getChangeState() {
		return this.changeState;
	}
	
	/**
	 * 改签状态(‘Y’：可改签‘N’：不可改签)
	 * @ void setChangeState(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:29:14 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setChangeState(String changeState) {
		this.changeState = changeState;
	}
	
	/**
	 * 退票手续费率
	 * @ double getRefundTicketCharge(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:29:20 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getRefundTicketCharge() {
		return this.refundTicketCharge;
	}
	
	/**
	 * 退票手续费率
	 * @ void setRefundTicketCharge(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:29:29 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRefundTicketCharge(double refundTicketCharge) {
		this.refundTicketCharge = refundTicketCharge;
	}
	
	/**
	 * 限制条件:'不可改签，退票收取30%手续费'
	 * @ String getRestrictions(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:29:35 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getRestrictions() {
		return this.restrictions;
	}
	
	/**
	 * 限制条件:'不可改签，退票收取30%手续费'
	 * @ void setRestrictions(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:29:49 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}
	
	/**
	 * 代理商信息
	 * @ String getAgentInfo(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:29:55 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getAgentInfo() {
		return this.agentInfo;
	}
	
	/**
	 * 代理商信息
	 * @ void setAgentInfo(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:30:04 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setAgentInfo(String agentInfo) {
		this.agentInfo = agentInfo;
	}
	
	/**
	 * 支付类型:'信用卡支付','现金支付','电话支付','网上转帐'
	 * @ String getPaymentType(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:30:10 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getPaymentType() {
		return this.paymentType;
	}
	
	/**
	 * 支付类型:'信用卡支付','现金支付','电话支付','网上转帐'
	 * @ void setPaymentType(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:43:56 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	/**
	 * 支付记录
	 * @ String getPaymentRef(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:44:04 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getPaymentRef() {
		return this.paymentRef;
	}
	
	/**
	 * 支付记录
	 * @ void setPaymentRef(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:44:14 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPaymentRef(String paymentRef) {
		this.paymentRef = paymentRef;
	}
	
	/**
	 * 营业记录
	 * @ long getBusinessRecordId(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:44:18 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public long getBusinessRecordId() {
		return this.businessRecordId;
	}
	
	/**
	 * 营业记录
	 * @ void setBusinessRecordId(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:44:39 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setBusinessRecordId(long businessRecordId) {
		this.businessRecordId = businessRecordId;
	}
	
	/**
	 * 终端类型编号: 
	 * 	'COU123' 柜员123; 
	 * 	'WEB001' web 001服务器, 
	 * 	'AGE123' 代理商123, 
	 * 	'CAC104'呼叫中心104
	 * @ String getTerminalType(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:44:43 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getTerminalType() {
		return this.terminalType;
	}
	
	/**
	 * 终端类型编号: 
	 * 	'COU123' 柜员123; 
	 * 	'WEB001' web 001服务器, 
	 * 	'AGE123' 代理商123, 
	 * 	'CAC104'呼叫中心104
	 * @ void setTerminalType(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:45:32 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}
	
	/**
	 * 终端IP
	 * @ String getTerminalIp(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:45:42 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getTerminalIp() {
		return this.terminalIp;
	}
	
	/**
	 * 终端IP
	 * @ void setTerminalIp(Ticket)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:45:52 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTerminalIp(String terminalIp) {
		this.terminalIp = terminalIp;
	}
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
}