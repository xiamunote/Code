package com.tarena.tts.abs.entity;

import java.util.Date;

/**
 * 营业记录类
 * @author liangjq
 */

public class BusinessRecord implements java.io.Serializable {

	// Fields

	private long busRecId;
	private String busRecType;
	private Date busRecDate;
	private double busRecMoney;
	private Integer refUser;
	private long refTicketId;
	private Integer recState;
	private String terminalType;
	private String terminalIp;
		
	@Override
	public String toString() {
		return "busRecId: "+busRecId+"\n"
			+"busRecType: "+busRecType+"\n"
			+"busRecDate: "+busRecDate+"\n"
			+"busRecMoney: "+busRecMoney+"\n"
			+"refUser: "+refUser+"\n"
			+"refTicketId: "+refTicketId+"\n"
			+"recState: "+recState+"\n"
			+"terminalType: "+terminalType+"\n"
			+"terminalIp: "+terminalIp+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (busRecId ^ (busRecId >>> 32));
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
		final BusinessRecord other = (BusinessRecord) obj;
		if (busRecId != other.busRecId)
			return false;
		return true;
	}

	/**
	 * 营业记录编号(毫秒)
	 * @ long getBusRecId(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:46:09 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public long getBusRecId() {
		return this.busRecId;
	}
	
	/**
	 * 营业记录编号(毫秒)
	 * @ void setBusRecId(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:46:23 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setBusRecId(long busRecId) {
		this.busRecId = busRecId;
	}
	
	/**
	 * 营业记录类型 :'购票','退票','改签',......
	 * @ String getBusRecType(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:46:39 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getBusRecType() {
		return this.busRecType;
	}
	
	/**
	 * 营业记录类型 :'购票','退票','改签',......
	 * @ void setBusRecType(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:47:02 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setBusRecType(String busRecType) {
		this.busRecType = busRecType;
	}
	
	/**
	 * 营业发生时间
	 * @ Date getBusRecDate(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:47:06 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Date getBusRecDate() {
		return this.busRecDate;
	}
	
	/**
	 * 营业发生时间
	 * @ void setBusRecDate(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:47:15 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setBusRecDate(Date busRecDate) {
		this.busRecDate = busRecDate;
	}
	
	/**
	 * 营业金额:正数为收入，负数为支出
	 * @ double getBusRecMoney(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:49:11 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public double getBusRecMoney() {
		return this.busRecMoney;
	}
	
	/**
	 * 营业金额:正数为收入，负数为支出
	 * @ void setBusRecMoney(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:49:19 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setBusRecMoney(double busRecMoney) {
		this.busRecMoney = busRecMoney;
	}
	
	/**
	 * 关联用户
	 * @ Integer getRefUser(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:49:24 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getRefUser() {
		return this.refUser;
	}
	
	/**
	 * 关联用户
	 * @ void setRefUser(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:49:32 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRefUser(Integer refUser) {
		this.refUser = refUser;
	}
	
	/**
	 * 关联机票编号
	 * @ long getRefTicketId(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:49:37 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public long getRefTicketId() {
		return this.refTicketId;
	}
	
	/**
	 * 关联机票编号
	 * @ void setRefTicketId(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:49:49 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRefTicketId(long refTicketId) {
		this.refTicketId = refTicketId;
	}
	
	/**
	 * 记录结算状态: 0:未结算; 1:一级已结算; 2:二级已结算; 3:三级已结算
	 * @ Integer getRecState(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:49:54 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getRecState() {
		return this.recState;
	}
	
	/**
	 * 记录结算状态: 0:未结算; 1:一级已结算; 2:二级已结算; 3:三级已结算
	 * @ void setRecState(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:57:06 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRecState(Integer recState) {
		this.recState = recState;
	}
	
	/**
	 * 终端类型
	 * @ String getTerminalType(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:57:12 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getTerminalType() {
		return this.terminalType;
	}
	
	/**
	 * 终端类型
	 * @ void setTerminalType(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:57:20 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}
	
	/**
	 * 终端IP
	 * @ String getTerminalIp(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:57:23 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getTerminalIp() {
		return this.terminalIp;
	}
	
	/**
	 * 终端IP
	 * @ void setTerminalIp(BusinessRecord)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20125:57:30 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setTerminalIp(String terminalIp) {
		this.terminalIp = terminalIp;
	}
}