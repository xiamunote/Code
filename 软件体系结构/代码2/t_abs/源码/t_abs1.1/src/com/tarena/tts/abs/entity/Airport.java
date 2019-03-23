package com.tarena.tts.abs.entity;

/**
 * 机场类 
 * @author liangjq
 */

public class Airport implements java.io.Serializable {

	
	private Integer airportId;
	private String airportName;
	private Integer provinceId;
	private Integer cityId;
	private String airportFullName;
	private String airportCode;
	private Integer departureRoutesNum;
	private Integer arrivalRoutesNum;
	private String airportGrand;
	private Integer departureFlightNumPerWeek;
	private Integer arrivalFlightNumPerWeek;
	
	
	
	@Override
	public String toString() {
		return "airportId: "+airportId+"\n"
			+"airportName: "+airportName+"\n"
			+"provinceId: "+provinceId+"\n"
			+"cityId: "+cityId+"\n"
			+"airportFullName: "+airportFullName+"\n"
			+"airportCode: "+airportCode+"\n"
			+"departureRoutesNum: "+departureRoutesNum+"\n"
			+"arrivalRoutesNum: "+arrivalRoutesNum+"\n"
			+"airportGrand: "+airportGrand+"\n"
			+"departureFlightNumPerWeek: "+departureFlightNumPerWeek+"\n"
			+"arrivalFlightNumPerWeek: "+arrivalFlightNumPerWeek+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((airportId == null) ? 0 : airportId.hashCode());
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
		final Airport other = (Airport) obj;
		if (airportId == null) {
			if (other.airportId != null)
				return false;
		} else if (!airportId.equals(other.airportId))
			return false;
		return true;
	}

	/**
	 * 机场编号
	 * @ Integer getAirportId(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:33:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getAirportId() {
		return this.airportId;
	}
	
	/**
	 * 机场编号
	 * @ void setAirportId(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:33:27 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setAirportId(Integer airportId) {
		this.airportId = airportId;
	}
	
	/**
	 * 机场名称，如：首都机场
	 * @ String getAirportName(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:33:32 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getAirportName() {
		return this.airportName;
	}
	
	/**
	 * 机场名称，如：首都机场
	 * @ void setAirportName(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:34:03 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	
	/**
	 * 机场所属省份
	 * @ Integer getProvinceId(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:34:08 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getProvinceId() {
		return this.provinceId;
	}
	
	/**
	 * 机场所属省份
	 * @ void setProvinceId(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:34:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	/**
	 * 机场所属城市
	 * @ Integer getCityId(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:34:21 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getCityId() {
		return this.cityId;
	}
	
	/**
	 * 机场所属城市
	 * @ void setCityId(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:34:42 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	/**
	 * 机场全名，如：北京-首都机场
	 * @ String getAirportFullName(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:34:46 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getAirportFullName() {
		return this.airportFullName;
	}

	/**
	 * 机场全名，如：北京-首都机场
	 * @ void setAirportFullName(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:35:01 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setAirportFullName(String airportFullName) {
		this.airportFullName = airportFullName;
	}
	
	/**
	 * 机场代码(三字码)
	 * @ String getAirportCode(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:35:29 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getAirportCode() {
		return this.airportCode;
	}
	
	/**
	 * 机场代码(三字码)
	 * @ void setAirportCode(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:35:33 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	
	/**
	 * 出发航线条数
	 * @ Integer getDepartureRoutesNum(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:35:38 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getDepartureRoutesNum() {
		return this.departureRoutesNum;
	}
	
	/**
	 * 出发航线条数
	 * @ void setDepartureRoutesNum(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:35:50 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setDepartureRoutesNum(Integer departureRoutesNum) {
		this.departureRoutesNum = departureRoutesNum;
	}
	
	/**
	 * 到达航线条数
	 * @ Integer getArrivalRoutesNum(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:35:55 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getArrivalRoutesNum() {
		return this.arrivalRoutesNum;
	}

	/**
	 * 到达航线条数
	 * @ void setArrivalRoutesNum(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:36:05 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setArrivalRoutesNum(Integer arrivalRoutesNum) {
		this.arrivalRoutesNum = arrivalRoutesNum;
	}
	
	/**
	 * 机场等级： '4E','4D',...
	 * @ String getAirportGrand(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:36:20 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getAirportGrand() {
		return this.airportGrand;
	}
	
	/**
	 * 机场等级： '4E','4D',...
	 * @ void setAirportGrand(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:36:47 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setAirportGrand(String airportGrand) {
		this.airportGrand = airportGrand;
	}
	
	/**
	 * 每周离港航班数
	 * @ Integer getDepartureFlightNumPerWeek(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:36:59 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getDepartureFlightNumPerWeek() {
		return this.departureFlightNumPerWeek;
	}
	
	/**
	 * 每周离港航班数
	 * @ void setDepartureFlightNumPerWeek(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:37:03 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setDepartureFlightNumPerWeek(Integer departureFlightNumPerWeek) {
		this.departureFlightNumPerWeek = departureFlightNumPerWeek;
	}
	
	/**
	 * 每周到港航班数
	 * @ Integer getArrivalFlightNumPerWeek(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:37:07 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getArrivalFlightNumPerWeek() {
		return this.arrivalFlightNumPerWeek;
	}
	
	/**
	 * 每周到港航班数
	 * @ void setArrivalFlightNumPerWeek(Airport)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:37:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setArrivalFlightNumPerWeek(Integer arrivalFlightNumPerWeek) {
		this.arrivalFlightNumPerWeek = arrivalFlightNumPerWeek;
	}
}