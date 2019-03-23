package com.tarena.tts.abs.entity;

/**
 * 城市类
 * @author liangjq
 */

public class City implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private String cityName;
	private Integer provinceId;
	private String citySpellName;
	
	@Override
	public String toString() {
		return "cityId: "+cityId+"\n"
			+"cityName: "+cityName+"\n"
			+"provinceId: "+provinceId+"\n"
			+"citySpellName: "+citySpellName+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
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
		final City other = (City) obj;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		return true;
	}

	/**
	 * 城市编号
	 * @ Integer getCityId(City)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:51:04 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getCityId() {
		return this.cityId;
	}
	
	/**
	 * 城市编号
	 * @ void setCityId(City)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:51:13 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	/**
	 * 城市名称
	 * @ String getCityName(City)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:51:18 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getCityName() {
		return this.cityName;
	}
	
	/**
	 * 城市名称
	 * @ void setCityName(City)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:51:25 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	/**
	 * 所属省份
	 * @ Integer getProvinceId(City)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:51:30 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getProvinceId() {
		return this.provinceId;
	}
	
	/**
	 * 所属省份
	 * @ void setProvinceId(City)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:51:42 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	/**
	 * 城市拼音
	 * @ String getCitySpellName(City)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:51:47 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getCitySpellName() {
		return this.citySpellName;
	}
	
	/**
	 * 城市拼音
	 * @ void setCitySpellName(City)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:51:55 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCitySpellName(String citySpellName) {
		this.citySpellName = citySpellName;
	}
}