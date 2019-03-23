package com.tarena.tts.abs.entity;

/**
 * 舱位等级类
 * @author liangjq
 */

public class CabinClass implements java.io.Serializable {

	// Fields

	private Integer cabinClassId;
	private String cabinClassName;
	private String cabinClassChar;
	private double refundCharge;
	private String limitCondition;
	private double cabinDiscount;
	private String planeCabinType;
	private double mileageFactor;

	@Override
	public String toString() {
		return "cabinClassId: "+cabinClassId+"\n"
			+"cabinClassName: "+cabinClassName+"\n"
			+"cabinClassChar: "+cabinClassChar+"\n"
			+"refundCharge: "+refundCharge+"\n"
			+"limitCondition: "+limitCondition+"\n"
			+"cabinDiscount: "+cabinDiscount+"\n"
			+"planeCabinType: "+planeCabinType+"\n"
			+"mileageFactor: "+mileageFactor+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cabinClassId == null) ? 0 : cabinClassId.hashCode());
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
		final CabinClass other = (CabinClass) obj;
		if (cabinClassId == null) {
			if (other.cabinClassId != null)
				return false;
		} else if (!cabinClassId.equals(other.cabinClassId))
			return false;
		return true;
	}

	/**
	 * 舱位等级编号
	 * @ Integer getCabinClassId(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:56:23 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getCabinClassId() {
		return this.cabinClassId;
	}
	
	/**
	 * 舱位等级编号
	 * @ void setCabinClassId(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:56:34 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCabinClassId(Integer cabinClassId) {
		this.cabinClassId = cabinClassId;
	}
	
	/**
	 * 舱位等级名称
	 * @ String getCabinClassName(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:56:39 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getCabinClassName() {
		return this.cabinClassName;
	}
	
	/**
	 * 舱位等级名称
	 * @ void setCabinClassName(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:57:00 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCabinClassName(String cabinClassName) {
		this.cabinClassName = cabinClassName;
	}
	
	/**
	 * 舱位等级字符：'Y',X',B','F','C',......
	 * @ String getCabinClassChar(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:57:05 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getCabinClassChar() {
		return this.cabinClassChar;
	}
	
	/**
	 * 舱位等级字符：'Y',X',B','F','C',......
	 * @ void setCabinClassChar(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:57:18 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCabinClassChar(String cabinClassChar) {
		this.cabinClassChar = cabinClassChar;
	}
	
	/**
	 * 退票手续费规定
	 * @ double getRefundCharge(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:57:23 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getRefundCharge() {
		return this.refundCharge;
	}
	
	/**
	 * 退票手续费规定
	 * @ void setRefundCharge(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:57:44 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRefundCharge(double refundCharge) {
		this.refundCharge = refundCharge;
	}
	
	/**
	 * 限制条件：‘TGZ’ 代表：可退，可改期，可签转
	 * @ String getLimitCondition(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:57:50 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getLimitCondition() {
		return this.limitCondition;
	}
	
	/**
	 * 限制条件：‘TGZ’ 代表：可退，可改期，可签转
	 * @ void setLimitCondition(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:58:11 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setLimitCondition(String limitCondition) {
		this.limitCondition = limitCondition;
	}
	
	/**
	 * 舱位折扣
	 * @ double getCabinDiscount(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:58:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getCabinDiscount() {
		return this.cabinDiscount;
	}
	
	/**
	 * 舱位折扣
	 * @ void setCabinDiscount(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:58:25 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCabinDiscount(double cabinDiscount) {
		this.cabinDiscount = cabinDiscount;
	}
	
	/**
	 * 飞机舱位类型：'F','C','Y'
	 * @ String getPlaneCabinType(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:58:30 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getPlaneCabinType() {
		return this.planeCabinType;
	}
	
	/**
	 * 飞机舱位类型：'F','C','Y'
	 * @ void setPlaneCabinType(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:58:40 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPlaneCabinType(String planeCabinType) {
		this.planeCabinType = planeCabinType;
	}
	
	/**
	 * 里程积累系数
	 * @ double getMileageFactor(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:58:47 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getMileageFactor() {
		return this.mileageFactor;
	}

	/**
	 * 里程积累系数
	 * @ void setMileageFactor(CabinClass)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:59:03 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setMileageFactor(double mileageFactor) {
		this.mileageFactor = mileageFactor;
	}

}