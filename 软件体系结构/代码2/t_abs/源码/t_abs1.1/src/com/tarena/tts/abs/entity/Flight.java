package com.tarena.tts.abs.entity;

import java.util.Date;

/**
 * 航班类
 * @author liangjq
 */

public class Flight implements java.io.Serializable {

	// Fields
	private String flightId;
	private String flightNum;
	private Date flDepartureDate;
	private Date flArrivalDate;
	private Integer routeId;
	private Integer planeId;
	private Integer fseatsRemain;
	private Integer bseatsRemain;
	private Integer eseatsRemain;
	private String currentClasses;
	private double fullPrice;
	private double currentDiscount;
	private double currentPrice;
	private double tax1Price;
	private double tax2Price;
	private Integer currentOrder;
	
	@Override
	public String toString() {
		return "flightId: "+flightId + "\n"
		+"flightNum: "+flightNum+ "\n"
		+"flDepartureDate: "+flDepartureDate+ "\n"
		+"flArrivalDate: "+flArrivalDate+ "\n"
		+"routeId: "+routeId+ "\n"
		+"planeId: "+planeId+ "\n"
		+"FSeatsRemain: "+fseatsRemain+ "\n"
		+"BSeatsRemain: "+bseatsRemain+ "\n"
		+"ESeatsRemain: "+eseatsRemain+ "\n"
		+"currentClasses: "+currentClasses+ "\n"
		+"fullPrice: "+fullPrice+ "\n"
		+"currentDiscount: "+currentDiscount+ "\n"
		+"currentPrice: "+currentPrice+ "\n"
		+"tax1Price: "+tax1Price+ "\n"
		+"tax2Price: "+tax2Price+"\n"
		+"currentOrder: "+currentOrder+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((flightId == null) ? 0 : flightId.hashCode());
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
		final Flight other = (Flight) obj;
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		return true;
	}

	/**
	 * 航班编号 'N201008251202' '类型-年-月-日-航班号'
	 * @ String getFlightId(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:04:12 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getFlightId() {
		return this.flightId;
	}
	
	/**
	 * 航班编号 'N201008251202' '类型-年-月-日-航班号'
	 * @ void setFlightId(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:04:27 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	
	/**
	 * 航班编号:TL1202
	 * @ String getFlightNum(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:04:33 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getFlightNum() {
		return this.flightNum;
	}
	
	/**
	 * 航班编号:TL1202
	 * @ void setFlightNum(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:04:45 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	
	/**
	 * 航班起飞时间
	 * @ Date getFlDepartureDate(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:04:49 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Date getFlDepartureDate() {
		return this.flDepartureDate;
	}
	
	/**
	 * 航班起飞时间
	 * @ void setFlDepartureDate(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:04:58 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFlDepartureDate(Date flDepartureDate) {
		this.flDepartureDate = flDepartureDate;
	}
	
	/**
	 * 航班到达时间
	 * @ Date getFlArrivalDate(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:05:03 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Date getFlArrivalDate() {
		return this.flArrivalDate;
	}
	
	/**
	 * 航班到达时间
	 * @ void setFlArrivalDate(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:05:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFlArrivalDate(Date flArrivalDate) {
		this.flArrivalDate = flArrivalDate;
	}
	
	/**
	 * 执行航线编号
	 * @ Integer getRouteId(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:05:22 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getRouteId() {
		return this.routeId;
	}
	
	/**
	 * 执行航线编号
	 * @ void setRouteId(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:05:50 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	
	/**
	 * 执行飞机编号
	 * @ Integer getPlaneId(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:05:55 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getPlaneId() {
		return this.planeId;
	}
	
	/**
	 * 执行飞机编号
	 * @ void setPlaneId(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:06:03 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPlaneId(Integer planeId) {
		this.planeId = planeId;
	}
	
	/**
	 * 头等舱剩余座位数
	 * @ Integer getFSeatsRemain(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:06:08 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getFseatsRemain() {
		return this.fseatsRemain;
	}
	
	/**
	 * 头等舱剩余座位数
	 * @ void setFSeatsRemain(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:06:27 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFseatsRemain(Integer fseatsRemain) {
		this.fseatsRemain = fseatsRemain;
	}
	
	/**
	 * 公务舱剩余座位
	 * @ Integer getBSeatsRemain(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:06:32 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getBseatsRemain() {
		return this.bseatsRemain;
	}
	
	/**
	 * 公务舱剩余座位
	 * @ void setBSeatsRemain(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:06:40 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setBseatsRemain(Integer bseatsRemain) {
		this.bseatsRemain = bseatsRemain;
	}
	
	/**
	 * 经济舱剩余座位
	 * @ Integer getESeatsRemain(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:06:46 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getEseatsRemain() {
		return this.eseatsRemain;
	}
	
	/**
	 * 经济舱剩余座位
	 * @ void setESeatsRemain(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:06:56 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setEseatsRemain(Integer eseatsRemain) {
		this.eseatsRemain = eseatsRemain;
	}
	
	/**
	 * 当前可选舱位代码:'F,Y,B,C,Q,U'
	 * @ String getCurrentClasses(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:07:00 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getCurrentClasses() {
		return this.currentClasses;
	}
	
	/**
	 * 当前可选舱位代码:'F,Y,B,C,Q,U'
	 * @ void setCurrentClasses(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:07:21 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCurrentClasses(String currentClasses) {
		this.currentClasses = currentClasses;
	}
	
	/**
	 * 经济舱全价
	 * @ double getFullPrice(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:07:26 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getFullPrice() {
		return this.fullPrice;
	}
	
	/**
	 * 经济舱全价
	 * @ void setFullPrice(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:07:35 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFullPrice(double fullPrice) {
		this.fullPrice = fullPrice;
	}
	
	/**
	 * 当前最低舱位折扣
	 * @ double getCurrentDiscount(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:07:39 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getCurrentDiscount() {
		return this.currentDiscount;
	}
	
	/**
	 * 当前最低舱位折扣
	 * @ void setCurrentDiscount(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:07:49 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCurrentDiscount(double currentDiscount) {
		this.currentDiscount = currentDiscount;
	}
	
	/**
	 * 当前最低价格
	 * @ double getCurrentPrice(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:07:56 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getCurrentPrice() {
		return this.currentPrice;
	}
	
	/**
	 * 当前最低价格
	 * @ void setCurrentPrice(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:08:04 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	/**
	 * 机场税
	 * @ double getTax1Price(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:08:09 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getTax1Price() {
		return this.tax1Price;
	}
	
	/**
	 * 机场税
	 * @ void setTax1Price(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:08:17 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTax1Price(double tax1Price) {
		this.tax1Price = tax1Price;
	}
	
	/**
	 * 燃油税
	 * @ double getTax2Price(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:08:23 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getTax2Price() {
		return this.tax2Price;
	}
	
	/**
	 * 燃油税
	 * @ void setTax2Price(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:08:30 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTax2Price(double tax2Price) {
		this.tax2Price = tax2Price;
	}
	
	/**
	 * 当前出票次序
	 * @ Integer getCurrentOrder(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:08:36 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getCurrentOrder() {
		return this.currentOrder;
	}
	
	/**
	 * 当前出票次序
	 * @ void setCurrentOrder(Flight)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:08:47 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCurrentOrder(Integer currentOrder) {
		this.currentOrder = currentOrder;
	}

}