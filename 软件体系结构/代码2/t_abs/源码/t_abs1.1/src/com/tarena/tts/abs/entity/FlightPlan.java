package com.tarena.tts.abs.entity;

import java.util.Date;

/**
 * 航班计划类
 * @author liangjq
 */

public class FlightPlan implements java.io.Serializable {

	// Fields

	private Integer fpId;
	private String flightNum;
	private Date fpStartDate;
	private Date fpEndDate;
	private Integer routeId;
	private String fpDepartureTime;
	private String fpArrivalTime;
	private Integer fpScheduler;
	private double fpBasePrice;
	
		
	@Override
	public String toString() {
		return "fpId: "+fpId+"\n"
		+"flightNum: "+flightNum+"\n"
		+"fpStartDate: "+fpStartDate+"\n"
		+"fpEndDate: "+fpEndDate+"\n"
		+"routeId: "+routeId+"\n"
		+"fpDepartureTime: "+fpDepartureTime+"\n"
		+"fpArrivalTime: "+fpArrivalTime+"\n"
		+"fpScheduler: "+fpScheduler+"\n"
		+"fpBasePrice: "+fpBasePrice+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fpId == null) ? 0 : fpId.hashCode());
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
		final FlightPlan other = (FlightPlan) obj;
		if (fpId == null) {
			if (other.fpId != null)
				return false;
		} else if (!fpId.equals(other.fpId))
			return false;
		return true;
	}

	/**
	 * 航班计划编号
	 * @ Integer getFpId(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:00:25 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getFpId() {
		return this.fpId;
	}
	
	/**
	 * 航班计划编号
	 * @ void setFpId(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:00:34 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFpId(Integer fpId) {
		this.fpId = fpId;
	}
	
	/**
	 * 航班编号，如:TL1202
	 * @ String getFlightNum(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:00:38 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getFlightNum() {
		return this.flightNum;
	}
	
	/**
	 * 航班编号，如:TL1202
	 * @ void setFlightNum(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:00:58 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	
	/**
	 * 航班计划开始日期
	 * @ Date getFpStartDate(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:01:03 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Date getFpStartDate() {
		return this.fpStartDate;
	}
	
	/**
	 * 航班计划开始日期
	 * @ void setFpStartDate(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:01:11 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFpStartDate(Date fpStartDate) {
		this.fpStartDate = fpStartDate;
	}
	
	/**
	 * 航班计划结束日期
	 * @ Date getFpEndDate(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:01:14 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Date getFpEndDate() {
		return this.fpEndDate;
	}
	
	/**
	 * 航班计划结束日期
	 * @ void setFpEndDate(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:01:23 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFpEndDate(Date fpEndDate) {
		this.fpEndDate = fpEndDate;
	}
	
	/**
	 * 执行航线编号
	 * @ Integer getRouteId(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:01:27 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getRouteId() {
		return this.routeId;
	}
	
	/**
	 * 执行航线编号
	 * @ void setRouteId(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:01:36 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	
	/**
	 * 起飞时刻，如:'23:10'
	 * @ String getFpDepartureTime(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:01:50 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getFpDepartureTime() {
		return this.fpDepartureTime;
	}
	
	/**
	 * 起飞时刻，如:'23:10'
	 * @ void setFpDepartureTime(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:01:57 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFpDepartureTime(String fpDepartureTime) {
		this.fpDepartureTime = fpDepartureTime;
	}
	
	/**
	 * 到达时刻，如:'N01:25' (N代表下一天)
	 * @ String getFpArrivalTime(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:02:03 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getFpArrivalTime() {
		return this.fpArrivalTime;
	}
	
	/**
	 * 到达时刻，如:'N01:25' (N代表下一天)
	 * @ void setFpArrivalTime(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:02:19 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFpArrivalTime(String fpArrivalTime) {
		this.fpArrivalTime = fpArrivalTime;
	}
	
	/**
	 * 航班班期
	 * @ Integer getFpScheduler(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:02:25 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getFpScheduler() {
		return this.fpScheduler;
	}
	
	/**
	 * 航班班期
	 * @ void setFpScheduler(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:02:50 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFpScheduler(Integer fpScheduler) {
		this.fpScheduler = fpScheduler;
	}
	
	/**
	 * 航班基准票价, 在航线基准票价基础上上下25%浮动。
	 * @ double getFpBasePrice(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:02:54 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getFpBasePrice() {
		return this.fpBasePrice;
	}
	
	/**
	 * 航班基准票价, 在航线基准票价基础上上下25%浮动。
	 * @ void setFpBasePrice(FlightPlan)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:03:05 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFpBasePrice(double fpBasePrice) {
		this.fpBasePrice = fpBasePrice;
	}

}