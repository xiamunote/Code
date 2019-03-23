package com.tarena.tts.abs.entity;

import java.util.Date;

/**
 * 会员里程细节类
 * @author liangjq
 */

public class MileageDetail implements java.io.Serializable {

	// Fields

	private long mileageId;
	private Integer membId;
	private String mileageType;
	private String mileageDescribe;
	private Date stageDate;
	private Integer accountMileage;
	
		
	@Override
	public String toString() {
		return "mileageId: "+mileageId+"\n"
		+"membId: "+membId+"\n"
		+"mileageType: "+mileageType+"\n"
		+"mileageDescribe: "+mileageDescribe+"\n"
		+"stageDate: "+stageDate+"\n"
		+"accountMileage: "+accountMileage+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (mileageId ^ (mileageId >>> 32));
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
		final MileageDetail other = (MileageDetail) obj;
		if (mileageId != other.mileageId)
			return false;
		return true;
	}

	/**
	 * 里程编号（毫秒数）
	 * @ long getMileageId(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:09:18 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public long getMileageId() {
		return this.mileageId;
	}
	
	/**
	 * 里程编号（毫秒数）
	 * @ void setMileageId(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:10:12 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setMileageId(long mileageId) {
		this.mileageId = mileageId;
	}
	
	/**
	 * 会员编号_id
	 * @ Integer getMembId(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:10:21 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getMembId() {
		return this.membId;
	}
	
	/**
	 * 会员编号_id
	 * @ void setMembId(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:10:49 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setMembId(Integer membId) {
		this.membId = membId;
	}
	
	/**
	 * 里程类型：'航段里程','奖励里程','促销里程','消费里程','合作伙伴里程'
	 * @ String getMileageType(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:10:53 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getMileageType() {
		return this.mileageType;
	}
	
	/**
	 * 里程类型：'航段里程','奖励里程','促销里程','消费里程','合作伙伴里程'
	 * @ void setMileageType(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:11:08 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setMileageType(String mileageType) {
		this.mileageType = mileageType;
	}
	
	/**
	 * 里程描述，
	 * 如：'TL1202 北京（首都机场）-上海（虹桥机场）Y 舱’,'成功预订 三亚香格里拉饭店 标准大床房2晚'
	 * @ String getMileageDescribe(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:11:56 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getMileageDescribe() {
		return this.mileageDescribe;
	}
	
	/**
	 * 里程描述，
	 * 如：'TL1202 北京（首都机场）-上海（虹桥机场）Y 舱’,'成功预订 三亚香格里拉饭店 标准大床房2晚'
	 * @ void setMileageDescribe(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:12:35 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setMileageDescribe(String mileageDescribe) {
		this.mileageDescribe = mileageDescribe;
	}
	
	/**
	 * 里程日期
	 * @ Date getStageDate(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:13:09 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Date getStageDate() {
		return this.stageDate;
	}
	
	/**
	 * 里程日期
	 * @ void setStageDate(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:13:18 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setStageDate(Date stageDate) {
		this.stageDate = stageDate;
	}
	
	/**
	 * 累积航程
	 * @ Integer getAccountMileage(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:13:21 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getAccountMileage() {
		return this.accountMileage;
	}
	
	/**
	 * 累积航程
	 * @ void setAccountMileage(MileageDetail)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:13:29 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setAccountMileage(Integer accountMileage) {
		this.accountMileage = accountMileage;
	}

}