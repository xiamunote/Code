package com.tarena.tts.abs.entity;

/**
 * 航线类
 * @author liangjq
 */

public class Route implements java.io.Serializable {

	// Fields

	private Integer routeId;
	private Integer fromAirportId;
	private Integer toAirportId;
	private Integer routeDistance;
	private double routeBasePrice;
	private Integer returnRouteId;
	private Integer flightNumPerWeek;
		
	@Override
	public String toString() {
		return "routeId: "+routeId+"\n"
		+"fromAirportId: "+fromAirportId+"\n"
		+"toAirportId: "+toAirportId+"\n"
		+"routeDistance: "+routeDistance+"\n"
		+"routeBasePrice: "+routeBasePrice+"\n"
		+"returnRouteId: "+returnRouteId+"\n"
		+"flightNumPerWeek: "+flightNumPerWeek+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeId == null) ? 0 : routeId.hashCode());
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
		final Route other = (Route) obj;
		if (routeId == null) {
			if (other.routeId != null)
				return false;
		} else if (!routeId.equals(other.routeId))
			return false;
		return true;
	}

	/**
	 * 航线编号
	 * @ Integer getRouteId(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:43:51 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getRouteId() {
		return this.routeId;
	}
	
	/**
	 * 航线编号
	 * @ void setRouteId(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:44:05 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	
	/**
	 * 航线出发机场
	 * @ Integer getFromAirportId(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:44:10 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getFromAirportId() {
		return this.fromAirportId;
	}
	
	/**
	 * 航线出发机场
	 * @ void setFromAirportId(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:44:47 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFromAirportId(Integer fromAirportId) {
		this.fromAirportId = fromAirportId;
	}
	
	/**
	 * 航线到达机场
	 * @ Integer getToAirportId(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:44:52 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getToAirportId() {
		return this.toAirportId;
	}
	
	/**
	 * 航线到达机场
	 * @ void setToAirportId(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:45:00 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setToAirportId(Integer toAirportId) {
		this.toAirportId = toAirportId;
	}
	
	/**
	 * 航线距离
	 * @ Integer getRouteDistance(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:45:09 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getRouteDistance() {
		return this.routeDistance;
	}
	
	/**
	 * 航线距离
	 * @ void setRouteDistance(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:45:23 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRouteDistance(Integer routeDistance) {
		this.routeDistance = routeDistance;
	}
	
	/**
	 * 航线基准价格=航线距离*0.75
	 * @ double getRouteBasePrice(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:47:30 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getRouteBasePrice() {
		return this.routeBasePrice;
	}
	
	/**
	 * 航线基准价格=航线距离*0.75
	 * @ void setRouteBasePrice(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:48:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRouteBasePrice(double routeBasePrice) {
		this.routeBasePrice = routeBasePrice;
	}
	
	/**
	 * 返程航线编号
	 * @ Integer getReturnRouteId(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:49:25 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getReturnRouteId() {
		return this.returnRouteId;
	}
	
	/**
	 * 返程航线编号
	 * @ void setReturnRouteId(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:49:30 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setReturnRouteId(Integer returnRouteId) {
		this.returnRouteId = returnRouteId;
	}
	
	/**
	 * 该航线每周航班数
	 * @ Integer getFlightNumPerWeek(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:49:39 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getFlightNumPerWeek() {
		return this.flightNumPerWeek;
	}
	
	/**
	 * 该航线每周航班数
	 * @ void setFlightNumPerWeek(Route)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:49:43 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFlightNumPerWeek(Integer flightNumPerWeek) {
		this.flightNumPerWeek = flightNumPerWeek;
	}
}