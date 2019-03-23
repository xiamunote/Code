package com.tarena.tts.abs.entity;

/**
 * 乘客类
 * @author liangjq
 */

public class Passenger implements java.io.Serializable {

	// Fields
	private Integer psgId;
	private String psgName;
	private String psgCertifType;
	private String psgCertifNum;
	private String psgType;
	private Integer refMembId;
	private Integer refUserId;
			
	@Override
	public String toString() {
		return "psgId: "+psgId+"\n"
		+"psgName: "+psgName+"\n"
		+"psgCertifType: "+psgCertifType+"\n"
		+"psgCertifNum: "+psgCertifNum+"\n"
		+"psgType: "+psgType+"\n"
		+"refMembId: "+refMembId+"\n"
		+"refUserId: "+refUserId+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((psgId == null) ? 0 : psgId.hashCode());
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
		final Passenger other = (Passenger) obj;
		if (psgId == null) {
			if (other.psgId != null)
				return false;
		} else if (!psgId.equals(other.psgId))
			return false;
		return true;
	}

	/**
	 * 乘客编号
	 * @ Integer getPsgId(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:26:16 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getPsgId() {
		return this.psgId;
	}
	
	/**
	 * 乘客编号
	 * @ void setPsgId(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:26:21 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPsgId(Integer psgId) {
		this.psgId = psgId;
	}
	
	/**
	 * 乘客姓名
	 * @ String getPsgName(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:26:25 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getPsgName() {
		return this.psgName;
	}
	
	/**
	 * 乘客姓名
	 * @ void setPsgName(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:26:36 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPsgName(String psgName) {
		this.psgName = psgName;
	}
	
	/**
	 * 乘客证件类型
	 * @ String getPsgCertifType(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:26:40 PM
	 * @ description
	 * 	身份证：NI		
	 * 	有效证件：PP		
	 * 	军官证：JG		
	 * 	其它：ID 
	 * @ reviewed_by
	 */
	public String getPsgCertifType() {
//		if("NI".equals(psgCertifType)){
//			return "身份证";
//		}
//		if("PP".equals(psgCertifType)){
//			return "有效证件";
//		}
//		if("JG".equals(psgCertifType)){
//			return "军官证";
//		}	
//		if("ID".equals(psgCertifType)){
//			return "其它";
//		}
		return this.psgCertifType;
	}
	
	/**
	 * 乘客证件类型
	 * @ void setPsgCertifType(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:26:49 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPsgCertifType(String psgCertifType) {
		
		this.psgCertifType = psgCertifType;
	}
	
	/**
	 * 乘客证件号码
	 * @ String getPsgCertifNum(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:26:54 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getPsgCertifNum() {
		return this.psgCertifNum;
	}
	
	/**
	 * 乘客证件号码
	 * @ void setPsgCertifNum(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:27:05 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPsgCertifNum(String psgCertifNum) {
		this.psgCertifNum = psgCertifNum;
	}
	
	/**
	 * 乘客类型 A：成人  C：儿童  I：婴儿
	 * @ String getPsgType(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:27:17 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getPsgType() {
//		if("A".equals(psgType)){
//			return "成人";
//		}
//		if("C".equals(psgType)){
//			return "儿童";
//		}
//		if("I".equals(psgType)){
//			return "婴儿";
//		}	
		return this.psgType;
	}
	
	/**
	 * 乘客类型 A：成人  C：儿童  I：婴儿
	 * @ void setPsgType(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:27:25 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPsgType(String psgType) {
		this.psgType = psgType;
	}
	
	/**
	 * 关联会员编号
	 * @ Integer getRefMembId(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:28:06 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getRefMembId() {
		return this.refMembId;
	}
	
	/**
	 * 关联会员编号
	 * @ void setRefMembId(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:28:09 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRefMembId(Integer refMembId) {
		this.refMembId = refMembId;
	}
	
	/**
	 * 关联用户编号
	 * @ Integer getRefUserId(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:28:14 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getRefUserId() {
		return this.refUserId;
	}
	
	/**
	 * 关联用户编号
	 * @ void setRefUserId(Passenger)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:28:22 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRefUserId(Integer refUserId) {
		this.refUserId = refUserId;
	}
}